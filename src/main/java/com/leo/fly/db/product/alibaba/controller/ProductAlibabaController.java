package com.leo.fly.db.product.alibaba.controller;

import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.ocean.rawsdk.common.SDKResult;
import com.alibaba.product.param.AlibabaProductProductInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.ailibaba.category.CategoryAttributeGetParam;
import com.leo.fly.ailibaba.common.AccessToken;
import com.leo.fly.ailibaba.common.SingletonAccessToken;
import com.leo.fly.ailibaba.photo.PhotoBankAlbumResult;
import com.leo.fly.ailibaba.product.ProductGetParam;
import com.leo.fly.ailibaba.product.ProductGetResult;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.product.alibaba.entity.ProductAlibaba;
import com.leo.fly.db.product.alibaba.params.*;
import com.leo.fly.db.product.alibaba.service.ProductAlibabaService;
import com.leo.fly.db.product.param.ProductQueryForm;
import com.leo.fly.db.product.param.ProductRePostForm;
import com.leo.fly.db.product.service.ProductAttributesService;
import com.leo.fly.db.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product/alibaba")
public class ProductAlibabaController {
	@Autowired
	ProductAlibabaService productAlibabaService;
	@Autowired
	ProductService productService;
	@Autowired
	ProductAttributesService productAttributesService;


	@PutMapping()
	public JsonResult update( @Valid @RequestBody ProductAlibabaUpdateForm updateForm) {
		ProductAlibaba productAlibaba = updateForm.toPo(ProductAlibaba.class);
		return JsonResult.success(productAlibabaService.updateById(productAlibaba));
	}
	@GetMapping(value = "/{id}")
	public JsonResult get(@PathVariable String id) {
		return JsonResult.success(productAlibabaService.getById(id));
	}
	@PostMapping(value = "/page")
	public JsonResult page(@Valid @RequestBody ProductAlibabaQueryForm productAlibabaQueryForm) {
		Page<ProductAlibaba> page = productAlibabaService.page(productAlibabaQueryForm.getPage(), productAlibabaQueryForm.toParam(ProductAlibabaQueryParam.class));
		return JsonResult.success(page);
	}
	@DeleteMapping(value = "/remove/{id}")
	public JsonResult remove(@PathVariable Long id) {
		return JsonResult.success(productAlibabaService.remove(id,1));
	}

	@DeleteMapping(value = "/delete/{id}")
	public JsonResult delete(@PathVariable Long id) {
		return JsonResult.success();
	}

	@PostMapping(value="/save")
	public JsonResult save(@Valid @RequestBody ProductAlibabaAddForm addForm) {
		productAlibabaService.localSave(addForm);
		return JsonResult.success();
	}

	@PostMapping(value="/add")
	public JsonResult sendToAlibaba(@Valid @RequestBody ProductAlibaba productAlibaba) {
		productAlibabaService.add(productAlibaba);
		return JsonResult.success();
	}

	@PostMapping(value = "/list")
	public JsonResult list1688(@Valid @RequestBody ProductQueryForm queryForm) {
		Object o = productAlibabaService.list(queryForm);
		return  JsonResult.success(o);
	}


	@PostMapping(value = "/rePost")
	public JsonResult rePost(@RequestBody ProductRePostForm form) {
		productAlibabaService.rePost(form);
		return  JsonResult.success();
	}

	@PostMapping(value = "/sync")
	public JsonResult sync(@RequestBody ProductGetParam param) {
		ProductGetResult productGetResult = productAlibabaService.get(param.getProductID());
		if (productGetResult == null) {
			return  JsonResult.success();
		}else{
			AlibabaProductProductInfo productInfo = productGetResult.getProductInfo();
			ProductAlibaba productAlibaba = new ProductAlibaba();
		}
		return  JsonResult.success();
	}

	@PostMapping(value = "/schema")
	public JsonResult getSchema(@RequestBody ProductAlibabaNewParam params){
		if(SingletonAccessToken.getAccessToken()==null){
			throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
		}
		SDKResult execute;
		if (SingletonAccessToken.getAccessToken().getToken() != null) {
			AccessToken accessToken = SingletonAccessToken.getAccessToken();
			ApiExecutor apiExecutor = accessToken.getApiExecutor();
			execute = apiExecutor.execute(params, accessToken.getToken().getAccess_token());
			if (StringUtils.isNotBlank(execute.getErrorMessage())) {
				throw new ComException(ErrorCodeEnum.E_OTHERS, execute.getErrorMessage());
			}
		}else{
			throw new ComException(ErrorCodeEnum.E_AUTHORIZED_1688);
		}
		return  JsonResult.success(execute);
	}
}

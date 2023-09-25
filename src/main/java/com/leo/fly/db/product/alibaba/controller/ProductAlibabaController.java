package com.leo.fly.db.product.alibaba.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.ailibaba.product.ProductListGetParam;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.product.alibaba.entity.ProductAlibaba;
import com.leo.fly.db.product.alibaba.params.ProductAlibabaAddForm;
import com.leo.fly.db.product.alibaba.params.ProductAlibabaQueryForm;
import com.leo.fly.db.product.alibaba.params.ProductAlibabaQueryParam;
import com.leo.fly.db.product.alibaba.params.ProductAlibabaUpdateForm;
import com.leo.fly.db.product.alibaba.service.ProductAlibabaService;
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
	@GetMapping(value = "/{id}")
	public JsonResult get(@PathVariable String id) {
		return JsonResult.success(productAlibabaService.getById(id));
	}

	@PostMapping(value = "/list")
	public JsonResult list1688(@Valid @RequestBody ProductListGetParam param) {
		Object o = productAlibabaService.list(param);
		return  JsonResult.success(o);
	}

	@PostMapping(value = "/rePost")
	public JsonResult rePost(@RequestBody ProductRePostForm form) {
		productAlibabaService.rePost(form);
		return  JsonResult.success();
	}
}

package com.leo.fly.db.product.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.util.BeanUtils;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.db.image.entity.Image;
import com.leo.fly.db.image.service.ImageService;
import com.leo.fly.db.product.components.*;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.entity.ProductAttributes;
import com.leo.fly.db.product.entity.ProductJson;
import com.leo.fly.db.product.param.*;
import com.leo.fly.db.product.service.ProductAttributesService;
import com.leo.fly.db.product.service.ProductJsonService;
import com.leo.fly.db.product.service.ProductService;
import com.leo.fly.db.warehouse.service.WarehouseService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
@RestController
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    ProductAttributesService productAttributesService;
    @Autowired
    ProductJsonService productJsonService;
    @Autowired
    ProductMoreComponent productMoreComponent;
    @Autowired
    ProductMergeComponent productMergeComponent;
    @Autowired
    ProductAllUpdateComponent productGroupComponent;
    @Autowired
    ProductResetComponent productResetComponent;
    @Autowired
    ImageService imageService;

    @PostMapping
    @Transactional
    public JsonResult add(@Valid @RequestBody ProductAddForm productAddForm) {
        Product product = new Product();
        BeanUtils.copyProperties(productAddForm, product);
        productService.save(product);
        return JsonResult.success(product.getId());
    }
    @PostMapping("/more")
    @Transactional
    public JsonResult addMore(@Valid @RequestBody ProductAddForm productAddForm) {
        ProductJson productJson = productAddForm.getProductJson();
        productJson.setProductId(productAddForm.getId());
        productJsonService.save(productJson);
        List<ProductAttributes> list = productAddForm.getList();
        list.forEach(attributes-> attributes.setProductId(productAddForm.getId()));
        productAttributesService.saveBatch(list);
        return JsonResult.success();
    }
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable int id) {
        productService.removeById(id);
        return JsonResult.success();
    }

    @GetMapping("/{id}")
    public JsonResult getById(@PathVariable Long id) {
        return JsonResult.success(productService.getById(id));
    }

    @GetMapping("/more/{id}")
    public JsonResult getMoreById(@PathVariable Long id) {
        return JsonResult.success(productMoreComponent.getById(id));
    }

    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = JsonResult.class))
    @PutMapping()
    public JsonResult update(@Valid @RequestBody Product form) {
        return JsonResult.success(productService.updateById(form));
    }

    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = JsonResult.class))
    @PutMapping("/all")
    public JsonResult updateAll(@Valid @RequestBody Product product) {
        productGroupComponent.execute(product);
        return JsonResult.success();
    }

    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = JsonResult.class))
    @PutMapping("/status")
    public JsonResult update(@RequestParam("id") long id, @RequestParam("status") Integer status) {
        Product product = new Product();
        product.setStatus(status);
        product.setId(id);
        return JsonResult.success(productService.updateById(product));
    }

    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = JsonResult.class))
    @PostMapping(value = "/page")
    public JsonResult page(@Valid @RequestBody ProductQueryForm queryForm) {
        log.debug("search with userQueryForm:{}", queryForm);
        Page<Product> page = productService.query(queryForm.getPage(), queryForm.toParam(ProductQueryParam.class));
        return JsonResult.success(page);
    }

    @ApiResponses(@ApiResponse(code = 200, message = "处理成功", response = JsonResult.class))
    @PostMapping(value = "/list")
    public JsonResult list(@Valid @RequestBody ProductQueryForm queryForm) {
        log.debug("search with userQueryForm:{}", queryForm);
        List<Product> list = productService.list(queryForm.toParam(ProductQueryParam.class));
        return JsonResult.success(list);
    }


    @PutMapping(value = "/merge")
    public JsonResult merge(@RequestBody ProductMergeForm mergeForm) {
        productMergeComponent.execute(mergeForm);
        return JsonResult.success();
    }

    @GetMapping(value = "/merge/pre")
    public JsonResult mergePrepare() {
        List pre = productMergeComponent.pre();
        return JsonResult.success(pre);
    }


    @DeleteMapping(value = "/reset")
    public JsonResult reset(@RequestBody ProductResetForm resetForm) {
        productResetComponent.execute(resetForm);
        return JsonResult.success();
    }

    @PutMapping(value = "/attributes")
    public JsonResult attributes(@RequestBody ProductEditForm form) {
        productAttributesService.update(form.getId(), form.getCode(), "oe");
        productAttributesService.update(form.getId(), form.getRefNo(), "refNo");
        Product product = new Product();
        product.setId(form.getId());
        product.setCode(form.getCode());
        product.setRefNo(form.getRefNo());
        productService.updateById(product);
        return JsonResult.success();
    }

    @Autowired
    WarehouseService warehouseService;


    @PutMapping(value = "/valid")
    public JsonResult valid(ProductValidForm validForm) {
        ProductQueryParam params = new ProductQueryParam();
        params.setName(validForm.getName());
        params.setStatus(validForm.getStatus());
        params.setId(validForm.getId());
        params.setReferStatus(validForm.getReferStatus());
        List<Product> products = productService.list(params);
        for (Product product : products
        ) {
            List<Image> images = imageService.getByCode(product.getId() + "");
            List<Number> peImages = images.stream()
//                    .filter(image -> image.getModuleType().equals("PE"))
                    .map(image -> image.getId()).collect(Collectors.toList());
            product.setImages(peImages);
            if(ObjectUtils.isEmpty(peImages)){
                product.setError("批量图片校验不通过");
                product.setStatus(445);
            }else{
                product.setError("");
                product.setStatus(600);
            }
            productService.updateById(product);
        }
        return JsonResult.success();
    }
}


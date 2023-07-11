package com.leo.fly.db.product.controller;


import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.product.entity.ProductJson;
import com.leo.fly.db.product.service.ProductJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-03
 */
@RestController
@RequestMapping("/product/json")
public class ProductJsonController {

    @Autowired
    ProductJsonService jsonService;

    @GetMapping("/{productId}")
    public JsonResult get(@PathVariable Long productId){
        return JsonResult.success(jsonService.findByProductId(productId));
    }

    @PostMapping()
    public JsonResult save(@RequestBody ProductJson productJson){
        jsonService.save(productJson);
        return JsonResult.success();
    }

}


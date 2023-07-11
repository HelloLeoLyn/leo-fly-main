package com.leo.fly.db.product.controller;


import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.db.product.entity.ProductAttributes;
import com.leo.fly.db.product.service.ProductAttributesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-05
 */
@RestController
@RequestMapping("/product/attributes")
public class ProductAttributesController {
    @Autowired
    ProductAttributesService attributesService;

    @GetMapping("/value/{value}")
    public JsonResult getByValue(@PathVariable String value) {
        List<ProductAttributes> list = attributesService.findByValue(value);
        return JsonResult.success(list);
    }
}


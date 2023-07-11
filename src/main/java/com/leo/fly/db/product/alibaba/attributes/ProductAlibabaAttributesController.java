package com.leo.fly.db.product.alibaba.attributes;

import com.leo.fly.common.entity.vo.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product/alibaba/attributes")
public class ProductAlibabaAttributesController {
    @Autowired
    ProductAlibabaAttributesService alibabaAttributesService;
    @PostMapping
    public JsonResult batch(@Valid @RequestBody List<ProductAlibabaAttributes> productAlibabaAttributesList) {
        alibabaAttributesService.saveBatch(productAlibabaAttributesList);
        return JsonResult.success();
    }
//
//    @DeleteMapping()
//    public JsonResult delete(@PathVariable int id) {
//        alibabaAttributesService.removeById(id);
//        return JsonResult.success();
//    }
//    @DeleteMapping("/batch")
//    public JsonResult delete(@RequestBody List<Long> idList) {
//        alibabaAttributesService.removeByIds(idList);
//        return JsonResult.success();
//    }

    @DeleteMapping("/parentId/{parentId}")
    public JsonResult deleteByParentId(@PathVariable long parentId) {
        alibabaAttributesService.deleteByParentId(parentId,true);
        return JsonResult.success();
    }

    @DeleteMapping("/productId/{productId}")
    public JsonResult deleteByProductId(@PathVariable long productId) {
        alibabaAttributesService.deleteByProductId(productId,true);
        return JsonResult.success();
    }

    @GetMapping("/productId/{productId}")
    public JsonResult getByProductId(@PathVariable Long productId) {
        List<ProductAlibabaAttributes> list = alibabaAttributesService.getByProductId(productId, true);
        return JsonResult.success(list);
    }

    @GetMapping("/parentId/{parentId}")
    public JsonResult getByParentId(@PathVariable Long parentId) {
        List<ProductAlibabaAttributes> list = alibabaAttributesService.getByParentId(parentId, true);
        return JsonResult.success(list);
    }


}

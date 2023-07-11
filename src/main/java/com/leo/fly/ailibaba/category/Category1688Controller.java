package com.leo.fly.ailibaba.category;

import com.alibaba.ocean.rawsdk.common.SDKResult;
import com.leo.fly.ailibaba.common.AccessToken;
import com.leo.fly.ailibaba.common.SingletonAccessToken;
import com.leo.fly.common.entity.vo.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping("/category/1688")
public class Category1688Controller {


    @Autowired
    Category1688Service categoryService;



    @GetMapping(value = "/{id}")
    public JsonResult get1688(@PathVariable Long id) {
        return JsonResult.success(categoryService.get1688(id));
    }



    @GetMapping(value = "/search")
    public JsonResult search(@RequestParam String keyWord) {
        return JsonResult.success(categoryService.search(keyWord));
    }

    @PostMapping(value = "/attribute")
    public JsonResult attribute(@RequestBody CategoryAttributeGetParam params) {
        return JsonResult.success(categoryService.getAttributes1688(params));
    }

}

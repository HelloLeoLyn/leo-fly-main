package com.leo.fly.sys.controller;

import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.sys.components.FindUserByMenuIdComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/user/menuId")
public class FindUserByMenuIdController {
    @Autowired
    FindUserByMenuIdComponent findUserByMenuIdComponent;
    @GetMapping("/{menuId}")
    public JsonResult doQuery(@PathVariable Long menuId){
       return JsonResult.success(findUserByMenuIdComponent.doQuery(menuId)) ;
    }
}

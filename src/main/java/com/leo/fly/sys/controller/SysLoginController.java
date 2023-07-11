package com.leo.fly.sys.controller;


import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.sys.param.SysLoginParam;
import com.leo.fly.sys.param.SysLoginResult;
import com.leo.fly.sys.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/login")
//@Access
public class SysLoginController {
    @Autowired
    SysLoginService loginService;

    @PostMapping("")
    public JsonResult<SysLoginResult> doLogin(@RequestBody SysLoginParam param, HttpServletRequest request){
        return JsonResult.success(loginService.doLogin(param,request));
    }

}


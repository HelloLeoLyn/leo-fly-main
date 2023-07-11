package com.leo.fly.sys.service;

import com.leo.fly.sys.param.SysLoginParam;
import com.leo.fly.sys.param.SysLoginResult;

import javax.servlet.http.HttpServletRequest;

public interface SysLoginService {
    SysLoginResult doLogin(SysLoginParam param);

    SysLoginResult doLogin(SysLoginParam param, HttpServletRequest request);
}

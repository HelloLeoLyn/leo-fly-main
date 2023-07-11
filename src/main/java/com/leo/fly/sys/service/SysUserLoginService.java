package com.leo.fly.sys.service;

import com.leo.fly.sys.param.SysUserLoginForm;
import com.leo.fly.sys.param.SysUserLoginResult;

public interface SysUserLoginService {
    SysUserLoginResult doLogin(SysUserLoginForm sysUserLoginForm);
}

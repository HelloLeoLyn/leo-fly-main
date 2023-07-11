package com.leo.fly.sys.service.impl;

import com.leo.fly.sys.param.SysUserLoginForm;
import com.leo.fly.sys.param.SysUserLoginResult;
import com.leo.fly.sys.service.SysMenuService;
import com.leo.fly.sys.service.SysUserLoginService;
import com.leo.fly.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class SysUserLoginServiceImpl implements SysUserLoginService {
    @Autowired
    StringRedisTemplate redisTemplate;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysMenuService sysMenuService;

    @Override
    public SysUserLoginResult doLogin(SysUserLoginForm sysUserLoginForm) {

        return null;
    }
}

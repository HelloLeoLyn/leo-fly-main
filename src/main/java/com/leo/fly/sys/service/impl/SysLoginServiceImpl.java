package com.leo.fly.sys.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.enums.Platform;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.common.util.AES256;
import com.leo.fly.common.util.MD5Util;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.sys.entity.SysRole;
import com.leo.fly.sys.entity.SysUser;
import com.leo.fly.sys.entity.SysUserRole;
import com.leo.fly.sys.param.SysLoginParam;
import com.leo.fly.sys.param.SysLoginResult;
import com.leo.fly.sys.param.SysUserVo;
import com.leo.fly.sys.service.SysLoginService;
import com.leo.fly.sys.service.SysRoleService;
import com.leo.fly.sys.service.SysUserRoleService;
import com.leo.fly.sys.service.SysUserService;
import com.leo.fly.web.form.BaseHeaderProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class SysLoginServiceImpl implements SysLoginService {
    @Value(value = "${leo.fly.login.sign}")
    Boolean isSign;
    @Value(value = "${leo.fly.keys.pri}")
    String priKey;
    @Value(value = "${leo.fly.keys.pub}")
    String pubKey;
    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysUserRoleService sysUserRoleService;
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    StringRedisTemplate redisTemplate;

    @Override
    public SysLoginResult doLogin(SysLoginParam param) {
        Platform platform = Platform.valueOf(param.getPlatform());
        if (isSign) {
            //解签
            String source = param.getTime() + param.getSystem() + param.getToken() + platform.getKey32();
            String sourceSign = MD5Util.string2MD5(source);
            if (StringUtils.notEquals(sourceSign, param.getTargetSign())) {
                throw new ComException(ErrorCodeEnum.E_SIGN);

            }
        }
        SysLoginResult result = new SysLoginResult();
        SysUser user = sysUserService.findByUsername(param.getUsername());
        if (user == null) {
            throw new ComException(ErrorCodeEnum.E_USER_NOT_FOUND);
        }

        checkUserAndPassword(user,param.getPassword());

        List<SysUserRole> userRoles = sysUserRoleService.getByUserID(user.getId());
        List<SysRole> sysRoles = sysRoleService.listByIds(userRoles.stream().map(a -> a.getRoleId()).collect(Collectors.toList()));
        result.setRoles(sysRoles);
        result.setToken(AES256.encryption(user.getName() + "," + System.currentTimeMillis(), platform.getKey16()));
        long expire = System.currentTimeMillis() + (platform.getSession() * 60 * 1000);
        SysUserVo object = new SysUserVo();
        object.setId(user.getId());
        object.setExpire(expire);
        object.setName(user.getName());
        object.setRoles(sysRoles);
        redisTemplate.opsForValue().set(result.getToken(),  JSONObject.toJSONString(object), platform.getSession(), TimeUnit.MINUTES);
        result.setId(user.getId());
        result.setName(user.getName());
        return result;
    }
    private void checkUserAndPassword(SysUser user, String password){
        if(!user.getPassword().equals(MD5Util.string2MD5(password+priKey))){
            throw new ComException(ErrorCodeEnum.E_USER_NOT_FOUND);
        }
    }
    @Override
    public SysLoginResult doLogin(SysLoginParam param, HttpServletRequest request) {
        String time = StringUtils.defaultIfBlank(request.getHeader(BaseHeaderProperties.X_SEQUENCE), "");
        String token = StringUtils.defaultIfBlank(request.getHeader(BaseHeaderProperties.X_TOKEN), "");
        String targetSign = StringUtils.defaultIfBlank(request.getHeader(BaseHeaderProperties.X_SLF), "");
        String system = request.getHeader(BaseHeaderProperties.X_SYSTEM);
        param.setSystem(system);
        param.setTargetSign(targetSign);
        param.setToken(token);
        param.setTime(time);
        return doLogin(param);
    }
}
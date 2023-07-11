package com.leo.fly.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import com.leo.fly.sys.entity.SysRole;
import com.leo.fly.sys.entity.SysUser;
import com.leo.fly.sys.entity.SysUserRole;
import com.leo.fly.sys.mapper.SysUserRoleMapper;
import com.leo.fly.sys.param.InfoResult;
import com.leo.fly.sys.param.SysLoginResult;
import com.leo.fly.sys.param.SysUserVo;
import com.leo.fly.sys.service.SysRoleMenuService;
import com.leo.fly.sys.service.SysRoleService;
import com.leo.fly.sys.service.SysUserRoleService;
import com.leo.fly.sys.service.SysUserService;
import com.leo.fly.web.util.UserContextHolder;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/sys/info")
//@Access
public class SysInfoController {
    @Autowired
    SysUserService sysUserService;
    @Autowired
    SysRoleService sysRoleService;
    @Autowired
    StringRedisTemplate redisTemplate;
    @GetMapping
    public JsonResult<SysLoginResult> info(@Param("token") String token){
        String string = redisTemplate.opsForValue().get(token);
        SysUserVo object = JSONObject.parseObject(string,SysUserVo.class);
        SysUser user = sysUserService.getById(object.getId());
        if(user==null){
            throw new ComException(ErrorCodeEnum.E_AUTHORIZED);
        }
        return JsonResult.success(object);
    }

}
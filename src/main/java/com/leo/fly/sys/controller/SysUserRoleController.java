package com.leo.fly.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.sys.entity.SysUserRole;
import com.leo.fly.sys.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户角色 前端控制器
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/sys/user/role")
//@Access
public class SysUserRoleController {
    @Autowired
    SysUserRoleService sysUserRoleService;
    @GetMapping("/roleId/{roleId}")
    public JsonResult getByRoleId(@PathVariable Long roleId){
        QueryWrapper<SysUserRole> query = new QueryWrapper<>();
        query.lambda().eq(SysUserRole::getRoleId,roleId);
        return JsonResult.success(sysUserRoleService.list(query));
    }

    @GetMapping("/userId/{userId}")
    public JsonResult getByUserId(@PathVariable Long userId){
        QueryWrapper<SysUserRole> query = new QueryWrapper<>();
        query.lambda().eq(SysUserRole::getUserId,userId);
        return JsonResult.success(sysUserRoleService.list(query));
    }

    @PostMapping("/batch/{userId}")
    public JsonResult batch(@RequestBody List<SysUserRole> sysUserRoles, @PathVariable Long userId){
        sysUserRoleService.deleteByUserID(userId);
        if(sysUserRoles.size()==0){
            return  JsonResult.success();
        }
        return JsonResult.success(sysUserRoleService.saveBatch(sysUserRoles));
    }

    @PostMapping()
    public JsonResult save(@RequestBody SysUserRole sysUserRole){
        return JsonResult.success(sysUserRoleService.save(sysUserRole));
    }
}


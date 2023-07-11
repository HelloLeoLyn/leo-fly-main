package com.leo.fly.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.sys.entity.SysRoleDept;
import com.leo.fly.sys.service.SysRoleDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 角色机构 前端控制器
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/sys/role/dept")
//@Access
public class SysRoleDeptController {
    @Autowired
    SysRoleDeptService sysRoleDeptService;
    @GetMapping("/roleId/{roleId}")
    public JsonResult getByRoleId(@PathVariable Long roleId){
        QueryWrapper<SysRoleDept> query = new QueryWrapper<>();
        query.lambda().eq(SysRoleDept::getRoleId,roleId);
        return JsonResult.success(sysRoleDeptService.list(query));
    }

    @GetMapping("/deptId/{deptId}")
    public JsonResult getByDeptId(@PathVariable Long deptId){
        QueryWrapper<SysRoleDept> query = new QueryWrapper<>();
        query.lambda().eq(SysRoleDept::getDeptId,deptId);
        return JsonResult.success(sysRoleDeptService.list(query));
    }

    @PostMapping("/batch")
    public JsonResult batch(@RequestBody List<SysRoleDept> sysRoleDept){
        return JsonResult.success(sysRoleDeptService.saveBatch(sysRoleDept));
    }

    @PostMapping()
    public JsonResult save(@RequestBody SysRoleDept sysRoleDept){
        return JsonResult.success(sysRoleDeptService.save(sysRoleDept));
    }
}


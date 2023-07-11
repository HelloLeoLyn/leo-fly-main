package com.leo.fly.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.sys.entity.SysRole;
import com.leo.fly.sys.param.SysRoleAddForm;
import com.leo.fly.sys.param.SysRoleQueryForm;
import com.leo.fly.sys.param.SysRoleUpdateForm;
import com.leo.fly.sys.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色管理 前端控制器
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/sys/role")
//@Access
public class SysRoleController {
    @Autowired
    SysRoleService sysRoleService;

    @PostMapping("/page")
    public JsonResult page(@RequestBody SysRoleQueryForm queryForm){
        Page page = queryForm.getPage();
        QueryWrapper<SysRole> query = new QueryWrapper<>();
        query.lambda().eq(queryForm.getDelFlag()!=null,SysRole::getDelFlag,queryForm.getDelFlag());
        return JsonResult.success(sysRoleService.page(page,query));
    }
    @PostMapping("/list")
    public JsonResult list(@RequestBody SysRoleQueryForm queryForm){
        QueryWrapper<SysRole> query = new QueryWrapper<>();
        query.lambda().eq(queryForm.getDelFlag()!=null,SysRole::getDelFlag,queryForm.getDelFlag());
        return JsonResult.success(sysRoleService.list(query));
    }
    @PostMapping()
    public JsonResult add(@RequestBody SysRoleAddForm addForm){
        return JsonResult.success(sysRoleService.save(addForm.toPo(SysRole.class)));
    }

    @PutMapping()
    public JsonResult put(@RequestBody SysRoleUpdateForm updateForm){
        return JsonResult.success(sysRoleService.updateById(updateForm.toPo(SysRole.class)));
    }

    @DeleteMapping("/{id}")
    public JsonResult deleteLogical(@PathVariable Long id){
        return JsonResult.success(sysRoleService.deleteLogical(id));
    }
}


package com.leo.fly.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.sys.entity.SysMenu;
import com.leo.fly.sys.entity.SysRoleMenu;
import com.leo.fly.sys.service.SysMenuService;
import com.leo.fly.sys.service.SysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色菜单 前端控制器
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/sys/role/menu")
//@Access
public class SysRoleMenuController {

    @Autowired
    SysRoleMenuService sysRoleMenuService;
    @Autowired
    SysMenuService sysMenuService;
    @GetMapping("/roleId/{roleId}")
    public JsonResult getByRoleId(@PathVariable Long[] roleId){
        QueryWrapper<SysRoleMenu> query = new QueryWrapper<>();
        query.lambda().in(SysRoleMenu::getRoleId,roleId);
        List<SysRoleMenu> list = sysRoleMenuService.list(query);
        List<Long> menuIdList = list.stream().map(e -> e.getMenuId()).collect(Collectors.toList());
        List<SysMenu> sysMenus = sysMenuService.listByIds(menuIdList);
        return JsonResult.success(sysMenus);
    }
    @GetMapping("/menuId/{menuId}")
    public JsonResult getByDeptId(@PathVariable Long menuId){
        QueryWrapper<SysRoleMenu> query = new QueryWrapper<>();
        query.lambda().eq(SysRoleMenu::getMenuId,menuId);
        return JsonResult.success(sysRoleMenuService.list(query));
    }


    @PutMapping("/{roleId}")
    public JsonResult batch(@RequestBody List<SysRoleMenu> sysRoleMenus,@PathVariable Long roleId){
        //数据库老数据
        List<SysRoleMenu> old = sysRoleMenuService.getByRoleId(roleId);

        //提交的新数据
        Set<Long> existsMenuId = sysRoleMenus.stream().map(m -> m.getMenuId()).collect(Collectors.toSet());

        //删除不存在的菜单权限
        List<Long> removeIdList = old.stream().filter(oid -> !existsMenuId.contains(oid.getMenuId())).map(m -> m.getId()).collect(Collectors.toList());
        sysRoleMenuService.removeByIds(removeIdList);

        //新增的菜单权限
        List<Long> oldMenuIdList = old.stream().map(o -> o.getMenuId()).collect(Collectors.toList());
        List<SysRoleMenu> addMenuList = sysRoleMenus.stream().filter(menu -> !oldMenuIdList.contains(menu.getMenuId())).collect(Collectors.toList());
        return JsonResult.success(sysRoleMenuService.saveBatch(addMenuList));
    }

    @PostMapping()
    public JsonResult save(@RequestBody SysRoleMenu sysRoleMenu){
        return JsonResult.success(sysRoleMenuService.save(sysRoleMenu));
    }
}


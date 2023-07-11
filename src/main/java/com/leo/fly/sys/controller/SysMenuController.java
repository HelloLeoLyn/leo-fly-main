package com.leo.fly.sys.controller;

import com.leo.fly.common.entity.vo.JsonResult;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.sys.entity.SysMenu;
import com.leo.fly.sys.mapper.SysRoleMenuMapper;
import com.leo.fly.sys.param.SysMenuAddForm;
import com.leo.fly.sys.param.SysMenuSaveUpdateForm;
import com.leo.fly.sys.param.SysMenuVo;
import com.leo.fly.sys.service.SysMenuService;
import com.leo.fly.web.util.UserContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {
    @Autowired
    SysMenuService sysMenuService;
    @Autowired
    SysRoleMenuMapper roleMenuMapper;
    @GetMapping("/parentId/{parentId}")
    public JsonResult getByParentId(@PathVariable Long parentId) {
        String platform = UserContextHolder.getInstance().getPlatform();
        List<SysMenu> list = sysMenuService.getByParentId(parentId, 0, platform);
        return JsonResult.success(list);
    }

    @PostMapping()
    public JsonResult save(@RequestBody SysMenuAddForm addForm) {
        SysMenu sysmenu = addForm.toPo(SysMenu.class);
        String platform = UserContextHolder.getInstance().getPlatform();
        sysmenu.setPlatform(platform);
        sysMenuService.save(sysmenu);
        return JsonResult.success(sysmenu);
    }

    @PutMapping()
    public JsonResult update(@RequestBody SysMenuSaveUpdateForm saveUpdateForm) {
        SysMenu sysmenu = saveUpdateForm.toPo(SysMenu.class);
        sysMenuService.updateById(sysmenu);
        return JsonResult.success();
    }

    @DeleteMapping("/{id}")
    public JsonResult deleteLogical(@PathVariable Long id) {
        return JsonResult.success(sysMenuService.deleteGroup(id));
    }

    @PostMapping("/roleIds")
    public JsonResult getByRoleIds(@RequestBody List<Long> roleIds) {
        return JsonResult.success(sysMenuService.getByRoleIds(roleIds, 0, null));
    }

    @PostMapping("/roles")
    public JsonResult getByRoles(@RequestBody List<String> roles) {
        return JsonResult.success(sysMenuService.getByRoles(roles));
    }

    @GetMapping("/userId/{userId}")
    public JsonResult getByUserId(@PathVariable Long userId){
        List<Long> idList = roleMenuMapper.listMenuIdByUserId(userId);
        if(ObjectUtils.isEmpty(idList)){
            return JsonResult.success(null);
        }
        List<SysMenuVo> menuVoList = sysMenuService.listByIds(idList).stream().map(a -> new SysMenuVo(a)).collect(Collectors.toList());
        Map<Long, List<SysMenuVo>> collect = menuVoList.stream().collect(Collectors.groupingBy(a -> a.getParentId()));
        List<SysMenuVo> result = collect.get(0L);
        result.forEach(one-> {
            if(ObjectUtils.isNotEmpty(collect.get(one.getId()))){
                one.setChildren(collect.get(one.getId()));
            }
        });
        return JsonResult.success(result);
    }
}


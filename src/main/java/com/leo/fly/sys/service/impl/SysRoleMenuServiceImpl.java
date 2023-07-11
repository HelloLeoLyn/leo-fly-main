package com.leo.fly.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.sys.entity.SysRoleMenu;
import com.leo.fly.sys.mapper.SysRoleMenuMapper;
import com.leo.fly.sys.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色菜单 服务实现类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {

    @Override
    public boolean removeByRoleId(long roleId) {
        Map<String,Object> map = new HashMap<>();
        map.put("role_id",roleId);
        return this.removeByMap(map);
    }

    @Override
    public List<SysRoleMenu> getByRoleId(Long roleId) {
        LambdaQueryWrapper<SysRoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysRoleMenu::getRoleId,roleId);
        return list(queryWrapper);
    }

    @Override
    public List<Long> getRoleIdByMenuId(Long menuId) {
        LambdaQueryWrapper<SysRoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.select(SysRoleMenu::getRoleId);
        queryWrapper.eq(SysRoleMenu::getMenuId,menuId);
        List<SysRoleMenu> list = list(queryWrapper);
        if(ObjectUtils.isNotEmpty(list)) {
            return list.stream().map(m->m.getRoleId()).collect(Collectors.toList());
        }
        return null;
    }


}

package com.leo.fly.sys.components;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.leo.fly.sys.entity.SysUserRole;
import com.leo.fly.sys.mapper.SysUserRoleMapper;
import com.leo.fly.sys.service.SysRoleMenuService;
import com.leo.fly.sys.service.SysUserRoleService;
import com.leo.fly.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class FindUserByMenuIdComponent {
    @Autowired
    SysRoleMenuService roleMenuService;
    @Autowired
    SysUserRoleMapper userRoleMapper;

    public List doQuery(Long menuId) {
        List<Long> roleIdList = roleMenuService.getRoleIdByMenuId(menuId);
        List<Map> list = userRoleMapper.findUserByRoleId(roleIdList);
        return list;
    }
}

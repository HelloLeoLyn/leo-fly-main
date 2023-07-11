package com.leo.fly.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.sys.entity.SysRoleMenu;

import java.util.List;

/**
 * <p>
 * 角色菜单 服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {
    boolean removeByRoleId(long roleId);

    List<SysRoleMenu> getByRoleId(Long roleId);

    List<Long> getRoleIdByMenuId(Long menuId);
}

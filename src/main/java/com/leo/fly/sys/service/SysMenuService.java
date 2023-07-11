package com.leo.fly.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.sys.entity.SysMenu;
import com.leo.fly.sys.param.SysMenuVo;

import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> getByParentId(Long parentId,Integer delFlag,String platform);

    Set<Long> getIdByParentId(Long parentId, Integer delFlag,String platform);

    List<SysMenu> getByRoleIds(List<Long> roleIds,Integer delFlag, List<String> roles);

    boolean deleteGroup(Long group);

    List<SysMenu> getByRoles(List<String> roles);

}

package com.leo.fly.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.sys.entity.SysUserRole;

import java.util.List;

/**
 * <p>
 * 用户角色 服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
public interface SysUserRoleService extends IService<SysUserRole> {

    List<SysUserRole> getByUserID(Long userId);

    List<SysUserRole> getByRoleID(Long roleId);

    boolean deleteByUserID(Long userId);

}

package com.leo.fly.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.sys.entity.SysRole;

import java.util.List;

/**
 * <p>
 * 角色管理 服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
public interface SysRoleService extends IService<SysRole> {

    boolean deleteLogical(Long id);

    List<SysRole> listByUserId(Long userId);
}

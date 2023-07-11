package com.leo.fly.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.sys.entity.SysRoleDept;

import java.util.List;

/**
 * <p>
 * 角色机构 服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
public interface SysRoleDeptService extends IService<SysRoleDept> {

    List<SysRoleDept> getByDeptId(Long deptId);

    List<SysRoleDept> getByRoleId(Long roleId);

    List<SysRoleDept> getByRoleIdAndDeptId(List<Long> roleIdList, List<Long> deptId);
}

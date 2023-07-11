package com.leo.fly.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.sys.entity.SysRoleDept;
import com.leo.fly.sys.mapper.SysRoleDeptMapper;
import com.leo.fly.sys.service.SysRoleDeptService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色机构 服务实现类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@Service
public class SysRoleDeptServiceImpl extends ServiceImpl<SysRoleDeptMapper, SysRoleDept> implements SysRoleDeptService {

    @Override
    public List<SysRoleDept> getByDeptId(Long deptId) {
        QueryWrapper<SysRoleDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysRoleDept::getDeptId,deptId);
        return this.list(queryWrapper);
    }

    @Override
    public List<SysRoleDept> getByRoleId(Long roleId) {
        QueryWrapper<SysRoleDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysRoleDept::getRoleId,roleId);
        return this.list(queryWrapper);
    }

    @Override
    public List<SysRoleDept> getByRoleIdAndDeptId(List<Long> roleIdList, List<Long> deptId) {
        QueryWrapper<SysRoleDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().in(SysRoleDept::getRoleId,roleIdList).in(SysRoleDept::getDeptId,deptId);
        return this.list(queryWrapper);
    }
}

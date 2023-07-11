package com.leo.fly.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.sys.entity.SysUserRole;
import com.leo.fly.sys.mapper.SysUserRoleMapper;
import com.leo.fly.sys.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {

    @Override
    public List<SysUserRole> getByUserID(Long userId) {
        QueryWrapper<SysUserRole> query = new QueryWrapper<>();
        query.lambda().eq(SysUserRole::getUserId,userId);
        return this.list(query);
    }

    @Override
    public List<SysUserRole> getByRoleID(Long roleId) {
        QueryWrapper<SysUserRole> query = new QueryWrapper<>();
        query.lambda().eq(SysUserRole::getRoleId,roleId);
        return this.list(query);
    }

    @Override
    public boolean deleteByUserID(Long userId) {
        List<SysUserRole> byUserID = this.getByUserID(userId);
        if(byUserID!=null&&byUserID.size()>0){
            List<Long> collect = byUserID.stream().map(SysUserRole::getId).collect(Collectors.toList());
          return this.removeByIds(collect);
        }
        return false;
    }
}

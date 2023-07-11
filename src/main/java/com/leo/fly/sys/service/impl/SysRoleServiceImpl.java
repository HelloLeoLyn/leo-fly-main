package com.leo.fly.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.sys.entity.SysRole;
import com.leo.fly.sys.entity.SysUserRole;
import com.leo.fly.sys.mapper.SysRoleMapper;
import com.leo.fly.sys.service.SysRoleService;
import com.leo.fly.sys.service.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色管理 服务实现类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Autowired
    SysUserRoleService userRoleService;
    @Override
    public boolean deleteLogical(Long id) {
        UpdateWrapper<SysRole> wrapper = new UpdateWrapper<>();
        wrapper.lambda().set(SysRole::getDelFlag,-1).eq(SysRole::getId,id);
        return update(wrapper);
    }

    @Override
    public List<SysRole> listByUserId(Long userId) {
        List<SysUserRole> list = userRoleService.getByUserID(userId);
        if(ObjectUtils.isEmpty(list)){
            return null;
        }
        return this.listByIds(list.stream().map(a->a.getRoleId()).collect(Collectors.toList()));
    }
}

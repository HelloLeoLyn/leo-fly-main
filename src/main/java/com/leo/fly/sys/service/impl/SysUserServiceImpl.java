package com.leo.fly.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.BeanUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.sys.entity.SysRole;
import com.leo.fly.sys.entity.SysUser;
import com.leo.fly.sys.entity.SysUserRole;
import com.leo.fly.sys.mapper.SysUserMapper;
import com.leo.fly.sys.param.InfoResult;
import com.leo.fly.sys.param.SysUserQueryParam;
import com.leo.fly.sys.param.SysUserVo;
import com.leo.fly.sys.service.SysRoleService;
import com.leo.fly.sys.service.SysUserRoleService;
import com.leo.fly.sys.service.SysUserService;
import com.leo.fly.web.util.UserContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    SysUserRoleService sysUserRoleService;
    @Autowired
    SysRoleService sysRoleService;

    @Override
    public Page<SysUserVo> query(Page page, SysUserQueryParam param) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(StringUtils.isNotBlank(param.getMobile()), SysUser::getMobile, param.getMobile())
                .like(StringUtils.isNotBlank(param.getName()), SysUser::getName, param.getName());
        IPage<SysUser> src = this.page(page, queryWrapper);
        List<SysUserVo> records = src.getRecords().stream().map(a -> {
                    List<SysUserRole> userRoles = sysUserRoleService.getByUserID(a.getId());
                    List<Long> roleIdList = userRoles.stream().map(userRole -> userRole.getRoleId()).collect(Collectors.toList());
                    SysUserVo vo = new SysUserVo();
                    BeanUtils.copyProperties(a, vo);
                    if (roleIdList.size() == 0) {
                        return vo;
                    }
                    List<SysRole> sysRoles = sysRoleService.listByIds(roleIdList);
                    vo.setRoles(sysRoles);
                    return vo;
                }
        ).collect(Collectors.toList());
        Page<SysUserVo> result = new Page();
        BeanUtils.copyProperties(src, result);
        result.setRecords(records);
        return result;
    }

    @Override
    public SysUser findByUsername(String username) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getName, username);
        return getOne(queryWrapper);
    }

    @Override
    public SysUser getById(String userId, String platform) {
        return getById(userId);
    }

}

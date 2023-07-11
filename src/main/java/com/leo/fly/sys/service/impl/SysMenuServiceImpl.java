package com.leo.fly.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.LeoFileUtils;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.sys.entity.SysMenu;
import com.leo.fly.sys.entity.SysRole;
import com.leo.fly.sys.entity.SysRoleMenu;
import com.leo.fly.sys.mapper.SysMenuMapper;
import com.leo.fly.sys.mapper.SysRoleMapper;
import com.leo.fly.sys.mapper.SysRoleMenuMapper;
import com.leo.fly.sys.param.Meta;
import com.leo.fly.sys.param.SysMenuVo;
import com.leo.fly.sys.service.SysMenuService;
import com.leo.fly.web.util.UserContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    SysRoleMapper sysRoleMapper;

    @Override
    public List<SysMenu> getByParentId(Long parentId, Integer delFlag, String platform) {
        return getByParentId(parentId, delFlag, null, platform, null);
    }

    @Override
    public Set<Long> getIdByParentId(Long parentId, Integer delFlag, String platform) {

        QueryWrapper<SysMenu> query = new QueryWrapper<>();
        query.lambda().select(SysMenu::getId).eq(SysMenu::getParentId, parentId).eq(delFlag != null, SysMenu::getDelFlag, delFlag)
                .eq(SysMenu::getPlatform, platform);
        List<Object> list = this.listObjs(query);
        if (list != null && list.size() > 0) {
            Set set = new HashSet();
            list.stream().forEach(a -> {
                Set<Long> children = getIdByParentId((Long) a, delFlag, platform);
                set.add(a);
                if (ObjectUtils.isNotEmpty(children)) {
                    set.addAll(children);
                }
            });
            return set;
        }
        return null;
    }

    private List<SysMenu> getByParentId(Long parentId, Integer delFlag, Set<Long> accessMenuIds, String platform, List<String> roles) {
        QueryWrapper<SysMenu> query = new QueryWrapper<>();
        query.lambda().eq(SysMenu::getParentId, parentId).eq(delFlag != null, SysMenu::getDelFlag, delFlag);
        List<SysMenu> list = this.list(query);
        List<SysMenu> result = new ArrayList<>();
        for (SysMenu sysMenu : list) {
            if (accessMenuIds != null && !accessMenuIds.contains(sysMenu.getId())) {
                continue;
            }
            result.add(sysMenu);
            sysMenu.setChildren(getByParentId(sysMenu.getId(), delFlag, accessMenuIds, platform, roles));
        }
        return result;
    }

    @Override
    public List<SysMenu> getByRoleIds(List<Long> roleIds, Integer delFlag, List<String> roles) {
        QueryWrapper<SysRoleMenu> queryRoleMenu = new QueryWrapper<>();
        queryRoleMenu.lambda().in(SysRoleMenu::getRoleId, roleIds);
        List<SysRoleMenu> sysRoleMenus = sysRoleMenuMapper.selectList(queryRoleMenu);
        Set<Long> accessMenuIds = sysRoleMenus.stream().map(a -> a.getMenuId()).collect(Collectors.toSet());
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().select(SysMenu::getParentId).in(SysMenu::getId, accessMenuIds);
        Set<Long> parentId = this.listObjs(queryWrapper).stream().map(a -> (Long) a).collect(Collectors.toSet());
        accessMenuIds.addAll(parentId);
        String platform = UserContextHolder.getInstance().getPlatform();
        return getByParentId(0l, delFlag, accessMenuIds,platform, roles);
    }

    @Override
    public boolean deleteGroup(Long groupId) {
        String platform = UserContextHolder.getInstance().getPlatform();
        Set<Long> idList = getIdByParentId(groupId, 0, platform);
        if (idList != null) {
            idList.add(groupId);
            return this.removeByIds(idList);
        }
        return this.removeById(groupId);
    }

    @Override
    public List<SysMenu> getByRoles(List<String> roles) {
        QueryWrapper<SysRole> queryRole = new QueryWrapper<>();
        queryRole.lambda().in(SysRole::getName, roles);
        List<SysRole> sysRoles = sysRoleMapper.selectList(queryRole);
        List<Long> roleIds = sysRoles.stream().map(a -> a.getId()).collect(Collectors.toList());
        return getByRoleIds(roleIds, 0, roles);
    }

}

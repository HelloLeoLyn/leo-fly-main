package com.leo.fly.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.sys.entity.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

/**
 * <p>
 * 角色菜单 Mapper 接口
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@Repository
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    @Select("select id, role_id, menu_id from leo_sys_role_menu where role_id in(select role_id from leo_sys_user_role where user_id=#{userId})")
    List<SysRoleMenu> listByUserId(@Param("userId") Long userId);

    @Select("select menu_id from leo_sys_role_menu where role_id in(select role_id from leo_sys_user_role where user_id=#{userId})")
    List<Long> listMenuIdByUserId(@Param("userId") Long userId);
}

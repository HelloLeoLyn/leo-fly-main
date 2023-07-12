package com.leo.fly.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.sys.entity.SysRoleMenu;
import com.leo.fly.sys.param.SysMenuVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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

    @Select("select distinct m.id,m.parent_id from leo_sys_role_menu rm, leo_sys_menu m where rm.menu_id=m.id and rm.role_id in(select role_id from leo_sys_user_role where user_id=4)")
    List<SysMenuVo> listMenuIdByUserId(@Param("userId") Long userId);
}

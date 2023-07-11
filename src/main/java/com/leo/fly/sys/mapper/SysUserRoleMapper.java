package com.leo.fly.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.sys.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户角色 Mapper 接口
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@Repository
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    @Select("<script>select u.id uid, u.name, ur.role_id from leo_sys_user_role ur " +
            "left join leo_sys_user u on ur.user_id=u.id " +
            "where role_id in<foreach item='item' index='index' collection='list' open='(' separator=',' close=')'>#{item}</foreach> </script>" )
    List<Map> findUserByRoleId(@Param("list") List<Long> list);
}

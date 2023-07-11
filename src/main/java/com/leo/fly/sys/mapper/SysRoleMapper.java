package com.leo.fly.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.sys.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 角色管理 Mapper 接口
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@Repository
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

}

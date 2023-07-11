package com.leo.fly.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.sys.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.List;

/**
 * <p>
 * 菜单管理 Mapper 接口
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@Repository
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {


}

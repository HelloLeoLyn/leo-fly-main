package com.leo.fly.sys.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.sys.entity.SysUser;
import com.leo.fly.sys.param.InfoResult;
import com.leo.fly.sys.param.SysUserQueryParam;
import com.leo.fly.sys.param.SysUserVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
public interface SysUserService extends IService<SysUser> {
    /**查询第三方用户
     * @param page
     * @param toParam
     * @return
     */
    Page<SysUserVo> query(Page page, SysUserQueryParam toParam);

    SysUser findByUsername(String username);

    SysUser getById(String userId, String platform);

}

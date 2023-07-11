package com.leo.fly.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.sys.entity.SysDept;

/**
 * <p>
 * 机构管理 服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
public interface SysDeptService extends IService<SysDept> {

    Boolean deleteLogical(Long id);

}

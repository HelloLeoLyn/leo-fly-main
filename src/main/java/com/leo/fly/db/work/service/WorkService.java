package com.leo.fly.db.work.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.work.entity.Work;
import com.leo.fly.db.work.params.WorkQueryParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
public interface WorkService extends IService<Work> {
    Page<Work> page(Page page, WorkQueryParam toParam);
}

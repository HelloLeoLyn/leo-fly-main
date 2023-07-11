package com.leo.fly.db.collection.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.collection.entity.Collection;
import com.leo.fly.db.collection.params.CollectionQueryParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
public interface CollectionService extends IService<Collection> {
    Page<Collection> page(Page page, CollectionQueryParam toParam);
}

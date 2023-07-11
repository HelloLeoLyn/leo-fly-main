package com.leo.fly.db.tag.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.tag.entity.Tag;
import com.leo.fly.db.tag.params.TagQueryParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
public interface TagService extends IService<Tag> {
    Page<Tag> page(Page page, TagQueryParam toParam);
}

package com.leo.fly.db.goods.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.goods.entity.Goods;
import com.leo.fly.db.goods.params.GoodsQueryParam;
import com.leo.fly.db.goods.params.GoodsTemplateParams;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
public interface GoodsService extends IService<Goods> {
    Page<Goods> page(Page page, GoodsQueryParam toParam);
}

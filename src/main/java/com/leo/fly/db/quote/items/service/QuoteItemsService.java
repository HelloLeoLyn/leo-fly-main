package com.leo.fly.db.quote.items.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.quote.items.entity.QuoteItems;
import com.leo.fly.db.quote.items.params.QuoteItemsQueryParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
public interface QuoteItemsService extends IService<QuoteItems> {
    Page<QuoteItems> page(Page page, QuoteItemsQueryParam toParam);
}

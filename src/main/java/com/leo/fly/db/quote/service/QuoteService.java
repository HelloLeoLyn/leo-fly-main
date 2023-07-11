package com.leo.fly.db.quote.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.quote.entity.Quote;
import com.leo.fly.db.quote.params.QuoteQueryParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
public interface QuoteService extends IService<Quote> {
    Page<Quote> page(Page page, QuoteQueryParam toParam);
}

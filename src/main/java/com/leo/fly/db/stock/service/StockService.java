package com.leo.fly.db.stock.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.stock.entity.Stock;
import com.leo.fly.db.stock.params.StockQueryParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
public interface StockService extends IService<Stock> {
    Page<Stock> page(Page page, StockQueryParam toParam);
}

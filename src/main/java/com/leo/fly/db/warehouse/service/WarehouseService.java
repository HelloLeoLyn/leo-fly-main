package com.leo.fly.db.warehouse.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.warehouse.entity.Warehouse;
import com.leo.fly.db.warehouse.params.WarehouseQueryParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
public interface WarehouseService extends IService<Warehouse> {
    Page<Warehouse> page(Page page, WarehouseQueryParam toParam);
}

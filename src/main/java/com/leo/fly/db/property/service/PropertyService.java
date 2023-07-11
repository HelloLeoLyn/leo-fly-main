package com.leo.fly.db.property.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.property.entity.Property;
import com.leo.fly.db.property.params.PropertyQueryParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
public interface PropertyService extends IService<Property> {
    Page<Property> page(Page page, PropertyQueryParam toParam);
}

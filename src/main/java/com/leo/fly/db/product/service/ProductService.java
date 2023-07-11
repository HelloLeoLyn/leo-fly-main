package com.leo.fly.db.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.product.entity.Product;
import com.leo.fly.db.product.param.ProductQueryParam;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
public interface ProductService extends IService<Product> {
    Page<Product> query(Page page, ProductQueryParam toParam);

    List<Product> list(ProductQueryParam toParam);

    List<Product> getByCode(String code);

    List<Product> findByStatus(int status);
}

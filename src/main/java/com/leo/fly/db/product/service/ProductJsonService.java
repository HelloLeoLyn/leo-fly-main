package com.leo.fly.db.product.service;

import com.leo.fly.db.product.entity.ProductJson;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-03
 */
public interface ProductJsonService extends IService<ProductJson> {
    List<ProductJson> findByProductId(Long productId);
    List<ProductJson> findByProductId(Collection<Long> productIdList);
    void deleteByProductId(Collection<Long> productIdList);
    void deleteByProductId(Long productId);
}

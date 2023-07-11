package com.leo.fly.db.product.service;

import com.leo.fly.db.product.entity.ProductAttributes;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.product.param.ProductAttributesParam;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-05
 */
public interface ProductAttributesService extends IService<ProductAttributes> {

    void deleteByProductId(Long id);

    void deleteByProductId(Long id,String attributeName);

    void deleteByProductId(List<Long> idList);

    List<ProductAttributes> query(ProductAttributesParam param);

    List<ProductAttributes> findByProductIds(Set<Long> idList);

    List<ProductAttributes> findByProductId(Long id);

    List<ProductAttributes> findByValue(String value);

    void update(Long productId,List<String> values, String type);
}

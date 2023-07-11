package com.leo.fly.db.product.alibaba.attributes;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface ProductAlibabaAttributesService extends IService<ProductAlibabaAttributes> {
    boolean deleteByProductId(Long productId);

    boolean deleteByParentId(Long productId);

    boolean deleteByProductId(Long productId, boolean loop);

    boolean deleteByParentId(Long productId, boolean loop);

    List<ProductAlibabaAttributes> getByProductId(Long productId, boolean loop);

    List<ProductAlibabaAttributes> getByParentId(Long parentId, boolean loop);

    List<ProductAlibabaAttributes> getByProductId(Long productId);

    List<ProductAlibabaAttributes> getByParentId(Long parentId);

}

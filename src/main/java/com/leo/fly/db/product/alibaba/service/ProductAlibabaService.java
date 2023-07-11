package com.leo.fly.db.product.alibaba.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.ailibaba.product.ProductGetResult;
import com.leo.fly.ailibaba.product.ProductPageResult;
import com.leo.fly.db.product.alibaba.entity.ProductAlibaba;
import com.leo.fly.db.product.alibaba.params.ProductAlibabaAddForm;
import com.leo.fly.db.product.alibaba.params.ProductAlibabaQueryParam;
import com.leo.fly.db.product.param.ProductQueryForm;
import com.leo.fly.db.product.param.ProductRePostForm;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
public interface ProductAlibabaService extends IService<ProductAlibaba> {
    Page<ProductAlibaba> page(Page page, ProductAlibabaQueryParam toParam);
    boolean remove(Long productID,int optType);

    void add(ProductAlibaba productAlibaba);

    void rePost(ProductRePostForm form);

    ProductPageResult list(ProductQueryForm form);

    ProductGetResult get(Long id);

    void localSave(ProductAlibabaAddForm addForm);
}

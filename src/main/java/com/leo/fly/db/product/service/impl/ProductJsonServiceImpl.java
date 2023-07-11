package com.leo.fly.db.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.leo.fly.db.product.entity.ProductJson;
import com.leo.fly.db.product.mapper.ProductJsonMapper;
import com.leo.fly.db.product.service.ProductJsonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-03
 */
@Service
public class ProductJsonServiceImpl extends ServiceImpl<ProductJsonMapper, ProductJson> implements ProductJsonService {

    @Override
    public List<ProductJson> findByProductId(Long productId) {
        LambdaQueryWrapper<ProductJson> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ProductJson::getProductId,productId);
        return list(queryWrapper);
    }

    @Override
    public void deleteByProductId(Collection<Long> productIdList) {
        QueryWrapper<ProductJson> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(ProductJson::getProductId,productIdList);
        remove(wrapper);
    }@Override
    public void deleteByProductId(Long productId) {
        QueryWrapper<ProductJson> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(ProductJson::getProductId,productId);
        remove(wrapper);
    }

    @Override
    public List<ProductJson> findByProductId(Collection productIdList) {
        LambdaQueryWrapper<ProductJson> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(ProductJson::getProductId,productIdList);
        return list(queryWrapper);
    }
}

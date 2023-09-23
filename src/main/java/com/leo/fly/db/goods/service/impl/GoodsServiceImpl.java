package com.leo.fly.db.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.goods.entity.Goods;
import com.leo.fly.db.goods.mapper.GoodsMapper;
import com.leo.fly.db.goods.params.GoodsQueryParam;
import com.leo.fly.db.goods.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
    @Override
    public Page<Goods> page(Page page, GoodsQueryParam params) {
        LambdaQueryWrapper<Goods> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getId()),Goods::getId,params.getId());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getProductId()),Goods::getProductId,params.getProductId());
		queryWrapper.eq(StringUtils.isNotBlank(params.getPlatform()),Goods::getPlatform,params.getPlatform());
		queryWrapper.eq(StringUtils.isNotBlank(params.getSubject()),Goods::getSubject,params.getSubject());
		queryWrapper.eq(StringUtils.isNotBlank(params.getImages()),Goods::getImages,params.getImages());
		queryWrapper.eq(StringUtils.isNotBlank(params.getMainImage()),Goods::getMainImage,params.getMainImage());
		queryWrapper.eq(StringUtils.isNotBlank(params.getTag()),Goods::getTag,params.getTag());
        return this.page(page, queryWrapper);
    }

}

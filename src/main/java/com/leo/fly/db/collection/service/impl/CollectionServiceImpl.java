package com.leo.fly.db.collection.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.collection.entity.Collection;
import com.leo.fly.db.collection.mapper.CollectionMapper;
import com.leo.fly.db.collection.params.CollectionQueryParam;
import com.leo.fly.db.collection.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {
    @Override
    public Page<Collection> page(Page page, CollectionQueryParam params) {
        LambdaQueryWrapper<Collection> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getId()),Collection::getId,params.getId());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getCategoryId()),Collection::getCategoryId,params.getCategoryId());
		queryWrapper.eq(StringUtils.isNotBlank(params.getName()),Collection::getName,params.getName());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getWeight()),Collection::getWeight,params.getWeight());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getWidth()),Collection::getWidth,params.getWidth());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getHeight()),Collection::getHeight,params.getHeight());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getLength()),Collection::getLength,params.getLength());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getUnitQuantity()),Collection::getUnitQuantity,params.getUnitQuantity());
		queryWrapper.eq(StringUtils.isNotBlank(params.getUnit()),Collection::getUnit,params.getUnit());
		queryWrapper.eq(StringUtils.isNotBlank(params.getColor()),Collection::getColor,params.getColor());
		queryWrapper.eq(StringUtils.isNotBlank(params.getBrandCode()),Collection::getBrandCode,params.getBrandCode());
		queryWrapper.eq(StringUtils.isNotBlank(params.getImages()),Collection::getImages,params.getImages());
		queryWrapper.eq(StringUtils.isNotBlank(params.getKeyword()),Collection::getKeyword,params.getKeyword());
		queryWrapper.eq(StringUtils.isNotBlank(params.getRefers()),Collection::getRefers,params.getRefers());
		queryWrapper.eq(StringUtils.isNotBlank(params.getPurchasePrices()),Collection::getPurchasePrices,params.getPurchasePrices());
		queryWrapper.eq(StringUtils.isNotBlank(params.getSalePrices()),Collection::getSalePrices,params.getSalePrices());
        return this.page(page, queryWrapper);
    }
}

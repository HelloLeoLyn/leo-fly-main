package com.leo.fly.db.warehouse.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.warehouse.entity.Warehouse;
import com.leo.fly.db.warehouse.mapper.WarehouseMapper;
import com.leo.fly.db.warehouse.params.WarehouseQueryParam;
import com.leo.fly.db.warehouse.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseServiceImpl extends ServiceImpl<WarehouseMapper, Warehouse> implements WarehouseService {
    @Override
    public Page<Warehouse> page(Page page, WarehouseQueryParam params) {
        LambdaQueryWrapper<Warehouse> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getId()),Warehouse::getId,params.getId());
		queryWrapper.in(ObjectUtils.isNotEmpty(params.getIdList()),Warehouse::getId,params.getIdList());
		queryWrapper.eq(StringUtils.isNotBlank(params.getType()),Warehouse::getType,params.getType());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getPurchasePrice()),Warehouse::getPurchasePrice,params.getPurchasePrice());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getSellingPrice()),Warehouse::getSellingPrice,params.getSellingPrice());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getAmount()),Warehouse::getAmount,params.getAmount());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getProductId()),Warehouse::getProductId,params.getProductId());
		queryWrapper.in(ObjectUtils.isNotEmpty(params.getProductIdList()),Warehouse::getProductId,params.getProductIdList());
		queryWrapper.eq(StringUtils.isNotBlank(params.getOrderId()),Warehouse::getOrderId,params.getOrderId());
		queryWrapper.eq(StringUtils.isNotBlank(params.getPurchaseType()),Warehouse::getPurchaseType,params.getPurchaseType());
		queryWrapper.eq(StringUtils.isNotBlank(params.getCustomer()),Warehouse::getCustomer,params.getCustomer());
		queryWrapper.like(StringUtils.isNotBlank(params.getShipping()),Warehouse::getShipping,params.getShipping());
		queryWrapper.eq(StringUtils.isNotBlank(params.getUnit()),Warehouse::getUnit,params.getUnit());
		queryWrapper.like(StringUtils.isNotBlank(params.getRemark()),Warehouse::getRemark,params.getRemark());
		queryWrapper.orderByDesc(true,Warehouse::getCreateTime);
        return this.page(page, queryWrapper);
    }
}

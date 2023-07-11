package com.leo.fly.db.stock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.stock.entity.Stock;
import com.leo.fly.db.stock.mapper.StockMapper;
import com.leo.fly.db.stock.params.StockQueryParam;
import com.leo.fly.db.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock> implements StockService {
    @Override
    public Page<Stock> page(Page page, StockQueryParam params) {
        LambdaQueryWrapper<Stock> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getId()),Stock::getId,params.getId());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getProductId()),Stock::getProductId,params.getProductId());
		queryWrapper.eq(StringUtils.isNotBlank(params.getProductType()),Stock::getProductType,params.getProductType());
		queryWrapper.eq(StringUtils.isNotBlank(params.getProductName()),Stock::getProductName,params.getProductName());
		queryWrapper.eq(StringUtils.isNotBlank(params.getRemark()),Stock::getRemark,params.getRemark());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getTotalQuantity()),Stock::getTotalQuantity,params.getTotalQuantity());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getAmount()),Stock::getAmount,params.getAmount());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getTotalAmount()),Stock::getTotalAmount,params.getTotalAmount());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getQuantity()),Stock::getQuantity,params.getQuantity());
        return this.page(page, queryWrapper);
    }
}

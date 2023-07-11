package com.leo.fly.db.quote.items.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.quote.items.entity.QuoteItems;
import com.leo.fly.db.quote.items.mapper.QuoteItemsMapper;
import com.leo.fly.db.quote.items.params.QuoteItemsQueryParam;
import com.leo.fly.db.quote.items.service.QuoteItemsService;
import org.springframework.stereotype.Service;

@Service
public class QuoteItemsServiceImpl extends ServiceImpl<QuoteItemsMapper, QuoteItems> implements QuoteItemsService {
    @Override
    public Page<QuoteItems> page(Page page, QuoteItemsQueryParam params) {
        LambdaQueryWrapper<QuoteItems> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.like(ObjectUtils.isNotEmpty(params.getCode()),QuoteItems::getCode,params.getCode());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getQuoteId()),QuoteItems::getQuoteId,params.getQuoteId());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getProductId()),QuoteItems::getProductId,params.getProductId());
		queryWrapper.eq(StringUtils.isNotBlank(params.getProductName()),QuoteItems::getProductName,params.getProductName());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getQuantity()),QuoteItems::getQuantity,params.getQuantity());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getUnitPrice()),QuoteItems::getUnitPrice,params.getUnitPrice());
		queryWrapper.eq(StringUtils.isNotBlank(params.getRemark()),QuoteItems::getRemark,params.getRemark());
        return this.page(page, queryWrapper);
    }
}

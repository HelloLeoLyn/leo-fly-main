package com.leo.fly.db.quote.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.entity.vo.StatusModel;
import com.leo.fly.common.enums.SqlConditionModel;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.quote.entity.Quote;
import com.leo.fly.db.quote.mapper.QuoteMapper;
import com.leo.fly.db.quote.params.QuoteQueryParam;
import com.leo.fly.db.quote.service.QuoteService;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl extends ServiceImpl<QuoteMapper, Quote> implements QuoteService {
    @Override
    public Page<Quote> page(Page page, QuoteQueryParam params) {
        LambdaQueryWrapper<Quote> queryWrapper = new LambdaQueryWrapper<>();
		setStatus(queryWrapper,params.getStatus());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getId()),Quote::getId,params.getId());
		queryWrapper.like(StringUtils.isNotBlank(params.getTitle()),Quote::getTitle,params.getTitle());
		queryWrapper.like(StringUtils.isNotBlank(params.getCustomer()),Quote::getCustomer,params.getCustomer());
		queryWrapper.like(StringUtils.isNotBlank(params.getOperator()),Quote::getOperator,params.getOperator());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getOperatorId()),Quote::getOperatorId,params.getOperatorId());
		queryWrapper.eq(StringUtils.isNotBlank(params.getType()),Quote::getType,params.getType());
		queryWrapper.like(StringUtils.isNotBlank(params.getRemark()),Quote::getRemark,params.getRemark());
        return this.page(page, queryWrapper);
    }

    private void setStatus(LambdaQueryWrapper<Quote> queryWrapper, StatusModel status){
    	if(status!=null){
			SqlConditionModel model = status.getModel();
			switch(model){
				case eq:
					queryWrapper.eq(Quote::getStatus,status.getVal());
					break; //可选
				case lt:
					queryWrapper.lt(Quote::getStatus,status.getVal());
					break; //可选
				case gt:
					queryWrapper.gt(Quote::getStatus,status.getVal());
					break; //可选
				case in:
					queryWrapper.in(Quote::getStatus,status.getVal());//语句
					break; //可选
				case le:
					queryWrapper.le(Quote::getStatus,status.getVal());//语句
					break; //可选
				case ge:
					queryWrapper.ge(Quote::getStatus,status.getVal());//语句
					break; //可选
				case like:
					queryWrapper.like(Quote::getStatus,status.getVal());//语句
					break; //可选
				default : //可选
					//语句
			}

		}
	}
}

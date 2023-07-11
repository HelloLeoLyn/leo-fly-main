package com.leo.fly.db.work.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.work.entity.Work;
import com.leo.fly.db.work.mapper.WorkMapper;
import com.leo.fly.db.work.params.WorkQueryParam;
import com.leo.fly.db.work.service.WorkService;
import org.springframework.stereotype.Service;

@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work> implements WorkService {
    @Override
    public Page<Work> page(Page page, WorkQueryParam params) {
        LambdaQueryWrapper<Work> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.like(StringUtils.isNotBlank(params.getDescription()),Work::getDescription,params.getDescription());
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getStatus()),Work::getStatus,params.getStatus());
		queryWrapper.ge(StringUtils.isNotBlank(params.getStart()),Work::getStart,params.getStart());
		queryWrapper.le(StringUtils.isNotBlank(params.getEnd()),Work::getEnd,params.getEnd());
		queryWrapper.like(StringUtils.isNotBlank(params.getReferNo()),Work::getReferNo,params.getReferNo());
		queryWrapper.eq(StringUtils.isNotBlank(params.getType()),Work::getType,params.getType());
        return this.page(page, queryWrapper);
    }
}

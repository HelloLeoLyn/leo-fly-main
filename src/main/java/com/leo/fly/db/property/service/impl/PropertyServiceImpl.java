package com.leo.fly.db.property.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.property.entity.Property;
import com.leo.fly.db.property.mapper.PropertyMapper;
import com.leo.fly.db.property.params.PropertyQueryParam;
import com.leo.fly.db.property.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl extends ServiceImpl<PropertyMapper, Property> implements PropertyService {
    @Override
    public Page<Property> page(Page page, PropertyQueryParam params) {
        LambdaQueryWrapper<Property> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(StringUtils.isNotBlank(params.getId()),Property::getId,params.getId());
		queryWrapper.eq(StringUtils.isNotBlank(params.getValue()),Property::getValue,params.getValue());
		queryWrapper.eq(StringUtils.isNotBlank(params.getDescription()),Property::getDescription,params.getDescription());
        return this.page(page, queryWrapper);
    }
}

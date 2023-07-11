package com.leo.fly.db.tag.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.ObjectUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.tag.entity.Tag;
import com.leo.fly.db.tag.mapper.TagMapper;
import com.leo.fly.db.tag.params.TagQueryParam;
import com.leo.fly.db.tag.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Override
    public Page<Tag> page(Page page, TagQueryParam params) {
        LambdaQueryWrapper<Tag> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(ObjectUtils.isNotEmpty(params.getId()),Tag::getId,params.getId());
		queryWrapper.eq(StringUtils.isNotBlank(params.getName()),Tag::getName,params.getName());
		queryWrapper.eq(StringUtils.isNotBlank(params.getType()),Tag::getType,params.getType());
        return this.page(page, queryWrapper);
    }
}

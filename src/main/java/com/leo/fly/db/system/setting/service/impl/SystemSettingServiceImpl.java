package com.leo.fly.db.system.setting.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.db.system.setting.entity.SystemSetting;
import com.leo.fly.db.system.setting.mapper.SystemSettingMapper;
import com.leo.fly.db.system.setting.params.SystemSettingQueryParam;
import com.leo.fly.db.system.setting.service.SystemSettingService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

@Service
@CacheConfig(cacheNames = {"sys_set"})
public class SystemSettingServiceImpl extends ServiceImpl<SystemSettingMapper, SystemSetting> implements SystemSettingService {
    @Resource
    RedisTemplate redisTemplate;
    @Override
    public Page<SystemSetting> page(Page page, SystemSettingQueryParam params) {
        LambdaQueryWrapper<SystemSetting> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(StringUtils.isNotBlank(params.getKey()),SystemSetting::getKey,params.getKey());
		queryWrapper.eq(StringUtils.isNotBlank(params.getValue()),SystemSetting::getValue,params.getValue());
		queryWrapper.eq(StringUtils.isNotBlank(params.getDataType()),SystemSetting::getDataType,params.getDataType());
        return this.page(page, queryWrapper);
    }

    @Override
    @Cacheable
    public SystemSetting getById(Serializable id) {
        return this.baseMapper.selectById(id);
    }
}

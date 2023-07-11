package com.leo.fly.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.leo.fly.sys.entity.SysDept;
import com.leo.fly.sys.mapper.SysDeptMapper;
import com.leo.fly.sys.service.SysDeptService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 机构管理 服务实现类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-05-09
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    @Override
    public Boolean deleteLogical(Long id) {
        UpdateWrapper<SysDept> wrapper = new UpdateWrapper<>();
        wrapper.lambda().set(SysDept::getDelFlag,-1).eq(SysDept::getId,id);
        return update(wrapper);
    }
}

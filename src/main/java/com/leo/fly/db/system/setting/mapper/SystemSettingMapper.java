package com.leo.fly.db.system.setting.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.leo.fly.db.system.setting.entity.SystemSetting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface SystemSettingMapper extends BaseMapper<SystemSetting> {

}

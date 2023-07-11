package com.leo.fly.db.system.setting.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.leo.fly.db.system.setting.entity.SystemSetting;
import com.leo.fly.db.system.setting.params.SystemSettingQueryParam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */

public interface SystemSettingService extends IService<SystemSetting> {
    Page<SystemSetting> page(Page page, SystemSettingQueryParam toParam);

}

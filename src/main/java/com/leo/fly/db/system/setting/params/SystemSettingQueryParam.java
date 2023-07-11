package com.leo.fly.db.system.setting.params;

import com.leo.fly.db.system.setting.entity.SystemSetting;
import com.leo.fly.web.param.BaseParam;
import lombok.Data;

@Data
public class SystemSettingQueryParam extends BaseParam<SystemSetting>{
	/**
	* 
	*/
	private String key;
	/**
	* 
	*/
	private String value;
	private String dataType;
}

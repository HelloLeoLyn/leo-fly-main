package com.leo.fly.db.system.setting.params;

import com.leo.fly.db.system.setting.entity.SystemSetting;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;

@Data
public class SystemSettingAddForm extends BaseForm<SystemSetting>{
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

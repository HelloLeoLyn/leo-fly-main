package com.leo.fly.db.system.setting.params;

import com.leo.fly.web.form.BaseQueryForm;
import lombok.Data;

@Data
public class SystemSettingQueryForm extends BaseQueryForm<SystemSettingQueryParam>{
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

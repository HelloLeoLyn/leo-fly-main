package com.leo.fly.db.property.params;

import com.leo.fly.db.property.entity.Property;
import com.leo.fly.web.form.BaseQueryForm;
import lombok.Data;
import com.leo.fly.web.param.BaseParam;
@Data
public class PropertyQueryParam extends BaseParam<Property>{
	/**
	* 
	*/
	private String id;
	/**
	* 
	*/
	private String value;
	/**
	* 
	*/
	private String description;
}

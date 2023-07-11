package com.leo.fly.db.property.params;

import com.leo.fly.web.form.BaseQueryForm;
import lombok.Data;

@Data
public class PropertyQueryForm extends BaseQueryForm<PropertyQueryParam>{
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

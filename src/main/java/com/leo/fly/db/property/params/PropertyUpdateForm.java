package com.leo.fly.db.property.params;

import com.leo.fly.db.property.entity.Property;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;

@Data
public class PropertyUpdateForm extends BaseForm<Property>{
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

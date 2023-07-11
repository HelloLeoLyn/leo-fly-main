package com.leo.fly.db.property.params;

import com.leo.fly.db.property.entity.Property;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;
import java.math.BigDecimal;
@Data
public class PropertyAddForm extends BaseForm<Property>{
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

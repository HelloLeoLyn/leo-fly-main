package com.leo.fly.db.tag.params;

import com.leo.fly.web.form.BaseQueryForm;
import lombok.Data;

@Data
public class TagQueryForm extends BaseQueryForm<TagQueryParam>{
	/**
	* 标签id
	*/
	private Integer id;
	/**
	* 标签名
	*/
	private String name;
	/**
	* 标签类型
	*/
	private String type;
}

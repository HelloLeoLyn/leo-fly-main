package com.leo.fly.db.tag.params;

import com.leo.fly.db.tag.entity.Tag;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;

@Data
public class TagUpdateForm extends BaseForm<Tag>{
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

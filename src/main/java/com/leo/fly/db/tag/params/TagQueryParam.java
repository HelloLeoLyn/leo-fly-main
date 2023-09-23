package com.leo.fly.db.tag.params;

import com.leo.fly.db.tag.entity.Tag;
import com.leo.fly.web.param.BaseParam;
import lombok.Data;

import java.util.List;

@Data
public class TagQueryParam extends BaseParam<Tag>{
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
	/**
	 * 标签id
	 */
	private List<Integer> idList;
}

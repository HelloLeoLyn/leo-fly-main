package com.leo.fly.db.tag.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leo.fly.web.po.BasePoNvl;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* Sat Jun 24 11:02:24 CST 2023
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_tag")
public class Tag extends BasePoNvl {
	/**
	* 标签id
	*/
	@TableId(value = "id",type = IdType.AUTO)
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

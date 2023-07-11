package com.leo.fly.db.property.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leo.fly.web.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.math.BigDecimal;

/**
* Sun Sep 18 20:40:22 CST 2022
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_property")
public class Property extends BasePo {
	/**
	* 
	*/
	@TableId(type = IdType.INPUT)
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

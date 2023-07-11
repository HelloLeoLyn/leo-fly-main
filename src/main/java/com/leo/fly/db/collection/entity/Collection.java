package com.leo.fly.db.collection.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leo.fly.web.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import java.math.BigDecimal;

/**
* Tue Jan 31 16:07:21 CST 2023
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_collection")
public class Collection extends BasePo {
	/**
	* 
	*/
	private Long id;
	/**
	* 
	*/
	private Integer categoryId;
	/**
	* 
	*/
	private String name;
	/**
	* 
	*/
	private BigDecimal weight;
	/**
	* 
	*/
	private BigDecimal width;
	/**
	* 
	*/
	private BigDecimal height;
	/**
	* 
	*/
	private BigDecimal length;
	/**
	* 
	*/
	private Integer unitQuantity;
	/**
	* 
	*/
	private String unit;
	/**
	* 
	*/
	private String color;
	/**
	* 
	*/
	private String brandCode;
	/**
	* 
	*/
	private String images;
	/**
	* 
	*/
	private String keyword;
	/**
	* 
	*/
	private String refers;
	/**
	* 
	*/
	private String purchasePrices;
	/**
	* 
	*/
	private String salePrices;
}

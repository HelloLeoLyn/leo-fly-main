package com.leo.fly.db.stock.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leo.fly.web.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;


/**
* Mon Jul 04 00:30:23 CST 2022
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_stock")
public class Stock extends BasePo {
	/**
	* 
	*/
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 
	*/

	private Long productId;
	/**
	* 
	*/
	private String productType;
	/**
	* 
	*/
	private String productName;
	/**
	* 
	*/
	private String remark;
	/**
	* 
	*/
	private Long totalQuantity;
	/**
	* 
	*/
	private BigDecimal amount;
	/**
	* 
	*/
	private BigDecimal totalAmount;
	/**
	* 
	*/
	private Long quantity;
}

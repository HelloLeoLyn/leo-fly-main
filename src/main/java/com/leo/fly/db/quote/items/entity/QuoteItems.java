package com.leo.fly.db.quote.items.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leo.fly.web.po.BasePoNvl;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;


/**
* Fri Jun 24 11:40:48 CST 2022
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_quote_items")
public class QuoteItems extends BasePoNvl {
	/**
	* 
	*/
	@TableId (value="id" ,type = IdType.AUTO)
	private Long id;
	/**
	* 报价单id
	*/
	private Long quoteId;
	/**
	* 产品id
	*/
	private Long productId;
	/**
	* 
	*/
	private String productName;
	/**
	* 数量
	*/
	private Integer quantity;
	/**
	* 单价
	*/
	private BigDecimal unitPrice;
	/**
	* 备注
	*/
	private String remark;

	private String code;

	private Integer state;

	@TableField(exist = false)
	private String imagePath;

	private String similarCode;

	private Double suggestedPrice;

	private Integer suggestedAmount;
}

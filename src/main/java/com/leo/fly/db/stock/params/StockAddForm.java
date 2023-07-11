package com.leo.fly.db.stock.params;

import com.leo.fly.db.stock.entity.Stock;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class StockAddForm extends BaseForm<Stock>{
	/**
	* 
	*/
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

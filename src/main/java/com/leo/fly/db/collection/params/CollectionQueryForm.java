package com.leo.fly.db.collection.params;

import com.leo.fly.web.form.BaseQueryForm;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CollectionQueryForm extends BaseQueryForm<CollectionQueryParam>{
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

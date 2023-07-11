package com.leo.fly.db.collection.params;

import com.leo.fly.db.collection.entity.Collection;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;
import java.math.BigDecimal;
@Data
public class CollectionAddForm extends BaseForm<Collection>{
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

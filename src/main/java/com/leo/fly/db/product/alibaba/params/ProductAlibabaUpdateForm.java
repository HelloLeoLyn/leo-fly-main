package com.leo.fly.db.product.alibaba.params;

import com.leo.fly.db.product.alibaba.entity.ProductAlibaba;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;

@Data
public class ProductAlibabaUpdateForm extends BaseForm<ProductAlibaba>{
	/**
	* 
	*/
	private Long productID;
	/**
	* 
	*/
	private Long localProductId;
	/**
	* 
	*/
	private String productType;
	/**
	* 
	*/
	private Long categoryID;
	/**
	* 
	*/
	private String groupId;
	/**
	* 
	*/
	private String status;
	/**
	* 
	*/
	private String subject;
	/**
	* 
	*/
	private String language;
	/**
	* 
	*/
	private Integer periodOfValidity;
	/**
	* 
	*/
	private Integer bizType;
	/**
	* 
	*/
	private String pictureAuth;
	/**
	* 
	*/
	private String image;

}

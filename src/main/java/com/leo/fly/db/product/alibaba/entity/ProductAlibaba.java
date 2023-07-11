package com.leo.fly.db.product.alibaba.entity;

import com.alibaba.product.param.*;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.leo.fly.web.po.BasePoNvl;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
* Sat Sep 24 15:30:20 CST 2022
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value="leo_product_alibaba",autoResultMap = true)
public class ProductAlibaba extends BasePoNvl {
	@TableId(value = "id",type = IdType.AUTO)
	private Long id;
	
	@TableField(value = "productID" )
	private Long productID;
	@TableField(value = "localProductId" )
	private Long localProductId;
	@TableField(value = "productType" )
	private String productType;
	@TableField(value = "categoryID" )
	private Long categoryID;
	@TableField(value="groupId",typeHandler = FastjsonTypeHandler.class)
	private List<Number> groupID;

	private String status;
	
	private String subject;
	
	private String language;
	@TableField(value = "periodOfValidity" )
	private Integer periodOfValidity;
	@TableField(value = "bizType" )
	private Integer bizType;
	@TableField(value = "pictureAuth" )
	private Boolean pictureAuth;

	@TableField(value="attributes",typeHandler = FastjsonTypeHandler.class)
	private List<AlibabaProductProductAttribute> attributes;
	@TableField(value="image",typeHandler = FastjsonTypeHandler.class)
	private AlibabaProductProductImageInfo image;
	@TableField(value="skuInfos",typeHandler = FastjsonTypeHandler.class)
	private List<AlibabaProductProductSKUInfo>  skuInfos[];
	@TableField(value="saleInfo",typeHandler = FastjsonTypeHandler.class)
	private AlibabaProductProductSaleInfo saleInfo;
	@TableField(value="shippingInfo",typeHandler = FastjsonTypeHandler.class)
	private AlibabaProductProductShippingInfo shippingInfo;

	@TableField(value = "categoryName" )
	private String categoryName;
	@TableField(value = "mainVedio" )
	private String mainVedio;
	@TableField(value = "productCargoNumber" )
	private String productCargoNumber;
	@TableField(value = "mainImage" )
	private String mainImage;
	private String webSite;
	private String description;

}

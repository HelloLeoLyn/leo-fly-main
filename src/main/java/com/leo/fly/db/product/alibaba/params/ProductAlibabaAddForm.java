package com.leo.fly.db.product.alibaba.params;

import com.alibaba.product.param.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.leo.fly.db.product.alibaba.entity.ProductAlibaba;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class ProductAlibabaAddForm extends BaseForm<ProductAlibaba>{
	private Long productID;
	@NotNull
	private Long localProductId;
	@NotBlank
	private String productType;
	@NotNull
	private Long categoryID;
	@JsonProperty("groupID")
	@Size(min = 1)
	private List<Number> groupId;
	@NotBlank
	private String subject;
	@NotBlank
	private String description;
	@NotBlank
	private String language;
	@NotNull
	private Integer periodOfValidity;
	@NotNull
	private Integer bizType;
	@NotNull
	private String pictureAuth;
	@Valid
	private List<AlibabaProductProductAttribute> attributes;
	@Valid
	private AlibabaProductProductImageInfo image;
	@Valid
	private List<AlibabaProductProductSKUInfo>  skuInfos[];
	@NotNull
	private AlibabaProductProductSaleInfo saleInfo;
	@NotNull
	private AlibabaProductProductShippingInfo shippingInfo;

	@NotBlank
	private String webSite;

	private Long productLineID;

	private Boolean sevenDaysRefunds = false;
	@NotBlank
	private String brand;
	@NotBlank
	private String productName;
	@NotNull
	private String code;
	@NotNull
	private Long albumID;
}

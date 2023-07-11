package com.leo.fly.db.quote.items.params;


import com.leo.fly.db.quote.items.entity.QuoteItems;
import com.leo.fly.web.param.BaseParam;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class QuoteItemsQueryParam extends BaseParam<QuoteItems> {
	/**
	* 
	*/
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
}

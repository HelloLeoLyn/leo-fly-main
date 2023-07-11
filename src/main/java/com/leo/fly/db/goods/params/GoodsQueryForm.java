package com.leo.fly.db.goods.params;

import com.leo.fly.web.form.BaseQueryForm;
import lombok.Data;

@Data
public class GoodsQueryForm extends BaseQueryForm<GoodsQueryParam>{
	/**
	* 商品id
	*/
	private Long id;
	/**
	* 产品id
	*/
	private Long productId;
	/**
	* 平台
	*/
	private String platform;
	/**
	* 主题
	*/
	private String subject;
	/**
	* 图片
	*/
	private String images;
	/**
	* 主图
	*/
	private String mainImage;
	/**
	* 标签
	*/
	private String tag;
}

package com.leo.fly.db.goods.params;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.leo.fly.db.goods.entity.Goods;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;

@Data
public class GoodsUpdateForm extends BaseForm<Goods>{
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
	private JSONArray images;
	/**
	* 主图
	*/
	private String mainImage;
	/**
	* 标签
	*/
	private String tag;
}

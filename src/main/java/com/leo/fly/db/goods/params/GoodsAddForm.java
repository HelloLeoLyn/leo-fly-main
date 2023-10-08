package com.leo.fly.db.goods.params;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.leo.fly.db.goods.entity.Goods;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;
@Data
public class GoodsAddForm extends BaseForm<Goods>{
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
	* 主图
	*/
	private String mainImage;
	/**
	* 标签
	*/
	private String tag;

	/**
	 * 图片
	 */
	@TableField(value="images",typeHandler = FastjsonTypeHandler.class)
	private JSONArray images;

	/**
	 * 第三方id
	 */
	private String thirdPartId;
	/**
	 * 参数
	 */
	@TableField(value="json",typeHandler = FastjsonTypeHandler.class)
	private JSONObject json;
}

package com.leo.fly.db.goods.entity;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.leo.fly.web.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
* Mon Jun 26 12:06:24 CST 2023
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "leo_goods",autoResultMap = true)
public class Goods extends BasePo {
	/**
	* 商品id
	*/
	@TableId(value = "id",type = IdType.AUTO)
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
	@TableField(value="images",typeHandler = FastjsonTypeHandler.class)
	private JSONArray images;
	/**
	* 主图
	*/
	private String mainImage;
	/**
	* 标签
	*/
	private String tag;
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

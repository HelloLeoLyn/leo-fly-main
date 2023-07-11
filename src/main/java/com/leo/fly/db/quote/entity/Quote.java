package com.leo.fly.db.quote.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leo.fly.web.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
* Fri Jun 24 11:40:19 CST 2022
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_quote")
public class Quote extends BasePo {
	/**
	* 
	*/
	@TableId (value="id" ,type = IdType.AUTO)
	private Long id;

	/**
	 *报价序列号
	 */
	private String seq;
	/**
	* 标题
	*/
	private String title;
	/**
	* 客户
	*/
	private String customer;
	/**
	* 报价人
	*/
	private String operator;

	/**
	 * 报价人id
	 */
	private Long operatorId;
	/**
	* 报价状态：0待处理,10处理中,99成功
	*/
	private Integer status;
	/**
	* N:普通报价
	*/
	private String type;
	/**
	* 备注
	*/
	private String remark;


}

package com.leo.fly.db.quote.params;

import com.leo.fly.common.entity.vo.StatusModel;
import com.leo.fly.web.form.BaseQueryForm;
import lombok.Data;

@Data
public class QuoteQueryForm extends BaseQueryForm<QuoteQueryParam>{
	/**
	* 
	*/
	private Long id;
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
	 * 报价人
	 */
	private Long operatorId;
	/**
	* 报价状态：0待处理,10处理中,99成功
	*/
	private StatusModel status;
	/**
	* N:普通报价
	*/
	private String type;
	/**
	* 备注
	*/
	private String remark;
}

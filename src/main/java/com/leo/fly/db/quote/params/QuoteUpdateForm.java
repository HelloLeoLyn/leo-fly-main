package com.leo.fly.db.quote.params;

import com.leo.fly.db.quote.entity.Quote;
import com.leo.fly.db.quote.items.entity.QuoteItems;
import com.leo.fly.db.work.entity.Work;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;

import java.util.List;

@Data
public class QuoteUpdateForm extends BaseForm<Quote>{
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
	private Integer status;
	/**
	* N:普通报价
	*/
	private String type;
	/**
	* 备注
	*/
	private String remark;

	private List<QuoteItems> items;

	private Work work;
}

package com.leo.fly.db.work.params;

import com.leo.fly.db.work.entity.Work;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;

@Data
public class WorkAddForm extends BaseForm<Work>{
	/**
	* 任务类型
	*/
	private String type;
	/**
	* 任务描述
	*/
	private String description;
	/**
	* 
	*/
	private Integer status;
	/**
	* 任务起始日期
	*/
	private String start;
	/**
	* 任务结束日期
	*/
	private String end;
	/**
	* 关联号
	*/
	private String referNo;

	/**
	 * 详情文本
	 */
	private String content;
	/**
	 * 是否存在content
	 */
	private Boolean existContent;
	/**
	 * 成员
	 */
	private String members;
}

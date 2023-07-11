package com.leo.fly.db.work.params;

import com.leo.fly.db.work.entity.Work;
import com.leo.fly.web.param.BaseParam;
import lombok.Data;

@Data
public class WorkQueryParam extends BaseParam<Work>{
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
	* 任务类型
	*/
	private String type;
}

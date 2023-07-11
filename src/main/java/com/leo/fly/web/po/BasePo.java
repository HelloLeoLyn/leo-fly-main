package com.leo.fly.web.po;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;


@Data
public class BasePo implements Serializable {
	public final static String DEFAULT_USERNAME = "system";
	public final static int DEFAULT_USER_ID = 0;

	@TableField(fill = FieldFill.INSERT)
	private String createBy;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	@TableField(fill = FieldFill.INSERT_UPDATE)
	private String updateBy;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;
}
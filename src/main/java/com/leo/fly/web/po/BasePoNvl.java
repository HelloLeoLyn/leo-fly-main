package com.leo.fly.web.po;


import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;


@Data
public class BasePoNvl extends BasePo {
	@TableField(exist = false)
	private String createBy;

	@TableField(exist = false)
	private Date createTime;

	@TableField(exist = false)
	private String updateBy;

	@TableField(exist = false)
	private Date updateTime;
}
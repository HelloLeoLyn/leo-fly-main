package com.leo.fly.db.work.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leo.fly.web.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
* Tue Jun 21 18:59:06 CST 2022
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_work")
public class Work extends BasePo {
	/**
	* 
	*/
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
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

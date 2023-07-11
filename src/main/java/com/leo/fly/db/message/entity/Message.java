package com.leo.fly.db.message.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leo.fly.web.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
* Thu Jun 23 01:42:57 CST 2022
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_message")
public class Message extends BasePo {
	/**
	* 
	*/
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 消息类型
	*/
	private String type;
	/**
	* 名称
	*/
	private String name;
	/**
	* 信息标题
	*/
	private String title;
	/**
	* 内容
	*/
	private String content;
	/**
	* 发送人
	*/
	private String send;
	/**
	* 接收人
	*/
	private String recipient;
}

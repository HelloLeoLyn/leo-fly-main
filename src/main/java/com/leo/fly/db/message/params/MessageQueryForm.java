package com.leo.fly.db.message.params;

import com.leo.fly.web.form.BaseQueryForm;
import lombok.Data;

@Data
public class MessageQueryForm extends BaseQueryForm<MessageQueryParam>{
	/**
	* 
	*/
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

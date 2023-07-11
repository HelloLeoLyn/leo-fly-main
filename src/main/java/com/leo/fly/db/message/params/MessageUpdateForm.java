package com.leo.fly.db.message.params;

import com.leo.fly.db.message.entity.Message;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;

@Data
public class MessageUpdateForm extends BaseForm<Message>{
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

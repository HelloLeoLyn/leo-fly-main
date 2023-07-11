package com.leo.fly.db.system.setting.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leo.fly.web.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
* Thu Jun 23 15:52:06 CST 2022
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_system_setting")
public class SystemSetting extends BasePo {
	/**
	* 键
	*/
	@TableId(value="`key`", type = IdType.INPUT)
	private String key;
	/**
	* 值
	*/
	private String value;

	/**
	 *数据类型
	 */
	private String dataType;

	/**
	 * 名称
	 */
	private String name;
}

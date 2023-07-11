package com.leo.fly.db.warehouse.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import com.leo.fly.web.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.math.BigDecimal;


/**
* Sat Jul 02 13:30:58 CST 2022
*/
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_warehouse")
public class Warehouse extends BasePo {
	/**
	* 
	*/
	@TableId(value = "id", type = IdType.AUTO)
	private Long id;
	/**
	* 0入库，1出库
	*/
	private String type;
	/**
	* 进价
	*/
	private BigDecimal purchasePrice;
	/**
	* 
	*/
	private BigDecimal sellingPrice;
	/**
	* 出入库数量
	*/
	private Integer amount;
	/**
	* 产品id
	*/
	private Long productId;
	/**
	* 出入库单号
	*/
	private String orderId;
	/**
	* 
	*/
	private String nno;
	/**
	* 结款方式:{C：现金，R：电子汇款，G：挂账，O：其他}
	*/
	private String purchaseType;
	/**
	* 客户
	*/
	private String customer;
	/**
	* 送货方式：{C:客户自提，D：快递}
	*/
	private String shipping;
	/**
	* 单位
	*/
	private String unit;
	/**
	* 
	*/
	private String remark;

	private String codeType;
}

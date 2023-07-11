package com.leo.fly.db.warehouse.params;

import com.leo.fly.db.warehouse.entity.Warehouse;

import com.leo.fly.web.param.BaseParam;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class WarehouseQueryParam extends BaseParam<Warehouse> {
	/**
	* 
	*/
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


	private List<Long> idList;
	private List<Long> productIdList;
}

package com.leo.fly.db.order.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("leo_order")
public class Order implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单号，销售单SD_XX，采购单PD_XX
     */
    private String orderId;

    /**
     * 表头
     */
    private String head;

    /**
     * 订单日期
     */
    private String orderDate;

    /**
     * 订单金额
     */
    private BigDecimal price;

    /**
     * 订单项
     */
    private Integer itemNum;

    /**
     * 备注
     */
    private String remark;

    /**
     * 底单图片
     */
    private Long imageId;


}

package com.leo.fly.db.product.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;


import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import com.leo.fly.web.po.BasePo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author leo.lyn
 * @since 2021-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "leo_product",autoResultMap = true)
public class Product extends BasePo {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 类目ID，由相应类目API获取
     */
    private Long categoryId;


    /**
     * 商品标题，最多255个字符。标题内容将被系统切分作为关键字，因此API将不再单独提供关键字字段。
     */
    private String subject;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 汽车厂商
     */
    private String brand;

    /**
     * 汽车车型
     */
    private String model;

    /**
     * 计量单位
     */
    private String unit;


    /**
     * 媒介资源
     */
    @TableField(value="images",typeHandler = FastjsonTypeHandler.class)
    private List<Number> images;

    /**
     * warranty
     */
    private String warranty;
    /**
     * 单位重量
     */
    private String weight;

    /**
     * 尺寸，单位是厘米，长宽高范围是1-9999999。1688无需关注此字段
     */
    private String packageSize;


    /**
     * 状态
     */
    private Integer status;

    /**
     * 货号
     */
    @TableField(value="code",typeHandler = FastjsonTypeHandler.class)
    private List<String> code;


    /**
     * 货号类型
     */
    private String codeType;

    /**
     * 主图
     */
    private String mainImage;

    private String error;

    @TableField(value="ref_no",typeHandler = FastjsonTypeHandler.class)
    private List<String> refNo;

    @TableField(value="type",typeHandler = FastjsonTypeHandler.class)
    private JSONObject type;

    private String referStatus;

    @TableField(value="group_id",typeHandler = FastjsonTypeHandler.class)
    private List<Number> groupId;

    private String tagIds;
}

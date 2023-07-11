package com.leo.fly.db.product.alibaba.params;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.handlers.FastjsonTypeHandler;
import lombok.Data;

import java.util.List;


@Data
public class ProductAlibabaForm {
    private String optType;
    private List<String> urlImages;
    private List<Number> images;
    private String ImageType;

    private Long id;
    private Long productID;

    private Long localProductId;

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
    @TableField(value = "code", typeHandler = FastjsonTypeHandler.class)
    private List<String> code;

    /**
     * 货号类型
     */
    private String codeType;

    /**
     * 主图
     */
    private String mainImage;


    @TableField(value = "ref_no", typeHandler = FastjsonTypeHandler.class)
    private List<String> refNo;


}

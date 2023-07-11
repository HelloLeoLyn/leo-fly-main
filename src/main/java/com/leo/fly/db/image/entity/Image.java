package com.leo.fly.db.image.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.leo.fly.web.po.BasePoNvl;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 图片表
 * </p>
 *
 * @author leo.lyn
 * @since 2022-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "leo_image",autoResultMap = true)
public class Image extends BasePoNvl {


    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 图片路径
     */
    private String path;

    /**
     * 图片流
     */
    @TableField(value = "stream",typeHandler = org.apache.ibatis.type.BlobTypeHandler.class)
    private String stream;

    /**
     * P产品图，O订单图 PM：产品主图，PS原图, OP:采购单图，OS:销售单图
     */
    private String type;

    /**
     * 图片类型
     */
    private String fileType;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 0 预存 1正常 -1 删除
     */
    private Integer status;

    /**
     * 关联号
     */
    private String code;

    /**
     * 是否主图
     */
    private Boolean isMain;

    /**
     * 小图
     */
    private String icon;

    /**
     * 原图像素
     */
    private String pixel;

    /**
     * 网络链接
     */
    private String url;

    /**
     * 描述
     */
    private String description;
}

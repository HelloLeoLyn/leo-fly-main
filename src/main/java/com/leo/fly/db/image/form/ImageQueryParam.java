package com.leo.fly.db.image.form;

import com.leo.fly.db.image.entity.Image;
import com.leo.fly.web.param.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageQueryParam extends BaseParam<Image> {

    private Long idList;

    private String type;

    private String name;

    private Integer status;

    private String code;

    private Boolean isMain;

    /**
     * 图片类型：{PM：产品主图，PS:产品缩略图, OP:采购单图，OS:销售单图}
     */
    private String moduleType;

    /**
     * 图片类型
     */
    private String fileType;

    /**
     * 数据源
     */
    private int srcType;

}

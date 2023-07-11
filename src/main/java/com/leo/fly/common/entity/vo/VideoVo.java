package com.leo.fly.common.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class VideoVo {

    private String path;
    private String remark;

    @ApiModelProperty(value = "媒介地址")
    private String url;

    @ApiModelProperty(value = "媒介地址缩略图地址，type为video（V）时，不能为空")
    private String subUlr;


    @ApiModelProperty(value = "缩略图宽度")
    private String width;

    @ApiModelProperty(value = "缩略图高度")
    private String height;
}

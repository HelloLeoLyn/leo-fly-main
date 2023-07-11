package com.leo.fly.web.form;

import com.leo.fly.common.enums.Platform;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@ApiModel
@Slf4j
@Data
public class PublicRequestHeader {

    @ApiModelProperty(hidden = true)
    private String transSeq;


    @NotBlank(message = "客户应用ID不能为空")
    @Size(max = 16, message = "客户应用ID长度不能超过16位")
    @ApiModelProperty(value = "客户应用ID不能为空")
    private String appId;

    @NotEmpty()
    @Size(max = 13, message = "无效的时间戳")
    @ApiModelProperty(value = "时间戳")
//    @ValidTimestamp(minus = 5 * 60 * 1000, plus = 5 * 60 * 1000, message = "无效的时间戳！")
    private String timestamp;

    @NotEmpty(message = "签名串不能为空")
    @ApiModelProperty(value = "签名字符串不能为空")
    private String sign;

    @NotNull(message = "请输入有效platform")
    @ApiModelProperty(value = "平台")
    private Platform platform;

//    @Session(expire = 30)
    @ApiModelProperty(value = "session 有效时间30分钟")
    private String sessionId;

    private String device;


}

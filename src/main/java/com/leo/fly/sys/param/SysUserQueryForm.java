package com.leo.fly.sys.param;

import com.leo.fly.web.form.BaseQueryForm;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class SysUserQueryForm extends BaseQueryForm<SysUserQueryParam> {


    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "ig用户id")
    private String userId;

    @ApiModelProperty(value = "ig用户id")
    private String invitationCode;
}

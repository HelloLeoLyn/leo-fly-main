package com.leo.fly.sys.param;

import com.leo.fly.web.form.BaseForm;
import com.leo.fly.sys.entity.SysUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
@Data
public class SysUserForm extends BaseForm<SysUser> {
    @ApiModelProperty("用户名，不能为空，为空时请填写用户ID")
    @NotBlank(message = "用户名不能为空")
    private String name;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("手机号码")
    private String mobile;

    @ApiModelProperty("网点")
    private Integer deptId;

    @ApiModelProperty("角色")
    private Integer roleId;

    @ApiModelProperty("头像")
    private String headerUrl;

    @ApiModelProperty("用户id，不能为空")
    private String userId;
}

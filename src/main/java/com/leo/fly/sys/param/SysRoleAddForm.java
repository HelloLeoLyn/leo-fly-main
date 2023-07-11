package com.leo.fly.sys.param;

import com.leo.fly.web.form.BaseForm;
import com.leo.fly.sys.entity.SysRole;
import lombok.Data;

@Data
public class SysRoleAddForm extends BaseForm<SysRole> {

    /**
     * 编号
     */
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;


    /**
     * 是否删除  -1：已删除  0：正常
     */
    private Integer delFlag;
}

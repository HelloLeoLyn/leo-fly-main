package com.leo.fly.sys.param;

import com.leo.fly.sys.entity.SysDept;
import com.leo.fly.web.form.BaseForm;
import lombok.Data;

@Data
public class SysDeptUpdateForm extends BaseForm<SysDept> {

    /**
     * 编号
     */
    private Long id;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 上级机构ID，一级机构为0
     */
    private Long parentId;

    /**
     * 排序
     */
    private Integer orderNum;


    /**
     * 是否删除  -1：已删除  0：正常
     */
    private Integer delFlag;


}

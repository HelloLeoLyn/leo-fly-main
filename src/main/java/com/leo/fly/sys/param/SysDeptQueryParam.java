package com.leo.fly.sys.param;

import com.leo.fly.web.param.BaseParam;
import com.leo.fly.sys.entity.SysDept;
import lombok.Data;

@Data
public class SysDeptQueryParam extends BaseParam<SysDept> {

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

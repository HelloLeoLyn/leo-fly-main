package com.leo.fly.sys.param;

import com.leo.fly.web.form.BaseForm;
import com.leo.fly.sys.entity.SysMenu;
import lombok.Data;
@Data
public class SysMenuAddForm extends BaseForm<SysMenu> {



    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;

    /**
     * 菜单URL,类型：1.普通页面（如用户管理， /sys/user） 2.嵌套完整外部页面，以http(s)开头的链接 3.嵌套服务器页面，使用iframe:前缀+目标URL(如SQL监控， iframe:/druid/login.html, iframe:前缀会替换成服务器地址)
     */
    private String url;

    /**
     * 授权(多个用逗号分隔，如：sys:user:add,sys:user:edit)
     */
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;


    /**
     * 组件
     */
    private String component;

    private String componentLocation;

    private String redirect;

    /**
     * 标题
     */
    private String title;

    private Integer delFlag;

    private String path;
}

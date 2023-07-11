package com.leo.fly.sys.param;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leo.fly.common.util.BeanUtils;
import com.leo.fly.common.util.StringUtils;
import com.leo.fly.sys.entity.SysMenu;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class SysMenuVo  {

    private String path;

    private String component;

    private Meta meta;

    private String name;

    private Boolean hidden;

    private List<SysMenuVo> children;
    @JsonIgnore
    private String redirect;

    @JsonIgnore
    private Integer type;
    @JsonIgnore
    private Long id;
    @JsonIgnore
    private Long parentId;

    public SysMenuVo(SysMenu sysMenu){
        BeanUtils.copyProperties(sysMenu,this);
        Map<String, Object> close = null;
        if(StringUtils.isNotBlank(sysMenu.getBeforeClose())){
            close = JSONObject.parseObject(sysMenu.getBeforeClose(), Map.class);
        }
        this.meta = new Meta(sysMenu.getTitle(),sysMenu.getIcon(),true,close);
        this.children = new ArrayList<>();
    }
}

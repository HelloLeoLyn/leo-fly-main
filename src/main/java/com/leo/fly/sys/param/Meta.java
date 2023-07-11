package com.leo.fly.sys.param;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Meta {
    private String title;
    private String icon;
    private Boolean showLink;
    private Map<String,Object> close;
}

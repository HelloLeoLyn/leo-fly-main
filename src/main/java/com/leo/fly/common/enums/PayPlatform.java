package com.leo.fly.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PayPlatform {

    SYSTEM("SYS", "系统", "SYSTEM"),

    ;
    private final String text;
    private final String remark;
    private final String i18Remark;



}

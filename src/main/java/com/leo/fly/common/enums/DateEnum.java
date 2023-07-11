package com.leo.fly.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DateEnum {
    DAY("D"),
    MONTH("M"),
    YEAR("Y");
    private final String type;
}

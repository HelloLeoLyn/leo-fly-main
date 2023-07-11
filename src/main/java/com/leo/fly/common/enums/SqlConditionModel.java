package com.leo.fly.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SqlConditionModel {
    eq("eq","="),
    in("in","in"),
    lt("lt","<"),
    gt("gt",">"),
    le("le","<="),
    ge("ge",">="),
    like("like","like"),
    ;
    private final String name;
    private final String symbol;
}


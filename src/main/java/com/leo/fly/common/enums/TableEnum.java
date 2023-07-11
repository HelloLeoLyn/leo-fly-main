package com.leo.fly.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TableEnum {
    LEO_SCALPING_ORDER(0, "刷单订单表", "RECHARGE"),
    LEO_SCALPING_TASK(1, "刷单订单任务表", "RECHARGE"),
    LEO_SCALPING_PAYMENT(2, "刷单交易表", "RECHARGE"),
    LEO_SCALPING_SHOP(3, "刷单店铺表", "RECHARGE"),

    ;
    private final Integer id;
    private final String name;
    private final String remark;



}

package com.leo.fly.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TradeEnum {
    RECHARGE("RCG", "充值", "RECHARGE"),
    COMMISSION("CMS", "任务佣金", "COMMISSION"),
    ORDER_PRODUCT("OPD", "购买产品", "PRODUCT"),
    SIGN("SGN", "签到", "SIGN"),
    REPOST("RPS", "转贴", "REPOST"),
    INVITE("IVT", "邀请金", "INVITE"),
    BONUS_OF_DOWNLOAD("BOD", "下載贈送金", "DOWNLOAD BONUS"),

    SCALPING_ORDER("SPO", "刷单", "SCALPING_ORDER"),
    SCALPING_ORDER_CANCEL("SOC", "刷单撤销", "SCALPING_ORDER_CANCEL")
    ;
    private final String type;
    private final String remark;
    private final String i18Remark;



}

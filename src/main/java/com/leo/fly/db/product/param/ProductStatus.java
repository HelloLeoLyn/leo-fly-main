package com.leo.fly.db.product.param;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum  ProductStatus {
    NONE(-1, "PRODUCT"),
    PRODUCT0(0, "PRODUCT"),
    PRODUCT100(100, "PRODUCT"),
    ;
    private final int value;
    private final String remark;
}

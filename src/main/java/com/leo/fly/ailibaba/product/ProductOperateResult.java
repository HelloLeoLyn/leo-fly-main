package com.leo.fly.ailibaba.product;

import lombok.Data;

@Data
public class ProductOperateResult {
    private Long productId;

    private Boolean result;

    private String code;

    private String desc;

}

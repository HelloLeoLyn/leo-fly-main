package com.leo.fly.ailibaba.product;

import lombok.Data;

@Data
public class ProductRePostResult {

    private ProductOperateResult[] result;

    private String errorCode;

    private String errorMessage;

    private String subErrorCode;

    private String subErrorMessage;


}

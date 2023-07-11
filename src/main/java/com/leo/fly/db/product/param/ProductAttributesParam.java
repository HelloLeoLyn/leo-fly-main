package com.leo.fly.db.product.param;

import lombok.Data;


@Data
public class ProductAttributesParam {
    private Long productId;
    private String value;
    private String attributeName;
}

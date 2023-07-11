package com.leo.fly.db.product.param;

import lombok.Data;

@Data
public class ProductValidForm {
    private Long id;
    private String referStatus;
    private Integer status;
    private String name;
}

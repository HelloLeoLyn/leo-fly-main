package com.leo.fly.db.product.param;

import lombok.Data;

import java.util.List;

@Data
public class ProductResetForm {
    private Boolean json;
    private Boolean refNo;
    private Boolean oe;
    private Boolean image;
    private Long id;
    private List<String> oemDefault;
}

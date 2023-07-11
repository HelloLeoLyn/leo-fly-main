package com.leo.fly.db.product.param;

import lombok.Data;

@Data
public class ProductUpdateParam {
    private Integer targetStatus;
    private int id;
    private Integer autoPartsId;
    private String oe;
    private String carBrand;
    private String error;
    private Integer currentStatus;
    private Long platformProductID;
}

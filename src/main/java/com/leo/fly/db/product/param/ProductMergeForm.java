package com.leo.fly.db.product.param;

import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class ProductMergeForm {
    private Long jsonId;
    private Long productId;
    private List<Long> productIdList;
    private Set<String> code;
    private Set<String> refNo;
    private String model;
    private List<Number> images;
    private String weight;
    private String packageSize;
}

package com.leo.fly.db.product.param;

import com.alibaba.fastjson.JSONObject;
import com.leo.fly.db.product.entity.ProductJson;
import lombok.Data;

import java.util.List;

@Data
public class ProductVo {
    private Long id;

    private Long categoryId;

    private String subject;

    private String name;

    private String brand;

    private String model;

    private String unit;

    private List images;

    private String warranty;

    private String weight;

    private String packageSize;

    private Integer status;

    private List<String> code;

    private String codeType;

    private String mainImage;

    private String error;

    private List<String> refNo;

    private JSONObject type;

    private  List<ProductJson> jsonList;

}

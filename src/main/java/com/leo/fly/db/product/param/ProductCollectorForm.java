package com.leo.fly.db.product.param;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

@Data
public class ProductCollectorForm {
    private Long id;
    private String code;
    private Integer status;
    private List<String> columns;
    private String subject;
    private String name;
    private String platform;
    private Boolean isShop;
    private String shopUrl;
    private String platformUrl;
    private JSONObject options;
    private List<String> imageUrls;
}

package com.leo.fly.spider;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.List;

@Data
public class SpiderForm {
    private String platform;
    private String dataType;
    private String shopUrl;
    private String url;
    private Boolean isShop;
    private String model;
    private Integer status;
    private String name;
    private Long id;
    private String code;
    private List<String> columns;
    private String platformUrl;
    private JSONObject options;
    private List<String> imageUrls;
    private Boolean clearImages;
    private Boolean isSearchItems;
    private String detailUrl;
    private String subject;
    private Boolean isAutoPs;
    private Boolean isCarFitment;
    private Boolean isCode;
    private Boolean isRefNo;
    private Boolean isImage;
    private Boolean isThirdPart;
    private String moduleType;
}

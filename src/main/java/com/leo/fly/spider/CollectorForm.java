package com.leo.fly.spider;

import lombok.Data;

@Data
public class CollectorForm {
    private Long productId;
    private String subject;
    private String code;
    private String name;
    private String dataType;
    private String platform;
    private boolean isShop;
    private boolean shopUrl;
    private String searchUrl;
    private String isSearchItems;
}

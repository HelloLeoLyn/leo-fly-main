package com.leo.fly.spider;


import lombok.Data;


@Data
public class ProductSpiderForm {

    private Long id;

    private String name;

    private String spiderType;

    private Integer status;

    private Integer targetStatus;
}

package com.leo.fly.auto.code.vo;

import lombok.Data;

@Data
public class TemplateField {
    private String dbKey;
    private String dbType;
    private String javaKey;
    private String javaType;
    private String comment;
    private String columnType;
    private Boolean inQuery;
    private Boolean inAdd;
    private Boolean inUpdate;
    private Boolean inTable;
    private String htmlTag;
    private Boolean isPk;
    private Boolean isNullable;
}

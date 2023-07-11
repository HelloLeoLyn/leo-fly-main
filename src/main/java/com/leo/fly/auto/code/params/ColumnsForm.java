package com.leo.fly.auto.code.params;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ColumnsForm {
    private String tableName;
    private List<Map<String,String>> fields;
}

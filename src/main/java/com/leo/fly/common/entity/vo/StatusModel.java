package com.leo.fly.common.entity.vo;

import com.leo.fly.common.enums.SqlConditionModel;
import lombok.Data;

@Data
public class StatusModel {
    private int val;
    private String key;
    private SqlConditionModel model;
}

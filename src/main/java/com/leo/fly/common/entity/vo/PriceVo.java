package com.leo.fly.common.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class PriceVo {
    private List<PriceRange> range;
    private PriceRange show;
    private String type = "USD";
}

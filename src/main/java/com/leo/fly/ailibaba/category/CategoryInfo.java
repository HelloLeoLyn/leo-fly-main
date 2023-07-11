package com.leo.fly.ailibaba.category;

import lombok.Data;

@Data
public class CategoryInfo {
    private Long categoryID;

    private String name;

    private Boolean isLeaf;

    private String categoryType;

}

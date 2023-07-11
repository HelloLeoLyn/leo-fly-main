package com.leo.fly.ailibaba.category;

import lombok.Data;

@Data
public class CategoryAddForm {
    private String name;
    private String zhName;
    private String type;
    private Long parentID;
}

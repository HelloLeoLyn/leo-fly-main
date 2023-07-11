package com.leo.fly.ailibaba.category;

import lombok.Data;

@Data
public class CategorySearchByKeywordResult {
   private CategoryInfo[] products;
   private String errorMsg;
    private String errorCode;
    private String  success;
}

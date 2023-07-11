package com.leo.fly.ailibaba.category;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class CategorySearchByKeywordParam extends AbstractAPIRequest<CategorySearchByKeywordResult> {
    private String keyword;

    public CategorySearchByKeywordParam() {
        super();
        oceanApiId = new APIId("com.alibaba.product", "alibaba.category.searchByKeyword", 1);
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}

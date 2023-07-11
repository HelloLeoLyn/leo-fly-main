package com.leo.fly.ailibaba.category;

public interface Category1688Service{
    CategoryGetResult get1688(Long id);

    UserDefineCategoryAddResult add1688(UserDefineCategoryAddParam categoryAddParam);

    CategoryAttributeGetResult getAttributes1688(CategoryAttributeGetParam param);

    CategorySearchByKeywordResult search(String keyword);

    void importWith1688();





}

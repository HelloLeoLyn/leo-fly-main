package com.leo.fly.ailibaba.product;

public class ProductProductInfoListResult {

    private ProductPageResult pageResult;

    /**
     * @return 查询结果
     */
    public ProductPageResult getPageResult() {
        return pageResult;
    }

    /**
     * 设置查询结果     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setPageResult(ProductPageResult pageResult) {
        this.pageResult = pageResult;
    }

}

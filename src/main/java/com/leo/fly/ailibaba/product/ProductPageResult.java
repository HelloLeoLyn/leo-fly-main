package com.leo.fly.ailibaba.product;

import com.alibaba.product.param.AlibabaProductProductInfo;

public class ProductPageResult {

    private Integer sizePerPage;

    /**
     * @return 每页数量
     */
    public Integer getSizePerPage() {
        return sizePerPage;
    }

    /**
     * 设置每页数量     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setSizePerPage(Integer sizePerPage) {
        this.sizePerPage = sizePerPage;
    }

    private AlibabaProductProductInfo[] resultList;

    /**
     * @return 商品列表
     */
    public AlibabaProductProductInfo[] getResultList() {
        return resultList;
    }

    /**
     * 设置商品列表     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setResultList(AlibabaProductProductInfo[] resultList) {
        this.resultList = resultList;
    }

    private Integer totalRecords;

    /**
     * @return 商品总数量
     */
    public Integer getTotalRecords() {
        return totalRecords;
    }

    /**
     * 设置商品总数量     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    private Integer pageIndex;

    /**
     * @return 当前页码
     */
    public Integer getPageIndex() {
        return pageIndex;
    }

    /**
     * 设置当前页码     *
     * 参数示例：<pre></pre>     
     * 此参数必填
     */
    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

}

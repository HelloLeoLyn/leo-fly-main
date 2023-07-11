package com.leo.fly.ailibaba.category;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class CategoryAttributeGetParam extends AbstractAPIRequest<CategoryAttributeGetResult> {

    public CategoryAttributeGetParam() {
        super();
        oceanApiId = new APIId("com.alibaba.product", "alibaba.category.attribute.get", 1);
    }

    private Long categoryID;

    /**
     * @return 类目ID
     */
    public Long getCategoryID() {
        return categoryID;
    }

    /**
     * 设置类目ID     *
     * 参数示例：<pre> </pre>     
     * 此参数必填
     */
    public void setCategoryID(Long categoryID) {
        this.categoryID = categoryID;
    }

    private String webSite;

    /**
     * @return 站点信息，指定调用的API是属于国际站（alibaba）还是1688网站（1688）
     */
    public String getWebSite() {
        return webSite;
    }

    /**
     * 设置站点信息，指定调用的API是属于国际站（alibaba）还是1688网站（1688）     *
     * 参数示例：<pre> </pre>     
     * 此参数必填
     */
    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

}

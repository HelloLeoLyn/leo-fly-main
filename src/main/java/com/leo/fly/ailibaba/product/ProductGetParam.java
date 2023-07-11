package com.leo.fly.ailibaba.product;


import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class ProductGetParam extends AbstractAPIRequest<ProductGetResult> {

    public ProductGetParam() {
        super();
        oceanApiId = new APIId("com.alibaba.product", "alibaba.product.get", 1);
    }

    private Long productID;

    /**
     * @return 商品ID
     */
    public Long getProductID() {
        return productID;
    }

    /**
     * 设置商品ID     *
     * 参数示例：<pre>123456</pre>     
     * 此参数必填
     */
    public void setProductID(Long productID) {
        this.productID = productID;
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

    private String scene;

    /**
     * @return 业务场景 零售通(lst) 1688市场(1688)
     */
    public String getScene() {
        return scene;
    }

    /**
     * 设置业务场景 零售通(lst) 1688市场(1688)     *
     * 参数示例：<pre> </pre>     
     * 此参数必填
     */
    public void setScene(String scene) {
        this.scene = scene;
    }

}

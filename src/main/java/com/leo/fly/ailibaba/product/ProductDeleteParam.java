package com.leo.fly.ailibaba.product;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;



public class ProductDeleteParam extends AbstractAPIRequest<ProductDeleteResult> {

    public ProductDeleteParam() {
        super();
        oceanApiId = new APIId("com.alibaba.product", "alibaba.product.delete", 1);
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


}

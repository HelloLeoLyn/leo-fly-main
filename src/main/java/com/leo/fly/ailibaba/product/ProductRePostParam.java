package com.leo.fly.ailibaba.product;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;
import lombok.Data;

@Data
public class ProductRePostParam extends AbstractAPIRequest<ProductRePostResult> {
    private Long[] productIds;

    private String webSite = "1688";

    public ProductRePostParam() {
        super();
        oceanApiId = new APIId("com.alibaba.product", "alibaba.product.repost", 1);
    }


}

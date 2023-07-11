// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductUnfollowCrossborderParam.java

package com.alibaba.product.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class AlibabaProductUnfollowCrossborderParam extends AbstractAPIRequest
{

    private Long productId;

    public AlibabaProductUnfollowCrossborderParam()
    {
        oceanApiId = new APIId("com.alibaba.product", "alibaba.product.unfollow.crossborder", 1);
    }

    public Long getProductId()
    {
        return productId;
    }

    public void setProductId(Long productId)
    {
        this.productId = productId;
    }
}

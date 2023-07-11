// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaAgentProductSimpleGetParam.java

package com.alibaba.product.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class AlibabaAgentProductSimpleGetParam extends AbstractAPIRequest
{

    private Long productID;
    private String webSite;

    public AlibabaAgentProductSimpleGetParam()
    {
        oceanApiId = new APIId("com.alibaba.product", "alibaba.agent.product.simple.get", 1);
    }

    public Long getProductID()
    {
        return productID;
    }

    public void setProductID(Long productID)
    {
        this.productID = productID;
    }

    public String getWebSite()
    {
        return webSite;
    }

    public void setWebSite(String webSite)
    {
        this.webSite = webSite;
    }
}

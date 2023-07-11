// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeGetSellerViewParam.java

package com.alibaba.trade.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class AlibabaTradeGetSellerViewParam extends AbstractAPIRequest
{

    private String webSite;
    private Long orderId;
    private String includeFields;

    public AlibabaTradeGetSellerViewParam()
    {
        oceanApiId = new APIId("com.alibaba.trade", "alibaba.trade.get.sellerView", 1);
    }

    public String getWebSite()
    {
        return webSite;
    }

    public void setWebSite(String webSite)
    {
        this.webSite = webSite;
    }

    public Long getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public String getIncludeFields()
    {
        return includeFields;
    }

    public void setIncludeFields(String includeFields)
    {
        this.includeFields = includeFields;
    }
}

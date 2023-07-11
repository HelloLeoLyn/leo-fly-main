// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeGetLogisticsInfosBuyerViewParam.java

package com.alibaba.logistics.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class AlibabaTradeGetLogisticsInfosBuyerViewParam extends AbstractAPIRequest
{

    private Long orderId;
    private String fields;
    private String webSite;

    public AlibabaTradeGetLogisticsInfosBuyerViewParam()
    {
        oceanApiId = new APIId("com.alibaba.logistics", "alibaba.trade.getLogisticsInfos.buyerView", 1);
    }

    public Long getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public String getFields()
    {
        return fields;
    }

    public void setFields(String fields)
    {
        this.fields = fields;
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

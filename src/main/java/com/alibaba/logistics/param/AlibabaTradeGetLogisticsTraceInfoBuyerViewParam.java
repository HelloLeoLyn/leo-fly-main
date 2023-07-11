// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeGetLogisticsTraceInfoBuyerViewParam.java

package com.alibaba.logistics.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class AlibabaTradeGetLogisticsTraceInfoBuyerViewParam extends AbstractAPIRequest
{

    private String logisticsId;
    private Long orderId;
    private String webSite;

    public AlibabaTradeGetLogisticsTraceInfoBuyerViewParam()
    {
        oceanApiId = new APIId("com.alibaba.logistics", "alibaba.trade.getLogisticsTraceInfo.buyerView", 1);
    }

    public String getLogisticsId()
    {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId)
    {
        this.logisticsId = logisticsId;
    }

    public Long getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
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

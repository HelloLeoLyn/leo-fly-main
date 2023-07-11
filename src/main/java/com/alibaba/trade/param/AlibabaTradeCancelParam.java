// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeCancelParam.java

package com.alibaba.trade.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class AlibabaTradeCancelParam extends AbstractAPIRequest
{

    private String webSite;
    private Long tradeID;
    private String cancelReason;
    private String remark;

    public AlibabaTradeCancelParam()
    {
        oceanApiId = new APIId("com.alibaba.trade", "alibaba.trade.cancel", 1);
    }

    public String getWebSite()
    {
        return webSite;
    }

    public void setWebSite(String webSite)
    {
        this.webSite = webSite;
    }

    public Long getTradeID()
    {
        return tradeID;
    }

    public void setTradeID(Long tradeID)
    {
        this.tradeID = tradeID;
    }

    public String getCancelReason()
    {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason)
    {
        this.cancelReason = cancelReason;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }
}

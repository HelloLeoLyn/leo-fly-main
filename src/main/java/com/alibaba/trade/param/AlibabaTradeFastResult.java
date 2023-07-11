// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeFastResult.java

package com.alibaba.trade.param;


// Referenced classes of package com.alibaba.trade.param:
//            AlibabaTradeFastOffer

public class AlibabaTradeFastResult
{

    private Long totalSuccessAmount;
    private String orderId;
    private AlibabaTradeFastOffer failedOfferList[];

    public AlibabaTradeFastResult()
    {
    }

    public Long getTotalSuccessAmount()
    {
        return totalSuccessAmount;
    }

    public void setTotalSuccessAmount(Long totalSuccessAmount)
    {
        this.totalSuccessAmount = totalSuccessAmount;
    }

    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public AlibabaTradeFastOffer[] getFailedOfferList()
    {
        return failedOfferList;
    }

    public void setFailedOfferList(AlibabaTradeFastOffer failedOfferList[])
    {
        this.failedOfferList = failedOfferList;
    }
}

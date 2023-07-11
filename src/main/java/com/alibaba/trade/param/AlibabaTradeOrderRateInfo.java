// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeOrderRateInfo.java

package com.alibaba.trade.param;


// Referenced classes of package com.alibaba.trade.param:
//            AlibabaOrderRateDetail

public class AlibabaTradeOrderRateInfo
{

    private Integer buyerRateStatus;
    private Integer sellerRateStatus;
    private AlibabaOrderRateDetail buyerRateList[];
    private AlibabaOrderRateDetail sellerRateList[];

    public AlibabaTradeOrderRateInfo()
    {
    }

    public Integer getBuyerRateStatus()
    {
        return buyerRateStatus;
    }

    public void setBuyerRateStatus(Integer buyerRateStatus)
    {
        this.buyerRateStatus = buyerRateStatus;
    }

    public Integer getSellerRateStatus()
    {
        return sellerRateStatus;
    }

    public void setSellerRateStatus(Integer sellerRateStatus)
    {
        this.sellerRateStatus = sellerRateStatus;
    }

    public AlibabaOrderRateDetail[] getBuyerRateList()
    {
        return buyerRateList;
    }

    public void setBuyerRateList(AlibabaOrderRateDetail buyerRateList[])
    {
        this.buyerRateList = buyerRateList;
    }

    public AlibabaOrderRateDetail[] getSellerRateList()
    {
        return sellerRateList;
    }

    public void setSellerRateList(AlibabaOrderRateDetail sellerRateList[])
    {
        this.sellerRateList = sellerRateList;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductProductShippingInfo.java

package com.alibaba.product.param;


public class AlibabaProductProductShippingInfo
{

    private Long freightTemplateID;
    private Double unitWeight;
    private String packageSize;
    private Integer volume;
    private Integer handlingTime;
    private Long sendGoodsAddressId;
    private String sendGoodsAddressText;

    public AlibabaProductProductShippingInfo()
    {
    }

    public Long getFreightTemplateID()
    {
        return freightTemplateID;
    }

    public void setFreightTemplateID(Long freightTemplateID)
    {
        this.freightTemplateID = freightTemplateID;
    }

    public Double getUnitWeight()
    {
        return unitWeight;
    }

    public void setUnitWeight(Double unitWeight)
    {
        this.unitWeight = unitWeight;
    }

    public String getPackageSize()
    {
        return packageSize;
    }

    public void setPackageSize(String packageSize)
    {
        this.packageSize = packageSize;
    }

    public Integer getVolume()
    {
        return volume;
    }

    public void setVolume(Integer volume)
    {
        this.volume = volume;
    }

    public Integer getHandlingTime()
    {
        return handlingTime;
    }

    public void setHandlingTime(Integer handlingTime)
    {
        this.handlingTime = handlingTime;
    }

    public Long getSendGoodsAddressId()
    {
        return sendGoodsAddressId;
    }

    public void setSendGoodsAddressId(Long sendGoodsAddressId)
    {
        this.sendGoodsAddressId = sendGoodsAddressId;
    }

    public String getSendGoodsAddressText()
    {
        return sendGoodsAddressText;
    }

    public void setSendGoodsAddressText(String sendGoodsAddressText)
    {
        this.sendGoodsAddressText = sendGoodsAddressText;
    }
}

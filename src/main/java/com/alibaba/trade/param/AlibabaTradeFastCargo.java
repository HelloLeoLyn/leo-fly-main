// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeFastCargo.java

package com.alibaba.trade.param;


public class AlibabaTradeFastCargo
{

    private Long offerId;
    private String specId;
    private Double quantity;

    public AlibabaTradeFastCargo()
    {
    }

    public Long getOfferId()
    {
        return offerId;
    }

    public void setOfferId(Long offerId)
    {
        this.offerId = offerId;
    }

    public String getSpecId()
    {
        return specId;
    }

    public void setSpecId(String specId)
    {
        this.specId = specId;
    }

    public Double getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Double quantity)
    {
        this.quantity = quantity;
    }
}

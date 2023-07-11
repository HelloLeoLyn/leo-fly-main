// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradePromotionModel.java

package com.alibaba.trade.param;


public class AlibabaTradePromotionModel
{

    private String promotionId;
    private Boolean selected;
    private String text;
    private String desc;
    private Boolean freePostage;
    private Long discountFee;

    public AlibabaTradePromotionModel()
    {
    }

    public String getPromotionId()
    {
        return promotionId;
    }

    public void setPromotionId(String promotionId)
    {
        this.promotionId = promotionId;
    }

    public Boolean getSelected()
    {
        return selected;
    }

    public void setSelected(Boolean selected)
    {
        this.selected = selected;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public Boolean getFreePostage()
    {
        return freePostage;
    }

    public void setFreePostage(Boolean freePostage)
    {
        this.freePostage = freePostage;
    }

    public Long getDiscountFee()
    {
        return discountFee;
    }

    public void setDiscountFee(Long discountFee)
    {
        this.discountFee = discountFee;
    }
}

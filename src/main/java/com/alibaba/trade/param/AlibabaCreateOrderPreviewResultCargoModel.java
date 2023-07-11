// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaCreateOrderPreviewResultCargoModel.java

package com.alibaba.trade.param;


// Referenced classes of package com.alibaba.trade.param:
//            AlibabaTradePromotionModel

public class AlibabaCreateOrderPreviewResultCargoModel
{

    private Double amount;
    private String message;
    private Double finalUnitPrice;
    private String specId;
    private Long skuId;
    private String resultCode;
    private Long offerId;
    private AlibabaTradePromotionModel cargoPromotionList[];

    public AlibabaCreateOrderPreviewResultCargoModel()
    {
    }

    public Double getAmount()
    {
        return amount;
    }

    public void setAmount(Double amount)
    {
        this.amount = amount;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Double getFinalUnitPrice()
    {
        return finalUnitPrice;
    }

    public void setFinalUnitPrice(Double finalUnitPrice)
    {
        this.finalUnitPrice = finalUnitPrice;
    }

    public String getSpecId()
    {
        return specId;
    }

    public void setSpecId(String specId)
    {
        this.specId = specId;
    }

    public Long getSkuId()
    {
        return skuId;
    }

    public void setSkuId(Long skuId)
    {
        this.skuId = skuId;
    }

    public String getResultCode()
    {
        return resultCode;
    }

    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }

    public Long getOfferId()
    {
        return offerId;
    }

    public void setOfferId(Long offerId)
    {
        this.offerId = offerId;
    }

    public AlibabaTradePromotionModel[] getCargoPromotionList()
    {
        return cargoPromotionList;
    }

    public void setCargoPromotionList(AlibabaTradePromotionModel cargoPromotionList[])
    {
        this.cargoPromotionList = cargoPromotionList;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaCreateOrderPreviewResultModel.java

package com.alibaba.trade.param;

import java.util.List;

// Referenced classes of package com.alibaba.trade.param:
//            AlibabaCreateOrderPreviewResultCargoModel, AlibabaTradePromotionModel

public class AlibabaCreateOrderPreviewResultModel
{

    private Long discountFee;
    private List tradeModeNameList;
    private Boolean status;
    private Boolean taoSampleSinglePromotion;
    private Long sumPayment;
    private String message;
    private Long sumCarriage;
    private String resultCode;
    private Long sumPaymentNoCarriage;
    private Long additionalFee;
    private String flowFlag;
    private AlibabaCreateOrderPreviewResultCargoModel cargoList[];
    private AlibabaTradePromotionModel shopPromotionList[];

    public AlibabaCreateOrderPreviewResultModel()
    {
    }

    public Long getDiscountFee()
    {
        return discountFee;
    }

    public void setDiscountFee(Long discountFee)
    {
        this.discountFee = discountFee;
    }

    public List getTradeModeNameList()
    {
        return tradeModeNameList;
    }

    public void setTradeModeNameList(List tradeModeNameList)
    {
        this.tradeModeNameList = tradeModeNameList;
    }

    public Boolean getStatus()
    {
        return status;
    }

    public void setStatus(Boolean status)
    {
        this.status = status;
    }

    public Boolean getTaoSampleSinglePromotion()
    {
        return taoSampleSinglePromotion;
    }

    public void setTaoSampleSinglePromotion(Boolean taoSampleSinglePromotion)
    {
        this.taoSampleSinglePromotion = taoSampleSinglePromotion;
    }

    public Long getSumPayment()
    {
        return sumPayment;
    }

    public void setSumPayment(Long sumPayment)
    {
        this.sumPayment = sumPayment;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Long getSumCarriage()
    {
        return sumCarriage;
    }

    public void setSumCarriage(Long sumCarriage)
    {
        this.sumCarriage = sumCarriage;
    }

    public String getResultCode()
    {
        return resultCode;
    }

    public void setResultCode(String resultCode)
    {
        this.resultCode = resultCode;
    }

    public Long getSumPaymentNoCarriage()
    {
        return sumPaymentNoCarriage;
    }

    public void setSumPaymentNoCarriage(Long sumPaymentNoCarriage)
    {
        this.sumPaymentNoCarriage = sumPaymentNoCarriage;
    }

    public Long getAdditionalFee()
    {
        return additionalFee;
    }

    public void setAdditionalFee(Long additionalFee)
    {
        this.additionalFee = additionalFee;
    }

    public String getFlowFlag()
    {
        return flowFlag;
    }

    public void setFlowFlag(String flowFlag)
    {
        this.flowFlag = flowFlag;
    }

    public AlibabaCreateOrderPreviewResultCargoModel[] getCargoList()
    {
        return cargoList;
    }

    public void setCargoList(AlibabaCreateOrderPreviewResultCargoModel cargoList[])
    {
        this.cargoList = cargoList;
    }

    public AlibabaTradePromotionModel[] getShopPromotionList()
    {
        return shopPromotionList;
    }

    public void setShopPromotionList(AlibabaTradePromotionModel shopPromotionList[])
    {
        this.shopPromotionList = shopPromotionList;
    }
}

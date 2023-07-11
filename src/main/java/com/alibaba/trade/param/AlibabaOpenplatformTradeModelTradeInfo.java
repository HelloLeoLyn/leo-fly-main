// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaOpenplatformTradeModelTradeInfo.java

package com.alibaba.trade.param;


// Referenced classes of package com.alibaba.trade.param:
//            AlibabaOpenplatformTradeModelGuaranteeTermsInfo, AlibabaOpenplatformTradeModelInternationalLogisticsInfo, AlibabaOpenplatformTradeModelNativeLogisticsInfo, AlibabaOpenplatformTradeModelProductItemInfo, 
//            AlibabaOpenplatformTradeModelTradeTermsInfo, AlibabaOpenplatformTradeKeyValuePair, AlibabaTradeOrderRateInfo, AlibabaInvoiceOrderInvoiceModel, 
//            AlibabaTradeCustoms, AlibabaTradeOverseasExtraAddress, AlibabaOpenplatformTradeModelOrderBaseInfo, AlibabaOrderBizInfo

public class AlibabaOpenplatformTradeModelTradeInfo
{

    private AlibabaOpenplatformTradeModelGuaranteeTermsInfo guaranteesTerms;
    private AlibabaOpenplatformTradeModelInternationalLogisticsInfo internationalLogistics;
    private AlibabaOpenplatformTradeModelNativeLogisticsInfo nativeLogistics;
    private AlibabaOpenplatformTradeModelProductItemInfo productItems[];
    private AlibabaOpenplatformTradeModelTradeTermsInfo tradeTerms[];
    private AlibabaOpenplatformTradeKeyValuePair extAttributes[];
    private AlibabaTradeOrderRateInfo orderRateInfo;
    private AlibabaInvoiceOrderInvoiceModel orderInvoiceInfo;
    private AlibabaTradeCustoms customs;
    private AlibabaTradeOverseasExtraAddress overseasExtraAddress;
    private AlibabaOpenplatformTradeModelOrderBaseInfo baseInfo;
    private AlibabaOrderBizInfo orderBizInfo;

    public AlibabaOpenplatformTradeModelTradeInfo()
    {
    }

    public AlibabaOpenplatformTradeModelGuaranteeTermsInfo getGuaranteesTerms()
    {
        return guaranteesTerms;
    }

    public void setGuaranteesTerms(AlibabaOpenplatformTradeModelGuaranteeTermsInfo guaranteesTerms)
    {
        this.guaranteesTerms = guaranteesTerms;
    }

    public AlibabaOpenplatformTradeModelInternationalLogisticsInfo getInternationalLogistics()
    {
        return internationalLogistics;
    }

    public void setInternationalLogistics(AlibabaOpenplatformTradeModelInternationalLogisticsInfo internationalLogistics)
    {
        this.internationalLogistics = internationalLogistics;
    }

    public AlibabaOpenplatformTradeModelNativeLogisticsInfo getNativeLogistics()
    {
        return nativeLogistics;
    }

    public void setNativeLogistics(AlibabaOpenplatformTradeModelNativeLogisticsInfo nativeLogistics)
    {
        this.nativeLogistics = nativeLogistics;
    }

    public AlibabaOpenplatformTradeModelProductItemInfo[] getProductItems()
    {
        return productItems;
    }

    public void setProductItems(AlibabaOpenplatformTradeModelProductItemInfo productItems[])
    {
        this.productItems = productItems;
    }

    public AlibabaOpenplatformTradeModelTradeTermsInfo[] getTradeTerms()
    {
        return tradeTerms;
    }

    public void setTradeTerms(AlibabaOpenplatformTradeModelTradeTermsInfo tradeTerms[])
    {
        this.tradeTerms = tradeTerms;
    }

    public AlibabaOpenplatformTradeKeyValuePair[] getExtAttributes()
    {
        return extAttributes;
    }

    public void setExtAttributes(AlibabaOpenplatformTradeKeyValuePair extAttributes[])
    {
        this.extAttributes = extAttributes;
    }

    public AlibabaTradeOrderRateInfo getOrderRateInfo()
    {
        return orderRateInfo;
    }

    public void setOrderRateInfo(AlibabaTradeOrderRateInfo orderRateInfo)
    {
        this.orderRateInfo = orderRateInfo;
    }

    public AlibabaInvoiceOrderInvoiceModel getOrderInvoiceInfo()
    {
        return orderInvoiceInfo;
    }

    public void setOrderInvoiceInfo(AlibabaInvoiceOrderInvoiceModel orderInvoiceInfo)
    {
        this.orderInvoiceInfo = orderInvoiceInfo;
    }

    public AlibabaTradeCustoms getCustoms()
    {
        return customs;
    }

    public void setCustoms(AlibabaTradeCustoms customs)
    {
        this.customs = customs;
    }

    public AlibabaTradeOverseasExtraAddress getOverseasExtraAddress()
    {
        return overseasExtraAddress;
    }

    public void setOverseasExtraAddress(AlibabaTradeOverseasExtraAddress overseasExtraAddress)
    {
        this.overseasExtraAddress = overseasExtraAddress;
    }

    public AlibabaOpenplatformTradeModelOrderBaseInfo getBaseInfo()
    {
        return baseInfo;
    }

    public void setBaseInfo(AlibabaOpenplatformTradeModelOrderBaseInfo baseInfo)
    {
        this.baseInfo = baseInfo;
    }

    public AlibabaOrderBizInfo getOrderBizInfo()
    {
        return orderBizInfo;
    }

    public void setOrderBizInfo(AlibabaOrderBizInfo orderBizInfo)
    {
        this.orderBizInfo = orderBizInfo;
    }
}

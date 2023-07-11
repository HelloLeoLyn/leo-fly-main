// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductProductInternationalTradeInfo.java

package com.alibaba.product.param;


public class AlibabaProductProductInternationalTradeInfo
{

    private String fobCurrency;
    private String fobMinPrice;
    private String fobMaxPrice;
    private String fobUnitType;
    private String paymentMethods[];
    private Integer minOrderQuantity;
    private String minOrderUnitType;
    private Integer supplyQuantity;
    private String supplyUnitType;
    private String supplyPeriodType;
    private String deliveryPort;
    private String deliveryTime;
    private Integer consignmentDate;
    private String packagingDesc;

    public AlibabaProductProductInternationalTradeInfo()
    {
    }

    public String getFobCurrency()
    {
        return fobCurrency;
    }

    public void setFobCurrency(String fobCurrency)
    {
        this.fobCurrency = fobCurrency;
    }

    public String getFobMinPrice()
    {
        return fobMinPrice;
    }

    public void setFobMinPrice(String fobMinPrice)
    {
        this.fobMinPrice = fobMinPrice;
    }

    public String getFobMaxPrice()
    {
        return fobMaxPrice;
    }

    public void setFobMaxPrice(String fobMaxPrice)
    {
        this.fobMaxPrice = fobMaxPrice;
    }

    public String getFobUnitType()
    {
        return fobUnitType;
    }

    public void setFobUnitType(String fobUnitType)
    {
        this.fobUnitType = fobUnitType;
    }

    public String[] getPaymentMethods()
    {
        return paymentMethods;
    }

    public void setPaymentMethods(String paymentMethods[])
    {
        this.paymentMethods = paymentMethods;
    }

    public Integer getMinOrderQuantity()
    {
        return minOrderQuantity;
    }

    public void setMinOrderQuantity(Integer minOrderQuantity)
    {
        this.minOrderQuantity = minOrderQuantity;
    }

    public String getMinOrderUnitType()
    {
        return minOrderUnitType;
    }

    public void setMinOrderUnitType(String minOrderUnitType)
    {
        this.minOrderUnitType = minOrderUnitType;
    }

    public Integer getSupplyQuantity()
    {
        return supplyQuantity;
    }

    public void setSupplyQuantity(Integer supplyQuantity)
    {
        this.supplyQuantity = supplyQuantity;
    }

    public String getSupplyUnitType()
    {
        return supplyUnitType;
    }

    public void setSupplyUnitType(String supplyUnitType)
    {
        this.supplyUnitType = supplyUnitType;
    }

    public String getSupplyPeriodType()
    {
        return supplyPeriodType;
    }

    public void setSupplyPeriodType(String supplyPeriodType)
    {
        this.supplyPeriodType = supplyPeriodType;
    }

    public String getDeliveryPort()
    {
        return deliveryPort;
    }

    public void setDeliveryPort(String deliveryPort)
    {
        this.deliveryPort = deliveryPort;
    }

    public String getDeliveryTime()
    {
        return deliveryTime;
    }

    public void setDeliveryTime(String deliveryTime)
    {
        this.deliveryTime = deliveryTime;
    }

    public Integer getConsignmentDate()
    {
        return consignmentDate;
    }

    public void setConsignmentDate(Integer consignmentDate)
    {
        this.consignmentDate = consignmentDate;
    }

    public String getPackagingDesc()
    {
        return packagingDesc;
    }

    public void setPackagingDesc(String packagingDesc)
    {
        this.packagingDesc = packagingDesc;
    }
}

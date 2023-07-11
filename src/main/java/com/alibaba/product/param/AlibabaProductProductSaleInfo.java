// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductProductSaleInfo.java

package com.alibaba.product.param;


// Referenced classes of package com.alibaba.product.param:
//            AlibabaProductProductPriceRange

public class AlibabaProductProductSaleInfo
{

    private Boolean supportOnlineTrade;
    private Boolean mixWholeSale;
    private String saleType;
    private Boolean priceAuth;
    private AlibabaProductProductPriceRange priceRanges[];
    private Double amountOnSale;
    private String unit;
    private Integer minOrderQuantity;
    private Integer batchNumber;
    private Double retailprice;
    private String tax;
    private String sellunit;
    private Integer quoteType;
    private Double consignPrice;

    public AlibabaProductProductSaleInfo()
    {
    }

    public Boolean getSupportOnlineTrade()
    {
        return supportOnlineTrade;
    }

    public void setSupportOnlineTrade(Boolean supportOnlineTrade)
    {
        this.supportOnlineTrade = supportOnlineTrade;
    }

    public Boolean getMixWholeSale()
    {
        return mixWholeSale;
    }

    public void setMixWholeSale(Boolean mixWholeSale)
    {
        this.mixWholeSale = mixWholeSale;
    }

    public String getSaleType()
    {
        return saleType;
    }

    public void setSaleType(String saleType)
    {
        this.saleType = saleType;
    }

    public Boolean getPriceAuth()
    {
        return priceAuth;
    }

    public void setPriceAuth(Boolean priceAuth)
    {
        this.priceAuth = priceAuth;
    }

    public AlibabaProductProductPriceRange[] getPriceRanges()
    {
        return priceRanges;
    }

    public void setPriceRanges(AlibabaProductProductPriceRange priceRanges[])
    {
        this.priceRanges = priceRanges;
    }

    public Double getAmountOnSale()
    {
        return amountOnSale;
    }

    public void setAmountOnSale(Double amountOnSale)
    {
        this.amountOnSale = amountOnSale;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public Integer getMinOrderQuantity()
    {
        return minOrderQuantity;
    }

    public void setMinOrderQuantity(Integer minOrderQuantity)
    {
        this.minOrderQuantity = minOrderQuantity;
    }

    public Integer getBatchNumber()
    {
        return batchNumber;
    }

    public void setBatchNumber(Integer batchNumber)
    {
        this.batchNumber = batchNumber;
    }

    public Double getRetailprice()
    {
        return retailprice;
    }

    public void setRetailprice(Double retailprice)
    {
        this.retailprice = retailprice;
    }

    public String getTax()
    {
        return tax;
    }

    public void setTax(String tax)
    {
        this.tax = tax;
    }

    public String getSellunit()
    {
        return sellunit;
    }

    public void setSellunit(String sellunit)
    {
        this.sellunit = sellunit;
    }

    public Integer getQuoteType()
    {
        return quoteType;
    }

    public void setQuoteType(Integer quoteType)
    {
        this.quoteType = quoteType;
    }

    public Double getConsignPrice()
    {
        return consignPrice;
    }

    public void setConsignPrice(Double consignPrice)
    {
        this.consignPrice = consignPrice;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductProductSKUInfo.java

package com.alibaba.product.param;


// Referenced classes of package com.alibaba.product.param:
//            AlibabaProductSKUAttrInfo, AlibabaProductProductPriceRange

public class AlibabaProductProductSKUInfo
{

    private AlibabaProductSKUAttrInfo attributes[];
    private String cargoNumber;
    private Integer amountOnSale;
    private Double retailPrice;
    private Double price;
    private AlibabaProductProductPriceRange priceRange[];
    private String skuCode;
    private Long skuId;
    private String specId;
    private Double consignPrice;

    public AlibabaProductProductSKUInfo()
    {
    }

    public AlibabaProductSKUAttrInfo[] getAttributes()
    {
        return attributes;
    }

    public void setAttributes(AlibabaProductSKUAttrInfo attributes[])
    {
        this.attributes = attributes;
    }

    public String getCargoNumber()
    {
        return cargoNumber;
    }

    public void setCargoNumber(String cargoNumber)
    {
        this.cargoNumber = cargoNumber;
    }

    public Integer getAmountOnSale()
    {
        return amountOnSale;
    }

    public void setAmountOnSale(Integer amountOnSale)
    {
        this.amountOnSale = amountOnSale;
    }

    public Double getRetailPrice()
    {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice)
    {
        this.retailPrice = retailPrice;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public AlibabaProductProductPriceRange[] getPriceRange()
    {
        return priceRange;
    }

    public void setPriceRange(AlibabaProductProductPriceRange priceRange[])
    {
        this.priceRange = priceRange;
    }

    public String getSkuCode()
    {
        return skuCode;
    }

    public void setSkuCode(String skuCode)
    {
        this.skuCode = skuCode;
    }

    public Long getSkuId()
    {
        return skuId;
    }

    public void setSkuId(Long skuId)
    {
        this.skuId = skuId;
    }

    public String getSpecId()
    {
        return specId;
    }

    public void setSpecId(String specId)
    {
        this.specId = specId;
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

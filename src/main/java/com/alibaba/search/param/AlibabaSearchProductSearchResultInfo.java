// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaSearchProductSearchResultInfo.java

package com.alibaba.search.param;


// Referenced classes of package com.alibaba.search.param:
//            AlibabaSearchProductBizGroupInfo

public class AlibabaSearchProductSearchResultInfo
{

    private Integer amountOnSale;
    private Double bookedCount;
    private Double brandBackRate;
    private Double brandBackRateMember;
    private Long categoryID;
    private String city;
    private String cityCode;
    private Double discountedPrice;
    private Double minPurchaseQuantity;
    private String picUrl;
    private Double price;
    private Long productID;
    private String proviceCode;
    private String province;
    private Double retailPrice;
    private Double saleQuantity;
    private String subject;
    private String unit;
    private AlibabaSearchProductBizGroupInfo bizGroupInfos[];

    public AlibabaSearchProductSearchResultInfo()
    {
    }

    public Integer getAmountOnSale()
    {
        return amountOnSale;
    }

    public void setAmountOnSale(Integer amountOnSale)
    {
        this.amountOnSale = amountOnSale;
    }

    public Double getBookedCount()
    {
        return bookedCount;
    }

    public void setBookedCount(Double bookedCount)
    {
        this.bookedCount = bookedCount;
    }

    public Double getBrandBackRate()
    {
        return brandBackRate;
    }

    public void setBrandBackRate(Double brandBackRate)
    {
        this.brandBackRate = brandBackRate;
    }

    public Double getBrandBackRateMember()
    {
        return brandBackRateMember;
    }

    public void setBrandBackRateMember(Double brandBackRateMember)
    {
        this.brandBackRateMember = brandBackRateMember;
    }

    public Long getCategoryID()
    {
        return categoryID;
    }

    public void setCategoryID(Long categoryID)
    {
        this.categoryID = categoryID;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getCityCode()
    {
        return cityCode;
    }

    public void setCityCode(String cityCode)
    {
        this.cityCode = cityCode;
    }

    public Double getDiscountedPrice()
    {
        return discountedPrice;
    }

    public void setDiscountedPrice(Double discountedPrice)
    {
        this.discountedPrice = discountedPrice;
    }

    public Double getMinPurchaseQuantity()
    {
        return minPurchaseQuantity;
    }

    public void setMinPurchaseQuantity(Double minPurchaseQuantity)
    {
        this.minPurchaseQuantity = minPurchaseQuantity;
    }

    public String getPicUrl()
    {
        return picUrl;
    }

    public void setPicUrl(String picUrl)
    {
        this.picUrl = picUrl;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Long getProductID()
    {
        return productID;
    }

    public void setProductID(Long productID)
    {
        this.productID = productID;
    }

    public String getProviceCode()
    {
        return proviceCode;
    }

    public void setProviceCode(String proviceCode)
    {
        this.proviceCode = proviceCode;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public Double getRetailPrice()
    {
        return retailPrice;
    }

    public void setRetailPrice(Double retailPrice)
    {
        this.retailPrice = retailPrice;
    }

    public Double getSaleQuantity()
    {
        return saleQuantity;
    }

    public void setSaleQuantity(Double saleQuantity)
    {
        this.saleQuantity = saleQuantity;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public AlibabaSearchProductBizGroupInfo[] getBizGroupInfos()
    {
        return bizGroupInfos;
    }

    public void setBizGroupInfos(AlibabaSearchProductBizGroupInfo bizGroupInfos[])
    {
        this.bizGroupInfos = bizGroupInfos;
    }
}

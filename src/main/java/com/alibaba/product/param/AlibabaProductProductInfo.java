// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductProductInfo.java

package com.alibaba.product.param;

import java.util.Date;

// Referenced classes of package com.alibaba.product.param:
//            AlibabaProductProductAttribute, AlibabaProductProductImageInfo, AlibabaProductProductSKUInfo, AlibabaProductProductSaleInfo, 
//            AlibabaProductProductShippingInfo, AlibabaProductProductInternationalTradeInfo, AlibabaProductProductExtendInfo

public class AlibabaProductProductInfo
{

    private Long productID;
    private String productType;
    private Long categoryID;
    private AlibabaProductProductAttribute attributes[];
    private long groupID[];
    private String status;
    private String subject;
    private String description;
    private String language;
    private Integer periodOfValidity;
    private Integer bizType;
    private Boolean pictureAuth;
    private AlibabaProductProductImageInfo image;
    private AlibabaProductProductSKUInfo skuInfos[];
    private AlibabaProductProductSaleInfo saleInfo;
    private AlibabaProductProductShippingInfo shippingInfo;
    private AlibabaProductProductInternationalTradeInfo internationalTradeInfo;
    private AlibabaProductProductExtendInfo extendInfos[];
    private String supplierUserId;
    private Integer qualityLevel;
    private String supplierLoginId;
    private String categoryName;
    private String mainVedio;
    private String productCargoNumber;
    private Boolean crossBorderOffer;
    private String referencePrice;
    private Date createTime;
    private Date lastUpdateTime;
    private Date expireTime;
    private Date modifyTime;
    private Date approvedTime;
    private Date lastRepostTime;

    public AlibabaProductProductInfo()
    {
    }

    public Long getProductID()
    {
        return productID;
    }

    public void setProductID(Long productID)
    {
        this.productID = productID;
    }

    public String getProductType()
    {
        return productType;
    }

    public void setProductType(String productType)
    {
        this.productType = productType;
    }

    public Long getCategoryID()
    {
        return categoryID;
    }

    public void setCategoryID(Long categoryID)
    {
        this.categoryID = categoryID;
    }

    public AlibabaProductProductAttribute[] getAttributes()
    {
        return attributes;
    }

    public void setAttributes(AlibabaProductProductAttribute attributes[])
    {
        this.attributes = attributes;
    }

    public long[] getGroupID()
    {
        return groupID;
    }

    public void setGroupID(long groupID[])
    {
        this.groupID = groupID;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getSubject()
    {
        return subject;
    }

    public void setSubject(String subject)
    {
        this.subject = subject;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public Integer getPeriodOfValidity()
    {
        return periodOfValidity;
    }

    public void setPeriodOfValidity(Integer periodOfValidity)
    {
        this.periodOfValidity = periodOfValidity;
    }

    public Integer getBizType()
    {
        return bizType;
    }

    public void setBizType(Integer bizType)
    {
        this.bizType = bizType;
    }

    public Boolean getPictureAuth()
    {
        return pictureAuth;
    }

    public void setPictureAuth(Boolean pictureAuth)
    {
        this.pictureAuth = pictureAuth;
    }

    public AlibabaProductProductImageInfo getImage()
    {
        return image;
    }

    public void setImage(AlibabaProductProductImageInfo image)
    {
        this.image = image;
    }

    public AlibabaProductProductSKUInfo[] getSkuInfos()
    {
        return skuInfos;
    }

    public void setSkuInfos(AlibabaProductProductSKUInfo skuInfos[])
    {
        this.skuInfos = skuInfos;
    }

    public AlibabaProductProductSaleInfo getSaleInfo()
    {
        return saleInfo;
    }

    public void setSaleInfo(AlibabaProductProductSaleInfo saleInfo)
    {
        this.saleInfo = saleInfo;
    }

    public AlibabaProductProductShippingInfo getShippingInfo()
    {
        return shippingInfo;
    }

    public void setShippingInfo(AlibabaProductProductShippingInfo shippingInfo)
    {
        this.shippingInfo = shippingInfo;
    }

    public AlibabaProductProductInternationalTradeInfo getInternationalTradeInfo()
    {
        return internationalTradeInfo;
    }

    public void setInternationalTradeInfo(AlibabaProductProductInternationalTradeInfo internationalTradeInfo)
    {
        this.internationalTradeInfo = internationalTradeInfo;
    }

    public AlibabaProductProductExtendInfo[] getExtendInfos()
    {
        return extendInfos;
    }

    public void setExtendInfos(AlibabaProductProductExtendInfo extendInfos[])
    {
        this.extendInfos = extendInfos;
    }

    public String getSupplierUserId()
    {
        return supplierUserId;
    }

    public void setSupplierUserId(String supplierUserId)
    {
        this.supplierUserId = supplierUserId;
    }

    public Integer getQualityLevel()
    {
        return qualityLevel;
    }

    public void setQualityLevel(Integer qualityLevel)
    {
        this.qualityLevel = qualityLevel;
    }

    public String getSupplierLoginId()
    {
        return supplierLoginId;
    }

    public void setSupplierLoginId(String supplierLoginId)
    {
        this.supplierLoginId = supplierLoginId;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public void setCategoryName(String categoryName)
    {
        this.categoryName = categoryName;
    }

    public String getMainVedio()
    {
        return mainVedio;
    }

    public void setMainVedio(String mainVedio)
    {
        this.mainVedio = mainVedio;
    }

    public String getProductCargoNumber()
    {
        return productCargoNumber;
    }

    public void setProductCargoNumber(String productCargoNumber)
    {
        this.productCargoNumber = productCargoNumber;
    }

    public Boolean getCrossBorderOffer()
    {
        return crossBorderOffer;
    }

    public void setCrossBorderOffer(Boolean crossBorderOffer)
    {
        this.crossBorderOffer = crossBorderOffer;
    }

    public String getReferencePrice()
    {
        return referencePrice;
    }

    public void setReferencePrice(String referencePrice)
    {
        this.referencePrice = referencePrice;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime()
    {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime)
    {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getExpireTime()
    {
        return expireTime;
    }

    public void setExpireTime(Date expireTime)
    {
        this.expireTime = expireTime;
    }

    public Date getModifyTime()
    {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime)
    {
        this.modifyTime = modifyTime;
    }

    public Date getApprovedTime()
    {
        return approvedTime;
    }

    public void setApprovedTime(Date approvedTime)
    {
        this.approvedTime = approvedTime;
    }

    public Date getLastRepostTime()
    {
        return lastRepostTime;
    }

    public void setLastRepostTime(Date lastRepostTime)
    {
        this.lastRepostTime = lastRepostTime;
    }
}

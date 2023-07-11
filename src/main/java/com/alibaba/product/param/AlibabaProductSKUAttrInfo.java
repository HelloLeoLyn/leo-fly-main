// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductSKUAttrInfo.java

package com.alibaba.product.param;


public class AlibabaProductSKUAttrInfo
{

    private Long attributeID;
    private Long attValueID;
    private String attributeValue;
    private String customValueName;
    private String skuImageUrl;
    private String attributeDisplayName;

    public AlibabaProductSKUAttrInfo()
    {
    }

    public Long getAttributeID()
    {
        return attributeID;
    }

    public void setAttributeID(Long attributeID)
    {
        this.attributeID = attributeID;
    }

    public Long getAttValueID()
    {
        return attValueID;
    }

    public void setAttValueID(Long attValueID)
    {
        this.attValueID = attValueID;
    }

    public String getAttributeValue()
    {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue)
    {
        this.attributeValue = attributeValue;
    }

    public String getCustomValueName()
    {
        return customValueName;
    }

    public void setCustomValueName(String customValueName)
    {
        this.customValueName = customValueName;
    }

    public String getSkuImageUrl()
    {
        return skuImageUrl;
    }

    public void setSkuImageUrl(String skuImageUrl)
    {
        this.skuImageUrl = skuImageUrl;
    }

    public String getAttributeDisplayName()
    {
        return attributeDisplayName;
    }

    public void setAttributeDisplayName(String attributeDisplayName)
    {
        this.attributeDisplayName = attributeDisplayName;
    }
}

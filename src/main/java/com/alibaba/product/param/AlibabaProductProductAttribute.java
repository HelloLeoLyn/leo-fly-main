// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductProductAttribute.java

package com.alibaba.product.param;


public class AlibabaProductProductAttribute
{

    private Long attributeID;
    private String attributeName;
    private Long valueID;
    private String value;
    private Boolean isCustom;

    public AlibabaProductProductAttribute()
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

    public String getAttributeName()
    {
        return attributeName;
    }

    public void setAttributeName(String attributeName)
    {
        this.attributeName = attributeName;
    }

    public Long getValueID()
    {
        return valueID;
    }

    public void setValueID(Long valueID)
    {
        this.valueID = valueID;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public Boolean getIsCustom()
    {
        return isCustom;
    }

    public void setIsCustom(Boolean isCustom)
    {
        this.isCustom = isCustom;
    }
}

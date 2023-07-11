// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeReceiveAddressItem.java

package com.alibaba.trade.param;


public class AlibabaTradeReceiveAddressItem
{

    private Long id;
    private String fullName;
    private String address;
    private String post;
    private String phone;
    private String mobilePhone;
    private String addressCode;
    private String addressCodeText;
    private Boolean isDefault;
    private String townCode;
    private String townName;

    public AlibabaTradeReceiveAddressItem()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFullName()
    {
        return fullName;
    }

    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPost()
    {
        return post;
    }

    public void setPost(String post)
    {
        this.post = post;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getMobilePhone()
    {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone)
    {
        this.mobilePhone = mobilePhone;
    }

    public String getAddressCode()
    {
        return addressCode;
    }

    public void setAddressCode(String addressCode)
    {
        this.addressCode = addressCode;
    }

    public String getAddressCodeText()
    {
        return addressCodeText;
    }

    public void setAddressCodeText(String addressCodeText)
    {
        this.addressCodeText = addressCodeText;
    }

    public Boolean getIsDefault()
    {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault)
    {
        this.isDefault = isDefault;
    }

    public String getTownCode()
    {
        return townCode;
    }

    public void setTownCode(String townCode)
    {
        this.townCode = townCode;
    }

    public String getTownName()
    {
        return townName;
    }

    public void setTownName(String townName)
    {
        this.townName = townName;
    }
}

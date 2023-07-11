// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaOpenplatformTradeModelNativeLogisticsInfo.java

package com.alibaba.trade.param;


// Referenced classes of package com.alibaba.trade.param:
//            AlibabaOpenplatformTradeModelNativeLogisticsItemsInfo

public class AlibabaOpenplatformTradeModelNativeLogisticsInfo
{

    private String address;
    private String area;
    private String areaCode;
    private String city;
    private String contactPerson;
    private String fax;
    private String mobile;
    private String province;
    private String telephone;
    private String zip;
    private AlibabaOpenplatformTradeModelNativeLogisticsItemsInfo logisticsItems[];
    private String townCode;
    private String town;

    public AlibabaOpenplatformTradeModelNativeLogisticsInfo()
    {
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getArea()
    {
        return area;
    }

    public void setArea(String area)
    {
        this.area = area;
    }

    public String getAreaCode()
    {
        return areaCode;
    }

    public void setAreaCode(String areaCode)
    {
        this.areaCode = areaCode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getContactPerson()
    {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson)
    {
        this.contactPerson = contactPerson;
    }

    public String getFax()
    {
        return fax;
    }

    public void setFax(String fax)
    {
        this.fax = fax;
    }

    public String getMobile()
    {
        return mobile;
    }

    public void setMobile(String mobile)
    {
        this.mobile = mobile;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public String getZip()
    {
        return zip;
    }

    public void setZip(String zip)
    {
        this.zip = zip;
    }

    public AlibabaOpenplatformTradeModelNativeLogisticsItemsInfo[] getLogisticsItems()
    {
        return logisticsItems;
    }

    public void setLogisticsItems(AlibabaOpenplatformTradeModelNativeLogisticsItemsInfo logisticsItems[])
    {
        this.logisticsItems = logisticsItems;
    }

    public String getTownCode()
    {
        return townCode;
    }

    public void setTownCode(String townCode)
    {
        this.townCode = townCode;
    }

    public String getTown()
    {
        return town;
    }

    public void setTown(String town)
    {
        this.town = town;
    }
}

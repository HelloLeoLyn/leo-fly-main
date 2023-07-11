// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductPushUserShop.java

package com.alibaba.product.push.param;


// Referenced classes of package com.alibaba.product.push.param:
//            AlibabaProductPushIdentity

public class AlibabaProductPushUserShop
{

    private String description;
    private String name;
    private String shopUrl;
    private AlibabaProductPushIdentity userIdentityInPartner;
    private AlibabaProductPushIdentity userIdentityInTargetPlatform;

    public AlibabaProductPushUserShop()
    {
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getShopUrl()
    {
        return shopUrl;
    }

    public void setShopUrl(String shopUrl)
    {
        this.shopUrl = shopUrl;
    }

    public AlibabaProductPushIdentity getUserIdentityInPartner()
    {
        return userIdentityInPartner;
    }

    public void setUserIdentityInPartner(AlibabaProductPushIdentity userIdentityInPartner)
    {
        this.userIdentityInPartner = userIdentityInPartner;
    }

    public AlibabaProductPushIdentity getUserIdentityInTargetPlatform()
    {
        return userIdentityInTargetPlatform;
    }

    public void setUserIdentityInTargetPlatform(AlibabaProductPushIdentity userIdentityInTargetPlatform)
    {
        this.userIdentityInTargetPlatform = userIdentityInTargetPlatform;
    }
}

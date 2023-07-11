// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductPushUserPlatformDetail.java

package com.alibaba.product.push.param;


// Referenced classes of package com.alibaba.product.push.param:
//            AlibabaProductPushUserPlatform, AlibabaProductPushUserShopDetail

public class AlibabaProductPushUserPlatformDetail
{

    private AlibabaProductPushUserPlatform userPlatform;
    private AlibabaProductPushUserShopDetail userShopDetail[];

    public AlibabaProductPushUserPlatformDetail()
    {
    }

    public AlibabaProductPushUserPlatform getUserPlatform()
    {
        return userPlatform;
    }

    public void setUserPlatform(AlibabaProductPushUserPlatform userPlatform)
    {
        this.userPlatform = userPlatform;
    }

    public AlibabaProductPushUserShopDetail[] getUserShopDetail()
    {
        return userShopDetail;
    }

    public void setUserShopDetail(AlibabaProductPushUserShopDetail userShopDetail[])
    {
        this.userShopDetail = userShopDetail;
    }
}

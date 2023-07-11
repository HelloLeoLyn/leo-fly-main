// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductPushUserShopDetail.java

package com.alibaba.product.push.param;

import java.util.Date;

// Referenced classes of package com.alibaba.product.push.param:
//            AlibabaProductPushUserShop

public class AlibabaProductPushUserShopDetail
{

    private String authState;
    private Date authStartTime;
    private Date authExpiredTime;
    private AlibabaProductPushUserShop userShop;

    public AlibabaProductPushUserShopDetail()
    {
    }

    public String getAuthState()
    {
        return authState;
    }

    public void setAuthState(String authState)
    {
        this.authState = authState;
    }

    public Date getAuthStartTime()
    {
        return authStartTime;
    }

    public void setAuthStartTime(Date authStartTime)
    {
        this.authStartTime = authStartTime;
    }

    public Date getAuthExpiredTime()
    {
        return authExpiredTime;
    }

    public void setAuthExpiredTime(Date authExpiredTime)
    {
        this.authExpiredTime = authExpiredTime;
    }

    public AlibabaProductPushUserShop getUserShop()
    {
        return userShop;
    }

    public void setUserShop(AlibabaProductPushUserShop userShop)
    {
        this.userShop = userShop;
    }
}

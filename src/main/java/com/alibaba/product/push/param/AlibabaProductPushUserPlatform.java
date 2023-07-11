// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductPushUserPlatform.java

package com.alibaba.product.push.param;

import java.util.Date;

// Referenced classes of package com.alibaba.product.push.param:
//            AlibabaProductPushPlatformDefinition, AlibabaProductPushUserDefinition

public class AlibabaProductPushUserPlatform
{

    private Boolean supported;
    private AlibabaProductPushPlatformDefinition platformDefinition;
    private AlibabaProductPushUserDefinition userDefinition;
    private Date anthTime;

    public AlibabaProductPushUserPlatform()
    {
    }

    public Boolean getSupported()
    {
        return supported;
    }

    public void setSupported(Boolean supported)
    {
        this.supported = supported;
    }

    public AlibabaProductPushPlatformDefinition getPlatformDefinition()
    {
        return platformDefinition;
    }

    public void setPlatformDefinition(AlibabaProductPushPlatformDefinition platformDefinition)
    {
        this.platformDefinition = platformDefinition;
    }

    public AlibabaProductPushUserDefinition getUserDefinition()
    {
        return userDefinition;
    }

    public void setUserDefinition(AlibabaProductPushUserDefinition userDefinition)
    {
        this.userDefinition = userDefinition;
    }

    public Date getAnthTime()
    {
        return anthTime;
    }

    public void setAnthTime(Date anthTime)
    {
        this.anthTime = anthTime;
    }
}

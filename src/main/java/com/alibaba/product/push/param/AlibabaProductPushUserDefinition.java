// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductPushUserDefinition.java

package com.alibaba.product.push.param;


// Referenced classes of package com.alibaba.product.push.param:
//            AlibabaProductPushIdentity

public class AlibabaProductPushUserDefinition
{

    private AlibabaProductPushIdentity identity;
    private AlibabaProductPushIdentity identityInPartner;
    private AlibabaProductPushIdentity identityInTargetPlatform;

    public AlibabaProductPushUserDefinition()
    {
    }

    public AlibabaProductPushIdentity getIdentity()
    {
        return identity;
    }

    public void setIdentity(AlibabaProductPushIdentity identity)
    {
        this.identity = identity;
    }

    public AlibabaProductPushIdentity getIdentityInPartner()
    {
        return identityInPartner;
    }

    public void setIdentityInPartner(AlibabaProductPushIdentity identityInPartner)
    {
        this.identityInPartner = identityInPartner;
    }

    public AlibabaProductPushIdentity getIdentityInTargetPlatform()
    {
        return identityInTargetPlatform;
    }

    public void setIdentityInTargetPlatform(AlibabaProductPushIdentity identityInTargetPlatform)
    {
        this.identityInTargetPlatform = identityInTargetPlatform;
    }
}

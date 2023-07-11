// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaProductPushSyncUserPlatformListParam.java

package com.alibaba.product.push.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

// Referenced classes of package com.alibaba.product.push.param:
//            AlibabaProductPushUserPlatformDetail

public class AlibabaProductPushSyncUserPlatformListParam extends AbstractAPIRequest
{

    private AlibabaProductPushUserPlatformDetail userPlatformDetails[];

    public AlibabaProductPushSyncUserPlatformListParam()
    {
        oceanApiId = new APIId("com.alibaba.product.push", "alibaba.product.push.syncUserPlatformList", 1);
    }

    public AlibabaProductPushUserPlatformDetail[] getUserPlatformDetails()
    {
        return userPlatformDetails;
    }

    public void setUserPlatformDetails(AlibabaProductPushUserPlatformDetail userPlatformDetails[])
    {
        this.userPlatformDetails = userPlatformDetails;
    }
}

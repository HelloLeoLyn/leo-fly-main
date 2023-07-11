// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   APIClient.java

package com.alibaba.ocean.rawsdk.client;

import com.alibaba.ocean.rawsdk.client.entity.AuthorizationToken;
import com.alibaba.ocean.rawsdk.client.exception.OceanException;
import com.alibaba.ocean.rawsdk.client.policy.RequestPolicy;

// Referenced classes of package com.alibaba.ocean.rawsdk.client:
//            Request

public interface APIClient
{

    public abstract Object send(Request request, Class class1, RequestPolicy requestpolicy)
        throws OceanException;

    public abstract AuthorizationToken getToken(String s)
        throws OceanException;

    public abstract AuthorizationToken refreshToken(String s)
        throws OceanException;

    public abstract void start();

    public abstract void shutdown();
}

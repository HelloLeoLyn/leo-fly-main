// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AuthorizationTokenStore.java

package com.alibaba.ocean.rawsdk.client.entity;


// Referenced classes of package com.alibaba.ocean.rawsdk.client.entity:
//            AuthorizationToken

public interface AuthorizationTokenStore
{

    public abstract AuthorizationToken getToken(String s);

    public abstract void storeToken(String s, AuthorizationToken authorizationtoken);

    public abstract void removeToken(String s);

    public abstract void storeAccessToken(String s, AuthorizationToken authorizationtoken);

    public abstract AuthorizationToken getAccessToken(String s);
}

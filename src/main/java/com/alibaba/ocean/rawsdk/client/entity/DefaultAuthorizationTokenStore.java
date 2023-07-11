// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   DefaultAuthorizationTokenStore.java

package com.alibaba.ocean.rawsdk.client.entity;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.alibaba.ocean.rawsdk.client.entity:
//            AuthorizationToken, AuthorizationTokenStore

public class DefaultAuthorizationTokenStore
    implements AuthorizationTokenStore
{

    private Map cache;

    public DefaultAuthorizationTokenStore()
    {
        cache = new HashMap();
    }

    public AuthorizationToken getToken(String authorizationCode)
    {
        return (AuthorizationToken)cache.get(authorizationCode);
    }

    public void storeToken(String authorizationCode, AuthorizationToken token)
    {
        cache.put(authorizationCode, token);
    }

    public void removeToken(String authorizationCode)
    {
        cache.remove(authorizationCode);
    }

    public void storeAccessToken(String uid, AuthorizationToken token)
    {
        cache.put(uid, token);
    }

    public AuthorizationToken getAccessToken(String uid)
    {
        return (AuthorizationToken)cache.get(uid);
    }
}

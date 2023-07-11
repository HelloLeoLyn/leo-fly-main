// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst
// Source File Name:   ApiExecutor.java

package com.alibaba.ocean.rawsdk;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.client.AlibabaClientFactory;
import com.alibaba.ocean.rawsdk.client.Request;
import com.alibaba.ocean.rawsdk.client.SDKListener;
import com.alibaba.ocean.rawsdk.client.SyncAPIClient;
import com.alibaba.ocean.rawsdk.client.entity.AuthorizationToken;
import com.alibaba.ocean.rawsdk.client.entity.AuthorizationTokenStore;
import com.alibaba.ocean.rawsdk.client.entity.DefaultAuthorizationTokenStore;
import com.alibaba.ocean.rawsdk.client.exception.OceanException;
import com.alibaba.ocean.rawsdk.client.policy.ClientPolicy;
import com.alibaba.ocean.rawsdk.client.serialize.DeSerializerListener;
import com.alibaba.ocean.rawsdk.client.serialize.SerializerListener;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;
import com.alibaba.ocean.rawsdk.common.SDKResult;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ApiExecutor
    implements SDKListener
{

    private String serverHost;
    private int httpPort;
    private int httpsPort;
    private String appKey;
    private String secKey;
    private AuthorizationTokenStore authorizationTokenStore;
    private Map serializerListeners;
    private Map deSerializerListeners;

    public ApiExecutor(String appKey, String secKey)
    {
        serverHost = "gw.open.1688.com";
        httpPort = 80;
        httpsPort = 443;
        serializerListeners = new LinkedHashMap();
        deSerializerListeners = new LinkedHashMap();
        this.appKey = appKey;
        this.secKey = secKey;
    }

    public ApiExecutor(String serverHost, int httpPort, int httpsPort, String appKey, String secKey)
    {
        this.serverHost = "gw.open.1688.com";
        this.httpPort = 80;
        this.httpsPort = 443;
        serializerListeners = new LinkedHashMap();
        deSerializerListeners = new LinkedHashMap();
        this.serverHost = serverHost;
        this.httpPort = httpPort;
        this.httpsPort = httpsPort;
        this.appKey = appKey;
        this.secKey = secKey;
    }

    public void register(SerializerListener serializerListener)
    {
        serializerListeners.put(serializerListener.getClass(), serializerListener);
    }

    public void register(DeSerializerListener deSerializerListener)
    {
        deSerializerListeners.put(deSerializerListener.getClass(), deSerializerListener);
    }

    private SyncAPIClient getAPIClient()
    {
        ClientPolicy clientPolicy = new ClientPolicy(serverHost);
        clientPolicy.setHttpPort(Integer.valueOf(httpPort));
        clientPolicy.setHttpsPort(Integer.valueOf(httpsPort));
        if(appKey != null)
            clientPolicy.setAppKey(appKey);
        if(secKey != null)
            clientPolicy.setSigningKey(secKey);
        if(authorizationTokenStore == null)
            authorizationTokenStore = new DefaultAuthorizationTokenStore();
        SyncAPIClient syncAPIClient = (new AlibabaClientFactory()).createAPIClient(clientPolicy, authorizationTokenStore);
        return syncAPIClient;
    }

    public final AuthorizationToken getToken(String code)
    {
        try
        {
            return getAPIClient().getToken(code);
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public final AuthorizationToken refreshToken(String refreshToken)
    {
        try
        {
            return getAPIClient().refreshToken(refreshToken);
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public final SDKResult execute(AbstractAPIRequest apiRequest)
    {
        com.alibaba.ocean.rawsdk.client.policy.RequestPolicy reqPolicy = apiRequest.getOceanRequestPolicy();
        try
        {
            APIId apiId = apiRequest.getOceanApiId();
            Request req = new Request(apiId.getNamespace(), apiId.getName(), apiId.getVersion());
            req.setRequestEntity(apiRequest);
            Object ret = getAPIClient().send(req, apiRequest.getResponseClass(), reqPolicy, serializerListeners.values(), deSerializerListeners.values());
            return new SDKResult(ret);
        }
        catch(OceanException e)
        {
            return new SDKResult(e.getErrorCode(), e.getErrorMessage());
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public final SDKResult execute(AbstractAPIRequest apiRequest, String accessToken)
    {
        com.alibaba.ocean.rawsdk.client.policy.RequestPolicy reqPolicy = apiRequest.getOceanRequestPolicy();
        try
        {
            APIId apiId = apiRequest.getOceanApiId();
            Request req = new Request(apiId.getNamespace(), apiId.getName(), apiId.getVersion());
            req.setRequestEntity(apiRequest);
            req.setAccessToken(accessToken);
            Object ret = getAPIClient().send(req, apiRequest.getResponseClass(), reqPolicy, serializerListeners.values(), deSerializerListeners.values());
            return new SDKResult(ret);
        }
        catch(OceanException e)
        {
            return new SDKResult(e.getErrorCode(), e.getErrorMessage());
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}

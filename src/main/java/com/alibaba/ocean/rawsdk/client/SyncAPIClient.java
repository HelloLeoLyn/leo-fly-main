// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst
// Source File Name:   SyncAPIClient.java

package com.alibaba.ocean.rawsdk.client;

import com.alibaba.ocean.rawsdk.client.entity.AuthorizationToken;
import com.alibaba.ocean.rawsdk.client.entity.AuthorizationTokenStore;
import com.alibaba.ocean.rawsdk.client.entity.DefaultAuthorizationTokenStore;
import com.alibaba.ocean.rawsdk.client.exception.OceanException;
import com.alibaba.ocean.rawsdk.client.http.AbstractHttpClient;
import com.alibaba.ocean.rawsdk.client.http.InvokeContext;
import com.alibaba.ocean.rawsdk.client.http.platform.DefaultHttpResponseBuilder;
import com.alibaba.ocean.rawsdk.client.http.platform.HttpURLConnectionClient;
import com.alibaba.ocean.rawsdk.client.policy.ClientPolicy;
import com.alibaba.ocean.rawsdk.client.policy.RequestPolicy;
import com.alibaba.ocean.rawsdk.client.serialize.SerializerProvider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

// Referenced classes of package com.alibaba.ocean.rawsdk.client:
//            Request, Response

public class SyncAPIClient
{

    private AbstractHttpClient httpClient;
    private ClientPolicy clientPolicy;
    private AuthorizationTokenStore authorizationTokenStore;

    public SyncAPIClient(ClientPolicy clientPolicy, SerializerProvider serializerProvider)
    {
        this(clientPolicy, serializerProvider, ((AuthorizationTokenStore) (new DefaultAuthorizationTokenStore())));
    }

    public SyncAPIClient(ClientPolicy clientPolicy, SerializerProvider serializerProvider, AuthorizationTokenStore authorizationTokenStore)
    {
        this.clientPolicy = clientPolicy;
        this.authorizationTokenStore = authorizationTokenStore;
        com.alibaba.ocean.rawsdk.client.http.HttpResponseBuilder httpResponseBuilder = new DefaultHttpResponseBuilder(clientPolicy, serializerProvider);
        httpClient = new HttpURLConnectionClient(serializerProvider, httpResponseBuilder);
    }

    public Object send(Request request, Class resultType, RequestPolicy policy)
        throws OceanException
    {
        return null;
    }

    public Object send(Request request, Class resultType, RequestPolicy policy, Collection serializerListners, Collection deSerializerListners)
        throws OceanException
    {
        InvokeContext invokeContext = new InvokeContext();
        invokeContext.setPolicy(policy);
        invokeContext.setRequest(request);
        invokeContext.setResultType(resultType);
        try
        {
            httpClient.request(invokeContext, clientPolicy, serializerListners, deSerializerListners);
            if(invokeContext.getResponse().getException() != null)
            {
                Throwable responseException = invokeContext.getResponse().getException();
                if(responseException instanceof OceanException)
                    throw (OceanException)responseException;
                else
                    throw new OceanException(responseException);
            } else
            {
                return invokeContext.getResponse().getResult();
            }
        }
        catch(IOException e)
        {
            throw new OceanException(e);
        }
    }

    public void start()
    {
    }

    public void shutdown()
    {
    }

    public AuthorizationToken getToken(String code)
        throws OceanException
    {
        Request request = new Request("system.oauth2", "getToken");
        request.addAddtionalParams("code", code);
        request.addAddtionalParams("grant_type", "authorization_code");
        request.addAddtionalParams("need_refresh_token", Boolean.valueOf(true));
        request.addAddtionalParams("client_id", clientPolicy.getAppKey());
        request.addAddtionalParams("client_secret", clientPolicy.getSigningKey());
        request.addAddtionalParams("redirect_uri", "default");
        RequestPolicy oauthPolicy = RequestPolicy.getAuthPolicy();
        Object send = send(request, AuthorizationToken.class, oauthPolicy, new ArrayList(), new ArrayList());
        return (AuthorizationToken) send;
    }

    public AuthorizationToken refreshToken(String refreshToken)
        throws OceanException
    {
        Request request = new Request("system.oauth2", "getToken");
        request.addAddtionalParams("refreshToken", refreshToken);
        request.addAddtionalParams("grant_type", "refresh_token");
        request.addAddtionalParams("client_id", clientPolicy.getAppKey());
        request.addAddtionalParams("client_secret", clientPolicy.getSigningKey());
        RequestPolicy oauthPolicy = RequestPolicy.getAuthPolicy();
        return (AuthorizationToken)send(request, AuthorizationToken.class, oauthPolicy, new ArrayList(), new ArrayList());
    }
}

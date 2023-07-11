// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Request.java

package com.alibaba.ocean.rawsdk.client;

import com.alibaba.ocean.rawsdk.client.entity.AuthorizationToken;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;
import java.util.*;

// Referenced classes of package com.alibaba.ocean.rawsdk.client:
//            APIId

public class Request
{

    public static final String ACCESS_TOKEN = "access_token";
    private APIId apiId;
    private Map addtionalParams;
    private AbstractAPIRequest requestEntity;
    private Map attachments;
    private String authCodeKey;
    private String accessToken;
    private AuthorizationToken authToken;

    public Request(String namespace, String name)
    {
        addtionalParams = new HashMap();
        apiId = new APIId(namespace, name);
    }

    public Request(String namespace, String name, int version)
    {
        addtionalParams = new HashMap();
        apiId = new APIId(namespace, name, version);
    }

    public Request(APIId apiId)
    {
        addtionalParams = new HashMap();
        this.apiId = apiId;
    }

    public APIId getApiId()
    {
        return apiId;
    }

    public Request setAttachment(String name, String value)
    {
        return this;
    }

    public Map getAttachments()
    {
        if(attachments == null)
            attachments = new LinkedHashMap();
        return attachments;
    }

    public AbstractAPIRequest getRequestEntity()
    {
        return requestEntity;
    }

    public void setRequestEntity(AbstractAPIRequest requestEntity)
    {
        this.requestEntity = requestEntity;
    }

    public Map getAddtionalParams()
    {
        return addtionalParams;
    }

    public void addAddtionalParams(String key, Object param)
    {
        addtionalParams.put(key, param);
    }

    public String getAuthCodeKey()
    {
        return authCodeKey;
    }

    public Request setAuthCodeKey(String authCodeKey)
    {
        this.authCodeKey = authCodeKey;
        return this;
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public Request setAccessToken(String accessToken)
    {
        this.accessToken = accessToken;
        addtionalParams.put("access_token", accessToken);
        return this;
    }

    public AuthorizationToken getAuthToken()
    {
        return authToken;
    }

    public Request setAuthToken(AuthorizationToken authToken)
    {
        this.authToken = authToken;
        return this;
    }
}

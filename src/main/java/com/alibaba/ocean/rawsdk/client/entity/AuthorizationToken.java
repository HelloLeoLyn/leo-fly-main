// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AuthorizationToken.java

package com.alibaba.ocean.rawsdk.client.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class AuthorizationToken
    implements Serializable
{

    private static final long serialVersionUID = 0x96c688f49bb15171L;
    private String access_token;
    private String refresh_token;
    private long expires_in;
    private Date expires_time;
    @JSONField(format = "yyyyMMddHHmmssSSSZ")
    private Date refresh_token_timeout;
    private String resource_owner;
    private String uid;
    private long aliId;
    private String memberId;

    public AuthorizationToken()
    {
    }

    public AuthorizationToken(String accessToken, long accessTokenTimeout, String resourceOwnerId, long aliId)
    {
        this(accessToken, accessTokenTimeout, null, null, resourceOwnerId, null, aliId, null);
    }

    public AuthorizationToken(String accessToken, long accessTokenTimeout, String resourceOwnerId, String uid, long aliId, 
            String memberId)
    {
        this(accessToken, accessTokenTimeout, null, null, resourceOwnerId, uid, aliId, memberId);
    }

    public AuthorizationToken(String accessToken, long accessTokenTimeout, String refreshToken, Date refreshTokenTimeout, String resourceOwnerId, long aliId, String memberId)
    {
        this(accessToken, accessTokenTimeout, refreshToken, refreshTokenTimeout, resourceOwnerId, null, aliId, memberId);
    }

    public AuthorizationToken(String accessToken, long accessTokenTimeout, String refreshToken, Date refreshTokenTimeout, String resourceOwnerId, String uid,
            long aliId, String memberId)
    {
        access_token = accessToken;
        expires_in = accessTokenTimeout;
        refresh_token = refreshToken;
        refresh_token_timeout = refreshTokenTimeout;
        resource_owner = resourceOwnerId;
        this.uid = uid;
        this.aliId = aliId;
        this.memberId = memberId;
    }

    public String getAccess_token()
    {
        return access_token;
    }

    public long getExpires_in()
    {
        return expires_in;
    }

    public String getRefresh_token()
    {
        return refresh_token;
    }

    public Date getRefresh_token_timeout()
    {
        return refresh_token_timeout;
    }

    public String getMemberId()
    {
        return memberId;
    }

    public void setMemberId(String memberId)
    {
        this.memberId = memberId;
    }

    public String getResource_owner()
    {
        return resource_owner;
    }

    public String getUid()
    {
        return uid;
    }

    public long getAliId()
    {
        return aliId;
    }

    public void setAccess_token(String accessToken)
    {
        access_token = accessToken;
    }

    public void setRefresh_token(String refreshToken)
    {
        refresh_token = refreshToken;
    }

    public void setExpires_in(long accessTokenTimeout)
    {
        expires_in = accessTokenTimeout;
        Calendar cal = Calendar.getInstance();
        cal.add(13, (int)expires_in);
        expires_time = cal.getTime();
    }

    public void setRefresh_token_timeout(Date refresh_token_timeout)
    {
        this.refresh_token_timeout = refresh_token_timeout;
    }

    public void setResource_owner(String resourceOwnerId)
    {
        resource_owner = resourceOwnerId;
    }

    public void setUid(String uid)
    {
        this.uid = uid;
    }

    public void setAliId(long aliId)
    {
        this.aliId = aliId;
    }

    public Date getExpires_time()
    {
        return expires_time;
    }
}

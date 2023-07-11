// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaMemberGetUserInfoParam.java

package com.alibaba.trade.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class AlibabaMemberGetUserInfoParam extends AbstractAPIRequest
{

    private String domin;

    public AlibabaMemberGetUserInfoParam()
    {
        oceanApiId = new APIId("com.alibaba.trade", "alibaba.member.getUserInfo", 1);
    }

    public String getDomin()
    {
        return domin;
    }

    public void setDomin(String domin)
    {
        this.domin = domin;
    }
}

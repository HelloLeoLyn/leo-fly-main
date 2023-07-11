// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaMemberGetShopInfoListParam.java

package com.alibaba.trade.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class AlibabaMemberGetShopInfoListParam extends AbstractAPIRequest
{

    private String domains[];

    public AlibabaMemberGetShopInfoListParam()
    {
        oceanApiId = new APIId("com.alibaba.trade", "alibaba.member.getShopInfoList", 1);
    }

    public String[] getDomains()
    {
        return domains;
    }

    public void setDomains(String domains[])
    {
        this.domains = domains;
    }
}

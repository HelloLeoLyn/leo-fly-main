// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaAlipayUrlGetParam.java

package com.alibaba.trade.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class AlibabaAlipayUrlGetParam extends AbstractAPIRequest
{

    private long orderIdList[];

    public AlibabaAlipayUrlGetParam()
    {
        oceanApiId = new APIId("com.alibaba.trade", "alibaba.alipay.url.get", 1);
    }

    public long[] getOrderIdList()
    {
        return orderIdList;
    }

    public void setOrderIdList(long orderIdList[])
    {
        this.orderIdList = orderIdList;
    }
}

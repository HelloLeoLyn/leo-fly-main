// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeReceiveAddressGetParam.java

package com.alibaba.trade.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class AlibabaTradeReceiveAddressGetParam extends AbstractAPIRequest
{

    public AlibabaTradeReceiveAddressGetParam()
    {
        oceanApiId = new APIId("com.alibaba.trade", "alibaba.trade.receiveAddress.get", 1);
    }
}

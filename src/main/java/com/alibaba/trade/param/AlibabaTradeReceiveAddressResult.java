// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeReceiveAddressResult.java

package com.alibaba.trade.param;


// Referenced classes of package com.alibaba.trade.param:
//            AlibabaTradeReceiveAddressItem

public class AlibabaTradeReceiveAddressResult
{

    private AlibabaTradeReceiveAddressItem receiveAddressItems[];

    public AlibabaTradeReceiveAddressResult()
    {
    }

    public AlibabaTradeReceiveAddressItem[] getReceiveAddressItems()
    {
        return receiveAddressItems;
    }

    public void setReceiveAddressItems(AlibabaTradeReceiveAddressItem receiveAddressItems[])
    {
        this.receiveAddressItems = receiveAddressItems;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaCreateOrderPreviewParam.java

package com.alibaba.trade.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

// Referenced classes of package com.alibaba.trade.param:
//            AlibabaTradeFastAddress, AlibabaTradeFastCargo, AlibabaTradeFastInvoice

public class AlibabaCreateOrderPreviewParam extends AbstractAPIRequest
{

    private AlibabaTradeFastAddress addressParam;
    private AlibabaTradeFastCargo cargoParamList[];
    private AlibabaTradeFastInvoice invoiceParam;
    private String flow;

    public AlibabaCreateOrderPreviewParam()
    {
        oceanApiId = new APIId("com.alibaba.trade", "alibaba.createOrder.preview", 1);
    }

    public AlibabaTradeFastAddress getAddressParam()
    {
        return addressParam;
    }

    public void setAddressParam(AlibabaTradeFastAddress addressParam)
    {
        this.addressParam = addressParam;
    }

    public AlibabaTradeFastCargo[] getCargoParamList()
    {
        return cargoParamList;
    }

    public void setCargoParamList(AlibabaTradeFastCargo cargoParamList[])
    {
        this.cargoParamList = cargoParamList;
    }

    public AlibabaTradeFastInvoice getInvoiceParam()
    {
        return invoiceParam;
    }

    public void setInvoiceParam(AlibabaTradeFastInvoice invoiceParam)
    {
        this.invoiceParam = invoiceParam;
    }

    public String getFlow()
    {
        return flow;
    }

    public void setFlow(String flow)
    {
        this.flow = flow;
    }
}

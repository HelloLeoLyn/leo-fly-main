// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeFastCreateOrderParam.java

package com.alibaba.trade.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

// Referenced classes of package com.alibaba.trade.param:
//            AlibabaTradeFastAddress, AlibabaTradeFastCargo, AlibabaTradeFastInvoice

public class AlibabaTradeFastCreateOrderParam extends AbstractAPIRequest
{

    private String flow;
    private Long subUserId;
    private String message;
    private AlibabaTradeFastAddress addressParam;
    private AlibabaTradeFastCargo cargoParamList[];
    private AlibabaTradeFastInvoice invoiceParam;
    private String shopPromotionId;

    public AlibabaTradeFastCreateOrderParam()
    {
        oceanApiId = new APIId("com.alibaba.trade", "alibaba.trade.fastCreateOrder", 1);
    }

    public String getFlow()
    {
        return flow;
    }

    public void setFlow(String flow)
    {
        this.flow = flow;
    }

    public Long getSubUserId()
    {
        return subUserId;
    }

    public void setSubUserId(Long subUserId)
    {
        this.subUserId = subUserId;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
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

    public String getShopPromotionId()
    {
        return shopPromotionId;
    }

    public void setShopPromotionId(String shopPromotionId)
    {
        this.shopPromotionId = shopPromotionId;
    }
}

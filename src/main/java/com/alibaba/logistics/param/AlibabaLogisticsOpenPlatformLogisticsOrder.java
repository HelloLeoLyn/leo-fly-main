// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaLogisticsOpenPlatformLogisticsOrder.java

package com.alibaba.logistics.param;


// Referenced classes of package com.alibaba.logistics.param:
//            AlibabaLogisticsOpenPlatformLogisticsSendGood, AlibabaLogisticsOpenPlatformLogisticsReceiver, AlibabaLogisticsOpenPlatformLogisticsSender

public class AlibabaLogisticsOpenPlatformLogisticsOrder
{

    private String logisticsId;
    private String logisticsBillNo;
    private String orderEntryIds;
    private String status;
    private String logisticsCompanyId;
    private String logisticsCompanyName;
    private String remarks;
    private String serviceFeature;
    private String gmtSystemSend;
    private AlibabaLogisticsOpenPlatformLogisticsSendGood sendGoods[];
    private AlibabaLogisticsOpenPlatformLogisticsReceiver receiver;
    private AlibabaLogisticsOpenPlatformLogisticsSender sender;

    public AlibabaLogisticsOpenPlatformLogisticsOrder()
    {
    }

    public String getLogisticsId()
    {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId)
    {
        this.logisticsId = logisticsId;
    }

    public String getLogisticsBillNo()
    {
        return logisticsBillNo;
    }

    public void setLogisticsBillNo(String logisticsBillNo)
    {
        this.logisticsBillNo = logisticsBillNo;
    }

    public String getOrderEntryIds()
    {
        return orderEntryIds;
    }

    public void setOrderEntryIds(String orderEntryIds)
    {
        this.orderEntryIds = orderEntryIds;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getLogisticsCompanyId()
    {
        return logisticsCompanyId;
    }

    public void setLogisticsCompanyId(String logisticsCompanyId)
    {
        this.logisticsCompanyId = logisticsCompanyId;
    }

    public String getLogisticsCompanyName()
    {
        return logisticsCompanyName;
    }

    public void setLogisticsCompanyName(String logisticsCompanyName)
    {
        this.logisticsCompanyName = logisticsCompanyName;
    }

    public String getRemarks()
    {
        return remarks;
    }

    public void setRemarks(String remarks)
    {
        this.remarks = remarks;
    }

    public String getServiceFeature()
    {
        return serviceFeature;
    }

    public void setServiceFeature(String serviceFeature)
    {
        this.serviceFeature = serviceFeature;
    }

    public String getGmtSystemSend()
    {
        return gmtSystemSend;
    }

    public void setGmtSystemSend(String gmtSystemSend)
    {
        this.gmtSystemSend = gmtSystemSend;
    }

    public AlibabaLogisticsOpenPlatformLogisticsSendGood[] getSendGoods()
    {
        return sendGoods;
    }

    public void setSendGoods(AlibabaLogisticsOpenPlatformLogisticsSendGood sendGoods[])
    {
        this.sendGoods = sendGoods;
    }

    public AlibabaLogisticsOpenPlatformLogisticsReceiver getReceiver()
    {
        return receiver;
    }

    public void setReceiver(AlibabaLogisticsOpenPlatformLogisticsReceiver receiver)
    {
        this.receiver = receiver;
    }

    public AlibabaLogisticsOpenPlatformLogisticsSender getSender()
    {
        return sender;
    }

    public void setSender(AlibabaLogisticsOpenPlatformLogisticsSender sender)
    {
        this.sender = sender;
    }
}

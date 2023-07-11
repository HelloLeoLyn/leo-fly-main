// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaLogisticsOpenPlatformLogisticsTrace.java

package com.alibaba.logistics.param;


// Referenced classes of package com.alibaba.logistics.param:
//            AlibabaLogisticsOpenPlatformLogisticsStep, AlibabaLogisticsOpenPlatformTraceNode

public class AlibabaLogisticsOpenPlatformLogisticsTrace
{

    private String logisticsId;
    private Long orderId;
    private String logisticsBillNo;
    private AlibabaLogisticsOpenPlatformLogisticsStep logisticsSteps[];
    private AlibabaLogisticsOpenPlatformTraceNode traceNodeList[];

    public AlibabaLogisticsOpenPlatformLogisticsTrace()
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

    public Long getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public String getLogisticsBillNo()
    {
        return logisticsBillNo;
    }

    public void setLogisticsBillNo(String logisticsBillNo)
    {
        this.logisticsBillNo = logisticsBillNo;
    }

    public AlibabaLogisticsOpenPlatformLogisticsStep[] getLogisticsSteps()
    {
        return logisticsSteps;
    }

    public void setLogisticsSteps(AlibabaLogisticsOpenPlatformLogisticsStep logisticsSteps[])
    {
        this.logisticsSteps = logisticsSteps;
    }

    public AlibabaLogisticsOpenPlatformTraceNode[] getTraceNodeList()
    {
        return traceNodeList;
    }

    public void setTraceNodeList(AlibabaLogisticsOpenPlatformTraceNode traceNodeList[])
    {
        this.traceNodeList = traceNodeList;
    }
}

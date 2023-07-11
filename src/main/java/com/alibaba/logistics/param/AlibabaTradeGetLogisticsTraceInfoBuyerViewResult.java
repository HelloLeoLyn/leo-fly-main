// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeGetLogisticsTraceInfoBuyerViewResult.java

package com.alibaba.logistics.param;


// Referenced classes of package com.alibaba.logistics.param:
//            AlibabaLogisticsOpenPlatformLogisticsTrace

public class AlibabaTradeGetLogisticsTraceInfoBuyerViewResult
{

    private AlibabaLogisticsOpenPlatformLogisticsTrace logisticsTrace[];
    private String errorCode;
    private String errorMessage;

    public AlibabaTradeGetLogisticsTraceInfoBuyerViewResult()
    {
    }

    public AlibabaLogisticsOpenPlatformLogisticsTrace[] getLogisticsTrace()
    {
        return logisticsTrace;
    }

    public void setLogisticsTrace(AlibabaLogisticsOpenPlatformLogisticsTrace logisticsTrace[])
    {
        this.logisticsTrace = logisticsTrace;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
}

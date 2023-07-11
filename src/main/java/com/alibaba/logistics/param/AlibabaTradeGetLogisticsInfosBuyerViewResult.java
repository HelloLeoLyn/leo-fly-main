// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeGetLogisticsInfosBuyerViewResult.java

package com.alibaba.logistics.param;


// Referenced classes of package com.alibaba.logistics.param:
//            AlibabaLogisticsOpenPlatformLogisticsOrder

public class AlibabaTradeGetLogisticsInfosBuyerViewResult
{

    private AlibabaLogisticsOpenPlatformLogisticsOrder result[];
    private String errorCode;
    private String errorMessage;

    public AlibabaTradeGetLogisticsInfosBuyerViewResult()
    {
    }

    public AlibabaLogisticsOpenPlatformLogisticsOrder[] getResult()
    {
        return result;
    }

    public void setResult(AlibabaLogisticsOpenPlatformLogisticsOrder result[])
    {
        this.result = result;
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

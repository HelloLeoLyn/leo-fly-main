// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeGetBuyerViewResult.java

package com.alibaba.trade.param;


// Referenced classes of package com.alibaba.trade.param:
//            AlibabaOpenplatformTradeModelTradeInfo

public class AlibabaTradeGetBuyerViewResult
{

    private AlibabaOpenplatformTradeModelTradeInfo result;
    private String errorCode;
    private String errorMessage;

    public AlibabaTradeGetBuyerViewResult()
    {
    }

    public AlibabaOpenplatformTradeModelTradeInfo getResult()
    {
        return result;
    }

    public void setResult(AlibabaOpenplatformTradeModelTradeInfo result)
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

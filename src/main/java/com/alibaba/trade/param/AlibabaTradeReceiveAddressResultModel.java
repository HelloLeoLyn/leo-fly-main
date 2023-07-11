// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeReceiveAddressResultModel.java

package com.alibaba.trade.param;


// Referenced classes of package com.alibaba.trade.param:
//            AlibabaTradeReceiveAddressResult

public class AlibabaTradeReceiveAddressResultModel
{

    private AlibabaTradeReceiveAddressResult result;
    private Boolean success;
    private String code;
    private String message;

    public AlibabaTradeReceiveAddressResultModel()
    {
    }

    public AlibabaTradeReceiveAddressResult getResult()
    {
        return result;
    }

    public void setResult(AlibabaTradeReceiveAddressResult result)
    {
        this.result = result;
    }

    public Boolean getSuccess()
    {
        return success;
    }

    public void setSuccess(Boolean success)
    {
        this.success = success;
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}

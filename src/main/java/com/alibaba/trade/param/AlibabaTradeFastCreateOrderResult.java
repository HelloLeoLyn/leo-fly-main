// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeFastCreateOrderResult.java

package com.alibaba.trade.param;


// Referenced classes of package com.alibaba.trade.param:
//            AlibabaTradeFastResult

public class AlibabaTradeFastCreateOrderResult
{

    private AlibabaTradeFastResult result;
    private Boolean success;
    private String code;
    private String message;

    public AlibabaTradeFastCreateOrderResult()
    {
    }

    public AlibabaTradeFastResult getResult()
    {
        return result;
    }

    public void setResult(AlibabaTradeFastResult result)
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

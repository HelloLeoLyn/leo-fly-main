// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaAlipayUrlGetResult.java

package com.alibaba.trade.param;


public class AlibabaAlipayUrlGetResult
{

    private String erroMsg;
    private String payUrl;
    private Boolean success;

    public AlibabaAlipayUrlGetResult()
    {
    }

    public String getErroMsg()
    {
        return erroMsg;
    }

    public void setErroMsg(String erroMsg)
    {
        this.erroMsg = erroMsg;
    }

    public String getPayUrl()
    {
        return payUrl;
    }

    public void setPayUrl(String payUrl)
    {
        this.payUrl = payUrl;
    }

    public Boolean getSuccess()
    {
        return success;
    }

    public void setSuccess(Boolean success)
    {
        this.success = success;
    }
}

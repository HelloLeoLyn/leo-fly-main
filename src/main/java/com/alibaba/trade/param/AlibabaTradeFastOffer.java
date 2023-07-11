// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeFastOffer.java

package com.alibaba.trade.param;


public class AlibabaTradeFastOffer
{

    private String offerId;
    private String specId;
    private String errorCode;
    private String errorMessage;

    public AlibabaTradeFastOffer()
    {
    }

    public String getOfferId()
    {
        return offerId;
    }

    public void setOfferId(String offerId)
    {
        this.offerId = offerId;
    }

    public String getSpecId()
    {
        return specId;
    }

    public void setSpecId(String specId)
    {
        this.specId = specId;
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

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   OceanException.java

package com.alibaba.ocean.rawsdk.client.exception;


public class OceanException extends Exception
{

    private static final long serialVersionUID = 0xe69e9725c4b9e635L;
    protected String errorCode;
    protected String errorMessage;

    public String getErrorCode()
    {
        return errorCode;
    }

    public String getErrorMessage()
    {
        return errorMessage;
    }

    public OceanException()
    {
    }

    public OceanException(String message)
    {
        super(message);
        errorMessage = message;
    }

    public OceanException(String errorCode, String message)
    {
        super(message);
        this.errorCode = errorCode;
        errorMessage = message;
    }

    public OceanException(Throwable cause)
    {
        super(cause);
    }

    public OceanException(String message, Throwable cause)
    {
        super(message, cause);
    }
}

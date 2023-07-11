// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ExceptionParser.java

package com.alibaba.ocean.rawsdk.client.util;

import com.alibaba.ocean.rawsdk.client.exception.OceanException;
import com.alibaba.ocean.rawsdk.util.GenericsUtil;
import java.util.Map;

public class ExceptionParser
{

    public ExceptionParser()
    {
    }

    public static Throwable buildException4Json2(Map exption)
    {
        Map m = exption;
        String errorCodeStr = (String)m.get("error_code");
        String errorMesage = (String)m.get("error_message");
        if(errorCodeStr == null)
            errorCodeStr = (String)m.get("errorCode");
        if(errorMesage == null)
            errorMesage = (String)m.get("errorMessage");
        if(GenericsUtil.isBlank(errorMesage))
            errorMesage = "Unknow message defined in response.";
        return buildException(errorCodeStr, errorMesage);
    }

    public static Throwable buildException4OAuth2(Object exption)
    {
        Map m = (Map)exption;
        int errorCode = 401;
        String errorMesage = (String)m.get("error_description");
        return buildException(errorCode, errorMesage);
    }

    private static Throwable buildException(int errorCode, String errorMesage)
    {
        return new OceanException(String.valueOf(errorCode), errorMesage);
    }

    private static Throwable buildException(String errorCode, String errorMesage)
    {
        return new OceanException(errorCode, errorMesage);
    }
}

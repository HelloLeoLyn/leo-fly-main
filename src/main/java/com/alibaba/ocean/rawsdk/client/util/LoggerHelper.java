// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   LoggerHelper.java

package com.alibaba.ocean.rawsdk.client.util;

import java.util.logging.Logger;

public final class LoggerHelper
{

    private static Logger logger = Logger.getLogger("com.alibaba.openapi.client");

    public static Logger getClientLogger()
    {
        return logger;
    }

    private LoggerHelper()
    {
    }

}

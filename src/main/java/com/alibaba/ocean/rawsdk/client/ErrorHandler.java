// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ErrorHandler.java

package com.alibaba.ocean.rawsdk.client;

import com.alibaba.ocean.rawsdk.client.exception.OceanException;

public interface ErrorHandler
{

    public abstract void handle(OceanException oceanexception);
}

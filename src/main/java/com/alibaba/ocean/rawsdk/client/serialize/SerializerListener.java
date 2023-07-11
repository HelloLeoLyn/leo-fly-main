// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SerializerListener.java

package com.alibaba.ocean.rawsdk.client.serialize;

import java.util.Map;

public interface SerializerListener
{

    public abstract void onRequestSerialized(Map map);
}

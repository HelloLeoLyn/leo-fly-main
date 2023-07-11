// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SDKListener.java

package com.alibaba.ocean.rawsdk.client;

import com.alibaba.ocean.rawsdk.client.serialize.DeSerializerListener;
import com.alibaba.ocean.rawsdk.client.serialize.SerializerListener;

public interface SDKListener
{

    public abstract void register(SerializerListener serializerlistener);

    public abstract void register(DeSerializerListener deserializerlistener);
}

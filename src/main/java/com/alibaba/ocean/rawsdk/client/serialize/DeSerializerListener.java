// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   DeSerializerListener.java

package com.alibaba.ocean.rawsdk.client.serialize;


public interface DeSerializerListener
{

    public abstract void onResponseDeSerialized(String s);

    public abstract void onResponseExceptioned(String s);
}

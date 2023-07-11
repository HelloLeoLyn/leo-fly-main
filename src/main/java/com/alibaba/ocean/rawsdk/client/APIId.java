// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   APIId.java

package com.alibaba.ocean.rawsdk.client;

import java.io.Serializable;

public class APIId
    implements Serializable
{

    private static final long serialVersionUID = 0x2defd66600f36ab4L;
    public static final int DEFAULT_VERSION = 1;
    private String namespace;
    private String name;
    private int version;

    public APIId()
    {
    }

    public APIId(String namespace, String name)
    {
        this(namespace, name, 1);
    }

    public APIId(String namespace, String name, int version)
    {
        this.namespace = namespace;
        this.name = name;
        this.version = version;
    }

    public String toString()
    {
        return (new StringBuilder()).append(namespace).append(':').append(name).append('-').append(version).toString();
    }

    public String getNamespace()
    {
        return namespace;
    }

    public String getName()
    {
        return name;
    }

    public int getVersion()
    {
        return version;
    }
}

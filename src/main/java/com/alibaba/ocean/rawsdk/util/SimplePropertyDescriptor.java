// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SimplePropertyDescriptor.java

package com.alibaba.ocean.rawsdk.util;

import java.lang.reflect.Method;

public class SimplePropertyDescriptor
{

    private String name;
    private Method readMethod;
    private Class propertyType;

    public SimplePropertyDescriptor()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Method getReadMethod()
    {
        return readMethod;
    }

    public void setReadMethod(Method readMethod)
    {
        this.readMethod = readMethod;
    }

    public Class getPropertyType()
    {
        return propertyType;
    }

    public void setPropertyType(Class propertyType)
    {
        this.propertyType = propertyType;
    }
}

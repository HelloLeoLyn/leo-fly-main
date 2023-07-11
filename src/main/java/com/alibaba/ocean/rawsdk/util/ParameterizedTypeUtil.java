// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ParameterizedTypeUtil.java

package com.alibaba.ocean.rawsdk.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

public class ParameterizedTypeUtil
{

    private static HashMap parameterizedTypesCache = new HashMap();

    public ParameterizedTypeUtil()
    {
    }

    public static Type[] getGenericTypes(Class beanClass)
    {
        if(beanClass == null)
            throw new IllegalArgumentException("No bean class specified");
        Type types[] = (Type[])parameterizedTypesCache.get(beanClass);
        if(types != null)
            return types;
        Type myGenericClass[] = beanClass.getGenericInterfaces();
        if(myGenericClass == null || myGenericClass.length == 0)
        {
            types = null;
        } else
        {
            ParameterizedType pt = (ParameterizedType)myGenericClass[0];
            types = pt.getActualTypeArguments();
        }
        parameterizedTypesCache.put(beanClass, types);
        return types;
    }

    public static Type[] getGenericTypes(Object bean)
    {
        if(bean == null)
            throw new IllegalArgumentException("No bean specified");
        else
            return getGenericTypes(bean.getClass());
    }

}

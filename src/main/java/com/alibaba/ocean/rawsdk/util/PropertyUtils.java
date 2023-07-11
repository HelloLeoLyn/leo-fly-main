// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   PropertyUtils.java

package com.alibaba.ocean.rawsdk.util;

import java.beans.*;
import java.util.*;

public class PropertyUtils
{

    private static HashMap descriptorsCache = new HashMap();

    public PropertyUtils()
    {
    }

    public static PropertyDescriptor[] getPropertyDescriptors(Class beanClass)
    {
        if(beanClass == null)
            return new PropertyDescriptor[0];
        PropertyDescriptor descriptors[] = null;
        descriptors = (PropertyDescriptor[])(PropertyDescriptor[])descriptorsCache.get(beanClass);
        if(descriptors != null)
            return descriptors;
        BeanInfo beanInfo = null;
        try
        {
            beanInfo = Introspector.getBeanInfo(beanClass);
        }
        catch(IntrospectionException e)
        {
            return new PropertyDescriptor[0];
        }
        descriptors = beanInfo.getPropertyDescriptors();
        if(descriptors == null)
            descriptors = new PropertyDescriptor[0];
        descriptorsCache.put(beanClass, descriptors);
        return descriptors;
    }

    public static PropertyDescriptor[] getPropertyDescriptors(Object bean)
    {
        if(bean == null)
            return new PropertyDescriptor[0];
        else
            return getPropertyDescriptors(bean.getClass());
    }

    public static Map getMappedPropertyDescriptors(Object bean)
    {
        PropertyDescriptor dess[] = getPropertyDescriptors(bean);
        Map mappedDes = new LinkedHashMap();
        PropertyDescriptor apropertydescriptor[] = dess;
        int i = apropertydescriptor.length;
        for(int j = 0; j < i; j++)
        {
            PropertyDescriptor propertyDescriptor = apropertydescriptor[j];
            mappedDes.put(propertyDescriptor.getName(), propertyDescriptor);
        }

        return mappedDes;
    }

    public static Map getMappedPropertyDescriptors(Class beanClass)
    {
        PropertyDescriptor dess[] = getPropertyDescriptors(beanClass);
        Map mappedDes = new LinkedHashMap();
        PropertyDescriptor apropertydescriptor[] = dess;
        int i = apropertydescriptor.length;
        for(int j = 0; j < i; j++)
        {
            PropertyDescriptor propertyDescriptor = apropertydescriptor[j];
            mappedDes.put(propertyDescriptor.getName(), propertyDescriptor);
        }

        return mappedDes;
    }

}

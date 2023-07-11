// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   DefaultPropertyUtils.java

package com.alibaba.ocean.rawsdk.util;

import java.lang.reflect.Field;
import java.util.HashMap;

// Referenced classes of package com.alibaba.ocean.rawsdk.util:
//            SimplePropertyDescriptor, GenericsUtil

public class DefaultPropertyUtils
{

    private static HashMap descriptorsCache = new HashMap();

    public DefaultPropertyUtils()
    {
    }

    public static SimplePropertyDescriptor[] getPropertyDescriptors(Class beanClass)
    {
        if(beanClass == null)
            return new SimplePropertyDescriptor[0];
        SimplePropertyDescriptor descriptors[] = null;
        descriptors = (SimplePropertyDescriptor[])(SimplePropertyDescriptor[])descriptorsCache.get(beanClass);
        if(descriptors != null)
            return descriptors;
        Field fields[] = beanClass.getDeclaredFields();
        if(fields == null)
        {
            descriptors = new SimplePropertyDescriptor[0];
        } else
        {
            descriptors = new SimplePropertyDescriptor[fields.length];
            for(int i = 0; i < fields.length; i++)
            {
                Field field = fields[i];
                SimplePropertyDescriptor simplePropertyDescriptor = new SimplePropertyDescriptor();
                simplePropertyDescriptor.setName(field.getName());
                simplePropertyDescriptor.setPropertyType(field.getType());
                try
                {
                    java.lang.reflect.Method readMethod = beanClass.getMethod((new StringBuilder()).append("get").append(GenericsUtil.capitalize(field.getName())).toString(), new Class[0]);
                    simplePropertyDescriptor.setReadMethod(readMethod);
                }
                catch(Exception exception) { }
                descriptors[i] = simplePropertyDescriptor;
            }

        }
        descriptorsCache.put(beanClass, descriptors);
        return descriptors;
    }

}

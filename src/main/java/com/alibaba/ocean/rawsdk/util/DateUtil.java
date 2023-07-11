// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   DateUtil.java

package com.alibaba.ocean.rawsdk.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class DateUtil
{

    public static final String DEFAULT_DATE_FORMAT_STR = "yyyyMMddHHmmssSSSZ";
    public static final String SIMPLE_DATE_FORMAT_STR = "yyyy-MM-dd HH:mm:ss.SSS";
    private static SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssSSSZ");

    public static String format(Date d)
    {
        return format(d, null);
    }

    public static String format(Date d, String pattern)
    {
        return format(d, pattern, null);
    }

    public static String format(Date d, String pattern, TimeZone timeZone)
    {
        if(d == null)
            return null;
        SimpleDateFormat format;
        if(pattern != null)
            format = new SimpleDateFormat(pattern);
        else
            format = (SimpleDateFormat)DEFAULT_FORMAT.clone();
        if(timeZone != null)
            format.setTimeZone(timeZone);
        return format.format(d);
    }

    public static Date parse(String str)
        throws ParseException
    {
        return parse(str, null);
    }

    public static Date parse(String source, String pattern)
        throws ParseException
    {
        return parse(source, pattern, null);
    }

    public static Date parse(String source, String pattern, TimeZone timeZone)
        throws ParseException
    {
        if(source == null)
            return null;
        SimpleDateFormat format;
        if(pattern != null)
            format = new SimpleDateFormat(pattern);
        else
            format = (SimpleDateFormat)DEFAULT_FORMAT.clone();
        if(timeZone != null)
            format.setTimeZone(timeZone);
        return format.parse(source);
    }

    private DateUtil()
    {
    }

}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SignatureUtil.java

package com.alibaba.ocean.rawsdk.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class SignatureUtil
{

    public static final String HMAC_SHA1 = "HmacSHA1";
    public static final String CHARSET_NAME_UTF8 = "UTF-8";
    public static final Charset CHARSET_UTF8 = Charset.forName("UTF-8");
    public static final char digital[] = "0123456789ABCDEF".toCharArray();

    public SignatureUtil()
    {
    }

    private static SecretKeySpec buildKey(byte key[])
    {
        return new SecretKeySpec(key, "HmacSHA1");
    }

    public static String encodeHexStr(byte bytes[])
    {
        if(bytes == null)
            return null;
        StringBuilder str = new StringBuilder(bytes.length * 2);
        for(int i = 0; i < bytes.length; i++)
        {
            str.append(digital[(bytes[i] & 0xf0) >> 4]);
            str.append(digital[bytes[i] & 0xf]);
        }

        return str.toString();
    }

    public static byte[] hmacSha1(String path, Map parameters, String signingKey)
    {
        Mac mac;
        try
        {
            mac = Mac.getInstance("HmacSHA1");
            mac.init(buildKey(toBytes(signingKey)));
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new IllegalStateException(e.getMessage(), e);
        }
        catch(InvalidKeyException e)
        {
            throw new IllegalStateException(e.getMessage(), e);
        }
        mac.update(path.getBytes(CHARSET_UTF8));
        List parameterToSort = new ArrayList();
        java.util.Map.Entry entry;
        for(Iterator iterator = parameters.entrySet().iterator(); iterator.hasNext(); parameterToSort.add((new StringBuilder()).append((String)entry.getKey()).append(entry.getValue()).toString()))
            entry = (java.util.Map.Entry)iterator.next();

        Collections.sort(parameterToSort);
        String paramToSign;
        for(Iterator iterator1 = parameterToSort.iterator(); iterator1.hasNext(); mac.update(paramToSign.getBytes(CHARSET_UTF8)))
            paramToSign = (String)iterator1.next();

        return mac.doFinal();
    }

    public static byte[] hmacSha1(Map parameters, String signingKey)
    {
        Mac mac;
        try
        {
            mac = Mac.getInstance("HmacSHA1");
            mac.init(buildKey(toBytes(signingKey)));
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new IllegalStateException(e.getMessage(), e);
        }
        catch(InvalidKeyException e)
        {
            throw new IllegalStateException(e.getMessage(), e);
        }
        List parameterToSort = new ArrayList();
        java.util.Map.Entry entry;
        for(Iterator iterator = parameters.entrySet().iterator(); iterator.hasNext(); parameterToSort.add((new StringBuilder()).append((String)entry.getKey()).append(entry.getValue()).toString()))
            entry = (java.util.Map.Entry)iterator.next();

        Collections.sort(parameterToSort);
        String paramToSign;
        for(Iterator iterator1 = parameterToSort.iterator(); iterator1.hasNext(); mac.update(paramToSign.getBytes(CHARSET_UTF8)))
            paramToSign = (String)iterator1.next();

        return mac.doFinal();
    }

    private static byte[] toBytes(String str)
    {
        if(str == null)
            return null;
        try
        {
            return str.getBytes("UTF-8");
        }
        catch(UnsupportedEncodingException e)
        {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

}

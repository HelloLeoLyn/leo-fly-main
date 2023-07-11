// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Param2Deserializer.java

package com.alibaba.ocean.rawsdk.client.imp.serialize;

import com.alibaba.ocean.rawsdk.client.policy.Protocol;

// Referenced classes of package com.alibaba.ocean.rawsdk.client.imp.serialize:
//            Json2Deserializer

public class Param2Deserializer extends Json2Deserializer
{

    public Param2Deserializer()
    {
    }

    public String supportedContentType()
    {
        return Protocol.param2.name();
    }
}

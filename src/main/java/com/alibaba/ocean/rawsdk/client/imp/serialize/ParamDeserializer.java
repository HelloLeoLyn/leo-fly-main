// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ParamDeserializer.java

package com.alibaba.ocean.rawsdk.client.imp.serialize;

import com.alibaba.ocean.rawsdk.client.policy.Protocol;

// Referenced classes of package com.alibaba.ocean.rawsdk.client.imp.serialize:
//            JsonDeserializer

public class ParamDeserializer extends JsonDeserializer
{

    public ParamDeserializer()
    {
    }

    public String supportedContentType()
    {
        return Protocol.param.name();
    }
}

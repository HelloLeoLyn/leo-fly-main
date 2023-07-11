// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Param2RequestSerializer.java

package com.alibaba.ocean.rawsdk.client.imp.serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.ocean.rawsdk.client.policy.Protocol;

// Referenced classes of package com.alibaba.ocean.rawsdk.client.imp.serialize:
//            AbstractParamRequestSerializer

public class Param2RequestSerializer extends AbstractParamRequestSerializer
{

    public Param2RequestSerializer()
    {
    }

    public String supportedContentType()
    {
        return Protocol.param2.name();
    }

    protected String processNestedParameter(Object value)
    {
        return JSON.toJSONString(value);
    }
}

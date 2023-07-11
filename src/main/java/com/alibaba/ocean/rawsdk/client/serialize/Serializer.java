// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   Serializer.java

package com.alibaba.ocean.rawsdk.client.serialize;

import java.util.Map;

// Referenced classes of package com.alibaba.ocean.rawsdk.client.serialize:
//            SerializerListener

public interface Serializer
{

    public abstract String supportedContentType();

    public abstract Map serialize(Object obj);

    public abstract void registeSerializerListener(SerializerListener serializerlistener);
}

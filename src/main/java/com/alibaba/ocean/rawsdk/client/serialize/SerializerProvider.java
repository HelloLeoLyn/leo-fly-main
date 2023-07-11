// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   SerializerProvider.java

package com.alibaba.ocean.rawsdk.client.serialize;

import java.util.LinkedHashMap;
import java.util.Map;

// Referenced classes of package com.alibaba.ocean.rawsdk.client.serialize:
//            Serializer, DeSerializer

public class SerializerProvider
{

    private Map serializerStore;
    private Map deSerializerStore;

    public SerializerProvider()
    {
        serializerStore = new LinkedHashMap();
        deSerializerStore = new LinkedHashMap();
    }

    public Serializer getSerializer(String contentType)
    {
        return (Serializer)serializerStore.get(contentType);
    }

    public void register(Serializer serializer)
    {
        serializerStore.put(serializer.supportedContentType(), serializer);
    }

    public DeSerializer getDeSerializer(String contentType)
    {
        return (DeSerializer)deSerializerStore.get(contentType);
    }

    public void register(DeSerializer deSerializer)
    {
        deSerializerStore.put(deSerializer.supportedContentType(), deSerializer);
    }
}

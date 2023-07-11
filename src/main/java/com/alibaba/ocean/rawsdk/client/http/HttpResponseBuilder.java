// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   HttpResponseBuilder.java

package com.alibaba.ocean.rawsdk.client.http;

import com.alibaba.ocean.rawsdk.client.Response;
import java.io.InputStream;
import java.util.Collection;

// Referenced classes of package com.alibaba.ocean.rawsdk.client.http:
//            InvokeContext

public interface HttpResponseBuilder
{

    public abstract Response buildResponse(InputStream inputstream, int i, String s, String s1, InvokeContext invokecontext, Collection collection);
}

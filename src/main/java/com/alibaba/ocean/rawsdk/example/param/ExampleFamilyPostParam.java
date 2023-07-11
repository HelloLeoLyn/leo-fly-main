// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ExampleFamilyPostParam.java

package com.alibaba.ocean.rawsdk.example.param;

import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

// Referenced classes of package com.alibaba.ocean.rawsdk.example.param:
//            ExampleFamily

public class ExampleFamilyPostParam extends AbstractAPIRequest
{

    private ExampleFamily family;
    private String comments;
    private byte houseImg[];

    public ExampleFamilyPostParam()
    {
    }

    public ExampleFamily getFamily()
    {
        return family;
    }

    public void setFamily(ExampleFamily family)
    {
        this.family = family;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public byte[] getHouseImg()
    {
        return houseImg;
    }

    public void setHouseImg(byte houseImg[])
    {
        this.houseImg = houseImg;
    }
}

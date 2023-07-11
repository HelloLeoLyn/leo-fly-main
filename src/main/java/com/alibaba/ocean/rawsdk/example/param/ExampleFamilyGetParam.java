// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ExampleFamilyGetParam.java

package com.alibaba.ocean.rawsdk.example.param;

import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;

public class ExampleFamilyGetParam extends AbstractAPIRequest
{

    private Integer familyNumber;

    public ExampleFamilyGetParam()
    {
    }

    public Integer getFamilyNumber()
    {
        return familyNumber;
    }

    public void setFamilyNumber(Integer familyNumber)
    {
        this.familyNumber = familyNumber;
    }
}

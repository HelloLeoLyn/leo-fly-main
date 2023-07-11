// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ExamplePerson.java

package com.alibaba.ocean.rawsdk.example.param;

import java.util.Date;

public class ExamplePerson
{

    private String name;
    private Integer age;
    private Date birthday;
    private String mobileNumber;

    public ExamplePerson()
    {
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public Date getBirthday()
    {
        return birthday;
    }

    public void setBirthday(Date birthday)
    {
        this.birthday = birthday;
    }

    public String getMobileNumber()
    {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ExamplePerson [name=").append(name).append(", age=").append(age).append(", birthday=").append(birthday).append(", mobileNumber=").append(mobileNumber).append("]").toString();
    }
}

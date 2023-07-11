// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ExampleHouse.java

package com.alibaba.ocean.rawsdk.example.param;


public class ExampleHouse
{

    private String location;
    private Integer areaSize;
    private Boolean rent;
    private Integer rooms;

    public ExampleHouse()
    {
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public Integer getAreaSize()
    {
        return areaSize;
    }

    public void setAreaSize(Integer areaSize)
    {
        this.areaSize = areaSize;
    }

    public Boolean getRent()
    {
        return rent;
    }

    public void setRent(Boolean rent)
    {
        this.rent = rent;
    }

    public Integer getRooms()
    {
        return rooms;
    }

    public void setRooms(Integer rooms)
    {
        this.rooms = rooms;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ExampleHouse [location=").append(location).append(", areaSize=").append(areaSize).append(", rent=").append(rent).append(", rooms=").append(rooms).append("]").toString();
    }
}

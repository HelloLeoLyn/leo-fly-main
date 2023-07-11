// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ExampleCar.java

package com.alibaba.ocean.rawsdk.example.param;

import java.util.Date;

public class ExampleCar
{

    private Date builtDate;
    private Date boughtDate;
    private String name;
    private String builtArea;
    private String carNumber;
    private Double price;
    private Integer seats;

    public ExampleCar()
    {
    }

    public Date getBuiltDate()
    {
        return builtDate;
    }

    public void setBuiltDate(Date builtDate)
    {
        this.builtDate = builtDate;
    }

    public Date getBoughtDate()
    {
        return boughtDate;
    }

    public void setBoughtDate(Date boughtDate)
    {
        this.boughtDate = boughtDate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBuiltArea()
    {
        return builtArea;
    }

    public void setBuiltArea(String builtArea)
    {
        this.builtArea = builtArea;
    }

    public String getCarNumber()
    {
        return carNumber;
    }

    public void setCarNumber(String carNumber)
    {
        this.carNumber = carNumber;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Integer getSeats()
    {
        return seats;
    }

    public void setSeats(Integer seats)
    {
        this.seats = seats;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ExampleCar [builtDate=").append(builtDate).append(", boughtDate=").append(boughtDate).append(", name=").append(name).append(", builtArea=").append(builtArea).append(", carNumber=").append(carNumber).append(", price=").append(price).append(", seats=").append(seats).append("]").toString();
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   RawSdkExampleData.java

package com.alibaba.ocean.rawsdk.example;

import com.alibaba.ocean.rawsdk.example.param.ExampleCar;
import com.alibaba.ocean.rawsdk.example.param.ExampleFamily;
import com.alibaba.ocean.rawsdk.example.param.ExampleHouse;
import com.alibaba.ocean.rawsdk.example.param.ExamplePerson;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RawSdkExampleData
{

    public static final String DATE_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public RawSdkExampleData()
    {
    }

    public static ExampleFamily createFirstFamily()
    {
        ExampleFamily family = new ExampleFamily();
        ExamplePerson father = new ExamplePerson();
        father.setAge(Integer.valueOf(38));
        father.setBirthday(createDate("1978-03-12 10:10:10"));
        father.setMobileNumber("27088888888");
        father.setName("\u5F20\u8FDB\u5219");
        family.setFather(father);
        ExamplePerson mother = new ExamplePerson();
        mother.setAge(Integer.valueOf(33));
        mother.setBirthday(createDate("1983-06-17 10:10:10"));
        mother.setMobileNumber("27099999999");
        mother.setName("\u5468\u715C\u6E05");
        family.setMother(mother);
        ExamplePerson xiaoming = new ExamplePerson();
        xiaoming.setBirthday(createDate("2010-10-17 10:10:10"));
        xiaoming.setName("\u5F20\u5C0F\u660E");
        ExamplePerson xiaogang = new ExamplePerson();
        xiaogang.setBirthday(createDate("2010-10-17 10:20:10"));
        xiaogang.setName("\u5F20\u5C0F\u521A");
        ExamplePerson children[] = {
            xiaoming, xiaogang
        };
        family.setChildren(children);
        family.setFamilyNumber(Integer.valueOf(1));
        family.setMyHouse(createHouse("\u4E2D\u56FD\u4E0A\u6D77\u5E02\u6D66\u4E1C\u65B0\u533A", Boolean.valueOf(false)));
        ExampleCar ownedCars[] = {
            createCar("BMW", Double.valueOf(370000.12D)), createCar("Ford", Double.valueOf(150000.26999999999D))
        };
        family.setOwnedCars(ownedCars);
        return family;
    }

    public static ExampleFamily createSecondFamily()
    {
        ExampleFamily family = new ExampleFamily();
        ExamplePerson mother = new ExamplePerson();
        mother.setAge(Integer.valueOf(33));
        mother.setBirthday(createDate("1983-06-17 10:10:10"));
        mother.setMobileNumber("27099999999");
        mother.setName("\u53F6\u6DB5");
        family.setMother(mother);
        ExamplePerson xiaoming = new ExamplePerson();
        xiaoming.setBirthday(createDate("2010-10-17 10:10:10"));
        xiaoming.setName("\u53F6\u5B50\u6DB5");
        xiaoming.setAge(Integer.valueOf(6));
        ExamplePerson children[] = {
            xiaoming
        };
        family.setChildren(children);
        family.setFamilyNumber(Integer.valueOf(2));
        family.setMyHouse(createHouse("\u4E2D\u56FD\u6D59\u6C5F\u7701\u676D\u5DDE\u5E02\u6EE8\u6C5F\u533A", null));
        ExampleCar ownedCars[] = {
            createCar("XXXX", Double.valueOf(1370000.1200000001D))
        };
        family.setOwnedCars(ownedCars);
        return family;
    }

    public static ExampleCar createCar(String name, Double price)
    {
        ExampleCar car = new ExampleCar();
        car.setBoughtDate(createDate("2008-10-17 10:20:10"));
        car.setBuiltArea("\u4E2D\u56FD");
        car.setBuiltDate(createDate("2007-10-17 10:20:10"));
        car.setCarNumber("HZ-H-9875");
        car.setName(name);
        car.setPrice(price);
        car.setSeats(Integer.valueOf(4));
        return car;
    }

    public static ExampleHouse createHouse(String address, Boolean rent)
    {
        ExampleHouse house = new ExampleHouse();
        house.setAreaSize(Integer.valueOf(120));
        house.setLocation(address);
        house.setRent(rent);
        return house;
    }

    public static Date createDate(String input)
    {
        try
        {
            return simpleDateFormat.parse(input);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] getPicture(String fileName)
    {
        URL fatherURL = RawSdkExampleData.class.getClassLoader().getResource(fileName);
        try
        {
            InputStream inputStream = fatherURL.openStream();
            byte bs[] = new byte[0x100000];
            int readCount = inputStream.read(bs);
            byte content[] = new byte[readCount];
            System.arraycopy(bs, 0, content, 0, readCount);
            return content;
        }
        catch(IOException ioexception)
        {
            return null;
        }
    }

}

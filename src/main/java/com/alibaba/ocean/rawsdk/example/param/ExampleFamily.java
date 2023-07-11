// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   ExampleFamily.java

package com.alibaba.ocean.rawsdk.example.param;

import java.util.Arrays;

// Referenced classes of package com.alibaba.ocean.rawsdk.example.param:
//            ExamplePerson, ExampleCar, ExampleHouse

public class ExampleFamily
{

    private Integer familyNumber;
    private ExamplePerson father;
    private ExamplePerson mother;
    private ExamplePerson children[];
    private ExampleCar ownedCars[];
    private ExampleHouse myHouse;

    public ExampleFamily()
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

    public ExamplePerson getFather()
    {
        return father;
    }

    public void setFather(ExamplePerson father)
    {
        this.father = father;
    }

    public ExamplePerson getMother()
    {
        return mother;
    }

    public void setMother(ExamplePerson mother)
    {
        this.mother = mother;
    }

    public ExamplePerson[] getChildren()
    {
        return children;
    }

    public void setChildren(ExamplePerson children[])
    {
        this.children = children;
    }

    public ExampleCar[] getOwnedCars()
    {
        return ownedCars;
    }

    public void setOwnedCars(ExampleCar ownedCars[])
    {
        this.ownedCars = ownedCars;
    }

    public ExampleHouse getMyHouse()
    {
        return myHouse;
    }

    public void setMyHouse(ExampleHouse myHouse)
    {
        this.myHouse = myHouse;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ExampleFamily [familyNumber=").append(familyNumber).append(", father=").append(father).append(", mother=").append(mother).append(", children=").append(Arrays.toString(children)).append(", ownedCars=").append(Arrays.toString(ownedCars)).append(", myHouse=").append(myHouse).append("]").toString();
    }
}

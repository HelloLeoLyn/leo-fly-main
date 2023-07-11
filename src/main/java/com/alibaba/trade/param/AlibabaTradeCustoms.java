// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeCustoms.java

package com.alibaba.trade.param;

import java.util.Date;

// Referenced classes of package com.alibaba.trade.param:
//            AlibabaTradeCustomsAttributesInfo

public class AlibabaTradeCustoms
{

    private Long id;
    private Date gmtCreate;
    private Date gmtModified;
    private Long buyerId;
    private String orderId;
    private Integer type;
    private AlibabaTradeCustomsAttributesInfo attributes[];

    public AlibabaTradeCustoms()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getGmtCreate()
    {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate)
    {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified()
    {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified)
    {
        this.gmtModified = gmtModified;
    }

    public Long getBuyerId()
    {
        return buyerId;
    }

    public void setBuyerId(Long buyerId)
    {
        this.buyerId = buyerId;
    }

    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }

    public Integer getType()
    {
        return type;
    }

    public void setType(Integer type)
    {
        this.type = type;
    }

    public AlibabaTradeCustomsAttributesInfo[] getAttributes()
    {
        return attributes;
    }

    public void setAttributes(AlibabaTradeCustomsAttributesInfo attributes[])
    {
        this.attributes = attributes;
    }
}

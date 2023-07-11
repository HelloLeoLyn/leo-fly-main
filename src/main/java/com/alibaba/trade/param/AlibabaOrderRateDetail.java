// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaOrderRateDetail.java

package com.alibaba.trade.param;

import java.util.Date;

public class AlibabaOrderRateDetail
{

    private Integer starLevel;
    private String content;
    private String receiverNick;
    private String posterNick;
    private Date publishTime;

    public AlibabaOrderRateDetail()
    {
    }

    public Integer getStarLevel()
    {
        return starLevel;
    }

    public void setStarLevel(Integer starLevel)
    {
        this.starLevel = starLevel;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public String getReceiverNick()
    {
        return receiverNick;
    }

    public void setReceiverNick(String receiverNick)
    {
        this.receiverNick = receiverNick;
    }

    public String getPosterNick()
    {
        return posterNick;
    }

    public void setPosterNick(String posterNick)
    {
        this.posterNick = posterNick;
    }

    public Date getPublishTime()
    {
        return publishTime;
    }

    public void setPublishTime(Date publishTime)
    {
        this.publishTime = publishTime;
    }
}

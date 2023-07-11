// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaOpenplatformTradeModelTradeTermsInfo.java

package com.alibaba.trade.param;

import java.math.BigDecimal;
import java.util.Date;

public class AlibabaOpenplatformTradeModelTradeTermsInfo
{

    private String payStatus;
    private Date payTime;
    private String payWay;
    private BigDecimal phasAmount;
    private Long phase;
    private String phaseCondition;
    private String phaseDate;
    private Boolean cardPay;
    private Boolean expressPay;

    public AlibabaOpenplatformTradeModelTradeTermsInfo()
    {
    }

    public String getPayStatus()
    {
        return payStatus;
    }

    public void setPayStatus(String payStatus)
    {
        this.payStatus = payStatus;
    }

    public Date getPayTime()
    {
        return payTime;
    }

    public void setPayTime(Date payTime)
    {
        this.payTime = payTime;
    }

    public String getPayWay()
    {
        return payWay;
    }

    public void setPayWay(String payWay)
    {
        this.payWay = payWay;
    }

    public BigDecimal getPhasAmount()
    {
        return phasAmount;
    }

    public void setPhasAmount(BigDecimal phasAmount)
    {
        this.phasAmount = phasAmount;
    }

    public Long getPhase()
    {
        return phase;
    }

    public void setPhase(Long phase)
    {
        this.phase = phase;
    }

    public String getPhaseCondition()
    {
        return phaseCondition;
    }

    public void setPhaseCondition(String phaseCondition)
    {
        this.phaseCondition = phaseCondition;
    }

    public String getPhaseDate()
    {
        return phaseDate;
    }

    public void setPhaseDate(String phaseDate)
    {
        this.phaseDate = phaseDate;
    }

    public Boolean getCardPay()
    {
        return cardPay;
    }

    public void setCardPay(Boolean cardPay)
    {
        this.cardPay = cardPay;
    }

    public Boolean getExpressPay()
    {
        return expressPay;
    }

    public void setExpressPay(Boolean expressPay)
    {
        this.expressPay = expressPay;
    }
}

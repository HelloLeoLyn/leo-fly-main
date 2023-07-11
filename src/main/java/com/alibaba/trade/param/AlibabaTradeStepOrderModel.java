// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeStepOrderModel.java

package com.alibaba.trade.param;

import java.math.BigDecimal;
import java.util.Date;

public class AlibabaTradeStepOrderModel
{

    private Long stepOrderId;
    private String stepOrderStatus;
    private Integer stepPayStatus;
    private Integer stepNo;
    private Boolean lastStep;
    private Boolean hasDisbursed;
    private BigDecimal payFee;
    private BigDecimal actualPayFee;
    private BigDecimal discountFee;
    private BigDecimal itemDiscountFee;
    private BigDecimal price;
    private Long amount;
    private BigDecimal postFee;
    private BigDecimal adjustFee;
    private Date gmtCreate;
    private Date gmtModified;
    private Date enterTime;
    private Date payTime;
    private Date sellerActionTime;
    private Date endTime;
    private String messagePath;
    private String picturePath;
    private String message;
    private Long templateId;
    private String stepName;
    private String sellerActionName;
    private Long buyerPayTimeout;
    private Long buyerConfirmTimeout;
    private Boolean needLogistics;
    private Boolean needSellerAction;
    private Boolean transferAfterConfirm;
    private Boolean needSellerCallNext;
    private Boolean instantPay;

    public AlibabaTradeStepOrderModel()
    {
    }

    public Long getStepOrderId()
    {
        return stepOrderId;
    }

    public void setStepOrderId(Long stepOrderId)
    {
        this.stepOrderId = stepOrderId;
    }

    public String getStepOrderStatus()
    {
        return stepOrderStatus;
    }

    public void setStepOrderStatus(String stepOrderStatus)
    {
        this.stepOrderStatus = stepOrderStatus;
    }

    public Integer getStepPayStatus()
    {
        return stepPayStatus;
    }

    public void setStepPayStatus(Integer stepPayStatus)
    {
        this.stepPayStatus = stepPayStatus;
    }

    public Integer getStepNo()
    {
        return stepNo;
    }

    public void setStepNo(Integer stepNo)
    {
        this.stepNo = stepNo;
    }

    public Boolean getLastStep()
    {
        return lastStep;
    }

    public void setLastStep(Boolean lastStep)
    {
        this.lastStep = lastStep;
    }

    public Boolean getHasDisbursed()
    {
        return hasDisbursed;
    }

    public void setHasDisbursed(Boolean hasDisbursed)
    {
        this.hasDisbursed = hasDisbursed;
    }

    public BigDecimal getPayFee()
    {
        return payFee;
    }

    public void setPayFee(BigDecimal payFee)
    {
        this.payFee = payFee;
    }

    public BigDecimal getActualPayFee()
    {
        return actualPayFee;
    }

    public void setActualPayFee(BigDecimal actualPayFee)
    {
        this.actualPayFee = actualPayFee;
    }

    public BigDecimal getDiscountFee()
    {
        return discountFee;
    }

    public void setDiscountFee(BigDecimal discountFee)
    {
        this.discountFee = discountFee;
    }

    public BigDecimal getItemDiscountFee()
    {
        return itemDiscountFee;
    }

    public void setItemDiscountFee(BigDecimal itemDiscountFee)
    {
        this.itemDiscountFee = itemDiscountFee;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public Long getAmount()
    {
        return amount;
    }

    public void setAmount(Long amount)
    {
        this.amount = amount;
    }

    public BigDecimal getPostFee()
    {
        return postFee;
    }

    public void setPostFee(BigDecimal postFee)
    {
        this.postFee = postFee;
    }

    public BigDecimal getAdjustFee()
    {
        return adjustFee;
    }

    public void setAdjustFee(BigDecimal adjustFee)
    {
        this.adjustFee = adjustFee;
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

    public Date getEnterTime()
    {
        return enterTime;
    }

    public void setEnterTime(Date enterTime)
    {
        this.enterTime = enterTime;
    }

    public Date getPayTime()
    {
        return payTime;
    }

    public void setPayTime(Date payTime)
    {
        this.payTime = payTime;
    }

    public Date getSellerActionTime()
    {
        return sellerActionTime;
    }

    public void setSellerActionTime(Date sellerActionTime)
    {
        this.sellerActionTime = sellerActionTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Date endTime)
    {
        this.endTime = endTime;
    }

    public String getMessagePath()
    {
        return messagePath;
    }

    public void setMessagePath(String messagePath)
    {
        this.messagePath = messagePath;
    }

    public String getPicturePath()
    {
        return picturePath;
    }

    public void setPicturePath(String picturePath)
    {
        this.picturePath = picturePath;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Long getTemplateId()
    {
        return templateId;
    }

    public void setTemplateId(Long templateId)
    {
        this.templateId = templateId;
    }

    public String getStepName()
    {
        return stepName;
    }

    public void setStepName(String stepName)
    {
        this.stepName = stepName;
    }

    public String getSellerActionName()
    {
        return sellerActionName;
    }

    public void setSellerActionName(String sellerActionName)
    {
        this.sellerActionName = sellerActionName;
    }

    public Long getBuyerPayTimeout()
    {
        return buyerPayTimeout;
    }

    public void setBuyerPayTimeout(Long buyerPayTimeout)
    {
        this.buyerPayTimeout = buyerPayTimeout;
    }

    public Long getBuyerConfirmTimeout()
    {
        return buyerConfirmTimeout;
    }

    public void setBuyerConfirmTimeout(Long buyerConfirmTimeout)
    {
        this.buyerConfirmTimeout = buyerConfirmTimeout;
    }

    public Boolean getNeedLogistics()
    {
        return needLogistics;
    }

    public void setNeedLogistics(Boolean needLogistics)
    {
        this.needLogistics = needLogistics;
    }

    public Boolean getNeedSellerAction()
    {
        return needSellerAction;
    }

    public void setNeedSellerAction(Boolean needSellerAction)
    {
        this.needSellerAction = needSellerAction;
    }

    public Boolean getTransferAfterConfirm()
    {
        return transferAfterConfirm;
    }

    public void setTransferAfterConfirm(Boolean transferAfterConfirm)
    {
        this.transferAfterConfirm = transferAfterConfirm;
    }

    public Boolean getNeedSellerCallNext()
    {
        return needSellerCallNext;
    }

    public void setNeedSellerCallNext(Boolean needSellerCallNext)
    {
        this.needSellerCallNext = needSellerCallNext;
    }

    public Boolean getInstantPay()
    {
        return instantPay;
    }

    public void setInstantPay(Boolean instantPay)
    {
        this.instantPay = instantPay;
    }
}

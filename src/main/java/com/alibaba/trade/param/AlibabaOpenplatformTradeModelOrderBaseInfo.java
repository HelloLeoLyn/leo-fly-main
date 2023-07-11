// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaOpenplatformTradeModelOrderBaseInfo.java

package com.alibaba.trade.param;

import java.math.BigDecimal;
import java.util.Date;

// Referenced classes of package com.alibaba.trade.param:
//            AlibabaTradeTradeContact, AlibabaTradeOrderReceiverInfo, AlibabaTradeStepOrderModel

public class AlibabaOpenplatformTradeModelOrderBaseInfo
{

    private Date allDeliveredTime;
    private String businessType;
    private String buyerID;
    private String buyerMemo;
    private Long buyerSubID;
    private Date completeTime;
    private Date createTime;
    private String currency;
    private Long id;
    private Date modifyTime;
    private Date payTime;
    private Date receivingTime;
    private BigDecimal refund;
    private String remark;
    private String sellerID;
    private String sellerMemo;
    private Long sellerSubID;
    private BigDecimal shippingFee;
    private String status;
    private BigDecimal totalAmount;
    private String buyerRemarkIcon;
    private String sellerRemarkIcon;
    private Long discount;
    private AlibabaTradeTradeContact buyerContact;
    private AlibabaTradeTradeContact sellerContact;
    private String tradeType;
    private String refundStatus;
    private String refundStatusForAs;
    private Long refundPayment;
    private String idOfStr;
    private String alipayTradeId;
    private AlibabaTradeOrderReceiverInfo receiverInfo;
    private String buyerLoginId;
    private String sellerLoginId;
    private Long buyerUserId;
    private Long sellerUserId;
    private String buyerAlipayId;
    private String sellerAlipayId;
    private Date confirmedTime;
    private String closeReason;
    private BigDecimal sumProductPayment;
    private AlibabaTradeStepOrderModel stepOrderList[];
    private String stepAgreementPath;
    private Boolean stepPayAll;
    private String buyerFeedback;
    private Boolean overSeaOrder;
    private String subBuyerLoginId;
    private Boolean sellerOrder;
    private Long preOrderId;
    private String refundId;
    private String flowTemplateCode;
    private String buyerLevel;
    private String sellerCreditLevel;

    public AlibabaOpenplatformTradeModelOrderBaseInfo()
    {
    }

    public Date getAllDeliveredTime()
    {
        return allDeliveredTime;
    }

    public void setAllDeliveredTime(Date allDeliveredTime)
    {
        this.allDeliveredTime = allDeliveredTime;
    }

    public String getBusinessType()
    {
        return businessType;
    }

    public void setBusinessType(String businessType)
    {
        this.businessType = businessType;
    }

    public String getBuyerID()
    {
        return buyerID;
    }

    public void setBuyerID(String buyerID)
    {
        this.buyerID = buyerID;
    }

    public String getBuyerMemo()
    {
        return buyerMemo;
    }

    public void setBuyerMemo(String buyerMemo)
    {
        this.buyerMemo = buyerMemo;
    }

    public Long getBuyerSubID()
    {
        return buyerSubID;
    }

    public void setBuyerSubID(Long buyerSubID)
    {
        this.buyerSubID = buyerSubID;
    }

    public Date getCompleteTime()
    {
        return completeTime;
    }

    public void setCompleteTime(Date completeTime)
    {
        this.completeTime = completeTime;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public String getCurrency()
    {
        return currency;
    }

    public void setCurrency(String currency)
    {
        this.currency = currency;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Date getModifyTime()
    {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime)
    {
        this.modifyTime = modifyTime;
    }

    public Date getPayTime()
    {
        return payTime;
    }

    public void setPayTime(Date payTime)
    {
        this.payTime = payTime;
    }

    public Date getReceivingTime()
    {
        return receivingTime;
    }

    public void setReceivingTime(Date receivingTime)
    {
        this.receivingTime = receivingTime;
    }

    public BigDecimal getRefund()
    {
        return refund;
    }

    public void setRefund(BigDecimal refund)
    {
        this.refund = refund;
    }

    public String getRemark()
    {
        return remark;
    }

    public void setRemark(String remark)
    {
        this.remark = remark;
    }

    public String getSellerID()
    {
        return sellerID;
    }

    public void setSellerID(String sellerID)
    {
        this.sellerID = sellerID;
    }

    public String getSellerMemo()
    {
        return sellerMemo;
    }

    public void setSellerMemo(String sellerMemo)
    {
        this.sellerMemo = sellerMemo;
    }

    public Long getSellerSubID()
    {
        return sellerSubID;
    }

    public void setSellerSubID(Long sellerSubID)
    {
        this.sellerSubID = sellerSubID;
    }

    public BigDecimal getShippingFee()
    {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee)
    {
        this.shippingFee = shippingFee;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public BigDecimal getTotalAmount()
    {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount)
    {
        this.totalAmount = totalAmount;
    }

    public String getBuyerRemarkIcon()
    {
        return buyerRemarkIcon;
    }

    public void setBuyerRemarkIcon(String buyerRemarkIcon)
    {
        this.buyerRemarkIcon = buyerRemarkIcon;
    }

    public String getSellerRemarkIcon()
    {
        return sellerRemarkIcon;
    }

    public void setSellerRemarkIcon(String sellerRemarkIcon)
    {
        this.sellerRemarkIcon = sellerRemarkIcon;
    }

    public Long getDiscount()
    {
        return discount;
    }

    public void setDiscount(Long discount)
    {
        this.discount = discount;
    }

    public AlibabaTradeTradeContact getBuyerContact()
    {
        return buyerContact;
    }

    public void setBuyerContact(AlibabaTradeTradeContact buyerContact)
    {
        this.buyerContact = buyerContact;
    }

    public AlibabaTradeTradeContact getSellerContact()
    {
        return sellerContact;
    }

    public void setSellerContact(AlibabaTradeTradeContact sellerContact)
    {
        this.sellerContact = sellerContact;
    }

    public String getTradeType()
    {
        return tradeType;
    }

    public void setTradeType(String tradeType)
    {
        this.tradeType = tradeType;
    }

    public String getRefundStatus()
    {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus)
    {
        this.refundStatus = refundStatus;
    }

    public String getRefundStatusForAs()
    {
        return refundStatusForAs;
    }

    public void setRefundStatusForAs(String refundStatusForAs)
    {
        this.refundStatusForAs = refundStatusForAs;
    }

    public Long getRefundPayment()
    {
        return refundPayment;
    }

    public void setRefundPayment(Long refundPayment)
    {
        this.refundPayment = refundPayment;
    }

    public String getIdOfStr()
    {
        return idOfStr;
    }

    public void setIdOfStr(String idOfStr)
    {
        this.idOfStr = idOfStr;
    }

    public String getAlipayTradeId()
    {
        return alipayTradeId;
    }

    public void setAlipayTradeId(String alipayTradeId)
    {
        this.alipayTradeId = alipayTradeId;
    }

    public AlibabaTradeOrderReceiverInfo getReceiverInfo()
    {
        return receiverInfo;
    }

    public void setReceiverInfo(AlibabaTradeOrderReceiverInfo receiverInfo)
    {
        this.receiverInfo = receiverInfo;
    }

    public String getBuyerLoginId()
    {
        return buyerLoginId;
    }

    public void setBuyerLoginId(String buyerLoginId)
    {
        this.buyerLoginId = buyerLoginId;
    }

    public String getSellerLoginId()
    {
        return sellerLoginId;
    }

    public void setSellerLoginId(String sellerLoginId)
    {
        this.sellerLoginId = sellerLoginId;
    }

    public Long getBuyerUserId()
    {
        return buyerUserId;
    }

    public void setBuyerUserId(Long buyerUserId)
    {
        this.buyerUserId = buyerUserId;
    }

    public Long getSellerUserId()
    {
        return sellerUserId;
    }

    public void setSellerUserId(Long sellerUserId)
    {
        this.sellerUserId = sellerUserId;
    }

    public String getBuyerAlipayId()
    {
        return buyerAlipayId;
    }

    public void setBuyerAlipayId(String buyerAlipayId)
    {
        this.buyerAlipayId = buyerAlipayId;
    }

    public String getSellerAlipayId()
    {
        return sellerAlipayId;
    }

    public void setSellerAlipayId(String sellerAlipayId)
    {
        this.sellerAlipayId = sellerAlipayId;
    }

    public Date getConfirmedTime()
    {
        return confirmedTime;
    }

    public void setConfirmedTime(Date confirmedTime)
    {
        this.confirmedTime = confirmedTime;
    }

    public String getCloseReason()
    {
        return closeReason;
    }

    public void setCloseReason(String closeReason)
    {
        this.closeReason = closeReason;
    }

    public BigDecimal getSumProductPayment()
    {
        return sumProductPayment;
    }

    public void setSumProductPayment(BigDecimal sumProductPayment)
    {
        this.sumProductPayment = sumProductPayment;
    }

    public AlibabaTradeStepOrderModel[] getStepOrderList()
    {
        return stepOrderList;
    }

    public void setStepOrderList(AlibabaTradeStepOrderModel stepOrderList[])
    {
        this.stepOrderList = stepOrderList;
    }

    public String getStepAgreementPath()
    {
        return stepAgreementPath;
    }

    public void setStepAgreementPath(String stepAgreementPath)
    {
        this.stepAgreementPath = stepAgreementPath;
    }

    public Boolean getStepPayAll()
    {
        return stepPayAll;
    }

    public void setStepPayAll(Boolean stepPayAll)
    {
        this.stepPayAll = stepPayAll;
    }

    public String getBuyerFeedback()
    {
        return buyerFeedback;
    }

    public void setBuyerFeedback(String buyerFeedback)
    {
        this.buyerFeedback = buyerFeedback;
    }

    public Boolean getOverSeaOrder()
    {
        return overSeaOrder;
    }

    public void setOverSeaOrder(Boolean overSeaOrder)
    {
        this.overSeaOrder = overSeaOrder;
    }

    public String getSubBuyerLoginId()
    {
        return subBuyerLoginId;
    }

    public void setSubBuyerLoginId(String subBuyerLoginId)
    {
        this.subBuyerLoginId = subBuyerLoginId;
    }

    public Boolean getSellerOrder()
    {
        return sellerOrder;
    }

    public void setSellerOrder(Boolean sellerOrder)
    {
        this.sellerOrder = sellerOrder;
    }

    public Long getPreOrderId()
    {
        return preOrderId;
    }

    public void setPreOrderId(Long preOrderId)
    {
        this.preOrderId = preOrderId;
    }

    public String getRefundId()
    {
        return refundId;
    }

    public void setRefundId(String refundId)
    {
        this.refundId = refundId;
    }

    public String getFlowTemplateCode()
    {
        return flowTemplateCode;
    }

    public void setFlowTemplateCode(String flowTemplateCode)
    {
        this.flowTemplateCode = flowTemplateCode;
    }

    public String getBuyerLevel()
    {
        return buyerLevel;
    }

    public void setBuyerLevel(String buyerLevel)
    {
        this.buyerLevel = buyerLevel;
    }

    public String getSellerCreditLevel()
    {
        return sellerCreditLevel;
    }

    public void setSellerCreditLevel(String sellerCreditLevel)
    {
        this.sellerCreditLevel = sellerCreditLevel;
    }
}

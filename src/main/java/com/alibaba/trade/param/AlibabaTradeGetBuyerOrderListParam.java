// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaTradeGetBuyerOrderListParam.java

package com.alibaba.trade.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;
import java.util.Date;

public class AlibabaTradeGetBuyerOrderListParam extends AbstractAPIRequest
{

    private String bizTypes[];
    private Date createEndTime;
    private Date createStartTime;
    private Boolean isHis;
    private Date modifyEndTime;
    private Date modifyStartTime;
    private String orderStatus;
    private Integer page;
    private Integer pageSize;
    private String refundStatus;
    private String sellerMemberId;
    private Integer sellerRateStatus;
    private String tradeType;
    private String productName;
    private Boolean needBuyerAddressAndPhone;
    private Boolean needMemoInfo;

    public AlibabaTradeGetBuyerOrderListParam()
    {
        oceanApiId = new APIId("com.alibaba.trade", "alibaba.trade.getBuyerOrderList", 1);
    }

    public String[] getBizTypes()
    {
        return bizTypes;
    }

    public void setBizTypes(String bizTypes[])
    {
        this.bizTypes = bizTypes;
    }

    public Date getCreateEndTime()
    {
        return createEndTime;
    }

    public void setCreateEndTime(Date createEndTime)
    {
        this.createEndTime = createEndTime;
    }

    public Date getCreateStartTime()
    {
        return createStartTime;
    }

    public void setCreateStartTime(Date createStartTime)
    {
        this.createStartTime = createStartTime;
    }

    public Boolean getIsHis()
    {
        return isHis;
    }

    public void setIsHis(Boolean isHis)
    {
        this.isHis = isHis;
    }

    public Date getModifyEndTime()
    {
        return modifyEndTime;
    }

    public void setModifyEndTime(Date modifyEndTime)
    {
        this.modifyEndTime = modifyEndTime;
    }

    public Date getModifyStartTime()
    {
        return modifyStartTime;
    }

    public void setModifyStartTime(Date modifyStartTime)
    {
        this.modifyStartTime = modifyStartTime;
    }

    public String getOrderStatus()
    {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus)
    {
        this.orderStatus = orderStatus;
    }

    public Integer getPage()
    {
        return page;
    }

    public void setPage(Integer page)
    {
        this.page = page;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public String getRefundStatus()
    {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus)
    {
        this.refundStatus = refundStatus;
    }

    public String getSellerMemberId()
    {
        return sellerMemberId;
    }

    public void setSellerMemberId(String sellerMemberId)
    {
        this.sellerMemberId = sellerMemberId;
    }

    public Integer getSellerRateStatus()
    {
        return sellerRateStatus;
    }

    public void setSellerRateStatus(Integer sellerRateStatus)
    {
        this.sellerRateStatus = sellerRateStatus;
    }

    public String getTradeType()
    {
        return tradeType;
    }

    public void setTradeType(String tradeType)
    {
        this.tradeType = tradeType;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public Boolean getNeedBuyerAddressAndPhone()
    {
        return needBuyerAddressAndPhone;
    }

    public void setNeedBuyerAddressAndPhone(Boolean needBuyerAddressAndPhone)
    {
        this.needBuyerAddressAndPhone = needBuyerAddressAndPhone;
    }

    public Boolean getNeedMemoInfo()
    {
        return needMemoInfo;
    }

    public void setNeedMemoInfo(Boolean needMemoInfo)
    {
        this.needMemoInfo = needMemoInfo;
    }
}

// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaOpenplatformTradeModelProductItemInfo.java

package com.alibaba.trade.param;

import java.math.BigDecimal;
import java.util.Date;

// Referenced classes of package com.alibaba.trade.param:
//            AlibabaOpenplatformTradeModelGuaranteeTermsInfo, AlibabaTradeSkuItemDesc

public class AlibabaOpenplatformTradeModelProductItemInfo
{

    private String cargoNumber;
    private String description;
    private BigDecimal itemAmount;
    private String name;
    private BigDecimal price;
    private Long productID;
    private String productImgUrl[];
    private String productSnapshotUrl;
    private BigDecimal quantity;
    private BigDecimal refund;
    private Long skuID;
    private Integer sort;
    private String status;
    private Long subItemID;
    private String type;
    private String unit;
    private String weight;
    private String weightUnit;
    private AlibabaOpenplatformTradeModelGuaranteeTermsInfo guaranteesTerms[];
    private String productCargoNumber;
    private AlibabaTradeSkuItemDesc skuInfos[];
    private Long entryDiscount;
    private String specId;
    private BigDecimal quantityFactor;
    private String statusStr;
    private String refundStatus;
    private String closeReason;
    private Integer logisticsStatus;
    private Date gmtCreate;
    private Date gmtModified;
    private Date gmtCompleted;
    private String gmtPayExpireTime;
    private String refundId;
    private String subItemIDString;
    private String refundIdForAs;

    public AlibabaOpenplatformTradeModelProductItemInfo()
    {
    }

    public String getCargoNumber()
    {
        return cargoNumber;
    }

    public void setCargoNumber(String cargoNumber)
    {
        this.cargoNumber = cargoNumber;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public BigDecimal getItemAmount()
    {
        return itemAmount;
    }

    public void setItemAmount(BigDecimal itemAmount)
    {
        this.itemAmount = itemAmount;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public Long getProductID()
    {
        return productID;
    }

    public void setProductID(Long productID)
    {
        this.productID = productID;
    }

    public String[] getProductImgUrl()
    {
        return productImgUrl;
    }

    public void setProductImgUrl(String productImgUrl[])
    {
        this.productImgUrl = productImgUrl;
    }

    public String getProductSnapshotUrl()
    {
        return productSnapshotUrl;
    }

    public void setProductSnapshotUrl(String productSnapshotUrl)
    {
        this.productSnapshotUrl = productSnapshotUrl;
    }

    public BigDecimal getQuantity()
    {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    public BigDecimal getRefund()
    {
        return refund;
    }

    public void setRefund(BigDecimal refund)
    {
        this.refund = refund;
    }

    public Long getSkuID()
    {
        return skuID;
    }

    public void setSkuID(Long skuID)
    {
        this.skuID = skuID;
    }

    public Integer getSort()
    {
        return sort;
    }

    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public Long getSubItemID()
    {
        return subItemID;
    }

    public void setSubItemID(Long subItemID)
    {
        this.subItemID = subItemID;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    public String getWeightUnit()
    {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit)
    {
        this.weightUnit = weightUnit;
    }

    public AlibabaOpenplatformTradeModelGuaranteeTermsInfo[] getGuaranteesTerms()
    {
        return guaranteesTerms;
    }

    public void setGuaranteesTerms(AlibabaOpenplatformTradeModelGuaranteeTermsInfo guaranteesTerms[])
    {
        this.guaranteesTerms = guaranteesTerms;
    }

    public String getProductCargoNumber()
    {
        return productCargoNumber;
    }

    public void setProductCargoNumber(String productCargoNumber)
    {
        this.productCargoNumber = productCargoNumber;
    }

    public AlibabaTradeSkuItemDesc[] getSkuInfos()
    {
        return skuInfos;
    }

    public void setSkuInfos(AlibabaTradeSkuItemDesc skuInfos[])
    {
        this.skuInfos = skuInfos;
    }

    public Long getEntryDiscount()
    {
        return entryDiscount;
    }

    public void setEntryDiscount(Long entryDiscount)
    {
        this.entryDiscount = entryDiscount;
    }

    public String getSpecId()
    {
        return specId;
    }

    public void setSpecId(String specId)
    {
        this.specId = specId;
    }

    public BigDecimal getQuantityFactor()
    {
        return quantityFactor;
    }

    public void setQuantityFactor(BigDecimal quantityFactor)
    {
        this.quantityFactor = quantityFactor;
    }

    public String getStatusStr()
    {
        return statusStr;
    }

    public void setStatusStr(String statusStr)
    {
        this.statusStr = statusStr;
    }

    public String getRefundStatus()
    {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus)
    {
        this.refundStatus = refundStatus;
    }

    public String getCloseReason()
    {
        return closeReason;
    }

    public void setCloseReason(String closeReason)
    {
        this.closeReason = closeReason;
    }

    public Integer getLogisticsStatus()
    {
        return logisticsStatus;
    }

    public void setLogisticsStatus(Integer logisticsStatus)
    {
        this.logisticsStatus = logisticsStatus;
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

    public Date getGmtCompleted()
    {
        return gmtCompleted;
    }

    public void setGmtCompleted(Date gmtCompleted)
    {
        this.gmtCompleted = gmtCompleted;
    }

    public String getGmtPayExpireTime()
    {
        return gmtPayExpireTime;
    }

    public void setGmtPayExpireTime(String gmtPayExpireTime)
    {
        this.gmtPayExpireTime = gmtPayExpireTime;
    }

    public String getRefundId()
    {
        return refundId;
    }

    public void setRefundId(String refundId)
    {
        this.refundId = refundId;
    }

    public String getSubItemIDString()
    {
        return subItemIDString;
    }

    public void setSubItemIDString(String subItemIDString)
    {
        this.subItemIDString = subItemIDString;
    }

    public String getRefundIdForAs()
    {
        return refundIdForAs;
    }

    public void setRefundIdForAs(String refundIdForAs)
    {
        this.refundIdForAs = refundIdForAs;
    }
}

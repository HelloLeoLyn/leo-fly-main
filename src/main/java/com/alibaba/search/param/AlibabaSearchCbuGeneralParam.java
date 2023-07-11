// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaSearchCbuGeneralParam.java

package com.alibaba.search.param;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.common.AbstractAPIRequest;
import java.util.Date;

public class AlibabaSearchCbuGeneralParam extends AbstractAPIRequest
{

    private Integer bizType;
    private Long category;
    private String city;
    private String descendOrder;
    private Date gmtModifiedBegin;
    private Date gmtModifiedEnd;
    private Integer pageNo;
    private Double priceStart;
    private Double priceEnd;
    private String province;
    private String q;
    private Integer quantityMin;
    private String replaceEnsure;
    private String sellerOnline;
    private String sendGoodsEnsure;
    private String sortType;

    public AlibabaSearchCbuGeneralParam()
    {
        oceanApiId = new APIId("com.alibaba.search", "alibaba.search.cbu.general", 1);
    }

    public Integer getBizType()
    {
        return bizType;
    }

    public void setBizType(Integer bizType)
    {
        this.bizType = bizType;
    }

    public Long getCategory()
    {
        return category;
    }

    public void setCategory(Long category)
    {
        this.category = category;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getDescendOrder()
    {
        return descendOrder;
    }

    public void setDescendOrder(String descendOrder)
    {
        this.descendOrder = descendOrder;
    }

    public Date getGmtModifiedBegin()
    {
        return gmtModifiedBegin;
    }

    public void setGmtModifiedBegin(Date gmtModifiedBegin)
    {
        this.gmtModifiedBegin = gmtModifiedBegin;
    }

    public Date getGmtModifiedEnd()
    {
        return gmtModifiedEnd;
    }

    public void setGmtModifiedEnd(Date gmtModifiedEnd)
    {
        this.gmtModifiedEnd = gmtModifiedEnd;
    }

    public Integer getPageNo()
    {
        return pageNo;
    }

    public void setPageNo(Integer pageNo)
    {
        this.pageNo = pageNo;
    }

    public Double getPriceStart()
    {
        return priceStart;
    }

    public void setPriceStart(Double priceStart)
    {
        this.priceStart = priceStart;
    }

    public Double getPriceEnd()
    {
        return priceEnd;
    }

    public void setPriceEnd(Double priceEnd)
    {
        this.priceEnd = priceEnd;
    }

    public String getProvince()
    {
        return province;
    }

    public void setProvince(String province)
    {
        this.province = province;
    }

    public String getQ()
    {
        return q;
    }

    public void setQ(String q)
    {
        this.q = q;
    }

    public Integer getQuantityMin()
    {
        return quantityMin;
    }

    public void setQuantityMin(Integer quantityMin)
    {
        this.quantityMin = quantityMin;
    }

    public String getReplaceEnsure()
    {
        return replaceEnsure;
    }

    public void setReplaceEnsure(String replaceEnsure)
    {
        this.replaceEnsure = replaceEnsure;
    }

    public String getSellerOnline()
    {
        return sellerOnline;
    }

    public void setSellerOnline(String sellerOnline)
    {
        this.sellerOnline = sellerOnline;
    }

    public String getSendGoodsEnsure()
    {
        return sendGoodsEnsure;
    }

    public void setSendGoodsEnsure(String sendGoodsEnsure)
    {
        this.sendGoodsEnsure = sendGoodsEnsure;
    }

    public String getSortType()
    {
        return sortType;
    }

    public void setSortType(String sortType)
    {
        this.sortType = sortType;
    }
}

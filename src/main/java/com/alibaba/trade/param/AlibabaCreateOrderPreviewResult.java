// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaCreateOrderPreviewResult.java

package com.alibaba.trade.param;


// Referenced classes of package com.alibaba.trade.param:
//            AlibabaCreateOrderPreviewResultModel

public class AlibabaCreateOrderPreviewResult
{

    private AlibabaCreateOrderPreviewResultModel orderPreviewResuslt[];
    private Boolean success;
    private String errorCode;
    private String errorMsg;
    private long postFeeByDescOfferList[];
    private long consignOfferList[];

    public AlibabaCreateOrderPreviewResult()
    {
    }

    public AlibabaCreateOrderPreviewResultModel[] getOrderPreviewResuslt()
    {
        return orderPreviewResuslt;
    }

    public void setOrderPreviewResuslt(AlibabaCreateOrderPreviewResultModel orderPreviewResuslt[])
    {
        this.orderPreviewResuslt = orderPreviewResuslt;
    }

    public Boolean getSuccess()
    {
        return success;
    }

    public void setSuccess(Boolean success)
    {
        this.success = success;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public void setErrorCode(String errorCode)
    {
        this.errorCode = errorCode;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg)
    {
        this.errorMsg = errorMsg;
    }

    public long[] getPostFeeByDescOfferList()
    {
        return postFeeByDescOfferList;
    }

    public void setPostFeeByDescOfferList(long postFeeByDescOfferList[])
    {
        this.postFeeByDescOfferList = postFeeByDescOfferList;
    }

    public long[] getConsignOfferList()
    {
        return consignOfferList;
    }

    public void setConsignOfferList(long consignOfferList[])
    {
        this.consignOfferList = consignOfferList;
    }
}

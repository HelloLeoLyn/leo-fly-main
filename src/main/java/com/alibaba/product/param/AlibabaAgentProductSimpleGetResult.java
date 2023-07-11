// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   AlibabaAgentProductSimpleGetResult.java

package com.alibaba.product.param;


// Referenced classes of package com.alibaba.product.param:
//            AlibabaProductProductInfo, AlibabaProductProductBizGroupInfo

public class AlibabaAgentProductSimpleGetResult
{

    private AlibabaProductProductInfo productInfo;
    private AlibabaProductProductBizGroupInfo bizGroupInfos[];
    private String errMsg;

    public AlibabaAgentProductSimpleGetResult()
    {
    }

    public AlibabaProductProductInfo getProductInfo()
    {
        return productInfo;
    }

    public void setProductInfo(AlibabaProductProductInfo productInfo)
    {
        this.productInfo = productInfo;
    }

    public AlibabaProductProductBizGroupInfo[] getBizGroupInfos()
    {
        return bizGroupInfos;
    }

    public void setBizGroupInfos(AlibabaProductProductBizGroupInfo bizGroupInfos[])
    {
        this.bizGroupInfos = bizGroupInfos;
    }

    public String getErrMsg()
    {
        return errMsg;
    }

    public void setErrMsg(String errMsg)
    {
        this.errMsg = errMsg;
    }
}

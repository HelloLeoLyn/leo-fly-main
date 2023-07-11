// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   RawSdkExample.java

package com.alibaba.ocean.rawsdk.example;

import com.alibaba.ocean.rawsdk.ApiExecutor;
import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.client.policy.RequestPolicy;
import com.alibaba.ocean.rawsdk.common.SDKResult;
import com.alibaba.ocean.rawsdk.example.param.ExampleFamilyGetParam;
import com.alibaba.ocean.rawsdk.example.param.ExampleFamilyPostParam;
import com.alibaba.ocean.rawsdk.example.param.ExampleFamilyPostResult;
import com.alibaba.ocean.rawsdk.util.DateUtil;
import java.io.PrintStream;

// Referenced classes of package com.alibaba.ocean.rawsdk.example:
//            RawSdkExampleData

public class RawSdkExample
{

    public RawSdkExample()
    {
    }

    public void exampleFamilyGet(ApiExecutor apiExecutor)
    {
        ExampleFamilyGetParam exampleFamilyGetParam = new ExampleFamilyGetParam();
        APIId oceanApiId = new APIId("api.example", "example.family.get", 1);
        exampleFamilyGetParam.setOceanApiId(oceanApiId);
        RequestPolicy oceanRequestPolicy = new RequestPolicy();
        oceanRequestPolicy.setHttpMethod(com.alibaba.ocean.rawsdk.client.policy.RequestPolicy.HttpMethodPolicy.POST).setNeedAuthorization(false).setRequestSendTimestamp(false).setUseHttps(false).setUseSignture(true).setAccessPrivateApi(false);
        exampleFamilyGetParam.setOceanRequestPolicy(oceanRequestPolicy);
        exampleFamilyGetParam.setFamilyNumber(Integer.valueOf(1));
        SDKResult exampleFamilyGetResult = apiExecutor.execute(exampleFamilyGetParam);
        System.out.println((new StringBuilder()).append("ExampleFamilyGet call, family information of Result:").append(exampleFamilyGetResult.getResult()).toString());
    }

    public void exampleFamilyPost(ApiExecutor apiExecutor, String accessToken)
    {
        ExampleFamilyPostParam exampleFamilyPostParam = new ExampleFamilyPostParam();
        APIId oceanApiId = new APIId("api.example", "example.family.post", 1);
        exampleFamilyPostParam.setOceanApiId(oceanApiId);
        RequestPolicy oceanRequestPolicy = new RequestPolicy();
        oceanRequestPolicy.setHttpMethod(com.alibaba.ocean.rawsdk.client.policy.RequestPolicy.HttpMethodPolicy.POST).setNeedAuthorization(false).setRequestSendTimestamp(false).setUseHttps(false).setUseSignture(true).setAccessPrivateApi(false).setDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        exampleFamilyPostParam.setOceanRequestPolicy(oceanRequestPolicy);
        exampleFamilyPostParam.setComments("Example for SDK");
        exampleFamilyPostParam.setFamily(RawSdkExampleData.createFirstFamily());
        exampleFamilyPostParam.setHouseImg(RawSdkExampleData.getPicture("example.png"));
        SDKResult exampleFamilyPostResult = apiExecutor.execute(exampleFamilyPostParam, accessToken);
        System.out.println((new StringBuilder()).append("ExampleFamilyPost call, Family information of Result:").append(((ExampleFamilyPostResult)exampleFamilyPostResult.getResult()).getResult()).toString());
        System.out.println((new StringBuilder()).append("ExampleFamilyPost call, Desc of Result:").append(((ExampleFamilyPostResult)exampleFamilyPostResult.getResult()).getResultDesc()).toString());
    }

    public static void main(String args[])
    {
        ApiExecutor apiExecutor = new ApiExecutor("{appKey}", "{appSecret}");
        RawSdkExample rawSdkExample = new RawSdkExample();
        rawSdkExample.exampleFamilyGet(apiExecutor);
        rawSdkExample.exampleFamilyPost(apiExecutor, "{the access token}");
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client.imp.serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.ocean.rawsdk.client.entity.ResponseStatus;
import com.alibaba.ocean.rawsdk.client.entity.ResponseWrapper;
import com.alibaba.ocean.rawsdk.client.policy.Protocol;
import com.alibaba.ocean.rawsdk.client.serialize.DeSerializerListener;
import com.alibaba.ocean.rawsdk.client.util.ExceptionParser;
import java.util.Map;

public class JsonDeserializer extends AbstractJsonDeserializer {
    public JsonDeserializer() {
    }

    public String supportedContentType() {
        return Protocol.json.name();
    }

    public <T> ResponseWrapper<T> deSerialize(String content, Class<T> resultType) {
        ResponseWrapper<T> responseWrapper = new ResponseWrapper();
        JSONObject rootJson = JSON.parseObject(content);
        responseWrapper.setInvokeStartTime(rootJson.getString("InvokeStartTime"));
        responseWrapper.setInvokeCostTime(rootJson.getLongValue("InvokeCostTime"));
        JSONObject statusJson = rootJson.getJSONObject("Status");
        ResponseStatus responseStatus = (ResponseStatus)this.parseResult(statusJson, ResponseStatus.class);
        responseWrapper.setStatus(responseStatus);
        JSONArray jsonResponseArray = rootJson.getJSONArray("Responses");
        JSONObject jsonResponseObject = jsonResponseArray.getJSONObject(0);
        T result = this.parseResult(jsonResponseObject, resultType);
        responseWrapper.setResult(result);
        return responseWrapper;
    }

    public Throwable buildException(String content, int statusCode) {
        Map result = (Map)JSON.parseObject(content, Map.class);
        return ExceptionParser.buildException4Json2(result);
    }

    public void registeDeSerializerListener(DeSerializerListener listner) {
    }
}

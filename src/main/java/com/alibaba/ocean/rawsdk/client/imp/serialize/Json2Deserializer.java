//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client.imp.serialize;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.ocean.rawsdk.client.entity.ResponseWrapper;
import com.alibaba.ocean.rawsdk.client.policy.Protocol;
import com.alibaba.ocean.rawsdk.client.serialize.DeSerializerListener;
import com.alibaba.ocean.rawsdk.client.util.ExceptionParser;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Json2Deserializer extends AbstractJsonDeserializer {
    private Map<Class<? extends DeSerializerListener>, DeSerializerListener> listnerList = new LinkedHashMap();

    public Json2Deserializer() {
    }

    public String supportedContentType() {
        return Protocol.json2.name();
    }

    public <T> ResponseWrapper<T> deSerialize(String content, Class<T> resultType) {
        Iterator var3 = this.listnerList.values().iterator();

        while(var3.hasNext()) {
            DeSerializerListener deSerializerListener = (DeSerializerListener)var3.next();
            deSerializerListener.onResponseDeSerialized(content);
        }

        JSONObject json = JSON.parseObject(content);
        T result = this.parseResult(json, resultType);
        ResponseWrapper<T> responseWrapper = new ResponseWrapper();
        responseWrapper.setResult(result);
        return responseWrapper;
    }

    public Throwable buildException(String content, int statusCode) {
        Iterator var3 = this.listnerList.values().iterator();

        while(var3.hasNext()) {
            DeSerializerListener deSerializerListener = (DeSerializerListener)var3.next();
            deSerializerListener.onResponseExceptioned(content);
        }

        Map result = (Map)JSON.parseObject(content, Map.class);
        return ExceptionParser.buildException4Json2(result);
    }

    public void registeDeSerializerListener(DeSerializerListener listner) {
        if (!this.listnerList.containsKey(listner.getClass())) {
            this.listnerList.put(listner.getClass(), listner);
        }

    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.common;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.client.policy.RequestPolicy;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbstractAPIRequest<TResponse> {
    protected RequestPolicy oceanRequestPolicy = new RequestPolicy();
    protected APIId oceanApiId;

    public AbstractAPIRequest() {
    }

    public RequestPolicy getOceanRequestPolicy() {
        return this.oceanRequestPolicy;
    }

    public void setOceanRequestPolicy(RequestPolicy oceanRequestPolicy) {
        this.oceanRequestPolicy = oceanRequestPolicy;
    }

    public APIId getOceanApiId() {
        return this.oceanApiId;
    }

    public void setOceanApiId(APIId oceanApiId) {
        this.oceanApiId = oceanApiId;
    }

    public Class<TResponse> getResponseClass() {
        Type type = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
        return (Class)parameterizedType.getActualTypeArguments()[0];
    }
}

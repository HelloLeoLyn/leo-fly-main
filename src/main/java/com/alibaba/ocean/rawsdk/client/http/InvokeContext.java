//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client.http;

import com.alibaba.ocean.rawsdk.client.Request;
import com.alibaba.ocean.rawsdk.client.Response;
import com.alibaba.ocean.rawsdk.client.entity.ResponseWrapper;
import com.alibaba.ocean.rawsdk.client.policy.RequestPolicy;

public class InvokeContext {
    private Request request;
    private Response response;
    private RequestPolicy policy;
    private Class<?> resultType;
    private ResponseWrapper responseWrapper;

    public InvokeContext() {
    }

    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Response getResponse() {
        return this.response;
    }

    public synchronized void setResponse(Response response) {
        this.response = response;
    }

    public RequestPolicy getPolicy() {
        return this.policy;
    }

    public void setPolicy(RequestPolicy policy) {
        this.policy = policy;
    }

    public Class<?> getResultType() {
        return this.resultType;
    }

    public void setResultType(Class<?> resultType) {
        this.resultType = resultType;
    }

    public ResponseWrapper getResponseWrapper() {
        return this.responseWrapper;
    }

    public void setResponseWrapper(ResponseWrapper responseWrapper) {
        this.responseWrapper = responseWrapper;
    }

    public synchronized void failed(Throwable exception) {
        if (this.response == null) {
            this.response = new Response();
        }

        this.response.setException(exception);
    }
}

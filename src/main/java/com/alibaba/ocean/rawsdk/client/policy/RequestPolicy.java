//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client.policy;

import com.alibaba.ocean.rawsdk.client.ErrorHandler;

public class RequestPolicy implements Cloneable {
    private boolean requestSendTimestamp = false;
    private boolean useHttps = false;
    private Protocol requestProtocol;
    private Protocol responseProtocol;
    private boolean responseCompress;
    private int requestCompressThreshold;
    private int timeout;
    private RequestPolicy.HttpMethodPolicy httpMethod;
    private String queryStringCharset;
    private String contentCharset;
    private boolean useSignture;
    private boolean needAuthorization;
    private boolean accessPrivateApi;
    private int defaultApiVersion;
    private ErrorHandler errorHandler;
    private String dateFormat;
    public static RequestPolicy authPolicy = null;

    public RequestPolicy() {
        this.requestProtocol = Protocol.param2;
        this.responseProtocol = Protocol.json2;
        this.responseCompress = true;
        this.requestCompressThreshold = -1;
        this.timeout = 5000;
        this.httpMethod = RequestPolicy.HttpMethodPolicy.POST;
        this.queryStringCharset = "GB18030";
        this.contentCharset = "UTF-8";
        this.useSignture = true;
        this.needAuthorization = false;
        this.accessPrivateApi = false;
        this.defaultApiVersion = 1;
        this.dateFormat = "yyyyMMddHHmmssSSS";
    }

    public static RequestPolicy getAuthPolicy() {
        if (authPolicy == null) {
            authPolicy = (new RequestPolicy()).setHttpMethod(RequestPolicy.HttpMethodPolicy.POST).setRequestProtocol(Protocol.param2).setUseHttps(true).setNeedAuthorization(false);
        }

        return authPolicy;
    }

    public RequestPolicy clone() {
        RequestPolicy newObj = this.newPolicy();
        newObj.requestSendTimestamp = this.requestSendTimestamp;
        newObj.useHttps = this.useHttps;
        newObj.requestProtocol = this.requestProtocol;
        newObj.responseProtocol = this.responseProtocol;
        newObj.responseCompress = this.responseCompress;
        newObj.requestCompressThreshold = this.requestCompressThreshold;
        newObj.timeout = this.timeout;
        newObj.httpMethod = this.httpMethod;
        newObj.queryStringCharset = this.queryStringCharset;
        newObj.contentCharset = this.contentCharset;
        newObj.useSignture = this.useSignture;
        newObj.accessPrivateApi = this.accessPrivateApi;
        newObj.defaultApiVersion = this.defaultApiVersion;
        return newObj;
    }

    protected RequestPolicy newPolicy() {
        return new RequestPolicy();
    }

    public RequestPolicy setRequestSendTimestamp(boolean requestSendTimestamp) {
        this.requestSendTimestamp = requestSendTimestamp;
        return this;
    }

    public boolean isRequestSendTimestamp() {
        return this.requestSendTimestamp;
    }

    public boolean isUseHttps() {
        return this.useHttps;
    }

    public RequestPolicy setUseHttps(boolean useHttps) {
        this.useHttps = useHttps;
        return this;
    }

    public RequestPolicy setRequestProtocol(Protocol protocol) {
        if (protocol == null) {
            throw new IllegalArgumentException("protocol can not be null");
        } else {
            this.requestProtocol = protocol;
            return this;
        }
    }

    public Protocol getRequestProtocol() {
        return this.requestProtocol;
    }

    public boolean isResponseCompress() {
        return this.responseCompress;
    }

    private RequestPolicy setResponseCompress(boolean responseCompress) {
        this.responseCompress = responseCompress;
        return this;
    }

    public int getRequestCompressThreshold() {
        return this.requestCompressThreshold;
    }

    public RequestPolicy setRequestCompressThreshold(int requestCompressThreshold) {
        this.requestCompressThreshold = requestCompressThreshold;
        return this;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public RequestPolicy setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public RequestPolicy setHttpMethod(RequestPolicy.HttpMethodPolicy httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public RequestPolicy.HttpMethodPolicy getHttpMethod() {
        return this.httpMethod;
    }

    public String getQueryStringCharset() {
        return this.queryStringCharset;
    }

    public RequestPolicy setQueryStringCharset(String queryStringCharset) {
        this.queryStringCharset = queryStringCharset;
        return this;
    }

    public String getContentCharset() {
        return this.contentCharset;
    }

    public RequestPolicy setContentCharset(String contentCharset) {
        this.contentCharset = contentCharset;
        return this;
    }

    public RequestPolicy setResponseProtocol(Protocol responseProtocol) {
        if (this.requestProtocol == null) {
            throw new IllegalArgumentException("response protocol can not be null");
        } else {
            this.responseProtocol = responseProtocol;
            return this;
        }
    }

    public Protocol getResponseProtocol() {
        return this.responseProtocol;
    }

    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    public RequestPolicy setErrorHandler(ErrorHandler errorHandler) {
        this.errorHandler = errorHandler;
        return this;
    }

    public boolean isUseSignture() {
        return this.useSignture;
    }

    public RequestPolicy setUseSignture(boolean useSignture) {
        this.useSignture = useSignture;
        return this;
    }

    public boolean isNeedAuthorization() {
        return this.needAuthorization;
    }

    public RequestPolicy setNeedAuthorization(boolean needAuthorization) {
        this.needAuthorization = needAuthorization;
        return this;
    }

    public boolean isAccessPrivateApi() {
        return this.accessPrivateApi;
    }

    public RequestPolicy setAccessPrivateApi(boolean accessPrivateApi) {
        this.accessPrivateApi = accessPrivateApi;
        return this;
    }

    public int getDefaultApiVersion() {
        return this.defaultApiVersion;
    }

    public String getDateFormat() {
        return this.dateFormat;
    }

    public RequestPolicy setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public static enum HttpMethodPolicy {
        POST,
        GET;

        private HttpMethodPolicy() {
        }
    }
}

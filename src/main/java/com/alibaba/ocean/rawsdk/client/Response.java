//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client;

import com.alibaba.ocean.rawsdk.client.entity.ResponseWrapper;

public class Response {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private int statusCode;
    private Object result;
    private Throwable exception;
    private String charset = "UTF-8";
    private String encoding;
    private ResponseWrapper responseWrapper;

    public Response() {
    }

    public Response setResult(Object result) {
        this.result = result;
        return this;
    }

    public Object getResult() {
        return this.result;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Throwable getException() {
        return this.exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

    public String getCharset() {
        return this.charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getEncoding() {
        return this.encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }
}

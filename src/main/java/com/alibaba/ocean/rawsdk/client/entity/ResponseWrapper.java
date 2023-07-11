//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client.entity;

public class ResponseWrapper<T> {
    private String invokeStartTime;
    private long invokeCostTime;
    private ResponseStatus status;
    private T result;
    private String signature;

    public ResponseWrapper() {
    }

    public String getInvokeStartTime() {
        return this.invokeStartTime;
    }

    public void setInvokeStartTime(String invokeStartTime) {
        this.invokeStartTime = invokeStartTime;
    }

    public long getInvokeCostTime() {
        return this.invokeCostTime;
    }

    public void setInvokeCostTime(long invokeCostTime) {
        this.invokeCostTime = invokeCostTime;
    }

    public ResponseStatus getStatus() {
        return this.status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

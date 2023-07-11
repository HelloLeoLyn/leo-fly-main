//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.common;

public class SDKResult<T> {
    private String errorCode;
    private String errorMessage;
    private T result;

    public SDKResult(String code, String message) {
        this.errorCode = code;
        this.errorMessage = message;
    }

    public SDKResult(T result) {
        this.result = result;
    }

    public SDKResult() {
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

}

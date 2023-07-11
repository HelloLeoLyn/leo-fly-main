package com.leo.fly.common.exception;

import com.leo.fly.common.service.BaseErrorEnum;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ComException extends RuntimeException {

    private BaseErrorEnum baseErrorEnum;
    private String message;
    private Throwable cause;


    public ComException(BaseErrorEnum baseErrorEnum, String message) {
        super(baseErrorEnum.getI18Remark());
        this.message = message;
        this.baseErrorEnum = baseErrorEnum;
    }

    public ComException(BaseErrorEnum baseErrorEnum) {
        super(baseErrorEnum.getI18Remark());
        this.message = baseErrorEnum.getI18Remark();
        this.baseErrorEnum = baseErrorEnum;
    }


    public ComException(Throwable e, BaseErrorEnum baseErrorEnum) {
        if (e instanceof ComException) {
            throw (ComException) e;
        }
        this.cause = e;
        this.baseErrorEnum = baseErrorEnum;
    }


}

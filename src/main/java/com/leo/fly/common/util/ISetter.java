package com.leo.fly.common.util;

import java.io.Serializable;

@FunctionalInterface
public interface ISetter<T,R> extends Serializable {
    void set(T t, R r);
}

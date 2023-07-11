package com.leo.fly.common.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class ObjectUtils {

    public static boolean isEmpty(final Object object) {
        if (object == null) {
            return true;
        }
        if (object instanceof CharSequence) {
            return ((CharSequence) object).length() == 0;
        }
        if (object.getClass().isArray()) {
            return Array.getLength(object) == 0;
        }
        if (object instanceof Collection<?>) {
            return ((Collection<?>) object).isEmpty();
        }
        if (object instanceof Map<?, ?>) {
            return ((Map<?, ?>) object).isEmpty();
        }
        return false;
    }
    public static boolean isNotEmpty(final Object object) {
        return !isEmpty(object);
    }

    public static boolean equalsNum(Number a, Number b){
        if(a==null&&b==null){
            return true;
        }
        if(a==null){
            return false;
        }
        if(b==null){
            return false;
        }
        if(a==b){
            return true;
        }
        return false;
    }

    public static boolean isNullFalse(Boolean obj){
        if(obj==null){
            return false;
        }
        return obj;
    }
    public static String boolean2String(Boolean obj){
        return boolean2Number(obj) + "";
    }
    public static Integer boolean2Number(Boolean obj){
        if(obj==null||obj==false){
            return 0;
        }
        return 1;
    }
}

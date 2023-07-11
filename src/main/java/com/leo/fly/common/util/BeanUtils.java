package com.leo.fly.common.util;



import java.util.Map;

public class BeanUtils {
    public static Map<String,String> describe(Object object){
        return MapUtils.tranferBean2StringMap(object);
    }

    public static void copyProperties(Object source, Object target){
        org.springframework.beans.BeanUtils.copyProperties(source,target);
    }
    public static void copyProperties(Object source, Object target,String... ignoreProperties){
        org.springframework.beans.BeanUtils.copyProperties(source,target,ignoreProperties);
    }
}

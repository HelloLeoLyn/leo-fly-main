package com.leo.fly.sys.components;

import com.leo.fly.common.util.MD5Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EncodePasswordComponent {
    @Value(value = "${leo.fly.keys.pri}")
    String priKey;

    public String encode(String  type,String str){
        return MD5Util.string2MD5(str+priKey);
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client.serialize;

import com.alibaba.ocean.rawsdk.client.entity.ResponseWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public interface DeSerializer {
    String supportedContentType();

    <T> ResponseWrapper<T> deSerialize(InputStream var1, Class<T> var2, String var3) throws IOException, ParseException;

    Throwable buildException(InputStream var1, int var2, String var3) throws IOException, ParseException;

    void registeDeSerializerListener(DeSerializerListener var1);
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client.imp.serialize;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.ocean.rawsdk.client.entity.ResponseWrapper;
import com.alibaba.ocean.rawsdk.client.serialize.DeSerializer;
import com.alibaba.ocean.rawsdk.client.util.LoggerHelper;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;

public abstract class AbstractJsonDeserializer implements DeSerializer {
    public AbstractJsonDeserializer() {
    }

    public abstract <T> ResponseWrapper<T> deSerialize(String var1, Class<T> var2);

    public abstract Throwable buildException(String var1, int var2);

    public <T> ResponseWrapper<T> deSerialize(InputStream istream, Class<T> resultType, String charSet) throws IOException, ParseException {
        LoggerHelper.getClientLogger().finer("Parse body by json.");
        String content = this.getStreamAsString(istream, charSet);
        return this.deSerialize(content, resultType);
    }

    public Throwable buildException(InputStream inputStream, int statusCode, String charSet) throws IOException, ParseException {
        LoggerHelper.getClientLogger().finer("Parse body by json.");
        String content = this.getStreamAsString(inputStream, charSet);
        return this.buildException(content, statusCode);
    }

    protected <T> T parseResult(JSONObject json, Class<T> resultType) {
        LoggerHelper.getClientLogger().finer("Parse body by json.");
        T result = json.toJavaObject(resultType);
        return result;
    }

    private String getStreamAsString(InputStream stream, String charset) throws IOException {
        Reader reader = new InputStreamReader(stream, charset);
        StringBuilder response = new StringBuilder();
        char[] buff = new char[1024];
        boolean var6 = false;

        int read;
        while((read = reader.read(buff)) > 0) {
            response.append(buff, 0, read);
        }

        return response.toString();
    }
}

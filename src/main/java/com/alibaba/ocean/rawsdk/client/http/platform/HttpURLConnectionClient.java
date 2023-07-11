//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client.http.platform;

import com.alibaba.ocean.rawsdk.client.Response;
import com.alibaba.ocean.rawsdk.client.http.AbstractHttpClient;
import com.alibaba.ocean.rawsdk.client.http.HttpResponseBuilder;
import com.alibaba.ocean.rawsdk.client.http.HttpSupport;
import com.alibaba.ocean.rawsdk.client.http.InvokeContext;
import com.alibaba.ocean.rawsdk.client.policy.ClientPolicy;
import com.alibaba.ocean.rawsdk.client.serialize.DeSerializerListener;
import com.alibaba.ocean.rawsdk.client.serialize.SerializerProvider;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HttpURLConnectionClient extends AbstractHttpClient {
    public HttpURLConnectionClient(SerializerProvider serializerProvider, HttpResponseBuilder responseBuilder) {
        super(serializerProvider, responseBuilder);
    }

    protected Response doMultipartPost(URL url, Map<String, Object> parameters, InvokeContext invokeContext, ClientPolicy clientPolicy, Collection<DeSerializerListener> deSerializerListners) throws IOException {
        HttpURLConnection conn = null;
        Response response = null;
        String BOUNDARY = "---------------------------123821742118716";
        DataOutputStream out = null;

        try {
            conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            Map<String, String> clientHttpHeader = HttpSupport.buildHttpHeader(invokeContext, clientPolicy);
            Iterator var11 = clientHttpHeader.entrySet().iterator();

            while(var11.hasNext()) {
                Entry<String, String> entry = (Entry)var11.next();
                conn.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
            }

            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            out = new DataOutputStream(conn.getOutputStream());
            StringBuffer strBuf = new StringBuffer();
            Iterator iter = parameters.entrySet().iterator();

            while(true) {
                while(true) {
                    String inputName;
                    Object inputValue;
                    Byte[] inputBytes;
                    do {
                        if (!iter.hasNext()) {
                            int httpCode = conn.getResponseCode();
                            inputName = conn.getContentEncoding();
                            String contentType = conn.getContentType();
                            inputBytes = null;
                            InputStream inputStream;
                            if (httpCode >= 200 && httpCode <= 299) {
                                inputStream = conn.getInputStream();
                            } else {
                                inputStream = conn.getErrorStream();
                            }

                            response = this.getResponseBuilder().buildResponse(inputStream, httpCode, inputName, contentType, invokeContext, deSerializerListners);
                            return response;
                        }

                        Entry<String, Object> entry = (Entry)iter.next();
                        inputName = (String)entry.getKey();
                        inputValue = entry.getValue();
                    } while(inputValue == null);

                    if (!inputValue.getClass().isAssignableFrom(byte[].class) && !inputValue.getClass().isAssignableFrom(Byte[].class)) {
                        strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                        strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");
                        strBuf.append(inputValue);
                        out.write(strBuf.toString().getBytes());
                    } else {
                        strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");
                        strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\"\r\n");
                        strBuf.append("Content-Type:application/x-www-form-urlencoded\r\n\r\n");
                        out.write(strBuf.toString().getBytes());
                        if (inputValue instanceof byte[]) {
                            byte[] inputBytes2 = (byte[])((byte[])inputValue);
                            out.write(inputBytes2);
                        }

                        if (inputValue instanceof Byte[]) {
                            inputBytes = (Byte[])((Byte[])inputValue);
                            Byte[] var17 = inputBytes;
                            int var18 = inputBytes.length;

                            for(int var19 = 0; var19 < var18; ++var19) {
                                Byte b = var17[var19];
                                out.write(b);
                            }
                        }
                    }
                }
            }
        } catch (IOException var24) {
            throw var24;
        } finally {
            if (out != null) {
                out.close();
            }

            if (conn != null) {
                conn.disconnect();
            }

        }
    }

    protected Response doPost(URL url, Map<String, Object> parameters, InvokeContext invokeContext, ClientPolicy clientPolicy, Collection<DeSerializerListener> deSerializerListners) throws IOException {
        HttpURLConnection conn = null;
        OutputStream out = null;
        Response response = null;

        try {
            try {
                conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                Map<String, String> clientHttpHeader = HttpSupport.buildHttpHeader(invokeContext, clientPolicy);
                Iterator var10 = clientHttpHeader.entrySet().iterator();

                while(var10.hasNext()) {
                    Entry<String, String> entry = (Entry)var10.next();
                    conn.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
                }
            } catch (IOException var20) {
                throw var20;
            }

            try {
                String query = HttpSupport.buildQuery(parameters);
                byte[] content = new byte[0];
                if (query != null) {
                    content = query.getBytes(invokeContext.getPolicy().getContentCharset());
                }

                out = conn.getOutputStream();
                out.write(content);
                int httpCode = conn.getResponseCode();
                String contentEncoding = conn.getContentEncoding();
                String contentType = conn.getContentType();
                InputStream inputStream = null;
                if (httpCode >= 200 && httpCode <= 299) {
                    inputStream = conn.getInputStream();
                } else {
                    inputStream = conn.getErrorStream();
                }

                response = this.getResponseBuilder().buildResponse(inputStream, httpCode, contentEncoding, contentType, invokeContext, deSerializerListners);
            } catch (IOException var19) {
                throw var19;
            }
        } finally {
            if (out != null) {
                out.close();
            }

            if (conn != null) {
                conn.disconnect();
            }

        }

        return response;
    }

    protected Response doGet(URL url, Map<String, Object> parameters, InvokeContext invokeContext, ClientPolicy clientPolicy, Collection<DeSerializerListener> deSerializerListners) throws IOException {
        HttpURLConnection conn = null;
        OutputStream out = null;
        Response response = null;

        try {
            try {
                conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                Map<String, String> clientHttpHeader = HttpSupport.buildHttpHeader(invokeContext, clientPolicy);
                Iterator var10 = clientHttpHeader.entrySet().iterator();

                while(var10.hasNext()) {
                    Entry<String, String> entry = (Entry)var10.next();
                    conn.setRequestProperty((String)entry.getKey(), (String)entry.getValue());
                }
            } catch (IOException var18) {
                throw var18;
            }

            try {
                int httpCode = conn.getResponseCode();
                String contentEncoding = conn.getContentEncoding();
                String contentType = conn.getContentType();
                InputStream inputStream = null;
                if (httpCode >= 200 && httpCode <= 299) {
                    inputStream = conn.getInputStream();
                } else {
                    inputStream = conn.getErrorStream();
                }

                response = this.getResponseBuilder().buildResponse(inputStream, httpCode, contentEncoding, contentType, invokeContext, deSerializerListners);
            } catch (IOException var17) {
                throw var17;
            }
        } finally {
            if (out != null) {
                ((OutputStream)out).close();
            }

            if (conn != null) {
                conn.disconnect();
            }

        }

        return response;
    }
}

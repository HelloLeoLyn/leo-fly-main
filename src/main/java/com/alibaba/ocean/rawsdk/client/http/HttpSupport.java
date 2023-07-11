// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   HttpSupport.java

package com.alibaba.ocean.rawsdk.client.http;

import com.alibaba.ocean.rawsdk.client.APIId;
import com.alibaba.ocean.rawsdk.client.Request;
import com.alibaba.ocean.rawsdk.client.policy.*;
import com.alibaba.ocean.rawsdk.client.serialize.Serializer;
import com.alibaba.ocean.rawsdk.util.*;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

// Referenced classes of package com.alibaba.ocean.rawsdk.client.http:
//            InvokeContext

public final class HttpSupport
{

    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    public static final char QUERY_STRING_SEPARATOR = 63;
    public static final char PARAMETER_SEPARATOR = 38;
    public static final char NAME_VALUE_SEPARATOR = 61;
    public static final String PARAM_NAME_SIGNATURE = "_aop_signature";
    public static final String PARAM_NAME_TIMESTAMP = "_aop_timestamp";
    public static final String PARAM_NAME_DATEPATTERN = "_aop_datePattern";
    public static final String PARAM_NAME_RESPONSE_FORMAT = "_aop_responseFormat";
    public static final String PARAM_NAME_ACCESS_TOKEY = "access_token";

    public HttpSupport()
    {
    }

    public static final Map buildHttpHeader(InvokeContext context, ClientPolicy clientPolicy)
    {
        Map header = new LinkedHashMap();
        header.put("Accept", "text/xml,text/javascript,application/json");
        header.put("User-Agent", clientPolicy.getAgent());
        return header;
    }

    public static final StringBuilder getApiRequestPath(RequestPolicy requestPolicy)
    {
        StringBuilder path = new StringBuilder();
        if(requestPolicy.isAccessPrivateApi())
            path.append("/api");
        else
            path.append("/openapi");
        return path;
    }

    public static StringBuilder getProtocolRequestPath(InvokeContext context, ClientPolicy clientPolicy)
    {
        StringBuilder path = new StringBuilder();
        path.append(context.getPolicy().getRequestProtocol().name()).append('/');
        Request request = context.getRequest();
        if(request.getApiId().getVersion() < 0)
            path.append(context.getPolicy().getDefaultApiVersion());
        else
            path.append(request.getApiId().getVersion());
        path.append('/').append(request.getApiId().getNamespace()).append('/').append(request.getApiId().getName());
        if(clientPolicy.getAppKey() != null)
            path.append('/').append(clientPolicy.getAppKey());
        return path;
    }

    public static Map buildParams(Serializer serializer, InvokeContext context)
    {
        Map serializerMap = serializer.serialize(context.getRequest().getRequestEntity());
        serializerMap.putAll(context.getRequest().getAddtionalParams());
        RequestPolicy requestPolicy = context.getPolicy();
        if(!requestPolicy.getRequestProtocol().equals(requestPolicy.getResponseProtocol()))
            serializerMap.put("_aop_responseFormat", requestPolicy.getResponseProtocol().name());
        if(requestPolicy.isRequestSendTimestamp())
            serializerMap.put("_aop_timestamp", Long.valueOf(System.currentTimeMillis()));
        if(requestPolicy.getDateFormat() != null)
            serializerMap.put("_aop_datePattern", requestPolicy.getDateFormat());
        else
            serializerMap.put("_aop_datePattern", "yyyy-MM-dd HH:mm:ss.SSS");
        return serializerMap;
    }

    public static void signature(StringBuilder protocolRequestPath, Map parameters, RequestPolicy requestPolicy, ClientPolicy clientPolicy)
    {
        if(!requestPolicy.isUseSignture())
            return;
        if(GenericsUtil.isBlank(clientPolicy.getAppKey()) || clientPolicy.getSigningKey() == null)
        {
            return;
        } else
        {
            byte sign[] = SignatureUtil.hmacSha1(protocolRequestPath.toString(), parameters, clientPolicy.getSigningKey());
            String signedContent = SignatureUtil.encodeHexStr(sign);
            parameters.put("_aop_signature", signedContent);
            return;
        }
    }

    public static String buildQuery(Map params)
        throws IOException
    {
        if(params == null || params.isEmpty())
            return "";
        StringBuilder query = new StringBuilder();
        Set entries = params.entrySet();
        boolean hasParam = false;
        Iterator iterator = entries.iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            String name = (String)entry.getKey();
            Object value = entry.getValue();
            if(value != null)
            {
                if(hasParam)
                    query.append("&");
                else
                    hasParam = true;
                query.append(name).append("=").append(URLEncoder.encode(String.valueOf(value), "utf-8"));
            }
        } while(true);
        return query.toString();
    }

    public static URL buildGetRequestUrl(ClientPolicy clientPolicy, InvokeContext context, Map params)
        throws IOException
    {
        String protocol = "http";
        String host = clientPolicy.getServerHost();
        int port = clientPolicy.getHttpPort();
        if(context.getPolicy().isUseHttps())
        {
            protocol = "https";
            port = clientPolicy.getHttpsPort();
        }
        StringBuilder pathSB = getApiRequestPath(context.getPolicy());
        StringBuilder proptolRequestPath = getProtocolRequestPath(context, clientPolicy);
        pathSB.append("/").append(proptolRequestPath.toString());
        String query = buildQuery(params);
        if(!GenericsUtil.isBlank(query))
        {
            pathSB.append("?");
            pathSB.append(query);
        }
        return new URL(protocol, host, port, pathSB.toString());
    }

    public static URL buildPostRequestUrl(ClientPolicy clientPolicy, InvokeContext context, Map params)
        throws IOException
    {
        String protocol = "http";
        String host = clientPolicy.getServerHost();
        int port = clientPolicy.getHttpPort();
        if(context.getPolicy().isUseHttps())
        {
            protocol = "https";
            port = clientPolicy.getHttpsPort();
        }
        StringBuilder pathSB = getApiRequestPath(context.getPolicy());
        StringBuilder proptolRequestPath = getProtocolRequestPath(context, clientPolicy);
        pathSB.append("/").append(proptolRequestPath.toString());
        return new URL(protocol, host, port, pathSB.toString());
    }

    public static String parseResponseCharset(RequestPolicy requestPolicy, String ctype)
    {
        String charset = requestPolicy.getContentCharset();
        if(!GenericsUtil.isBlank(ctype))
        {
            String params[] = ctype.split(";");
            String as[] = params;
            int i = as.length;
            int j = 0;
            do
            {
                if(j >= i)
                    break;
                String param = as[j];
                param = param.trim();
                if(param.startsWith("charset"))
                {
                    String pair[] = param.split("=", 2);
                    if(pair.length == 2 && !GenericsUtil.isBlank(pair[1]))
                        charset = pair[1].trim();
                    break;
                }
                j++;
            } while(true);
        }
        return charset;
    }
}

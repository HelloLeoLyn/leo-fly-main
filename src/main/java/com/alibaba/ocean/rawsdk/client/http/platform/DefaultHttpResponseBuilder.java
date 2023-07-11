// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst 
// Source File Name:   DefaultHttpResponseBuilder.java

package com.alibaba.ocean.rawsdk.client.http.platform;

import com.alibaba.ocean.rawsdk.client.Response;
import com.alibaba.ocean.rawsdk.client.entity.ResponseWrapper;
import com.alibaba.ocean.rawsdk.client.http.*;
import com.alibaba.ocean.rawsdk.client.policy.*;
import com.alibaba.ocean.rawsdk.client.serialize.*;
import com.alibaba.ocean.rawsdk.client.util.LoggerHelper;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

public class DefaultHttpResponseBuilder
    implements HttpResponseBuilder
{

    private static final String HEADER_NAME_CONTENT_ENCODING = "Content-Encoding";
    protected static final String CONTENT_ENCODING_GZIP = "gzip";
    private static final String HEADER_NAME_CONTENT_TYPE = "Content-Type";
    private static final String HEADER_FLAG_CONTENT_TYPE_CHARSET = ";charset=";
    private static final int HEADER_FLAG_LENGTH_CONTENT_TYPE_CHARSET = ";charset=".length();
    protected ClientPolicy clientPolicy;
    private SerializerProvider serializerProvider;

    public DefaultHttpResponseBuilder(ClientPolicy clientPolicy, SerializerProvider serializerProvider)
    {
        this.clientPolicy = clientPolicy;
        this.serializerProvider = serializerProvider;
    }

    protected Object parseBody(InputStream istream, Class resultType, InvokeContext invokeContext, Collection deSerializerListners)
        throws IOException, ParseException
    {
        Protocol protocol = invokeContext.getPolicy().getResponseProtocol();
        if(protocol == null)
            protocol = invokeContext.getPolicy().getRequestProtocol();
        DeSerializer deSerializer = serializerProvider.getDeSerializer(protocol.name());
        DeSerializerListener srializerListener;
        for(Iterator iterator = deSerializerListners.iterator(); iterator.hasNext(); deSerializer.registeDeSerializerListener(srializerListener))
            srializerListener = (DeSerializerListener)iterator.next();

        ResponseWrapper responseWrapper = deSerializer.deSerialize(istream, resultType, invokeContext.getResponse().getCharset());
        invokeContext.setResponseWrapper(responseWrapper);
        return responseWrapper.getResult();
    }

    protected Throwable buildException(InputStream istream, int statusCode, InvokeContext invokeContext, Collection deSerializerListners)
        throws IOException, ParseException
    {
        Protocol protocol = invokeContext.getPolicy().getResponseProtocol();
        if(protocol == null)
            protocol = invokeContext.getPolicy().getRequestProtocol();
        DeSerializer deSerializer = serializerProvider.getDeSerializer(protocol.name());
        if(deSerializer == null)
            throw new RuntimeException((new StringBuilder()).append("The Protocol[").append(protocol.name()).append("] is not supported when parse the response.").toString());
        DeSerializerListener srializerListener;
        for(Iterator iterator = deSerializerListners.iterator(); iterator.hasNext(); deSerializer.registeDeSerializerListener(srializerListener))
            srializerListener = (DeSerializerListener)iterator.next();

        Throwable rhrowable = deSerializer.buildException(istream, statusCode, invokeContext.getResponse().getCharset());
        return rhrowable;
    }

    public Response buildResponse(InputStream istream, int httpCode, String contentEncoding, String contentType, InvokeContext invokeContext, Collection deSerializerListners)
    {
        LoggerHelper.getClientLogger().finer("--Start init Response--");
        Response response = new Response();
        invokeContext.setResponse(response);
        response.setStatusCode(httpCode);
        if(contentEncoding != null)
            response.setEncoding(contentEncoding);
        if(contentType == null)
        {
            response.setException(new IllegalStateException("response need content type"));
        } else
        {
            String charset = HttpSupport.parseResponseCharset(invokeContext.getPolicy(), contentType);
            response.setCharset(charset);
        }
        try
        {
            if("gzip".equalsIgnoreCase(response.getEncoding()))
            {
                LoggerHelper.getClientLogger().finer(" translate InputStream to GZIPInputStream ");
                istream = new GZIPInputStream(istream);
            }
            LoggerHelper.getClientLogger().finer((new StringBuilder()).append("Response status code :").append(response.getStatusCode()).toString());
            if(response.getStatusCode() >= 200 && response.getStatusCode() <= 399)
            {
                Object result = parseBody(istream, invokeContext.getResultType(), invokeContext, deSerializerListners);
                response.setResult(result);
            } else
            {
                Throwable exception = buildException(istream, response.getStatusCode(), invokeContext, deSerializerListners);
                response.setException(exception);
            }
        }
        catch(IOException e)
        {
            response.setException(e);
        }
        catch(RuntimeException e)
        {
            response.setException(e);
        }
        catch(ParseException e)
        {
            response.setException(e);
        }
        return response;
    }

    public ClientPolicy getClientPolicy()
    {
        return clientPolicy;
    }

}

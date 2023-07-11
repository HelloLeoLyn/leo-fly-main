//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client.http;

import com.alibaba.ocean.rawsdk.client.Response;
import com.alibaba.ocean.rawsdk.client.policy.ClientPolicy;
import com.alibaba.ocean.rawsdk.client.policy.Protocol;
import com.alibaba.ocean.rawsdk.client.policy.RequestPolicy.HttpMethodPolicy;
import com.alibaba.ocean.rawsdk.client.serialize.DeSerializerListener;
import com.alibaba.ocean.rawsdk.client.serialize.Serializer;
import com.alibaba.ocean.rawsdk.client.serialize.SerializerListener;
import com.alibaba.ocean.rawsdk.client.serialize.SerializerProvider;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class AbstractHttpClient {
    private SerializerProvider serializerProvider;
    private HttpResponseBuilder responseBuilder;

    public AbstractHttpClient(SerializerProvider serializerProvider, HttpResponseBuilder responseBuilder) {
        this.serializerProvider = serializerProvider;
        this.responseBuilder = responseBuilder;
    }

    public Response request(InvokeContext invokeContext, ClientPolicy clientPolicy, Collection<SerializerListener> serializerListners, Collection<DeSerializerListener> deSerializerListners) throws IOException {
        StringBuilder protocolRequestPath = HttpSupport.getProtocolRequestPath(invokeContext, clientPolicy);
        Protocol protocol = invokeContext.getPolicy().getRequestProtocol();
        Serializer serializer = this.serializerProvider.getSerializer(protocol.name());
        Iterator var8 = serializerListners.iterator();

        while(var8.hasNext()) {
            SerializerListener serializerListener = (SerializerListener)var8.next();
            serializer.registeSerializerListener(serializerListener);
        }

        Map<String, Object> parameters = HttpSupport.buildParams(serializer, invokeContext);
        HttpSupport.signature(protocolRequestPath, parameters, invokeContext.getPolicy(), clientPolicy);
        Response response;
        URL postURL;
        if (HttpMethodPolicy.GET.equals(invokeContext.getPolicy().getHttpMethod())) {
            postURL = HttpSupport.buildGetRequestUrl(clientPolicy, invokeContext, parameters);
            response = this.doGet(postURL, parameters, invokeContext, clientPolicy, deSerializerListners);
            return response;
        } else {
            postURL = HttpSupport.buildPostRequestUrl(clientPolicy, invokeContext, parameters);
            Iterator var10 = parameters.entrySet().iterator();

            Object inputValue;
            do {
                if (!var10.hasNext()) {
                    response = this.doPost(postURL, parameters, invokeContext, clientPolicy, deSerializerListners);
                    return response;
                }

                Entry<String, Object> entry = (Entry)var10.next();
                inputValue = entry.getValue();
            } while(!inputValue.getClass().isAssignableFrom(byte[].class) && !inputValue.getClass().isAssignableFrom(Byte[].class));

            return this.doMultipartPost(postURL, parameters, invokeContext, clientPolicy, deSerializerListners);
        }
    }

    protected abstract Response doMultipartPost(URL var1, Map<String, Object> var2, InvokeContext var3, ClientPolicy var4, Collection<DeSerializerListener> var5) throws IOException;

    protected abstract Response doPost(URL var1, Map<String, Object> var2, InvokeContext var3, ClientPolicy var4, Collection<DeSerializerListener> var5) throws IOException;

    protected abstract Response doGet(URL var1, Map<String, Object> var2, InvokeContext var3, ClientPolicy var4, Collection<DeSerializerListener> var5) throws IOException;

    public SerializerProvider getSerializerProvider() {
        return this.serializerProvider;
    }

    public HttpResponseBuilder getResponseBuilder() {
        return this.responseBuilder;
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client.imp.serialize;

import com.alibaba.ocean.rawsdk.client.entity.ResponseWrapper;
import com.alibaba.ocean.rawsdk.client.policy.Protocol;
import com.alibaba.ocean.rawsdk.client.serialize.DeSerializer;
import com.alibaba.ocean.rawsdk.client.serialize.DeSerializerListener;
import com.alibaba.ocean.rawsdk.client.util.LoggerHelper;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Xml2Deserializer implements DeSerializer {
    public Xml2Deserializer() {
    }

    public String supportedContentType() {
        return Protocol.xml2.name();
    }

    public <T> ResponseWrapper<T> deSerialize(InputStream istream, Class<T> resultType, String charSet) throws IOException, ParseException {
        LoggerHelper.getClientLogger().finer("Parse body by xml2.");

        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(istream);
            NodeList nodeList = document.getChildNodes();
            Node root = nodeList.item(0);
            ResponseWrapper responseWrapper;
            if (Map.class.isAssignableFrom(resultType)) {
                Map result = new LinkedHashMap();
                this.deserializeMap(root, result);
                responseWrapper = new ResponseWrapper();
                responseWrapper.setResult(result);
                return responseWrapper;
            } else if (List.class.isAssignableFrom(resultType)) {
                List result = new ArrayList();
                this.deserializeList(root, result);
                responseWrapper = new ResponseWrapper();
                responseWrapper.setResult(result);
                return responseWrapper;
            } else {
                throw new RuntimeException(this.supportedContentType() + " only supported Map and List as result type.");
            }
        } catch (Exception var11) {
            throw new RuntimeException("Exception occured when parse response.", var11);
        }
    }

    private void deserializeList(Node propertyNode, List result) throws IOException, ParseException {
        NodeList childrenNodeList = propertyNode.getChildNodes();

        for(int i = 0; i < childrenNodeList.getLength(); ++i) {
            childrenNodeList.item(i);
            Object object = this.deserialize(propertyNode);
            result.add(object);
        }

    }

    private void deserializeMap(Node propertyNode, Map result) throws IOException, ParseException {
        NodeList childrenNodeList = propertyNode.getChildNodes();

        for(int i = 0; i < childrenNodeList.getLength(); ++i) {
            Node child = childrenNodeList.item(i);
            Object object = this.deserialize(propertyNode);
            Object extObject = result.get(child.getLocalName());
            if (extObject != null) {
                if (extObject instanceof List) {
                    List extOjbectList = (List)extObject;
                    extOjbectList.add(object);
                } else {
                    List extOjbectList = new ArrayList();
                    extOjbectList.add(extObject);
                    extOjbectList.add(object);
                    result.put(child.getLocalName(), extOjbectList);
                }
            } else {
                result.put(child.getLocalName(), object);
            }
        }

    }

    private Object deserialize(Node propertyNode) throws IOException, ParseException {
        if (propertyNode.hasChildNodes()) {
            Node child = propertyNode.getFirstChild();
            if (this.isOceanXMLRootArray(child)) {
                List result = new ArrayList();
                this.deserializeList(propertyNode, result);
                return result;
            } else {
                Map result = new LinkedHashMap();
                this.deserializeMap(propertyNode, result);
                return result;
            }
        } else {
            String nodeValue = propertyNode.getNodeValue();
            return nodeValue;
        }
    }

    private boolean isOceanXMLRootArray(Node node) {
        return "list".equals(node.getLocalName()) || "item".equals(node.getLocalName());
    }

    public Throwable buildException(InputStream inputStream, int statusCode, String charSet) throws IOException, ParseException {
        throw new UnsupportedOperationException();
    }

    public void registeDeSerializerListener(DeSerializerListener listner) {
    }
}

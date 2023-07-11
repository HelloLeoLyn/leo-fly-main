package com.leo.fly.common.util;

import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsoupUtils {
    public static void generateJsoupCookie(Connection connect, String url) throws IOException {
        if (StringUtils.isBlank(url)) {
            return;
        }
        Map<String, String> cookys = Jsoup.connect(url).ignoreContentType(true).execute().cookies();
        connect.cookies(cookys);
    }

    public static Document post(String url, String authUrl, Map<String, String> param,
                                Map<String, String> headers) throws IOException {
        Connection connect = Jsoup.connect(url);
        setConnetionHeaders(connect, headers);
        generateJsoupCookie(connect, authUrl);
        setConnetionParam(connect, param);
        connect.ignoreContentType(true);
        return connect.post();
    }

    public static Document post(String url, String authUrl, Map<String, String> param,
                                Map<String, String> headers, String charset) throws IOException {
        Connection connect = Jsoup.connect(url);
        setConnetionHeaders(connect, headers);
        generateJsoupCookie(connect, authUrl);
        setConnetionParam(connect, param);
        connect.ignoreContentType(true);
        connect.response().charset(charset);
        return connect.post();
    }

    public static Document get(String url) throws IOException {
        Connection connect = Jsoup.connect(url);
        connect.ignoreContentType(true);
        return connect.get();
    }

    private static void setConnetionParam(Connection connect, Map<String, String> param) {
        if (param == null) {
            return;
        }
        param.forEach((k, v) -> {
            connect.data(k, v);
        });
    }

    private static void setConnetionHeaders(Connection connect, Map<String, String> headers) {
        if (headers == null) {
            return;
        }
        headers.forEach((k, v) -> {
            connect.header(k, v);
        });
    }

    public static List<String> parseNode(Node nodeSource, List<String> list) {
        List<Node> childNodes = nodeSource.childNodes();
        if (childNodes.size() > 0) {
            for (Node node : childNodes) {
                if (node instanceof Element) {
                    parseNode(node, list);
                } else {
                    if (StringUtils.isBlank(node.toString().trim())) {
                        continue;
                    }
                    if (node.toString().indexOf("<!") > -1) {
                        continue;
                    }
                    list.add(node.toString().trim());
                }

            }

        }
        return list;
    }

    public static void parseNodeToString(Node nodeSource, StringBuilder builder) {
        List<Node> childNodes = nodeSource.childNodes();
        if (childNodes.size() > 0) {
            for (Node node : childNodes) {
                if (node instanceof Element) {
                    parseNodeToString(node, builder);
                } else {
                    if (StringUtils.isBlank(node.toString().trim())) {
                        continue;
                    }
                    if (node.toString().indexOf("<!") > -1) {
                        continue;
                    }
                    builder.append(node.toString().trim());
                }

            }

        }
    }

    public static String parseNodeToString(Node nodeSource) {
        StringBuilder builder = new StringBuilder();
        parseNodeToString(nodeSource, builder);
        return builder.toString();
    }

    public static List<String> parseNode(Node nodeSource) {
        List<String> list = new ArrayList<String>();
        parseNode(nodeSource, list);
        return list;
    }

    public static List<String> parseToArrayString(Elements nodes) {
        List<String> list = new ArrayList<String>();
        nodes.forEach((node) -> {
            list.add(parseNodeToString(node));
        });
        return list;
    }

    public static Document parseLocalHtml(String filepath) throws IOException {
        File file = new File(filepath);

        if (!file.exists()) {
            throw new ComException(ErrorCodeEnum.E_FILE_NOT_EXISTS);
        }
        return Jsoup.parse(file, null);
    }

//    public static void main(String[] args) throws IOException {
////        File file = new File("C:\\Users\\54112\\Desktop\\Free Icons _ Font Awesome.html");
//        Document document = JsoupUtils.get("https://www.alibaba.com/trade/search?fsb=y&IndexArea=product_en&CatId=&SearchText=203+420+01+20&selectedTab=product_en");
////        Document document = Jsoup.parse(file,"UTF8","");
//        Elements li = document.getElementsByClass("J-offer-wrapper");
////        Elements li = iconSet.getElementsByTag("li");
//        List<String> list = new ArrayList<>();
//        for(Element e : li){
//            Elements a = e.getElementsByTag("a");
//            Element element = a.get(0);
//            System.out.println(element);
//        }
//        System.out.println(JSONObject.toJSONString(list));
//    }
}

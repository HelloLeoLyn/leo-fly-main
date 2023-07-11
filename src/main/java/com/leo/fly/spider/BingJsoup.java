package com.leo.fly.spider;

import com.leo.fly.common.util.JsoupUtils;
import com.leo.fly.common.util.ObjectUtils;
import lombok.SneakyThrows;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BingJsoup {

    @SneakyThrows
    public static List getByCode(String code) {
        List list = new ArrayList();
        Document document = JsoupUtils.get("https://cn.bing.com/images/search?q="+code+"&qft=+filterui:imagesize-custom_1000_1000&form=IRFLTR&first=1&tsc=ImageHoverTitle");
        Elements dgControl_list_ = document.getElementsByClass("dgControl_list ");
        if(ObjectUtils.isNotEmpty(dgControl_list_)){
            for (Element element: dgControl_list_){
                Elements children = element.children();
                for (Element child: children){
                    Elements img_badges = child.getElementsByClass("img_badges");
                    Map map = new HashMap<String,String>();
                    String href = img_badges.get(0).child(0).child(0).attr("href");
                    map.put("url", href);
                    map.put("style",child.attr("style"));
                    list.add(map);
                }
            }
        }
        return list;
    }
}

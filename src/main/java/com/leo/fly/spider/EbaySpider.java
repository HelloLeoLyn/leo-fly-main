package com.leo.fly.spider;

import com.leo.fly.common.util.JsoupUtils;
import lombok.SneakyThrows;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class EbaySpider {
    @SneakyThrows
    public List<String> getImagesByJsoup(String detailUrl){
        Document document = JsoupUtils.get(detailUrl);
        Elements items = document.getElementsByClass("ux-image-filmstrip-carousel-item");
        List<String> imagesUrl = new ArrayList<>();
        for (Element item : items){
            Elements img = item.getElementsByTag("img");
            if(img.size()>0){
                imagesUrl.add(img.get(0).attr("src"));
            }
        }
        return imagesUrl;
    }


    @SneakyThrows
    public List<Map<String,Object>> getItemsByJsoup(String url) {
        Document document = JsoupUtils.get(url);
        Elements items = document.getElementsByClass("s-item--watch-at-corner");
        List<Map<String,Object>> list = new ArrayList<>();
        for (Element item : items){
            Elements a = item.child(0).child(0).getElementsByTag("a");
            Elements img = item.child(0).child(0).getElementsByTag("img");
            String subject = item.getElementsByClass("s-item__title").get(0).child(0).text();
            Map<String,Object> child = new HashMap<>();
            List<String> images = new ArrayList<>();
            images.add(img.get(0).attr("src"));
            child.put("images",images);
            child.put("subject",subject);
            child.put("detailUrl",a.get(0).attr("href"));
            list.add(child);
        }
        return list;
    }
}

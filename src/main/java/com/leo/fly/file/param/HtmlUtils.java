package com.leo.fly.file.param;

import com.leo.fly.common.util.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

public class HtmlUtils {
    public static String toHtmlNode(String tag, String text, Map<String,String> attr){
        StringBuilder sb = new StringBuilder("\n");
        sb.append("<").append(tag).append(" ");
        if(ObjectUtils.isNotEmpty(attr)){
            attr.forEach((k,v)->{
                if(ObjectUtils.isNotEmpty(v)){
                    sb.append(k).append("=").append("'").append(v).append("'").append(" ");
                }else{
                    sb.append(k).append(" ");
                }
            });
        }
        sb.append(">").append("\n").append(text).append("\n").append("</").append(tag).append(">");
        return sb.toString();
    }

    public static Map<String, String> eventsMap(String nodeName) {
        Map<String, String> eventsMap = new HashMap<>();
        String refName = "vue" + nodeName.hashCode();
        eventsMap.put("ref", refName);
        eventsMap.put(":class", "{ clickActive: targetClickRef == '" + refName + "', hover: targetMouseRef == '" + refName + "' }");
        eventsMap.put("@mouseenter.native", "(e) => handleMouseEnter(e, '" + refName + "')");
        eventsMap.put("@mouseleave.native", "(e) => handleMouseLeave(e, '" + refName + "')");
        eventsMap.put("@click.native", "(e) => handleCompsClick(e, '" + refName + "')");
        return eventsMap;
    }

}

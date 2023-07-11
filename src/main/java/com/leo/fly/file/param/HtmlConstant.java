package com.leo.fly.file.param;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HtmlConstant {
    public static String handleMouseEnterFunc = "\n handleMouseEnter(e, refName) {\n  this.targetMouseRef = refName;\n     },";

    public static String handleMouseLeaveFunc = "\n handleMouseLeave(e, refName) {\n  this.targetMouseRef = \"\";\n     },";

    public static String handleCompsClickFunc = "\n handleCompsClick(e, refName) {\n  this.targetClickRef = refName;\n     let left = this.$refs[refName].getBoundingClientRect().left;\n     let top = this.$refs[refName].getBoundingClientRect().top - 80;},";

    public static String elements = "\n elements(el) {\n         let ele = parseHtml(el, 0);\n         return ele;\n     },";

    public static String[] func = {handleMouseEnterFunc,handleMouseLeaveFunc,handleCompsClickFunc,elements};

    public static Map<String, String> classMap;

    public static Map<String, String> styleAttr;

    public static Map<String,String> vueDataMap;
    static {
        Map<String,String> temp = new HashMap<>();
        temp.put(".hover:hover", "{ border: 1px solid #03a9f3; }");
        temp.put(".clickActive", "{ border: 1px solid #03a9f3; }");
        classMap = Collections.unmodifiableMap(temp);

        Map<String,String> temp2 = new HashMap<>();
        temp2.put("scoped", null);
        temp2.put("lang", "scss");
        styleAttr = Collections.unmodifiableMap(temp2);

        Map<String,String> temp3 = new HashMap<>();
        temp3.put("targetClickRef", "''");
        temp3.put("targetMouseRef", "''");
        vueDataMap = Collections.unmodifiableMap(temp3);

    }
}

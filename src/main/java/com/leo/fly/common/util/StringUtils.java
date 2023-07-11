package com.leo.fly.common.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    /**
     * 非空判断
     * @param string
     * @return
     */
    public static boolean isNotBlank(String string) {
        return !isBlank(string);
    }


    public static boolean equals(String str1, String str2) {
        return str1.equals(str2);
    }

    public static boolean notEquals(String str1, String str2) {
        return !equals(str1, str2);
    }

    public static boolean isEmpty(String str) {
        return org.springframework.util.StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }


    public static String defaultIfBlank(String str, String defaultStr) {
        return StringUtils.isBlank(str) ? defaultStr : str;
    }


    public static boolean isBlank(String str) {
        if (str == null) {
            return true;
        }

        if (str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); ++i) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将布尔类型转为Integer
     * @param flag
     * @return
     */
    public static int convertBooleanToInteger(boolean flag) {
        if (flag)
            return 1;
        return 0;
    }

    /**
     * 数组转String
     * @param array
     * @return
     */
    public static String ArrayToString(Collection array) {
        if (array == null || array.size() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.size(); i++) {
            sb.append(array + "");
        }
        return sb.toString();
    }

    public static String ArrayToString(String[] array) {
        if (array == null || array.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (String temp : array) {
            sb.append(temp);
        }
        return sb.toString();
    }

    public static String MapToString(Map map) {
        StringBuilder sb = new StringBuilder();
        map.forEach((k, v) -> sb.append(k).append(v).append("\n"));
        return sb.toString();
    }

    public static String ArrayToString(List<String> array) {
        if (array == null || array.size() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (String temp : array) {
            sb.append(temp).append(" ");
        }
        return sb.toString();
    }

    public static String CollectionToString(Collection<String> array) {
        if (array == null || array.size() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (String temp : array) {
            sb.append(temp);
        }
        return sb.toString();
    }

    public static String[] listToArray(Collection<String> list) {
        String[] array = new String[list.size()];
        return list.toArray(array);
    }

    public static String[] setToArray(Set<String> set) {
        if (set == null || set.size() == 0) {
            return null;
        }
        set.stream().sorted();
        String[] array = new String[set.size()];
        return set.toArray(array);
    }

    public static int listIndex(String[] a, String target) {
        for (int i = 0; i < a.length; i++) {
            if (StringUtils.equals(target, a[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String addZeroLeft(String str, int strLength) {
        return addCharacter(str, strLength, Boolean.TRUE);
    }

    public static String addCharacter(String str, int strLength, boolean position) {
        int strLen = str.length();
        if (strLen < strLength) {
            while (strLen < strLength) {
                StringBuffer sb = new StringBuffer();
                if (position) {
                    sb.append("0").append(str);// 左补0
                } else {
                    sb.append(str).append("0");//右补0
                }
                str = sb.toString();
                strLen = str.length();
            }
        }
        return str;
    }

    public static boolean isSpace(String str) {
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isWhitespace(ch[i])) return true;
        }
        return false;
    }

    /**
     * 首字母大写
     * @param name
     * @return
     */
    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return  name;
    }

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    /** 下划线转驼峰 */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /** 驼峰转下划线,效率比上面高 */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
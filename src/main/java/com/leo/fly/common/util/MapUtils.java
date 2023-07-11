package com.leo.fly.common.util;

import com.alibaba.fastjson.JSONObject;
import com.leo.fly.common.enums.ErrorCodeEnum;
import com.leo.fly.common.exception.ComException;
import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * <p>
 * Title: MapUtils.java
 * </p>
 * <p>
 * Description:类型下画线Key 转小写驼峰形式
 * </p>
 * <p>
 * Company:
 * </p>
 *
 * @author Leo.Lyn @date 2020年6月10日 @version 1.0
 */
public class MapUtils {

    /**
     * 处理 Map 类型
     *
     * @param map
     */
    public static void processMap(Map<String, Object> map) {
        Set<String> keySet = new HashSet<String>(map.keySet());
        for (String key : keySet) {
            // 大写开头的会将整个字符串转换为小写，如果包含下划线也会处理为驼峰
            if ((key.charAt(0) >= 'A' && key.charAt(0) <= 'Z') || key.indexOf("_") >= 0) {
                Object value = map.get(key);
                map.remove(key);
                map.put(underlineToCamelhump(key), value);
            }
        }
    }

    /**
     * 将下划线风格替换为驼峰风格
     *
     * @param inputString
     * @return
     */
    public static String underlineToCamelhump(String inputString) {
        StringBuilder sb = new StringBuilder();

        boolean nextUpperCase = false;
        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == '_') {
                if (sb.length() > 0) {
                    nextUpperCase = true;
                }
            } else {
                if (nextUpperCase) {
                    sb.append(Character.toUpperCase(c));
                    nextUpperCase = false;
                } else {
                    sb.append(Character.toLowerCase(c));
                }
            }
        }
        return sb.toString();
    }

    /**
     * 将List中map的key值命名方式格式化为驼峰
     *
     * @param
     * @return
     */
    public static List<Map<String, Object>> formatHumpNameForList(List<Map<String, Object>> list) {
        for (Map<String, Object> o : list) {
            processMap(o);
        }
        return list;
    }

    // bean 转化为map
    public static Map<String, Object> tranferBean2Map(Object obj) throws Exception {
        // obj为空，结束方法
        if (obj == null)
            return null;
        Map<String, Object> map = new HashMap<String, Object>();
        /*
         * Introspector 类为通过工具学习有关受目标 Java Bean 支持的属性、事件和方法的知识提供了一个标准方法。 java的自省机制
         */
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] ps = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : ps) {
            String key = propertyDescriptor.getName();

            if (!"class".equals(key)) {
                Method getter = propertyDescriptor.getReadMethod();
                Object value = getter.invoke(obj);
                map.put(key, value);
            }
        }
        return map;

    }

    // bean 转化为map
    public static Map<String, String> tranferBean2StringMap(Object obj) {
        // obj为空，结束方法
        if (obj == null)
            return null;
        Map<String, String> map = new HashMap<>();
        /*
         * Introspector 类为通过工具学习有关受目标 Java Bean 支持的属性、事件和方法的知识提供了一个标准方法。 java的自省机制
         */

        BeanInfo beanInfo = null;
        try {
            beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] ps = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : ps) {
                String key = propertyDescriptor.getName();

                if (!"class".equals(key)) {
                    Method getter = propertyDescriptor.getReadMethod();
                    Object value = getter.invoke(obj);
                    map.put(key, value + "");
                }
            }
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            throw new ComException(ErrorCodeEnum.E_MAP_TO_BEAN);
        }

        return map;

    }

    // map转换为javaBean
    public static <T extends Object> T transferMap2Bean(Map<String, Object> map, Class<T> clazz) throws InstantiationException, IllegalAccessException, IntrospectionException, IllegalArgumentException, InvocationTargetException {
        T instance = clazz.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
        PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : descriptors) {
            String key = property.getName();
            if (map.containsKey(key)) {
                Object value = map.get(key);
                Method setter = property.getWriteMethod();
                setter.invoke(instance, value);
            }
        }
        return instance;
    }

    // bean 转化为map
    public static Map<String, Object> Bean2Map(Object obj) {
        // obj为空，结束方法
        if (obj == null)
            return null;
        Map<String, Object> map = new HashMap<String, Object>();
        /*
         * Introspector 类为通过工具学习有关受目标 Java Bean 支持的属性、事件和方法的知识提供了一个标准方法。 java的自省机制
         */
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] ps = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor propertyDescriptor : ps) {
                String key = propertyDescriptor.getName();
                Class<?> propertyType = propertyDescriptor.getPropertyType();
                if (propertyType.getName().equals("java.lang.Double")
                        ||propertyType.getName().equals("java.lang.Integer")
                        ||propertyType.getName().equals("java.lang.String")
                        ||propertyType.getName().equals("java.lang.Boolean")) {
                    if (!"class".equals(key)) {
                        Method getter = propertyDescriptor.getReadMethod();
                        Object value = getter.invoke(obj);
                        map.put(key, value);
                    }
                }
            }
            return map;
        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
            throw new ComException(ErrorCodeEnum.E_MAP_TO_BEAN);
        }
    }

    public static Map<String,Object> getJsonToMap(String path){
        Map<String,Object>  map = new LinkedHashMap();
        try {
            //路径
            File file = ResourceUtils.getFile("classpath:" + path);
            //读取文件信息
            String str = FileUtils.readFileToString(file,"UTF8");
            //转换为Map对象
            map = JSONObject.parseObject(str, LinkedHashMap.class);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

}
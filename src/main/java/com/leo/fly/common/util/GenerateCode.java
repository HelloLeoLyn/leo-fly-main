package com.leo.fly.common.util;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GenerateCode {

    public static void generateJSON(Class obj) {
        Field[] declaredFields = obj.getDeclaredFields();
        List<JSONObject> attributes = new ArrayList<>();
        List<JSONObject> columns = new ArrayList<>();
        Map<String,Object> dictionary = new HashMap<>();
        JSONObject dataForm = new JSONObject();
        for (Field field : declaredFields) {
            JSONObject attribute = new JSONObject();
            attribute.put("attrName", field.getName());
            attribute.put("attrLabel", field.getName());
            attribute.put("attrValue", field.getName());
            attribute.put("attrType", field.getType());
            attributes.add(attribute);

            JSONObject column = new JSONObject();
            column.put("title", field.getName().toUpperCase());
            column.put("field", field.getName());
            column.put("type", field.getType());
            columns.add(column);
            dataForm.put(field.getName(), "");
            dictionary.put(field.getName(),field);
        }
        JSONObject object = new JSONObject();
        object.put("attributes", attributes);
        object.put("columns", columns);
        object.put("dictionary", dictionary);
        object.put("dataForm", dataForm);
        object.put("queryForm", dataForm);
        object.put("allKeys",attributes.stream().map(a->a.getString("attrName")).collect(Collectors.toList()));
        System.out.println(object.toJSONString());
    }

    public static void generateJSONNew(Class obj) {
        Field[] declaredFields = obj.getDeclaredFields();
        List<JSONObject> columns = new ArrayList<>();
        Map<String,Object> dictionary = new HashMap<>();
        JSONObject dataForm = new JSONObject();
        for (Field field : declaredFields) {
            JSONObject dictionaryItem = new JSONObject();
            dictionaryItem.put("declaringClass",field.getDeclaringClass());
            dictionaryItem.put("genericType",field.getGenericType());
            dictionaryItem.put("type",field.getType());
            dictionaryItem.put("htmlTag","input");
            dictionaryItem.put("name",field.getName());
            dictionaryItem.put("title", StringUtils.captureName(field.getName()));
            dictionary.put(field.getName(),dictionaryItem);

            JSONObject column = new JSONObject();
            column.put("attrName",field.getName());
            column.put("attrValue", StringUtils.captureName(field.getName()));
            column.put("children",null);
            column.put("htmlTag","b-form-input");
            columns.add(column);

            dataForm.put(field.getName(), "");
        }
        JSONObject object = new JSONObject();
        object.put("dictionary", dictionary);
        object.put("allKeys",columns.stream().map(a->a.getString("attrName")).collect(Collectors.toList()));
        object.put("ignoreKeysOfCreate",new ArrayList<String>());
        object.put("ignoreKeysOfRead",new ArrayList<String>());
        object.put("ignoreKeysOfUpdate",new ArrayList<String>());
        object.put("ignoreKeysOfColumns",new ArrayList<String>());
        object.put("columns", columns);
        object.put("dataForm", dataForm);
        object.put("queryForm", dataForm);
        object.put("actionForm", dataForm);
        object.forEach((key,value)->{
            System.out.println(String.format("%s%s%s%s","export const ", key, " = ", JSONObject.toJSONString(value)));
        });
    }
}

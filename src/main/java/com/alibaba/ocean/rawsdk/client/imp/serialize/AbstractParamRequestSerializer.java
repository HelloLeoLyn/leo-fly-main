//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.client.imp.serialize;

import com.alibaba.ocean.rawsdk.client.serialize.Serializer;
import com.alibaba.ocean.rawsdk.client.serialize.SerializerListener;
import com.alibaba.ocean.rawsdk.util.DateUtil;
import com.alibaba.ocean.rawsdk.util.DefaultPropertyUtils;
import com.alibaba.ocean.rawsdk.util.GenericsUtil;
import com.alibaba.ocean.rawsdk.util.SimplePropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractParamRequestSerializer implements Serializer {
    private Map<Class<? extends SerializerListener>, SerializerListener> listnerList = new LinkedHashMap();

    public AbstractParamRequestSerializer() {
    }

    protected abstract String processNestedParameter(Object var1);

    public Map<String, Object> serialize(Object serializer) {
        if (serializer == null) {
            return new LinkedHashMap();
        } else {
            Map<String, Object> params = new LinkedHashMap();
            SimplePropertyDescriptor[] propertyDescriptors = DefaultPropertyUtils.getPropertyDescriptors(serializer.getClass());
            SimplePropertyDescriptor[] var4 = propertyDescriptors;
            int var5 = propertyDescriptors.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                SimplePropertyDescriptor propertyDescriptor = var4[var6];
                String name = propertyDescriptor.getName();
                if (!name.equals("class")) {
                    try {
                        Method method = propertyDescriptor.getReadMethod();
                        if (method == null && Boolean.class.isAssignableFrom(propertyDescriptor.getPropertyType())) {
                            Method booleanMethod = null;

                            try {
                                booleanMethod = serializer.getClass().getMethod("is" + GenericsUtil.capitalize(name));
                            } catch (NoSuchMethodException var13) {
                                ;
                            } catch (SecurityException var14) {
                                ;
                            }

                            method = booleanMethod;
                        }

                        if (method == null) {
                            throw new RuntimeException("Could not parse the property[" + name + "] of " + serializer.getClass().getSimpleName());
                        }

                        Object value = method.invoke(serializer);
                        if (value != null) {
                            Class<?> valueType = value.getClass();
                            String valueStr;
                            if (!valueType.isPrimitive() && !CharSequence.class.isAssignableFrom(valueType) && !Number.class.isAssignableFrom(valueType) && !Boolean.class.equals(valueType) && !Character.class.equals(valueType)) {
                                if (Date.class.isAssignableFrom(valueType)) {
                                    valueStr = DateUtil.format((Date)value);
                                } else {
                                    valueStr = this.processNestedParameter(value);
                                }
                            } else {
                                valueStr = value.toString();
                            }

                            params.put(name, valueStr);
                        }
                    } catch (InvocationTargetException var15) {
                        throw new IllegalArgumentException("illegal argument " + name + ", error:" + var15.getMessage(), var15);
                    } catch (IllegalAccessException var16) {
                        throw new IllegalArgumentException("illegal argument " + name + ", error:" + var16.getMessage(), var16);
                    } catch (IllegalArgumentException var17) {
                        throw new IllegalArgumentException("illegal argument " + name + ", error:" + var17.getMessage(), var17);
                    }
                }
            }

            Iterator var18 = this.listnerList.values().iterator();

            while(var18.hasNext()) {
                SerializerListener serializerListener = (SerializerListener)var18.next();
                serializerListener.onRequestSerialized(params);
            }

            return params;
        }
    }

    public void registeSerializerListener(SerializerListener listner) {
        if (!this.listnerList.containsKey(listner.getClass())) {
            this.listnerList.put(listner.getClass(), listner);
        }

    }
}

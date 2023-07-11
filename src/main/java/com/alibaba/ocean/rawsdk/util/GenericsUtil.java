//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.alibaba.ocean.rawsdk.util;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

public final class GenericsUtil {
    private static final String CHARSET_NAME_UTF8 = "UTF-8";

    private GenericsUtil() {
    }

    public static Class<?> getInterfaceGenricType(Class<?> clazz, Class<?> interfaceClass) {
        return getInterfaceGenricType(clazz, interfaceClass, 0);
    }

    public static Class<?> getTypeParameterClass(Class<?> clazz, String name) {
        TypeVariable<?>[] types = clazz.getTypeParameters();
        if (types != null && types.length > 0) {
            for(int i = 0; i < types.length; ++i) {
                if (name.equals(types[i].getName())) {
                    System.out.println(types[i].getGenericDeclaration());
                    Type[] bounds;
                    if (types[i] instanceof WildcardType) {
                        bounds = ((WildcardType)types[i]).getLowerBounds();
                    } else {
                        bounds = types[i].getBounds();
                    }

                    if (bounds != null && bounds.length > 0) {
                        if (bounds[0] instanceof TypeVariable) {
                            return getTypeParameterClass(clazz, ((TypeVariable)bounds[0]).getName());
                        }

                        if (bounds[0] instanceof Class) {
                            return (Class)bounds[0];
                        }
                    }

                    return null;
                }
            }
        }

        return null;
    }

    public static Class<?> getInterfaceGenricType(Class<?> clazz, Class<?> interfaceClass, int typeIndex) {
        Type[] interfaceTypes = clazz.getGenericInterfaces();
        if (interfaceTypes != null && interfaceTypes.length > 0) {
            for(int i = 0; i < interfaceTypes.length; ++i) {
                Type interfaceType = interfaceTypes[i];
                if (interfaceType instanceof ParameterizedType && interfaceClass.isAssignableFrom((Class)((ParameterizedType)interfaceType).getRawType())) {
                    Type[] params = ((ParameterizedType)interfaceType).getActualTypeArguments();
                    Class<?>[] types = new Class[params.length];

                    for(int j = 0; j < params.length; ++j) {
                        if (params[i] instanceof Class) {
                            types[i] = (Class)params[i];
                        } else if (params[i] instanceof WildcardType) {
                            Type[] lowerBounds = ((WildcardType)params[i]).getLowerBounds();
                            if (lowerBounds != null && lowerBounds.length > 0 && lowerBounds[0] instanceof Class) {
                                types[i] = (Class)lowerBounds[0];
                            }
                        } else if (params[i] instanceof TypeVariable) {
                            types[i] = getTypeParameterClass(clazz, ((TypeVariable)params[i]).getName());
                        } else {
                            types[i] = Object.class;
                        }
                    }

                    if (typeIndex < types.length && typeIndex >= 0) {
                        return types[typeIndex];
                    }

                    return null;
                }
            }
        }

        return null;
    }

    public static Class<?> getMethodGenericReturnType(Method method, Class<?> rawType, int index) {
        Type returnType = method.getGenericReturnType();
        return getGenericType(returnType, rawType, index);
    }

    public static Class<?> getRawType(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType)type;
            return getRawType(ptype.getRawType());
        } else {
            return type instanceof Class ? (Class)type : null;
        }
    }

    public static Class<?> getGenericType(Type type, Class<?> rawType, int index) {
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType)type;
            if (rawType.equals(ptype.getRawType())) {
                Type[] typeArguments = ptype.getActualTypeArguments();
                if (index < typeArguments.length && index >= 0) {
                    return getRawType(typeArguments[index]);
                }

                throw new RuntimeException("index " + (index < 0 ? " must large then 0" : "out of arguments count"));
            }
        }

        return null;
    }

    public static Class<?>[] getGenericType(Type type) {
        if (type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType)type;
            Type[] typeArguments = ptype.getActualTypeArguments();
            Class<?>[] types = new Class[typeArguments.length];
            System.arraycopy(typeArguments, 0, types, 0, types.length);
            return types;
        } else {
            return null;
        }
    }

    public static String encodeBase64Str(byte[] bytes) {
        return bytes == null ? null : toString(Base64.encodeBase64(bytes));
    }

    public static byte[] decodeBase64Str(String str) {
        if (str == null) {
            return null;
        } else {
            try {
                return Base64.decodeBase64(toBytes(str));
            } catch (RuntimeException var2) {
                throw new RuntimeException(var2.getMessage(), var2);
            }
        }
    }

    private static String toString(byte[] bytes) {
        if (bytes == null) {
            return null;
        } else {
            try {
                return new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException var2) {
                throw new RuntimeException(var2.getMessage(), var2);
            }
        }
    }

    private static byte[] toBytes(String str) {
        if (str == null) {
            return null;
        } else {
            try {
                return str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException var2) {
                throw new RuntimeException(var2.getMessage(), var2);
            }
        }
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static String capitalize(String str) {
        int strLen;
        return str != null && (strLen = str.length()) != 0 ? (new StringBuffer(strLen)).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1)).toString() : str;
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        } else {
            int sz = str.length();

            for(int i = 0; i < sz; ++i) {
                if (!Character.isDigit(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }
}

package com.leo.fly.common.util;

import java.math.BigDecimal;

public class MathUtils {
    public static long getAbsLong(Long value) {
        return value < 0 ? -value : value;
    }


    /**
     * 取余数
     *
     * @param source
     * @param limit
     * @return
     */
    public static int surplus(int source, int limit) {
        int num1 = 0;
        int num2 = 0;
        while (source >= limit) {
            num1 = source % limit;    //取余
            num2 = source / limit;    //除以10
            source = num1 + num2;
        }
        return source;
    }

    public static BigDecimal mul(Object... args) {
        BigDecimal res;
        if (args.length < 2) {
            return null;
        } else {
            if (args[0] instanceof BigDecimal) {
                res = (BigDecimal) args[0];
            } else if (args[0] instanceof String || args[0] instanceof Integer) {
                res = (BigDecimal) args[0];
            } else {
                return null;
            }
            for (int i = 1; i < args.length; i++) {
                BigDecimal tmp;
                if (args[i] instanceof BigDecimal) {
                    tmp = (BigDecimal) args[i];
                    res = res.multiply(tmp);
                } else if (args[i] instanceof String || args[i] instanceof Integer) {
                    tmp = new BigDecimal(args[i] + "");
                    res = res.multiply(tmp);
                } else {
                    return null;
                }
            }
            return res;
        }
    }

    public static BigDecimal div(Object... args) {
        BigDecimal res;
        if (args.length < 2) {
            return null;
        } else {
            if (args[0] instanceof BigDecimal) {
                res = (BigDecimal) args[0];
            } else if (args[0] instanceof String || args[0] instanceof Integer) {
                res = new BigDecimal(args[0] + "");
            } else {
                return null;
            }

            for (int i = 1; i < args.length; i++) {
                BigDecimal tmp;
                if (args[i] instanceof BigDecimal) {
                    tmp = (BigDecimal) args[i];
                    res = res.divide(tmp);
                } else if (args[i] instanceof String || args[i] instanceof Integer) {
                    tmp = new BigDecimal(args[i] + "");
                    res = res.divide(tmp);
                } else {
                    return null;
                }
            }
            return res;
        }
    }

    public static int avg(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int temp = 0;
        for (int num : nums) {
            temp += num;
        }
        return temp / nums.length;
    }

    public static long cycleNum(long requestId, long maxId) {
        long temp = requestId % maxId;
        if (temp == 0) {
            return maxId;
        } else {
            return temp;
        }
    }

    public static boolean isOdd(int a) {
        if (a % 2 == 1) {   //是奇数
            return true;
        }
        return false;
    }

    public static long getStartWithPage(long pageNo, long pageSize) {
        return (pageNo - 1) * pageSize;
    }

    public static long getEndWithPage(long start, long pageSize) {
        return start + pageSize;
    }

    public static String decimalToBase32(String num) {
        return new java.math.BigInteger(num, 10).toString(32);
    }

    public static String base32ToDecimal(String num) {
        return new java.math.BigInteger(num, 32).toString(10);
    }

    public static String randomMessageCode(){
        int  random = (int)((Math.random()*9+1)*100000);
        return random+"";
    }
    public static int compare(Long a, Long b){
        if(a.longValue()>b.longValue()){
            return 1;
        }
        else if(a.longValue()==b.longValue()){
            return 0;
        }
        return -1;
    }
}

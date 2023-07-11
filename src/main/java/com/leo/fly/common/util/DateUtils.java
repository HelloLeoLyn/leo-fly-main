package com.leo.fly.common.util;


import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private static final String YYYY_MM = "yyyyMM";
    private static final String YYYY_MM_DD = "yyyyMMdd";
    private static final String YYYY = "yyyy";
    private static final String MM = "MM";
    private static final String DD = "DD";


    public static String getFormatNow(String pattern) {
        return getFormatDate(new Date(), pattern);
    }

    public static String getFormatDate(Date date, String pattern) {
        return DateFormatUtils.format(date, pattern);
    }

    public static String getYYYYMM() {
        return getFormatNow(YYYY_MM);
    }

    public static String getYYYYMMDD() {
        return getFormatNow(YYYY_MM_DD);
    }

    public static String getYYYY() {
        return getFormatNow(YYYY);
    }

    public static String getMM() {
        return getFormatNow(MM);
    }

    public static String getDD() {
        return getFormatNow(DD);
    }


    public static Date addDate(Date date, int dateLong){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, dateLong);
        Date rd = cal.getTime();
        return rd;
    }
    public static Date addYear(Date date, int yearLong){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, yearLong);
        Date rd = cal.getTime();
        return rd;
    }
    public static Date addMonth(Date date, int monthLong){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, monthLong);
        Date rd = cal.getTime();
        return rd;
    }
    public static Date addHour(Date date, int hour){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);
        Date rd = cal.getTime();
        return rd;
    }
    public static Date addMinute(Date date, int minute){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minute);
        Date rd = cal.getTime();
        return rd;
    }
    public static Date now(){
        return new Date();
    }

    public static Date now(long timestamp){
        return new Date(timestamp);
    }
    public static Date parseDate(long timestamp){
        return new Date(timestamp);
    }

    /**
     * yyyyMMdd字符串格式转日期
     * @return
     * @throws ParseException
     */
    public static Date parseStringToDate(String str,String partern) throws ParseException {
        DateFormat format = new SimpleDateFormat(partern);
        Date date = format.parse(str);
        return date;
    }

}

package com.wenbing.demo.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class DateUtils {
    private static String[] parsePatterns = new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM", "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    public DateUtils() {
    }

    public static String getDateString() {
        return getDateString("yyyy-MM-dd");
    }

    public static String getDateString(String pattern) {
        return DateFormatUtils.format(getCurrentDate(), pattern);
    }

    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }

        return formatDate;
    }

    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static String getTimeString() {
        return formatDate(getCurrentDate(), "HH:mm:ss");
    }

    public static String getDateTimeString() {
        return formatDate(getCurrentDate(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getYear() {
        return formatDate(getCurrentDate(), "yyyy");
    }

    public static String getMonth() {
        return formatDate(getCurrentDate(), "MM");
    }

    public static String getDay() {
        return formatDate(getCurrentDate(), "dd");
    }

    public static String getWeek() {
        return formatDate(getCurrentDate(), "E");
    }

    public static long pastDays(Date date) {
        long t = getCurrentDate().getTime() - date.getTime();
        return t / 86400000L;
    }

    public static long pastHour(Date date) {
        long t = getCurrentDate().getTime() - date.getTime();
        return t / 3600000L;
    }

    public static long pastMinutes(Date date) {
        long t = getCurrentDate().getTime() - date.getTime();
        return t / 60000L;
    }

    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / 86400000L;
        long hour = timeMillis / 3600000L - day * 24L;
        long min = timeMillis / 60000L - day * 24L * 60L - hour * 60L;
        long s = timeMillis / 1000L - day * 24L * 60L * 60L - hour * 60L * 60L - min * 60L;
        long sss = timeMillis - day * 24L * 60L * 60L * 1000L - hour * 60L * 60L * 1000L - min * 60L * 1000L - s * 1000L;
        return (day > 0L ? day + "," : "") + hour + ":" + min + ":" + s + "." + sss;
    }

    /** @deprecated */
    @Deprecated
    public static double getDistanceOfTwoDate(Date before, Date after) {
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (double)((afterTime - beforeTime) / 86400000L);
    }

    public static long getDistanceOfTwoDate(Date before, Date after, TimeUnit distanceTimeUnit) {
        Objects.requireNonNull(before);
        Objects.requireNonNull(after);
        Objects.requireNonNull(distanceTimeUnit);
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return distanceTimeUnit.convert(afterTime - beforeTime, TimeUnit.MILLISECONDS);
    }

    public static Date getCurrentDate() {
        return new Date();
    }

    public static Date getDateEndTime(Date endTime) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String newTime = df.format(endTime) + " 23:59:59";
        Date newEndTime = endTime;

        try {
            newEndTime = df2.parse(newTime);
        } catch (ParseException var6) {
            var6.printStackTrace();
        }

        return newEndTime;
    }

    public static Date getDateBeginTime(Date beginTime) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String newTime = df.format(beginTime);
        Date newBeginTime = beginTime;

        try {
            newBeginTime = df.parse(newTime);
        } catch (ParseException var5) {
            var5.printStackTrace();
        }

        return newBeginTime;
    }
}

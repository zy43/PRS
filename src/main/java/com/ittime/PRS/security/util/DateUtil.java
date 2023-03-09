package com.ittime.PRS.security.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {


    /**
     * 延迟一天, 在计算截止日期时，需要将日期延后一天才能得到准确的范围
     *
     * @param stringDate 日期
     * @return {@link String}
     */
    public static String delayOneDay(String stringDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(stringDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);

        return sdf.format(calendar.getTime());
    }
}

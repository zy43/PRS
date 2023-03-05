package com.ittime.linglingbo.security.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Josh-ZJUT
 * @date 2023/2/22 09:15
 * @email dujianghui537885@163.com
 */
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

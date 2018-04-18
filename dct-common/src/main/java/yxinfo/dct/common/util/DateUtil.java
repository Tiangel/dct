package yxinfo.dct.common.util;

import com.alibaba.dubbo.common.utils.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by sxd on 2016/7/15.
 */
public class DateUtil {

    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String SIMPLE_DATE_PATTERN = "yyyyMMdd";
    public static final String TIME_PATTERN = "HH:mm:ss";

    /**
     * 返回date字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern){
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 返回date yyyy-MM-dd HH:mm:ss格式字符串
     * @param date
     * @return
     */
    public static String formatDatetime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_PATTERN);
        return sdf.format(date);
    }

    public static Date getDate(String dateStr) throws ParseException {
        if(StringUtils.isEmpty(dateStr)){
            return null;
        }
        String pattern = DATETIME_PATTERN;
        if(dateStr.length() == 10){
            pattern = DATE_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateStr);
    }

    /**
     * 增加秒数
     * @param date
     * @param sec
     * @return
     */
    public static Date addSec( Date date, int sec ) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime( date );
        calendar.add( Calendar.SECOND, sec );
        return calendar.getTime();
    }
}

package yxinfo.dct.common.util;

import java.util.UUID;

/**
 * 字符串工具
 * Created by dy on 2016/8/1.
 */
public class StringUtil {

    /**
     * 获取UUID
     * @return
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll( "-", "" );
    }

    /**
     * 判断一个String对象是否为空
     * @param s
     * @return
     */
    public static boolean isEmpty( String s ) {
        return isNull(s) || s.isEmpty();
    }

    /**
     * 判断一个String对象是否为NULL
     * @param s
     * @return
     */
    public static boolean isNull( String s ) {
        return s == null;
    }

    /**
     * 判断一个字符串是否是数字
     * @param arg
     * @return
     */
    public static boolean isNumeric( String arg ) {
        return isNumeric( arg, -1 );
    }

    /**
     * 判断一个字符串是否是特定长度
     * @param arg
     * @param len 长度
     * @return
     */
    public static boolean isNumeric( String arg, int... len ) {
        if ( isEmpty( arg ) ) return false;
        String tmp = arg.trim();
        int i = 0;
        for ( ; i < tmp.length(); i++ ) {
            char one = tmp.charAt(i);
            if ( one > '9' || one < '0' ) return false;
        }
        if ( len.length > 0 && len[0] > 0 && i != len[0] ) return false;
        return true;
    }

    /**
     * 判断一个字符串长度是否在某个范围
     * @param arg
     * @param len1 >= len1
     * @param len2 <= len2
     * @return
     */
    public static boolean isNumeric( String arg, int len1, int len2 ) {
        if ( isEmpty( arg ) ) return false;
        String tmp = arg.trim();
        int i = 0;
        for ( ; i < tmp.length(); i++ ) {
            char one = tmp.charAt(i);
            if ( one > '9' || one < '0' ) return false;
        }
        if ( i < len1 || i > len2 ) return false;
        return true;
    }

    /**
     * 处理null为空字符串
     * @param str
     * @return
     */
    public static String nullToEmpty( String str ) {
        return str == null ? "" : str;
    }
}

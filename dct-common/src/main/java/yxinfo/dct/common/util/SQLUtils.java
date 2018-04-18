package yxinfo.dct.common.util;

/**
 * Created by hanley on 2016/6/23.
 */
public class SQLUtils {

    public static String toLink( String arg ) {
        return new StringBuilder("%").append(arg).append("%").toString();
    }

}

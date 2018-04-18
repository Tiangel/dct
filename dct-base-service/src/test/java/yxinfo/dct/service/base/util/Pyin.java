package yxinfo.dct.service.base.util;

import org.springframework.util.StringUtils;

/**
 * Created by dy on 2016/9/19.
 */
public class Pyin {

    public static void main( String[] args ) {
        System.out.println( getPiny( "李蕾" ) );
    }

    /**
     * 获取拼音
     * @param str
     * @return
     */
    private static String getPiny( String str ) {
        if ( StringUtils.isEmpty( str ) ) return "";
        return PyinUtil.cn2FullSpellLowercase( str, true ) + "*" + PyinUtil.cn2FirstSpellLowercase( str, true );
    }
}

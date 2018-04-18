package yxinfo.dct.service.base.util;

import org.springframework.util.DigestUtils;

/**
 * Created by dy on 2016/8/16.
 */
public class Pwd {

    /**
     * 密码混淆
     */
    private static final String LAT = "_k_k_Q_";

    public static void main( String[] args ) {
        System.out.println( DigestUtils.md5DigestAsHex( ( "3366#yry_45#" + LAT ).getBytes() ) );
    }
}

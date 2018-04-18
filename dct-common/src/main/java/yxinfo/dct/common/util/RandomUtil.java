package yxinfo.dct.common.util;

import java.util.Random;

/**
 * Created by hanley on 2016/6/28.
 */
public final class RandomUtil {

    public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String numberChar = "0123456789";

    public static String generateString(int length, String souce) {

        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(allChar.charAt(random.nextInt(souce.length())));
        }
        return sb.toString();

    }

}

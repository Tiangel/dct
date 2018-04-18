package yxinfo.dct.common.util;

/**
 * 公共的方法
 *
 * Created by cy on 2016/7/11.
 */
public class DctUtil {

    /**
     * 验证string的长度是否合法(不区分有无汉字)
     *
     * @param str
     * @param maxLength
     * @param minLength
     */
    public static boolean checkStringLength(String str, int minLength, int maxLength) {
        if (str == null) {
            return false;
        }
        int valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
        for (int i = 0; i < str.length(); i++) {
            // 获取一个字符
            String temp = str.substring(i, i + 1);
            // 判断是否为中文字符
            if (temp.matches(chinese)) {
                // 中文字符长度为2
                valueLength += 2;
            } else {
                // 其他字符长度为1
                valueLength += 1;
            }
        }
        if (valueLength >= minLength && valueLength <= maxLength) {
            return true;
        }
        return false;
    }

}

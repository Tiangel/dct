package yxinfo.dct.common.util;

import com.alibaba.dubbo.common.utils.StringUtils;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by dy on 2016/7/7.
 */
public class PyinUtil {

    /**
     * 中文全拼和中文简拼中间的分隔符
     */
    private static final String SEPARATOR = "*";

    /**
     * 字符串转小写全拼
     * @param cn 待转换字符串
     * @param nonCnJoin 是否保留非中文字符
     * @return
     */
    public static String cn2FullSpellLowercase( String cn, boolean nonCnJoin ) {
        if ( cn == null || "".equals( cn.trim() ) ) {
            return "";
        }
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType( HanyuPinyinToneType.WITHOUT_TONE );
        char[] chars = cn.toCharArray();
        StringBuffer spell = new StringBuffer();
        for ( char c : chars ) {
            if ( Character.toString(c).matches( "[\\u4E00-\\u9FA5]+" ) ) {
                try {
                    String[] spells = PinyinHelper.toHanyuPinyinStringArray( c, format );
                    if ( spells != null && spells.length > 0 ) {
                        for (String spe : spells) {
                            spell.append(spe);
                        }
                    }
                } catch ( Exception e ) {
                    e.printStackTrace();
                }
            } else {
                if ( nonCnJoin ) {
                    spell.append( c );
                }
            }
        }
        return spell.toString();
    }

    /**
     * 字符串转小写拼音首字母
     * @param cn 待转换字符串
     * @param nonCnJoin 是否保留非中文字符
     * @return
     */
    public static String cn2FirstSpellLowercase( String cn, boolean nonCnJoin ) {
        if ( cn == null || "".equals( cn.trim() ) ) {
            return "";
        }
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setToneType( HanyuPinyinToneType.WITHOUT_TONE );
        char[] chars = cn.toCharArray();
        StringBuffer spell = new StringBuffer();
        for ( char c : chars ) {
            if ( Character.toString(c).matches( "[\\u4E00-\\u9FA5]+" ) ) {
                try {
                    String[] spells = PinyinHelper.toHanyuPinyinStringArray( c, format );
                    if ( spells != null && spells.length > 0 ) {
                        String spp = spells[0];
                        if ( spp != null && spp.length() > 0 ) {
                            spell.append( spells[0].charAt(0) );
                        }
                    }
                } catch ( Exception e ) {
                    e.printStackTrace();
                }
            } else {
                if ( nonCnJoin ) {
                    spell.append( c );
                }
            }
        }
        return spell.toString();
    }

    public static String getPyinName(String fname){
        if(StringUtils.isEmpty(fname)){
            return null;
        }
        return cn2FullSpellLowercase(fname, true) + SEPARATOR + cn2FirstSpellLowercase(fname, true);
    }

    public static void main(String[] args) {
        System.out.println(cn2FullSpellLowercase( "4-[3-氨基-5-(1-甲基胍基)戊酰氨基]-1-[4-氨基-2-氧代-1(2H)-嘧啶基]-1,2,3,4-四脱氧-β,D赤己-2-烯吡喃糖醛酸", false ));
        System.out.println(cn2FirstSpellLowercase( "4-[3-氨基-5-(1-甲基胍基)戊酰氨基]-1-[4-氨基-2-氧代-1(2H)-嘧啶基]-1,2,3,4-四脱氧-β,D赤己-2-烯吡喃糖醛酸", false ));
    }

    private static final Logger log = LoggerFactory.getLogger( PyinUtil.class );

}

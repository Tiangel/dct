package yxinfo.dct.inteface.context.chem;

/**
 * 用量检查状态
 * Created by dy on 2016/7/27.
 */
public interface ChemCheckUsed {

    /**
     * 正常
     */
    String NORMAL = "1";

    /**
     * 异常-实际使用量超限
     */
    String ABNOR_OVER = "2";

    /**
     * 异常关闭
     */
    String CLOSE = "3";

}

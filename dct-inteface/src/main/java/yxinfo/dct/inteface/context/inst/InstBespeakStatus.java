package yxinfo.dct.inteface.context.inst;

/**
 * Created by sxd on 2016/7/15.
 */
public interface InstBespeakStatus {
    //o审核中，s待使用，f已驳回，e已使用
    String INSTBESPEAK_REVIWING = "o";
    String INSTBESPEAK_TO_BE_USED = "s";
    String INSTBESPEAK_REJECT = "f";
    String INSTBESPEAK_USED = "e";
}

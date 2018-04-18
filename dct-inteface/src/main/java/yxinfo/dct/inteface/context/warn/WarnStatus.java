package yxinfo.dct.inteface.context.warn;

/**
 * Created by sxd on 2016/7/21.
 */
public interface WarnStatus {
    //状态（1待处理，2关闭，3搁置）
    String WARN_STATUS_PENDING = "1";
    String WARN_STATUS_CLOSED = "2";
    String WARN_STATUS_DELAY = "3";
    //颜色(1绿色，2黄色，3红色)
    Integer WARN_COLOR_RED = 3;

    int WARN_COLOR_YELLOW = 2;

    int WARN_COLOR_GREEN = 1;
}

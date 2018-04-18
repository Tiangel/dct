package yxinfo.dct.inteface.context.warn;

/**
 * Created by sxd on 2016/7/21.
 */
public class WarnItem {

    //领用预警
    public static final String WARN_ITEM_RECEIVE = "100000";
    //领用化学品超出设定的数量
    public static final String WARN_ITEM_RECEIVE_QUANTITY = "100001";
    //领用化学品后未出现超出消失时间
    public static final String WARN_ITEM_RECEIVE_TIME = "100002";
    //回收预警
    public static final String WARN_ITEM_RECYCLE = "100003";
    //盘点预警
    public static final String WARN_ITEM_CHECK = "100004";
    //回库预警
    public static final String WARN_ITEM_REAGENT_RECYCLE = "100005";
    //混用预警
    public static final String WARN_ITEM_MIX_CHEM = "100006";
    //环境预警
    public static final String WARN_ITEM_ENVIRONMENT = "100007";
    //非法领用
    public static final String WARN_ITEM_RECEIVE_UNLAWFUL = "100008";

}

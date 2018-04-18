package yxinfo.dct.inteface.context.inst;

/**
 * @author sxd
 * @date 2016/8/13 10:48
 */
public class InstRunStatus {
    //运行状态（1开启，2关闭）
    public static final String INST_RUN_ON = "1";

    public static final String INST_RUN_OFF = "2";

    public static boolean isInstRunStatus(String status){
        return INST_RUN_ON.equals(status) || INST_RUN_OFF.equals(status);
    }

}

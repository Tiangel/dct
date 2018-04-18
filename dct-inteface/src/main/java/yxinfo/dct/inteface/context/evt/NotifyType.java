package yxinfo.dct.inteface.context.evt;

/**
 * Created by dy on 2016/6/30.
 */
public interface NotifyType {

    /**
     * APP通知
     */
    String APP_NOTIF = "1";
    /**
     * APP推送
     */
    String APP_MSG = "2";
    /**
     * APP通知+消息
     */
    String APP_MSG_NOTIF = "3";
    /**
     * 短信通知
     */
    String SMS = "4";
    /**
     * 邮件通知
     */
    String EMAIL = "5";
    /**
     * PC端推送
     */
    String PC = "6";
}

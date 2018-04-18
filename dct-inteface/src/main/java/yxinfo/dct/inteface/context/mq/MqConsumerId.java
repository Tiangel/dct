package yxinfo.dct.inteface.context.mq;

/**
 * Created by dy on 2016/8/12.
 */
public interface MqConsumerId {

    // 温湿度监控模块
    String TEMP_HUM = "CID_DCT_MONITOR_TEMP_HUM";

    // 设备仪器插座状态监控模块
    String STOCK = "CID_DCT_MONITOR_STOCK";

    // 短信模块
    String SMS = "CID_DCT_SMS";

    //预警消息App推送
    String WARN_PUSH = "CID_DCT_WARN_PUSH";

    // 试剂轨迹检查模块
    String CHECK_CHEM_TRAJ = "CID_DCT_CHECK_CHEM_TRAJ";

    // 非法领用预警模块
    String ILLEGAL_RECEIVE_WARN = "CID_DCT_ILLEGAL_RECEIVE_WARN";
}

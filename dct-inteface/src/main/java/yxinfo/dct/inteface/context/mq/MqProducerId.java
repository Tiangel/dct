package yxinfo.dct.inteface.context.mq;

/**
 * 消息发布者id
 * Created by dy on 2016/8/4.
 */
public interface MqProducerId {

    /**
     * 预警模块
     */
    String WARN = "PID_DCT_WARN";

    /**
     *　湿度监控器
     */
    String HUM = "PID_DCT_MONITOR";

    /**
     *　插座监控器
     */
    String SOCKET = "PID_DCT_MONITOR";

    /**
     *　温度监控器
     */
    String TEMP = "PID_DCT_MONITOR";

    /**
     * 试剂模块
     */
    String CHEM = "PID_DCT_CHEM";
}

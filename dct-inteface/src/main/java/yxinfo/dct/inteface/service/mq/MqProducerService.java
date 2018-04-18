package yxinfo.dct.inteface.service.mq;

/**
 * Created by dy on 2016/8/4.
 */
public interface MqProducerService {

    /**
     * 发布消息
     * @param producerId 消息发布者id
     * @param topic 消息主题
     * @param tag 消息标签
     * @param msg 消息
     * @return
     */
    Boolean produce( String producerId, String topic, String tag, String msg );
}

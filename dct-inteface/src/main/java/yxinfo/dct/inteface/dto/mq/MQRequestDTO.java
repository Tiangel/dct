package yxinfo.dct.inteface.dto.mq;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * Created by dy on 2016/8/13.
 */
public class MQRequestDTO extends BaseDTO {

    private static final long serialVersionUID = -5076438832504249582L;

    // 消息发布者id
    private String producerId;

    // 消息主题
    private String topic;

    // 消息标签
    private String tag;

    // 消息内容
    private String msg;

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

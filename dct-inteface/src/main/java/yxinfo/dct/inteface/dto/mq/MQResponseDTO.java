package yxinfo.dct.inteface.dto.mq;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * Created by dy on 2016/8/4.
 */
public class MQResponseDTO extends BaseDTO {

    private static final long serialVersionUID = -5846222267328638707L;

    private int status;
    private String content;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

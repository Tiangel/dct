package yxinfo.dct.inteface.dto.topicLog;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * Created by cy on 2016/6/27.
 */
public class TopicLogImgDTO extends BaseDTO {

    private Integer id;

    /**
     * 课题日志id
     */
    private Integer logId;

    /**
     * 静态资源id
     */
    @Digits( integer = 10, fraction = 0, message = ErrorCode.TOPICLOG_STATICID_LENGTH)
    @NotNull( message = ErrorCode.TOPICLOG_STATICID_NOTNULL )
    private Integer staticId;

    /**
     * 图片地址
     */
    private String imgUrl;

    public TopicLogImgDTO() {
    }

    public TopicLogImgDTO(Integer id, Integer logId, Integer staticId, String imgUrl) {
        this.id = id;
        this.logId = logId;
        this.staticId = staticId;
        this.imgUrl = imgUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getStaticId() {
        return staticId;
    }

    public void setStaticId(Integer staticId) {
        this.staticId = staticId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}

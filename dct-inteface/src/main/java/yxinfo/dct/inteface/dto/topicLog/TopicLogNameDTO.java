package yxinfo.dct.inteface.dto.topicLog;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.Date;

/**
 * 实验日志（不包含明细信息）
 * <p>
 * Created by cy on 2016/6/22.
 */
public class TopicLogNameDTO extends BaseDTO {

    /**
     * id
     */
    private Integer logId;

    /**
     * 课题名称
     */
    private String issuesName;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 对应的详情信息
     */
    private TopicLogDTO topicLogDTO;

    public TopicLogNameDTO() {
    }

    public TopicLogNameDTO(Integer logId, String issuesName, Date createAt, TopicLogDTO topicLogDTO) {
        this.logId = logId;
        this.issuesName = issuesName;
        this.createAt = createAt;
        this.topicLogDTO = topicLogDTO;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public String getIssuesName() {
        return issuesName;
    }

    public void setIssuesName(String issuesName) {
        this.issuesName = issuesName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public TopicLogDTO getTopicLogDTO() {
        return topicLogDTO;
    }

    public void setTopicLogDTO(TopicLogDTO topicLogDTO) {
        this.topicLogDTO = topicLogDTO;
    }

    @Override
    public String toString() {
        return "TopicLogNameDTO{" +
                "logId=" + logId +
                ", issuesName='" + issuesName + '\'' +
                ", createAt=" + createAt +
                ", topicLogDTO=" + topicLogDTO +
                '}';
    }
}

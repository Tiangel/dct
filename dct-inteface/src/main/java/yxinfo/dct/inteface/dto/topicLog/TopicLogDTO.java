package yxinfo.dct.inteface.dto.topicLog;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.dto.lab.LaboratoryDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 课题日志bean
 * <p>
 * Created by cy on 2016/6/22.
 */
public class TopicLogDTO extends BaseDTO {

    /**
     * 日志id
     */
    @Digits(integer = 10, fraction = 0, groups = Update.class, message = ErrorCode.TOPICLOG_LOGID_LENGTH)
    @NotNull(groups = Update.class, message = ErrorCode.TOPICLOG_LOGID_NOTNULL)
    private Integer logId;

    /**
     * 组织id
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.LAB_ORGID_LENGTH)
    @NotNull(message = ErrorCode.LAB_ORGID_NOTNULL)
    private Integer orgId;

    /**
     * 使用成员id
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.TOPICLOG_MEMBERID_LENGTH)
    @NotNull(message = ErrorCode.TOPICLOG_MEMBERID_NOTNULL)
    private Integer memberId;
    private MemberDTO memberDTO;
    /**
     * 使用成员名称
     */
    private String memberName;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 课题名称
     */
    @Length(max = 100, message = ErrorCode.TOPICLOG_ISSUESNAME_LENGTH)
    @NotEmpty(message = ErrorCode.TOPICLOG_ISSUESNAME_NOTNULL)
    private String issuesName;

    /**
     * 课题类型（1：教学 2：科研）
     */
    @Length(max = 2, message = ErrorCode.TOPICLOG_PURPOSE_LENGTH)
    private String purpose;

    /**
     * 实验时间
     */
    private Date exptAt;

    /**
     * 实验时常（s）
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.TOPICLOG_EXPTLENGTH_LENGTH)
    private Integer exptLength;

    /**
     * 实验室id
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.TOPICLOG_LABID_LENGTH)
    private Integer labId;
    private LaboratoryDTO labDto;
    private String labName;
    /**
     * 教师id
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.TOPICLOG_TEACHERID_LENGTH)
    private Integer teacherId;
    private MemberDTO teacherDTO;
    private String teacherName;
    /**
     * 内容
     */
    @Length(max = 2000, message = ErrorCode.TOPICLOG_CONTEXT_LENGTH)
    private String context;

    /**
     * 课题使用试剂list
     */
    @Valid
    private List<TopicLogReagentDTO> topicLogReagentList;

    /**
     * 课题日志中实验内容图片list
     */
    @Valid
    private List<TopicLogImgDTO> topicLogImgList;

    /**
     * 查询条件
     */
    private Date exptAtBegin;
    private Date exptAtEnd;

    /**
     * token
     */
    private String token;
    public TopicLogDTO() {
    }

    public TopicLogDTO(Integer logId, Integer orgId, Integer memberId, MemberDTO memberDTO, String memberName, Date createAt, String issuesName, String purpose, Date exptAt, Integer exptLength, Integer labId, LaboratoryDTO labDto, String labName, Integer teacherId, MemberDTO teacherDTO, String teacherName, String context, List<TopicLogReagentDTO> topicLogReagentList, List<TopicLogImgDTO> topicLogImgList, Date exptAtBegin, Date exptAtEnd, String token) {
        this.logId = logId;
        this.orgId = orgId;
        this.memberId = memberId;
        this.memberDTO = memberDTO;
        this.memberName = memberName;
        this.createAt = createAt;
        this.issuesName = issuesName;
        this.purpose = purpose;
        this.exptAt = exptAt;
        this.exptLength = exptLength;
        this.labId = labId;
        this.labDto = labDto;
        this.labName = labName;
        this.teacherId = teacherId;
        this.teacherDTO = teacherDTO;
        this.teacherName = teacherName;
        this.context = context;
        this.topicLogReagentList = topicLogReagentList;
        this.topicLogImgList = topicLogImgList;
        this.exptAtBegin = exptAtBegin;
        this.exptAtEnd = exptAtEnd;
        this.token = token;
    }

    public Integer getLogId() {
        return logId;
    }

    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getIssuesName() {
        return issuesName;
    }

    public void setIssuesName(String issuesName) {
        this.issuesName = issuesName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Date getExptAt() {
        return exptAt;
    }

    public void setExptAt(Date exptAt) {
        this.exptAt = exptAt;
    }

    public Integer getExptLength() {
        return exptLength;
    }

    public void setExptLength(Integer exptLength) {
        this.exptLength = exptLength;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public List<TopicLogReagentDTO> getTopicLogReagentList() {
        return topicLogReagentList;
    }

    public void setTopicLogReagentList(List<TopicLogReagentDTO> topicLogReagentList) {
        this.topicLogReagentList = topicLogReagentList;
    }

    public List<TopicLogImgDTO> getTopicLogImgList() {
        return topicLogImgList;
    }

    public void setTopicLogImgList(List<TopicLogImgDTO> topicLogImgList) {
        this.topicLogImgList = topicLogImgList;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    public LaboratoryDTO getLabDto() {
        return labDto;
    }

    public void setLabDto(LaboratoryDTO labDto) {
        this.labDto = labDto;
    }

    public MemberDTO getTeacherDTO() {
        return teacherDTO;
    }

    public void setTeacherDTO(MemberDTO teacherDTO) {
        this.teacherDTO = teacherDTO;
    }

    public Date getExptAtBegin() {
        return exptAtBegin;
    }

    public void setExptAtBegin(Date exptAtBegin) {
        this.exptAtBegin = exptAtBegin;
    }

    public Date getExptAtEnd() {
        return exptAtEnd;
    }

    public void setExptAtEnd(Date exptAtEnd) {
        this.exptAtEnd = exptAtEnd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TopicLogDTO{" +
                "logId=" + logId +
                ", orgId=" + orgId +
                ", memberId=" + memberId +
                ", memberDTO=" + memberDTO +
                ", memberName='" + memberName + '\'' +
                ", createAt=" + createAt +
                ", issuesName='" + issuesName + '\'' +
                ", purpose='" + purpose + '\'' +
                ", exptAt=" + exptAt +
                ", exptLength=" + exptLength +
                ", labId=" + labId +
                ", labDto=" + labDto +
                ", labName='" + labName + '\'' +
                ", teacherId=" + teacherId +
                ", teacherDTO=" + teacherDTO +
                ", teacherName='" + teacherName + '\'' +
                ", context='" + context + '\'' +
                ", topicLogReagentList=" + topicLogReagentList +
                ", topicLogImgList=" + topicLogImgList +
                '}';
    }
}

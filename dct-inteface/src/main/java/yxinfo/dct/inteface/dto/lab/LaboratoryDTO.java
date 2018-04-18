package yxinfo.dct.inteface.dto.lab;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 实验室bean
 * <p>
 * Created by cy on 2016/6/18.
 */
public class LaboratoryDTO extends BaseDTO {

    /**
     * 实验室id
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.LAB_LABID_LENGTH)
    @NotNull(groups = Update.class, message = ErrorCode.LAB_LABID_NOTNULL)
    private Integer labId;

    /**
     * 实验室名称
     */
    @Length(max = 100, message = ErrorCode.LAB_LABNAME_LENGTH)
    @NotEmpty(message = ErrorCode.LAB_LABNAME_NOTNULL)
    private String labName;

    /**
     * 实验室编号
     */
    @Length(max = 100, message = ErrorCode.LAB_LABCODE_LENGTH)
    @NotEmpty(message = ErrorCode.LAB_LABCODE_NOTNULL)
    private String labCode;

    /**
     * 状态（o开放，c关闭)
     */
    @Length(max = 1, message = ErrorCode.LAB_LABSTATUS_LENGTH)
    @NotEmpty(message = ErrorCode.LAB_LABSTATUS_NOTNULL)
    private String labStatus;

    /**
     * 实验室级别
     */
    @Length(max = 100, message = ErrorCode.LAB_LABLEVEL_LENGTH)
    private String flevel;

    /**
     * 所属组织id  sql_column:org_id
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.LAB_ORGID_LENGTH)
    @NotNull(message = ErrorCode.LAB_ORGID_NOTNULL)
    private Integer orgId;

    /**
     * 创建时间  sql_column:create_at
     */
    private Date labCreateAt;

    /**
     * 更新时间  sql_column:update_at
     */
    private Date labUpdateAt;

    /**
     * 父id  sql_column:pid
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.LAB_PID_LENGTH)
    private Integer pid;

    /**
     * 备注  sql_column:remark
     */
    @Length(max = 255, message = ErrorCode.LAB_LABREMARK_LENGTH)
    private String labRemark;

    /**
     * 危险源
     */
    @Length(max = 255, message = ErrorCode.LAB_LABDANGERSOURCE_LENGTH)
    private String dangerSource;

    /**
     * rfid设备号
     */
    @Length(max = 100, message = ErrorCode.LAB_RFFCODE_LENGTH)
    private String rfFcode;

    /**
     * 开放开始时间
     */
    private Date openStartAt;

    /**
     * 开放结束时间
     */
    private Date openEndAt;

    /**
     * 安全员
     */
    @Valid
    private List<LabManagerDTO> labSafetyMemberList;

    /**
     * 负责人
     */
    @Valid
    private List<LabManagerDTO> labManaMemberList;

    /**
     * 技术人员
     */
    @Valid
    private List<LabManagerDTO> labTechMemberList;

    /**
     * 各种人员的集合
     */
    private List<LabManagerDTO> memberList;

    /**
     * 楼宇及房间号
     */
    @Length(max = 50, message = ErrorCode.LAB_ROOMNUM_LENGTH)
    private String roomNum;

    /**
     * 实验室位置地址
     */
    @Length(max = 100, message = ErrorCode.LAB_ADDRESS_LENGTH)
    private String address;

    /**
     * 查询条件人员
     */
    private Integer memberId;
    /**
     * 实验室用途（1教学, 2科研）
     */
    @Length(max = 1, message = ErrorCode.LAB_PURPOSE_LENGTH)
    private String purpose;

    /**
     * 面积
     */
    @Length(max = 50, message = ErrorCode.WH_AREA_LENGTH)
    private String area;

    /**
     * 仓库id
     */
    private Integer whId;

    /**
     * 排序列
     */
    private String sortParams;
    public LaboratoryDTO() {

    }

    public LaboratoryDTO(Integer labId, String labName, String labCode, String labStatus, String flevel, Integer orgId, Date labCreateAt, Date labUpdateAt, Integer pid, String labRemark, String dangerSource, String rfFcode, Date openStartAt, Date openEndAt, List<LabManagerDTO> labSafetyMemberList, List<LabManagerDTO> labManaMemberList, List<LabManagerDTO> labTechMemberList, List<LabManagerDTO> memberList, String roomNum, String address, Integer memberId, String purpose, String area, Integer whId, String sortParams) {
        this.labId = labId;
        this.labName = labName;
        this.labCode = labCode;
        this.labStatus = labStatus;
        this.flevel = flevel;
        this.orgId = orgId;
        this.labCreateAt = labCreateAt;
        this.labUpdateAt = labUpdateAt;
        this.pid = pid;
        this.labRemark = labRemark;
        this.dangerSource = dangerSource;
        this.rfFcode = rfFcode;
        this.openStartAt = openStartAt;
        this.openEndAt = openEndAt;
        this.labSafetyMemberList = labSafetyMemberList;
        this.labManaMemberList = labManaMemberList;
        this.labTechMemberList = labTechMemberList;
        this.memberList = memberList;
        this.roomNum = roomNum;
        this.address = address;
        this.memberId = memberId;
        this.purpose = purpose;
        this.area = area;
        this.whId = whId;
        this.sortParams = sortParams;
    }

    public String getFlevel() {
        return flevel;
    }

    public void setFlevel(String flevel) {
        this.flevel = flevel;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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

    public String getLabCode() {
        return labCode;
    }

    public void setLabCode(String labCode) {
        this.labCode = labCode;
    }

    public String getLabStatus() {
        return labStatus;
    }

    public void setLabStatus(String labStatus) {
        this.labStatus = labStatus;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Date getLabCreateAt() {
        return labCreateAt;
    }

    public void setLabCreateAt(Date labCreateAt) {
        this.labCreateAt = labCreateAt;
    }

    public Date getLabUpdateAt() {
        return labUpdateAt;
    }

    public void setLabUpdateAt(Date labUpdateAt) {
        this.labUpdateAt = labUpdateAt;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getLabRemark() {
        return labRemark;
    }

    public void setLabRemark(String labRemark) {
        this.labRemark = labRemark;
    }

    public String getDangerSource() {
        return dangerSource;
    }

    public void setDangerSource(String dangerSource) {
        this.dangerSource = dangerSource;
    }

    public String getRfFcode() {
        return rfFcode;
    }

    public void setRfFcode(String rfFcode) {
        this.rfFcode = rfFcode;
    }

    public Date getOpenStartAt() {
        return openStartAt;
    }

    public void setOpenStartAt(Date openStartAt) {
        this.openStartAt = openStartAt;
    }

    public Date getOpenEndAt() {
        return openEndAt;
    }

    public void setOpenEndAt(Date openEndAt) {
        this.openEndAt = openEndAt;
    }

    public List<LabManagerDTO> getLabSafetyMemberList() {
        return labSafetyMemberList;
    }

    public void setLabSafetyMemberList(List<LabManagerDTO> labSafetyMemberList) {
        this.labSafetyMemberList = labSafetyMemberList;
    }

    public List<LabManagerDTO> getLabManaMemberList() {
        return labManaMemberList;
    }

    public void setLabManaMemberList(List<LabManagerDTO> labManaMemberList) {
        this.labManaMemberList = labManaMemberList;
    }

    public List<LabManagerDTO> getLabTechMemberList() {
        return labTechMemberList;
    }

    public void setLabTechMemberList(List<LabManagerDTO> labTechMemberList) {
        this.labTechMemberList = labTechMemberList;
    }

    public List<LabManagerDTO> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<LabManagerDTO> memberList) {
        this.memberList = memberList;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public String getSortParams() {
        return sortParams;
    }

    public void setSortParams(String sortParams) {
        this.sortParams = sortParams;
    }

    @Override
    public String toString() {
        return "LaboratoryDTO{" +
                "labId=" + labId +
                ", labName='" + labName + '\'' +
                ", labCode='" + labCode + '\'' +
                ", labStatus='" + labStatus + '\'' +
                ", flevel='" + flevel + '\'' +
                ", orgId=" + orgId +
                ", labCreateAt=" + labCreateAt +
                ", labUpdateAt=" + labUpdateAt +
                ", pid=" + pid +
                ", labRemark='" + labRemark + '\'' +
                ", dangerSource='" + dangerSource + '\'' +
                ", rfFcode='" + rfFcode + '\'' +
                ", openStartAt=" + openStartAt +
                ", openEndAt=" + openEndAt +
                ", labSafetyMemberList=" + labSafetyMemberList +
                ", labManaMemberList=" + labManaMemberList +
                ", labTechMemberList=" + labTechMemberList +
                ", memberList=" + memberList +
                ", roomNum='" + roomNum + '\'' +
                ", address='" + address + '\'' +
                ", memberId=" + memberId +
                ", purpose='" + purpose + '\'' +
                ", area='" + area + '\'' +
                ", whId=" + whId +
                ", sortParams='" + sortParams + '\'' +
                '}';
    }
}

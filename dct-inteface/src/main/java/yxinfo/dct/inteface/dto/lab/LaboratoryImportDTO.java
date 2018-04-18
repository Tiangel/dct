package yxinfo.dct.inteface.dto.lab;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 实验室导入bean
 * <p>
 * Created by cy on 2016/6/18.
 */
public class LaboratoryImportDTO extends BaseDTO {

    /**
     * 实验室名称
     */
    private String labName;

    /**
     * 实验室编号
     */
    private String labCode;

    /**
     * 状态（o开放，c关闭)
     */
    private String labStatus;

    /**
     * 楼宇及房间号
     */
    private String roomNum;
    /**
     * 地址
     */
    private String address;
    /**
     * 面积
     */
    private String labArea;

    /**
     * 地址
     */
    private String purpose;

    /**
     * 所属组织id  sql_column:org_id
     */
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
    private Integer pid;

    /**
     * 备注  sql_column:remark
     */
    private String labRemark;

    /**
     * 危险源
     */
    private String dangerSource;

    /**
     * 开放开始时间
     */
    private Date openStartAt;

    /**
     * 开放结束时间
     */
    private Date openEndAt;

    /**
     * 导入时安全员信息
     */
    private String safetyMember;

    /**
     * 导入时负责人信息
     */
    private String manaMember;

    /**
     * 导入时技术人信息
     */
    private String techMember;

    /**
     * 导入是的URL（服务器上存放地址）
     */
    private String url;

    public LaboratoryImportDTO() {

    }

    public LaboratoryImportDTO(String labName, String labCode, String labStatus, String roomNum, String address, String labArea, String purpose, Integer orgId, Date labCreateAt, Date labUpdateAt, Integer pid, String labRemark, String dangerSource, Date openStartAt, Date openEndAt, String safetyMember, String manaMember, String techMember) {
        this.labName = labName;
        this.labCode = labCode;
        this.labStatus = labStatus;
        this.roomNum = roomNum;
        this.address = address;
        this.labArea = labArea;
        this.purpose = purpose;
        this.orgId = orgId;
        this.labCreateAt = labCreateAt;
        this.labUpdateAt = labUpdateAt;
        this.pid = pid;
        this.labRemark = labRemark;
        this.dangerSource = dangerSource;
        this.openStartAt = openStartAt;
        this.openEndAt = openEndAt;
        this.safetyMember = safetyMember;
        this.manaMember = manaMember;
        this.techMember = techMember;
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

    public String getLabArea() {
        return labArea;
    }

    public void setLabArea(String labArea) {
        this.labArea = labArea;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
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

    public String getSafetyMember() {
        return safetyMember;
    }

    public void setSafetyMember(String safetyMember) {
        this.safetyMember = safetyMember;
    }

    public String getManaMember() {
        return manaMember;
    }

    public void setManaMember(String manaMember) {
        this.manaMember = manaMember;
    }

    public String getTechMember() {
        return techMember;
    }

    public void setTechMember(String techMember) {
        this.techMember = techMember;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LaboratoryImportDTO{" +
                "labName='" + labName + '\'' +
                ", labCode='" + labCode + '\'' +
                ", labStatus='" + labStatus + '\'' +
                ", roomNum='" + roomNum + '\'' +
                ", address='" + address + '\'' +
                ", labArea='" + labArea + '\'' +
                ", purpose='" + purpose + '\'' +
                ", orgId=" + orgId +
                ", labCreateAt=" + labCreateAt +
                ", labUpdateAt=" + labUpdateAt +
                ", pid=" + pid +
                ", labRemark='" + labRemark + '\'' +
                ", dangerSource='" + dangerSource + '\'' +
                ", openStartAt=" + openStartAt +
                ", openEndAt=" + openEndAt +
                ", safetyMember='" + safetyMember + '\'' +
                ", manaMember='" + manaMember + '\'' +
                ", techMember='" + techMember + '\'' +
                '}';
    }
}

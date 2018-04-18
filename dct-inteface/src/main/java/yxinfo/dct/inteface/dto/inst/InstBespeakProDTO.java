package yxinfo.dct.inteface.dto.inst;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.pro.ProjectDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by sxd on 2016/7/16.
 */
public class InstBespeakProDTO extends BaseDTO {

    private Integer id;

    //组织id
    private Integer orgId;

    //预约成员id
    private Integer memberId;

    //用途
    private String fuse;

    //编号
    private String fcode;

    //预约使用起始时间
    private Date startTime;

    //预约使用结束时间
    private Date endTime;

    //状态（o审核中，s待使用，f已驳回，e已使用）
    private String status;

    //生成时间
    private Date createAt;

    private ProjectDTO projectDTO;

    private List<InstrumentDTO> instList;

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

    public String getFuse() {
        return fuse;
    }

    public void setFuse(String fuse) {
        this.fuse = fuse;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public ProjectDTO getProjectDTO() {
        return projectDTO;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.projectDTO = projectDTO;
    }

    public List<InstrumentDTO> getInstList() {
        return instList;
    }

    public void setInstList(List<InstrumentDTO> instList) {
        this.instList = instList;
    }
}

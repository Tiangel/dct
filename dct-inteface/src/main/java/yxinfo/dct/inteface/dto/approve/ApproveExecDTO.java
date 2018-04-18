package yxinfo.dct.inteface.dto.approve;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Delete;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 审核方案DTO
 * Created by dy on 2016/6/18.
 */
public class ApproveExecDTO extends BaseDTO {

    private static final long serialVersionUID = -7443737859962373048L;

    /**
     * 审核方案id
     */
    @NotNull( groups = {
            Update.class,
            Delete.class
    } )
    private Integer id;

    /**
     * 审核项目编号
     */
    @Length( max = 10,
            message = ErrorCode.APPROVE_ITEM_NO_NOT_EMPTY )
    @NotEmpty( message = ErrorCode.APPROVE_ITEM_NO_LENGTH)
    private String itemNo;

    /**
     * 方案所属组织id
     */
    @NotNull( message = ErrorCode.APPROVE_ORG_ID_NOT_EMPTY)
    private Integer orgId;

    /**
     * 名称
     */
    @Length( max = 255,
            message = ErrorCode.APPROVE_EXEC_NAME_LENGTH )
    @NotEmpty( message = ErrorCode.APPROVE_EXEC_NAME_NOT_EMPTY )
    private String fname;

    /**
     * 备注
     */
    @Length( max = 255,
            message = ErrorCode.APPROVE_EXEC_REMARK_LENGTH )
    private String remark;

    /**
     * 过程类型（1流模式, 2自由模式）
     */
    @Length( max = 1,
            message = ErrorCode.APPROVE_EXEC_TYPE_LENGTH )
    @NotEmpty( message = ErrorCode.APPROVE_EXEC_TYPE_LENGTH )
    private String ftype;

    /**
     * 审核起点成员组id
     */
    private Integer startGroupId;

    /**
     * 审核起点角色id
     */
    private Integer startRoleId;

    /**
     * 审核起点标签id
     */
    private Integer startTagId;

    /**
     * 步骤数
     */
    private Integer step;

    /**
     * 审核方案过程
     */
    private List<ApproveExecFlowDTO> flowList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public Integer getStartGroupId() {
        return startGroupId;
    }

    public void setStartGroupId(Integer startGroupId) {
        this.startGroupId = startGroupId;
    }

    public Integer getStartRoleId() {
        return startRoleId;
    }

    public void setStartRoleId(Integer startRoleId) {
        this.startRoleId = startRoleId;
    }

    public Integer getStartTagId() {
        return startTagId;
    }

    public void setStartTagId(Integer startTagId) {
        this.startTagId = startTagId;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public List<ApproveExecFlowDTO> getFlowList() {
        return flowList;
    }

    public void setFlowList(List<ApproveExecFlowDTO> flowList) {
        this.flowList = flowList;
    }

}


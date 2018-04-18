package yxinfo.dct.inteface.dto.approve.biz;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * 获取下一个审核方案过程业务返回DTO
 * Created by dy on 2016/6/20.
 */
public class GetNextFlowRetDTO extends BaseDTO {

    private static final long serialVersionUID = -1632697929884017411L;

    /**
     * 过程类型（1不指定范围, 2指定用户, 3指定角色, 4指定成员组, 5指定标签, 6指定成员组+标签）
     */
    private String type;

    /**
     * 审核人的用户id
     */
    private Integer memberId;

    /**
     * 审核人的成员组id
     */
    private Integer groupId;

    /**
     * 审核人的角色id
     */
    private Integer roleId;

    /**
     * 审核人的标签id
     */
    private Integer tagId;

    /**
     * 审核方案id
     */
    private Integer approveExecId;

    public GetNextFlowRetDTO(
            String type, Integer memberId, Integer groupId, Integer roleId, Integer tagId, Integer approveExecId) {
        this.type = type;
        this.memberId = memberId;
        this.groupId = groupId;
        this.roleId = roleId;
        this.tagId = tagId;
        this.approveExecId = approveExecId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getApproveExecId() {
        return approveExecId;
    }

    public void setApproveExecId(Integer approveExecId) {
        this.approveExecId = approveExecId;
    }

}

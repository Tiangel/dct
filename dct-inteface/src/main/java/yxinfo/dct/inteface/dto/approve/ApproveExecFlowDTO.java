package yxinfo.dct.inteface.dto.approve;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * 审核方案过程DTO
 * Created by dy on 2016/6/18.
 */
public class ApproveExecFlowDTO extends BaseDTO {

    private static final long serialVersionUID = -6700569982619728130L;

    /**
     * 审核方案过程id
     */
    private Integer id;

    /**
     * 审核方案id
     */
    private Integer approveExecId;

    /**
     * 审核方案过程名称
     */
    private String fname;

    /**
     * 方案过程审核人称呼
     */
    private String person;

    /**
     * 过程类型（2指定用户, 3指定角色, 4指定成员组, 5指定标签, 6指定成员组+标签）
     */
    private String ftype;

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
     * 标签id
     */
    private Integer tagId;

    /**
     * 步骤排序
     */
    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApproveExecId() {
        return approveExecId;
    }

    public void setApproveExecId(Integer approveExecId) {
        this.approveExecId = approveExecId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}

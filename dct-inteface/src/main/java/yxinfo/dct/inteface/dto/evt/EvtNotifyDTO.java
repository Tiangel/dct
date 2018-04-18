package yxinfo.dct.inteface.dto.evt;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.evt.AddSync;

import java.util.Date;

public class EvtNotifyDTO extends BaseDTO {

    private static final long serialVersionUID = 2066942159035265887L;

    private Integer id;

    //类型（1APP通知, 2APP消息, 3APP通知+消息, 4短信通知, 5邮件通知, 6PC端推送）
    @NotEmpty( groups = { Add.class, AddSync.class }, message = ErrorCode.EVT_NOTIFY_TYPE_NOT_EMPTY )
    private String ftype;

    //事件项目编号
    @NotEmpty( groups = { Add.class, AddSync.class }, message = ErrorCode.EVT_ITEM_NO_NOT_EMPTY )
    private String itemNo;

    //计划通知时间
    private Date planAt;

    //级别（数字越大越优先, 默认为5）
    private Integer flevel;

    //通知用户id
    private Integer memberId;

    //通知用户的组织id
    private Integer memberOrgId;

    //通知角色id
    private Integer roleId;

    //通知成员组id
    private Integer groupId;

    //通知标签id
    private Integer tagId;

    //通知组织id
    private Integer orgId;

    //额外信息id
    private Integer extraMsgId;

    //标题
    @NotEmpty( groups = { Add.class, AddSync.class }, message = ErrorCode.EVT_TITLE_NOT_EMPTY )
    private String title;

    //摘要
    private String summary;

    //创建时间
    private Date createAt;

    //事件通知内容
    private String context;

    //终端编号
    @NotEmpty( groups = { Add.class, AddSync.class }, message = ErrorCode.EVT_TERMINAL_NOT_EMPTY )
    private String terminal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public Date getPlanAt() {
        return planAt;
    }

    public void setPlanAt(Date planAt) {
        this.planAt = planAt;
    }

    public Integer getFlevel() {
        return flevel;
    }

    public void setFlevel(Integer flevel) {
        this.flevel = flevel;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberOrgId() {
        return memberOrgId;
    }

    public void setMemberOrgId(Integer memberOrgId) {
        this.memberOrgId = memberOrgId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getExtraMsgId() {
        return extraMsgId;
    }

    public void setExtraMsgId(Integer extraMsgId) {
        this.extraMsgId = extraMsgId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EvtNotifyDTO{");
        sb.append("itemNo='").append(itemNo).append('\'');
        sb.append(", planAt=").append(planAt);
        sb.append(", flevel=").append(flevel);
        sb.append(", memberId=").append(memberId);
        sb.append(", memberOrgId=").append(memberOrgId);
        sb.append(", roleId=").append(roleId);
        sb.append(", groupId=").append(groupId);
        sb.append(", tagId=").append(tagId);
        sb.append(", orgId=").append(orgId);
        sb.append(", extraMsgId=").append(extraMsgId);
        sb.append(", title='").append(title).append('\'');
        sb.append(", summary='").append(summary).append('\'');
        sb.append(", createAt=").append(createAt);
        sb.append(", context='").append(context).append('\'');
        sb.append(", ftype='").append(ftype).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
package yxinfo.dct.inteface.dto.approve;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.approve.biz.ApproveExtraMsgDTO;
import yxinfo.dct.inteface.dto.approve.biz.ApproveNodeListDTO;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 审核记录DTO
 * Created by dy on 2016/6/20.
 */
public class ApproveRecodeDTO extends BaseDTO {

    private static final long serialVersionUID = -8741293737110894027L;

    /**
     * 审核记录id
     */
    private Integer id;

    /**
     * 审批项目编号
     */
    @Length( max = 10, message = ErrorCode.APPROVE_ITEM_NO_LENGTH )
    @NotEmpty( message = ErrorCode.APPROVE_ITEM_NO_NOT_EMPTY )
    private String itemNo;

    /**
     * 提交人组织id
     */
    @NotNull( message = ErrorCode.APPROVE_SUBMIT_ORG_ID_NOT_EMPTY )
    private Integer orgId;

    /**
     * 审核方案id
     */
    private Integer approveExecId;

    /**
     * 提交人id
     */
    @NotNull( message = ErrorCode.APPROVE_SUBMIT_MEMBER_NOT_EMPTY )
    private Integer submitMemberId;

    /**
     * 下一步审核人用户id
     */
    private Integer onMemberId;

    /**
     * 记录所处成员组id
     */
    private Integer onGroupId;

    /**
     * 记录所处角色id
     */
    private Integer onRoleId;

    /**
     * 记录所处标签id
     */
    private Integer onTagId;

    /**
     * 审批步骤位置
     */
    private Integer onStep;

    /**
     * 状态（o审核中, s审核通过, f审核不通过, i已作废）
     */
    private String status;

    /**
     * 额外信息id
     */
    @NotNull( message = ErrorCode.APPROVE_RECODE_EXT_MSG_ID_NOT_EMPTY )
    private Integer extraMsgId;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 审核方案
     */
    private ApproveExecDTO approveExec;

    /**
     * 审核节点记录
     */
    private List<ApproveNodeDTO> nodeList;

    /**
     * 额外信息
     */
    private ApproveExtraMsgDTO extraMsg;

    /**
     * 当前处于审核人姓名
     */
    private String onMemberName;

    /**
     * 扩展字符
     */
    private String extendChar1;
    private String extendChar2;

    /**
     * 扩展数字
     */
    private Long extendInt1;
    private Long extendInt2;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 审核节点信息
     */
    private ApproveNodeListDTO node;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo( String itemNo ) {
        this.itemNo = itemNo;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId( Integer orgId ) {
        this.orgId = orgId;
    }

    public Integer getApproveExecId() {
        return approveExecId;
    }

    public void setApproveExecId( Integer approveExecId ) {
        this.approveExecId = approveExecId;
    }

    public Integer getSubmitMemberId() {
        return submitMemberId;
    }

    public void setSubmitMemberId( Integer submitMemberId ) {
        this.submitMemberId = submitMemberId;
    }

    public Integer getOnMemberId() {
        return onMemberId;
    }

    public void setOnMemberId( Integer onMemberId ) {
        this.onMemberId = onMemberId;
    }

    public Integer getOnGroupId() {
        return onGroupId;
    }

    public void setOnGroupId( Integer onGroupId ) {
        this.onGroupId = onGroupId;
    }

    public Integer getOnRoleId() {
        return onRoleId;
    }

    public void setOnRoleId( Integer onRoleId ) {
        this.onRoleId = onRoleId;
    }

    public Integer getOnTagId() {
        return onTagId;
    }

    public void setOnTagId( Integer onTagId ) {
        this.onTagId = onTagId;
    }

    public Integer getOnStep() {
        return onStep;
    }

    public void setOnStep( Integer onStep ) {
        this.onStep = onStep;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public Integer getExtraMsgId() {
        return extraMsgId;
    }

    public void setExtraMsgId( Integer extraMsgId ) {
        this.extraMsgId = extraMsgId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt( Date createAt ) {
        this.createAt = createAt;
    }

    public ApproveExecDTO getApproveExec() {
        return approveExec;
    }

    public void setApproveExec( ApproveExecDTO approveExec ) {
        this.approveExec = approveExec;
    }

    public List<ApproveNodeDTO> getNodeList() {
        return nodeList;
    }

    public void setNodeList( List<ApproveNodeDTO> nodeList ) {
        this.nodeList = nodeList;
    }

    public ApproveExtraMsgDTO getExtraMsg() {
        return extraMsg;
    }

    public void setExtraMsg( ApproveExtraMsgDTO extraMsg ) {
        this.extraMsg = extraMsg;
    }

    public String getOnMemberName() {
        return onMemberName;
    }

    public void setOnMemberName( String onMemberName ) {
        this.onMemberName = onMemberName;
    }

    public String getExtendChar1() {
        return extendChar1;
    }

    public void setExtendChar1( String extendChar1 ) {
        this.extendChar1 = extendChar1;
    }

    public String getExtendChar2() {
        return extendChar2;
    }

    public void setExtendChar2( String extendChar2 ) {
        this.extendChar2 = extendChar2;
    }

    public Long getExtendInt1() {
        return extendInt1;
    }

    public void setExtendInt1( Long extendInt1 ) {
        this.extendInt1 = extendInt1;
    }

    public Long getExtendInt2() {
        return extendInt2;
    }

    public void setExtendInt2( Long extendInt2 ) {
        this.extendInt2 = extendInt2;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary( String summary ) {
        this.summary = summary;
    }

    public ApproveNodeListDTO getNode() {
        return node;
    }

    public void setNode( ApproveNodeListDTO node ) {
        this.node = node;
    }
}

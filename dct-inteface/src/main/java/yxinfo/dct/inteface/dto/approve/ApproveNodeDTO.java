package yxinfo.dct.inteface.dto.approve;

import org.hibernate.validator.constraints.Length;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 审核节点DTO
 * Created by dy on 2016/6/21.
 */
public class ApproveNodeDTO extends BaseDTO {

    private static final long serialVersionUID = 3318508668016893649L;

    private Integer id;

    /**
     * 审核人id
     */
    @NotNull( message = ErrorCode.APPROVE_NODE_MEMBERID_NOT_EMPTY )
    private Integer memberId;

    /**
     * 状态（s审核通过, f审核不通过）
     */
    @Length( max = 1, message = ErrorCode.APPROVE_NODE_STATUS_LENGTH )
    @NotNull( message = ErrorCode.APPROVE_NODE_STATUS_NOT_EMPTY )
    private String status;

    /**
     * 私有域，用于存储业务定制信息
     */
    private String privateField;

    /**
     * 审核意见
     */
    @Length( max = 255,
            message = ErrorCode.APPROVE_NODE_OPINION_LENGTH )
    private String opinion;

    /**
     * 审核流程记录id
     */
    @NotNull( message = ErrorCode.APPROVE_NODE_ARID_NOT_EMPTY )
    private Integer approveRecodeId;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 下一节点用户id
     */
    private Integer onMemberId;

    /**
     * 是否结束(自由模式专用, 1时结束流程)
     */
    @Length( max = 1, message = ErrorCode.APPROVE_NODE_ISEND_LENGTH )
    private String isEnd;

    /**
     * 审核人姓名
     */
    private String memberRealName;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId( Integer memberId ) {
        this.memberId = memberId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }

    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField( String privateField ) {
        this.privateField = privateField;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion( String opinion ) {
        this.opinion = opinion;
    }

    public Integer getApproveRecodeId() {
        return approveRecodeId;
    }

    public void setApproveRecodeId( Integer approveRecodeId ) {
        this.approveRecodeId = approveRecodeId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt( Date createAt ) {
        this.createAt = createAt;
    }

    public Integer getOnMemberId() {
        return onMemberId;
    }

    public void setOnMemberId( Integer onMemberId ) {
        this.onMemberId = onMemberId;
    }

    public String getIsEnd() {
        return isEnd;
    }

    public void setIsEnd( String isEnd ) {
        this.isEnd = isEnd;
    }

    public String getMemberRealName() {
        return memberRealName;
    }

    public void setMemberRealName( String memberRealName ) {
        this.memberRealName = memberRealName;
    }
}

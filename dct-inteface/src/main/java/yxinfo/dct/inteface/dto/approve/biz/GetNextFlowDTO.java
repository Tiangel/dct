package yxinfo.dct.inteface.dto.approve.biz;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Select;

import javax.validation.constraints.NotNull;

/**
 * 获取下一个审核方案过程业务DTO
 * Created by dy on 2016/6/20.
 */
public class GetNextFlowDTO extends BaseDTO {

    private static final long serialVersionUID = -5202207879758429143L;

    /**
     * 审核方案id
     */
    @NotNull( groups = Select.class,
            message = ErrorCode.APPROVE_EXEC_ID_NOT_EMPTY )
    private Integer approveExecId;

    /**
     * 审核记录id
     */
    @NotNull( groups = Select.class,
            message = ErrorCode.APPROVE_RECODE_ID_NOT_EMPTY )
    private Integer approveRecodeId;

    /**
     * 审核项目编号
     */
    @Length( max = 10, groups = Add.class,
            message = ErrorCode.APPROVE_ITEM_NO_LENGTH )
    @NotEmpty( groups = Add.class,
            message = ErrorCode.APPROVE_ITEM_NO_NOT_EMPTY )
    private String itemNo;

    /**
     * 成员组织id
     */
    @NotNull( groups = Add.class,
            message = ErrorCode.APPROVE_SUBMIT_ORG_ID_NOT_EMPTY )
    private Integer orgId;

    /**
     * 审核提交人id
     */
    @NotNull( groups = Add.class,
            message = ErrorCode.APPROVE_SUBMIT_MEMBER_NOT_EMPTY )
    private Integer memberId;

    /**
     * 搜索人姓名
     */
    private String schMemberName;

    public Integer getApproveExecId() {
        return approveExecId;
    }

    public void setApproveExecId(Integer approveExecId) {
        this.approveExecId = approveExecId;
    }

    public Integer getApproveRecodeId() {
        return approveRecodeId;
    }

    public void setApproveRecodeId(Integer approveRecodeId) {
        this.approveRecodeId = approveRecodeId;
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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getSchMemberName() {
        return schMemberName;
    }

    public void setSchMemberName(String schMemberName) {
        this.schMemberName = schMemberName;
    }
}

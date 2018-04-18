package yxinfo.dct.inteface.dto.chem.apply.biz;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import javax.validation.constraints.NotNull;

/**
 * "申领页面获取审核用户"业务DTO
 * Created by dy on 2016/6/20.
 */
public class ChemGetApproveMberDTO extends BaseDTO {

    private static final long serialVersionUID = -5202207879758429143L;

    /**
     * 审核项目编号
     */
    @Length( max = 10, groups = Add.class,
            message = ErrorCode.APPROVE_ITEM_NO_LENGTH )
    @NotEmpty( groups = Add.class, message = ErrorCode.APPROVE_ITEM_NO_NOT_EMPTY )
    private String itemNo;

    /**
     * 提交人组织id
     */
    @NotNull( groups = Add.class, message = ErrorCode.APPROVE_SUBMIT_ORG_ID_NOT_EMPTY )
    private Integer orgId;

    /**
     * 提交人id
     */
    @NotNull( groups = Add.class, message = ErrorCode.APPROVE_SUBMIT_MEMBER_NOT_EMPTY )
    private Integer memberId;

    /**
     * 搜索成员姓名
     */
    @NotEmpty( groups = Add.class, message = ErrorCode.APPROVE_SCH_M_NAME_NOT_EMPTY )
    private String schMemberName;


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

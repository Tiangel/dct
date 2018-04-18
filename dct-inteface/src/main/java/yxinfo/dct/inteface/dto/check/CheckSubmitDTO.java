package yxinfo.dct.inteface.dto.check;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by sxd on 2016/7/20.
 */
public class CheckSubmitDTO extends BaseDTO {
    private static final long serialVersionUID = -4776337281561534289L;
    // M 组织id
    @NotNull(groups = Add.class, message = ErrorCode.CHECK_RECODE_ORGID_NOT_EMPTY)
    private Integer orgId;
    // M 盘点人id
    @NotNull(groups = Add.class, message = ErrorCode.CHECK_RECODE_MEMBERID_NOT_EMPTY)
    private Integer memberId;
    // M 仓库id
    @NotNull(groups = Add.class, message = ErrorCode.CHECK_RECODE_WHID_NOT_EMPTY)
    private Integer whId;
    // M 试剂rfcode码集合
    @NotNull(groups = Add.class, message = ErrorCode.CHECK_RECODE_RFIDLIST_NOT_EMPTY)
    private List<String> rfidList;

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

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public List<String> getRfidList() {
        return rfidList;
    }

    public void setRfidList(List<String> rfidList) {
        this.rfidList = rfidList;
    }
}

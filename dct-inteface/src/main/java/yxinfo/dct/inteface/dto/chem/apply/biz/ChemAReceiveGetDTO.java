package yxinfo.dct.inteface.dto.chem.apply.biz;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * Created by dy on 2016/6/25.
 */
public class ChemAReceiveGetDTO extends BaseDTO {

    private static final long serialVersionUID = -6311064475732841987L;

    // 审核记录id
    private Integer approveRecodeId;

    // 试剂领取申请记录id
    private Integer applyReceiveId;

    public Integer getApproveRecodeId() {
        return approveRecodeId;
    }

    public void setApproveRecodeId(Integer approveRecodeId) {
        this.approveRecodeId = approveRecodeId;
    }

    public Integer getApplyReceiveId() {
        return applyReceiveId;
    }

    public void setApplyReceiveId(Integer applyReceiveId) {
        this.applyReceiveId = applyReceiveId;
    }
}

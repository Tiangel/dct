package yxinfo.dct.inteface.dto.approve.biz;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.approve.ApproveRecodeDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;

/**
 * 审核结果DTO
 * Created by dy on 2016/6/22.
 */
public class ApproveNodeRetDTO extends BaseDTO {

    private static final long serialVersionUID = -3339615793676684264L;

    /**
     * 审核是否结束
     */
    private boolean isEnd;

    /**
     * 审核后状态（成功、失败或审核中）
     */
    private String status;

    /**
     * 审核记录信息
     */
    private ApproveRecodeDTO approveRecodeDTO;

    /**
     * 审核人姓名
     */
    private MemberDTO approveMember;

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ApproveRecodeDTO getApproveRecodeDTO() {
        return approveRecodeDTO;
    }

    public void setApproveRecodeDTO(ApproveRecodeDTO approveRecodeDTO) {
        this.approveRecodeDTO = approveRecodeDTO;
    }

    public MemberDTO getApproveMember() {
        return approveMember;
    }

    public void setApproveMember(MemberDTO approveMember) {
        this.approveMember = approveMember;
    }
}

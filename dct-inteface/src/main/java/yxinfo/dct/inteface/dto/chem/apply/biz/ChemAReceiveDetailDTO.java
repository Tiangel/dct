package yxinfo.dct.inteface.dto.chem.apply.biz;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.approve.ApproveExecFlowDTO;
import yxinfo.dct.inteface.dto.chem.apply.ChemApplyReceiveDTO;

import java.util.List;

/**
 * 化学品领取申请详情DTO, 包含审核信息
 * Created by dy on 2016/6/23.
 */
public class ChemAReceiveDetailDTO extends BaseDTO {

    private static final long serialVersionUID = 7540485961247064545L;

    // 化学品领取申请
    private ChemApplyReceiveDTO applyReceive;

    // 当前所处审核步骤
    private Integer onStep;

    // 审核总步骤数
    private Integer step;

    // 审核节点信息
    private List<ChemAReceiveNodeDTO> approveNodes;

    // 审核状态（u未提交, o审核中, s审核通过, f审核不通过, i已作废）
    private String status;

    // 审核老师/仓库管理员
    private String approveTeacher;

    // 审核方案
    private List<ApproveExecFlowDTO> execFlows;

    public ChemApplyReceiveDTO getApplyReceive() {
        return applyReceive;
    }

    public void setApplyReceive(ChemApplyReceiveDTO applyReceive) {
        this.applyReceive = applyReceive;
    }

    public Integer getOnStep() {
        return onStep;
    }

    public void setOnStep(Integer onStep) {
        this.onStep = onStep;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public List<ChemAReceiveNodeDTO> getApproveNodes() {
        return approveNodes;
    }

    public void setApproveNodes(List<ChemAReceiveNodeDTO> approveNodes) {
        this.approveNodes = approveNodes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApproveTeacher() {
        return approveTeacher;
    }

    public void setApproveTeacher(String approveTeacher) {
        this.approveTeacher = approveTeacher;
    }

    public List<ApproveExecFlowDTO> getExecFlows() {
        return execFlows;
    }

    public void setExecFlows(List<ApproveExecFlowDTO> execFlows) {
        this.execFlows = execFlows;
    }
}

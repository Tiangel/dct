package yxinfo.dct.inteface.dto.inst;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.approve.ApproveExecFlowDTO;
import yxinfo.dct.inteface.dto.approve.ApproveNodeDTO;
import yxinfo.dct.inteface.dto.chem.apply.biz.ChemAReceiveNodeDTO;

import java.util.List;

/**
 * Created by sxd on 2016/7/15.
 */
public class InstBespeakApproveDTO extends BaseDTO {

    private static final long serialVersionUID = -2593988639188554423L;

    private Integer approveId;

    private InstBespeakDTO instBespeakDTO;

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
    //审核意见
    private String opinion;
    // 审核节点信息
    private List<ApproveNodeDTO> nodeList;
    // 审核方案
    private List<ApproveExecFlowDTO> execFlows;

    public InstBespeakDTO getInstBespeakDTO() {
        return instBespeakDTO;
    }

    public void setInstBespeakDTO(InstBespeakDTO instBespeakDTO) {
        this.instBespeakDTO = instBespeakDTO;
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

    public List<ApproveNodeDTO> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<ApproveNodeDTO> nodeList) {
        this.nodeList = nodeList;
    }

    public Integer getApproveId() {
        return approveId;
    }

    public void setApproveId(Integer approveId) {
        this.approveId = approveId;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
}

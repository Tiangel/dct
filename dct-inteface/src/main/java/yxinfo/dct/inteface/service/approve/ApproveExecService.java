package yxinfo.dct.inteface.service.approve;


import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.approve.ApproveExecDTO;
import yxinfo.dct.inteface.dto.approve.ApproveExecFlowDTO;
import yxinfo.dct.inteface.dto.approve.biz.GetNextFlowDTO;
import yxinfo.dct.inteface.dto.approve.biz.GetNextFlowRetDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;

import java.util.List;

/**
 * 审核方案服务接口
 * Created by dy on 2016/6/18.
 */
public interface ApproveExecService {

    /**
     * 获取审核方案过程
     * @param approveExecId 审核方案id
     * @return
     * @throws Exception
     */
    List<ApproveExecFlowDTO> getFlowList( Integer approveExecId );

    /**
     * 获取审核方案, 同时获取其方案过程
     * @param approveExecId 审核方案id
     * @return
     * @throws Exception
     */
    ApproveExecDTO getApproveExec( Integer approveExecId );

    /**
     * 获取下一个方案过程(新提交审核)
     *      itemNo    审核项目编号
     *      orgId     成员组织id
     *      memberId  审核提交人id
     * @param getNextFlowDTO
     * @return
     * @throws Exception
     */
    GetNextFlowRetDTO getNextExecFlowAdd( GetNextFlowDTO getNextFlowDTO );

    /**
     * 获取下一个方案过程人员(新提交审核)
     * @api 109004 获取下一步审核用户
     * @param getNextFlowPage
     * @return
     */
    PageDTO<List<MemberDTO>> getNextExecFlowAddMember( PageDTO<GetNextFlowDTO> getNextFlowPage );

    /**
     * 获取下一个方案过程(审核过程中)
     *      approveExecId   审核方案id
     *      approveRecodeId 审核记录id
     * @param getNextFlowDTO
     * @return
     * @throws Exception
     */
    GetNextFlowRetDTO getNextExecFlow( GetNextFlowDTO getNextFlowDTO );
}

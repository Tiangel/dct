package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.approve.ApproveNodeDTO;
import yxinfo.dct.inteface.dto.approve.biz.ApproveNodeRetDTO;
import yxinfo.dct.inteface.dto.chem.apply.ChemApplyReceiveDTO;

/**
 * 试剂业务封装服务
 * Created by dy on 2016/7/2.
 */
public interface ChemApplyBizService {

    /**
     * 添加化学试剂领取申请（学校）
     * @api 108005 申请领取（学校）
     * @param chemApplyReceiveDTO 送approveMemberId则自动提交至第一审核节点
     * @param terminal 终端编号
     * @return
     * @throws Exception
     */
    Integer addApplyReceive( ChemApplyReceiveDTO chemApplyReceiveDTO, String terminal );

    /**
     * 化学试剂领取申请审核
     * @api 108010 审核领取申请
     * @param approveNodeDTO
     * @param terminal 终端编号
     * @return
     * @throws Exception
     */
    ApproveNodeRetDTO approveApplyReceive( ApproveNodeDTO approveNodeDTO, String terminal );
}

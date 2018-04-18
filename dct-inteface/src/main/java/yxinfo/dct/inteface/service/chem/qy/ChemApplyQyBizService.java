package yxinfo.dct.inteface.service.chem.qy;

import yxinfo.dct.inteface.dto.chem.apply.ChemApplyReceiveDTO;

/**
 * 企业版试剂业务封装服务
 * Created by dy on 2016/7/2.
 */
public interface ChemApplyQyBizService {

    /**
     * 添加化学试剂领取申请（企业）
     * @api  108037 申请领取（企业）
     * @param chemApplyReceiveDTO 送approveMemberId则自动提交至第一审核节点
     * @param terminal 终端编号
     * @return
     * @throws Exception
     */
    Integer addApplyReceiveQy( ChemApplyReceiveDTO chemApplyReceiveDTO, String terminal );
}

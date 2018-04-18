package yxinfo.dct.inteface.service.chem.qy;

import yxinfo.dct.inteface.dto.approve.ApproveRecodeDTO;
import yxinfo.dct.inteface.dto.chem.apply.ChemApplyReceiveDTO;

/**
 * Created by dy on 2016/6/22.
 */
public interface ChemApplyQyService {

    /**
     * 添加化学试剂领取申请基础操作（企业）
     * @param chemApplyReceiveDTO 送approveMemberId则自动提交至第一审核节点
     * @return
     * @throws Exception
     */
    ApproveRecodeDTO addApplyReceiveQy( ChemApplyReceiveDTO chemApplyReceiveDTO );
}

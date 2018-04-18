package yxinfo.dct.inteface.service.approve;

import yxinfo.dct.inteface.dto.approve.biz.ApproveExtraMsgDTO;

/**
 * Created by dy on 2016/6/23.
 */
public interface ApproveExtMsgService {

    /**
     * 获取额外信息
     * @param itemNo 审核项目编号
     * @param extraMsgId 额外信息id
     * @return
     * @throws Exception
     */
    ApproveExtraMsgDTO getExtraMsg(String itemNo, Integer extraMsgId );
}

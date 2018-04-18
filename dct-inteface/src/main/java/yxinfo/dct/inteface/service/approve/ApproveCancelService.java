package yxinfo.dct.inteface.service.approve;

import yxinfo.dct.inteface.dto.approve.ApproveRecodeDTO;

import java.util.List;

/**
 * Created by dy on 2016/8/28.
 */
public interface ApproveCancelService {

    /**
     * 取消审核
     * @param extraMsgId
     * @param itemNo
     */
    void cancelApprove( Integer extraMsgId, String itemNo );

    /**
     * 批量删除
     * @param apvs 根据 itemNo & extraMsgId 删除
     */
    void deleteApprove( List<ApproveRecodeDTO> apvs );
}

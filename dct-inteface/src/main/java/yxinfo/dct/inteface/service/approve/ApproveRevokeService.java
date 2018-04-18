package yxinfo.dct.inteface.service.approve;

import yxinfo.dct.inteface.context.ErrorCode;

/**
 * Created by dy on 2016/10/13.
 */
public interface ApproveRevokeService {

    /**
     * 撤销审核
     * @param approveRecodeId
     * @param memberId
     * @param step
     * @throws DctException( ErrorCode.APPROVE_RECODE_NOT_EXIST )    审核记录不存在
     * @throws DctException( ErrorCode.APPROVE_NO_RIGHT_TO_REVOKE )  无权撤销审核记录
     * @throws DctException( ErrorCode.APPROVE_REVOKE_NEXT_HAS_APV ) 下一位审核人已审核, 无法撤销
     */
    void revokeApv( Integer approveRecodeId, Integer memberId, Integer step );
}

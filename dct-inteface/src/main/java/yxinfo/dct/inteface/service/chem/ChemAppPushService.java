package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.approve.ApproveRecodeDTO;

/**
 * Created by dy on 2016/8/3.
 */
public interface ChemAppPushService {

    /**
     * APP通知
     * @param itemNo
     * @param context
     * @param approveRecodeDTO
     * @param extraMsgId
     * @param terminal 终端类型编号, {@link yxinfo.dct.inteface.context.base.TerminalCode}
     */
    void doAppPush( String itemNo, String context, ApproveRecodeDTO approveRecodeDTO, Integer extraMsgId,
                    String terminal );

}

package yxinfo.dct.inteface.service.evt;

import yxinfo.dct.inteface.context.base.OrgFeeItem;

import java.util.List;

/**
 * Created by dy on 2016/8/4.
 */
public interface SmsService {

    /**
     * 下发短信（通知类）
     * <p>非营销类通知短信, 会对orgId对应组织计费, 计费项目为{@link OrgFeeItem.SMS_NTF}<p/>
     * @param orgId
     * @param mobiles
     * @param context
     */
    Boolean sendSMS( Integer orgId, List<String> mobiles, String context );

}

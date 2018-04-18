package yxinfo.dct.inteface.service.evt;

import yxinfo.dct.inteface.dto.evt.EvtNotifyDTO;

/**
 * Created by dy on 2016/7/1.
 */
public interface AppPushService {

    /**
     * APP推送(极光推送)
     * @param evtNotifyDTO
     * @return
     */
    boolean doJPush( EvtNotifyDTO evtNotifyDTO );

}

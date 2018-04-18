package yxinfo.dct.inteface.service.evt;

import yxinfo.dct.inteface.dto.evt.EvtNotifyDTO;

/**
 * Created by dy on 2016/8/13.
 */
public interface NotifyBizService {

    /**
     * 事件通知
     * @param evtNotifyDTO
     * @return
     */
    boolean doNotify( EvtNotifyDTO evtNotifyDTO );

}

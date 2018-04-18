package yxinfo.dct.inteface.service.evt;

import yxinfo.dct.inteface.dto.evt.EvtRedPointDTO;

/**
 * Created by dy on 2016/6/29.
 */
public interface RedPointService {

    /**
     * 增加事件通知数量
     * @param redPointDTO
     */
    void plusRedPointCount( EvtRedPointDTO redPointDTO );

    /**
     * 清除事件通知数量
     * @param redPointDTO
     */
    void clearRedPointCount( EvtRedPointDTO redPointDTO );

    /**
     * 获取事件通知数量
     * @api 110001 是否有事件状态更新（红点提示）
     * @param redPointDTO
     * @return
     */
    int getRedPointNum( EvtRedPointDTO redPointDTO );

}

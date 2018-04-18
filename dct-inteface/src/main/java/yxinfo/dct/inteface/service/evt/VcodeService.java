package yxinfo.dct.inteface.service.evt;

import yxinfo.dct.inteface.dto.evt.EvtVcodeDTO;

/**
 * Created by dy on 2016/6/27.
 */
public interface VcodeService {

    /**
     * 发送验证码
     * @param evtVcodeDTO
     */
    void sendVCode( EvtVcodeDTO evtVcodeDTO );

    /**
     * 发送验证码(自动生成验证码)
     * @param evtVcodeDTO
     */
    void sendVCodeCrtCode( EvtVcodeDTO evtVcodeDTO );

    /**
     * 验证验证码
     * @param evtVcodeDTO
     * @return 需要票据时返回
     */
    String checkVCode( EvtVcodeDTO evtVcodeDTO );

}

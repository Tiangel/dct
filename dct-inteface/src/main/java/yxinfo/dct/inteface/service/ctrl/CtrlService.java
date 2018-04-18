package yxinfo.dct.inteface.service.ctrl;

import yxinfo.dct.inteface.dto.ctrl.*;

/**
 * @author sxd
 * @date 2016/8/11 14:21
 */
public interface CtrlService {

    CtrlLabMsgShowDTO getLabMsg(CtrlLabMsgShowDTO ctrlLabMsgShowDTO);

    boolean sendMsg4App(String itemNo, Integer orgId, String title);

    /**
     * 获取温度和湿度
     * @param ctrlTempAndHumSearchDTO
     * @return
     */
    CtrlTempHumDTO getCtrlTempHum(CtrlTempAndHumSearchDTO ctrlTempAndHumSearchDTO);

    int editTempHum(CtrlTempHumDTO ctrlTempHumDTO);

    CtrlEquAndInstShowDTO getEquAndInstShow(String equNo);
}

package yxinfo.dct.inteface.service.ctrl;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.ctrl.CtrlTempHumDTO;

import java.util.List;

/**
 * @author sxd
 * @date 2016/8/23 20:43
 */
public interface CtrlTempHumService {

    List<CtrlTempHumDTO> getList(PageDTO pageDTO);

}

package yxinfo.dct.inteface.service.lab;

import yxinfo.dct.inteface.dto.lab.LabTempHumDTO;

/**
 * @author sxd
 * @date 2016/8/24 12:06
 */
public interface LabTempHumService {

    int insert(LabTempHumDTO labTempHumDTO);

    LabTempHumDTO getLastLabTempHum(Integer labId);
}

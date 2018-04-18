package yxinfo.dct.inteface.service.lab;

import yxinfo.dct.inteface.dto.lab.LabSettingsDTO;

/**
 * @author sxd
 * @date 2016/8/24 12:07
 */
public interface LabSettingsService {

    String getValue(Integer labId, Byte fkey);

    int edit(LabSettingsDTO labSettingsDTO);

}

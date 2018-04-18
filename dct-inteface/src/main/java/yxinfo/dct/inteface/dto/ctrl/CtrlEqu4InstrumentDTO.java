package yxinfo.dct.inteface.dto.ctrl;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.equipment.EquEquipmentDTO;

/**
 * @author lovetcat
 * @date 2016/8/11 16:50
 */
public class CtrlEqu4InstrumentDTO extends BaseDTO {

    private EquEquipmentDTO equEquipmentDTO;

    private Integer instId;

    public EquEquipmentDTO getEquEquipmentDTO() {
        return equEquipmentDTO;
    }

    public void setEquEquipmentDTO(EquEquipmentDTO equEquipmentDTO) {
        this.equEquipmentDTO = equEquipmentDTO;
    }

    public Integer getInstId() {
        return instId;
    }

    public void setInstId(Integer instId) {
        this.instId = instId;
    }
}

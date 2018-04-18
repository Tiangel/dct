package yxinfo.dct.inteface.dto.mq;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;

/**
 * Created by dy on 2016/8/17.
 */
public class MQChemTrajDTO extends BaseDTO {

    private static final long serialVersionUID = -5996844248430897115L;

    // 轨迹信息id
    private Integer chemTrajId;

    // 当时的试剂信息
    private ChemReagentDTO thenReagent;

    public Integer getChemTrajId() {
        return chemTrajId;
    }

    public void setChemTrajId( Integer chemTrajId ) {
        this.chemTrajId = chemTrajId;
    }

    public ChemReagentDTO getThenReagent() {
        return thenReagent;
    }

    public void setThenReagent( ChemReagentDTO thenReagent ) {
        this.thenReagent = thenReagent;
    }
}

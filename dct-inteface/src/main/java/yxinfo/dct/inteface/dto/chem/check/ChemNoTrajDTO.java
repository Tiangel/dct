package yxinfo.dct.inteface.dto.chem.check;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.apply.ChemReceiveDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;

/**
 * Created by dy on 2016/7/21.
 */
public class ChemNoTrajDTO extends BaseDTO {

    private static final long serialVersionUID = -6377227676411723705L;

    // 领取的试剂
    private ChemReagentDTO reagent;

    // 领用记录
    private ChemReceiveDTO receive;

    public ChemReagentDTO getReagent() {
        return reagent;
    }

    public void setReagent(ChemReagentDTO reagent) {
        this.reagent = reagent;
    }

    public ChemReceiveDTO getReceive() {
        return receive;
    }

    public void setReceive(ChemReceiveDTO receive) {
        this.receive = receive;
    }
}

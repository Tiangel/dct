package yxinfo.dct.inteface.dto.chem.check;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemRecycleDTO;

/**
 * Created by dy on 2016/7/21.
 */
public class ChemRecycleAbnorDTO extends BaseDTO {

    private static final long serialVersionUID = 8087968780716936299L;

    // 领取的试剂
    private ChemReagentDTO reagent;

    // 回收信息
    private ChemRecycleDTO recycle;

    // 申领的容量
    private Integer apply;

    public ChemReagentDTO getReagent() {
        return reagent;
    }

    public void setReagent(ChemReagentDTO reagent) {
        this.reagent = reagent;
    }

    public ChemRecycleDTO getRecycle() {
        return recycle;
    }

    public void setRecycle(ChemRecycleDTO recycle) {
        this.recycle = recycle;
    }

    public Integer getApply() {
        return apply;
    }

    public void setApply(Integer apply) {
        this.apply = apply;
    }
}

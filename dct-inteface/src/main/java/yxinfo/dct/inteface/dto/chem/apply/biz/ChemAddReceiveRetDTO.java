package yxinfo.dct.inteface.dto.chem.apply.biz;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;

/**
 * 申领返回DTO
 * Created by dy on 2016/7/2.
 */
public class ChemAddReceiveRetDTO extends BaseDTO {

    private static final long serialVersionUID = -8513640857846905904L;

    // 申领id
    private Integer applyReceiveId;

    // 领用的试剂id
    private ChemReagentDTO chemReagentDTO;

    public Integer getApplyReceiveId() {
        return applyReceiveId;
    }

    public void setApplyReceiveId(Integer applyReceiveId) {
        this.applyReceiveId = applyReceiveId;
    }

    public ChemReagentDTO getChemReagentDTO() {
        return chemReagentDTO;
    }

    public void setChemReagentDTO(ChemReagentDTO chemReagentDTO) {
        this.chemReagentDTO = chemReagentDTO;
    }
}

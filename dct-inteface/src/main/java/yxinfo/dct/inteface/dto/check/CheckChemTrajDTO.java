package yxinfo.dct.inteface.dto.check;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;
import yxinfo.dct.inteface.dto.chem.traj.ChemTrajDTO;
import yxinfo.dct.inteface.validation.groups.Select;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author sxd
 * @date 2016/7/30 11:45
 */
public class CheckChemTrajDTO extends BaseDTO {

    @NotNull(groups = Select.class, message = ErrorCode.CHECK_RECODE_CHECKCHEMID_NOT_NULL)
    private Integer checkChemId;

    private List<ChemTrajDTO> chemTrajDTO;

    private ChemReagentDTO chemReagentDTO;

    public Integer getCheckChemId() {
        return checkChemId;
    }

    public void setCheckChemId(Integer checkChemId) {
        this.checkChemId = checkChemId;
    }

    public List<ChemTrajDTO> getChemTrajDTO() {
        return chemTrajDTO;
    }

    public void setChemTrajDTO(List<ChemTrajDTO> chemTrajDTO) {
        this.chemTrajDTO = chemTrajDTO;
    }

    public ChemReagentDTO getChemReagentDTO() {
        return chemReagentDTO;
    }

    public void setChemReagentDTO(ChemReagentDTO chemReagentDTO) {
        this.chemReagentDTO = chemReagentDTO;
    }

    public CheckChemTrajDTO() {
    }

    public CheckChemTrajDTO(List<ChemTrajDTO> chemTrajDTO, ChemReagentDTO chemReagentDTO) {
        this.chemTrajDTO = chemTrajDTO;
        this.chemReagentDTO = chemReagentDTO;
    }

    @Override
    public String toString() {
        return "CheckChemTrajDTO{" +
                "checkChemId=" + checkChemId +
                ", chemTrajDTO=" + chemTrajDTO +
                ", chemReagentDTO=" + chemReagentDTO +
                '}';
    }
}

package yxinfo.dct.inteface.dto.chem.reagent.biz;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * Created by dy on 2016/7/14.
 */
public class ChemReagentSchDTO extends BaseDTO {

    private static final long serialVersionUID = 4670115910036698250L;

    @Valid
    private ChemReagentDTO reagent;

    // 入库时间范围, createAtFrom~ createAtTo
    private Date createAtFrom;
    private Date createAtTo;

    private List<Integer> ids;

    public ChemReagentDTO getReagent() {
        return reagent;
    }

    public void setReagent(ChemReagentDTO reagent) {
        this.reagent = reagent;
    }

    public Date getCreateAtFrom() {
        return createAtFrom;
    }

    public void setCreateAtFrom(Date createAtFrom) {
        this.createAtFrom = createAtFrom;
    }

    public Date getCreateAtTo() {
        return createAtTo;
    }

    public void setCreateAtTo(Date createAtTo) {
        this.createAtTo = createAtTo;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}

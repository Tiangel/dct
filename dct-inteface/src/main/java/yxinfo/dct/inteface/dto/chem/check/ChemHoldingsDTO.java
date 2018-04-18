package yxinfo.dct.inteface.dto.chem.check;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;

import java.util.List;

/**
 * Created by dy on 2016/7/21.
 */
public class ChemHoldingsDTO extends BaseDTO {

    private static final long serialVersionUID = 5500379031984172640L;

    // 成员
    private MemberDTO member;

    // 成员持有试剂
    private List<ChemReagentDTO> holdings;

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public List<ChemReagentDTO> getHoldings() {
        return holdings;
    }

    public void setHoldings(List<ChemReagentDTO> holdings) {
        this.holdings = holdings;
    }
}

package yxinfo.dct.inteface.dto.chem.check;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.List;

/**
 * 试剂混放检查
 * Created by dy on 2016/8/5.
 */
public class ChemMixDTO extends BaseDTO {

    private static final long serialVersionUID = 1748026877462395505L;

    // 1实验室混放, 2仓库混放
    private int type;

    // 位置id
    private int siteId;

    // 混放试剂id
    private List<Integer> reagentIds;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public List<Integer> getReagentIds() {
        return reagentIds;
    }

    public void setReagentIds(List<Integer> reagentIds) {
        this.reagentIds = reagentIds;
    }
}

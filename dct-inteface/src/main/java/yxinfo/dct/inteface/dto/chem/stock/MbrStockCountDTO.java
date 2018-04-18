package yxinfo.dct.inteface.dto.chem.stock;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * Created by dy on 2016/10/19.
 */
public class MbrStockCountDTO extends BaseDTO {

    private static final long serialVersionUID = 4100215112878216478L;

    private Integer chemNum;

    private Integer total;

    public Integer getChemNum() {
        return chemNum;
    }

    public void setChemNum( Integer chemNum ) {
        this.chemNum = chemNum;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal( Integer total ) {
        this.total = total;
    }
}

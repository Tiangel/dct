package yxinfo.dct.inteface.dto.chem.stock;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * Created by dy on 2016/10/18.
 */
public class ChemStockSchDTO extends BaseDTO {

    private static final long serialVersionUID = -7064742181827905286L;

    private String schText;

    private Integer orgId;

    public String getSchText() {
        return schText;
    }

    public void setSchText( String schText ) {
        this.schText = schText;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId( Integer orgId ) {
        this.orgId = orgId;
    }
}

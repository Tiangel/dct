package yxinfo.dct.inteface.dto.chem.stocks;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.List;

/**
 * Created by dy on 2016/10/19.
 */
public class StockSummarySchDTO extends BaseDTO {

    private static final long serialVersionUID = -638084823401513884L;

    private Integer orgId;

    private String mbrCode;

    // 是否搜索可调配试剂库存
    private boolean schCanDeploy;

    private Integer chemId;

    private List<String> statusIn;

    private String status;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId( Integer orgId ) {
        this.orgId = orgId;
    }

    public String getMbrCode() {
        return mbrCode;
    }

    public void setMbrCode( String mbrCode ) {
        this.mbrCode = mbrCode;
    }

    public boolean isSchCanDeploy() {
        return schCanDeploy;
    }

    public void setSchCanDeploy( boolean schCanDeploy ) {
        this.schCanDeploy = schCanDeploy;
    }

    public Integer getChemId() {
        return chemId;
    }

    public void setChemId( Integer chemId ) {
        this.chemId = chemId;
    }

    public List<String> getStatusIn() {
        return statusIn;
    }

    public void setStatusIn( List<String> statusIn ) {
        this.statusIn = statusIn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus( String status ) {
        this.status = status;
    }
}

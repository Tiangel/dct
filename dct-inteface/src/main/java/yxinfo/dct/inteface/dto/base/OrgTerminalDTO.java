package yxinfo.dct.inteface.dto.base;

import yxinfo.dct.inteface.dto.BaseDTO;

public class OrgTerminalDTO extends BaseDTO {

    private static final long serialVersionUID = 6631606635852136245L;

    private String termCode;
    private Integer orgId;

    public String getTermCode() {
        return termCode;
    }

    public void setTermCode(String termCode) {
        this.termCode = termCode;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
}
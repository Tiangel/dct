package yxinfo.dct.inteface.dto.lab;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * Created by cy on 2016/7/12.
 */
public class LaboratoryExportDTO extends BaseDTO {

    private Integer orgId;

    private String labName;

    private String labCode;

    private String token;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getLabCode() {
        return labCode;
    }

    public void setLabCode(String labCode) {
        this.labCode = labCode;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

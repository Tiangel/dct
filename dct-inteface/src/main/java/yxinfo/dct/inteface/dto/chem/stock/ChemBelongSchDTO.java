package yxinfo.dct.inteface.dto.chem.stock;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;

import javax.validation.constraints.NotNull;

public class ChemBelongSchDTO extends BaseDTO {

    private static final long serialVersionUID = 3333389064868220644L;

    // 组织id
    @NotNull( message = ErrorCode.CHEM_REAGENT_ORG_ID_NOT_EMPTY )
    private Integer orgId;

    // 对应化学品id
    @NotNull( message = ErrorCode.CHEM_CHEM_ID_NOT_EMPTY )
    private Integer chemId;

    // 规格id
    @NotNull( message = ErrorCode.CHEM_SPEC_ID_NOT_EMPTY )
    private Integer specId;

    // 容量
    @NotNull( message = ErrorCode.CHEM_CAPACITY_NOT_EMPTY )
    private Integer capacity;

    // 容量计量单位id
    @NotNull( message = ErrorCode.CHEM_UNIT_ID_NOT_EMPTY )
    private Integer unitId;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId( Integer orgId ) {
        this.orgId = orgId;
    }

    public Integer getChemId() {
        return chemId;
    }

    public void setChemId( Integer chemId ) {
        this.chemId = chemId;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId( Integer specId ) {
        this.specId = specId;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity( Integer capacity ) {
        this.capacity = capacity;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId( Integer unitId ) {
        this.unitId = unitId;
    }
}

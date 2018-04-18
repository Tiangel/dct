package yxinfo.dct.inteface.dto.chem.stocks;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemChemicalDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemSpecDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemUnitDTO;

/**
 * Created by dy on 2016/6/23.
 */
public class StockSummaryDTO extends BaseDTO {

    private static final long serialVersionUID = 3705754913135091431L;

    // 组织id
    private Integer orgId;

    // 化学品id
    private Integer chemId;
    private ChemChemicalDTO chem;

    // 规格id
    private Integer specId;
    private ChemSpecDTO spec;

    // 容量
    private Integer capacity;

    // 单位id
    private Integer unitId;
    private ChemUnitDTO unit;

    // 数量
    private Integer count;

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

    public ChemChemicalDTO getChem() {
        return chem;
    }

    public void setChem( ChemChemicalDTO chem ) {
        this.chem = chem;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId( Integer specId ) {
        this.specId = specId;
    }

    public ChemSpecDTO getSpec() {
        return spec;
    }

    public void setSpec( ChemSpecDTO spec ) {
        this.spec = spec;
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

    public ChemUnitDTO getUnit() {
        return unit;
    }

    public void setUnit( ChemUnitDTO unit ) {
        this.unit = unit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount( Integer count ) {
        this.count = count;
    }
}

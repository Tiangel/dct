package yxinfo.dct.inteface.dto.chem.reagent;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemChemicalDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemSpecDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemUnitDTO;
import yxinfo.dct.inteface.validation.groups.Select;
import yxinfo.dct.inteface.validation.groups.Update;
import yxinfo.dct.inteface.validation.groups.chem.Apply;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class ChemWhTotalDTO extends BaseDTO {

    private static final long serialVersionUID = 6591705060565621944L;

    private Integer id;

    //组织id
    @NotNull( groups = { Apply.class, Update.class, Select.class },
            message = ErrorCode.CHEM_ORG_ID_NOT_EMPTY )
    private Integer orgId;

    //化学品id
    @NotNull( groups = { Apply.class, Update.class, Select.class },
            message = ErrorCode.CHEM_CHEM_ID_NOT_EMPTY )
    private Integer chemId;
    private ChemChemicalDTO chem;

    //规格id
    @NotNull( groups = { Update.class, Select.class },
            message = ErrorCode.CHEM_SPEC_ID_NOT_EMPTY )
    private Integer specId;
    private ChemSpecDTO spec;

    //容量计量单位id
    @NotNull( groups = { Update.class, Select.class },
            message = ErrorCode.CHEM_UNIT_ID_NOT_EMPTY )
    private Integer unitId;
    private ChemUnitDTO unit;

    //存量
    private Integer total;

    //更新时间
    private Date updateAt;

    //库存详情
    private List<ChemSummaryDTO> summary;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getChemId() {
        return chemId;
    }

    public void setChemId(Integer chemId) {
        this.chemId = chemId;
    }

    public ChemChemicalDTO getChem() {
        return chem;
    }

    public void setChem(ChemChemicalDTO chem) {
        this.chem = chem;
    }

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public ChemSpecDTO getSpec() {
        return spec;
    }

    public void setSpec(ChemSpecDTO spec) {
        this.spec = spec;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public ChemUnitDTO getUnit() {
        return unit;
    }

    public void setUnit(ChemUnitDTO unit) {
        this.unit = unit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public List<ChemSummaryDTO> getSummary() {
        return summary;
    }

    public void setSummary(List<ChemSummaryDTO> summary) {
        this.summary = summary;
    }
}
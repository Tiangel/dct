package yxinfo.dct.inteface.dto.chem.reagent;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemChemicalDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemSpecDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemUnitDTO;
import yxinfo.dct.inteface.dto.lab.LaboratoryDTO;
import yxinfo.dct.inteface.dto.wh.WhDTO;
import yxinfo.dct.inteface.validation.groups.Select;
import yxinfo.dct.inteface.validation.groups.Update;
import yxinfo.dct.inteface.validation.groups.chem.Apply;

import javax.validation.constraints.NotNull;

/**
 * Created by dy on 2016/6/23.
 */
public class ChemSummaryDTO extends BaseDTO {

    private static final long serialVersionUID = 7863298336473078820L;

    //id
    private Integer id;

    //组织id
    @NotNull( groups = { Apply.class, Update.class, Select.class },
            message = ErrorCode.CHEM_ORG_ID_NOT_EMPTY )
    private Integer orgId;

    //仓库id
    @NotNull( groups = { Update.class, Select.class },
            message = ErrorCode.CHEM_WH_ID_NOT_EMPTY )
    private Integer whId;
    private WhDTO wh;

    //实验室id
    @NotNull( groups = { Update.class, Select.class },
            message = ErrorCode.CHEM_LAB_ID_NOT_EMPTY )
    private Integer labId;
    private LaboratoryDTO lab;

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

    //容量
    @NotNull( groups = { Update.class, Select.class },
            message = ErrorCode.CHEM_CAPACITY_NOT_EMPTY )
    private Integer capacity;

    //化学试剂状态（1库存中, 2使用中, 3待回收, 4正常回收, 5回收但未扫码, 6扫码但未回收, 7被申领但未领用）
    @NotEmpty( groups = { Update.class, Select.class },
            message = ErrorCode.CHEM_STATUS_NOT_EMPTY )
    private String status;

    //数量
    private Integer count;

    //单位id
    @NotNull( groups = { Update.class, Select.class },
            message = ErrorCode.CHEM_UNIT_ID_NOT_EMPTY )
    private Integer unitId;
    private ChemUnitDTO unit;

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

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public WhDTO getWh() {
        return wh;
    }

    public void setWh(WhDTO wh) {
        this.wh = wh;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public LaboratoryDTO getLab() {
        return lab;
    }

    public void setLab(LaboratoryDTO lab) {
        this.lab = lab;
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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
}

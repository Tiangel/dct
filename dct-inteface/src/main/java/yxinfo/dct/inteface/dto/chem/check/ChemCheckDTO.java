package yxinfo.dct.inteface.dto.chem.check;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemChemicalDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemSpecDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemUnitDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * 试剂库存盘点DTO
 * Created by dy on 2016/7/20.
 */
public class ChemCheckDTO extends BaseDTO {

    private static final long serialVersionUID = -1322685917884357393L;

    //化学品id
    private Integer chemId;
    private ChemChemicalDTO chem;

    //规格id
    private Integer specId;
    private ChemSpecDTO spec;

    //容量
    private Integer capacity;

    //单位id
    private Integer unitId;
    private ChemUnitDTO unit;

    //盘点得出的数量
    private Integer ckNum;

    //记录的库存数量
    private Integer recordNum;

    // 盘盈id列表
    private List<Integer> idsMore = new ArrayList<Integer>();

    // 盘亏id列表
    private List<Integer> idsLess = new ArrayList<Integer>();

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

    public Integer getCkNum() {
        return ckNum;
    }

    public void setCkNum(Integer ckNum) {
        this.ckNum = ckNum;
    }

    public Integer getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(Integer recordNum) {
        this.recordNum = recordNum;
    }

    public List<Integer> getIdsMore() {
        return idsMore;
    }

    public void setIdsMore(List<Integer> idsMore) {
        this.idsMore = idsMore;
    }

    public List<Integer> getIdsLess() {
        return idsLess;
    }

    public void setIdsLess(List<Integer> idsLess) {
        this.idsLess = idsLess;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ChemCheckDTO{");
        sb.append("chemId=").append(chemId);
        sb.append(", specId=").append(specId);
        sb.append(", capacity=").append(capacity);
        sb.append(", unitId=").append(unitId);
        sb.append(", ckNum=").append(ckNum);
        sb.append(", recordNum=").append(recordNum);
        sb.append(", idsMore=").append(idsMore);
        sb.append(", idsLess=").append(idsLess);
        sb.append('}');
        return sb.toString();
    }
}

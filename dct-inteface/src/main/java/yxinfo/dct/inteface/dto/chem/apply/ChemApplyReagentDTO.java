package yxinfo.dct.inteface.dto.chem.apply;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemChemicalDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemSpecDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemUnitDTO;

import javax.validation.constraints.NotNull;

/**
 * 申请领取的化学试剂DTO
 * Created by dy on 2016/6/21.
 */
public class ChemApplyReagentDTO extends BaseDTO {

    private static final long serialVersionUID = -270864020221253366L;
    
    //id
    private Integer id;

    //领取申请id
    private Integer arId;
    private ChemApplyReceiveDTO applyReceive;

    //化学品id
    @NotNull( message = ErrorCode.CHEM_CHEM_ID_NOT_EMPTY )
    private Integer chemId;
    private ChemChemicalDTO chem;

    //规格id
    @NotNull( message = ErrorCode.CHEM_SPEC_ID_NOT_EMPTY )
    private Integer specId;
    private ChemSpecDTO spec;

    //申请的容量
    @NotNull( message = ErrorCode.CHEM_CAPACITY_NOT_EMPTY )
    private Integer capacity;

    //领取记录id
    private Integer receiveId;
    private ChemReceiveDTO receive;

    //领取状态（1未领, 2已领）
    private String receiveSta;

    //容量计量单位id
    @NotNull( message = ErrorCode.CHEM_UNIT_ID_NOT_EMPTY )
    private Integer unitId;
    private ChemUnitDTO unit;

    // 已领数量
    private Integer receiveTotal;
    // 申领数量
    private Integer applyTotal;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }

    public ChemApplyReceiveDTO getApplyReceive() {
        return applyReceive;
    }

    public void setApplyReceive(ChemApplyReceiveDTO applyReceive) {
        this.applyReceive = applyReceive;
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

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public ChemReceiveDTO getReceive() {
        return receive;
    }

    public void setReceive(ChemReceiveDTO receive) {
        this.receive = receive;
    }

    public String getReceiveSta() {
        return receiveSta;
    }

    public void setReceiveSta(String receiveSta) {
        this.receiveSta = receiveSta;
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

    public Integer getReceiveTotal() {
        return receiveTotal;
    }

    public void setReceiveTotal(Integer receiveTotal) {
        this.receiveTotal = receiveTotal;
    }

    public Integer getApplyTotal() {
        return applyTotal;
    }

    public void setApplyTotal(Integer applyTotal) {
        this.applyTotal = applyTotal;
    }
}

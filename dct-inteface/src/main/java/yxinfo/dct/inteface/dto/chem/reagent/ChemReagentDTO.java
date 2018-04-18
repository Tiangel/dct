package yxinfo.dct.inteface.dto.chem.reagent;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemChemicalDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemSpecDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemUnitDTO;
import yxinfo.dct.inteface.dto.lab.LaboratoryDTO;
import yxinfo.dct.inteface.dto.wh.WhDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.chem.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 化学试剂DTO
 * Created by dy on 2016/6/21.
 */
public class ChemReagentDTO extends BaseDTO {

    private static final long serialVersionUID = 8927091040664945726L;

    //id
    private Integer id;

    //组织id
    @NotNull( groups = {
            Add.class,
            RecycleList.class, RecycleAdd.class,
            ReceiveList.class, ReceiveAdd.class,
            ReagentList.class },
            message = ErrorCode.CHEM_REAGENT_ORG_ID_NOT_EMPTY )
    private Integer orgId;

    //存放仓库id
    private Integer whId;
    private WhDTO wh;

    //存放实验室id
    private Integer labId;
    private LaboratoryDTO lab;

    //对应化学品id
    @NotNull( groups = Add.class, message = ErrorCode.CHEM_CHEM_ID_NOT_EMPTY )
    private Integer chemId;
    private ChemChemicalDTO chem;

    //规格id
    @NotNull( groups = Add.class, message = ErrorCode.CHEM_SPEC_ID_NOT_EMPTY )
    private Integer specId;
    private ChemSpecDTO spec;

    //容量
    @NotNull( groups = Add.class, message = ErrorCode.CHEM_CAPACITY_NOT_EMPTY )
    private Integer capacity;

    //容量计量单位id
    @NotNull( groups = Add.class, message = ErrorCode.CHEM_UNIT_ID_NOT_EMPTY )
    private Integer unitId;
    private ChemUnitDTO unit;

    //状态（1库存中, 2使用中, 3待回收, 4正常回收, 5回收但未扫码, 6扫码但未回收, 7被申领但未领用）
    private String status;

    //试剂唯一编号
    private String fcode;

    //已用容量
    private Integer used;

    //RFID码
    @NotNull( groups = { RecycleAdd.class, ReceiveAdd.class, GetChemInfo.class },
            message = ErrorCode.CHEM_REAGENT_RF_CODE_NOT_EMPTY )
    private String rfFcode;

    //目前归属于的领取申请id
    private Integer arId;

    //目前归属于的用户id
    @NotNull( groups = { ReceiveAdd.class, RecycleAdd.class },
            message = ErrorCode.CHEM_MEMBER_ID_NOT_EMPTY )
    private Integer memberId;

    //RFID码列表
    @NotEmpty( groups = Add.class,
            message = ErrorCode.CHEM_REAGENT_RF_CODE_NOT_EMPTY )
    private List<String> rfFcodes;

    //是否可领取
    private  boolean canReceive;

    //负责人成员id
    private Integer inCharge;
    private MemberDTO inChargeMember;

    //归属人成员id
    private Integer belongTo;
    private MemberDTO belongToMember;

    //入库时间
    private Date intowhAt;

    //归属人成员工号
    private String belongToCode;

    //是否由电商采购入库
    private Boolean fromShop;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public String getRfFcode() {
        return rfFcode;
    }

    public void setRfFcode(String rfFcode) {
        this.rfFcode = rfFcode;
    }

    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public List<String> getRfFcodes() {
        return rfFcodes;
    }

    public void setRfFcodes(List<String> rfFcodes) {
        this.rfFcodes = rfFcodes;
    }

    public boolean isCanReceive() {
        return canReceive;
    }

    public void setCanReceive(boolean canReceive) {
        this.canReceive = canReceive;
    }

    public Integer getInCharge() {
        return inCharge;
    }

    public void setInCharge(Integer inCharge) {
        this.inCharge = inCharge;
    }

    public MemberDTO getInChargeMember() {
        return inChargeMember;
    }

    public void setInChargeMember(MemberDTO inChargeMember) {
        this.inChargeMember = inChargeMember;
    }

    public Integer getBelongTo() {
        return belongTo;
    }

    public void setBelongTo( Integer belongTo ) {
        this.belongTo = belongTo;
    }

    public MemberDTO getBelongToMember() {
        return belongToMember;
    }

    public void setBelongToMember( MemberDTO belongToMember ) {
        this.belongToMember = belongToMember;
    }

    public Date getIntowhAt() {
        return intowhAt;
    }

    public void setIntowhAt( Date intowhAt ) {
        this.intowhAt = intowhAt;
    }

    public String getBelongToCode() {
        return belongToCode;
    }

    public void setBelongToCode( String belongToCode ) {
        this.belongToCode = belongToCode;
    }

    public Boolean getFromShop() {
        return fromShop;
    }

    public void setFromShop( Boolean fromShop ) {
        this.fromShop = fromShop;
    }
}

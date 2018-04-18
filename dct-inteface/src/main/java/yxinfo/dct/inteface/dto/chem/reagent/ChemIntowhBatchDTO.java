package yxinfo.dct.inteface.dto.chem.reagent;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemSpecDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemUnitDTO;

import java.util.Date;

public class ChemIntowhBatchDTO extends BaseDTO {

    private static final long serialVersionUID = -1130870824793081937L;

    private Integer id;

    //组织id
    private Integer orgId;

    //化学品id
    private Integer chemId;

    //归属人成员工号
    private String belongToCode;

    //归属人姓名
    private String belongToName;

    private Integer specId;

    private Integer capacity;

    //容量计量单位id
    private Integer unitId;

    //入库数量
    private Integer num;

    //创建时间
    private Date createAt;

    //仓库id
    private Integer whId;

    //入库人成员id
    private Integer memberId;

    // ================================================
    private String schText;

    private String chemName;

    private ChemSpecDTO spec;

    private ChemUnitDTO unit;

    private String cas;

    private String memberCode;

    private String realName;

    private Date intowhAt;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

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

    public String getBelongToCode() {
        return belongToCode;
    }

    public void setBelongToCode( String belongToCode ) {
        this.belongToCode = belongToCode;
    }

    public String getBelongToName() {
        return belongToName;
    }

    public void setBelongToName( String belongToName ) {
        this.belongToName = belongToName;
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

    public Integer getNum() {
        return num;
    }

    public void setNum( Integer num ) {
        this.num = num;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt( Date createAt ) {
        this.createAt = createAt;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId( Integer whId ) {
        this.whId = whId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId( Integer memberId ) {
        this.memberId = memberId;
    }

    public String getSchText() {
        return schText;
    }

    public void setSchText( String schText ) {
        this.schText = schText;
    }

    public String getChemName() {
        return chemName;
    }

    public void setChemName( String chemName ) {
        this.chemName = chemName;
    }

    public ChemSpecDTO getSpec() {
        return spec;
    }

    public void setSpec( ChemSpecDTO spec ) {
        this.spec = spec;
    }

    public ChemUnitDTO getUnit() {
        return unit;
    }

    public void setUnit( ChemUnitDTO unit ) {
        this.unit = unit;
    }

    public String getCas() {
        return cas;
    }

    public void setCas( String cas ) {
        this.cas = cas;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode( String memberCode ) {
        this.memberCode = memberCode;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName( String realName ) {
        this.realName = realName;
    }

    public Date getIntowhAt() {
        return intowhAt;
    }

    public void setIntowhAt( Date intowhAt ) {
        this.intowhAt = intowhAt;
    }
}
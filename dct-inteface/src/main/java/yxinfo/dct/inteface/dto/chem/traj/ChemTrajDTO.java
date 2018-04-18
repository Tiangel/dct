package yxinfo.dct.inteface.dto.chem.traj;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;
import yxinfo.dct.inteface.validation.groups.PageSelect;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

public class ChemTrajDTO extends BaseDTO {

    private static final long serialVersionUID = -7470213564793524669L;

    private Integer id;

    //组织id
    @NotNull( groups = PageSelect.class,
            message = ErrorCode.ORG_ID_NOT_NULL )
    private Integer orgId;

    //化学试剂id
    private Integer reagentId;
    private ChemReagentDTO reagent;

    //轨迹原由，<FK>chem_traj_reason.reason
    private Short reason;

    //位置信息id（仓库id、实验室id）
    private Integer siteId;

    //位置名称
    private String fname;

    //位置地址
    private String address;

    //设备id
    private Integer equId;

    //设备编号
    private String equNo;

    //设备名称
    private String equName;

    //地址
    private String equAddress;

    //经度
    private BigDecimal lat;

    //纬度
    private BigDecimal lng;

    //相关领用记录id
    private Integer arId;

    //相关人员成员id
    private Integer inCharge;
    private MemberDTO inChargeMember;

    //轨迹信息产生前试剂处于的实验室id
    private Integer labId;

    //轨迹信息产生前试剂处于的仓库id
    private Integer whId;

    //余量
    private Integer surplus;

    //创建时间
    private Date createAt;

    //关联静态资源id
    private Integer staticId;

    private String rfcode;

    //轨迹原由文本
    private String trajReason;

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

    public Integer getReagentId() {
        return reagentId;
    }

    public void setReagentId(Integer reagentId) {
        this.reagentId = reagentId;
    }

    public ChemReagentDTO getReagent() {
        return reagent;
    }

    public void setReagent(ChemReagentDTO reagent) {
        this.reagent = reagent;
    }

    public Short getReason() {
        return reason;
    }

    public void setReason(Short reason) {
        this.reason = reason;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getEquId() {
        return equId;
    }

    public void setEquId(Integer equId) {
        this.equId = equId;
    }

    public String getEquNo() {
        return equNo;
    }

    public void setEquNo(String equNo) {
        this.equNo = equNo;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public String getEquAddress() {
        return equAddress;
    }

    public void setEquAddress(String equAddress) {
        this.equAddress = equAddress;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
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

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public Integer getSurplus() {
        return surplus;
    }

    public void setSurplus(Integer surplus) {
        this.surplus = surplus;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getStaticId() {
        return staticId;
    }

    public void setStaticId(Integer staticId) {
        this.staticId = staticId;
    }

    public String getRfcode() {
        return rfcode;
    }

    public void setRfcode(String rfcode) {
        this.rfcode = rfcode;
    }

    public String getTrajReason() {
        return trajReason;
    }

    public void setTrajReason(String trajReason) {
        this.trajReason = trajReason;
    }
}
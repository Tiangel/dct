package yxinfo.dct.inteface.dto.chem.reagent.biz;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.GroupDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemUnitDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by dy on 2016/7/1.
 */
public class ChemRecycleExDTO extends BaseDTO {

    private static final long serialVersionUID = -5200227186422632222L;

    // 试剂名称
    private String chemName;

    // CAS号
    private String cas;

    // 纯度
    private String specName;

    // 容量
    private Integer capacity;

    // RFID码
    private String rfFcode;

    // 学生姓名
    private String memberName;

    // 学号
    private String memberCode;

    // 手机号
    private String memberMobile;

    // 课题名称
    private String issuesName;

    // 状态
    private String status;

    private Integer id;

    //回收者组织id
    private Integer orgId;

    //回收者成员id
    private Integer memberId;

    //回收试剂id
    private Integer reagentId;

    //创建时间
    private Date createAt;

    //确认回收时间
    private Date recycleAt;

    //属于的领取申请id
    private Integer arId;

    //用量
    private Integer used;

    //单位
    private ChemUnitDTO unit;

    //回收者院系班级
    private List<GroupDTO> groups;

    public String getChemName() {
        return chemName;
    }

    public void setChemName(String chemName) {
        this.chemName = chemName;
    }

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getRfFcode() {
        return rfFcode;
    }

    public void setRfFcode(String rfFcode) {
        this.rfFcode = rfFcode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    public String getIssuesName() {
        return issuesName;
    }

    public void setIssuesName(String issuesName) {
        this.issuesName = issuesName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getReagentId() {
        return reagentId;
    }

    public void setReagentId(Integer reagentId) {
        this.reagentId = reagentId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getRecycleAt() {
        return recycleAt;
    }

    public void setRecycleAt(Date recycleAt) {
        this.recycleAt = recycleAt;
    }

    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public ChemUnitDTO getUnit() {
        return unit;
    }

    public void setUnit(ChemUnitDTO unit) {
        this.unit = unit;
    }

    public List<GroupDTO> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupDTO> groups) {
        this.groups = groups;
    }
}

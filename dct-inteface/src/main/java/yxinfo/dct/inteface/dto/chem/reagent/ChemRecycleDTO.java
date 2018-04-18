package yxinfo.dct.inteface.dto.chem.reagent;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;

import java.util.Date;

/**
 * Created by dy on 2016/7/1.
 */
public class ChemRecycleDTO extends BaseDTO {

    private static final long serialVersionUID = -6208174297155644013L;

    private Integer id;

    //回收者组织id
    private Integer orgId;

    //回收者成员id
    private Integer memberId;
    private MemberDTO member;
    private String memberName;

    //回收试剂id
    private Integer reagentId;
    private ChemReagentDTO reagent;

    //创建时间
    private Date createAt;

    //确认回收时间
    private Date recycleAt;

    //用量
    private Integer used;

    //属于的领取申请id
    private Integer arId;

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

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
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

    public Integer getUsed() {
        return used;
    }

    public void setUsed(Integer used) {
        this.used = used;
    }

    public Integer getArId() {
        return arId;
    }

    public void setArId(Integer arId) {
        this.arId = arId;
    }
}

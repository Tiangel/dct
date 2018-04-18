package yxinfo.dct.inteface.dto.chem.apply;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;
import yxinfo.dct.inteface.validation.groups.chem.ReceiveListInIds;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 化学试剂领取记录DTO
 * Created by dy on 2016/6/21.
 */
public class ChemReceiveDTO extends BaseDTO {

    private static final long serialVersionUID = -2216996197271475578L;

    //id
    private Integer id;

    //领取组织id
    private Integer orgId;

    //领取成员id
    private Integer memberId;
    private String memberName;
    private MemberDTO member;

    //领取试剂id
    @NotNull( groups = ReceiveListInIds.class, message = ErrorCode.CHEM_REAGENT_ID_NOT_EMPTY )
    private Integer reagentId;
    private ChemReagentDTO reagent;

    //创建时间
    private Date createAt;

    //实际领取的量
    private Integer used;

    //属于的领取申请id
    @NotNull( groups = ReceiveListInIds.class, message = ErrorCode.CHEM_AR_ID_NOT_EMPTY )
    private Integer arId;
    private ChemApplyReceiveDTO applyReceive;

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

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
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

    public ChemApplyReceiveDTO getApplyReceive() {
        return applyReceive;
    }

    public void setApplyReceive(ChemApplyReceiveDTO applyReceive) {
        this.applyReceive = applyReceive;
    }
}

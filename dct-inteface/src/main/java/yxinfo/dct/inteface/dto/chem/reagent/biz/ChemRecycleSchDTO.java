package yxinfo.dct.inteface.dto.chem.reagent.biz;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.dto.chem.apply.ChemApplyReceiveDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;

import java.util.Date;

/**
 * Created by dy on 2016/7/8.
 */
public class ChemRecycleSchDTO extends BaseDTO {

    private static final long serialVersionUID = -7328814021146538856L;

    //回收记录id
    private Integer id;

    //回收者组织id
    private Integer orgId;

    //回收者成员
    private MemberDTO member;

    //回收试剂
    private ChemReagentDTO reagent;

    //申领记录
    private ChemApplyReceiveDTO applyReceive;


    private Date createAtFrom;
    private Date createAtTo;

    //回收时间范围, recycleAtFrom ~ recycleAtTo
    private Date recycleAtFrom;
    private Date recycleAtTo;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public ChemReagentDTO getReagent() {
        return reagent;
    }

    public void setReagent(ChemReagentDTO reagent) {
        this.reagent = reagent;
    }

    public ChemApplyReceiveDTO getApplyReceive() {
        return applyReceive;
    }

    public void setApplyReceive(ChemApplyReceiveDTO applyReceive) {
        this.applyReceive = applyReceive;
    }

    public Date getCreateAtFrom() {
        return createAtFrom;
    }

    public void setCreateAtFrom(Date createAtFrom) {
        this.createAtFrom = createAtFrom;
    }

    public Date getCreateAtTo() {
        return createAtTo;
    }

    public void setCreateAtTo(Date createAtTo) {
        this.createAtTo = createAtTo;
    }

    public Date getRecycleAtFrom() {
        return recycleAtFrom;
    }

    public void setRecycleAtFrom(Date recycleAtFrom) {
        this.recycleAtFrom = recycleAtFrom;
    }

    public Date getRecycleAtTo() {
        return recycleAtTo;
    }

    public void setRecycleAtTo(Date recycleAtTo) {
        this.recycleAtTo = recycleAtTo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

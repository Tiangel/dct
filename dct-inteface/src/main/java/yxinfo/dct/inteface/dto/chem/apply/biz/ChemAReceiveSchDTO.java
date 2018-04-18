package yxinfo.dct.inteface.dto.chem.apply.biz;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.dto.chem.apply.ChemApplyReceiveDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;

import java.util.Date;
import java.util.List;

/**
 * 化学品领取申请搜索DTO
 * Created by dy on 2016/6/23.
 */
public class ChemAReceiveSchDTO extends BaseDTO {

    private static final long serialVersionUID = 6107007753580960978L;

    // 化学品领取申请
    private ChemApplyReceiveDTO applyReceive;

    // 申请人
    private MemberDTO member;

    // 领用时间范围, appointAtFrom ~ appointAtTo
    private Date appointAtFrom;
    private Date appointAtTo;

    // 申领的化学试剂
    private ChemReagentDTO reagent;

    // 申领id列表
    private List<Integer> arIds;

    public ChemApplyReceiveDTO getApplyReceive() {
        return applyReceive;
    }

    public void setApplyReceive(ChemApplyReceiveDTO applyReceive) {
        this.applyReceive = applyReceive;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    public Date getAppointAtFrom() {
        return appointAtFrom;
    }

    public void setAppointAtFrom(Date appointAtFrom) {
        this.appointAtFrom = appointAtFrom;
    }

    public Date getAppointAtTo() {
        return appointAtTo;
    }

    public void setAppointAtTo(Date appointAtTo) {
        this.appointAtTo = appointAtTo;
    }

    public ChemReagentDTO getReagent() {
        return reagent;
    }

    public void setReagent(ChemReagentDTO reagent) {
        this.reagent = reagent;
    }

    public List<Integer> getArIds() {
        return arIds;
    }

    public void setArIds(List<Integer> arIds) {
        this.arIds = arIds;
    }
}

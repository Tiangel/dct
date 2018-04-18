package yxinfo.dct.inteface.dto.chem.apply;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.validation.groups.PageSelect;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;
import java.util.Date;
import java.util.List;

/**
 * 化学试剂领取申请DTO
 * Created by dy on 2016/6/21.
 */
public class ChemApplyReceiveDTO extends BaseDTO {

    private static final long serialVersionUID = -3478846019398391760L;

    //领取申请id
    private Integer id;

    //领取申请唯一编号
    private String fcode;

    //申请人id
    @NotNull( groups = { Default.class, PageSelect.class },
            message = ErrorCode.CHEM_APLY_MEMBER_ID_NOT_EMPTY )
    private Integer memberId;
    private MemberDTO member;

    //申请人组织id
    @NotNull( groups = { Default.class, PageSelect.class },
            message = ErrorCode.CHEM_APLY_ORG_ID_NOT_EMPTY )
    private Integer orgId;

    //试剂用于课题名称
    @Length( max = 30, message = ErrorCode.CHEM_APLY_ISSUESNAME_LENGTH )
    private String issuesName;

    //用途（1教学, 2科研）
    @Length( max = 1, message = ErrorCode.CHEM_APLY_PURPOSE_LENGTH )
    private String purpose;

    //项目id
    private Integer proId;

    //备注（企业版用途）
    private String remark;

    //创建时间
    private Date createAt;

    //领取状态（1不可领/审核中, 2待领用, 3已领完, 4已驳回, 5已逾期）
    private String receiveSta;

    //预约领取时间
    @NotNull( message = ErrorCode.CHEM_APLY_APPOINT_AT_NOT_EMPTY )
    private Date appointAt;

    //申请领取的化学试剂列表
    @NotEmpty( message = ErrorCode.CHEM_APLY_REAGENTS_NOT_EMPTY )
    @Valid
    private List<ChemApplyReagentDTO> applyReagentList;

    //下一步审核人id
    private Integer approveMemberId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
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

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getIssuesName() {
        return issuesName;
    }

    public void setIssuesName(String issuesName) {
        this.issuesName = issuesName;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getReceiveSta() {
        return receiveSta;
    }

    public void setReceiveSta(String receiveSta) {
        this.receiveSta = receiveSta;
    }

    public Date getAppointAt() {
        return appointAt;
    }

    public void setAppointAt(Date appointAt) {
        this.appointAt = appointAt;
    }

    public List<ChemApplyReagentDTO> getApplyReagentList() {
        return applyReagentList;
    }

    public void setApplyReagentList(List<ChemApplyReagentDTO> applyReagentList) {
        this.applyReagentList = applyReagentList;
    }

    public Integer getApproveMemberId() {
        return approveMemberId;
    }

    public void setApproveMemberId(Integer approveMemberId) {
        this.approveMemberId = approveMemberId;
    }
}

package yxinfo.dct.inteface.dto.inst;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.approve.ApproveNodeDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Select;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by sxd on 2016/7/14.
 */
public class InstBespeakDTO extends BaseDTO {

    private static final long serialVersionUID = -655169275250126762L;
    //预约id
    private Integer id;
    //组织id
    @NotNull(groups = {Add.class, Select.class}, message = ErrorCode.ORG_ID_NOT_NULL)
    private Integer orgId;

    //预约成员id
    @NotNull(groups = {Add.class}, message = ErrorCode.MEMBER_ID_NOT_EMPTY)
    private Integer memberId;

    //预约项目id
    @NotNull(groups = Add.class, message = ErrorCode.INST_BESPEAK_PROID_NOT_EMPTY)
    private Integer proId;
    //项目名称
    private String proName;
    //用途
    @NotNull(groups = Add.class, message = ErrorCode.INST_BESPEAK_USE_NOT_EMPTY)
    private String fuse;

    //预约使用起始时间
    @NotNull(groups = Add.class, message = ErrorCode.INST_BESPEAK_STARTTIME_NOT_EMPTY)
    private Date startTime;

    //预约使用结束时间
    @NotNull(groups = Add.class, message = ErrorCode.INST_BESPEAK_ENDTIME_NOT_EMPTY)
    private Date endTime;
    //编号
    private String fcode;

    //状态（o审核中，s待使用，f已驳回，e已使用）
    private String status;
    private String statusName;
    //生成时间
    private Date createAt;
    //进入仪器预约，显示预约列表时，只显示第一个仪器名称
    private String firstInstName;
    //预约中的仪器数量是否大于1
    private Boolean moreThanOne;
    //预约仪器list
    private List<BespeakInstDTO> instList;
    //仪器list
    private List<InstrumentDTO> instrumentList;

    private MemberDTO member;
    //操作是否成功
    private Boolean success;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    //操作错误信息
    private String errorMsg;

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

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getFuse() {
        return fuse;
    }

    public void setFuse(String fuse) {
        this.fuse = fuse;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getFirstInstName() {
        return firstInstName;
    }

    public void setFirstInstName(String firstInstName) {
        this.firstInstName = firstInstName;
    }

    public Boolean getMoreThanOne() {
        return moreThanOne;
    }

    public void setMoreThanOne(Boolean moreThanOne) {
        this.moreThanOne = moreThanOne;
    }

    public List<BespeakInstDTO> getInstList() {
        return instList;
    }

    public void setInstList(List<BespeakInstDTO> instList) {
        this.instList = instList;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public List<InstrumentDTO> getInstrumentList() {
        return instrumentList;
    }

    public void setInstrumentList(List<InstrumentDTO> instrumentList) {
        this.instrumentList = instrumentList;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public MemberDTO getMember() {
        return member;
    }

    public void setMember(MemberDTO member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "InstBespeakDTO{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", memberId=" + memberId +
                ", proId=" + proId +
                ", proName='" + proName + '\'' +
                ", fuse='" + fuse + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", fcode='" + fcode + '\'' +
                ", status='" + status + '\'' +
                ", createAt=" + createAt +
                ", firstInstName='" + firstInstName + '\'' +
                ", moreThanOne=" + moreThanOne +
                ", instList=" + instList +
                ", instrumentList=" + instrumentList +
                ", success=" + success +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
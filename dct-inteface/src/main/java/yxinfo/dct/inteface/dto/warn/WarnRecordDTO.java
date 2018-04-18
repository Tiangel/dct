package yxinfo.dct.inteface.dto.warn;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by ZH on 2016/7/20.
 */
public class WarnRecordDTO extends BaseDTO{
    private Integer id;

    //组织id
    private Integer orgId;

    //预警内容
    private String fcontext;

    //预警项目编号，<FK>warn_item.item_no
    private String itemNo;

    //状态（1待处理，2关闭，3搁置）
    private String status;

    //关联的信息记录标识
    private String relMsgId;

    //额外信息
    private String extraMsg;

    //预警时间
    private Date createAt;

    //搁置开始时间
    private Date shelveAt;

    //搁置时间（秒）
    private Integer shelveTime;
    //试剂id
    private Integer reagentId;

    private WarnRecordLogDTO warnRecordLogDTO;

    public WarnRecordDTO() {
    }

    public WarnRecordDTO(Integer id, Integer orgId, String fcontext, String itemNo, String status, String relMsgId, String extraMsg, Date createAt, Date shelveAt, Integer shelveTime, WarnRecordLogDTO warnRecordLogDTO) {
        this.id = id;
        this.orgId = orgId;
        this.fcontext = fcontext;
        this.itemNo = itemNo;
        this.status = status;
        this.relMsgId = relMsgId;
        this.extraMsg = extraMsg;
        this.createAt = createAt;
        this.shelveAt = shelveAt;
        this.shelveTime = shelveTime;
        this.warnRecordLogDTO = warnRecordLogDTO;
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

    public String getFcontext() {
        return fcontext;
    }

    public void setFcontext(String fcontext) {
        this.fcontext = fcontext;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRelMsgId() {
        return relMsgId;
    }

    public void setRelMsgId(String relMsgId) {
        this.relMsgId = relMsgId;
    }

    public String getExtraMsg() {
        return extraMsg;
    }

    public void setExtraMsg(String extraMsg) {
        this.extraMsg = extraMsg;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getShelveAt() {
        return shelveAt;
    }

    public void setShelveAt(Date shelveAt) {
        this.shelveAt = shelveAt;
    }

    public Integer getShelveTime() {
        return shelveTime;
    }

    public void setShelveTime(Integer shelveTime) {
        this.shelveTime = shelveTime;
    }

    public Integer getReagentId() {
        return reagentId;
    }

    public void setReagentId(Integer reagentId) {
        this.reagentId = reagentId;
    }

    public WarnRecordLogDTO getWarnRecordLogDTO() {
        return warnRecordLogDTO;
    }

    public void setWarnRecordLogDTO(WarnRecordLogDTO warnRecordLogDTO) {
        this.warnRecordLogDTO = warnRecordLogDTO;
    }

    @Override
    public String toString() {
        return "WarnRecordDTO{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", fcontext='" + fcontext + '\'' +
                ", itemNo='" + itemNo + '\'' +
                ", status='" + status + '\'' +
                ", relMsgId='" + relMsgId + '\'' +
                ", extraMsg='" + extraMsg + '\'' +
                ", createAt=" + createAt +
                ", shelveAt=" + shelveAt +
                ", shelveTime=" + shelveTime +
                ", reagentId=" + reagentId +
                ", warnRecordLogDTO=" + warnRecordLogDTO +
                '}';
    }
}

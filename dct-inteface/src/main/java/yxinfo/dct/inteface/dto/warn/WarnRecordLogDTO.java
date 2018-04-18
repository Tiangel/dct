package yxinfo.dct.inteface.dto.warn;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;

import java.util.Date;

/**
 * Created by ZH on 2016/7/20.
 */
public class WarnRecordLogDTO extends BaseDTO {
    private Integer id;

    //预警记录id，<FK>warn_record.id
    private Integer recordId;

    //类型（2关闭，3搁置）
    private String ftype;

    //搁置开始时间
    private Date shelveAt;

    //搁置时间（秒）
    private Integer shelveTime;

    //处理记录
    private String note;

    //处理人成员id
    private Integer memberId;

    //创建时间
    private Date createAt;

    private MemberDTO memberDTO;

    public WarnRecordLogDTO() {
    }

    public WarnRecordLogDTO(Integer id, Integer recordId, String ftype, Date shelveAt, Integer shelveTime, String note, Integer memberId, Date createAt, MemberDTO memberDTO) {
        this.id = id;
        this.recordId = recordId;
        this.ftype = ftype;
        this.shelveAt = shelveAt;
        this.shelveTime = shelveTime;
        this.note = note;
        this.memberId = memberId;
        this.createAt = createAt;
        this.memberDTO = memberDTO;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }
}

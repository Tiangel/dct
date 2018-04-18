package yxinfo.dct.inteface.dto.lab;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * 实验室负责人bean
 *
 * Created by cy on 2016/6/20.
 */
public class LabManagerDTO extends BaseDTO {

    /**
     * 实验室负责人表id  sql_column:id
     */
    private Integer labManagerId;

    /**
     * 实验室id  sql_column:lab_id
     */
    private Integer labId;

    /**
     * 成员id  sql_column:member_id
     */
    @Digits( integer = 10, fraction = 0, message = ErrorCode.LAB_LABMEMBERID_LENGTH)
    @NotNull( message = ErrorCode.LAB_LABMEMBERID_NOTNULL )
    private Integer memberId;

    /**
     * 联系电话  sql_column:phone
     */
    @Length( max = 20, message = ErrorCode.LAB_LABMEPHONE_LENGTH )
/*    @NotEmpty(message = ErrorCode.LAB_LABMEPHONE_NOTNULL )*/
    private String phone;

    /**
     * 类型（1负责人, 2安全员, 3技术人员） sql_column:ftype
     */
    @Length( max = 1, message = ErrorCode.LAB_FTYPE_LENGTH )
    private String ftype;

    /**
     * 成员名
     */
    private String memberName;

    /**
     * 成员member
     */
    private MemberDTO memberDTO;

    public LabManagerDTO() {
    }

    public LabManagerDTO(Integer labManagerId, Integer labId, Integer memberId, String phone, String ftype, String memberName, MemberDTO memberDTO) {
        this.labManagerId = labManagerId;
        this.labId = labId;
        this.memberId = memberId;
        this.phone = phone;
        this.ftype = ftype;
        this.memberName = memberName;
        this.memberDTO = memberDTO;
    }

    public Integer getLabManagerId() {
        return labManagerId;
    }

    public void setLabManagerId(Integer labManagerId) {
        this.labManagerId = labManagerId;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public MemberDTO getMemberDTO() {
        return memberDTO;
    }

    public void setMemberDTO(MemberDTO memberDTO) {
        this.memberDTO = memberDTO;
    }

    @Override
    public String toString() {
        return "LabManagerDTO{" +
                "labManagerId=" + labManagerId +
                ", labId=" + labId +
                ", memberId=" + memberId +
                ", phone='" + phone + '\'' +
                ", ftype='" + ftype + '\'' +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}

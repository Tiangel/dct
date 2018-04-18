package yxinfo.dct.inteface.dto.wh;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

/**
 * 仓库管理人bean
 * <p>
 * Created by cy on 2016/6/23.
 */
public class WhManagerDTO extends BaseDTO {

    private Integer id;

    /**
     * 仓库id
     */
    private Integer whId;

    /**
     * 人员id
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.WH_MEMBERID_LENGTH)
    @NotNull(message = ErrorCode.WH_MEMBERID_NOTNULL)
    private Integer memberId;

    /**
     * 成员名称
     */
    private String memberName;

    public WhManagerDTO() {
    }

    public WhManagerDTO(Integer id, Integer whId, Integer memberId, String memberName) {
        this.id = id;
        this.whId = whId;
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
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

    @Override
    public String toString() {
        return "WhManagerDTO{" +
                "id=" + id +
                ", whId=" + whId +
                ", memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                '}';
    }
}

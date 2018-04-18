package yxinfo.dct.inteface.dto.evt;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Select;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class EvtRedPointDTO extends BaseDTO {

    private static final long serialVersionUID = -3672457491165666966L;

    //成员id
    @NotNull( groups = { Update.class, Select.class },
            message = ErrorCode.MEMBER_ID_NOT_EMPTY )
    private Integer memberId;

    //组织id
    @NotNull( groups = { Update.class, Select.class },
            message = ErrorCode.ORG_ID_NOT_NULL )
    private Integer orgId;

    //数量
    @NotNull( groups = Update.class,
            message = ErrorCode.EVT_NUM_NOT_EMPTY )
    private Integer num;

    //项目编号
    @NotEmpty( groups = { Update.class, Select.class },
            message = ErrorCode.EVT_ITEM_NO_NOT_EMPTY )
    private String itemNo;

    //更新时间
    private Date updateAt;

    public EvtRedPointDTO() {}

    public EvtRedPointDTO(Integer memberId, Integer orgId, String itemNo) {
        this.memberId = memberId;
        this.orgId = orgId;
        this.itemNo = itemNo;
    }

    public EvtRedPointDTO(Integer memberId, Integer orgId, String itemNo,Integer num) {
        this.memberId = memberId;
        this.orgId = orgId;
        this.itemNo = itemNo;
        this.num = num;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
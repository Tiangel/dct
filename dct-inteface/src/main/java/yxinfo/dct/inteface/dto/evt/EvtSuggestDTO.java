package yxinfo.dct.inteface.dto.evt;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class EvtSuggestDTO extends BaseDTO {

    private static final long serialVersionUID = -1220642430207689328L;

    private Integer id;

    //内容
    @NotEmpty( groups = Add.class,
            message = ErrorCode.EVT_SUGGEST_CONTEXT_NOT_EMPTY )
    @Length( groups = Add.class, max = 2000,
            message = ErrorCode.EVT_SUGGEST_CONTEXT_LENGTH )
    private String fcontext;

    //成员id
    @NotNull( groups = Add.class,
            message = ErrorCode.MEMBER_ID_NOT_EMPTY )
    private Integer memberId;

    //组织id
    @NotNull( groups = Add.class,
            message = ErrorCode.ORG_ID_NOT_NULL )
    private Integer orgId;

    //类型（1APP）
    @NotEmpty( groups = Add.class,
            message = ErrorCode.EVT_SUGGEST_TYPE_NOT_EMPTY )
    private String ftype;

    private Date createAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFcontext() {
        return fcontext;
    }

    public void setFcontext(String fcontext) {
        this.fcontext = fcontext;
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

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
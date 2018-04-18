package yxinfo.dct.inteface.dto.evt;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author sxd
 * @date 2016/8/10 14:51
 */
public class EvtNoticeDTO extends BaseDTO {

    private Integer id;

    @NotNull(groups = Add.class, message = ErrorCode.ORG_ID_NOT_NULL)
    private Integer orgId;

    //公告项目
    private String itemNo;

    //标题
    private String title;

    //内容
    @NotEmpty(groups = Add.class, message = ErrorCode.EVT_NOTICE_CONTENT_NOT_EMPTY)
    private String content;

    private Date createAt;

    //创建者成员id
    @NotNull(groups = Add.class, message = ErrorCode.MEMBER_ID_NOT_EMPTY)
    private Integer memberId;
    private MemberDTO member;

    //是否显示
    private Boolean isShow;

    //是否删除
    private Boolean isDel;

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

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
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

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }
}

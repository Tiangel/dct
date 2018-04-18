package yxinfo.dct.inteface.dto.warn;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author lovetcat
 * @date 2016/8/4 11:24
 */
public class WarnPersonDTO extends BaseDTO {

    private static final long serialVersionUID = 8454094409954061348L;

    private Integer id;

    //组织id
    @NotNull(groups = Add.class, message = ErrorCode.ORG_ID_NOT_NULL)
    private Integer orgId;

    //姓名
    @NotEmpty(groups = Add.class, message = ErrorCode.NAME_NOT_EMPTY)
    private String fname;

    //手机号
    @NotEmpty(groups = Add.class, message = ErrorCode.MOBILE_NOT_EMPTY)
    private String mobile;

    //邮箱
    private String email;

    //成员id
    private Integer memberId;

    //微信OPENID
    private String wxOpenId;

    private Date createAt;

    private Date updateAt;

    private List<WarnPersonItemDTO> warnPersonItemDTOList;

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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getWxOpenId() {
        return wxOpenId;
    }

    public void setWxOpenId(String wxOpenId) {
        this.wxOpenId = wxOpenId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public List<WarnPersonItemDTO> getWarnPersonItemDTOList() {
        return warnPersonItemDTOList;
    }

    public void setWarnPersonItemDTOList(List<WarnPersonItemDTO> warnPersonItemDTOList) {
        this.warnPersonItemDTOList = warnPersonItemDTOList;
    }

    @Override
    public String toString() {
        return "WarnPersonDTO{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", fname='" + fname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", memberId=" + memberId +
                ", wxOpenId='" + wxOpenId + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", warnPersonItemDTOList=" + warnPersonItemDTOList +
                '}';
    }
}

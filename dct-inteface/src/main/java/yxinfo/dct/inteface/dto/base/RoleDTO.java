package yxinfo.dct.inteface.dto.base;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by hanley on 2016/6/25.
 */
public class RoleDTO extends BaseDTO {

    private static final long serialVersionUID = -330804204873755137L;

    @NotNull ( groups = Update.class )
    private Integer id;

    //名称
    @NotEmpty ( groups = Add.class, message = ErrorCode.NAME_NOT_EMPTY )
    private String fname;

    //备注
    private String remark;

    //所属组织id
    @NotNull ( groups = Add.class, message = ErrorCode.ORG_ID_NOT_NULL )
    private Integer orgId;

    //创建时间
    private Date createAt;

    //更新时间
    private Date updateAt;

    //是否被删除（1是, 0否）
    private Boolean isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
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

    public Boolean getDel() {
        return isDel;
    }

    public void setDel(Boolean del) {
        isDel = del;
    }

    @Override
    public String toString() {
        return "RoleDTO{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", remark='" + remark + '\'' +
                ", orgId=" + orgId +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", isDel=" + isDel +
                '}';
    }
}

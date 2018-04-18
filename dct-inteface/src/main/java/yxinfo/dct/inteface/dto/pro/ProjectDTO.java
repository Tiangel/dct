package yxinfo.dct.inteface.dto.pro;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by sxd on 2016/7/14.
 */
public class ProjectDTO extends BaseDTO {

    private static final long serialVersionUID = -3607896107649382055L;

    private Integer id;

    //项目名称
    @NotEmpty(groups = Add.class, message = ErrorCode.PRO_FNAME_NOT_EMPTY)
    private String fname;

    //项目名称全拼和简拼
    private String pyinName;

    //所属组织id
    @NotNull(groups = Add.class, message = ErrorCode.ORG_ID_NOT_NULL)
    private Integer orgId;


    //状态（1进行中, 2已结束）
    private String status;

    //创建时间
    private Date createAt;

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

    public String getPyinName() {
        return pyinName;
    }

    public void setPyinName(String pyinName) {
        this.pyinName = pyinName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", pyinName='" + pyinName + '\'' +
                ", orgId=" + orgId +
                ", createAt=" + createAt +
                '}';
    }
}

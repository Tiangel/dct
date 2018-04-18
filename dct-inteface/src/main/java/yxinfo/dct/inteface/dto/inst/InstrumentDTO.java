package yxinfo.dct.inteface.dto.inst;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by sxd on 2016/7/14.
 */
public class InstrumentDTO extends BaseDTO {
    private static final long serialVersionUID = -7173920823293432070L;

    private Integer id;

    //仪器所属组织id
    @NotNull(groups = Add.class, message = ErrorCode.ORG_ID_NOT_NULL)
    private Integer orgId;

    //实验室id
    private Integer labId;

    //仪器名称
    @NotEmpty(groups = Add.class, message = ErrorCode.INST_FNAME_NOT_EMPTY)
    private String fname;

    //仪器名称全拼和简拼
    private String pyinName;

    //名称长度
    private Integer nameLen;

    //状态（1正常, 2损坏）
    private String status;

    //创建时间
    private Date createAt;

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

    public String getPyinName() {
        return pyinName;
    }

    public void setPyinName(String pyinName) {
        this.pyinName = pyinName;
    }

    public Integer getNameLen() {
        return nameLen;
    }

    public void setNameLen(Integer nameLen) {
        this.nameLen = nameLen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    @Override
    public String toString() {
        return "InstrumentDTO{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", labId=" + labId +
                ", fname='" + fname + '\'' +
                ", pyinName='" + pyinName + '\'' +
                ", nameLen=" + nameLen +
                ", status='" + status + '\'' +
                ", createAt=" + createAt +
                '}';
    }
}

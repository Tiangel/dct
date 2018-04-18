package yxinfo.dct.inteface.dto.base;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by hanley on 2016/6/21.
 */
public class GroupDTO extends BaseDTO {

    private static final long serialVersionUID = 6627594483227436116L;

    @NotNull( groups = { Update.class } )
    private Integer id;

    //名称
    @NotEmpty( groups = { Add.class } )
    private String fname;

    //成员组编号
    private String fcode;

    private String remark;

    //所属组织
    @NotNull( groups = { Add.class } )
    private Integer orgId;

    //父成员组id
    private Integer pid;

    //创建时间
    private Date createAt;

    //更新时间
    private Date updateAt;

    //是否被删除（1是, 0否）
    private Boolean isDel;

    //排序
    private Integer sort;

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

    public String getFcode() {
        return fcode;
    }

    public void setFcode( String fcode ) {
        this.fcode = fcode;
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean del) {
        isDel = del;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}

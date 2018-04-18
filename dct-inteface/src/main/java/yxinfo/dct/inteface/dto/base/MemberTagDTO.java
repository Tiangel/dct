package yxinfo.dct.inteface.dto.base;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.Date;

/**
 * Created by hanley on 2016/6/28.
 */
public class MemberTagDTO extends BaseDTO {

    private static final long serialVersionUID = -8938735415916580245L;

    private Integer id;

    //标签名称
    private String tag;

    //组织id
    private Integer orgId;

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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}

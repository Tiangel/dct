package yxinfo.dct.inteface.dto.base;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by hanley on 2016/6/21.
 */
public class OrgDTO extends BaseDTO {

    private static final long serialVersionUID = -7945067120220142881L;

    @NotNull( groups = Update.class, message = ErrorCode.ORG_ID_NOT_NULL )
    private Integer id;

    //组织编号
    @NotEmpty( groups = { Add.class, Update.class }, message = ErrorCode.ORG_NAME_NOT_EMPTY )
    private String fcode;

    //名称
    @NotEmpty( groups = { Add.class, Update.class }, message = ErrorCode.ORG_NAME_NOT_EMPTY )
    private String fname;

    //地址
    @NotEmpty
    private String address;

    //上级组织
    private Integer pid;

    //创建时间
    private Date createAt;

    //更新时间
    private Date updateAt;

    //是否被删除（1是, 0否）
    private Boolean isDel;

    //组织定制信息
    private SysOrgCustomizedDTO customized;

    //用户用户组
    private List<Integer> groupIds;

    //用户角色
    private List<Integer> roleIds;

    //用户标签
    private List<Integer> tagIds;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode( String fcode ) {
        this.fcode = fcode;
    }

    public String getFname() {
        return fname;
    }

    public void setFname( String fname ) {
        this.fname = fname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid( Integer pid ) {
        this.pid = pid;
    }


    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt( Date updateAt ) {
        this.updateAt = updateAt;
    }

    public Boolean getDel() {
        return isDel;
    }

    public void setDel( Boolean del ) {
        isDel = del;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt( Date createAt ) {
        this.createAt = createAt;
    }

    public SysOrgCustomizedDTO getCustomized() {
        return customized;
    }

    public void setCustomized( SysOrgCustomizedDTO customized ) {
        this.customized = customized;
    }

    public List<Integer> getGroupIds() {
        return groupIds;
    }

    public void setGroupIds( List<Integer> groupIds ) {
        this.groupIds = groupIds;
    }

    public List<Integer> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds( List<Integer> roleIds ) {
        this.roleIds = roleIds;
    }

    public List<Integer> getTagIds() {
        return tagIds;
    }

    public void setTagIds( List<Integer> tagIds ) {
        this.tagIds = tagIds;
    }
}

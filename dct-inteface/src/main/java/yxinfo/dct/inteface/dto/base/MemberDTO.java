package yxinfo.dct.inteface.dto.base;


import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Update;
import yxinfo.dct.inteface.validation.groups.base.Register;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by hanley on 2016/6/15.
 */
public class MemberDTO extends BaseDTO {

    private static final long serialVersionUID = -1026121611978762042L;

    @NotNull( groups = Update.class, message = ErrorCode.MEMBER_ID_NOT_EMPTY )
    private Integer id;

    // 登录名
    @NotEmpty( groups = Register.class, message = ErrorCode.USER_NOT_FOUND )
    private String loginName;

    // 密码
    @NotEmpty( groups = Register.class, message = ErrorCode.PWD_NOT_EMPTY )
    private String pwd;

    // 真实姓名
    @NotEmpty( groups = Register.class, message = ErrorCode.REAL_NAME_NOT_EMPTY )
    private String realName;

    // 昵称
    private String nickName;

    // 人员编号
    private String fcode;

    // 手机号
    private String mobile;

    // 头像
    private Integer head;

    // 创建时间
    private Date createAt;

    // 更新时间
    private Date updateAt;

    // 是否被删除
    private Boolean isDel;

    // 密码输入错误次数
    private Integer pwdErrcount;

    // 密码输入错误时间
    private Date pwdErrAt;

    // 排序
    private Integer sort;

    // ========================== ↓扩展信息↓ ==========================
    // 组织id
    private Integer orgId;

    // 用户组id
    private Integer groupId;

    // 角色id
    private Integer roleId;

    // 标签id
    private Integer tagId;

    // 登录设备终端类型
    private String loginDev;

    // 用户accessToken
    private AccessTokenDTO accessToken;

    // 用户组织
    private List<OrgDTO> orgs;

    // 用户组
    private List<GroupDTO> groups;

    // 用户角色
    private List<RoleDTO> roles;

    // 用户标签
    private List<MemberTagDTO> tags;

    public Integer getId() {
        return id;
    }

    public void setId( Integer id ) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName( String loginName ) {
        this.loginName = loginName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd( String pwd ) {
        this.pwd = pwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName( String realName ) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName( String nickName ) {
        this.nickName = nickName;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode( String fcode ) {
        this.fcode = fcode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile( String mobile ) {
        this.mobile = mobile;
    }

    public Integer getHead() {
        return head;
    }

    public void setHead( Integer head ) {
        this.head = head;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt( Date createAt ) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt( Date updateAt ) {
        this.updateAt = updateAt;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel( Boolean del ) {
        isDel = del;
    }

    public Integer getPwdErrcount() {
        return pwdErrcount;
    }

    public void setPwdErrcount( Integer pwdErrcount ) {
        this.pwdErrcount = pwdErrcount;
    }

    public Date getPwdErrAt() {
        return pwdErrAt;
    }

    public void setPwdErrAt( Date pwdErrAt ) {
        this.pwdErrAt = pwdErrAt;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort( Integer sort ) {
        this.sort = sort;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId( Integer orgId ) {
        this.orgId = orgId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId( Integer groupId ) {
        this.groupId = groupId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId( Integer roleId ) {
        this.roleId = roleId;
    }

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId( Integer tagId ) {
        this.tagId = tagId;
    }

    public String getLoginDev() {
        return loginDev;
    }

    public void setLoginDev( String loginDev ) {
        this.loginDev = loginDev;
    }

    public AccessTokenDTO getAccessToken() {
        return accessToken;
    }

    public void setAccessToken( AccessTokenDTO accessToken ) {
        this.accessToken = accessToken;
    }

    public List<OrgDTO> getOrgs() {
        return orgs;
    }

    public void setOrgs( List<OrgDTO> orgs ) {
        this.orgs = orgs;
    }

    public List<GroupDTO> getGroups() {
        return groups;
    }

    public void setGroups( List<GroupDTO> groups ) {
        this.groups = groups;
    }

    public List<RoleDTO> getRoles() {
        return roles;
    }

    public void setRoles( List<RoleDTO> roles ) {
        this.roles = roles;
    }

    public List<MemberTagDTO> getTags() {
        return tags;
    }

    public void setTags( List<MemberTagDTO> tags ) {
        this.tags = tags;
    }
}

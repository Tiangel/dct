package yxinfo.dct.inteface.dto.base;

import yxinfo.dct.inteface.dto.BaseDTO;

public class SysMbrInputDTO extends BaseDTO {

    private static final long serialVersionUID = 2935621749720708950L;

    private Integer id;

    // 登录名
    private String loginName;

    // 人员编号
    private String fcode;

    // 真实姓名
    private String realName;

    // 组织id
    private Integer orgId;

    // 录入的用户组
    private String groups;

    // 录入的角色
    private String roles;

    // 录入的标签
    private String tags;

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

    public String getFcode() {
        return fcode;
    }

    public void setFcode( String fcode ) {
        this.fcode = fcode;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName( String realName ) {
        this.realName = realName;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId( Integer orgId ) {
        this.orgId = orgId;
    }

    public String getGroups() {
        return groups;
    }

    public void setGroups( String groups ) {
        this.groups = groups;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles( String roles ) {
        this.roles = roles;
    }

    public String getTags() {
        return tags;
    }

    public void setTags( String tags ) {
        this.tags = tags;
    }
}
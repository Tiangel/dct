package yxinfo.dct.service.base.dao.model;

import java.util.Date;

public class SysMember {
    private Integer id;

    //登录名
    private String loginName;

    //登录密码
    private String pwd;

    //人员编号
    private String fcode;

    //真实姓名
    private String realName;

    //真实姓名拼音
    private String pyinName;

    //昵称
    private String nickName;

    //手机号码
    private String mobile;

    //头像id
    private Integer head;

    //创建时间
    private Date createAt;

    //更新时间
    private Date updateAt;

    //是否被删除（1是, 0否）
    private Boolean isDel;

    //密码输入错误次数
    private Integer pwdErrcount;

    //密码输入错误时间
    private Date pwdErrAt;

    //排序
    private Integer sort;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.id
     *
     * @return the value of sys_member.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.id
     *
     * @param id the value for sys_member.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.login_name
     *
     * @return the value of sys_member.login_name
     *
     * @mbggenerated
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.login_name
     *
     * @param loginName the value for sys_member.login_name
     *
     * @mbggenerated
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.pwd
     *
     * @return the value of sys_member.pwd
     *
     * @mbggenerated
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.pwd
     *
     * @param pwd the value for sys_member.pwd
     *
     * @mbggenerated
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.fcode
     *
     * @return the value of sys_member.fcode
     *
     * @mbggenerated
     */
    public String getFcode() {
        return fcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.fcode
     *
     * @param fcode the value for sys_member.fcode
     *
     * @mbggenerated
     */
    public void setFcode(String fcode) {
        this.fcode = fcode == null ? null : fcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.real_name
     *
     * @return the value of sys_member.real_name
     *
     * @mbggenerated
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.real_name
     *
     * @param realName the value for sys_member.real_name
     *
     * @mbggenerated
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.pyin_name
     *
     * @return the value of sys_member.pyin_name
     *
     * @mbggenerated
     */
    public String getPyinName() {
        return pyinName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.pyin_name
     *
     * @param pyinName the value for sys_member.pyin_name
     *
     * @mbggenerated
     */
    public void setPyinName(String pyinName) {
        this.pyinName = pyinName == null ? null : pyinName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.nick_name
     *
     * @return the value of sys_member.nick_name
     *
     * @mbggenerated
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.nick_name
     *
     * @param nickName the value for sys_member.nick_name
     *
     * @mbggenerated
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.mobile
     *
     * @return the value of sys_member.mobile
     *
     * @mbggenerated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.mobile
     *
     * @param mobile the value for sys_member.mobile
     *
     * @mbggenerated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.head
     *
     * @return the value of sys_member.head
     *
     * @mbggenerated
     */
    public Integer getHead() {
        return head;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.head
     *
     * @param head the value for sys_member.head
     *
     * @mbggenerated
     */
    public void setHead(Integer head) {
        this.head = head;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.create_at
     *
     * @return the value of sys_member.create_at
     *
     * @mbggenerated
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.create_at
     *
     * @param createAt the value for sys_member.create_at
     *
     * @mbggenerated
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.update_at
     *
     * @return the value of sys_member.update_at
     *
     * @mbggenerated
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.update_at
     *
     * @param updateAt the value for sys_member.update_at
     *
     * @mbggenerated
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.is_del
     *
     * @return the value of sys_member.is_del
     *
     * @mbggenerated
     */
    public Boolean getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.is_del
     *
     * @param isDel the value for sys_member.is_del
     *
     * @mbggenerated
     */
    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.pwd_errcount
     *
     * @return the value of sys_member.pwd_errcount
     *
     * @mbggenerated
     */
    public Integer getPwdErrcount() {
        return pwdErrcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.pwd_errcount
     *
     * @param pwdErrcount the value for sys_member.pwd_errcount
     *
     * @mbggenerated
     */
    public void setPwdErrcount(Integer pwdErrcount) {
        this.pwdErrcount = pwdErrcount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.pwd_err_at
     *
     * @return the value of sys_member.pwd_err_at
     *
     * @mbggenerated
     */
    public Date getPwdErrAt() {
        return pwdErrAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.pwd_err_at
     *
     * @param pwdErrAt the value for sys_member.pwd_err_at
     *
     * @mbggenerated
     */
    public void setPwdErrAt(Date pwdErrAt) {
        this.pwdErrAt = pwdErrAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_member.sort
     *
     * @return the value of sys_member.sort
     *
     * @mbggenerated
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_member.sort
     *
     * @param sort the value for sys_member.sort
     *
     * @mbggenerated
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
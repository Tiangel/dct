package yxinfo.dct.service.base.dao.model;

public class SysAppMenu {
    private Integer id;

    //名称
    private String fname;

    //唯一编号
    private String fcode;

    private String icon;

    //备注
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_app_menu.id
     *
     * @return the value of sys_app_menu.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_app_menu.id
     *
     * @param id the value for sys_app_menu.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_app_menu.fname
     *
     * @return the value of sys_app_menu.fname
     *
     * @mbggenerated
     */
    public String getFname() {
        return fname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_app_menu.fname
     *
     * @param fname the value for sys_app_menu.fname
     *
     * @mbggenerated
     */
    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_app_menu.fcode
     *
     * @return the value of sys_app_menu.fcode
     *
     * @mbggenerated
     */
    public String getFcode() {
        return fcode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_app_menu.fcode
     *
     * @param fcode the value for sys_app_menu.fcode
     *
     * @mbggenerated
     */
    public void setFcode(String fcode) {
        this.fcode = fcode == null ? null : fcode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_app_menu.icon
     *
     * @return the value of sys_app_menu.icon
     *
     * @mbggenerated
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_app_menu.icon
     *
     * @param icon the value for sys_app_menu.icon
     *
     * @mbggenerated
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_app_menu.remark
     *
     * @return the value of sys_app_menu.remark
     *
     * @mbggenerated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_app_menu.remark
     *
     * @param remark the value for sys_app_menu.remark
     *
     * @mbggenerated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
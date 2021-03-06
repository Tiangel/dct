package yxinfo.dct.service.base.dao.model;

import java.util.Date;

public class SysOrgBop {
    private Integer id;

    private Integer orgId;

    //计费项目
    private String itemNo;

    //类型（1收入，2支出）
    private String ftype;

    //收支金额（分）
    private Integer amt;

    private Date createAt;

    //关联记录id
    private Integer relId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org_bop.id
     *
     * @return the value of sys_org_bop.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org_bop.id
     *
     * @param id the value for sys_org_bop.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org_bop.org_id
     *
     * @return the value of sys_org_bop.org_id
     *
     * @mbggenerated
     */
    public Integer getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org_bop.org_id
     *
     * @param orgId the value for sys_org_bop.org_id
     *
     * @mbggenerated
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org_bop.item_no
     *
     * @return the value of sys_org_bop.item_no
     *
     * @mbggenerated
     */
    public String getItemNo() {
        return itemNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org_bop.item_no
     *
     * @param itemNo the value for sys_org_bop.item_no
     *
     * @mbggenerated
     */
    public void setItemNo(String itemNo) {
        this.itemNo = itemNo == null ? null : itemNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org_bop.ftype
     *
     * @return the value of sys_org_bop.ftype
     *
     * @mbggenerated
     */
    public String getFtype() {
        return ftype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org_bop.ftype
     *
     * @param ftype the value for sys_org_bop.ftype
     *
     * @mbggenerated
     */
    public void setFtype(String ftype) {
        this.ftype = ftype == null ? null : ftype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org_bop.amt
     *
     * @return the value of sys_org_bop.amt
     *
     * @mbggenerated
     */
    public Integer getAmt() {
        return amt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org_bop.amt
     *
     * @param amt the value for sys_org_bop.amt
     *
     * @mbggenerated
     */
    public void setAmt(Integer amt) {
        this.amt = amt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org_bop.create_at
     *
     * @return the value of sys_org_bop.create_at
     *
     * @mbggenerated
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org_bop.create_at
     *
     * @param createAt the value for sys_org_bop.create_at
     *
     * @mbggenerated
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org_bop.rel_id
     *
     * @return the value of sys_org_bop.rel_id
     *
     * @mbggenerated
     */
    public Integer getRelId() {
        return relId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org_bop.rel_id
     *
     * @param relId the value for sys_org_bop.rel_id
     *
     * @mbggenerated
     */
    public void setRelId(Integer relId) {
        this.relId = relId;
    }
}
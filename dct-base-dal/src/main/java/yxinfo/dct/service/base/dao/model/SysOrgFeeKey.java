package yxinfo.dct.service.base.dao.model;

public class SysOrgFeeKey {
    //组织id
    private Integer orgId;

    //计费项目
    private String itemNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org_fee.org_id
     *
     * @return the value of sys_org_fee.org_id
     *
     * @mbggenerated
     */
    public Integer getOrgId() {
        return orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org_fee.org_id
     *
     * @param orgId the value for sys_org_fee.org_id
     *
     * @mbggenerated
     */
    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_org_fee.item_no
     *
     * @return the value of sys_org_fee.item_no
     *
     * @mbggenerated
     */
    public String getItemNo() {
        return itemNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_org_fee.item_no
     *
     * @param itemNo the value for sys_org_fee.item_no
     *
     * @mbggenerated
     */
    public void setItemNo(String itemNo) {
        this.itemNo = itemNo == null ? null : itemNo.trim();
    }
}
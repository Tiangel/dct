package yxinfo.dct.inteface.dto.warn;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.Date;

/**
 * @author sxd
 * @date 2016/8/24 9:21
 */
public class WarnEnvironmentDTO extends BaseDTO {
    //in
    private Integer orgId;

    private String itemNo;
    //out
    /**
     * 预警内容
     */
    private String fcontext;
    /**
     * 生成时间
     */
    private Date createAt;
    /**
     * 类型 1温度，2湿度
     */
    private Integer type;
    /**
     * 实验室id
     */
    private Integer labId;
    /**
     * 实验室名称
     */
    private String labName;
    /**
     * 预警值
     */
    private String warnValue;
    /**
     * 预警范围
     */
    private String warnInterval;

    private String status;

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getFcontext() {
        return fcontext;
    }

    public void setFcontext(String fcontext) {
        this.fcontext = fcontext;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public String getLabName() {
        return labName;
    }

    public void setLabName(String labName) {
        this.labName = labName;
    }

    public String getWarnValue() {
        return warnValue;
    }

    public void setWarnValue(String warnValue) {
        this.warnValue = warnValue;
    }

    public String getWarnInterval() {
        return warnInterval;
    }

    public void setWarnInterval(String warnInterval) {
        this.warnInterval = warnInterval;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public WarnEnvironmentDTO() {
    }

    public WarnEnvironmentDTO(Integer labId, String labName, String warnValue, String warnInterval, Integer type) {
        this.labId = labId;
        this.labName = labName;
        this.warnValue = warnValue;
        this.warnInterval = warnInterval;
        this.type = type;
    }
}

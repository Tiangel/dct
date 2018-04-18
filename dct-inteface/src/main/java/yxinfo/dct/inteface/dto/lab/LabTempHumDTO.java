package yxinfo.dct.inteface.dto.lab;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author sxd
 * @date 2016/8/24 12:07
 */
public class LabTempHumDTO extends BaseDTO {
    private Integer id;

    private Integer orgId;

    private Integer labId;

    private BigDecimal temp;

    private BigDecimal hum;

    private Date createAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public BigDecimal getHum() {
        return hum;
    }

    public void setHum(BigDecimal hum) {
        this.hum = hum;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}

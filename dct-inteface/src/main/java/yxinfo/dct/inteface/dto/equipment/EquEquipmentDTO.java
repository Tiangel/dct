package yxinfo.dct.inteface.dto.equipment;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Delete;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Created by zh on 2016/6/23.
 */
public class EquEquipmentDTO extends BaseDTO {

    @Digits( integer = 10, fraction = 0, groups = Update.class, message = ErrorCode.EQU_EQUIPMENTID_LENGTH)
    @NotNull( groups = {Update.class, Delete.class}, message = ErrorCode.EQU_EQUIPMENTID_NOTNULL )
    private Integer id;

    @Length(max = 100, groups = {Update.class, Add.class},message = ErrorCode.EQU_RFIDFCODE_LENGTH)
    @NotEmpty(groups = {Update.class, Add.class},message = ErrorCode.EQU_RFIDFCODE_NOTNULL)
    private String equNo;

    private String purposeNo;

    private String fname;

    //组织id
    @Digits( integer = 10, fraction = 0, groups = {Update.class, Add.class}, message = ErrorCode.EQU_EQUIPMENT_ORGID_LENGTH)
    @NotNull( groups = {Update.class, Add.class}, message = ErrorCode.EQU_EQUIPMENTID_ORGID_NOTNULL )
    private Integer orgId;

    //物理地址
    private String address;

    private Integer siteId;

    //经度
    private BigDecimal lat;

    //纬度
    private BigDecimal lng;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquNo() {
        return equNo;
    }

    public void setEquNo(String equNo) {
        this.equNo = equNo;
    }

    public String getPurposeNo() {
        return purposeNo;
    }

    public void setPurposeNo(String purposeNo) {
        this.purposeNo = purposeNo;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }
}

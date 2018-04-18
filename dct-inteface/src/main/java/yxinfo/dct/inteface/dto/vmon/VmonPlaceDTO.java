package yxinfo.dct.inteface.dto.vmon;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.lab.LaboratoryDTO;
import yxinfo.dct.inteface.dto.wh.WhDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Delete;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * Created by ZH on 2016/7/26.
 */
public class VmonPlaceDTO extends BaseDTO {

    private Integer id;

    //组织id
    @Digits( integer = 10, fraction = 0, message = ErrorCode.EQU_EQUIPMENT_ORGID_LENGTH)
    @NotNull(message = ErrorCode.EQU_EQUIPMENTID_ORGID_NOTNULL )
    private Integer orgId;

    //地址
    @Length( max = 255, message = ErrorCode.VMON_PLACEADDRESS_LENGTH )
    @NotEmpty(message = ErrorCode.VMON_PLACEADDRESS_NOTNULL)
    private String address;

    //创建时间
    private Date createAt;

    //用途编号
    private String purposeNo;

    //监控地点id
    private Integer siteId;

    private WhDTO whDTO;

    private LaboratoryDTO laboratoryDTO;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getPurposeNo() {
        return purposeNo;
    }

    public void setPurposeNo(String purposeNo) {
        this.purposeNo = purposeNo;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public WhDTO getWhDTO() {
        return whDTO;
    }

    public void setWhDTO(WhDTO whDTO) {
        this.whDTO = whDTO;
    }

    public LaboratoryDTO getLaboratoryDTO() {
        return laboratoryDTO;
    }

    public void setLaboratoryDTO(LaboratoryDTO laboratoryDTO) {
        this.laboratoryDTO = laboratoryDTO;
    }

    @Override
    public String toString() {
        return "VmonPlaceDTO{" +
                "id=" + id +
                ", orgId=" + orgId +
                ", address='" + address + '\'' +
                ", createAt=" + createAt +
                ", purposeNo='" + purposeNo + '\'' +
                ", siteId=" + siteId +
                ", whDTO=" + whDTO +
                ", laboratoryDTO=" + laboratoryDTO +
                '}';
    }
}

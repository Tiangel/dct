package yxinfo.dct.inteface.dto.wh;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * 仓库bean
 *
 * Created by cy on 2016/6/23.
 */
public class WhDTO extends BaseDTO {

    /**
     * 仓库id
     */
    @Digits( integer = 10, fraction = 0, groups = Update.class, message = ErrorCode.WH_WHID_LENGTH)
    @NotNull( groups = Update.class, message = ErrorCode.WH_WHID_NOTNULL )
    private Integer whId;

    /**
     * 仓库名称
     */
    @Length(max = 255, message = ErrorCode.WH_WHNAME_LENGTH)
    @NotEmpty(message = ErrorCode.WH_WHNAME_NOTNULL)
    private String whName;

    /**
     * 组织id
     */
    @Digits(integer = 10, fraction = 0, message = ErrorCode.LAB_ORGID_LENGTH)
    @NotNull(message = ErrorCode.LAB_ORGID_NOTNULL)
    private Integer orgId;

    /**
     * 创建时间
     */
    private Date createAt;

    /**
     * 更新时间
     */
    private Date updateAt;

/*    *//**
     * 仓库管理人集合
     *//*
    @Valid
    private List<WhManagerDTO> whManagerList;*/

    /**
     * 仓库地址
     */
    @Length(max = 255, message = ErrorCode.WH_ADDRESS_LENGTH)
    private String address;

    @Length(max = 50, message = ErrorCode.WH_AREA_LENGTH)
    private String area;

    public WhDTO() {
    }

    public WhDTO(Integer whId, String whName, Integer orgId, Date createAt, Date updateAt, String address, String area) {
        this.whId = whId;
        this.whName = whName;
        this.orgId = orgId;
        this.createAt = createAt;
        this.updateAt = updateAt;
        this.address = address;
        this.area = area;
    }

    public Integer getWhId() {
        return whId;
    }

    public void setWhId(Integer whId) {
        this.whId = whId;
    }

    public String getWhName() {
        return whName;
    }

    public void setWhName(String whName) {
        this.whName = whName;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "WhDTO{" +
                "whId=" + whId +
                ", whName='" + whName + '\'' +
                ", orgId=" + orgId +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", address='" + address + '\'' +
                ", area='" + area + '\'' +
                '}';
    }
}

package yxinfo.dct.inteface.dto.warn;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author sxd
 * @date 2016/8/25 9:16
 */
public class WarnRule4EnvironmentDTO extends BaseDTO {

    @NotNull(groups = Add.class, message = ErrorCode.CHEM_LAB_ID_NOT_EMPTY)
    private Integer labId;
    @NotNull(groups = Add.class, message = ErrorCode.ORG_ID_NOT_NULL)
    private Integer orgId;
    @NotNull(groups = Add.class, message = ErrorCode.MEMBER_ID_NOT_EMPTY)
    private Integer memberId;
    @NotNull(groups = Add.class, message = ErrorCode.PARAM_NOT_NULL)
    private BigDecimal tempLeft;

    @NotNull(groups = Add.class, message = ErrorCode.PARAM_NOT_NULL)
    private BigDecimal tempRight;

    @NotNull(groups = Add.class, message = ErrorCode.PARAM_NOT_NULL)
    private BigDecimal humLeft;

    @NotNull(groups = Add.class, message = ErrorCode.PARAM_NOT_NULL)
    private BigDecimal humRight;

    @NotNull(groups = Add.class, message = ErrorCode.PARAM_NOT_NULL)
    private Integer tempAndHumCacheInterval;

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public BigDecimal getTempLeft() {
        return tempLeft;
    }

    public void setTempLeft(BigDecimal tempLeft) {
        this.tempLeft = tempLeft;
    }

    public BigDecimal getTempRight() {
        return tempRight;
    }

    public void setTempRight(BigDecimal tempRight) {
        this.tempRight = tempRight;
    }

    public BigDecimal getHumLeft() {
        return humLeft;
    }

    public void setHumLeft(BigDecimal humLeft) {
        this.humLeft = humLeft;
    }

    public BigDecimal getHumRight() {
        return humRight;
    }

    public void setHumRight(BigDecimal humRight) {
        this.humRight = humRight;
    }

    public Integer getTempAndHumCacheInterval() {
        return tempAndHumCacheInterval;
    }

    public void setTempAndHumCacheInterval(Integer tempAndHumCacheInterval) {
        this.tempAndHumCacheInterval = tempAndHumCacheInterval;
    }
}

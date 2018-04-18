package yxinfo.dct.inteface.dto.lab;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;

import javax.validation.constraints.NotNull;

/**
 * @author sxd
 * @date 2016/8/24 12:07
 */
public class LabSettingsDTO extends BaseDTO {

    @NotNull(message = ErrorCode.CHEM_LAB_ID_NOT_EMPTY)
    private Integer labId;

    //配置key
    @NotNull(message = ErrorCode.FKEY_NOT_NULL)
    private Byte fkey;

    //配置值
    @NotEmpty(message = ErrorCode.VAL_NOT_NULL)
    private String val;

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public Byte getFkey() {
        return fkey;
    }

    public void setFkey(Byte fkey) {
        this.fkey = fkey;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}

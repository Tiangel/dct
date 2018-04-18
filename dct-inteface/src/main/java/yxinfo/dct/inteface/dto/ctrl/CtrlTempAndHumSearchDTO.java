package yxinfo.dct.inteface.dto.ctrl;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;

import javax.validation.constraints.NotNull;


/**
 * @author lovetcat
 * @date 2016/8/13 19:31
 */
public class CtrlTempAndHumSearchDTO extends BaseDTO{

    //in
    //用途编号，实验室温湿度监控传100005
    @NotEmpty(message = ErrorCode.EQU_PURPOSE_NOT_EMPTY)
    private String purposeNo;
    //位置id（实验室id/....）
    @NotNull(message = ErrorCode.EQU_SITE_ID_NOT_NULL)
    private Integer siteId;

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
}

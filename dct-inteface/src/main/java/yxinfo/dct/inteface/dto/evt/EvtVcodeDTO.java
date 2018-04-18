package yxinfo.dct.inteface.dto.evt;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Select;

import java.util.Date;
import java.util.List;

/**
 * Created by dy on 2016/6/27.
 */
public class EvtVcodeDTO extends BaseDTO {

    private static final long serialVersionUID = 1556950127181481041L;

    private Integer id;

    //用于的功能码
    @NotEmpty( groups = { Add.class, Select.class },
            message = ErrorCode.EVT_VCODE_USE_AT_NOT_EMPTY )
    private String useAt;

    //验证码
    @NotEmpty( groups = { Add.class, Select.class },
            message = ErrorCode.EVT_VCODE_CODE_NOT_EMPTY )
    private String fcode;

    //手机号
    @NotEmpty( groups = { Add.class, Select.class },
            message = ErrorCode.EVT_VCODE_MOBILE_NOT_EMPTY )
    private String mobile;

    //创建时间
    private Date createAt;

    //验证错误次数
    private Integer errCount;

    List<String> ectMsg;

    // 是否需要票据
    private boolean needTicket;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUseAt() {
        return useAt;
    }

    public void setUseAt(String useAt) {
        this.useAt = useAt;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getErrCount() {
        return errCount;
    }

    public void setErrCount(Integer errCount) {
        this.errCount = errCount;
    }

    public List<String> getEctMsg() {
        return ectMsg;
    }

    public void setEctMsg(List<String> ectMsg) {
        this.ectMsg = ectMsg;
    }

    public boolean isNeedTicket() {
        return needTicket;
    }

    public void setNeedTicket(boolean needTicket) {
        this.needTicket = needTicket;
    }
}

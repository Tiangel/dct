package yxinfo.dct.inteface.dto.base;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;

import javax.validation.constraints.NotNull;

/**
 * Created by dy on 2016/7/16.
 */
public class UpdatePwdDTO extends BaseDTO {

    private static final long serialVersionUID = 6384699436911627162L;

    // 成员id
    @NotNull( message = ErrorCode.MEMBER_ID_NOT_EMPTY )
    private Integer memberId;

    // 原密码
    @NotNull( message = ErrorCode.PWD_NOT_EMPTY )
    private String oldPwd;

    // 新密码
    @NotNull( message = ErrorCode.PWD_NOT_EMPTY )
    private String newPwd;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}

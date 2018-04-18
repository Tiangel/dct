package yxinfo.dct.inteface.dto.base;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.Date;

/**
 * Created by hanley on 2016/6/23.
 */
public class AccessTokenDTO extends BaseDTO {

    private static final long serialVersionUID = -8186687727165607980L;

    //AccessToken
    private String accessTok;

    //设备终端类型
    private String deviceType;

    //创建时间
    private Date createAt;

    //过期时间
    private int expireIn;

    //成员id
    private Integer memberId;

    public String getAccessTok() {
        return accessTok;
    }

    public void setAccessTok(String accessTok) {
        this.accessTok = accessTok;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
}

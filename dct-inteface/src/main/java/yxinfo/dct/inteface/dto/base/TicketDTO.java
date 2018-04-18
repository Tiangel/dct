package yxinfo.dct.inteface.dto.base;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.Date;

public class TicketDTO extends BaseDTO {

    private static final long serialVersionUID = 6675146768748627144L;

    // 票据
    private String ticket;

    //创建时间
    private Date createAt;

    //成员id
    private Integer memberId;

    //票据使用接口
    private String userAt;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
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

    public String getUserAt() {
        return userAt;
    }

    public void setUserAt(String userAt) {
        this.userAt = userAt;
    }
}
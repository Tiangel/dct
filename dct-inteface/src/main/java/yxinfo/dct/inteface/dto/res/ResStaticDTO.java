package yxinfo.dct.inteface.dto.res;

import org.hibernate.validator.constraints.NotEmpty;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class ResStaticDTO extends BaseDTO {

    private static final long serialVersionUID = 7208235056442598195L;

    private Integer id;

    //地址
    @NotEmpty( groups = Add.class,
            message = ErrorCode.RES_URL_NOT_EMPTY )
    private String url;

    //创建时间
    private Date createAt;

    //资源上传约束id
    @NotNull( groups = Add.class,
            message = ErrorCode.RES_UB_ID_NOT_EMPTY  )
    private Integer ubId;

    //上传ip
    private String ip;

    //上传用户id
    private Integer memberId;

    public ResStaticDTO() {}

    public ResStaticDTO(String url, Date createAt, Integer ubId, String ip, Integer memberId) {
        this.url = url;
        this.createAt = createAt;
        this.ubId = ubId;
        this.ip = ip;
        this.memberId = memberId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getUbId() {
        return ubId;
    }

    public void setUbId(Integer ubId) {
        this.ubId = ubId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }
}
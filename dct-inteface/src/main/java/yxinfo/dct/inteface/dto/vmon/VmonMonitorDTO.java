package yxinfo.dct.inteface.dto.vmon;

import org.hibernate.validator.constraints.Length;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by ZH on 2016/7/26.
 */
public class VmonMonitorDTO extends BaseDTO {

    private Integer id;

    //监控地点id
    @Digits( integer = 10, fraction = 0, message = ErrorCode.VMON_PLACEID_LENGTH)
    private Integer placeId;

    //ip地址
    @Length(max = 100, message = ErrorCode.VMON_MONITORIP_LENGTH)
    private String ip;

    //组织id
    @Digits( integer = 10, fraction = 0, message = ErrorCode.EQU_EQUIPMENT_ORGID_LENGTH)
    @NotNull(message = ErrorCode.EQU_EQUIPMENTID_ORGID_NOTNULL )
    private Integer orgId;

    //供应商id
    @Digits( integer = 10, fraction = 0, message = ErrorCode.EQU_EQUIPMENT_ORGID_LENGTH)
    private Integer supplierId;

    //端口
    @Length(max = 20, message = ErrorCode.VMON_MONITORPORT_LENGTH)
    private String port;

    //用户名
    @Length(max = 100, message = ErrorCode.VMON_MONITORIPUSERNAME_LENGTH)
    private String username;

    //密码
    @Length(max = 100, message = ErrorCode.VMON_MONITORPWD_LENGTH)
    private String pwd;

    //创建时间
    private Date createAt;

    private String resCode;

    //rtsp端口
    @Length(max = 20, message = ErrorCode.VMON_MONITORPORT_LENGTH)
    private String rtspPort;

    //信道
    @Length(max = 255, message = ErrorCode.VMON_MONITORPORT_LENGTH)
    private String channel;

    private VmonPlaceDTO vmonPlaceDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public VmonPlaceDTO getVmonPlaceDTO() {
        return vmonPlaceDTO;
    }

    public void setVmonPlaceDTO(VmonPlaceDTO vmonPlaceDTO) {
        this.vmonPlaceDTO = vmonPlaceDTO;
    }

    public String getRtspPort() {
        return rtspPort;
    }

    public void setRtspPort(String rtspPort) {
        this.rtspPort = rtspPort;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }
}

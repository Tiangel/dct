package yxinfo.dct.inteface.dto.inst;

import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.validation.groups.Update;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by sxd on 2016/7/14.
 */
public class BespeakInstDTO extends BaseDTO {

    private static final long serialVersionUID = 3961073062223209158L;

    //仪器id
    @NotNull(groups = Update.class, message = ErrorCode.INST_BESPEAK_INSTID_NOT_NULL)
    private Integer instId;
    //仪器预约id
    @NotNull(groups = Update.class, message = ErrorCode.INST_BESPEAK_INSTBSKID_NOT_NULL)
    private Integer instBskId;
    //仪器使用开始时间
    private Date useStartTime;
    //仪器使用结束时间
    private Date useEndTime;

    private Date startTime;
    private Date endTime;
    //仪器名称
    private String fname;

    public Integer getInstId() {
        return instId;
    }

    public void setInstId(Integer instId) {
        this.instId = instId;
    }

    public Integer getInstBskId() {
        return instBskId;
    }

    public void setInstBskId(Integer instBskId) {
        this.instBskId = instBskId;
    }

    public Date getUseStartTime() {
        return useStartTime;
    }

    public void setUseStartTime(Date useStartTime) {
        this.useStartTime = useStartTime;
    }

    public Date getUseEndTime() {
        return useEndTime;
    }

    public void setUseEndTime(Date useEndTime) {
        this.useEndTime = useEndTime;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "BespeakInstDTO{" +
                "instId=" + instId +
                ", instBskId=" + instBskId +
                ", useStartTime=" + useStartTime +
                ", useEndTime=" + useEndTime +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", fname='" + fname + '\'' +
                '}';
    }
}

package yxinfo.dct.inteface.dto.inst;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.Date;

/**
 * @author sxd
 * @date 2016/8/13 10:51
 */
public class InstRunRecordDTO extends BaseDTO {

    private Integer id;

    //日期
    private Date fdate;

    //仪器id
    private Integer instId;

    //运行时间（秒）
    private Integer runTime;

    //运行状态（1开启，2关闭）
    private String runStatus;

    private Date startupAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFdate() {
        return fdate;
    }

    public void setFdate(Date fdate) {
        this.fdate = fdate;
    }

    public Integer getInstId() {
        return instId;
    }

    public void setInstId(Integer instId) {
        this.instId = instId;
    }

    public Integer getRunTime() {
        return runTime;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }

    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus;
    }

    public Date getStartupAt() {
        return startupAt;
    }

    public void setStartupAt(Date startupAt) {
        this.startupAt = startupAt;
    }

    @Override
    public String toString() {
        return "InstRunRecordDTO{" +
                "id=" + id +
                ", fdate=" + fdate +
                ", instId=" + instId +
                ", runTime=" + runTime +
                ", runStatus='" + runStatus + '\'' +
                ", startupAt=" + startupAt +
                '}';
    }
}

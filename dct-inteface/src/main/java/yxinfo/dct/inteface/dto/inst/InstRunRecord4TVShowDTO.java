package yxinfo.dct.inteface.dto.inst;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * @author sxd
 * @date 2016/8/13 15:56
 */
public class InstRunRecord4TVShowDTO extends BaseDTO {
    //总仪器数
    private Integer total;
    //正常的数量
    private Integer normal;
    //运行的数量
    private Integer running;
    //停机的数量
    private Integer closed;
    //报损的数量
    private Integer broken;
    //利用率
    private Double utilization;
    //故障率
    private Double faultRate;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getNormal() {
        return normal;
    }

    public void setNormal(Integer normal) {
        this.normal = normal;
    }

    public Integer getRunning() {
        return running;
    }

    public void setRunning(Integer running) {
        this.running = running;
    }

    public Integer getClosed() {
        return closed;
    }

    public void setClosed(Integer closed) {
        this.closed = closed;
    }

    public Integer getBroken() {
        return broken;
    }

    public void setBroken(Integer broken) {
        this.broken = broken;
    }

    public Double getUtilization() {
        return utilization;
    }

    public void setUtilization(Double utilization) {
        this.utilization = utilization;
    }

    public Double getFaultRate() {
        return faultRate;
    }

    public void setFaultRate(Double faultRate) {
        this.faultRate = faultRate;
    }

    public InstRunRecord4TVShowDTO() {
    }

    public InstRunRecord4TVShowDTO(Integer total, Integer normal, Integer running, Integer closed, Integer broken, Double utilization, Double faultRate) {
        this.total = total;
        this.normal = normal;
        this.running = running;
        this.closed = closed;
        this.broken = broken;
        this.utilization = utilization;
        this.faultRate = faultRate;
    }

    @Override
    public String toString() {
        return "InstRunRecord4TVShowDTO{" +
                "total=" + total +
                ", normal=" + normal +
                ", running=" + running +
                ", closed=" + closed +
                ", broken=" + broken +
                ", utilization=" + utilization +
                ", faultRate=" + faultRate +
                '}';
    }
}

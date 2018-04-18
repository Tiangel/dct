package yxinfo.dct.inteface.dto.chem.stats;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.Date;

/**
 * Created by dy on 2016/7/15.
 */
public class ChemStatsSchDTO extends BaseDTO {

    private static final long serialVersionUID = -5843740467681145349L;

    // 统计时间范围，statsDateFrom~statsDateTo
    private Date statsDateFrom;
    private Date statsDateTo;

    private ChemStatsDTO stats;

    public Date getStatsDateFrom() {
        return statsDateFrom;
    }

    public void setStatsDateFrom(Date statsDateFrom) {
        this.statsDateFrom = statsDateFrom;
    }

    public Date getStatsDateTo() {
        return statsDateTo;
    }

    public void setStatsDateTo(Date statsDateTo) {
        this.statsDateTo = statsDateTo;
    }

    public ChemStatsDTO getStats() {
        return stats;
    }

    public void setStats(ChemStatsDTO stats) {
        this.stats = stats;
    }
}

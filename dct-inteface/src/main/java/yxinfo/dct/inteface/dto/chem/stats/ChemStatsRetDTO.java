package yxinfo.dct.inteface.dto.chem.stats;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemChemicalDTO;

import java.util.Date;

/**
 * Created by dy on 2016/7/15.
 */
public class ChemStatsRetDTO extends BaseDTO {

    private static final long serialVersionUID = 2803661341611730647L;

    // 时间
    private Date statsDate;

    // 化学品
    private ChemChemicalDTO chem;

    // 领用数量
    private Integer receiveTotal;

    // 回收数量
    private Integer recycleTotal;

    public Date getStatsDate() {
        return statsDate;
    }

    public void setStatsDate(Date statsDate) {
        this.statsDate = statsDate;
    }

    public ChemChemicalDTO getChem() {
        return chem;
    }

    public void setChem(ChemChemicalDTO chem) {
        this.chem = chem;
    }

    public Integer getReceiveTotal() {
        return receiveTotal;
    }

    public void setReceiveTotal(Integer receiveTotal) {
        this.receiveTotal = receiveTotal;
    }

    public Integer getRecycleTotal() {
        return recycleTotal;
    }

    public void setRecycleTotal(Integer recycleTotal) {
        this.recycleTotal = recycleTotal;
    }
}

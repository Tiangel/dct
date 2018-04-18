package yxinfo.dct.inteface.dto.ctrl;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.List;

/**
 * @author lovetcat
 * @date 2016/8/13 17:41
 */
public class ChemReagent4TVShowDTO extends BaseDTO {

    /**
     * 总数
     */
    private Integer total;
    /**
     * 危险试剂数
     */
    private Integer danger;
    /**
     * 试剂名称
     */
    private List<String> chemReagentNameList;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getDanger() {
        return danger;
    }

    public void setDanger(Integer danger) {
        this.danger = danger;
    }

    public List<String> getChemReagentNameList() {
        return chemReagentNameList;
    }

    public void setChemReagentNameList(List<String> chemReagentNameList) {
        this.chemReagentNameList = chemReagentNameList;
    }

    public ChemReagent4TVShowDTO() {
    }

    public ChemReagent4TVShowDTO(Integer total, Integer danger, List<String> chemReagentNameList) {
        this.total = total;
        this.danger = danger;
        this.chemReagentNameList = chemReagentNameList;
    }

    @Override
    public String toString() {
        return "ChemReagent4TVShowDTO{" +
                "total=" + total +
                ", danger=" + danger +
                ", chemReagentNameList=" + chemReagentNameList +
                '}';
    }
}

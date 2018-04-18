package yxinfo.dct.inteface.dto.chem.chemical;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * 化学试剂单位
 * Created by dy on 2016/6/21.
 */
public class ChemUnitDTO extends BaseDTO {

    private static final long serialVersionUID = -4547944347200044811L;

    // id
    private Integer id;

    //编号
    private String fcode;

    //单位
    private String unit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

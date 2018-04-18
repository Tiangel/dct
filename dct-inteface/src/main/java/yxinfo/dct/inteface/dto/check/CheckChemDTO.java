package yxinfo.dct.inteface.dto.check;

import yxinfo.dct.inteface.dto.BaseDTO;

/**
 * Created by sxd on 2016/7/21.
 */
public class CheckChemDTO extends BaseDTO {

    private static final long serialVersionUID = -2463781491229629413L;

    private Integer id;
    //盘点记录id
    private Integer checkId;

    //化学品
    private String chemName;

    //规格
    private String specName;

    private String cas;

    //容量
    private Integer capacity;

    //单位
    private String unitName;
    //盘点得出的数量
    private Integer ckNum;

    //记录的库存数量
    private Integer recordNum;
    //差值
    private Integer difference;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    public String getChemName() {
        return chemName;
    }

    public void setChemName(String chemName) {
        this.chemName = chemName;
    }

    public String getSpecName() {
        return specName;
    }

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Integer getCkNum() {
        return ckNum;
    }

    public void setCkNum(Integer ckNum) {
        this.ckNum = ckNum;
    }

    public Integer getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(Integer recordNum) {
        this.recordNum = recordNum;
    }

    public Integer getDifference() {
        return difference;
    }

    public void setDifference(Integer difference) {
        this.difference = difference;
    }

    @Override
    public String toString() {
        return "CheckChemDTO{" +
                "id=" + id +
                ", checkId=" + checkId +
                ", chemName='" + chemName + '\'' +
                ", specName='" + specName + '\'' +
                ", cas='" + cas + '\'' +
                ", capacity=" + capacity +
                ", unitName='" + unitName + '\'' +
                ", ckNum=" + ckNum +
                ", recordNum=" + recordNum +
                ", difference=" + difference +
                '}';
    }
}

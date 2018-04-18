package yxinfo.dct.inteface.dto.chem.check;

import yxinfo.dct.inteface.dto.BaseDTO;

import java.util.List;

/**
 * 盘点汇总
 * Created by dy on 2016/7/29.
 */
public class ChemCheckStockRetDTO extends BaseDTO {

    private static final long serialVersionUID = 1981099815291495645L;

    // 汇总信息
    private List<ChemCheckDTO> ckList;

    // 唯一流水号
    private String serial;

    public List<ChemCheckDTO> getCkList() {
        return ckList;
    }

    public void setCkList(List<ChemCheckDTO> ckList) {
        this.ckList = ckList;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}

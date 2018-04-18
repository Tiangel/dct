package yxinfo.dct.inteface.dto.chem.stock;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemUnitDTO;

/**
 * Created by dy on 2016/10/18.
 */
public class ChemStockCountDTO extends BaseDTO {

    private static final long serialVersionUID = -6645768328443831744L;

    private Integer capacity;

    private ChemUnitDTO unit;

    private Integer count;

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity( Integer capacity ) {
        this.capacity = capacity;
    }

    public ChemUnitDTO getUnit() {
        return unit;
    }

    public void setUnit( ChemUnitDTO unit ) {
        this.unit = unit;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount( Integer count ) {
        this.count = count;
    }
}

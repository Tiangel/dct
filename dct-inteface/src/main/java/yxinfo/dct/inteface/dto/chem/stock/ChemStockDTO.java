package yxinfo.dct.inteface.dto.chem.stock;

import yxinfo.dct.inteface.dto.BaseDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemChemicalDTO;
import yxinfo.dct.inteface.dto.chem.chemical.ChemSpecDTO;

import java.util.List;

/**
 * Created by dy on 2016/10/18.
 */
public class ChemStockDTO extends BaseDTO {

    private static final long serialVersionUID = -5718169636302388968L;

    private ChemChemicalDTO chem;

    private ChemSpecDTO spec;

    private List<ChemStockCountDTO> counts;

    public ChemChemicalDTO getChem() {
        return chem;
    }

    public void setChem( ChemChemicalDTO chem ) {
        this.chem = chem;
    }

    public ChemSpecDTO getSpec() {
        return spec;
    }

    public void setSpec( ChemSpecDTO spec ) {
        this.spec = spec;
    }

    public List<ChemStockCountDTO> getCounts() {
        return counts;
    }

    public void setCounts( List<ChemStockCountDTO> counts ) {
        this.counts = counts;
    }
}

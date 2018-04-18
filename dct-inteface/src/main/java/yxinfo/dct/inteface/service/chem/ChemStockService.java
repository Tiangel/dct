package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.chem.stock.ChemBelongSchDTO;
import yxinfo.dct.inteface.dto.chem.stock.ChemStockDTO;
import yxinfo.dct.inteface.dto.chem.stock.ChemStockMbrDTO;
import yxinfo.dct.inteface.dto.chem.stock.ChemStockSchDTO;

import java.util.List;

/**
 * Created by dy on 2016/10/18.
 */
public interface ChemStockService {

    /**
     * 根据试剂名称/CAS查询库存列表
     * @code 108047
     * @param schPage
     * @return
     */
    PageDTO<List<ChemStockDTO>> getStockListPageByNameCas( PageDTO<ChemStockSchDTO> schPage );

    /**
     * 根据采购人姓名查询库存列表
     * @code 108048
     * @param schPage
     * @return
     */
    PageDTO<List<ChemStockMbrDTO>> getStockListPageByMbrName( PageDTO<ChemStockSchDTO> schPage );

    /**
     * 试剂归属明细
     * @code 108049
     * @param schData
     * @return
     */
    List<ChemStockMbrDTO> getBelongMbrList( ChemBelongSchDTO schData );
}

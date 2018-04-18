package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.chem.stock.MbrStockCountDTO;
import yxinfo.dct.inteface.dto.chem.stocks.StockSummaryDTO;
import yxinfo.dct.inteface.dto.chem.stocks.StockSummarySchDTO;

import java.util.List;

/**
 * Created by dy on 2016/10/19.
 */
public interface ChemStockSummaryService {

    /**
     * 试剂汇总信息
     * @code 108050
     * @param schPage
     * @return
     */
    PageDTO<List<StockSummaryDTO>> getChemStockSummaryPage( PageDTO<StockSummarySchDTO> schPage );

    /**
     * 查询采购人的试剂数量以及试剂种类
     * @code 108051
     * @param data
     * @return
     */
    MbrStockCountDTO getMbrChemStockCount( StockSummarySchDTO data );

    /**
     * 申领时获取库存的化学品规格
     * @code 108052
     * @param schData chemId  必传, 化学品名称id
     *                mbrCode 选传, 采购人工号; 传递则搜索采购人名下及可调配的试剂, 不传递则搜索全部试剂
     * @return
     */
    List<StockSummaryDTO> getChemStockSummaryOnApply( StockSummarySchDTO schData );
}

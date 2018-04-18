package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemSummaryDTO;

import java.util.List;

/**
 * Created by dy on 2016/6/23.
 */
public interface ChemSummaryService {

    /**
     * 获取化学品规格
     * @api 108004 获取库存的化学品规格
     * @param chemSummaryDTO
     * @return
     */
    List<ChemSummaryDTO> getChemSummaryOnApply( ChemSummaryDTO chemSummaryDTO );

    /**
     * 获取化学品汇总信息
     * @api 108021 获取化学品汇总信息
     * @param chemSummaryDTO
     * @return
     */
    PageDTO<List<ChemSummaryDTO>> getChemSummarys( PageDTO<ChemSummaryDTO> chemSummaryDTOPageDTO );

    /**
     * 获取化学品规格（按地点归类）
     * @param chemSummaryDTO
     * @return
     */
    List<ChemSummaryDTO> getChemSummarysByWhere( ChemSummaryDTO chemSummaryDTO );

    /**
     * 修改化学试剂汇总信息
     * @param chemSummaryDTO count为增加或减少的数量, 例如count=-10表示减少10
     * @return
     * @throws DctException 库存不足抛出异常ErrorCode.CHEM_RECEIVE_NO_STOCK
     */
    int plusChemSummaryCount( ChemSummaryDTO chemSummaryDTO );

    /**
     * 修改化学试剂汇总信息, 不存在则新建
     * @param chemSummaryDTO count为增加或减少的数量, 例如count=-10表示减少10
     * @return
     */
    Integer addOrPlusChemSummary( ChemSummaryDTO chemSummaryDTO );

    /**
     * 查询化学试剂汇总信息
     * @param chemSummaryDTO
     * @return
     */
    ChemSummaryDTO getChemSummary( ChemSummaryDTO chemSummaryDTO );

    /**
     * 获取确定唯一一条ChemSummary记录的条件
     * @param chemReagentDTO
     * @return
     */
    ChemSummaryDTO getChemSummaryUniqueCriteria( ChemReagentDTO chemReagentDTO );

}

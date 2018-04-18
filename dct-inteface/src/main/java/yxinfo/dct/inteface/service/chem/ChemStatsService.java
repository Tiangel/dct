package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;
import yxinfo.dct.inteface.dto.chem.stats.ChemStatsDTO;
import yxinfo.dct.inteface.dto.chem.stats.ChemStatsRetDTO;
import yxinfo.dct.inteface.dto.chem.stats.ChemStatsSchDTO;

import java.util.List;

/**
 * Created by dy on 2016/7/14.
 */
public interface ChemStatsService {

    /**
     * 领用及回收统计
     * @api 108022 领用及回收统计
     * @param chemStatsSchDTOPageDTO
     * @return
     */
    PageDTO<List<ChemStatsRetDTO>> getStatsReceiveAndRecycle( PageDTO<ChemStatsSchDTO> chemStatsSchDTOPageDTO );

    /**
     * 领用及回收统计导出
     * @api 108033 领用及回收统计导出
     * @param schDTO
     * @param token
     * @return
     */
    String getStatsReceiveAndRecycleExport( ChemStatsSchDTO schDTO, String token );

    /**
     * 增加统计数量, 不存在则新建
     * @param chemStatsDTO
     * @return
     */
    Integer addOrPlusChemStats( ChemStatsDTO chemStatsDTO );

    /**
     * 增加统计数量
     * @param chemStatsDTO
     * @return
     */
    int plusChemStatsCount( ChemStatsDTO chemStatsDTO );

    /**
     * 初始化统计信息
     * @param chemReagentDTO
     * @param itemNo
     * @param count
     * @return
     */
    ChemStatsDTO getChemStatsDTO( ChemReagentDTO chemReagentDTO, String itemNo, int count );
}

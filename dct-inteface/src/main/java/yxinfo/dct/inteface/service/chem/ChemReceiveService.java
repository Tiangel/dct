package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.chem.apply.ChemReceiveDTO;
import yxinfo.dct.inteface.dto.chem.apply.biz.ChemAddReceiveRetDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;

import java.util.List;

/**
 * Created by dy on 2016/6/23.
 */
public interface ChemReceiveService {

    /**
     * 领用列表全部
     * @api 108015 领用列表（仓管）
     * @param chemReagentPage
     * @return
     */
    PageDTO<List<ChemReceiveDTO>> getReceiveReagentPage( PageDTO<ChemReagentDTO> chemReagentPage );

    /**
     * 添加试剂领用基础方法
     * @param chemReagentDTO
     * @return
     */
    ChemAddReceiveRetDTO addReceive( ChemReagentDTO chemReagentDTO );

    /**
     * 添加试剂领用（电商采购专用）
     * @param chemReagentDTO
     * @return
     */
    ChemAddReceiveRetDTO addReceiveForShop( ChemReagentDTO chemReagentDTO );

    /**
     * 获取试剂信息
     * @api 108017 扫码获取试剂信息（领用时）
     * @param chemReagentDTO
     * @return
     * @throws Exception
     */
    ChemReagentDTO getChemInfoOnReceive( ChemReagentDTO chemReagentDTO );

    /**
     * 根据试剂id和申领记录id查询领用记录列表
     * @api 108036 试剂列表（领用预警）
     * @param chemReceiveDTOs
     * @return
     */
    List<ChemReceiveDTO> getReceiveInReagentIdsAndArIds( List<ChemReceiveDTO> chemReceiveDTOs );

}

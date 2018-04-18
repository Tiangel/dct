package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemWhTotalDTO;

import java.util.List;

/**
 * Created by dy on 2016/7/14.
 */
public interface ChemWhTotalService {

    /**
     * 获取化学品规格（企业）
     * @api 108023 获取库存的化学品规格（企业）
     * @param chemWhTotalDTO
     * @return
     */
    List<ChemWhTotalDTO> getChemWhTotalOnApply( ChemWhTotalDTO chemWhTotalDTO );

    /**
     * 分页查询化学品库存, 并查询库存明细
     * @api 108028 获取库存信息
     * @param chemWhTotalDTOPageDTO
     * @return
     */
    PageDTO<List<ChemWhTotalDTO>> getChemWhTotalDetailPage( PageDTO<ChemReagentDTO> chemWhTotalDTOPageDTO );

    /**
     * 增加（或减去）库存, 记录不存在则创建
     * @param chemWhTotalDTO
     * @return
     * @throws DctException 库存不足抛出异常ErrorCode.CHEM_RECEIVE_NO_STOCK
     */
    Integer addOrPlusChemWhTotal( ChemWhTotalDTO chemWhTotalDTO );

    /**
     * 增加（或减去）库存
     * @param chemWhTotalDTO
     * @return DctException 库存不足抛出异常ErrorCode.CHEM_RECEIVE_NO_STOCK
     */
    int plusChemWhTotalCount( ChemWhTotalDTO chemWhTotalDTO );

    /**
     * 获取库存信息
     * @param chemWhTotalDTO
     * @return
     */
    ChemWhTotalDTO getChemWhTotal( ChemWhTotalDTO chemWhTotalDTO );

    /**
     * 获取确定库存记录唯一条件
     * @param chemReagentDTO
     * @return
     */
    ChemWhTotalDTO getChemWhTotalUniqueCriteria( ChemReagentDTO chemReagentDTO );

}

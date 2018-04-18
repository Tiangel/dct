package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemRecycleDTO;
import yxinfo.dct.inteface.dto.chem.reagent.biz.ChemRecycleExDTO;
import yxinfo.dct.inteface.dto.chem.reagent.biz.ChemRecycleSchDTO;

import java.util.List;

/**
 * Created by dy on 2016/6/23.
 */
public interface ChemRecycleService {

    /**
     * 回收的化学试剂分页查询
     * @api 108009 回收列表
     * @api 1080026 仓管回收（回库）列表
     * @param chemReagentPage
     * @return
     * @throws Exception
     */
    PageDTO<List<ChemRecycleDTO>> getRecycleReagentPage( PageDTO<ChemReagentDTO> chemReagentPage );

    /**
     * 回收的化学试剂分页查询(扩展)
     * @api 108020 回收列表(扩展搜索)
     * @param chemRecycleSchDTOPageDTO
     * @return
     */
    PageDTO<List<ChemRecycleExDTO>> getRecycleReagentPageEx( PageDTO<ChemRecycleSchDTO> chemRecycleSchDTOPageDTO );

    /**
     * 添加试剂回收
     * @api 108007 回收 isBack=false
     * @api 108025 回库 isBack=true
     * @param chemReagentDTO
     * @param isBack 是否回库
     * @return
     * @throws Exception
     */
    Integer addRecycle( ChemReagentDTO chemReagentDTO, boolean isBack );

    /**
     * 获取试剂回收记录
     * @param key
     * @return
     */
    ChemRecycleDTO getRecycleByKey( int key );

}

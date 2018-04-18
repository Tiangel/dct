package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemIntowhBatchDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;

import java.util.List;

/**
 * Created by dy on 2016/9/24.
 */
public interface ChemIntowhBatchService {

    /**
     * 分页查询入库批次
     * @code 108044
     * @param chemReagentSchDTOPageDTO
     * @return
     */
    PageDTO<List<ChemIntowhBatchDTO>> getIntowhBatchPage( PageDTO<ChemIntowhBatchDTO> chemReagentSchDTOPageDTO );

    /**
     * 根据入库记录修改试剂
     * @code 108045
     * @param batchId
     * @param chemReagent
     */
    void editReagentByBatch( Integer batchId, ChemReagentDTO chemReagent );
}

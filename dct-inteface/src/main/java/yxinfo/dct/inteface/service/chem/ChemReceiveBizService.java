package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;

/**
 * 试剂领用业务封装服务
 * Created by dy on 2016/7/2.
 */
public interface ChemReceiveBizService {

    /**
     * 添加试剂领用（学校版）
     * @api 108006 领用（学校版）
     * @param chemReagentDTO
     * @param terminal
     * @return
     */
    Integer addReceive( ChemReagentDTO chemReagentDTO, String terminal );

}

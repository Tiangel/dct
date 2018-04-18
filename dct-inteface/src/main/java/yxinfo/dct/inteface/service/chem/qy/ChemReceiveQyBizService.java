package yxinfo.dct.inteface.service.chem.qy;

import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;

/**
 * 试剂业务封装服务
 * Created by dy on 2016/7/2.
 */
public interface ChemReceiveQyBizService {

    /**
     * 添加试剂领用（企业）
     * @api 108024 领用（APP企业）
     * @param chemReagentDTO
     * @param terminal
     * @return
     */
    Integer addReceiveQy( ChemReagentDTO chemReagentDTO, String terminal );

}

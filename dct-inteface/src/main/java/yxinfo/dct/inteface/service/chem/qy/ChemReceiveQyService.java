package yxinfo.dct.inteface.service.chem.qy;

import yxinfo.dct.inteface.dto.chem.apply.biz.ChemAddReceiveRetDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;


/**
 * Created by dy on 2016/6/23.
 */
public interface ChemReceiveQyService {

    /**
     * 添加试剂领用基础方法（企业版）
     * @param chemReagentDTO
     * @return
     */
    ChemAddReceiveRetDTO addReceiveQy(ChemReagentDTO chemReagentDTO);

    /**
     * 获取试剂信息
     * @api 1080027 扫码获取试剂信息（企业版）
     * @param chemReagentDTO
     * @return
     */
    ChemReagentDTO getChemInfoOnReceiveQy(ChemReagentDTO chemReagentDTO);

}

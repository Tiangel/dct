package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;
import yxinfo.dct.inteface.dto.chem.reagent.biz.ChemAddReagentRetDTO;

/**
 * Created by dy on 2016/6/23.
 */
public interface ChemReagentBizService {

    /**
     * 试剂入库
     * @code 108014
     * @param chemReagentDTO
     * @param isPda 是否使用PAD扫码
     * @return
     */
    ChemAddReagentRetDTO addReagent( ChemReagentDTO chemReagentDTO, boolean isPda );

    /**
     * 作废试剂
     * @param rfCode
     * @return
     * @throws RFCODE不合法时,        DctException code=008001
     *         非库存中的试剂不能修改, DctException code=008036
     */
    int deleteReagent( String rfCode );
}

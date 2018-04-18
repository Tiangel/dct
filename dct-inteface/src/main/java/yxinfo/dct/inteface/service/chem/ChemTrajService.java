package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;
import yxinfo.dct.inteface.dto.chem.traj.ChemTrajDTO;
import yxinfo.dct.inteface.dto.equipment.EquEquipmentDTO;
import yxinfo.dct.inteface.dto.lab.LaboratoryDTO;
import yxinfo.dct.inteface.dto.wh.WhDTO;

import java.util.List;

/**
 * Created by dy on 2016/7/21.
 */
public interface ChemTrajService {

    /**
     * 分页查询试剂轨迹
     * @api 108030 试剂轨迹列表
     * @param chemTrajDTO
     * @return
     */
    PageDTO<List<ChemTrajDTO>> getTrajPage( PageDTO<ChemTrajDTO> chemTrajDTOPageDTO );

    /**
     * 查询试剂轨迹
     * @api 108042 根据ID获取试剂轨迹
     * @param chemTrajDTO
     * @return
     */
    List<ChemTrajDTO> getTrajList( ChemTrajDTO chemTrajDTO );

    /**
     * 按id获取试剂轨迹
     * @api
     * @param trajId
     * @return
     */
    ChemTrajDTO getTrajByKey( Integer trajId );

    /**
     * 获取某试剂指定轨迹的前一条轨迹
     * @param trajId 轨迹id
     * @param reagentId 试剂id
     * @return
     */
    ChemTrajDTO getPreviousOneTraj( Integer trajId, Integer reagentId );

    /**
     * 添加试剂轨迹
     * @param equNo 设备号
     * @param rfcode RF标签密文
     * @param staticId 静态资源id
     * @return
     */
    int addTraj( String equNo, String rfcode, Integer staticId );

    /**
     * 添加试剂轨迹
     * @param chemTrajDTO
     * @return
     */
    int addTraj( ChemTrajDTO chemTrajDTO );

    /**
     * 获取试剂轨迹（仓库）
     * @param reason 轨迹原由 ChemTrajReason
     * @param reagent 必传
     * @param equ 传递会设置设备信息
     * @param wh 必传
     * @param staticId 静态资源id
     * @return
     */
    ChemTrajDTO getTrajByWarehouse(
            Short reason, ChemReagentDTO reagent, EquEquipmentDTO equ, WhDTO wh, Integer staticId );

    /**
     * 获取试剂轨迹（实验室）
     * @param reason 轨迹原由 ChemTrajReason
     * @param reagent 必传
     * @param equ 传递会设置设备信息
     * @param lab 必传
     * @param staticId 静态资源id
     * @return
     */
    ChemTrajDTO getTrajByLaboratory(
            Short reason, ChemReagentDTO reagent, EquEquipmentDTO equ, LaboratoryDTO lab, Integer staticId );

}

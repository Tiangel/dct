package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.chem.reagent.ChemReagentDTO;
import yxinfo.dct.inteface.dto.chem.reagent.biz.ChemAddReagentRetDTO;
import yxinfo.dct.inteface.dto.chem.reagent.biz.ChemReagentSchDTO;

import java.util.List;

/**
 * Created by dy on 2016/6/23.
 */
public interface ChemReagentService {

    /**
     * 试剂列表
     * @api 108016 试剂列表
     * @param chemReagentPage
     * @return
     */
    PageDTO<List<ChemReagentDTO>> getReagentPage( PageDTO<ChemReagentSchDTO> chemReagentSchDTOPageDTO );

    /**
     * 混放预警试剂列表
     * @api 108041 混放预警试剂列表
     * @param chemReagentSchDTOPageDTO
     * @return
     */
    PageDTO<List<ChemReagentDTO>> getReagentForMixPage( PageDTO<ChemReagentSchDTO> chemReagentSchDTOPageDTO );

    /**
     * 试剂列表导出
     * @api 108032 试剂列表导出
     * @param chemAReceiveSchDTO
     * @param token
     * @return
     */
    String getReagentExport( ChemReagentSchDTO chemAReceiveSchDTO, String token );

    /**
     * 获取试剂信息
     * @api 108008 扫码获取试剂信息
     * @param chemReagentDTO
     * @return
     * @throws Exception
     */
    ChemReagentDTO getChemInfo( ChemReagentDTO chemReagentDTO );

    /**
     * 获取试剂信息
     * @api 108046 获取试剂信息（含采购人）
     * @param chemReagentDTO
     * @return
     * @throws Exception
     */
    ChemReagentDTO getChemInfoWithBelong( ChemReagentDTO chemReagentDTO );

    /**
     * 添加试剂
     * @param chemReagentDTO
     * @param isPda 是否使用PAD扫码
     * @return
     */
    ChemAddReagentRetDTO addReagent( ChemReagentDTO chemReagentDTO, boolean isPda );

    /**
     * 添加试剂（采购入库）
     * @param chemReagentDTO
     * @param isPda 是否使用PAD扫码
     * @return
     */
    Integer addReagentFromShop( ChemReagentDTO chemReagentDTO, boolean isPda );

    /**
     * 根据rfCode获取试剂
     * @param rfCode
     * @return 不存在则返回null
     */
    ChemReagentDTO getReagentByRfCode( String rfCode );

    /**
     * 根据rfCode获取试剂（行级锁）
     * @param rfCode
     * @return 不存在则返回null
     */
    ChemReagentDTO getReagentByRfCodeForUpdate( String rfCode );

    /**
     * 校验rfCode（二维码）
     * @param rfCodeEncry
     * @return 校验成功返回rfCode明码, 检验不通过返回null
     */
    String checkRfCodeQr( String rfCodeEncry );

    /**
     * 校验rfCode（RFID标签）
     * @param rfCodeEncry
     * @return 校验成功返回rfCode明码, 检验不通过返回null
     */
    String checkRfCodeRf( String rfCodeEncry );

    /**
     * 获取ChemReagentDTO
     * @param chemReagent
     * @return
     * @throws Exception
     */
    ChemReagentDTO getChemReagent( ChemReagentDTO chemReagentDTO );

    /**
     * 获取ChemReagentDTO
     * @api 108034 获取试剂信息（根据ID）
     * @param chemReagentId
     * @return
     * @throws Exception
     */
    ChemReagentDTO getChemReagentByKey( Integer chemReagentId );

}

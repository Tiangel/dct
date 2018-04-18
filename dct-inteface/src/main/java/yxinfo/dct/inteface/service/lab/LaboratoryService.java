package yxinfo.dct.inteface.service.lab;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.lab.LabManagerDTO;
import yxinfo.dct.inteface.dto.lab.LaboratoryDTO;
import yxinfo.dct.inteface.dto.lab.LaboratoryExportDTO;
import yxinfo.dct.inteface.dto.lab.LaboratoryImportDTO;

import java.util.List;
import java.util.Map;

/**
 * 实验室管理模块
 * <p>
 * Created by cy on 2016/6/18.
 */
public interface LaboratoryService {

    /**
     * 插入一条实验室记录
     *
     * @param record
     * @return
     */
    Integer addLab(LaboratoryDTO record);

    /**
     * 根据主鍵查询实验室记录
     *
     * @param labId
     * @return
     */
    LaboratoryDTO getLabByKey(Integer labId);

    /**
     * 分页查询实验室记录列表
     *
     * @param queryPage
     * @return
     */
    PageDTO<List<LaboratoryDTO>> getPageLabs(PageDTO<LaboratoryDTO> queryPage);

    /**
     * 删除实验室记录信息
     *
     * @param labId
     * @return
     */
    int deleteLaboratoryByKey(Integer labId);

    /**
     * 根据条件查询实验室信息
     *
     * @param laboratoryDTO
     * @return
     */
    List<LaboratoryDTO> getLaboratorys(LaboratoryDTO laboratoryDTO);

    /**
     * 更新实验室信息
     *
     * @param laboratoryDTO
     * @return
     */
    Integer updateLaboratory(LaboratoryDTO laboratoryDTO);

    /**
     * 根据实验室key查询实验室负责人
     *
     * @param labId
     * @return
     */
    List<LabManagerDTO> getLabManagersByLabId(Integer labId);

    /**
     * 删除实验室负责人记录
     *
     * @param id
     * @return
     */
    int deleteLabManagersByKey(Integer id);

    /**
     * 导出实验室信息
     *
     * @param dto
     * @return
     */
    Map<String, String> exportLab(LaboratoryExportDTO dto);

    /**
     * 导入验室信息
     *
     * @param laboratoryImportDTO
     * @return
     */
    Map<String, String> importLabs(LaboratoryImportDTO laboratoryImportDTO);

}

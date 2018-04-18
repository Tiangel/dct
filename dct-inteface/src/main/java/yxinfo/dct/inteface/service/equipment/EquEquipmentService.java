package yxinfo.dct.inteface.service.equipment;


import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.equipment.EquEquipmentDTO;
import java.util.List;

/**
 * Created by zh on 2016/6/22.
 */
public interface EquEquipmentService {

    /**
     * 根据主键删除设备信息
     * @param id
     * @return
     * @throws Exception
     */
    int deleteByEquEquipmentKey(Integer id);

    /**
     * 插入设备信息
     * @param equEquipmentDTO
     * @return
     * @throws Exception
     */
    int addEquEquipment(EquEquipmentDTO equEquipmentDTO);

    /**
     * 根据主键获取设备信息
     * @param id
     * @return
     * @throws Exception
     */
    EquEquipmentDTO getByEquEquipmentKey(Integer id);

    /**
     * 更新设备信息
     * @param equEquipmentDTO
     * @return
     * @throws Exception
     */
    int updateByEquEquipment(EquEquipmentDTO equEquipmentDTO);

    /**
     * 分页显示设备信息
     * @param queryPage
     * @return
     */
    PageDTO<List<EquEquipmentDTO>> getEquEquipments(PageDTO<EquEquipmentDTO> queryPage);

    /**
     * 根据设备编号查询设备信息
     * @param equEquipmentDTO
     * @return
     */
    EquEquipmentDTO getByEquEquipmentNo(EquEquipmentDTO equEquipmentDTO);

    /**
     * 根据条件查询设备集合
     * @param
     * @return
     */
    List<EquEquipmentDTO> getListByPurposeNoAndSiteId(String purposeNo, Integer siteId);
}

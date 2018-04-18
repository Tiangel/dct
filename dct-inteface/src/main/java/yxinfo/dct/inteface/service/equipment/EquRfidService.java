package yxinfo.dct.inteface.service.equipment;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.equipment.EquRfidDTO;

import java.util.List;

/**
 * Created by zh on 2016/6/22.
 */
public interface EquRfidService {

    /**
     * 根据主键删除RFID卡信息
     * @param id
     * @return
     * @throws Exception
     */
    int deleteByEquRfidKey(Integer id);

    /**
     * 插入RFID卡信息
     * @param equRfidDTO
     * @return
     * @throws Exception
     */
    int addEquRfid (EquRfidDTO equRfidDTO);

    /**
     * 根据主键获取RFID卡信息
     * @param id
     * @return
     * @throws Exception
     */
    EquRfidDTO getByEquRfidKey(Integer id);

    /**
     * 更新RFID卡信息
     * @param equRfidDTO
     * @return
     * @throws Exception
     */
    int updateByEquRfidFcode(EquRfidDTO equRfidDTO);

    /**
     * 分页查询RFID卡信息
     * @param queryPage
     * @return
     */
    PageDTO<List<EquRfidDTO>> getEquRfids(PageDTO<EquRfidDTO> queryPage);

    /**
     * 根据fcode获取RFID卡信息
     * @param fcode
     * @return
     */
    EquRfidDTO getByEquRfidFcode(String fcode);
}

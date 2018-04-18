package yxinfo.dct.inteface.service.warn;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.warn.WarnItemNoDTO;
import yxinfo.dct.inteface.dto.warn.WarnPersonDTO;
import yxinfo.dct.inteface.dto.warn.WarnRecordAndPersonsDTO;

import java.util.List;

/**
 * @author sxd
 * @date 2016/8/4 11:23
 */
public interface WarnPersonService {

    /**
     * 插入预警联系人
     * @param warnPersonDTO
     * @return
     */
    int insertWarnPerson(WarnPersonDTO warnPersonDTO);

    /**
     * 修改预警联系人
     * @param warnPersonDTO
     * @return
     */
    int updateWarnPerson(WarnPersonDTO warnPersonDTO);

    /**
     * 删除预警联系人
     *
     * @param id
     * @return
     */
    int deleteWarnPerson(Integer id);

    /**
     * 获取预警联系人列表
     * @param pageDTO
     * @return
     */
    PageDTO<List<WarnPersonDTO>> getWarnPersonPage(PageDTO<WarnPersonDTO> pageDTO);

    /**
     * 获取预警类型列表
     * @return
     */
    List<WarnItemNoDTO> getWarnItemNoDTOList();

    /**
     * 根据预警记录id获取预警记录信息及报警联系人
     * @param wrid
     * @return
     */
    WarnRecordAndPersonsDTO getWarnRecordAndPersonsByWrid(Integer wrid);
}

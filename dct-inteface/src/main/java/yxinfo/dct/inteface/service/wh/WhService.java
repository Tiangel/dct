package yxinfo.dct.inteface.service.wh;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.wh.WhDTO;

import java.util.List;

/**
 * 仓库管理
 * <p>
 * Created by cy on 2016/6/23.
 */
public interface WhService {

    /**
     * 添加仓库信息
     *
     * @param whDto
     * @return
     */
    Integer addWh(WhDTO whDto);

    /**
     * 更新仓库信息
     *
     * @param whDto
     * @return
     */
    Integer updateWh(WhDTO whDto);

    /**
     * 根据id删除仓库信息
     *
     * @param whId
     * @return
     */
    int deleteWhByKey(Integer whId);

    /**
     * 查询所有的仓库信息
     *
     * @param whDto
     * @return
     */
    List<WhDTO> getWhs(WhDTO whDto);

    /**
     * 分页查询仓库信息
     *
     * @param queryPage
     * @return
     */

    PageDTO<List<WhDTO>> getWhsPage(PageDTO<WhDTO> queryPage);

    /**
     * 根据id获取仓库
     *
     * @param whId
     * @return
     */

    WhDTO getWhByKey(Integer whId);

    /**
     * 获取id最小的仓库
     * @return
     */
    WhDTO getWhOnTop(WhDTO whDto);
}

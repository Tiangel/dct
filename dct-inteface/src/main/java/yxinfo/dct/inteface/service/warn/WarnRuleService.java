package yxinfo.dct.inteface.service.warn;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.warn.WarnRule4EnvironmentDTO;
import yxinfo.dct.inteface.dto.warn.WarnRuleDTO;
import yxinfo.dct.inteface.dto.warn.WarnRuleShow4EnvironmemtDTO;

import java.util.List;

/**
 * 预警规则service
 *
 * Created by cy on 2016/7/20.
 */
public interface WarnRuleService {

    /**
     * 保存预警规则记录
     *
     * @param record
     * @return 主键id
     */
    Integer addWarnRule(WarnRuleDTO record);

    /**
     * 获取所有的预警规则
     *
     * @return
     */
    List<WarnRuleDTO> getWarnRuleList(WarnRuleDTO record);

    /**
     * 分页获取预警规则
     *
     * @param queryPage
     * @return
     */
    PageDTO<List<WarnRuleDTO>> getPageWarnRuleList(PageDTO<WarnRuleDTO> queryPage);

    /**
     * 删除一条预警记录
     *
     * @param id
     * @return
     */
    int deleteWarnRuleByKey(Integer id);

    int insertWarnRule4Environment(WarnRule4EnvironmentDTO warnRule4EnvironmentDTO);

    PageDTO<List<WarnRuleShow4EnvironmemtDTO>> getWarnRuleShow4EnvPageList(PageDTO<WarnRuleShow4EnvironmemtDTO> pageDTO);
}

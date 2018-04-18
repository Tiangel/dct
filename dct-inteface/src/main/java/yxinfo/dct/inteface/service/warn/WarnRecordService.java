package yxinfo.dct.inteface.service.warn;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.warn.WarnEnvironmentDTO;
import yxinfo.dct.inteface.dto.warn.WarnRecordDTO;
import yxinfo.dct.inteface.dto.warn.WarnRecordLogDTO;
import yxinfo.dct.inteface.dto.warn.WarnShow4AppDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by ZH on 2016/7/20.
 */
public interface WarnRecordService {

    /**
     * 插入预警记录
     * @param warnRecordDTO
     * @return
     */
    Integer addWarnRecord(WarnRecordDTO warnRecordDTO);

    /**
     * 修改预警记录
     * @param warnRecordDTO
     * @return
     */
    int updateByWarnRecord(WarnRecordDTO warnRecordDTO);

    /**
     * 分页显示预警记录
     * @param queryPage
     * @return
     */
    PageDTO<List<WarnRecordDTO>> getWarnRecordDTOList(PageDTO<WarnRecordDTO> queryPage);

    /**
     * 插入预警记录日志
     * @param warnRecordLogDTO
     * @return
     */
    int addWarnRecordLog(WarnRecordLogDTO warnRecordLogDTO);

    /**
     * 根据记录ID查询预警记录日志
     * @param warnRecordLogDTO
     * @return
     */
    List<WarnRecordLogDTO> getWarnRecordLogDTOListByRecordKey(WarnRecordLogDTO warnRecordLogDTO);

    WarnRecordDTO getWarnRecordByItemAndId(String itemNo, String relId);

    /**
     * 预警处理(关闭或搁置)
     * @param warnRecordDTO
     * @return
     */
    Integer handleWarn(WarnRecordDTO warnRecordDTO);

    /**
     * app点击预警返回展示数据
     * @param warnShow4AppDTO
     * @return
     */
    List<WarnShow4AppDTO> warnShow4App(WarnShow4AppDTO warnShow4AppDTO);

    /**
     * app端点击预警信息返回预警分页列表，需传itemNo
     * @param pageDTO
     * @return
     */
    PageDTO<List<WarnRecordDTO>> getWarnRecordPage4App(PageDTO<WarnRecordDTO> pageDTO);


    PageDTO<List<WarnEnvironmentDTO>> getWarnEnvironmentPage(PageDTO<WarnEnvironmentDTO> pageDTO);

    /**
     * 添加预警后发布消息
     *
     * @param warnRecordDTO
     * @return
     */
    Integer addWarnRecordThenPubMsg(WarnRecordDTO warnRecordDTO);

    /**
     * 根据组织id获取预警项目
     *
     * @param orgId
     * @return
     */
    String getWarnItemNoByOrgId(Integer orgId);

    WarnRecordDTO getById(Integer id);

    /**
     * 插入预警记录并发送消息（）
     * @param warnRecordDTO
     * @return
     */
    Integer addWarnRecordAndPubMsg(WarnRecordDTO warnRecordDTO);

    /**
     * 修改预警记录并发送消息
     * @param warnRecordDTO
     * @return
     */
    Integer updateByWarnRecordAndPubMsg(WarnRecordDTO warnRecordDTO);

    List<WarnRecordDTO> getWarnRecordList(WarnRecordDTO dto);
}

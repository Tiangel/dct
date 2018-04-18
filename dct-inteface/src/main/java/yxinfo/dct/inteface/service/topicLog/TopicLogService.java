package yxinfo.dct.inteface.service.topicLog;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.topicLog.TopicLogDTO;
import yxinfo.dct.inteface.dto.topicLog.TopicLogNameDTO;

import java.util.List;

/**
 * 课题日志service
 *
 *
 * Created by cy on 2016/6/22.
 */
public interface TopicLogService {

    /**
     * 添加课题日志
     *
     * @param topicLog
     * @return
     */
    Integer addTopicLog(TopicLogDTO topicLog);

    /**
     * 查询所有的课题日志信息(只包含主要信息)
     *
     * @param topicLogDTO
     * @return
     */
    PageDTO<List<TopicLogNameDTO>> getTopicLogDTOList(PageDTO<TopicLogDTO> topicLogDTO);

    /**
     * 查询课题日志明细信息
     *
     * @param logId
     * @return
     */
    TopicLogDTO getTopicLogDTOByKey(Integer logId);

    /**
     * 更新修改课题日志
     *
     * @param topicLog
     * @return
     */
    TopicLogDTO updateTopicLog(TopicLogDTO topicLog);

    /**
     * 查询所有的课题日志信息
     *
     * @param topicLogDTO
     * @return
     */
    PageDTO<List<TopicLogDTO>> getTopicLogDTOLists(PageDTO<TopicLogDTO> topicLogDTO);

    /**
     * 课题日志导出
     *
     * @param dto
     * @return
     */
    String exportTopicLog(TopicLogDTO dto);
}

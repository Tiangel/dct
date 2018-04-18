package yxinfo.dct.inteface.service.vmon;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.vmon.VmonMonitorDTO;
import yxinfo.dct.inteface.dto.vmon.VmonPlaceDTO;

import java.util.List;

/**
 * Created by ZH on 2016/7/26.
 */
public interface VmonMonitorService {

    PageDTO<List<VmonMonitorDTO>> getMonitorList(PageDTO<VmonMonitorDTO> queryPage);

    /**
     * 根据视频监控地点返回设备
     * @param vmonPlaceDTO
     * @return
     */
    List<VmonMonitorDTO> getVmonMonitorList(VmonPlaceDTO vmonPlaceDTO);

    /**
     * 添加监控设备
     * @param vmonMonitorDTO
     * @return
     */
    Integer addVmonMonitor(VmonMonitorDTO vmonMonitorDTO);

    /**
     * 根据ID更新监控设备
     * @param vmonMonitorDTO
     * @return
     */
    Integer updateVmonMonitor(VmonMonitorDTO vmonMonitorDTO);

    /**
     * 根据ID删除监控设备
     * @param id
     * @return
     */
    Integer deleteVmonMonitor(Integer id);

    /**
     * 根据地址id获取监控设备
     * @param vmonPlaceDTO
     * @return
     */
    VmonMonitorDTO getVmonMonitorDTOByPlaceId ( VmonPlaceDTO vmonPlaceDTO );
}

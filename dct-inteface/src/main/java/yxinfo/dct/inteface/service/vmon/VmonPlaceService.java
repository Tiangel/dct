package yxinfo.dct.inteface.service.vmon;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.vmon.VmonPlaceDTO;

import java.util.List;

/**
 * Created by ZH on 2016/7/26.
 */
public interface VmonPlaceService {

    /**
     * 分页显示视频监控地点
     * @param queryPage
     * @return
     */
    PageDTO<List<VmonPlaceDTO>> getVmonPlaceList(PageDTO<VmonPlaceDTO> queryPage);

    /**
     * 新增监控地点
     * @param vmonPlaceDTO
     * @return
     */
    Integer addVmonPlace(VmonPlaceDTO vmonPlaceDTO);

    /**
     * 根据ID修改监控地点
     * @param vmonPlaceDTO
     * @return
     */
    Integer updataVmonPlace(VmonPlaceDTO vmonPlaceDTO);

    /**
     * 根据ID删除监控地点
     * @param id
     * @return
     */
    Integer deleteVmonPlaceByKey(Integer id);

    /**
     * 根据ID查询监控地点
     * @param id
     * @return
     */
    VmonPlaceDTO getVmonPlaceDTOByKey(Integer id);

    /**
     * 根据地点Id 用途获取监控地址
     * @param vmonPlaceDTO
     * @return
     */
    VmonPlaceDTO getVmonPlaceDTO( VmonPlaceDTO vmonPlaceDTO );
}

package yxinfo.dct.inteface.service.res;

import yxinfo.dct.inteface.dto.res.ResAreaDTO;

import java.util.List;

/**
 * Created by dy on 2016/8/16.
 */
public interface AreaService {

    /**
     * 根据id获取地区信息
     * @param id
     * @return
     */
    ResAreaDTO getAreaByKey( Integer id );

    /**
     * 获取第一级地区
     * @return
     */
    List<ResAreaDTO> getAreaLevel1();

    /**
     * 根据父id获取下一级的子地区信息
     * @param pid
     * @return
     */
    List<ResAreaDTO> getAreaByPid( Integer pid );

    /**
     * 根据id地区信息, 并递归获取它全部的子地区信息
     * @param id
     * @param level 递归深度
     * @return
     */
    ResAreaDTO getAreaTreeByKey( Integer id, Integer level );
}

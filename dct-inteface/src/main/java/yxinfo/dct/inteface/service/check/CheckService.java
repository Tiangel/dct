package yxinfo.dct.inteface.service.check;

import yxinfo.dct.inteface.dto.check.CheckChemTrajDTO;
import yxinfo.dct.inteface.dto.check.CheckRecodeDTO;
import yxinfo.dct.inteface.dto.check.CheckRecodeDetailDTO;
import yxinfo.dct.inteface.dto.check.CheckSubmitDTO;

import java.util.List;

/**
 * Created by sxd on 2016/7/20.
 */
public interface CheckService {

    /**
     * 提交盘点结果
     * @param checkSubmitDTO
     */
    CheckRecodeDTO check(CheckSubmitDTO checkSubmitDTO);

    /**
     * 根据状态查询盘点列表
     * @param status
     * @return
     */
    List<CheckRecodeDTO> getCheckRecodeList(String status);

    /**
     * 获得预警详情
     * @param checkRecodeId 盘点记录id
     * @return
     */
    CheckRecodeDetailDTO getCheckRecode(Integer checkRecodeId);

    Integer updateCheckRecode(CheckRecodeDTO checkRecodeDTO);

    /**
     * 获取盘点试剂轨迹 115002
     * @param checkChemTraj checkChemId
     * @return
     */
    List<CheckChemTrajDTO> getCheckChemTraj(CheckChemTrajDTO checkChemTraj);
}

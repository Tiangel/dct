package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.chem.check.*;

import java.util.List;

/**
 * 试剂检查
 * Created by dy on 2016/7/20.
 */
public interface ChemCheckService {

    /**
     * 库存盘点
     * @param rfCodes RFID码
     * @param whId 仓库id
     * @param serial 盘点单号
     * @return
     */
    ChemCheckStockRetDTO checkStock( List<String> rfCodes, Integer whId, String serial );

    /**
     * 持有数限制检查
     * @param orgId 组织id
     * @param chemId 化学品id
     * @param lmt 持有限制
     * @return
     */
    List<ChemHoldingsDTO> checkHoldingsReagent( int orgId, int chemId, int lmt );

    /**
     * 领用后检查轨迹
     * @param orgId 组织id
     * @param lmt 时间限制（秒）
     * @return
     */
    List<ChemNoTrajDTO> checkTrajAfterReceive( int orgId, int lmt );

    /**
     * 回收异常检查
     * @param orgId 组织id
     * @return
     */
    List<ChemRecycleAbnorDTO> checkRecycle( int orgId );

    /**
     * 关闭回收异常
     * @param reagentId 试剂id
     * @return
     */
    int closeRecycleAbnor( int reagentId );

    /**
     * 回收使用量检查
     * @param orgId 组织id
     * @return apply 申领的容量
     *         recycle.used 实际用量
     *         recycle.member 回收人
     */
    List<ChemRecycleAbnorDTO> checkRecycleUsed( int orgId );

    /**
     * 关闭回收使用量异常
     * @param recycleId 回收记录id
     * @return
     */
    int closeRecycleUsedAbnor( int recycleId );

    /**
     * 混放预警
     * @param orgId
     * @param categoryId1
     * @param categoryId2
     * @return
     */
    List<ChemMixDTO> checkMix( int orgId, int categoryId1, int categoryId2 );

}

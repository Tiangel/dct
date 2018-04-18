package yxinfo.dct.inteface.service.chem;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.approve.ApproveRecodeDTO;
import yxinfo.dct.inteface.dto.chem.apply.ChemApplyReagentDTO;
import yxinfo.dct.inteface.dto.chem.apply.ChemApplyReceiveDTO;
import yxinfo.dct.inteface.dto.chem.apply.biz.ChemAReceiveDetailDTO;
import yxinfo.dct.inteface.dto.chem.apply.biz.ChemAReceiveGetDTO;
import yxinfo.dct.inteface.dto.chem.apply.biz.ChemAReceiveSchDTO;

import java.util.List;

/**
 * Created by dy on 2016/6/22.
 */
public interface ChemApplyService {

    /**
     * 添加化学试剂领取申请基础方法（学校）
     * @param chemApplyReceiveDTO 送approveMemberId则自动提交至第一审核节点
     * @return
     * @throws Exception
     */
    ApproveRecodeDTO addApplyReceive( ChemApplyReceiveDTO chemApplyReceiveDTO );

    /**
     * 化学试剂领取申请分页查询
     * @api 108001 领用记录列表
     * @param chemApplyReceivePage
     * @return
     * @throws Exception
     */
    PageDTO<List<ChemApplyReceiveDTO>> getAplyReceivePage( PageDTO<ChemApplyReceiveDTO> chemApplyReceivePage );

    /**
     * 化学试剂领取申请分页查询(扩展)
     * @api 108019 申领记录列表（扩展搜索）
     * @param chemAReceiveSchDTOPageDTO
     * @return
     */
    PageDTO<List<ChemApplyReceiveDTO>> getAplyReceivePageEx( PageDTO<ChemAReceiveSchDTO> chemAReceiveSchDTOPageDTO );

    /**
     * 化学试剂领取申请查询
     * @param applyReceiveId
     * @return
     * @throws Exception
     */
    ChemApplyReceiveDTO getAplyReceive( Integer applyReceiveId );

    /**
     * 化学试剂领取申请查询(没有试剂信息)
     * @param applyReceiveId
     * @return
     * @throws Exception
     */
    ChemApplyReceiveDTO getAplyReceiveNoReagent( Integer applyReceiveId );

    /**
     * 化学试剂领取申请查询详情
     * @api 108002 领用记录详情
     * @param chemAReceiveGet
     * @return
     * @throws Exception
     */
    ChemAReceiveDetailDTO getAplyReceiveDetail( ChemAReceiveGetDTO chemAReceiveGetDTO );

    /**
     * 申请领取的化学试剂查询
     *      查询对应的化学品以及领取记录
     * @param applyReceiveId
     * @return
     * @throws Exception
     */
    List<ChemApplyReagentDTO> getApplyReagentDetailList( Integer applyReceiveId );

    /**
     * 申请领取的化学试剂查询
     *      只查询对应的化学品
     * @param applyReceiveId
     * @return
     * @throws Exception
     */
    List<ChemApplyReagentDTO> getApplyReagentList( Integer applyReceiveId );

    /**
     * 申领记录列表导出
     * @api 108029 申领记录列表导出
     * @param chemAReceiveSchDTO
     * @param token 用户accessToken
     * @return Excel静态资源id
     */
    String aplyReceiveExport( ChemAReceiveSchDTO chemAReceiveSchDTO, String token );

}

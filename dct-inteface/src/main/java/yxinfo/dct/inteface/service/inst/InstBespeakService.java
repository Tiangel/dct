package yxinfo.dct.inteface.service.inst;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.approve.ApproveNodeDTO;
import yxinfo.dct.inteface.dto.approve.biz.ApproveNodeRetDTO;
import yxinfo.dct.inteface.dto.inst.BespeakInstDTO;
import yxinfo.dct.inteface.dto.inst.InstBespeakApproveDTO;
import yxinfo.dct.inteface.dto.inst.InstBespeakDTO;
import yxinfo.dct.inteface.dto.inst.InstBespeakProDTO;

import java.util.List;

/**
 * 仪器预约service
 * Created by sxd on 2016/7/14.
 */
public interface InstBespeakService {

    /**
     * 获取仪器预约列表
     * @param pageDTO memberId: 成员id, orgId: 组织id， status：1待使用， 2审核中, 3全部
     * @return
     */
    PageDTO<List<InstBespeakDTO>> getInstBespeakPageList(PageDTO<InstBespeakDTO> pageDTO);

    /**
     * 获取仪器预约详情
     * @param approveDTO 仪器预约(可能包含审核信息)
     * @return
     */
    InstBespeakApproveDTO getInstBespeakDetail(InstBespeakApproveDTO approveDTO);

    /**
     * 添加预约信息
     * @param instBespeakDTO
     * @return
     */
    InstBespeakDTO addInstBespeak(InstBespeakDTO instBespeakDTO, String terminal);

    /**
     * 修改仪器使用时间()
     * @param bespeakInstDTO instId: 仪器id,instBskId: 仪器预约id
     * @return
     */
    BespeakInstDTO updateUseTime(BespeakInstDTO bespeakInstDTO);

    /**
     * 仪器预约审核
     * @param approveNodeDTO
     * @return
     */
    ApproveNodeRetDTO instBespeakApprove(ApproveNodeDTO approveNodeDTO, String terminal);

    /**
     * 根据仪器预约id获取仪器预约信息和其项目信息
     * @param instBskId
     * @return
     */
    InstBespeakProDTO getInstBespeakAndProByInstBskId(Integer instBskId);

    /**
     * 获取仪器预约列表(后台调用)
     * @param pageDTO
     * @return
     */
    PageDTO<List<InstBespeakDTO>> getInstBespeakBackendPageList(PageDTO<InstBespeakDTO> pageDTO);

    /**
     * 获取一个实验室一周的实验项目
     * @param labId
     * @return
     */
    List<String> getWeekOfProjectnamekListByLabId(Integer labId);

}

package yxinfo.dct.inteface.service.approve;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.approve.ApproveNodeDTO;
import yxinfo.dct.inteface.dto.approve.biz.ApproveNodeRetDTO;
import yxinfo.dct.inteface.dto.approve.biz.ApproveRdSearchDTO;
import yxinfo.dct.inteface.dto.approve.ApproveRecodeDTO;

import java.util.List;

/**
 * 审核记录服务接口
 * Created by dy on 2016/6/21.
 */
public interface ApproveRecodeService {

    /**
     * 添加审核记录
     *      添加一条审核记录, 及其对应的在提交人处的审核记录节点（approveNode）及额外信息表数据
     * @param approveRecodeDTO
     * @return 审核记录id
     * @throws Exception
     */
    Integer addApproveRecode( ApproveRecodeDTO approveRecodeDTO );

    /**
     * 添加审核节点
     *      添加一条审核记录节点, 并根据业务逻辑修改审核记录及额外信息表数据
     *      memberId         审核人id
     *      status           状态（s审核通过, f审核不通过）
     *      approveRecodeId  审核流程记录id
     *      onMemberId       下一节点用户id *选填, 自由模式必填; 有值时优先采用作为审核下一节点位置
     * @param approveNodeDTO
     * @return 审核结果
     * @throws Exception
     */
    ApproveNodeRetDTO addApproveNode( ApproveNodeDTO approveNodeDTO );

    /**
     * 提交审核记录(添加审核记录并自动提交到第一个方案节点)
     *      itemNo          审批项目编号
     *      orgId           提交人组织id
     *      submitMemberId  提交人id
     *      onMemberId      下一步审核人用户id
     *      extraMsgId      额外信息id
     * @param approveRecodeDTO
     * @return 审核记录id
     * @throws Exception
     */
    ApproveRecodeDTO submitApprove( ApproveRecodeDTO approveRecodeDTO );

    /**
     * 提交审核记录(添加审核记录并自动提交到第一个方案节点)
     * <p>业务逻辑同<code>ApproveRecodeDTO submitApprove( ApproveRecodeDTO approveRecodeDTO ), 此方法为批量处理<code/><p/>
     * @param approveRecodeDTOs
     * @return
     */
    List<ApproveRecodeDTO> submitApproveBatch( List<ApproveRecodeDTO> approveRecodeDTOs );

    /**
     * 待审核记录分页查询
     * @api 109001 待审核记录列表
     * @param approveRdSearchPage
     * @return
     * @throws Exception
     */
    PageDTO<List<ApproveRecodeDTO>> getWaitApprovePage( PageDTO<ApproveRdSearchDTO> approveRdSearchPage );

    /**
     * 待审核记录数量
     * @api 109003 获取待审核记录数量
     * @param approveRdSearchDTO
     * @return
     */
    Integer getWaitApproveCount( ApproveRdSearchDTO approveRdSearchDTO );

    /**
     * 历史审核记录分页查询
     * @api 109002 历史审核记录列表
     * @param approveRdSearchPage
     * @return
     * @throws Exception
     */
    PageDTO<List<ApproveRecodeDTO>> getHistoryApprovePage( PageDTO<ApproveRdSearchDTO> approveRdSearchPage );

    /**
     * 获取审核记录
     *      必传approveRecodeId, 或者itemNo&extMsgId
     * @param approveRecodeId 审核记录id
     * @param itemNo 审核项目编号
     * @param extMsgId 额外信息id
     * @return 返回审核记录、审核记录对应的方案以及审核流程节点记录
     * @throws Exception
     */
    ApproveRecodeDTO getApproveRecode( Integer approveRecodeId, String itemNo, Integer extMsgId );

    /**
     * 获取用户的角色id列表
     * @param memberId
     * @param orgId
     * @return
     */
    List<Integer> getMemberRoleIds( Integer memberId, Integer orgId );

    /**
     * 获取用户的组id列表
     * @param memberId
     * @param orgId
     * @return
     */
    List<Integer> getMemberGroupIds( Integer memberId, Integer orgId );

    /**
     * 获取用户的标签id列表
     * @param memberId
     * @param orgId
     * @return
     */
    List<Integer> getMemberTagIds( Integer memberId, Integer orgId );
}

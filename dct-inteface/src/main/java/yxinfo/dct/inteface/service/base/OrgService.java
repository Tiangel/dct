package yxinfo.dct.inteface.service.base;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.base.OrgDTO;

import java.util.List;

/**
 * Created by hanley on 2016/6/21.
 *
 * 组织架构服务
 *
 */
public interface OrgService {

    /**
     * 添加组织
     * @param orgDTO
     * @return  添加成功返回主键
     */
    Integer addOrg( OrgDTO orgDTO );

    /**
     * 添加成员到组织
     * @param memberId
     * @param orgId
     * @return
     */
    Integer addMember( Integer memberId, Integer orgId );

    /**
     * 根据id获取组织详情
     * <p>同时获取组织定制信息<p/>
     * @param orgId
     * @return
     */
    List<OrgDTO> getOrgDetailInId( List<Integer> orgIds );

    /**
     * 获取用户所有组织
     * <p>同时获取组织定制信息<p/>
     * @api 100007 获取用户所有组织
     * @param memberId
     * @return
     */
    List<OrgDTO> getOrgIdByMember( Integer memberId );

    /**
     * 仅获取用户的组织id
     * @param memberId
     * @return
     */
    List<Integer> getOrgIdByMemberId( Integer memberId );

    /**
     * 分页搜索所有组织
     * @api 100016 获取组织列表
     * @param orgDTOPageDTO
     * @return
     */
    PageDTO<List<OrgDTO>> getOrgAllPage( PageDTO<OrgDTO> orgDTOPageDTO );
}

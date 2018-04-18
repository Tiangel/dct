package yxinfo.dct.inteface.service.base;

import yxinfo.dct.inteface.dto.base.GroupDTO;

import java.util.List;

/**
 * Created by hanley on 2016/6/22.
 *
 * 成员组管理服务
 */
public interface GroupService {

    /**
     * 添加成员组
     * @param groupDTO
     * @return
     */
    Integer addGroup( GroupDTO groupDTO );

    /**
     * 添加成员到组
     * @param memberId
     * @param groupId
     * @param orgId
     * @return
     */
    Integer addMember( Integer memberId, Integer groupId, Integer orgId );

    /**
     * 获取用户组
     * @param memberId 用户
     * @param orgId 所属组织
     * @return
     */
    List<GroupDTO> getGroupByMember( Integer memberId, Integer orgId );

    /**
     * 获取用户组id
     * @param memberId  用户
     * @param orgId 所属组织
     * @return
     */
    List<Integer> getGroupIdByMember( Integer memberId, Integer orgId );

    /**
     * 获取orgId下所有管理组
     * @author sxd 2016/7/6
     * @param orgId
     * @return
     */
    List<GroupDTO> getGroupByOrg( Integer orgId );

    /**
     * 根据id获取成员组
     * @author sxd 2016/7/6
     * @param groupId
     * @return
     */
    GroupDTO getGroupById( Integer groupId );

    /**
     * 修改成员组
     * @author sxd 2016/7/7
     * @param groupDTO
     * @return
     */
    Integer updateGroup( GroupDTO groupDTO );

    /**
     * 删除group
     * @author sxd 2016/7/7
     * @param groupId
     * @return
     */
    Integer deleteGroup( Integer groupId );
}

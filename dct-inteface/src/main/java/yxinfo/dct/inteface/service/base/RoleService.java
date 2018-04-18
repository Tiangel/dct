package yxinfo.dct.inteface.service.base;

import yxinfo.dct.inteface.dto.base.RoleDTO;

import java.util.List;

/**
 * Created by hanley on 2016/6/23.
 *
 * 成员角色管理
 */
public interface RoleService {

    /**
     * 添加角色
     * @param roleDTO
     * @return
     */
    Integer addRole( RoleDTO roleDTO );

    /**
     * 获取成员所有角色
     * @api 100008 获取用户所有角色
     * @param memberId
     * @param orgId
     * @return
     */
    List<RoleDTO> getRoleByMember( Integer memberId, Integer orgId );

    /**
     * 获取成员所有角色id
     * @param memberId
     * @param orgId
     * @return
     */
    List<Integer> getRoleIdByMember( Integer memberId, Integer orgId );
}

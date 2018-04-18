package yxinfo.dct.service.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import yxinfo.dct.framework.validation.annotation.DctValid;
import yxinfo.dct.framework.validation.annotation.DctValidator;
import yxinfo.dct.inteface.dto.base.RoleDTO;
import yxinfo.dct.inteface.service.base.RoleService;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.service.base.dal.RoleDal;
import yxinfo.dct.service.base.dao.model.SysMemberOrgRole;
import yxinfo.dct.service.base.dao.model.SysMemberOrgRoleExample;
import yxinfo.dct.service.base.dao.model.SysRole;
import yxinfo.dct.service.base.dao.model.SysRoleExample;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanley on 2016/6/24.
 */
@Component
@Service( version = "1.0.0", owner = "dy" )
public class RoleServiceImpl implements RoleService {

    @DctValidator
    public Integer addRole( @DctValid( groups = Add.class) RoleDTO roleDTO ) {
        return roleDal.insertSelective( roleDTO.toModel( SysRole.class ) );
    }

    public List<RoleDTO> getRoleByMember( Integer memberId, Integer orgId ) {
        SysMemberOrgRoleExample example = new SysMemberOrgRoleExample();
        example.createCriteria().andMemberIdEqualTo( memberId ).andOrgIdEqualTo( orgId );
        List<SysMemberOrgRole> memberOrgRoles = roleDal.selectByExample( example );
        List<RoleDTO> roleList = null;
        if ( !CollectionUtils.isEmpty( memberOrgRoles ) ) {
            List<Integer> roleIds = new ArrayList<Integer>( memberOrgRoles.size() );
            for ( SysMemberOrgRole sysMemberOrgRole : memberOrgRoles ) {
                roleIds.add( sysMemberOrgRole.getRoleId() );
            }
            SysRoleExample roleExample = new SysRoleExample();
            roleExample.createCriteria().andIdIn( roleIds );
            List<SysRole> sysRoleList = roleDal.selectByExample( roleExample );
            if ( !CollectionUtils.isEmpty( sysRoleList ) ) {
                roleList = new ArrayList<RoleDTO>( sysRoleList.size() );
                for ( SysRole sysRole : sysRoleList ) {
                    RoleDTO roleDTO = new RoleDTO().toDTO( sysRole );
                    roleList.add( roleDTO );
                }
            }
        }
        return roleList;
    }

    public List<Integer> getRoleIdByMember( Integer memberId, Integer orgId ) {
        SysMemberOrgRoleExample example = new SysMemberOrgRoleExample();
        example.createCriteria().andMemberIdEqualTo( memberId ).andOrgIdEqualTo( orgId );
        List<SysMemberOrgRole> memberOrgRoles = roleDal.selectByExample( example );
        if ( !CollectionUtils.isEmpty( memberOrgRoles ) ) {
            List<Integer> roleIds = new ArrayList<Integer>( memberOrgRoles.size() );
            for ( SysMemberOrgRole sysMemberOrgRole : memberOrgRoles ) {
                roleIds.add( sysMemberOrgRole.getRoleId() );
            }
            return roleIds;
        }
        return null;
    }

    @Resource private RoleDal roleDal;
}

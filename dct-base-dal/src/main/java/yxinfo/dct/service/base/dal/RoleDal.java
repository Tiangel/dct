package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysMemberOrgRoleMapper;
import yxinfo.dct.service.base.dao.mapper.SysRoleMapper;
import yxinfo.dct.service.base.dao.model.SysMemberOrgRole;
import yxinfo.dct.service.base.dao.model.SysMemberOrgRoleExample;
import yxinfo.dct.service.base.dao.model.SysRole;
import yxinfo.dct.service.base.dao.model.SysRoleExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hanley on 2016/6/25.
 */
@Component
public class RoleDal {

    public int insertSelective( SysRole record ) {
        return sysRoleMapper.insertSelective( record );
    }

    public int insertSelective( SysMemberOrgRole record ) {
        return sysMemberOrgRoleMapper.insertSelective( record );
    }

    public  List<SysRole> selectByExample( SysRoleExample example ) {
        return sysRoleMapper.selectByExample( example );
    }

    public List<SysMemberOrgRole> selectByExample( SysMemberOrgRoleExample example ) {
        return sysMemberOrgRoleMapper.selectByExample( example );
    }

    @Resource private SysRoleMapper sysRoleMapper;
    @Resource private SysMemberOrgRoleMapper sysMemberOrgRoleMapper;
}

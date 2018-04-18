package yxinfo.dct.service.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import yxinfo.dct.inteface.dto.base.AppMenuDTO;
import yxinfo.dct.inteface.dto.base.OrgDTO;
import yxinfo.dct.inteface.service.base.AppService;
import yxinfo.dct.inteface.service.base.RoleService;
import yxinfo.dct.service.base.dal.AppDal;
import yxinfo.dct.service.base.dao.model.SysAppMenu;
import yxinfo.dct.service.base.dao.model.SysAppMenuExample;
import yxinfo.dct.service.base.dao.model.SysRoleAppMenu;
import yxinfo.dct.service.base.dao.model.SysRoleAppMenuExample;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanley on 2016/6/23.
 */
@Component
@Service( version = "1.0.0", owner = "wh" )
public class AppServiceImpl implements AppService {

    public List<AppMenuDTO> getMenu( OrgDTO orgDTO ) {

        List<AppMenuDTO> appMenuDTOList = null;
        // ~获取成员角色对应的App菜单
        SysRoleAppMenuExample roleAppMenuExample = new SysRoleAppMenuExample();
        SysRoleAppMenuExample.Criteria roleAppMenuCriteria = roleAppMenuExample.createCriteria();
        if ( !CollectionUtils.isEmpty( orgDTO.getRoleIds() ) ) {
            roleAppMenuCriteria.andRoleIdIn( orgDTO.getRoleIds() );
        }
        /*if ( orgDTO.getRoleId() != null ) { // TODO 兼容,下个版本去掉
            roleAppMenuCriteria.andRoleIdEqualTo( orgDTO.getRoleId() );
        }
*/
        roleAppMenuExample.setOrderByClause( "sort" );
        List<SysRoleAppMenu> roleAppMenuList =  appDal.selectByExample( roleAppMenuExample );
        if ( CollectionUtils.isEmpty( roleAppMenuList ) ) return null;

        List<Integer> amIds = new ArrayList<Integer>( roleAppMenuList.size() );
        for ( SysRoleAppMenu sysRoleAppMenu : roleAppMenuList ) {
            amIds.add( sysRoleAppMenu.getAmId() );
        }
        SysAppMenuExample appMenuExample = new SysAppMenuExample();
        appMenuExample.createCriteria().andIdIn( amIds );
        // ~获取App菜单
        List<SysAppMenu> sysAppMenuList = appDal.selectByExample( appMenuExample );
        if ( !CollectionUtils.isEmpty( sysAppMenuList ) ) {
            appMenuDTOList = new ArrayList<AppMenuDTO>( sysAppMenuList.size() );
            for ( SysRoleAppMenu sysRoleAppMenu : roleAppMenuList ) {
                for ( SysAppMenu sysAppMenu : sysAppMenuList ) {
                    if ( sysAppMenu.getId().equals( sysRoleAppMenu.getAmId() ) ) {
                        AppMenuDTO appMenuDTO = new AppMenuDTO().toDTO( sysAppMenu );
                        appMenuDTOList.add( appMenuDTO );
                        break;
                    }
                }
            }
        }
        return appMenuDTOList;
    }

    @Resource private RoleService roleService;
    @Resource private AppDal appDal;
}

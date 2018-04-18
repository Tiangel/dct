package yxinfo.dct.service.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import yxinfo.dct.framework.exception.DctException;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.dto.base.MenuDTO;
import yxinfo.dct.inteface.dto.base.RoleDTO;
import yxinfo.dct.inteface.service.base.ManageService;
import yxinfo.dct.inteface.service.base.RoleService;
import yxinfo.dct.service.base.dal.ManageDal;
import yxinfo.dct.service.base.dao.model.SysMenu;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by hanley on 2016/6/30.
 */
@Component
@Service( version = "1.0.0", owner = "wh" )
public class ManageServiceImpl implements ManageService {

    public List<MenuDTO> getMenu( MemberDTO memberDTO ) {

        if ( memberDTO == null ) throw new DctException( ErrorCode.PARAM_NOT_NULL );

        // ~获取角色列表
        List<RoleDTO> roleList = roleService.getRoleByMember( memberDTO.getId(), memberDTO.getOrgId() );
        if ( CollectionUtils.isEmpty(roleList) ) return null;
        List<Integer> roleIds = new ArrayList<Integer>( roleList.size() );
        for ( RoleDTO roleDTO : roleList ) {
            roleIds.add( roleDTO.getId() );
        }

        // ~获取菜单列表
        List<SysMenu> menuList = manageDal.selectMenuByRole( roleIds );
        List<MenuDTO> menuDTOList = null;
        if ( !CollectionUtils.isEmpty( menuList ) ) {
            menuDTOList = new ArrayList<MenuDTO>( menuList.size() );
            Map<Integer, MenuDTO> temp = new HashMap<Integer, MenuDTO>();
            // ~拼接二级分类菜单结构
            for ( SysMenu menu : menuList ) {
                MenuDTO menuDTO, childDTO;
                if ( menu.getPid() == null ) {
                    // ~父级
                    menuDTO = new MenuDTO().toDTO( menu );
                    menuDTOList.add( menuDTO );
                    temp.put( menu.getId(), menuDTO );
                } else {
                    // ~子级
                    menuDTO = temp.get( menu.getPid() );
                    if ( menuDTO == null ) {
                        // ~没有父级子级作为父级
                        menuDTO = new MenuDTO().toDTO( menu );
                        menuDTOList.add( menuDTO );
                        temp.put( menuDTO.getId(), menuDTO );
                    } else {
                        // ~放入父级
                        childDTO = new MenuDTO().toDTO( menu );
                        List<MenuDTO> childs = menuDTO.getChilds();
                        if ( childs == null ) {
                            childs = new ArrayList<MenuDTO>();
                            childs.add( childDTO );
                            menuDTO.setChilds( childs );
                        } else {
                            childs.add( childDTO );
                        }
                    }
                }
            }
        }
        return menuDTOList;
    }

    @Resource private RoleService roleService;
    @Resource private ManageDal manageDal;
}

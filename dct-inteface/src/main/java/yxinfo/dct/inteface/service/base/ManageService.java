package yxinfo.dct.inteface.service.base;

import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.dto.base.MenuDTO;

import java.util.List;

/**
 * Created by hanley on 2016/6/30.
 * PC后台管理管理
 */
public interface ManageService {

    /**
     * 获取用户后台的菜单项
     * @param memberDTO
     * @return
     */
    List<MenuDTO> getMenu( MemberDTO memberDTO );

}

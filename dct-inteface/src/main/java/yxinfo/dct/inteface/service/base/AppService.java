package yxinfo.dct.inteface.service.base;

import yxinfo.dct.inteface.dto.base.AppMenuDTO;
import yxinfo.dct.inteface.dto.base.OrgDTO;

import java.util.List;

/**
 * Created by hanley on 2016/6/23.
 *
 * App管理服务
 */
public interface AppService {

    /**
     * 获取用户可见APP菜单
     * @api 100013 APP首页菜单
     * @param orgDTO
     * @return
     */
    List<AppMenuDTO> getMenu( OrgDTO orgDTO );

}

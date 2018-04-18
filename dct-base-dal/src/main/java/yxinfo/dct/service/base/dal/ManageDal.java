package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysMenuMapperEx;
import yxinfo.dct.service.base.dao.model.SysMenu;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hanley on 2016/6/30.
 */
@Component
public class ManageDal {

    @Resource
    private SysMenuMapperEx sysMenuMapperEx;

    public List<SysMenu> selectMenuByRole( List<Integer> roleIds) {
        return sysMenuMapperEx.selectMenuByRole(roleIds);
    }

}

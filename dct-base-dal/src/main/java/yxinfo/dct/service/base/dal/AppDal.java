package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysAppMenuMapper;
import yxinfo.dct.service.base.dao.mapper.SysRoleAppMenuMapper;
import yxinfo.dct.service.base.dao.model.SysAppMenu;
import yxinfo.dct.service.base.dao.model.SysAppMenuExample;
import yxinfo.dct.service.base.dao.model.SysRoleAppMenu;
import yxinfo.dct.service.base.dao.model.SysRoleAppMenuExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hanley on 2016/6/23.
 */
@Component
public class AppDal {

    @Resource
    private SysRoleAppMenuMapper sysRoleAppMenuMapper;

    @Resource
    private SysAppMenuMapper sysAppMenuMapper;


    public List<SysRoleAppMenu> selectByExample(SysRoleAppMenuExample example) {
        return sysRoleAppMenuMapper.selectByExample(example);
    }

    public List<SysAppMenu> selectByExample(SysAppMenuExample example) {
        return sysAppMenuMapper.selectByExample(example);
    }

}

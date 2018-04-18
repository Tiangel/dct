package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysOrgCustomizedMapper;
import yxinfo.dct.service.base.dao.model.SysOrgCustomized;

import javax.annotation.Resource;

@Component
public class OrgCustomizedDal {

    public SysOrgCustomized selectByPrimaryKey( Integer orgId ) {
        return sysOrgCustomizedMapper.selectByPrimaryKey( orgId );
    }

    @Resource private SysOrgCustomizedMapper sysOrgCustomizedMapper;
}
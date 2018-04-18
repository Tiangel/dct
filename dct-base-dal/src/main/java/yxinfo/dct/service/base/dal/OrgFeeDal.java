package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysOrgFeeMapper;
import yxinfo.dct.service.base.dao.model.SysOrgFee;
import yxinfo.dct.service.base.dao.model.SysOrgFeeKey;

import javax.annotation.Resource;

@Component
public class OrgFeeDal {

    @Resource private SysOrgFeeMapper sysOrgFeeMapper;

    public SysOrgFee selectByPrimaryKey( SysOrgFeeKey key ) {
        return sysOrgFeeMapper.selectByPrimaryKey( key );
    }
}
package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysOrgBopMapper;
import yxinfo.dct.service.base.dao.model.SysOrgBop;

import javax.annotation.Resource;

@Component
public class OrgBopDal {

    @Resource private SysOrgBopMapper sysOrgBopMapper;

    public int insertSelective( SysOrgBop record ) {
        return sysOrgBopMapper.insertSelective( record );
    }
}
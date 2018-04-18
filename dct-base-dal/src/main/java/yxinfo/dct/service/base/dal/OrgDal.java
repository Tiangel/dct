package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysMemberOrgMapper;
import yxinfo.dct.service.base.dao.mapper.SysOrgMapper;
import yxinfo.dct.service.base.dao.mapper.SysOrgMapperEx;
import yxinfo.dct.service.base.dao.model.SysMemberOrg;
import yxinfo.dct.service.base.dao.model.SysMemberOrgExample;
import yxinfo.dct.service.base.dao.model.SysOrg;
import yxinfo.dct.service.base.dao.model.SysOrgExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hanley on 2016/6/21.
 */
@Component
public class OrgDal {

    @Resource private SysOrgMapper sysOrgMapper;
    @Resource private SysMemberOrgMapper sysMemberOrgMapper;
    @Resource private SysOrgMapperEx sysOrgMapperEx;

    public int plusOrgBal( int orgId, int amt ) {
        return sysOrgMapperEx.plusOrgBal( orgId, amt );
    }

    public SysOrg selectByPrimaryKey(Integer id) {
        return sysOrgMapper.selectByPrimaryKey(id);
    }

    public int insertSelective(SysOrg record) {
        return sysOrgMapper.insertSelective(record);
    }

    public int insertSelective(SysMemberOrg record) {
        return sysMemberOrgMapper.insertSelective(record);
    }

    public List<SysMemberOrg> selectByExample(SysMemberOrgExample example) {
        return sysMemberOrgMapper.selectByExample(example);
    }

    public  List<SysOrg> selectByExample(SysOrgExample example) {
        return sysOrgMapper.selectByExample(example);
    }
}

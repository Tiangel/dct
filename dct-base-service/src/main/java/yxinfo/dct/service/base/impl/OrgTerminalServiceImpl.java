package yxinfo.dct.service.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import yxinfo.dct.inteface.dto.base.OrgTerminalDTO;
import yxinfo.dct.inteface.service.base.OrgTerminalService;
import yxinfo.dct.service.base.dal.OrgTerminalDal;
import yxinfo.dct.service.base.dao.model.SysOrgTerminal;
import yxinfo.dct.service.base.dao.model.SysOrgTerminalExample;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dy on 2016/8/13.
 */
@Component
@Service( version = "1.0.0", owner = "dy" )
public class OrgTerminalServiceImpl implements OrgTerminalService {

    public List<OrgTerminalDTO> getTerminalByOrg( Integer orgId ) {
        if ( orgId == null ) return null;
        SysOrgTerminalExample example = new SysOrgTerminalExample();
        SysOrgTerminalExample.Criteria criteria = example.createCriteria();
        criteria.andOrgIdEqualTo( orgId );
        List<SysOrgTerminal> list = orgTerminalDal.selectByExample( example );
        List<OrgTerminalDTO> retList = null;
        if ( !CollectionUtils.isEmpty( list ) ) {
            retList = new ArrayList<OrgTerminalDTO>();
            for ( SysOrgTerminal sysOrgTerminal : list ) {
                retList.add( (OrgTerminalDTO) new OrgTerminalDTO().toDTO( sysOrgTerminal ) );
            }
        }
        return retList;
    }

    public List<OrgTerminalDTO> getTerminalByOrgIdsAndTermCode( List<Integer> orgIds, String terminal ) {
        if ( CollectionUtils.isEmpty( orgIds ) || StringUtils.isEmpty( terminal ) ) return null;
        SysOrgTerminalExample example = new SysOrgTerminalExample();
        SysOrgTerminalExample.Criteria criteria = example.createCriteria();
        criteria.andOrgIdIn( orgIds );
        criteria.andTermCodeEqualTo( terminal );
        List<SysOrgTerminal> list = orgTerminalDal.selectByExample( example );
        if ( !CollectionUtils.isEmpty( list ) ) {
            List<OrgTerminalDTO> retList = new ArrayList<OrgTerminalDTO>();
            for ( SysOrgTerminal sysOrgTerminal : list ) {
                retList.add( (OrgTerminalDTO) new OrgTerminalDTO().toDTO( sysOrgTerminal ) );
            }
            return retList;
        }
        return null;
    }

    @Resource private OrgTerminalDal orgTerminalDal;
}

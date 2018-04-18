package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysOrgTerminalMapper;
import yxinfo.dct.service.base.dao.model.SysOrgTerminal;
import yxinfo.dct.service.base.dao.model.SysOrgTerminalExample;

import javax.annotation.Resource;
import java.util.List;

@Component
public class OrgTerminalDal {

    @Resource SysOrgTerminalMapper sysOrgTerminalMapper;

    public int countByExample( SysOrgTerminalExample example ) {
        return sysOrgTerminalMapper.countByExample( example );
    }

    public List<SysOrgTerminal> selectByExample( SysOrgTerminalExample example ) {
        return sysOrgTerminalMapper.selectByExample( example );
    }
}
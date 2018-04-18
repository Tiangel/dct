package yxinfo.dct.inteface.service.base;

import yxinfo.dct.inteface.dto.base.OrgTerminalDTO;

import java.util.List;

/**
 * Created by dy on 2016/8/13.
 */
public interface OrgTerminalService {

    List<OrgTerminalDTO> getTerminalByOrg( Integer orgId );

    List<OrgTerminalDTO> getTerminalByOrgIdsAndTermCode( List<Integer> orgIds, String terminal );
}

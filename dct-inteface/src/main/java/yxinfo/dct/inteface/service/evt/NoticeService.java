package yxinfo.dct.inteface.service.evt;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.evt.EvtNoticeDTO;

import java.util.List;

/**
 * @author sxd
 * @date 2016/8/10 14:53
 */
public interface NoticeService {

    int insert(EvtNoticeDTO evtNoticeDTO);

    int update(EvtNoticeDTO evtNoticeDTO);

    int delete(EvtNoticeDTO evtNoticeDTO);

    int show(EvtNoticeDTO evtNoticeDTO);

    PageDTO<List<EvtNoticeDTO>> getPage(PageDTO<EvtNoticeDTO> pageDTO);
}

package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysTicketMapper;
import yxinfo.dct.service.base.dao.mapper.SysTicketMapperEx;
import yxinfo.dct.service.base.dao.model.SysTicket;

import javax.annotation.Resource;

/**
 * Created by dy on 2016/7/5.
 */
@Component
public class TicketDal {

    @Resource private SysTicketMapper sysTicketMapper;
    @Resource private SysTicketMapperEx sysTicketMapperEx;

    public int replace(SysTicket record) {
        return sysTicketMapperEx.replace(record);
    }

    public int deleteByPrimaryKey(String ticket) {
        return sysTicketMapper.deleteByPrimaryKey(ticket);
    }

    public SysTicket selectByPrimaryKey(String ticket) {
        return sysTicketMapper.selectByPrimaryKey(ticket);
    }

}

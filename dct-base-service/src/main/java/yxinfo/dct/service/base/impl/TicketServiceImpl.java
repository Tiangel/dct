package yxinfo.dct.service.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import yxinfo.dct.inteface.service.base.TicketService;
import yxinfo.dct.service.base.dal.TicketDal;
import yxinfo.dct.service.base.dao.model.SysTicket;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created by dy on 2016/7/5.
 */
@Component
@Service( version = "1.0.0", owner = "dy" )
public class TicketServiceImpl implements TicketService {

    public String createTicket( String userAt, String key ) {
        SysTicket sysTicket = new SysTicket();
        sysTicket.setUserKey( key );
        sysTicket.setUseAt( userAt );
        sysTicket.setCreateAt( new Date() );
        sysTicket.setTicket( UUID.randomUUID().toString().replaceAll( "-", "" ) );
        ticketDal.replace( sysTicket );
        return sysTicket.getTicket();
    }

    @Transactional( propagation = Propagation.NOT_SUPPORTED )
    public boolean useTicket( String ticket, String userAt, String key ) {
        SysTicket sysTicket = ticketDal.selectByPrimaryKey( ticket );
        if ( sysTicket != null ) {
            if ( !sysTicket.getUseAt().equals( userAt ) ) return false;
            if ( !sysTicket.getUserKey().equals( key ) ) return false;
            int i = ticketDal.deleteByPrimaryKey( ticket );
            if ( i == 0 ) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }

    @Resource private TicketDal ticketDal;
}

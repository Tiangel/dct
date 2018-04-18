package yxinfo.dct.inteface.service.base;

/**
 * Created by hanley on 2016/6/23.
 */
public interface TicketService {

    int EXPIRE_IN = 7200000;

    /**
     * 添加票据
     * @param userAt 票据使用接口
     * @param key 票据使用者唯一标识
     * @return 票据
     */
    String createTicket( String userAt, String key );

    /**
     * 使用票据
     *      票据使用一次即失效(删除)
     * @param ticket 票据
     * @param userAt 票据使用接口
     * @param key 票据使用者唯一标识
     * @return
     */
    boolean useTicket( String ticket, String userAt, String key );

}

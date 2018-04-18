package yxinfo.dct.inteface.service.base;

/**
 * Created by dy on 2016/8/9.
 */
public interface OrgFeeService {

    /**
     * 检查组织余额是否足够
     * @param orgId 组织id
     * @param itemNo 收支项目
     * @param amt 计费次数, 大于0
     * @return
     */
    boolean checkBal( int orgId, String itemNo, int count );

    /**
     * 按收支项目支出
     * @param orgId 组织id
     * @param itemNo 收支项目
     * @param amt 计费次数, 大于0
     */
    void expend( int orgId, String itemNo, int count, int relId );
}

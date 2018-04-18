package yxinfo.dct.service.base.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

public interface SysOrgMapperEx {

    /**
     * 增加组织余额
     * @param orgId
     * @param amt
     * @return
     */
    @Update( " UPDATE sys_org SET bal = bal + #{amt} WHERE id = #{orgId} " )
    int plusOrgBal( @Param("orgId") int orgId, @Param("amt") int amt );

}
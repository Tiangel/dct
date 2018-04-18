package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysAccessTokMapper;
import yxinfo.dct.service.base.dao.model.SysAccessTok;
import yxinfo.dct.service.base.dao.model.SysAccessTokExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hanley on 2016/6/23.
 */
@Component
public class AccessTokenDal {

    @Resource SysAccessTokMapper sysAccessTokMapper;

    public int deleteByExample( SysAccessTokExample example ) {
        return sysAccessTokMapper.deleteByExample( example );
    }

    public int insertSelective( SysAccessTok record ) {
        return sysAccessTokMapper.insertSelective( record );
    }

    public SysAccessTok selectByPrimaryKey( String accessToken ) {
        return sysAccessTokMapper.selectByPrimaryKey( accessToken );
    }

    public List<SysAccessTok> selectByExample( SysAccessTokExample example ) {
        return sysAccessTokMapper.selectByExample( example );
    }

    public int updateByPrimaryKeySelective( SysAccessTok record ) {
        return sysAccessTokMapper.updateByPrimaryKeySelective( record );
    }
}

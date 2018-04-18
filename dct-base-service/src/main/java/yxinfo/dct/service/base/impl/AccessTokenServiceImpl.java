package yxinfo.dct.service.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import yxinfo.dct.framework.exception.DctException;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.base.AccessTokenDTO;
import yxinfo.dct.inteface.service.base.AccessTokenService;
import yxinfo.dct.service.base.dal.AccessTokenDal;
import yxinfo.dct.service.base.dao.model.SysAccessTok;
import yxinfo.dct.service.base.dao.model.SysAccessTokExample;

import javax.annotation.Resource;
import java.util.Date;
import java.util.UUID;

/**
 * Created by hanley on 2016/6/23.
 */
@Component
@Service( version = "1.0.0", owner = "wh" )
public class AccessTokenServiceImpl implements AccessTokenService {

    public AccessTokenDTO createAccessToken( String derviceType, Integer memberId  ) {
        derviceType = StringUtils.isEmpty(derviceType) ? "1" : derviceType;
        SysAccessTokExample tokExample = new SysAccessTokExample();
        tokExample.createCriteria().andMemberIdEqualTo( memberId ).andDeviceTypeEqualTo( derviceType );
        accessTokenDal.deleteByExample( tokExample );

        SysAccessTok sysAccessTok = new SysAccessTok();
        sysAccessTok.setAccessTok( UUID.randomUUID().toString().replaceAll( "-", "" ) );
        sysAccessTok.setDeviceType( derviceType );
        sysAccessTok.setMemberId( memberId );
        accessTokenDal.insertSelective( sysAccessTok );
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO().toDTO( sysAccessTok );
        accessTokenDTO.setMemberId( null );
        accessTokenDTO.setExpireIn( EXPIRE_IN );
        return accessTokenDTO;
    }

    public AccessTokenDTO updateAccessToken( String oldAccessToken ) {
        AccessTokenDTO accessTokenDTO = getAccessToken( oldAccessToken );
        if ( accessTokenDTO == null ) {
            throw new DctException( ErrorCode.ACCESS_TOKEN_INVALID );
        }
        return createAccessToken( accessTokenDTO.getDeviceType(), accessTokenDTO.getMemberId() );
    }

    public AccessTokenDTO extendAccessToken( String oldAccessToken ) {
        AccessTokenDTO accessTokenDTO = getAccessToken( oldAccessToken );
        if ( accessTokenDTO == null ) {
            throw new DctException( ErrorCode.ACCESS_TOKEN_INVALID );
        }

        long dateTime = System.currentTimeMillis() - AccessTokenService.EXPIRE_IN;
        if ( accessTokenDTO.getCreateAt().before( new Date( dateTime ) ) ) {
            throw new DctException( ErrorCode.ACCESS_TOKEN_INVALID );
        }

        SysAccessTok update = new SysAccessTok();
        update.setAccessTok( oldAccessToken );
        update.setCreateAt( new Date() );
        accessTokenDal.updateByPrimaryKeySelective( update );

        accessTokenDTO.setCreateAt( update.getCreateAt() );
        accessTokenDTO.setExpireIn( EXPIRE_IN );
        return accessTokenDTO;
    }

    public AccessTokenDTO getAccessToken( String accessToken ) {
        if ( StringUtils.isEmpty( accessToken ) ) {
            throw new DctException( ErrorCode.ACCESS_TOKEN_NOT_EMPTY );
        }
        SysAccessTok sysAccessTok = accessTokenDal.selectByPrimaryKey( accessToken );
        if ( sysAccessTok == null ) return null;
        return new AccessTokenDTO().toDTO( sysAccessTok );
    }

    @Resource AccessTokenDal accessTokenDal;
}

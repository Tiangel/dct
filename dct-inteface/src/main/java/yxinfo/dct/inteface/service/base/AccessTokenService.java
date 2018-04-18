package yxinfo.dct.inteface.service.base;

import yxinfo.dct.inteface.dto.base.AccessTokenDTO;

/**
 * Created by hanley on 2016/6/23.
 */
public interface AccessTokenService {

    int EXPIRE_IN = 7200 * 1000;

    /**
     * 添加AccessToken
     * @return
     */
    AccessTokenDTO createAccessToken( String derviceType, Integer memberId );

    /**
     * 更新AccessToken
     * @api 100012 更新AccessToken
     * @param oldAccessToken
     * @return
     */
    AccessTokenDTO updateAccessToken( String oldAccessToken );

    /**
     * 续期AccessToken
     * @param oldAccessToken
     * @return
     */
    AccessTokenDTO extendAccessToken( String oldAccessToken );

    /**
     * 查找AccessToken
     * @param accessToken
     * @return
     */
    AccessTokenDTO getAccessToken( String accessToken );
}

package yxinfo.dct.service.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import yxinfo.dct.common.util.SQLUtils;
import yxinfo.dct.framework.exception.DctException;
import yxinfo.dct.framework.service.dal.Page;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.base.SysMbrInputDTO;
import yxinfo.dct.inteface.service.base.MbrInputService;
import yxinfo.dct.service.base.dal.SysMbrInputDal;
import yxinfo.dct.service.base.dao.model.SysMbrInput;
import yxinfo.dct.service.base.dao.model.SysMbrInputExample;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dy on 2016/9/18.
 */
@Component
@Service( version = "1.0.0", owner = "dy" )
public class MbrInputServiceImpl implements MbrInputService {

    public SysMbrInputDTO getMbrInput( String fcode, Integer orgId ) {
        if ( StringUtils.isEmpty( fcode ) || orgId == null ) return null;
        SysMbrInputExample example = new SysMbrInputExample();
        SysMbrInputExample.Criteria criteria = example.createCriteria();
        criteria.andOrgIdEqualTo( orgId );
        criteria.andFcodeEqualTo( fcode );
        List<SysMbrInput> list = sysMbrInputDal.selectByExample( example );
        if ( CollectionUtils.isEmpty( list ) ) {
            return null;
        }
        return new SysMbrInputDTO().toDTO( list.get(0) );
    }

    public PageDTO<List<SysMbrInputDTO>> geMbrInputPage( PageDTO<SysMbrInputDTO> queryPage ) {
        if ( queryPage == null ) return null;

        Page page = queryPage.toModel( Page.class );
        SysMbrInputDTO queryData = queryPage.getData();
        if ( queryData == null || queryData.getOrgId() == null ) {
            throw new DctException( ErrorCode.ORG_ID_NOT_NULL );
        }

        SysMbrInputExample example = new SysMbrInputExample();
        SysMbrInputExample.Criteria criteria = example.createCriteria();
        criteria.andOrgIdEqualTo( queryData.getOrgId() );

        if ( !StringUtils.isEmpty( queryData.getRealName() ) ) {
            if ( queryData.getRealName().matches( "^[a-zA-Z]*" ) ) {
                criteria.andPyinNameLike( SQLUtils.toLink( queryData.getRealName() ) );
            } else {
                criteria.andRealNameLike( SQLUtils.toLink( queryData.getRealName() ) );
            }
        }
        if ( !StringUtils.isEmpty( queryData.getLoginName() ) ) {
            criteria.andLoginNameEqualTo( queryData.getLoginName() );
        }
        if ( !StringUtils.isEmpty( queryData.getFcode() ) ) {
            criteria.andFcodeLike( queryData.getFcode() + "%" );
        }
        example.setPage( page );

        List<SysMbrInput> sysMbrInputs = sysMbrInputDal.selectByExample( example );
        PageDTO<List<SysMbrInputDTO>> results = new PageDTO<List<SysMbrInputDTO>>().toDTO( page );
        List<SysMbrInputDTO> retData = new ArrayList<SysMbrInputDTO>();
        if ( !CollectionUtils.isEmpty( sysMbrInputs ) ) {
            for ( SysMbrInput sysMbrInput : sysMbrInputs ) {
                SysMbrInputDTO ret = new SysMbrInputDTO().toDTO( sysMbrInput );
                ret.setId( 0 );
                ret.setGroups( null );
                ret.setRoles( null );
                ret.setTags( null );
                retData.add( ret );
            }
        }
        results.setData( retData );
        return results;
    }

    @Resource private SysMbrInputDal sysMbrInputDal;
}

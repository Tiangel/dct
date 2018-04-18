package yxinfo.dct.service.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import yxinfo.dct.common.util.SQLUtils;
import yxinfo.dct.framework.service.dal.Page;
import yxinfo.dct.framework.validation.annotation.DctValid;
import yxinfo.dct.framework.validation.annotation.DctValidator;
import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.base.OrgDTO;
import yxinfo.dct.inteface.dto.base.SysOrgCustomizedDTO;
import yxinfo.dct.inteface.service.base.OrgService;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.service.base.dal.OrgCustomizedDal;
import yxinfo.dct.service.base.dal.OrgDal;
import yxinfo.dct.service.base.dao.model.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanley on 2016/6/21.
 */
@Component
@Service( version = "1.0.0", owner = "wh" )
public class OrgServiceImpl implements OrgService {

    @DctValidator
    public Integer addOrg( @DctValid( groups = Add.class ) OrgDTO orgDTO ) {
        SysOrg sysOrg = orgDTO.toModel( SysOrg.class );
        orgDal.insertSelective( sysOrg );
        return sysOrg.getId();
    }

    public Integer addMember( Integer memberId, Integer orgId ) {
        if ( memberId == null || orgId == null ) return null;
        SysMemberOrg record = new SysMemberOrg();
        record.setMemberId( memberId );
        record.setOrgId( orgId );
        orgDal.insertSelective( record );
        return record.getId();
    }

    public List<OrgDTO> getOrgInId( List<Integer> orgIds ) {
        if ( CollectionUtils.isEmpty( orgIds ) ) return null;
        SysOrgExample orgExample = new SysOrgExample();
        orgExample.createCriteria().andIdIn( orgIds );
        List<SysOrg> sysOrgList = orgDal.selectByExample( orgExample );
        if ( CollectionUtils.isEmpty( sysOrgList ) ) {
            return null;
        }
        List<OrgDTO> ret = new ArrayList<OrgDTO>( orgIds.size() );
        for ( SysOrg sysOrg : sysOrgList ) {
            ret.add( (OrgDTO) new OrgDTO().toDTO( sysOrg ) );
        }
        return ret;
    }

    public List<OrgDTO> getOrgDetailInId( List<Integer> orgIds ) {
        if ( CollectionUtils.isEmpty( orgIds ) ) return null;
        SysOrgExample orgExample = new SysOrgExample();
        orgExample.createCriteria().andIdIn( orgIds );
        List<SysOrg> sysOrgList = orgDal.selectByExample( orgExample );
        if ( CollectionUtils.isEmpty( sysOrgList ) ) {
            return null;
        }
        List<OrgDTO> ret = new ArrayList<OrgDTO>( orgIds.size() );
        for ( SysOrg sysOrg : sysOrgList ) {
            OrgDTO orgDTO = new OrgDTO().toDTO( sysOrg );
            SysOrgCustomized orgCustomized = orgCustomizedDal.selectByPrimaryKey( orgDTO.getId() );
            if ( orgCustomized != null ) {
                orgDTO.setCustomized( (SysOrgCustomizedDTO) new SysOrgCustomizedDTO().toDTO( orgCustomized ) );
            }
            ret.add( orgDTO );
        }
        return ret;
    }

    public List<OrgDTO> getOrgIdByMember( Integer memberId ) {
        if ( memberId == null ) return null;
        SysMemberOrgExample example = new SysMemberOrgExample();
        example.createCriteria().andMemberIdEqualTo( memberId );
        List<SysMemberOrg> orgList = orgDal.selectByExample( example );

        List<OrgDTO> orgDTOList = null;
        if ( !CollectionUtils.isEmpty( orgList ) ) {
            List<Integer> orgIdList = new ArrayList<Integer>( orgList.size() );
            for ( SysMemberOrg sysMemberOrg : orgList   ) {
                orgIdList.add( sysMemberOrg.getOrgId() );
            }

            SysOrgExample orgExample = new SysOrgExample();
            orgExample.createCriteria().andIdIn( orgIdList );
            List<SysOrg> sysOrgList = orgDal.selectByExample( orgExample );
            if ( !CollectionUtils.isEmpty( sysOrgList ) ) {
                orgDTOList = new ArrayList<OrgDTO>( sysOrgList.size() );
                for ( SysOrg sysOrg : sysOrgList ) {
                    OrgDTO orgDTO = new OrgDTO().toDTO( sysOrg );
                    SysOrgCustomized orgCustomized = orgCustomizedDal.selectByPrimaryKey( orgDTO.getId() );
                    if ( orgCustomized != null ) {
                        orgDTO.setCustomized( (SysOrgCustomizedDTO) new SysOrgCustomizedDTO().toDTO( orgCustomized ) );
                    }
                    orgDTOList.add( orgDTO );
                }
            }
        }
        return orgDTOList;
    }

    public List<Integer>  getOrgIdByMemberId( Integer memberId ) {
        if ( memberId == null ) return null;
        SysMemberOrgExample example = new SysMemberOrgExample();
        example.createCriteria().andMemberIdEqualTo( memberId );
        List<SysMemberOrg> orgList = orgDal.selectByExample( example );

        if ( !CollectionUtils.isEmpty( orgList ) ) {
            List<Integer> orgIdList = new ArrayList<Integer>( orgList.size() );
            for ( SysMemberOrg sysMemberOrg : orgList   ) {
                orgIdList.add( sysMemberOrg.getOrgId() );
            }
            return orgIdList;
        }
        return null;
    }

    public PageDTO<List<OrgDTO>> getOrgAllPage( PageDTO<OrgDTO> orgDTOPageDTO ) {
        try {
            Page page = orgDTOPageDTO.toModel( Page.class );
            OrgDTO orgDTO = orgDTOPageDTO.getData();

            SysOrgExample example = new SysOrgExample();
            SysOrgExample.Criteria criteria = example.createCriteria();
            if ( orgDTO != null && !StringUtils.isEmpty( orgDTO.getFname() ) ) {
                criteria.andFnameLike( SQLUtils.toLink( orgDTO.getFname() ) );
            }
            example.setPage( page );

            List<SysOrg> sysOrgList = orgDal.selectByExample( example );
            List<OrgDTO> retList = new ArrayList<OrgDTO>();
            PageDTO<List<OrgDTO>> retPage = new PageDTO<List<OrgDTO>>().toDTO( page );
            if ( !CollectionUtils.isEmpty( sysOrgList ) ) {
                for ( SysOrg sysOrg : sysOrgList ) {
                    retList.add( (OrgDTO)new OrgDTO().toDTO(sysOrg) );
                }
            }
            retPage.setData( retList );
            return retPage;
        } catch ( RuntimeException e ) {
            log.error( "{}", e.getMessage(), e );
            throw e;
        }
    }

    @Resource private OrgDal orgDal;
    @Resource private OrgCustomizedDal orgCustomizedDal;

    private static final Logger log = LoggerFactory.getLogger( OrgServiceImpl.class );

}
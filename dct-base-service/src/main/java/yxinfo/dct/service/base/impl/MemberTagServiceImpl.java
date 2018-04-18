package yxinfo.dct.service.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import yxinfo.dct.framework.validation.annotation.DctValid;
import yxinfo.dct.framework.validation.annotation.DctValidator;
import yxinfo.dct.inteface.dto.base.MemberTagDTO;
import yxinfo.dct.inteface.service.base.MemberTagService;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.service.base.dal.TagDal;
import yxinfo.dct.service.base.dao.model.SysMemberTag;
import yxinfo.dct.service.base.dao.model.SysMemberTagExample;
import yxinfo.dct.service.base.dao.model.SysTag;
import yxinfo.dct.service.base.dao.model.SysTagExample;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanley on 2016/6/28.
 */
@Component
@Service( version = "1.0.0", owner = "dy" )
public class MemberTagServiceImpl implements MemberTagService {

    @DctValidator
    public int addTag( @DctValid( groups = Add.class ) MemberTagDTO tag ) {
        if ( tag == null ) return 0;
        SysTag add = tag.toModel( SysTag.class );
        tagDal.insertSelective( add );
        return add.getId();
    }

    public List<MemberTagDTO> getTagByMember( Integer memberId, Integer orgId ) {
        List<MemberTagDTO> memberTagList = null;
        SysMemberTagExample memberTagExample = new SysMemberTagExample();
        memberTagExample.createCriteria().andMemberIdEqualTo( memberId ).andOrgIdEqualTo( orgId );
        List<SysMemberTag> sysMemberTagList = tagDal.selectByExample(memberTagExample);
        if ( CollectionUtils.isEmpty( sysMemberTagList ) ) return null;

        List<Integer> tagIds = new ArrayList<Integer>( sysMemberTagList.size() );
        for ( SysMemberTag memberTag : sysMemberTagList ) {
            tagIds.add( memberTag.getTagId() );
        }
        SysTagExample tagExample = new SysTagExample();
        tagExample.createCriteria().andIdIn( tagIds );
        List<SysTag> tagList = tagDal.selectByExample( tagExample );
        if ( CollectionUtils.isEmpty( tagList ) ) return null;
        memberTagList = new ArrayList<MemberTagDTO>( tagList.size() );
        for ( SysTag tag : tagList ) {
            MemberTagDTO memberTagDTO = new MemberTagDTO();
            memberTagDTO.toDTO( tag );
            memberTagList.add( memberTagDTO );
        }
        return memberTagList;
    }

    public List<Integer> getTagIdByMember( Integer memberId, Integer orgId ) {
        SysMemberTagExample memberTagExample = new SysMemberTagExample();
        memberTagExample.createCriteria().andMemberIdEqualTo( memberId ).andOrgIdEqualTo( orgId );
        List<SysMemberTag> sysMemberTagList = tagDal.selectByExample( memberTagExample );
        if ( CollectionUtils.isEmpty( sysMemberTagList ) ) {
            return null;
        }
        List<Integer> tagIds = new ArrayList<Integer>( sysMemberTagList.size() );
        for ( SysMemberTag memberTag : sysMemberTagList ) {
            tagIds.add( memberTag.getTagId() );
        }
        return tagIds;
    }

    @Resource private TagDal tagDal;
}

package yxinfo.dct.service.base.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import yxinfo.dct.framework.validation.annotation.DctValid;
import yxinfo.dct.framework.validation.annotation.DctValidator;
import yxinfo.dct.inteface.context.base.GroupIsDel;
import yxinfo.dct.inteface.dto.base.GroupDTO;
import yxinfo.dct.inteface.service.base.GroupService;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Update;
import yxinfo.dct.service.base.dal.GroupDal;
import yxinfo.dct.service.base.dal.MemberGroupDal;
import yxinfo.dct.service.base.dao.model.SysGroup;
import yxinfo.dct.service.base.dao.model.SysGroupExample;
import yxinfo.dct.service.base.dao.model.SysMemberGroup;
import yxinfo.dct.service.base.dao.model.SysMemberGroupExample;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hanley on 2016/6/22.
 */
@Component
@Service( version = "1.0.0", owner = "wh" )
public class GroupServiceImpl implements GroupService {

    @DctValidator
    public Integer addGroup( @DctValid( groups = Add.class ) GroupDTO groupDTO ) {
        if ( groupDTO == null ) return 0;
        SysGroup sysGroup = groupDTO.toModel( SysGroup.class );
        groupDal.insertSelective( sysGroup );
        return sysGroup.getId();
    }

    public Integer addMember( Integer memberId, Integer groupId, Integer orgId ) {
        if ( memberId == null || groupId == null || orgId == null ) return null;
        SysMemberGroup sysMemberGroup = new SysMemberGroup();
        sysMemberGroup.setOrgId( orgId );
        sysMemberGroup.setGroupId( groupId) ;
        sysMemberGroup.setMemberId( memberId );
        memberGroupDal.insertSelective( sysMemberGroup );
        return sysMemberGroup.getId();
    }

    public List<GroupDTO> getGroupByMember( Integer memberId, Integer orgId ) {

        SysMemberGroupExample example = new SysMemberGroupExample();
        example.createCriteria().andMemberIdEqualTo( memberId ).andOrgIdEqualTo( orgId );

        List<SysMemberGroup> sysMemberGroupList = memberGroupDal.selectByExample( example );
        List<GroupDTO> groupDTOList = null;
        if ( !CollectionUtils.isEmpty( sysMemberGroupList ) ) {
            groupDTOList = new ArrayList<GroupDTO>();
            List<Integer> groupIds = new ArrayList<Integer>();
            for ( SysMemberGroup sysMemberGroup : sysMemberGroupList ) {
                groupIds.add( sysMemberGroup.getGroupId() );
            }

            SysGroupExample groupExample = new SysGroupExample();
            groupExample.createCriteria().andIdIn( groupIds );
            List<SysGroup> sysGroupList = memberGroupDal.selectByExample( groupExample );
            if ( !CollectionUtils.isEmpty( sysGroupList ) ) {
                for ( SysGroup sysGroup : sysGroupList ) {
                    GroupDTO groupDTO = new GroupDTO().toDTO( sysGroup );
                    groupDTOList.add( groupDTO );
                }
            }
        }
        return groupDTOList;
    }

    public List<Integer> getGroupIdByMember( Integer memberId, Integer orgId ) {
        SysMemberGroupExample example = new SysMemberGroupExample();
        example.createCriteria().andMemberIdEqualTo( memberId ).andOrgIdEqualTo( orgId );
        List<SysMemberGroup> sysMemberGroupList = memberGroupDal.selectByExample( example );
        if ( !CollectionUtils.isEmpty( sysMemberGroupList ) ) {
            List<Integer> groupIds = new ArrayList<Integer>();
            for ( SysMemberGroup sysMemberGroup : sysMemberGroupList ) {
                groupIds.add( sysMemberGroup.getGroupId() );
            }
            return groupIds;
        }
        return null;
    }


    public List<GroupDTO> getGroupByOrg( Integer orgId ) {
        SysGroupExample example = new SysGroupExample();
        example.createCriteria().andOrgIdEqualTo( orgId ).andIsDelEqualTo( GroupIsDel.IS_DEL_NO );
        List<GroupDTO> groupDTOList = null;
        List<SysGroup> list = memberGroupDal.selectByExample( example );
        if( !CollectionUtils.isEmpty( list ) ) {
            groupDTOList = new ArrayList<GroupDTO>();
            for( SysGroup group : list ) {
                GroupDTO groupDTO = new GroupDTO().toDTO( group );
                groupDTOList.add( groupDTO );
            }
        }
        return groupDTOList;
    }

    public GroupDTO getGroupById( Integer groupId ) {
        SysGroup group = groupDal.selectById( groupId );
        GroupDTO groupDTO = new GroupDTO().toDTO( group );
        return groupDTO;
    }

    @DctValidator
    public Integer updateGroup( @DctValid( groups = Update.class ) GroupDTO groupDTO ) {
        SysGroup group = groupDTO.toModel( SysGroup.class );
        group.setUpdateAt( new Date() );
        return groupDal.updateGroup( group );
    }

    public Integer deleteGroup( Integer groupId ) {
        SysMemberGroupExample example = new SysMemberGroupExample();
        example.createCriteria().andGroupIdEqualTo( groupId );
        int memberCount = memberGroupDal.getCountByExample( example );
        if( memberCount > 0 ){
            // ~成员组下有成员
            return -1;
        }else{
            SysGroupExample example1 = new SysGroupExample();
            example1.createCriteria().andPidEqualTo( groupId ).andIsDelEqualTo( false );
            int childGroupCount = groupDal.getGroupCountByExample( example1 );
            if( childGroupCount > 0 ) {
                return -2;
            }else{
                GroupDTO groupDTO = new GroupDTO();
                groupDTO.setId( groupId );
                groupDTO.setIsDel( true );
                return groupDal.updateGroup( groupDTO.toModel( SysGroup.class ) );
            }
        }
    }

    @Resource private GroupDal groupDal;
    @Resource private MemberGroupDal memberGroupDal;
}

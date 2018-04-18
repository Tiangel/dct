package yxinfo.dct.service.base.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import yxinfo.dct.common.util.RandomUtil;
import yxinfo.dct.common.util.SQLUtils;
import yxinfo.dct.common.util.StringUtil;
import yxinfo.dct.framework.exception.DctException;
import yxinfo.dct.framework.service.dal.Page;
import yxinfo.dct.framework.validation.annotation.DctValid;
import yxinfo.dct.framework.validation.annotation.DctValidator;
import yxinfo.dct.inteface.context.ErrorCode;
import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.base.*;
import yxinfo.dct.inteface.dto.evt.EvtVcodeDTO;
import yxinfo.dct.inteface.mapper.RouteCode;
import yxinfo.dct.inteface.service.base.*;
import yxinfo.dct.inteface.service.evt.VcodeService;
import yxinfo.dct.inteface.validation.groups.Add;
import yxinfo.dct.inteface.validation.groups.Update;
import yxinfo.dct.inteface.validation.groups.base.Register;
import yxinfo.dct.service.base.dal.*;
import yxinfo.dct.service.base.dao.model.*;
import yxinfo.dct.service.base.util.PyinUtil;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanley on 2016/6/15.
 */
@Component
@Service( version = "1.0.0", owner = "dy" )
public class MemberServiceImpl implements MemberService {

    public MemberDTO login( MemberDTO memberDTO, String terminal ) {
        if ( memberDTO == null || StringUtils.isEmpty( memberDTO.getLoginName() ) ) {
            throw new DctException( ErrorCode.PARAM_NOT_NULL );
        }
        // ~获取用户
        SysMemberExample example = new SysMemberExample();
        example.createCriteria()
                .andIsDelEqualTo( false )
                .andLoginNameEqualTo( memberDTO.getLoginName() );
        List<SysMember> sysMembers = memberDal.selectByExample( example );
        if ( CollectionUtils.isEmpty(sysMembers) ) {
            throw new DctException( ErrorCode.USER_NOT_FOUND );
        }
        MemberDTO queryMember = new MemberDTO().toDTO( sysMembers.get(0) );

        // ~登录
        // ~错误10次, 24小时禁止登录
        if ( queryMember.getPwdErrcount() != null && queryMember.getPwdErrcount() >= 10 ) {
            throw new DctException( ErrorCode.USER_PWD_ERR_TOO_MUCH );
        }

        if ( !confusePwd( memberDTO.getPwd() ).equals( queryMember.getPwd() ) ) {
            // ~密码错误, 错误计数+1
            SysMember update = new SysMember();
            update.setId( queryMember.getId() );
            update.setPwdErrcount( queryMember.getPwdErrcount() == null ? 1 : queryMember.getPwdErrcount() + 1 );
            memberDal.updateByPrimaryKeySelective( update );
            throw new DctException( ErrorCode.PASSWORD_ERROR );
        }
        // ~登录成功, 错误计数清空
        SysMember update = new SysMember();
        update.setId( queryMember.getId() );
        update.setPwdErrcount( 0 );
        memberDal.updateByPrimaryKeySelective( update );
        // ~屏蔽密码
        queryMember.setPwd( null );

        // ~获取用户组织id
        List<Integer> orgIds = orgService.getOrgIdByMemberId( queryMember.getId() );
        if ( !CollectionUtils.isEmpty( orgIds ) ) {
            List<OrgTerminalDTO> terminals = orgTerminalService.getTerminalByOrgIdsAndTermCode( orgIds, terminal );
            if ( !CollectionUtils.isEmpty( terminals ) ) {
                List<Integer> memberOrgIds = new ArrayList<Integer>();
                for ( OrgTerminalDTO orgTerminal : terminals ) {
                    memberOrgIds.add( orgTerminal.getOrgId() );
                }
                List<OrgDTO> orgs = orgService.getOrgDetailInId( memberOrgIds );
                for ( OrgDTO memberOrg : orgs ) {
                    // ~获取用户角色
                    memberOrg.setRoleIds( roleService.getRoleIdByMember( queryMember.getId(), memberOrg.getId() ) );
                    // ~获取用户用户组
                    memberOrg.setGroupIds( groupService.getGroupIdByMember( queryMember.getId(), memberOrg.getId() ) );
                    // ~获取用户标签
                    memberOrg.setTagIds( memberTagService.getTagIdByMember( queryMember.getId(), memberOrg.getId() ) );
                }
                queryMember.setOrgs( orgs );
            }
        }

        AccessTokenDTO accessToken = accessTokenService.createAccessToken( terminal, queryMember.getId() );
        queryMember.setAccessToken( accessToken );
        return queryMember;
    }

    public MemberDTO loginNoPwd( Integer memberId, String terminal ) {
        if ( memberId == null ) {
            throw new DctException( ErrorCode.PARAM_NOT_NULL );
        }
        // ~获取用户
        SysMember sysMember = memberDal.selectByPrimaryKey( memberId );
        if ( sysMember.getIsDel() ) {
            throw new DctException( ErrorCode.USER_NOT_FOUND );
        }
        MemberDTO queryMember = new MemberDTO().toDTO( sysMember );
        // ~屏蔽密码
        queryMember.setPwd( null );

        // ~免密登录
        // ~获取用户组织id
        List<Integer> orgIds = orgService.getOrgIdByMemberId( queryMember.getId() );
        if ( !CollectionUtils.isEmpty( orgIds ) ) {
            List<OrgTerminalDTO> terminals = orgTerminalService.getTerminalByOrgIdsAndTermCode( orgIds, terminal );
            if ( !CollectionUtils.isEmpty( terminals ) ) {
                List<Integer> memberOrgIds = new ArrayList<Integer>();
                for ( OrgTerminalDTO orgTerminal : terminals ) {
                    memberOrgIds.add( orgTerminal.getOrgId() );
                }
                List<OrgDTO> orgs = orgService.getOrgDetailInId( memberOrgIds );
                for ( OrgDTO memberOrg : orgs ) {
                    // ~获取用户角色
                    memberOrg.setRoleIds( roleService.getRoleIdByMember( queryMember.getId(), memberOrg.getId() ) );
                    // ~获取用户用户组
                    memberOrg.setGroupIds( groupService.getGroupIdByMember( queryMember.getId(), memberOrg.getId() ) );
                    // ~获取用户标签
                    memberOrg.setTagIds( memberTagService.getTagIdByMember( queryMember.getId(), memberOrg.getId() ) );
                }
                queryMember.setOrgs( orgs );
            }
        }

        AccessTokenDTO accessToken = accessTokenService.createAccessToken( terminal, queryMember.getId() );
        queryMember.setAccessToken( accessToken );
        return queryMember;
    }

    @DctValidator
    @Transactional
    public Integer addMember( @DctValid( groups = Add.class ) MemberDTO memberDTO ) {
        // ~用户是否存在
        if ( isMemberExist( memberDTO.getLoginName(), null ) ) {
            throw new DctException( ErrorCode.USER_EXIST );
        }
        SysMember sysMember = memberDTO.toModel( SysMember.class );
        sysMember.setPwd( confusePwd( memberDTO.getPwd() ) );
        if ( !StringUtils.isEmpty( sysMember.getRealName() ) ) {
            sysMember.setPyinName( getPiny( sysMember.getRealName() ) );
        }
        memberDal.insertSelective( sysMember );
        if ( memberDTO.getOrgId() != null ) {
            // ~添加用户与组织关系
            orgService.addMember( sysMember.getId(), memberDTO.getOrgId() );
            // ~添加用户和成员组关系
            if( memberDTO.getGroups() != null ) {
                addMemberGroups( memberDTO.getGroups(), sysMember.getId(), memberDTO.getOrgId() );
            }
            // ~添加用户和角色关系
            if( memberDTO.getRoles() != null ) {
                addMemberRoles( memberDTO.getRoles(), sysMember.getId(), memberDTO.getOrgId() );
            }
            // ~添加用户和标签关系
            if( memberDTO.getTags() != null ) {
                addMemberTags( memberDTO.getTags(), sysMember.getId(), memberDTO.getOrgId() );
            }
        }
        return sysMember.getId();
    }

    @DctValidator
    @Transactional
    public Integer addMemberSys( MemberDTO memberDTO ) {
        // ~用户是否存在
        if ( isMemberExist( memberDTO.getLoginName(), null ) ) {
            throw new DctException( ErrorCode.USER_EXIST );
        }
        SysMember sysMember = memberDTO.toModel( SysMember.class );
        sysMember.setPwd( confusePwd( memberDTO.getPwd() ) );
        if ( !StringUtils.isEmpty( sysMember.getRealName() ) ) {
            sysMember.setPyinName( getPiny( sysMember.getRealName() ) );
        }
        memberDal.insertSelective( sysMember );
        if ( memberDTO.getOrgId() != null ) {
            // ~添加用户与组织关系
            orgService.addMember( sysMember.getId(), memberDTO.getOrgId() );
            // ~添加用户和成员组关系
            if( memberDTO.getGroups() != null ) {
                addMemberGroups( memberDTO.getGroups(), sysMember.getId(), memberDTO.getOrgId() );
            }
            // ~添加用户和角色关系
            if( memberDTO.getRoles() != null ) {
                addMemberRoles( memberDTO.getRoles(), sysMember.getId(), memberDTO.getOrgId() );
            }
            // ~添加用户和标签关系
            if( memberDTO.getTags() != null ) {
                addMemberTags( memberDTO.getTags(), sysMember.getId(), memberDTO.getOrgId() );
            }
        }
        return sysMember.getId();
    }

    @DctValidator
    @Transactional
    public MemberDTO addMemberHasInput( @DctValid( groups = Register.class ) MemberDTO memberDTO, String terminal ) {

        // 1.是否已经注册
        SysMemberExample memberExample = new SysMemberExample();
        SysMemberExample.Criteria criteria = memberExample.createCriteria()
                .andLoginNameEqualTo( memberDTO.getLoginName() ).andIsDelEqualTo( false );
        criteria.andPwdIsNotNull();
        int i = memberDal.countByExample( memberExample );
        if ( i > 0 ) throw new DctException( ErrorCode.USER_EXIST );

        // 2.验证录入资料
        SysMbrInput sysMbrInput = authMbrInput( memberDTO, memberDTO.getLoginName() );

        // 3.初始化用户
        MemberDTO addMember = new MemberDTO();
        addMember.setFcode( sysMbrInput.getFcode() );
        addMember.setLoginDev( terminal );
        addMember.setLoginName( memberDTO.getLoginName() );
        addMember.setMobile( memberDTO.getLoginName() );
        addMember.setPwd( memberDTO.getPwd() );
        addMember.setRealName( sysMbrInput.getRealName() );
        addMember.setOrgId( sysMbrInput.getOrgId() );

        // 4.处理成员的用户组、角色、标签关系
        handleMbrInputGroupsRolesTags( sysMbrInput, addMember );

        // 5.添加用户
        addMember( addMember );

        // 6.登录
        return login( memberDTO, terminal );
    }

    /**
     * 处理成员的用户组、角色、标签关系
     * @param sysMbrInput
     * @param member
     */
    private void handleMbrInputGroupsRolesTags( SysMbrInput sysMbrInput, MemberDTO member ) {
        if ( sysMbrInput == null || member == null ) return;
        if ( !StringUtils.isEmpty( sysMbrInput.getGroups() ) ) {
            // 用户组
            member.setGroups( new ArrayList<GroupDTO>() );
            String[] groupIdStrs = sysMbrInput.getGroups().split( "," );
            for ( String  groupIdStr : groupIdStrs ) {
                if ( StringUtil.isNumeric( groupIdStr ) ) {
                    GroupDTO group = new GroupDTO();
                    group.setId( new Integer( groupIdStr ) );
                    member.getGroups().add( group );
                }
            }
        }
        if ( !StringUtils.isEmpty( sysMbrInput.getRoles() ) ) {
            // 用户角色
            member.setRoles( new ArrayList<RoleDTO>() );
            String[] roleIdStrs = sysMbrInput.getRoles().split( "," );
            for ( String roleIdStr : roleIdStrs ) {
                if ( StringUtil.isNumeric( roleIdStr ) ) {
                    RoleDTO role = new RoleDTO();
                    role.setId( new Integer( roleIdStr ) );
                    member.getRoles().add( role );
                }
            }
        }
        if ( !StringUtils.isEmpty( sysMbrInput.getTags() ) ) {
            // 用户标签
            member.setTags( new ArrayList<MemberTagDTO>() );
            String[] tagIdStrs = sysMbrInput.getTags().split( "," );
            for ( String tagStr : tagIdStrs ) {
                if ( StringUtil.isNumeric( tagStr ) ) {
                    MemberTagDTO tag = new MemberTagDTO();
                    tag.setId( new Integer( tagStr ) );
                    member.getTags().add( tag );
                }
            }
        }
    }

    @DctValidator
    @Transactional
    public MemberDTO registerHasInput( @DctValid( groups = Register.class ) MemberDTO memberDTO, String terminal ) {

        if ( memberDTO == null ) throw new DctException( ErrorCode.PARAM_NOT_NULL );
        // ~是否有注册票据
        if ( memberDTO.getAccessToken() == null ) throw new DctException( ErrorCode.USER_REGISTER_MUST_VCODE );
        if ( !ticketService.useTicket(
                memberDTO.getAccessToken().getAccessTok(), RouteCode.REGISTER_HAS_INPUT, memberDTO.getLoginName() ) ) {
            throw new DctException( ErrorCode.USER_REGISTER_MUST_VCODE );
        }

        // ~添加用户
        return addMemberHasInput( memberDTO, terminal );
    }

    @Transactional
    public MemberDTO register( MemberDTO memberDTO, String terminal ) {
        if ( memberDTO == null ) {
            throw new DctException( ErrorCode.PARAM_NOT_NULL );
        }
        if ( StringUtils.isEmpty( memberDTO.getLoginName() ) ) {
            throw new DctException( ErrorCode.USER_NOT_FOUND );
        }
        if ( StringUtils.isEmpty( memberDTO.getPwd() ) ) {
            throw new DctException( ErrorCode.PWD_NOT_EMPTY );
        }

        // ~是否有注册票据
        if ( memberDTO.getAccessToken() == null ) throw new DctException( ErrorCode.USER_REGISTER_MUST_VCODE );
        if ( !ticketService.useTicket(
                memberDTO.getAccessToken().getAccessTok(), RouteCode.REGISTER_HAS_INPUT, memberDTO.getLoginName() ) ) {
            throw new DctException( ErrorCode.USER_REGISTER_MUST_VCODE );
        }

        // 1.是否已经注册
        SysMemberExample memberExample = new SysMemberExample();
        SysMemberExample.Criteria criteria = memberExample.createCriteria()
                .andLoginNameEqualTo( memberDTO.getLoginName() ).andIsDelEqualTo( false );
        int i = memberDal.countByExample( memberExample );
        if ( i > 0 ) throw new DctException( ErrorCode.USER_EXIST );

        // 2.注册
        SysMember addMember = new SysMember();
        addMember.setLoginName( memberDTO.getLoginName() );
        addMember.setMobile( memberDTO.getLoginName() );
        addMember.setPwd( confusePwd( memberDTO.getPwd() ) );
        memberDal.insertSelective( addMember );

        // 3.登录
        return login( memberDTO, terminal );
    }

    @DctValidator
    @Transactional
    public Integer authMemberHasInput( MemberDTO memberDTO ) {
        if ( memberDTO.getId() == null ) {
            throw new DctException( ErrorCode.MEMBER_ID_NOT_EMPTY );
        }

        // 1.是否已经注册
        SysMember sysMember = memberDal.selectByPrimaryKey( memberDTO.getId() );
        if ( sysMember == null ) {
            // ~用户未注册
            throw new DctException( ErrorCode.USER_NOT_FOUND );
        }

        // 2.验证录入资料
        SysMbrInput sysMbrInput = authMbrInput( memberDTO, sysMember.getLoginName() );

        // 3.完善用户资料
        // ~更新成员姓名和人员编号
        // ~已有成员姓名、人员编号的成员, 将不再更新
        if ( StringUtils.isEmpty( sysMember.getRealName() ) ) {
            // 3.1.1 更新成员姓名和人员编号
            SysMember updateMember = new SysMember();
            updateMember.setId( sysMember.getId() );
            updateMember.setRealName( sysMbrInput.getRealName() );
            updateMember.setPyinName( getPiny( sysMbrInput.getRealName() ) );
            updateMember.setFcode( sysMbrInput.getFcode() );
            memberDal.updateByPrimaryKeySelective( updateMember );
        }
        // ~建立成员与组织的对应关系, 并根据事先录入的内容, 建立成员的用户组、角色、标签的对应关系
        // ~已经建立与该组织对应关系的成员, 将不再建立这些对应关系
        SysMemberOrgExample example = new SysMemberOrgExample();
        example.createCriteria().andMemberIdEqualTo( sysMember.getId() ).andOrgIdEqualTo( sysMbrInput.getOrgId() );
        List<SysMemberOrg> orgList = orgDal.selectByExample( example );
        if ( CollectionUtils.isEmpty( orgList ) ) {

            // 3.2.1 建立成员与组织的对应关系
            orgService.addMember( sysMember.getId(), sysMbrInput.getOrgId() );

            // 3.2.2 处理成员的用户组、角色、标签关系
            handleMbrInputGroupsRolesTags( sysMbrInput, memberDTO );
            // ~添加用户和成员组关系
            if( memberDTO.getGroups() != null ) {
                addMemberGroups( memberDTO.getGroups(), sysMember.getId(), memberDTO.getOrgId() );
            }
            // ~添加用户和角色关系
            if( memberDTO.getRoles() != null ) {
                addMemberRoles( memberDTO.getRoles(), sysMember.getId(), memberDTO.getOrgId() );
            }
            // ~添加用户和标签关系
            if( memberDTO.getTags() != null ) {
                addMemberTags( memberDTO.getTags(), sysMember.getId(), memberDTO.getOrgId() );
            }
        }
        return sysMember.getId();
    }

    /**
     * 认证录入的成员资料
     * @param memberDTO
     * @param loginName
     * @return
     */
    private SysMbrInput authMbrInput( MemberDTO memberDTO, String loginName ) {
        SysMbrInputExample exampleInput = new SysMbrInputExample();
        SysMbrInputExample.Criteria criteriaInput = exampleInput.createCriteria();

        // 1.验证姓名/组织
        criteriaInput.andRealNameEqualTo( memberDTO.getRealName() );
        criteriaInput.andOrgIdEqualTo( memberDTO.getOrgId() );
        List<SysMbrInput> sysMbrInputs = sysMbrInputDal.selectByExample( exampleInput );
        if ( CollectionUtils.isEmpty( sysMbrInputs ) ) {
            throw new DctException( ErrorCode.CAN_NOT_REGISTER );
        }

        // 2.验证学号/注册名
        SysMbrInput sysMbrInput = null;
        if ( sysMbrInputs.size() == 1 ) {
            sysMbrInput = sysMbrInputs.get(0);
            // ~验证学号
            if ( !StringUtils.isEmpty( sysMbrInput.getFcode() ) && !sysMbrInput.getFcode().equals( memberDTO.getFcode() ) ) {
                throw new DctException( ErrorCode.CAN_NOT_REGISTER );
            }
            // ~验证注册名
            if ( !StringUtils.isEmpty( sysMbrInput.getLoginName() ) && !sysMbrInput.getLoginName().equals( loginName ) ) {
                throw new DctException( ErrorCode.CAN_NOT_REGISTER );
            }
            return sysMbrInput;

        } else {
            exampleInput.clear();
            criteriaInput = exampleInput.createCriteria();
            criteriaInput.andRealNameEqualTo( memberDTO.getRealName() );
            criteriaInput.andOrgIdEqualTo( memberDTO.getOrgId() );
            if ( !StringUtils.isEmpty( memberDTO.getFcode() ) ) {
                criteriaInput.andFcodeEqualTo( memberDTO.getFcode() );
            } else {
                criteriaInput.andFcodeIsNull();
            }
            List<SysMbrInput> sysMbrInputsCode = sysMbrInputDal.selectByExample( exampleInput );
            if ( CollectionUtils.isEmpty( sysMbrInputsCode ) ) {
                throw new DctException( ErrorCode.CAN_NOT_REGISTER );
            }
            boolean flag = true;
            for ( SysMbrInput symc : sysMbrInputsCode ) {
                // ~验证注册名
                if ( StringUtils.isEmpty( symc.getLoginName() ) || symc.getLoginName().equals( loginName ) ) {
                    sysMbrInput = sysMbrInputsCode.get(0);
                    flag = false;
                    break;
                }
            }
            if ( flag ) {
                throw new DctException( ErrorCode.CAN_NOT_REGISTER );
            }
            return sysMbrInput;
        }
    }

    public int deleteMember( Integer id ) {
        SysMember sysMember = new SysMember();
        sysMember.setId( id );
        sysMember.setIsDel( true );
        return memberDal.updateByPrimaryKeySelective( sysMember );
    }

    @DctValidator
    public Integer updateMember( @DctValid( groups = Update.class ) MemberDTO memberDTO ) {
        // ~用户是否存在
        if ( !StringUtils.isEmpty( memberDTO.getLoginName() ) ) {
            if ( isMemberExist( memberDTO.getLoginName(), memberDTO.getId() ) ) {
                throw new DctException( ErrorCode.USER_EXIST );
            }
        }
        if ( !StringUtils.isEmpty( memberDTO.getPwd() ) ) {
            memberDTO.setPwd( confusePwd( memberDTO.getPwd() ) );
        }
        SysMember sysMember = memberDTO.toModel( SysMember.class );
        if ( !StringUtils.isEmpty( sysMember.getRealName() ) ) {
            sysMember.setPyinName( getPiny( sysMember.getRealName() ) );
        }
        return memberDal.updateByPrimaryKeySelective( sysMember );
    }

    @DctValidator
    @Transactional
    public Integer updateMemberSys( MemberDTO memberDTO ) {
        // ~用户是否存在
        if ( !StringUtils.isEmpty( memberDTO.getLoginName() ) ) {
            if ( isMemberExist( memberDTO.getLoginName(), memberDTO.getId() ) ) {
                throw new DctException( ErrorCode.USER_EXIST );
            }
        }
        SysMember sysMember = memberDTO.toModel( SysMember.class );
        // ~不更新密码
        sysMember.setPwd( null );
        if ( !StringUtils.isEmpty( sysMember.getRealName() ) ) {
            sysMember.setPyinName( getPiny( sysMember.getRealName() ) );
        }

        Integer updateResult = memberDal.updateByPrimaryKeySelective( sysMember );
        // ~修改成员和成员组关系
        Integer orgId = memberDTO.getOrgId();
        Integer memberId = memberDTO.getId();
        SysMemberGroupExample example = new SysMemberGroupExample();
        example.createCriteria().andMemberIdEqualTo( memberId ).andOrgIdEqualTo( orgId );
        memberGroupDal.deleteByExample( example );
        List<GroupDTO> groups = memberDTO.getGroups();
        addMemberGroups( groups, memberId, orgId );
        return updateResult;
    }

    public Integer updatePassword( MemberDTO memberDTO ) {
        if ( memberDTO == null || StringUtils.isEmpty( memberDTO.getLoginName() ) ) {
            throw new DctException( ErrorCode.PARAM_NOT_NULL );
        }
        // ~是否有重置密码票据
        if ( memberDTO.getAccessToken() == null ) throw new DctException( ErrorCode.USER_REGISTER_MUST_VCODE );
        if ( !ticketService.useTicket(
                memberDTO.getAccessToken().getAccessTok(), RouteCode.UPDATE_PASSWORD, memberDTO.getLoginName() ) ) {
            throw new DctException( ErrorCode.USER_REGISTER_MUST_VCODE );
        }

        if ( StringUtils.isEmpty( memberDTO.getPwd() ) ) {
            throw new DctException( ErrorCode.PWD_NOT_EMPTY );
        }

        SysMemberExample memberExample = new SysMemberExample();
        memberExample.createCriteria().andLoginNameEqualTo( memberDTO.getLoginName() ).andIsDelEqualTo( false );
        List<SysMember> memberList = memberDal.selectByExample( memberExample );
        if ( CollectionUtils.isEmpty( memberList ) ) {
            throw new DctException( ErrorCode.USER_NOT_FOUND );
        }
        SysMember sysMember = memberList.get(0);

        SysMember update = new SysMember();
        update.setId( sysMember.getId() );
        update.setPwd( confusePwd( memberDTO.getPwd() ) );
        update.setPwdErrcount( 0 ); // ~清空错误计数
        memberDal.updateByPrimaryKeySelective( update );
        return sysMember.getId();
    }

    @DctValidator
    public Integer updatePasswordByOld( @DctValid UpdatePwdDTO updatePwdDTO ) {
        // TODO 防止恶意破解
        // ~获取用户
        SysMember sysMember = memberDal.selectByPrimaryKey( updatePwdDTO.getMemberId() );
        if ( sysMember == null || sysMember.getIsDel() ) {
            throw new DctException( ErrorCode.USER_NOT_FOUND );
        }
        // ~判断原密码是否正确
        if ( confusePwd( updatePwdDTO.getOldPwd() ).equals( sysMember.getPwd() ) ) {
            String newPwd = confusePwd( updatePwdDTO.getNewPwd() );
            if ( newPwd.equals( sysMember.getPwd() ) ) return 1;
            // ~更新密码
            SysMember update = new SysMember();
            update.setId( sysMember.getId() );
            update.setPwd( newPwd );
            update.setPwdErrcount( 0 ); // ~清空错误计数
            return memberDal.updateByPrimaryKeySelective( update );
        } else {
            throw new DctException( ErrorCode.PASSWORD_ERROR );
        }
    }

    public void verifyMobileAndSendCode( String mobile, int type, String userAt ) {
        SysMemberExample memberExample = new SysMemberExample();
        if ( type == 1 ) {
            // ~1 注册流程发码
            // 1. 是否已经注册
            SysMemberExample.Criteria criteria = memberExample.createCriteria()
                    .andLoginNameEqualTo( mobile ).andIsDelEqualTo( false );
            criteria.andPwdIsNotNull();
            int i = memberDal.countByExample( memberExample );
            if ( i > 0 ) throw new DctException( ErrorCode.USER_EXIST );
        } else if ( type == 2 ) {
            // ~2 重置密码流程发码
            // 1. 是否没有注册
            SysMemberExample.Criteria criteria = memberExample.createCriteria()
                    .andLoginNameEqualTo( mobile ).andIsDelEqualTo( false );;
            criteria.andPwdIsNotNull();
            int i = memberDal.countByExample( memberExample );
            if ( i == 0 ) throw new DctException( ErrorCode.USER_NOT_FOUND );
        }
        // ~发送验证码
        EvtVcodeDTO vcodeDTO = new EvtVcodeDTO();
        vcodeDTO.setMobile( mobile );
        vcodeDTO.setFcode( RandomUtil.generateString( 5, RandomUtil.numberChar ) );
        vcodeDTO.setUseAt( userAt );
        vcodeService.sendVCode( vcodeDTO );
    }

    public MemberDTO getMemberByKey( Integer id ) {
        MemberDTO memberDTO = new MemberDTO().toDTO( memberDal.selectByPrimaryKey(id) );
        if ( memberDTO == null || memberDTO.getIsDel()  ) return null;
        memberDTO.setPwd( null );
        return memberDTO;
    }

    public MemberDTO getMemberByKeyWithGroups( Integer id, Integer orgId ) {
        MemberDTO ret = new MemberDTO().toDTO( memberDal.selectByPrimaryKey(id) );
        if ( ret == null || ret.getIsDel() ) return null;
        List<GroupDTO> groupDTOs = groupService.getGroupByMember(ret.getId(), orgId);
        ret.setGroups( groupDTOs );
        ret.setPwd( null );
        return ret;
    }

    public MemberDTO getMember( MemberDTO memberDTO ) {
        if ( memberDTO == null || memberDTO.getOrgId() == null )
            throw new DctException( ErrorCode.ORG_ID_NOT_NULL );

        SysMemberExample example = new SysMemberExample();
        SysMemberExample.Criteria criteria = example.createCriteria();
        if ( memberDTO.getIsDel() == null ) {
            memberDTO.setIsDel( false );
        }
        criteria.andIsDelEqualTo( memberDTO.getIsDel() );
        if ( memberDTO.getId() != null ) {
            criteria.andIdEqualTo( memberDTO.getId() );
        }
        if ( !StringUtils.isEmpty( memberDTO.getLoginName() ) ) {
            criteria.andLoginNameEqualTo( memberDTO.getLoginName() );
        }
        if ( !StringUtils.isEmpty( memberDTO.getFcode() ) ) {
            criteria.andFcodeEqualTo( memberDTO.getFcode() );
        }
        if ( !StringUtils.isEmpty( memberDTO.getRealName() ) ) {
            criteria.andRealNameEqualTo( memberDTO.getRealName() );
        }
        List<SysMember> sysMemberList = chooseMemberQueryTab( memberDTO, example );
        if ( !CollectionUtils.isEmpty( sysMemberList ) ) {
            MemberDTO member = new MemberDTO().toDTO( sysMemberList.get(0) );
            member.setPwd( null );
            return member;
        }
        return null;
    }

    public PageDTO<List<MemberDTO>> getMembers( PageDTO<MemberDTO> queryPage ) {
        if ( queryPage == null ) return null;

        SysMemberExample example = new SysMemberExample();
        Page page = queryPage.toModel( Page.class );
        MemberDTO queryData = queryPage.getData();
        if ( queryData == null || queryData.getOrgId() == null ) throw new DctException( ErrorCode.ORG_ID_NOT_NULL );
        example.setPage( page );
        SysMemberExample.Criteria criteria = example.createCriteria();
        SysMemberExample.Criteria criteriaPyin = example.or();

        if ( !StringUtils.isEmpty( queryData.getMobile() ) ) {
            criteria.andMobileLike( SQLUtils.toLink( queryData.getMobile() ) );
        }
        if ( !StringUtils.isEmpty( queryData.getRealName() ) ) {
            if ( queryData.getRealName().matches( "^[a-zA-Z]*" ) ) {
                criteria.andPyinNameLike( SQLUtils.toLink( queryData.getRealName() ) );
            } else {
                criteria.andRealNameLike( SQLUtils.toLink( queryData.getRealName() ) );
            }
        }
        if ( !StringUtils.isEmpty(queryData.getLoginName() ) ) {
            criteria.andLoginNameEqualTo( queryData.getLoginName() );
        }

        List<SysMember> sysMemberList = chooseMemberQueryTab( queryData, example );
        PageDTO<List<MemberDTO>> results = null;
        List<MemberDTO> memberDTOList;

        if ( !CollectionUtils.isEmpty(sysMemberList) ) {
            results = new PageDTO<List<MemberDTO>>();
            memberDTOList = new ArrayList<MemberDTO>(sysMemberList.size());
            for ( SysMember sysMember : sysMemberList ) {
                MemberDTO memberDTO = new MemberDTO().toDTO( sysMember );
                memberDTO.setPwd( null );
                memberDTOList.add( memberDTO );
            }
            results.toDTO( page );
            results.setData( memberDTOList );
        }
        return results;
    }

    public boolean isMemberExist( String loginName, Integer memberId ) {
        SysMemberExample memberExample = new SysMemberExample();
        SysMemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andIsDelEqualTo( false ).andLoginNameEqualTo( loginName );
        if ( memberId != null ) {
            criteria.andIdNotEqualTo( memberId );
        }
        int userCount = memberDal.countByExample( memberExample );
        if ( userCount > 0 ) {
            return true;
        }
        return false;
    }

    public MemberDTO getMemberByLgName( String loginName ) {
        SysMemberExample memberExample = new SysMemberExample();
        SysMemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andIsDelEqualTo( false ).andLoginNameEqualTo( loginName );
        List<SysMember> users = memberDal.selectByExample( memberExample );
        if ( !CollectionUtils.isEmpty( users ) ) {
            MemberDTO memberDTO = new MemberDTO().toDTO( users.get(0) );
            if ( memberDTO == null ) {
                return null;
            }
            memberDTO.setPwd( null );
            return memberDTO;
        }
        return null;
    }

    private void addMemberGroups( List<GroupDTO> groups, Integer memberId, Integer orgId ) {
        for( GroupDTO group : groups ) {
            if( group != null ) {
                SysMemberGroup memberGroup = new SysMemberGroup();
                memberGroup.setGroupId( group.getId() );
                memberGroup.setMemberId( memberId );
                memberGroup.setOrgId( orgId );
                memberGroupDal.insertSelective( memberGroup );
            }
        }
    }

    private void addMemberRoles( List<RoleDTO> roles, Integer memberId, Integer orgId ) {
        for( RoleDTO role : roles ) {
            if( role != null ) {
                SysMemberOrgRole memberOrgRole = new SysMemberOrgRole();
                memberOrgRole.setRoleId( role.getId() );
                memberOrgRole.setMemberId( memberId );
                memberOrgRole.setOrgId( orgId );
                roleDal.insertSelective( memberOrgRole );
            }
        }
    }

    private void addMemberTags( List<MemberTagDTO> tags, Integer memberId, Integer orgId ) {
        for( MemberTagDTO tag : tags ) {
            if( tag != null ) {
                SysMemberTag memberTag = new SysMemberTag();
                memberTag.setTagId( tag.getId() );
                memberTag.setMemberId( memberId );
                memberTag.setOrgId( orgId );
                tagDal.insertSelective( memberTag );
            }
        }
    }

    private List<SysMember> chooseMemberQueryTab( MemberDTO memberDTO, SysMemberExample example ) {
        if ( memberDTO.getGroupId() != null ) {
            return memberDal.selectByGroup( memberDTO.getOrgId(), memberDTO.getGroupId(), example );
        } else if ( memberDTO.getRoleId() != null ) {
            return memberDal.selectByRole( memberDTO.getOrgId(), memberDTO.getRoleId(), example );
        } else if ( memberDTO.getTagId() != null ) {
            return memberDal.selectByTag( memberDTO.getOrgId(), memberDTO.getTagId(), example );
        } else {
            return memberDal.selectByOrg( memberDTO.getOrgId() , example );
        }
    }

    /**
     * 获取拼音
     * @param str
     * @return
     */
    private String getPiny( String str ) {
        if ( StringUtils.isEmpty( str ) ) return "";
        return PyinUtil.cn2FullSpellLowercase( str, true ) + SEPARATOR + PyinUtil.cn2FirstSpellLowercase( str, true );
    }

    /**
     * 混淆密码明文
     * @param pwd
     * @return
     */
    public String confusePwd( String pwd ) {
        if ( StringUtils.isEmpty( pwd ) ) return null;
        return DigestUtils.md5DigestAsHex( ( pwd + LAT ).getBytes() );
    }

    /**
     * 密码混淆
     */
    private static final String LAT = "_k_k_Q_";
    /**
     * 中文全拼和中文简拼中间的分隔符
     */
    private static final String SEPARATOR = "*";

    @Reference( version = "1.0.0") private VcodeService vcodeService;

    @Resource private OrgService orgService;
    @Resource private GroupService groupService;
    @Resource private RoleService roleService;
    @Resource private MemberTagService memberTagService;
    @Resource private AccessTokenService accessTokenService;
    @Resource private TicketService ticketService;
    @Resource private OrgTerminalService orgTerminalService;


    @Resource private MemberDal memberDal;
    @Resource private SysMbrInputDal sysMbrInputDal;
    @Resource private MemberGroupDal memberGroupDal;
    @Resource private RoleDal roleDal;
    @Resource private TagDal tagDal;
    @Resource private OrgDal orgDal;
}

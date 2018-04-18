package yxinfo.dct.service.base.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.service.base.MemberService;
import yxinfo.dct.inteface.service.base.OrgService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hanley on 2016/6/18.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-base.xml")
public class MemberServiceImplTest {

    public void addMember() throws Exception {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setLoginName("k1");
        memberDTO.setPwd("123");
        memberDTO.setMobile("13757122107");
        memberDTO.setOrgId(1);
        memberId = memberService.addMember(memberDTO);
        Assert.assertNotNull(memberId);
    }

    public void findMember() throws Exception {

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setLoginName("k1");
        memberDTO.setOrgId(1);

        MemberDTO dto = memberService.getMember(memberDTO);

        Assert.assertNotNull(dto);
    }

    public void findMembers() throws Exception {
        PageDTO pageDTO = new PageDTO();
        pageDTO.setPageNum(2);
        MemberDTO memberDTO = new  MemberDTO();
        memberDTO.setOrgId(1);
        memberDTO.setGroupId(19);
        pageDTO.setData(memberDTO);
        PageDTO<List<MemberDTO>> memerList = memberService.getMembers(pageDTO);

        System.out.println(memerList);
    }

    public void deleteMember() throws Exception {
        memberService.deleteMember(2);
    }


    public void findMemberKey() throws Exception {
        memberService.getMemberByKey(1);
    }

    @org.junit.Test
    public void addMemberHasInput() throws Exception {
        MemberDTO memberDTO = new  MemberDTO();
        memberDTO.setOrgId( 1 );
        memberDTO.setFcode( "1113" );
        memberDTO.setRealName( "戴越" );
        memberDTO.setPwd( "123456" );
        memberDTO.setLoginName( "18767122001" );
        System.out.println(memberService.addMemberHasInput(memberDTO,""));
    }

    public void authMemberHasInput() throws Exception {
        MemberDTO memberDTO = new  MemberDTO();
        memberDTO.setId( 129 );
        memberDTO.setOrgId( 1 );
        memberDTO.setFcode( "543211" );
        memberDTO.setRealName( "戴越" );
        memberDTO.setLoginName( "" );
        System.out.println( memberService.authMemberHasInput( memberDTO ) );
    }

    private Integer memberId;

    @Resource private OrgService orgService;
    @Resource MemberService memberService;
}
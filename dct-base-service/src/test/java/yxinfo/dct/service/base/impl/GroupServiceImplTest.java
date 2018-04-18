package yxinfo.dct.service.base.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxinfo.dct.inteface.dto.base.GroupDTO;
import yxinfo.dct.inteface.service.base.GroupService;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by hanley on 2016/6/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-base.xml")
public class GroupServiceImplTest {

    public void addMember() throws Exception {
        groupService.addMember( 2, 19, 1 );
    }

    public void addGroup() throws Exception {

        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setFname("仓库管理员");
        groupDTO.setOrgId(1);
        groupService.addGroup(groupDTO);

    }

    public void findGroupByMember() throws Exception {
        List<GroupDTO> groupList =  groupService.getGroupByMember(2, 1);
        System.out.println(groupList);
    }

    @Resource
    private GroupService groupService;

}
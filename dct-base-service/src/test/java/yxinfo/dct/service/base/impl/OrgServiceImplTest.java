package yxinfo.dct.service.base.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxinfo.dct.inteface.dto.base.OrgDTO;
import yxinfo.dct.inteface.service.base.OrgService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hanley on 2016/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-base.xml")
public class OrgServiceImplTest {

    public void getOrgIdByMember() throws Exception {
        List<OrgDTO> orgDTOList = orgService.getOrgIdByMember(49);

        System.out.println(orgDTOList);
    }

    public void addOrg() throws Exception {

        OrgDTO orgDTO = new OrgDTO();
        orgDTO.setFcode("001");
        orgDTO.setFname("中医药大学");
        orgDTO.setAddress("滨文路");
        Integer i = orgService.addOrg(orgDTO);

        Assert.assertNotNull(i);
    }

    @Resource private OrgService orgService;
}
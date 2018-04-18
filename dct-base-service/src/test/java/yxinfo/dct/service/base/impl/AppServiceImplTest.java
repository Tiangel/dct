package yxinfo.dct.service.base.impl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxinfo.dct.inteface.dto.base.AppMenuDTO;
import yxinfo.dct.inteface.dto.base.OrgDTO;
import yxinfo.dct.inteface.service.base.AppService;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by hanley on 2016/6/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-base.xml")
public class AppServiceImplTest {

    public void getMenu() throws Exception {

        OrgDTO org = new OrgDTO();
        List<AppMenuDTO> appMenuDTOList = appService.getMenu(org);

        System.out.println(appMenuDTOList);

    }

    @Resource
    private AppService appService;
}
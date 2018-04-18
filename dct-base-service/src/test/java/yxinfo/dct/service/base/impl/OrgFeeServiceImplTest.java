package yxinfo.dct.service.base.impl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxinfo.dct.inteface.service.base.OrgFeeService;

import javax.annotation.Resource;

/**
 * Created by hanley on 2016/6/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-base.xml")
public class OrgFeeServiceImplTest {

    public void checkBal() throws Exception {
        System.out.println(orgFeeService.checkBal(2, "100001", 20001));
    }

    public void expend() throws Exception {
        orgFeeService.expend( 2, "100001", 1, 1 );
    }

    @Resource private OrgFeeService orgFeeService;
}
package yxinfo.dct.service.base.impl;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxinfo.dct.inteface.dto.base.RoleDTO;
import yxinfo.dct.inteface.service.base.RoleService;

import javax.annotation.Resource;

import java.util.List;

/**
 * Created by hanley on 2016/6/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-base.xml")
public class RoleServiceImplTest {

    public void addRole() throws Exception {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setOrgId(1);
        roleDTO.setFname("仓库管理员");
        roleService.addRole(roleDTO);
    }

    public void getRoleByMember() throws Exception {
        List<RoleDTO> roleDTOList = roleService.getRoleByMember(50, 1);
        System.out.println(roleDTOList);
    }

    @Resource private RoleService roleService;
}
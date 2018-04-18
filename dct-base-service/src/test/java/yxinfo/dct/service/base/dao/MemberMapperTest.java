package yxinfo.dct.service.base.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yxinfo.dct.service.base.dao.mapper.SysMemberMapperEx;
import yxinfo.dct.service.base.dao.model.SysMember;
import yxinfo.dct.service.base.dao.model.SysMemberExample;
import yxinfo.dct.service.base.util.PyinUtil;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dy on 2016/06/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-base.xml")
public class MemberMapperTest {

    @Resource private SysMemberMapperEx memberMapperEx;

    public void pyinname() throws Exception {
        try {
            List<SysMember> sysMemberList = memberMapperEx.selectByExample(new SysMemberExample());
            for ( SysMember sysMember : sysMemberList ) {
                String fname = sysMember.getRealName();
                String fullSpell = PyinUtil.cn2FullSpellLowercase( fname, false );
                String firstSpell = PyinUtil.cn2FirstSpellLowercase( fname, false );
                SysMember update = new SysMember();
                update.setId( sysMember.getId() );
                update.setPyinName( fullSpell + "*" + firstSpell );
                memberMapperEx.updateByPrimaryKeySelective( update );
            }
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }


}

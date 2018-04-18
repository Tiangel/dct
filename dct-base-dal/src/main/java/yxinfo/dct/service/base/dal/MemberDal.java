package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysMemberMapperEx;
import yxinfo.dct.service.base.dao.model.SysMember;
import yxinfo.dct.service.base.dao.model.SysMemberExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hanley on 2016/6/18.
 */
@Component
public class MemberDal {

    @Resource
    SysMemberMapperEx sysMemberMapperEx;

    public int insertSelective(SysMember record) {
        return sysMemberMapperEx.insertSelective(record);
    }


    public int deleteByPrimaryKey(Integer id) {
        return sysMemberMapperEx.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(SysMember record) {
        return sysMemberMapperEx.updateByPrimaryKeySelective(record);
    }

    public int countByExample( SysMemberExample example ) {
        return sysMemberMapperEx.countByExample(example);
    }


    public SysMember selectByPrimaryKey(Integer id) {
        return sysMemberMapperEx.selectByPrimaryKey(id);
    }

    public List<SysMember> selectByOrg(Integer orgId, SysMemberExample example) {
        return sysMemberMapperEx.selectByOrg(orgId, example);
    }

    public List<SysMember> selectByGroup(Integer orgId, Integer groupId, SysMemberExample example) {
        return sysMemberMapperEx.selectByGroup(orgId, groupId, example);
    }

    public List<SysMember> selectByRole(Integer orgId, Integer roleId, SysMemberExample example) {
        return sysMemberMapperEx.selectByRole(orgId, roleId, example);
    }

    public List<SysMember> selectByTag( Integer orgId, Integer tagId, SysMemberExample example) {
        return sysMemberMapperEx.selectByTag(orgId, tagId, example);
    }

    public List<SysMember> selectByExample(SysMemberExample example) {
        return sysMemberMapperEx.selectByExample(example);
    }



}

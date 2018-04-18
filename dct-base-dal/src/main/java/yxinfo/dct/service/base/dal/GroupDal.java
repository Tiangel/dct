package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysGroupMapper;
import yxinfo.dct.service.base.dao.model.SysGroup;
import yxinfo.dct.service.base.dao.model.SysGroupExample;

import javax.annotation.Resource;

/**
 * Created by hanley on 2016/6/22.
 */
@Component
public class GroupDal {

    @Resource private SysGroupMapper sysGroupMapper;

    public int insertSelective(SysGroup record) {
        return sysGroupMapper.insertSelective(record);
    }

    public int updateGroup(SysGroup group){
        return sysGroupMapper.updateByPrimaryKeySelective(group);
    }

    public SysGroup selectById(Integer groupId){
        return sysGroupMapper.selectByPrimaryKey(groupId);
    }

    public int getGroupCountByExample(SysGroupExample example){
        return sysGroupMapper.countByExample(example);
    }
}

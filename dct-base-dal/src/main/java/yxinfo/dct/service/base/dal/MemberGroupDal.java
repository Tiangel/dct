package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysGroupMapper;
import yxinfo.dct.service.base.dao.mapper.SysMemberGroupMapper;
import yxinfo.dct.service.base.dao.model.SysGroup;
import yxinfo.dct.service.base.dao.model.SysGroupExample;
import yxinfo.dct.service.base.dao.model.SysMemberGroup;
import yxinfo.dct.service.base.dao.model.SysMemberGroupExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hanley on 2016/6/21.
 */

@Component
public class MemberGroupDal {

    @Resource
    private SysGroupMapper sysGroupMapper;

    @Resource
    private SysMemberGroupMapper sysMemberGroupMapper;


    /**
     * 查询关联表
     * @param example
     * @return
     */
    public List<SysMemberGroup> selectByExample(SysMemberGroupExample example) {

        return sysMemberGroupMapper.selectByExample(example);

    }

    public int insertSelective(SysMemberGroup record) {
        return sysMemberGroupMapper.insertSelective(record);
    }

    public List<SysGroup> selectByExample(SysGroupExample example) {
        return sysGroupMapper.selectByExample(example);
    }

    public int getCountByExample(SysMemberGroupExample example){
        return sysMemberGroupMapper.countByExample(example);
    }

    public int deleteByExample(SysMemberGroupExample example){
        return sysMemberGroupMapper.deleteByExample(example);
    }

}

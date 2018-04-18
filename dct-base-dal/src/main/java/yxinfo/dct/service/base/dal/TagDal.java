package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysMemberTagMapper;
import yxinfo.dct.service.base.dao.mapper.SysTagMapper;
import yxinfo.dct.service.base.dao.model.SysMemberTag;
import yxinfo.dct.service.base.dao.model.SysMemberTagExample;
import yxinfo.dct.service.base.dao.model.SysTag;
import yxinfo.dct.service.base.dao.model.SysTagExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hanley on 2016/6/28.
 */
@Component
public class TagDal {

    public int insertSelective( SysTag record ) {
        return tagMapper.insertSelective( record );
    }

    public int insertSelective( SysMemberTag record ) {
        return sysMemberTagMapper.insertSelective( record );
    }

    public List<SysTag> selectByExample(SysTagExample example) {
        return tagMapper.selectByExample(example);
    }

    public List<SysMemberTag> selectByExample(SysMemberTagExample example) {
        return sysMemberTagMapper.selectByExample(example);
    }

    @Resource private SysTagMapper tagMapper;
    @Resource private SysMemberTagMapper sysMemberTagMapper;
}

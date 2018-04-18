package yxinfo.dct.service.base.dal;

import org.springframework.stereotype.Component;
import yxinfo.dct.service.base.dao.mapper.SysMbrInputMapper;
import yxinfo.dct.service.base.dao.model.SysMbrInput;
import yxinfo.dct.service.base.dao.model.SysMbrInputExample;

import javax.annotation.Resource;
import java.util.List;

@Component
public class SysMbrInputDal {

    public int countByExample( SysMbrInputExample example ) {
        return sysMbrInputMapper.countByExample( example );
    }

    public List<SysMbrInput> selectByExample( SysMbrInputExample example ) {
        return sysMbrInputMapper.selectByExample( example );
    }

    @Resource private SysMbrInputMapper sysMbrInputMapper;
}
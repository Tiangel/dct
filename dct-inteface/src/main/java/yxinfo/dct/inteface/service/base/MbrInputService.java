package yxinfo.dct.inteface.service.base;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.base.SysMbrInputDTO;

import java.util.List;

/**
 * Created by dy on 2016/9/18.
 */
public interface MbrInputService {

    SysMbrInputDTO getMbrInput( String fcode, Integer orgId );

    /**
     * 获取录入成员
     * @code 100027
     * @param queryPage
     * @return
     */
    PageDTO<List<SysMbrInputDTO>> geMbrInputPage( PageDTO<SysMbrInputDTO> queryPage );
}

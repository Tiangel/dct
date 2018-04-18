package yxinfo.dct.service.base.dao.mapper;

import org.apache.ibatis.annotations.Param;
import yxinfo.dct.service.base.dao.model.SysMenu;

import java.util.List;

/**
 * Created by hanley on 2016/6/30.
 */
public interface SysMenuMapperEx extends SysMenuMapper {

    List<SysMenu> selectMenuByRole( @Param("roleIds") List<Integer> roleIds );

}

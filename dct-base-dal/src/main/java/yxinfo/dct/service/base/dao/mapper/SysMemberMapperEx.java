package yxinfo.dct.service.base.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import yxinfo.dct.service.base.dao.model.SysMember;
import yxinfo.dct.service.base.dao.model.SysMemberExample;

import java.util.List;

/**
 * Created by hanley on 2016/6/23.
 */
public interface SysMemberMapperEx extends SysMemberMapper {


    List<SysMember> selectByGroup(@Param("orgId") Integer orgId, @Param("groupId") Integer groupId, @Param("example") SysMemberExample example );

    List<SysMember> selectByRole(@Param("orgId") Integer orgId,  @Param("roleId") Integer roleId, @Param("example") SysMemberExample example );

    List<SysMember> selectByOrg(@Param("orgId") Integer orgId, @Param("example") SysMemberExample example );

    List<SysMember> selectByTag( @Param("orgId") Integer orgId, @Param("tagId") Integer tagId, @Param("example") SysMemberExample example);

}

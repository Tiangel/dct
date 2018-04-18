package yxinfo.dct.inteface.service.base;

import yxinfo.dct.inteface.dto.base.MemberTagDTO;

import java.util.List;

/**
 * Created by hanley on 2016/6/28.
 *
 * 用户标签管理
 */
public interface MemberTagService {

    /**
     * 获取用户标签
     * @param memberId
     * @param orgId
     * @return
     */
    List<MemberTagDTO> getTagByMember( Integer memberId, Integer orgId );

    /**
     * 获取用户标签id
     * @param memberId
     * @param orgId
     * @return
     */
    List<Integer> getTagIdByMember( Integer memberId, Integer orgId );
}

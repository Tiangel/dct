package yxinfo.dct.inteface.service.warn;

import java.util.List;

/**
 * @author sxd
 * @date 2016/8/25 11:33
 */
public interface WarnItemRoleService {

    List<Integer> getRoleIdList(Integer orgId, List<String> itemNo);
}

package yxinfo.dct.inteface.context.evt;

/**
 * 推送常量
 * Created by dy on 2016/6/30.
 */
public interface PushContext {

    /**
     * 别名标志, A{memberId}#{memberOrgId}
     */
    String ALIAS_FLAG = "A{0}_{1}";
    /**
     * 角色Tag标志, R{角色id}
     */
    String TAG_ROLE_FLAG = "R";
    /**
     * 用户组Tag标志, G{用户组id}
     */
    String TAG_GROUP_FLAG = "G";
    /**
     * 用户标签Tag标志, T{用户标签id}
     */
    String TAG_TAG_FLAG = "T";
    /**
     * 组织Tag标志, O{组织id}
     */
    String TAG_ORG_FLAG = "O";


}

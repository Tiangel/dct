package yxinfo.dct.inteface.context.approve;

/**
 * 审核类型枚举
 * Created by dy on 2016/06/19.
 */
public interface ApproveType {

    // 方案过程类型
    String EXEC_FLOW_TPYE_FREE = "1"; // 不指定范围
    String EXEC_FLOW_TPYE_FOR_MEMBER = "2"; // 指定用户
    String EXEC_FLOW_TPYE_FOR_ROLE = "3";   // 指定角色
    String EXEC_FLOW_TPYE_FOR_GROUP = "4";  // 指定成员组
    String EXEC_FLOW_TPYE_FOR_TAG = "5";  // 指定标签
    String EXEC_FLOW_TPYE_FOR_GROUP_TAG = "6";  // 指定成员组+标签

    // 方案类型
    String EXEC_TYPE_FLOW = "1"; // 流模式
    String EXEC_TYPE_FREE = "2"; // 自由模式

}

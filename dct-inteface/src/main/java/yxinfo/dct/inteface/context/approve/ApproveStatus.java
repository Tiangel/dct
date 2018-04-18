package yxinfo.dct.inteface.context.approve;

/**
 * Created by dy on 2016/6/21.
 */
public interface ApproveStatus {

    // 审核状态
    String RECODE_STATUS_UNSUBMIT = "u"; // 未提交
    String RECODE_STATUS_PROCESS = "o";  // 审核中
    String RECODE_STATUS_SUCCESS = "s";  // 审核通过
    String RECODE_STATUS_FAIL = "f";     // 审核不通过
    String RECODE_STATUS_INVALID = "i";  // 已作废

}

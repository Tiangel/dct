package yxinfo.dct.inteface.context.chem;

/**
 * Created by dy on 2016/6/22.
 */
public interface ChemStatus {

    // 试剂状态
    String REAGENT_STA_IN_WH = "1";               // 库存中
    String REAGENT_STA_IN_USE = "2";              // 使用中
    String REAGENT_STA_RECYCLE_WAIT = "3";        // 待回收
    String REAGENT_STA_RECYCLE_SUCC = "4";        // 正常回收
    String REAGENT_STA_RECYCLE_NO_SCAN = "5";     // 回收但未扫码
    String REAGENT_STA_SCAN_NO_RECYCLE = "6";     // 扫码但未回收
    String REAGENT_STA_RECYCLE_ABNOR_CLOSE = "7"; // 回收异常关闭
    String REAGENT_STA_INVALID  = "8";            // 作废

    // 试剂领用状态
    String APPLY_REAGENT_RECEIVE_STA_NOT = "1"; // 未领
    String APPLY_REAGENT_RECEIVE_STA_HAS = "2"; // 已领

    // 试剂申领领取状态
    String APPLY_RECEIVE_RECEIVE_STA_CANNOT = "1";  // 不可领
    String APPLY_RECEIVE_RECEIVE_STA_WAIT = "2";    // 待领用
    String APPLY_RECEIVE_RECEIVE_STA_FIN = "3";     // 已领完
    String APPLY_RECEIVE_RECEIVE_STA_REFUSE = "4";  // 已驳回
    String APPLY_RECEIVE_RECEIVE_STA_TOMEOUT = "5"; // 已逾期


}

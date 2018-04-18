package yxinfo.dct.inteface.context.evt;

/**
 * Created by dy on 2016/6/28.
 */
public interface EvtItemNo {

    /**
     * 同意/驳回化学试剂领用申请
     */
    String APPLEY_RECEIVE_PASS_OR_NOT = "100001";

    /**
     * 化学试剂回收
     */
    String REAGENT_RECYCLE = "100002";

    /**
     * 化学试剂领用申请待审核
     */
    String WAIT_APPROVE_APPLEY_RECEIVE = "100003";

    /**
     * 学生化学试剂领用通知（老师接收）
     */
    String REAGENT_RECEIVE_FOR_TEACHER = "100004";

    /**
     * 学生/老师化学试剂领用通知（仓管接收）
     */
    String REAGENT_RECEIVE_FOR_WH_MANAGER = "100005";

    /**
     * 化学试剂领用申请状态更新
     */
    String APPLEY_RECEIVE_UPDATE = "100006";

    /**
     * 化学试剂回收状态更新
     */
    String REAGENT_RECYCLE_UPDATE = "100007";

    /**
     * 同意/驳回仪器预约
     */
    String INST_BESPEAK_PASS_OR_NOT = "100008";

    /**
     * 仪器预约状态更新
     */
    String INST_BESPEAK_UPDATE = "100009";

    /**
     * 仪器预约待审核
     */
    String WAIT_APPROVE_INST_BESPEAK = "100010";

    /**
     * 电视展示公告
     */
    String TV_NOTICE = "100011";

    /**
     * 化学试剂预警
     */
    String CHEM_WARN = "100012";

    /**
     * 电视项目
     */
    String TV_PROJECT = "100013";

    /**
     * 电视仪器
     */
    String TV_INSTRUMENT = "100014";

    /**
     * 电视温度和湿度
     */
    String TV_TEMP_HUM = "100015";

    /**
     * 电视预警
     */
    String TV_WARN = "100016";

    /**
     * 预警推送
     */
    String WARN_PUSH = "100017";

    /**
     * 同意/驳回购买订单
     */
    String ORDER_PASS_OR_NOT = "100018";

    /**
     * 购买订单待审核
     */
    String WAIT_APPROVE_ORDER = "100019";

    /**
     * 大仪共享中订单审核推送
     */
    String DIS_APRPROVE_ORDER = "100020";
}

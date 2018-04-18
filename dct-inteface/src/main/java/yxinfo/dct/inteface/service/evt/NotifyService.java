package yxinfo.dct.inteface.service.evt;

import yxinfo.dct.inteface.dto.evt.EvtNotifyDTO;

/**
 * Created by dy on 2016/6/27.
 */
public interface NotifyService {

    /**
     * 添加事件通知（异步通知）
     * <p>仅保存不立即通知, 后续交由异步通知服务{@link yxinfo.dct.service.evt.job.NotifyJob}处理<p/>
     * <p>
     * 参数说明:
     * ftype       必传, 类型, 取值为{@link yxinfo.dct.inteface.context.evt.NotifyType}
     * itemNo      必传, 事件项目编号, 取值为{@link yxinfo.dct.inteface.context.evt.EvtItemNo}
     * memberId    通知用户id, memberId/memberOrgId必须一起传递
     * memberOrgId 通知用户的组织id
     * roleId      通知角色id
     * groupId     通知成员组id
     * tagId       通知标签id
     * orgId       通知组织id, 以上memberId/memberOrgId/roleId/groupId/tagId/orgId不能全部为空
     * extraMsgId  额外信息id
     * title       必传, 消息标题
     * summary     消息摘要
     * context     消息内容
     * terminal    必传, 终端类型编号, 取值为{@link yxinfo.dct.inteface.context.base.TerminalCode}
     * <p/>
     * @param evtNotifyDTO
     * @return
     */
    Boolean addNotify( EvtNotifyDTO evtNotifyDTO );

    /**
     * 添加事件通知（同步通知）
     * <p>立即通知<p/>
     * <p>
     * 参数说明:
     * ftype       必传, 类型, 取值为{@link yxinfo.dct.inteface.context.evt.NotifyType}
     * itemNo      必传, 事件项目编号, 取值为{@link yxinfo.dct.inteface.context.evt.EvtItemNo}
     * memberId    通知用户id, memberId/memberOrgId必须一起传递
     * memberOrgId 通知用户的组织id
     * roleId      通知角色id
     * groupId     通知成员组id
     * tagId       通知标签id
     * orgId       通知组织id, 以上memberId/memberOrgId/roleId/groupId/tagId/orgId不能全部为空
     * extraMsgId  额外信息id
     * title       必传, 消息标题
     * summary     消息摘要
     * context     消息内容
     * terminal    必传, 终端类型编号, 取值为{@link yxinfo.dct.inteface.context.base.TerminalCode}
     * <p/>
     * @param evtNotifyDTO
     * @return
     */
    Boolean addNotifySync( EvtNotifyDTO evtNotifyDTO );

}

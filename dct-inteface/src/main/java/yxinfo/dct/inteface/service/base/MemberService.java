package yxinfo.dct.inteface.service.base;

import yxinfo.dct.inteface.dto.PageDTO;
import yxinfo.dct.inteface.dto.base.MemberDTO;
import yxinfo.dct.inteface.dto.base.UpdatePwdDTO;

import java.util.List;

/**
 * Created by hanley on 2016/6/15.
 */
public interface MemberService {

    /**
     * 用户登录
     * @code 100001
     * @param memberDTO
     * @param terminal 终端设备类型
     * @return
     */
    MemberDTO login( MemberDTO memberDTO, String terminal );

    /**
     * 免密登录
     * <p>不验证密码直接登录, 用于第三方授权登录成功后调用<p/>
     * @param memberId
     * @param terminal
     * @return
     */
    MemberDTO loginNoPwd( Integer memberId, String terminal );

    /**
     * 添加成员
     * @code 100002
     * @param memberDTO
     * @return 添加成功返回用户信息，否则返回null
     */
    Integer addMember( MemberDTO memberDTO );

    /**
     * 添加成员（管理后台）
     * @code 100025
     * @param memberDTO
     * @return  添加成功返回用户信息，否则返回null
     */
    Integer addMemberSys( MemberDTO memberDTO );

    /**
     * 添加已录入资料的成员
     * @param memberDTO
     * @param terminal 终端设备类型
     * @return
     * @throws DctException, code如下:
     *         验证不通过时, {@link yxinfo.dct.inteface.context.ErrorCode.CAN_NOT_REGISTER}
     *         用户已经注册时, {@link yxinfo.dct.inteface.context.ErrorCode.USER_EXIST}
     */
    MemberDTO addMemberHasInput( MemberDTO memberDTO, String terminal );

    /**
     * 已录入资料的成员注册
     * <p>验证ticket, 即memberDTO.getAccessToken().getAccessTok(); ticket由验证短信验证码接口获取（code为110002）<p/>
     * <p>认证组织、姓名和人员编号, 认证通过时: <p/>
     * <p>注册成员; <p/>
     * <p>建立成员与组织的对应关系, 并根据事先录入的内容, 建立成员的用户组、角色、标签的对应关系 <p/>
     * <p>传递参数如下: <p/>
     * <p>loginName 成员登录名 <p/>
     * <p>pwd       密码      <p/>
     * <p>realName  姓名      <p/>
     * <p>orgId     组织id    <p/>
     * <p>fcode     人员编号  <p/>
     * @code 100004 验证用户资料并注册
     * @param memberDTO
     * @param terminal 终端设备类型
     * @return
     * @throws DctException, code如下:
     *         ticket失效时, {@link yxinfo.dct.inteface.context.ErrorCode.USER_REGISTER_MUST_VCODE}
     *         验证不通过时, {@link yxinfo.dct.inteface.context.ErrorCode.CAN_NOT_REGISTER}
     *         用户已经注册时, {@link yxinfo.dct.inteface.context.ErrorCode.USER_EXIST}
     */
    MemberDTO registerHasInput( MemberDTO memberDTO, String terminal );

    /**
     * 成员注册
     * <p>验证ticket, 即memberDTO.getAccessToken().getAccessTok(); ticket由验证短信验证码接口获取（code为110002）<p/>
     * @code 100028
     * @param memberDTO
     * @param terminal 终端设备类型
     * @return
     * @throws 用户已经注册时抛出DctException, code为{@link yxinfo.dct.inteface.context.ErrorCode.USER_EXIST}
     */
    MemberDTO register( MemberDTO memberDTO, String terminal );

    /**
     * 已注册的成员认证
     * <p>认证组织、姓名和人员编号, 认证通过时: <p/>
     * <p>更新成员姓名和人员编号, 已有成员姓名、人员编号的成员, 将不再更新; <p/>
     * <p>建立成员与组织的对应关系, 并根据事先录入的内容, 建立成员的用户组、角色、标签的对应关系, <p/>
     * <p>已经建立与该组织对应关系的成员, 将不再建立这些对应关系<p/>
     * <p>传递参数如下: <p/>
     * <p>id       成员id   <p/>
     * <p>realName 姓名     <p/>
     * <p>orgId    组织id   <p/>
     * <p>fcode    人员编号 <p/>
     * @code 100029
     * @param memberDTO
     * @return 验证通过返回成员id
     * @throws
     */
    Integer authMemberHasInput( MemberDTO memberDTO );

    /**
     * 删除用户信息
     * @code 100023
     * @param id
     * @return
     */
    int deleteMember( Integer id );

    /**
     * 修改成员信息
     * <p>id必传, 按id查找并修改成员信息, 可修改成员要素如下: <p/>
     * <p>loginName 登录名   <p/>
     * <p>pwd       登录密码 <p/>
     * <p>fcode     人员编号 <p/>
     * <p>realName  真实姓名 <p/>
     * <p>nickName  昵称     <p/>
     * <p>mobile    手机号码 <p/>
     * <p>head      头像id   <p/>
     * @code 100005
     * @param memberDTO
     * @return
     * @throws 修改登录名为已注册登录名时抛出DctException, code为{@link yxinfo.dct.inteface.context.ErrorCode.USER_EXIST}
     */
    Integer updateMember( MemberDTO memberDTO );

    /**
     * 修改成员信息（管理后台）
     * @code 100026
     * @param memberDTO
     * @return
     */
    Integer updateMemberSys( MemberDTO memberDTO );

    /**
     * 重置成员密码
     * <p>验证ticket, 即memberDTO.getAccessToken().getAccessTok(); ticket由验证短信验证码接口获取（code为110002）<p/>
     * <p>loginName 登录名   <p/>
     * <p>pwd       登录密码 <p/>
     * @code 100011
     * @param memberDTO
     * @return 被重置密码的成员id
     */
    Integer updatePassword( MemberDTO memberDTO );

    /**
     * 修改成员密码
     * <p>memberId 成员id <p/>
     * <p>oldPwd   原密码 <p/>
     * <p>newPwd   新密码 <p/>
     * @code 100024
     * @param updatePwdDTO
     * @return
     */
    Integer updatePasswordByOld( UpdatePwdDTO updatePwdDTO );

    /**
     * 验证手机号码并发送验证码
     * @code 100009 注册流程验证手机号码并发送验证码
     * @code 100010 重置密码流程验证手机号码并发送验证码
     * @param mobile
     * @param type 1 注册流程, 验证是否已经注册/是否允许注册（数据是否已录入）
     *             2 重置密码流程, 验证是否没有注册
     * @param userAt 用于的功能码, 送接口请求的code参数
     */
    void verifyMobileAndSendCode( String mobile, int type, String userAt );

    /**
     * 根据主键获取用户信息
     * @param id
     * @return
     */
    MemberDTO getMemberByKey( Integer id );

    /**
     * 根据主键获取用户及其用户组信息
     * @param id
     * @param orgId
     * @return
     */
    MemberDTO getMemberByKeyWithGroups( Integer id, Integer orgId );

    /**
     * 根据条件查询单条用户信息
     * @code 100003
     * @param memberDTO
     * @return
     */
    MemberDTO getMember( MemberDTO memberDTO );

    /**
     * 分页查询用户信息列表
     * @param queryPage
     * @return
     */
    PageDTO<List<MemberDTO>> getMembers( PageDTO<MemberDTO> queryPage );

    /**
     * 判断用户名对应的用户是否存在
     * @param loginName 用户名
     * @param memberId 传值则查询时带上条件, id != memberId; 用于更新用户用户名时排除自己
     * @return
     */
    boolean isMemberExist( String loginName, Integer memberId );

    /**
     * 根据用户名获取用户
     * @param loginName
     * @return
     */
    MemberDTO getMemberByLgName( String loginName );
}

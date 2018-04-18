package yxinfo.dct.inteface.mapper;

/**
 * Created by hanley on 2016/6/16.
 */
public interface RouteCode {

    //成员登录
    String USER_LOGIN = "100001";
    //添加成员
    String ADD_MEMBER = "100002";
    //验证是否是组织成员
    String CHECK_MEMBER_IN_ORG = "100003";
    //用户注册(已录入信息)
    String REGISTER_HAS_INPUT = "100004";
    //修改成员信息
    String MODIFY_MEMBER = "100005";
    //查找成员信息
    String GET_MEMBER = "100006";
    //获取用户组织
    String GET_ORG_LIST = "100007";
    //获取用户角色
    String GET_ROLE_LIST = "100008";
    //注册流程验证手机号码并发送验证码
    String VERIFY_MOBILE_REGISTER_SEND_CODE = "100009";
    //重置密码流程验证手机号码并发送验证码
    String VERIFY_MOBILE_RESET_PWD_SEND_CODE = "100010";
    //重置密码
    String UPDATE_PASSWORD = "100011";
    //更新AccessToken
    String UPDATE_ACCESS_TOKEN = "100012";
    //APP首页菜单
    String APP_INDEX_MENU = "100013";
    //后台菜单
    String MANAGE_MENU = "100014";
    //获取全部成员
    String GET_MEMBER_ALL = "100015";
    //分页搜索全部组织
    String GET_ORG_PAGE_ALL = "100016";
    //获取ORG全部成员组
    String GET_GROUP_BY_ORG = "100017";
    //主键查询成员组
    String GET_GROUP_BY_KEY = "100018";
    //获取成员
    String GET_MEMBER_BY_KEY = "100019";
    //添加成员组
    String ADD_GROUP = "100020";
    //修改成员组
    String UPDATE_GROUP = "100021";
    //删除成员组
    String DELETE_GROUP = "100022";
    //删除成员
    String DELETE_MEMBER = "100023";
    //修改用户密码（根据原密码）
    String UPDATE_PASSWORD_BY_OLD = "100024";
    //后台添加成员
    String ADD_MEMBER_SYS = "100025";
    //后台修改成员
    String UPDATE_MEMBER_SYS = "100026";
    //获取录入成员
    String GET_MBR_INPUT_PAGE = "100027";
    //用户注册
    String REGISTER = "100028";
    //用户认证
    String AUTH_HAS_INPUT = "100029";

    //添加类目信息
    String ADD_CATEG = "103001";
    //添加类目试题
    String ADD_CATEG_QUESTS = "103002";
    //根据类目查询试题信息
    String GET_QUESTS_BY_CATEGID = "103003";
    //获取类目集合
    String GET_CATEG_LIST = "103004";

    //插入一条实验室记录
    String ADD_LAB = "104001";
    //主键查询实验室记录
    String GET_LAB_BY_KEY = "104002";
    //分页查询实验室记录
    String GET_PAGE_LABS = "104003";
    //删除实验室记录
    String DELETE_LAB = "104004";
    //查询实验室记录（所有）
    String GET_LABS = "104005";
    //更新实验室记录
    String UPDATE_LAB = "104006";
    //查询实验室负责人
    String GET_LAB_MANAGER = "104007";
    //删除实验室负责人
    String DELETE_LABMANAGER_BY_KEY = "104008";
    //导入实验室
    String IMPORT_LAB = "104009";
    //导出实验室
    String EXPORT_LAB = "104010";

    //添加课题日志
    String ADD_TOPICLOG = "105001";
    //查询课题日志记录集合
    String GET_TOPICLOG_LIST = "105002";
    //根据日志id查询详细信息
    String GET_TOPICLOG_BYKEY = "105003";
    //更新课题日志
    String UPDATE_TOPICLOG = "105004";
    //查询课题日志分页
    String GET_TOPICLOG_PAGE_LIST = "105005";
    //导出课题日志
    String EXPORT_TOPICLOG = "105006";
    //添加仓库
    String ADD_WH = "106001";
    //更新仓库
    String UPDATE_WH = "106002";
    //删除仓库信息
    String DELETE_WH = "106003";
    //查询仓库集合
    String GET_WH_LIST = "106004";
    //分页查询仓库集合
    String GET_WH_PAGE_LIST = "106005";
    //根据id获取仓库
    String GET_WH_BY_KEY = "106006";
    //获取第一条仓库信息
    String GET_WH_ON_TOP = "106007";

    //添加设备
    String ADD_EQUIPMENT = "107001";
    //删除设备
    String DELETE_EQUIPMENT = "107002";
    //更新设备
    String MODIFY_EQUIPMENT = "107003";
    //根据ID获取设备信息
    String GET_EQUIPMENT = "107004";
    //分页查询设备信息
    String GET_EQUIPMENT_LIST = "107005";
    //添加Rfid卡
    String ADD_RFID = "107006";
    //删除Rfid卡
    String DELETE_RFID = "107007";
    //更新Rfid卡
    String MODIFY_RFID = "107008";
    //根据ID获取Rfid卡信息
    String GET_RFID = "107009";
    //分页查询Rfid卡信息
    String GET_RFID_LIST = "107010";
    //根据Fcode获取Rfid卡信息
    String GET_RFID_FCODE = "107011";

    //申领记录列表
    String CHEM_APPLY_LIST = "108001";
    //申领记录详情
    String CHEM_APPLY_DETAIL = "108002";
    //搜索化学品
    String CHEM_SEARCH_CHEM = "108003";
    //获取化学品规格
    String CHEM_GET_SPEC = "108004";
    //申请领取（学校）
    String CHEM_APPLY = "108005";
    //领用
    String CHEM_RECEIVE = "108006";
    //回收
    String CHEM_RECYCLE = "108007";
    //根据RFID获取试剂信息
    String CHEM_GET_REAGENT_INFO = "108008";
    //回收列表
    String CHEM_RECYCLE_LIST = "108009";
    //审核领取申请
    String CHEM_APPROVE = "108010";
    //获取单位列表
    String CHEM_UNIT_LIST = "108012";
    //获取规格列表
    String CHEM_SPEC_LIST = "108013";
    //入库
    String CHEM_ADD_REAGENT = "108014";
    //领用列表
    String CHEM_RECEIVE_ALL_LITS = "108015";
    //试剂列表
    String CHEM_REAGENT_LIST = "108016";
    //根据RFID获取试剂信息（领用时）
    String CHEM_GET_REAGENT_INFO_ON_RECEIVE = "108017";
    //获取化学品详情
    String CHEM_GET_CHEM = "108018";
    //申领记录列表（扩展搜索）
    String CHEM_APPLY_LIST_EX = "108019";
    //回收列表（扩展搜索）
    String CHEM_RECYCLE_LIST_EX = "108020";
    //获取化学品汇总信息
    String CHEM_GET_SUMMARYS = "108021";
    //领用及回收统计
    String CHEM_STATS_RECEIVE_RECYCLE = "108022";
    //获取库存的化学品规（企业）
    String CHEM_GET_SPEC_QY = "108023";
    //领用（企业）
    String CHEM_RECEIVE_QY = "108024";
    //回库
    String CHEM_RECYCLE_BACK_WH = "108025";
    //仓管回收（回库）列表
    String CHEM_RECYCLE_ALL_LIST = "108026";
    //扫码获取试剂信息（企业领用时）
    String CHEM_GET_REAGENT_INFO_ON_RECEIVE_QY = "108027";
    //获取库存信息
    String CHEM_GET_WH_TOTAL_LIST = "108028";
    //申领记录列表导出
    String CHEM_APPLY_LIST_EX_EXPORT = "108029";
    //试剂轨迹列表
    String CHEM_TRAJ_LIST = "108030";
    //试剂轨迹列表（不分页）
    String CHEM_TRAJ_LIST_NO_PAGE = "108031";
    //试剂列表导出
    String CHEM_REAGENT_LIST_EXPORT = "108032";
    //领用及回收统计导出
    String CHEM_STATS_RECEIVE_RECYCLE_EXPORT = "108033";
    //获取试剂信息（根据ID）
    String CHEM_GET_REAGENT_BY_KEY = "108034";
    //试剂轨迹
    String CHEM_ADD_TRAJ = "108035";
    //试剂列表（领用预警）
    String CHEM_RECEIVE_IN_REAGENT_IDS = "108036";
    //申请领取（企业）
    String CHEM_APPLY_QY = "108037";
    //获取化学品类别
    String CHEM_CATEGORY_LIST = "108038";
    //添加化学品
    String CHEM_CHEMICAL_ADD = "108039";
    //修改化学品
    String CHEM_CATEGORY_EDIT = "108040";
    //混放预警试剂列表
    String CHEM_REAGENT_LIST_FOR_MIX = "108041";
    //根据ID获取试剂轨迹
    String CHEM_GET_TRAJ_KEY = "108042";
    //PDA入库
    String CHEM_ADD_REAGENT_PDA = "108043";
    //入库记录
    String CHEM_GET_INTOWH_BATCH_PAGE = "108044";
    //根据入库记录修改试剂
    String CHEM_EDIT_REAGENT_BY_BATCH = "108045";
    //扫码获取试剂信息（含采购人）
    String CHEM_GET_REAGENT_INFO_WITH_BELONG = "108046";
    //根据试剂名称/CAS查询库存列表
    String CHEM_STOCK_LIST_BY_NAME = "108047";
    //根据采购人姓名查询库存列表
    String CHEM_STOCK_LIST_BY_MBR_NAME = "108048";
    //试剂归属明细
    String GET_BELONG_MBR_LIST = "108049";
    //我的试剂列表
    String MY_REAGENT_SUMMARY_PAGE = "108050";
    //我的试剂数量以及试剂种类
    String MY_CHEM_STOCK_COUNT = "108051";
    //获取库存的化学品规格
    String GET_CHEM_STOCK_SUMMARY_ON_APPLY = "108052";

    //待审核记录列表
    String APPROVE_WAIT_LIST = "109001";
    //历史审核记录列表
    String APPROVE_HISTORY_LIST = "109002";
    //获取待审核记录数量
    String APPROVE_GET_WAIT_NUM = "109003";
    //获取下一步审核用户
    String APPROVE_GET_NEXT_FLOW_MEMBER = "109004";

    //是否有事件状态更新（红点提示）
    String EVT_RED_POINT = "110001";
    //验证短信验证码
    String EVT_CK_VCODE = "110002";
    //建议
    String EVT_SUGGEST = "110003";
    //发送验证码
    String EVT_SEND_VCODE = "110004";
    //公告
    String EVT_NOTICE_INSERT = "110005";
    String EVT_NOTICE_UPDATE = "110006";
    String EVT_NOTICE_DELETE = "110007";
    String EVT_NOTICE_SHOW = "110008";
    String EVT_NOTICE_PAGE = "110009";

    //项目
    //搜索项目列表
    String PRO_SEARCH_LIST = "120001";
    //项目后台列表
    String PRO_BACKEND_LIST = "120002";
    //添加项目
    String PRO_ADD = "120003";
    //修改项目
    String PRO_UPDATE = "120004";
    //获取本周的实验项目
    String PRO_WEEK_OF_PROJECT_PAGELIST = "120005";


    //仪器
    //搜索仪器列表
    String INST_SEARCH_LIST = "130001";
    //仪器预约列表
    String INSTBESPEAK_LIST = "130002";
    //查看预约详情
    String INSTBESPEAK_DETAIL = "130003";
    //提交仪器预约
    String INSTBESPEAK_ADD = "130004";
    //修改仪器使用时间
    String INSTBESPEAK_UPDATE_USETIME = "130005";
    //仪器预约审核
    String INSTBESPEAK_APPROVE = "130006";
    //获取仪器预约列表(后台)
    String INSTBESPEAK_BACKEND_List = "130007";
    //仪器后台列表
    String INST_BACKEND_LIST = "130008";
    //添加仪器
    String INST_ADD = "130009";
    //修改仪器
    String INST_UPDATE = "130010";
    //添加仪器监控设备
    String INST_CTRL_EQU_INSERT = "130011";


    //预警
    //新增预警规则
    String ADD_WARNRULE = "114001";
    //获取预警规则列表
    String GET_WARNRULE_LIST = "114002";
    //分页获取预警规则列表
    String GET_WARNRULE_PAGE_LIST = "114003";
    //删除预警规则列表记录
    String DELETE_WARNRULE = "114004";
    //新增预警记录
    String ADD_WARNRECORD= "114005";
    //更新预警记录
    String UPDATE_WARNRECORD = "114006";
    //查询预警记录
    String GET_WARNRECORDLIST = "114007";
    //添加预警记录日志
    String ADD_WARNRECORDLOG = "114008";
    //查询预警记录日志
    String GET_WARNRECORDLOGLIST = "114009";
    //查看盘点预警详情
    String GET_WARN_CHECK_DETAIL = "114010";
    //关闭或搁置预警信息
    String WARN_CLOSE_OR_DELAY = "114011";
    //app获取预警首页
    String WARN_SHOW_4_APP = "114013";
    //app获取预警信息列表
    String WARNRECORD_PAGE_4_APP = "114014";

    String WARNPERSON_ADD = "114015";
    String WARNPERSON_UPDATE = "114016";
    String WARNPERSON_DELETE = "114017";
    String WARNPERSON_PAGE_LIST = "114018";
    String WARN_ITEMNO_LIST = "114019";
    //分页显示
    String WARN_ENVIRONMENT_PAGE_LIST = "114020";
    String WARNRULE_ENVIRONMENT_EDIT = "114021";
    String WARNRULE_ENVIRONMENT_PAGE_LIST = "114022";

    //盘点
    //提交盘点结果
    String CHECK_SUBMIT = "115001";
    //获取盘点试剂轨迹
    String CHECK_CHEM_TRAJ = "115002";

    //视频监控
    //视频监控地址分页
    String GET_VMONPLACE_LIST = "116001";
    //根据地址id获取监控设备
    String GET_VMONMONITOR_LIST = "116002";
    //添加视频监控地址
    String ADD_PLACE = "116003";
    //更新视频监控地址
    String UPDATE_PLACE = "116004";
    //删除视频监控地址
    String DELETE_PLACE = "116005";
    //添加监控设备
    String ADD_MONITOR = "116006";
    //更新监控设备
    String UPDATE_MONITOR = "116007";
    //删除监控设备
    String DELETE_MONITOR = "116008";
    //监控设备分页
    String GET_MONITOR_LIST = "116009";
    //根据地址id获取监控设备
    String GET_VMONMONITOR = "116010";

    //智能中控器
    String CTRL_LAB_MSG_SHOW = "117001";
    String CTRL_INST_UNBUNDING = "117002";
    String CTRL_EQU_INST_SHOW = "117003";

    //在消息队列发布消息
    String MQ_PRODUCE = "118001";

    //获取第一级地区
    String GET_AREA_LEVEL1 = "119001";
    //获取地区信息, 并获取它的子地区信息
    String GET_AREA_TREE = "119002";
    //直接提交静态资源地址
    String SUBMIT_STATIC_URL = "119003";
    // BASE64上传文件
    String UPLOAD_B64 = "119004";
}


package yxinfo.dct.inteface.context;

/**
 * Created by hanley on 2016/6/21.
 */
public interface ErrorCode {

    String SUCCESS = "0";

    String PARAM_NOT_NULL = "001000"; //参数不能为空
    String USER_NOT_FOUND = "001001"; //用户不存在
    String PASSWORD_ERROR = "001002"; //密码错误
    String ORG_NAME_NOT_EMPTY = "001003"; //组织名称不能为空
    String ORG_ID_NOT_NULL = "001004";
    String USER_EXIST = "001005"; //用户存在
    String MOBILE_NOT_EMPTY = "001006"; //手机号码不能为空
    String ACCESS_TOKEN_NOT_EMPTY = "001007"; //AccessToken不能为空
    String ACCESS_TOKEN_INVALID = "001008"; //AccessToken 失效
    String NAME_NOT_EMPTY = "001009"; //名称不能为空
    String MEMBER_ID_NOT_EMPTY = "001010"; //用户id不能为空
    String CAN_NOT_REGISTER = "001011"; //不允许注册的用户
    String USER_REGISTER_MSG_NOT_MEET = "001012"; //用户资料不正确
    String USER_REGISTER_MUST_VCODE = "001013"; //请先验证手机
    String PWD_NOT_EMPTY = "001014"; //密码不能为空
    String REAL_NAME_NOT_EMPTY = "001015"; //姓名不能为空
    String LOGIN_NAME_NOT_EMPTY = "001016"; //登录名不能为空
    String USER_CODE_NOT_EMPTY = "001017"; //人员编号不能为空
    String USER_PWD_ERR_TOO_MUCH = "001018"; //登录输入密码错误次数过多
    String MEMBER_FCODE_IS_REPEAT = "001019";//成员编号已存在
    String MEMBER_LOGINNAME_IS_REPEAT = "001020";//成员登陆名已存在
    String DATE_NOT_EMPTY = "001021";//日期不能为空
    String UPLOAD_ERROR = "001022";//文件上传失败
    String MEMBER_MSG_HAS_INPUT = "001023";//用户已录入资料, 请使用认证注册
    String NO_DATA = "001024";//没有数据


    //审核模块（002） 002034
    String APPROVE_EXEC_ID_NOT_EMPTY = "002002"; //审核方案id不能为空
    String APPROVE_EXTMSG_ERROR = "002011"; //额外信息错误
    String APPROVE_ORG_ID_NOT_EMPTY = "002003"; //组织id不能为空
    String APPROVE_ITEM_NO_NOT_EMPTY = "002013"; //审核项目编号不能为空
    String APPROVE_ITEM_NO_LENGTH = "002014"; //审核项目编号长度必须小于10
    String APPROVE_ON_MEMBER_ID_NOT_EMPTY = "002006"; //必须指定审核人
    String APPROVE_NO_RIGHT_TO_APPROVE = "002030"; //无权审核此单据
    String APPROVE_NO_RIGHT_TO_APPROVE_NEXT = "002031"; //选择的下一位审核人无权审核此单据

    String APPROVE_RECODE_ID_NOT_EMPTY = "002001"; //审核记录id不能为空
    String APPROVE_RECODE_NOT_EXIST = "002009"; //审核记录不存在
    String APPROVE_RECODE_HAS_FIN = "002010"; //审核已结束
    String APPROVE_RECODE_EXT_MSG_ID_NOT_EMPTY = "002029"; //审核额外信息id不能为空

    String APPROVE_EXEC_NOT_EXIST = "002007"; //审核方案不存在
    String APPROVE_EXEC_FLOW_NOT_EXIST = "002008"; //审核方案过程未配置
    String APPROVE_EXEC_FLOW_ERROR = "002012"; //审核方案过程配置异常
    String APPROVE_EXEC_NAME_LENGTH = "002015"; //审核项目名称长度必须小于255
    String APPROVE_EXEC_NAME_NOT_EMPTY = "002016"; //审核项目名称不能为空
    String APPROVE_EXEC_REMARK_LENGTH = "002017"; //审核项目备注长度必须小于255
    String APPROVE_EXEC_TYPE_NOT_EMPTY = "002018"; //审核项目过程类型不能为空
    String APPROVE_EXEC_TYPE_LENGTH = "002019"; //审核项目过程类型长度必须等于1

    String APPROVE_NODE_MEMBERID_NOT_EMPTY = "002020"; //审核人id不能为空
    String APPROVE_NODE_STATUS_LENGTH = "002021"; //审核状态长度必须等于1
    String APPROVE_NODE_STATUS_NOT_EMPTY = "002022"; //审核状态不能为空
    String APPROVE_NODE_OPINION_LENGTH = "002023"; //审核意见长度必须小于255
    String APPROVE_NODE_ARID_NOT_EMPTY = "002024"; //审核流程记录id不能为空
    String APPROVE_NODE_ISEND_LENGTH = "002025"; //是否结束自由模式标志长度必须等于1

    String APPROVE_SUBMIT_ORG_ID_NOT_EMPTY = "002026"; //审核提交人组织id不能为空
    String APPROVE_SUBMIT_MEMBER_NOT_EMPTY = "002027"; //审核提交人id不能为空
    String APPROVE_SCH_M_NAME_NOT_EMPTY = "002028"; //搜索审核人姓名不能为空

    String APPROVE_NO_RIGHT_TO_REVOKE = "002032"; //无权撤销
    String APPROVE_REVOKE_NEXT_HAS_APV = "002033"; //下一位审核人已审核, 无法撤销
    String APPROVE_FAIL_PREVIOUS_AT = "002034"; //撤销失败

    // 试题模块开始（003）
    String QUESTION_CATEGID_LENGTH = "003029";//类目ID须为整数且长度小于10
    String QUESTION_CATEGID_NOTNULL = "003031";//类目ID不可为空

    String QUESTION_FCATEGNAME_LENGTH = "003001";//类目名称长度须小于255
    String QUESTION_FCATEGNAME_NOTNULL = "003002";//类目名称不能为空
    String QUESTION_QUESTTYPE_LENGTH = "003005";//试题标题的长度为1
    String QUESTION_QUESTTYPE_NOTNULL = "003006";//试题类型不可为空
    String QUESTION_QUESTANALYSE_LENGTH = "003007";//试题解析的长度须小于2000
    String QUESTION_QUESTANALYSE_NOTNULL = "003008";//试题解析不可为空
    String QUESTION_QUESTANSWER_LENGTH = "003009";//试题答案的长度须小于255
    String QUESTION_QUESTANSWER_NOTNULL = "003010";//试题答案不可为空
    String QUESTION_QUESTCONTEXT_LENGTH = "003013";//试题内容的长度须小于2000
    String QUESTION_QUESTCONTEXT_NOTNULL = "003014";//试题内容不可为空
    String QUESTION_QUESTOPTCODE_LENGTH = "003015";//试题选项编号的长度为1
    String QUESTION_QUESTOPTCODE_NOTNULL = "003016";//试题选项编号不可为空
    String QUESTION_QUESTOPTTEXT_LENGTH = "003017";//试题选项内容的长度为500
    String QUESTION_QUESTOPTTEXT_NOTNULL = "003018";//试题选项内容不可为空

    String QUESTION_INSERT_CATEG_ERROR = "003019";//插入试题类目表失败
    String QUESTION_ADDCATEGQUEST_ERROR = "003020";//新增类目试题信息
    String QUESTION_INSERT_QUQUEST_ERROR = "003021";//插入试题表失败
    String QUESTION_INSERT_QUESTCATEG_ERROR = "003022";//插入试题类目关系表失败
    String QUESTION_INSERT_QUESTANALYSE_ERROR = "003023";//插入试题解析表失败

    String QUESTION_INSERT_QUESTANSWER_ERROR = "003024";//插入试题答案失败
    String QUESTION_INSERT_QUESTCONTEXT_ERROR = "003025";//插入试题内容失败
    String QUESTION_INSERT_QUESTOPT_ERROR = "003026";//插入试题选项表失败

    String QUESTION_SEARCH_QUESTSBYCATEGID_ERROR = "003027";//根据类目查询试题失败
    String QUESTION_SEARCH_CATEGS_ERROR = "003028";//查询类目失败

    String QUESTION_CATEGDESCRIBE_LENGTH = "003040";//类目描述的长度须小于255
    String LAB_ORGID_ISNULL_ERROR = "003043";//组织id不可为空
    String LAB_MEMBERID_ISNULL_ERROR = "003044";//登录人id不可为空
    String QUESTION_INSERT_CATEGID_ERROR = "003041";//未找到对应的类目
    String QUESTION_INSERT_FTYPEVALUE_ERROR = "003042";//试题类型的格式有误

    // 实验室模块开始（004）
    String LAB_LABNAME_LENGTH = "004001";//实验室名称的长度须小于100
    String LAB_LABNAME_NOTNULL = "004002";//实验室名称不可为空
    String LAB_LABCODE_LENGTH = "004003";//实验室编号的长度须小于100
    String LAB_LABCODE_NOTNULL = "004004";//实验室编号不可为空
    String LAB_LABSTATUS_LENGTH = "004005";//实验室状态的长度须小于1
    String LAB_LABSTATUS_NOTNULL = "004006";//实验室状态不可为空
    String LAB_LABLEVEL_LENGTH = "004007";//实验室级别的长度须小于100
    String LAB_ORGID_LENGTH = "004008";//组织id须为整数且长度小于10
    String LAB_ORGID_NOTNULL = "004009";//组织id不可为空
    String LAB_PID_LENGTH = "004010";//实验室上级id须为整数且长度小于10
    String LAB_LABREMARK_LENGTH = "004011";//实验室备注的长度须小于255

    String LAB_LABID_LENGTH = "004012";//id须为整数且长度小于10
    String LAB_LABID_NOTNULL = "004013";//id不可为空
    String LAB_LABMEMBERID_LENGTH = "004014";//实验室管理员id须为整数且长度小于10
    String LAB_LABMEMBERID_NOTNULL = "004015";//实验室管理员id不可为空

    String LAB_FTYPE_LENGTH = "004016";//实验室管理员类型的长度须小于1
    String LAB_FTYPE_NOTNULL = "004017";//实验室管理员类型不可为空

    String LAB_DELETE_LABMANAGER_ERROR = "004022";//实验室负责人删除失败
    String LAB_DELETE_LAB_ERROR = "004018";//根据实验室id删除失败
    String LAB_SEARCH_LAB_ERROR = "004019";//查询实验室信息失败
    String LAB_SEARCH_LABMANAG_ERROR = "004020";//查询实验室负责人信息失败
    String LAB_UPDATE_LAB_ERROR = "004021";//更新实验室信息失败
    String LAB_INSERT_LABMANAGER_ERROR = "004023";//插入实验室负责人信息失败
    String LAB_INSERT_LAB_ERROR = "004024";//插入实验室信息失败

    String LAB_LABMEPHONE_LENGTH = "004025";//联系电话长度应小于20
    String LAB_LABMEPHONE_NOTNULL = "004026";//联系电话不可为空
    String LAB_SEARCH_LABFID_ERROR = "004027";//查询时fid不可为空
    String LAB_LABDANGERSOURCE_LENGTH = "004028";//危险源的长度须小于255
    String LAB_RFFCODE_LENGTH = "004029";//rfid设备号的长度须小于100
    String LAB_IMPORT_LAB_ERROR = "004030";//导入实验室失败
    String LAB_IMPORT_CHECKLAB_ERROR = "004031";//验证实验室字段失败
    String LAB_IMPORT_TRANSFORMLAB_ERROR = "004032";//转化导入实体失败
    String LAB_IMPORT_MANALAB_ERROR = "004033";//处理导入实验室中的实验室管理人员失败
    String UPLOAD_FILE_ERROR = "004034";//上传文件到服务器失败
    String EXPORT_LAB_ERROR = "004035";//导出excel失败
    String LAB_ROOMNUM_LENGTH = "004036";//楼宇及房间号的长度须小于50
    String LAB_ADDRESS_LENGTH = "004037";//实验室位置的长度须小于100
    String LAB_PURPOSE_LENGTH = "004038";//实验室类型的长度须小于2

    String FKEY_NOT_NULL = "004039";//配置key不能为空
    String VAL_NOT_NULL = "004040";//配置值不能为空
    String EDIT_SETTINGS_ERROR = "004041";


    //课题日志（005）
    String TOPICLOG_INSERT_TOPICLOG_ERROR = "005001";//添加课题日志信息失败
    String TOPICLOG_INSERT_TOPICLOGCTX_ERROR = "005002";//添加课题日志内容信息失败
    String TOPICLOG_INSERT_TOPICLOGREAG_ERROR = "005003";//添加课题日志与试剂关系表信息失败
    String TOPICLOG_SEARCH_TOPICLOG_ERROR = "005004";//查询课题日志信息出错
    String TOPICLOG_TRANSFORM_TOPICLOG_ERROR = "005005";//课题日志DTO转Model出错
    String TOPICLOG_SEARCH_NAME_ERROR = "005006";//调用服务获取人员名称或实验室名称出错
    String TOPICLOG_SEARCH_TOPICLOGCTX_ERROR = "005007";//获取课题日志内容出错
    String TOPICLOG_SEARCH_TOPICLOGREAGENT_ERROR = "005008";//获取课题日志对应试剂内容出错
    String TOPICLOG_UPDATE_TOPICLOG_ERROR = "005009";//更新课题日志表出错
    String TOPICLOG_UPDATE_TOPICLOGCTX_ERROR = "005010";//更新课题日志内容表出错
    String TOPICLOG_UPDATE_TOPICLOGREAGENT_ERROR = "005011";//更新课题日志与试剂关系表出错

    String TOPICLOG_LOGID_LENGTH = "005012";//日志id须为整数且长度小于10
    String TOPICLOG_LOGID_NOTNULL = "005013";//日志id不可为空
    String TOPICLOG_MEMBERID_LENGTH = "005014";//使用成员id须为整数且长度小于10
    String TOPICLOG_MEMBERID_NOTNULL = "005015";//使用成员id不可为空
    String TOPICLOG_ISSUESNAME_LENGTH = "005016";//课题名称应小于100
    String TOPICLOG_ISSUESNAME_NOTNULL = "005017";//课题名称不可为空
    String TOPICLOG_PURPOSE_LENGTH = "005018";//课题类型长度须小于2

    String TOPICLOG_EXPTLENGTH_LENGTH = "005022";//实验时长须为整数且长度小于10
    String TOPICLOG_LABID_LENGTH = "005023";//实验室id须为整数且长度小于10
    String TOPICLOG_TEACHERID_LENGTH = "005025";//教师id须为整数且长度小于10
    String TOPICLOG_CONTEXT_LENGTH = "005027";//课题日志内容长度须小于2000
    String TOPICLOG_REAGENTID_LENGTH = "005028";//试剂id须为整数且长度小于10
    String TOPICLOG_REAGENTID_NOTNULL = "005029";//试剂id不可为空
    String TOPICLOG_USED_LENGTH = "005030";//试剂用量的长度须小于255
    String TOPICLOG_USED_NOTNULL = "005031";//试剂用量不可为空

    String TOPICLOG_INSERT_TOPICLOGIMG_ERROR = "005032";//添加课题日志中实验内容对应图片失败
    String TOPICLOG_STATICID_LENGTH = "005033";//静态资源id须为整数且长度小于10
    String TOPICLOG_STATICID_NOTNULL = "005034";//静态资源id不可为空
    String TOPICLOG_UPDATE_TOPICLOGIMG_ERROR = "005035";//保存课题日志中的日志与图片关系表出错
    String TOPICLOG_SEARCH_TOPICLOGCTXIMG_ERROR = "005036";//获取课题日志内容中对应图片出错
    String TOPICLOG_EXPORT_TOKEN_ERROR = "005037";//token为必传字段

    //仓库管理（006）
    String WH_INSERT_WH_ERROR = "006001";//新增仓库信息错误
    String WH_INSERT_WHMANAGER_ERROR = "006002";//新增仓库管理人信息出错
    String WH_UPDATE_WH_ERROR = "006003";//更新仓库信息出错
    String WH_UPDATE_WHMANAGER_ERROR = "006004";//更新仓库管理人信息出错
    String WH_DELETE_WH_ERROR = "006005";//删除仓库信息出错
    String WH_DELETE_WHMANAGER_ERROR = "006006";//删除仓库管理人信息出错

    String WH_WHID_LENGTH = "006007";//仓库id须为整数且长度小于10
    String WH_WHID_NOTNULL = "006008";//仓库id不可为空
    String WH_WHTYPE_LENGTH = "006009";//仓库类型的长度须小于2
    String WH_WHTYPE_NOTNULL = "006010";//仓库类型不可为空
    String WH_WHCODE_LENGTH = "006011";//仓库编号的长度须小于100
    String WH_WHCODE_NOTNULL = "006012";//仓库编号不可为空
    String WH_WHNAME_LENGTH = "006013";//仓库名称的长度须小于255
    String WH_WHNAME_NOTNULL = "006014";//仓库名称不可为空
    String WH_MEMBERID_LENGTH = "006015";//仓库管理人id须为整数且长度小于10
    String WH_MEMBERID_NOTNULL = "006016";//仓库管理人id不可为空

    String WH_SEARCH_WH_ERROR = "006017";//查询仓库信息出错
    String WH_ADDRESS_LENGTH = "006018";//地址的长度须小于100
    String WH_AREA_LENGTH = "006019";//面积的长度须小于50

    //设备管理（007）
    String EQU_INSERT_EQUIPMENT_ERROR ="007001"; //新增设备信息出错
    String EQU_DELETE_EQUIPMENT_ERROR ="007002"; //删除设备信息出错
    String EQU_UPDATE_EQUIPMENT_ERROR ="007003"; //更新设备信息出错
    String EQU_SEARCH_EQUIPMENT_ERROR ="007004"; //查询设备信息出错
    String EQU_INSERT_EQURFID_ERROR ="007005";   //新增RFID卡信息出错
    String EQU_DELETE_EQURFID_ERROR ="007006";   //删除RFID卡信息出错
    String EQU_UPDATE_EQURFID_ERROR ="007008";   //更新RFID卡信息出错
    String EQU_SEARCH_EQURFID_ERROR ="007009";   //查询RFID卡信息出错

    String EQU_RFIDID_LENGTH = "007010";          //Rfid卡id必须为整数且长度小于10
    String EQU_RFIDID_NOTNULL = "007011";         //Rfid卡id不可为空
    String EQU_RFIDFCODE_LENGTH = "007012";         //Rfid码长度必须小于100
    String EQU_RFIDFCODE_NOTNULL = "007013";         //Rfid码不可为空
    String EQU_RFIDSTATUS_LENGTH = "007014";         //Rfid卡状态长度必须小于2
    String EQU_RFIDSTATUS_NOTNULL = "007015";         //Rfid卡状态不可为空
    String EQU_EQUIPMENTID_LENGTH = "007016";          //设备id必须为整数且长度小于10
    String EQU_EQUIPMENTID_NOTNULL = "007017";         //设备id不可为空
    String EQU_EQUIPMENT_ORGID_LENGTH = "007018";          //组织id必须为整数且长度小于10
    String EQU_EQUIPMENTID_ORGID_NOTNULL = "007019";         //组织id不可为空
    String EQU_EQUIPMENT_MACADDRESS_LENGTH = "007020";          //物理地址长度必须小于255
    String EQU_EQUIPMENTID_MACADDRESS_NOTNULL = "007021";         //物理地址不可为空
    String EQU_RFIDIDUSEAT_NOTNULL_ = "007022";          //使用时间不能为空
    String EQU_EQUIPMENTID_EQUNO_NOTNULL = "007023";          //设备编号不能为空


    //化学品（008） 008040
    String CHEM_RECYCLE_REAGENT_NOT_ON_USE = "008002"; //回收的试剂不是使用中状态
    String CHEM_RECEIVE_REAGENT_NOT_ON_WH = "008003"; //领取的试剂不是库存中
    String CHEM_REAGENT_CAN_NOT_RECEIVE = "008004"; //不可领取试剂
    String CHEM_RECEIVE_NO_STOCK = "008005"; //库存不足
    String CHEM_REAGENT_RFID_NOT_EXIST = "008006"; //扫描的rfid码对应的试剂不存在
    String CHEM_RFID_NOT_EXIST = "008001"; //扫描的rfid码不存在
    String CHEM_NO_WH = "008027"; //仓库不存在
    String CHEM_ITEM_NO_NOT_EMPTY = "008028"; //统计项目不能为空

    String CHEM_CHEM_ID_NOT_EMPTY = "008007"; //化学品id不能为空
    String CHEM_SPEC_ID_NOT_EMPTY = "008008"; //规格id不能为空
    String CHEM_CAPACITY_NOT_EMPTY = "008009"; //容量不能为空
    String CHEM_UNIT_ID_NOT_EMPTY = "008020"; //计量单位id不能为空
    String CHEM_MEMBER_ID_NOT_EMPTY = "008022"; //用户id不能为空
    String CHEM_ORG_ID_NOT_EMPTY = "008023"; //组织id不能为空
    String CHEM_WH_ID_NOT_EMPTY = "008024"; //仓库id不能为空
    String CHEM_LAB_ID_NOT_EMPTY = "008025"; //实验室id不能为空
    String CHEM_STATUS_NOT_EMPTY = "008026"; //化学试剂状态不能为空

    String CHEM_APLY_MEMBER_ID_NOT_EMPTY = "008010"; //化学品申请人id不能为空
    String CHEM_APLY_ORG_ID_NOT_EMPTY = "008011"; //申请人组织不能为空
    String CHEM_APLY_ISSUESNAME_NOT_EMPTY = "008012"; //课题名称不能为空
    String CHEM_APLY_ISSUESNAME_LENGTH = "008013"; //课题名称长度必须小于30
    String CHEM_APLY_PURPOSE_NOT_EMPTY = "008014"; //用途不能为空
    String CHEM_APLY_PURPOSE_LENGTH = "008015"; //用途长度必须小于30
    String CHEM_APLY_APPOINT_AT_NOT_EMPTY = "008016"; //预约领取时间不能为空
    String CHEM_APLY_REAGENTS_NOT_EMPTY = "008017"; //申请领取的化学试剂不能为空
    String CHEM_APLY_APPROVE_M_ID_NOT_EMPTY = "008018"; //审核老师/仓库管理员id不能为空

    String CHEM_REAGENT_ORG_ID_NOT_EMPTY = "008019"; //试剂所属组织不能为空
    String CHEM_REAGENT_RF_CODE_NOT_EMPTY = "008021"; //rfid码不能为空
    String CHEM_MSG_ID_NOT_EMPTY = "008029"; //额外信息不能为空
    String CHEM_USED_TOO_LARGE = "008030";//用量大于剩余量
    String CHEM_USED_NOT_EMPTY = "008031";//用量不能为空
    String CHEM_REAGENT_CAN_NOT_RECYCLE = "008032";//不可回收试剂
    String CHEM_REAGENT_ID_NOT_EMPTY = "008033";//试剂id不能为空
    String CHEM_AR_ID_NOT_EMPTY = "008034";//申领记录id不能为空
    String CHEM_CAS_NOT_EMPTY = "008035";//CAS不能为空
    String CHEM_REAGENT_EDIT_NOT_IN_WH = "008036";//非库存中的试剂不能修改
    String CHEM_INTOWH_BATCH_ID_NOT_EMPTY = "008037";//入库记录ID不能为空

    String CHEM_NAME_REPEAT = "008038"; //化学试剂名称重复
    String CHEM_RFCODE_HAS_ADD = "008039"; //二维码已被使用
    String CHEM_QR_ERROR = "008040"; //二维码不合法

    //事件通知（009）
    String EVT_VCODE_TOO_OFTEN = "009001"; //发送短信过于频繁
    String EVT_VCODE_TOO_OFTEN_DAY = "009002"; //短信请求超过限制，请24小时后重试
    String EVT_VCODE_USE_AT_NOT_EMPTY = "009003"; //用于的功能码不能为空
    String EVT_VCODE_MOBILE_NOT_EMPTY = "009004"; //手机号不能为空
    String EVT_VCODE_CODE_NOT_EMPTY = "009005"; //验证码不能为空

    String EVT_VCODE_NOT_SEND = "009006"; //短信验证码不存在
    String EVT_VCODE_INVALID = "009007"; //短信验证码验证超限
    String EVT_VCODE_EXPIRE = "009008"; //短信验证码超时
    String EVT_VCODE_NOT_MEET = "009009"; //短信验证码不正确

    String EVT_ITEM_NO_NOT_EMPTY = "009010"; //事件项目编号不能为空
    String EVT_NUM_NOT_EMPTY = "009011"; //事件数量不能为空
    String EVT_NOTIFY_TYPE_NOT_EMPTY = "009012"; //事件通知类型不能为空
    String EVT_TITLE_NOT_EMPTY = "009013"; //事件通知标题不能为空
    String EVT_SUGGEST_TYPE_NOT_EMPTY = "009014"; //建议类型不能为空
    String EVT_SUGGEST_CONTEXT_NOT_EMPTY = "009015"; //建议内容不能为空
    String EVT_SUGGEST_CONTEXT_LENGTH = "009016"; //建议内容不能超过2000字

    String EVT_NOTICE_CONTENT_NOT_EMPTY = "009017";//公告内容不能为空
    String EVT_NOTICE_INSERT_ERROR = "009018";
    String EVT_NOTICE_UPDATE_ERROR = "009019";
    String EVT_NOTICE_DELETE_ERROR = "009020";
    String EVT_NOTICE_SHOW_ERROR = "009021";
    String EVT_TERMINAL_NOT_EMPTY = "009022";//终端类型编号不能为空

    //资源（010）
    String RES_UPLOAD_CODE_ERROR = "010001";//静态资源业务代码错误
    String RES_UPLOAD_SUFFIX_ERROR = "010002";//不允许上传的文件类型
    String RES_UPLOAD_SIZE_LIMIT = "010003";//上传的文件太大
    String RES_URL_NOT_EMPTY = "010004";//地址不能为空
    String RES_UB_ID_NOT_EMPTY = "010005";//资源上传约束id不能为空

    //仪器(011)
    String INST_BESPEAK_PROID_NOT_EMPTY = "011001";//项目ID不能为空
    String INST_BESPEAK_USE_NOT_EMPTY = "011002";//仪器预约用途不能为空
    String INST_BESPEAK_INST_NOT_NULL = "011003";//预约仪器不能为空
    String INST_BESPEAK_STARTTIME_NOT_EMPTY = "011004";//预约开始时间不能为空
    String INST_BESPEAK_ENDTIME_NOT_EMPTY = "011005";//预约结束时间不能为空
    String INST_BESPEAK_TIME_IS_LESS= "011006";//预约时间应大于当前系统时间
    String INST_BESPEAK_ENDTIME_IS_LESS = "011007";//预约结束时间应该大于预约开始时间
    String INST_BESPEAK_INSTID_NOT_NULL = "011008";//仪器id不能为空
    String INST_BESPEAK_INSTBSKID_NOT_NULL = "011009";//预约id不能为空
    String INST_BESPEAK_INST_NOT_FOUND = "011010";//扫码的设备未找到
    String INST_BESPEAK_ADD_ERROR = "011011";
    String INST_BESPEAK_UPDATE_USETIME_ERROR = "011012";
    String INST_FNAME_NOT_EMPTY = "011013";//仪器名称不能为空
    String INST_ADD_ERROR = "011014";//添加仪器失败
    String INST_UPDATE_ERROR = "011015";//修改仪器失败

    String INSTRUNRECORD_INSERT_ERROR = "011016";
    String INSTRUNRECORD_UPDATE_ERROR = "011017";


    //盘点(012)
    String CHECK_RECODE_ORGID_NOT_EMPTY = "012001";//组织ID不能为空
    String CHECK_RECODE_MEMBERID_NOT_EMPTY = "012002";//盘点人ID不能为空
    String CHECK_RECODE_WHID_NOT_EMPTY = "012003";//仓库ID不能为空
    String CHECK_RECODE_RFIDLIST_NOT_EMPTY = "012004";//盘点试剂不能为空
    String CHECK_RECODE_SUBMIT_ERROR = "012005";//盘点失败
    String CHECK_RECODE_CHECKCHEMID_NOT_NULL = "012006";//盘点记录试剂ID不能为空
    String CHECK_RECODE_GET_TARJ_ERROR = "012007";//查询盘点试剂轨迹失败

    //预警模块（013）
    String GET_WARNRULE_LIST_ERROR = "013001";//获取预警规则列表失败
    String ADD_WARNRULE_ERROR = "013002";//新增预警规则列表失败
    String ADD_WARNRECORD_ERROR = "013003";//新增预警记录失败
    String UPDATE_WARNRECORD_ERROR = "013004";//更新预警记录失败
    String GET_WARNRECORDLIST_ERROR = "013005";//查询预警记录失败
    String ADD_WARNRECORDLOG_ERROR = "013006";//添加预警记录日志失败
    String GET_WARNRECORDLOGLIST__ERROR = "013007";//查询预警记录日志失败
    String DELETE_WARNRULE_ERROR = "013008";//删除预警规则失败
    String UPDATE_WARNRULE_ERROR = "013019";//更新预警规则失败

    String ITEM_NO_NOT_NULL = "013009";//预警项目不能为空
    String STATUS_NOT_NULL = "013010";//状态不能为空
    String WARN_CLOSE_ERROR = "013011";//预警关闭失败
    String WARN_DELAY_ERROR = "013012";//预警搁置失败
    String RECYCLE_IS_NULL = "013036";//未找到回收记录的信息

    String WARN_ITEMNO_LENGTH = "013013";//预警项目编号长度必须小于6
    String WARN_ITEMNO_NOTNULL = "013014";//预警项目编号不可为空
    String WARN_WARNFOR_LENGTH = "013015";//预警事物标识必须为整数且长度小于10
    String WARN_LIMITLEFT_LENGTH = "013016";//限制范围左值长度必须小于200
    String WARN_LIMITRIGHT_LENGTH = "013017";//限制范围右值长度必须小于200
    String WARN_MEMBERID_LENGTH = "013018";//成员id必须为整数且长度小于10

    String TASK_GET_WARNRECORD_ERROR = "013020";//生成一条预警记录失败
    String TASK_GET_CHEMLIST_ERROR = "013021";//获取人员领用化学品记录出错
    String WARN_IS_CLOSED = "013022";//预警信息已经关闭，不能重复操作
    String WARN_IS_DELAYED = "013023";//预警信息已经搁置，不能重复操作
    String GET_ORGLIST_ERROR = "013024";//查询所有组织出错
    String HANDLER_BEYOND_TIME_ERROR = "013025";//处理领用后超出未出现时间的处理业务出错
    String HANDLER_BEYOND_QUANTITY_ERROR = "013026";//处理领用超出数量的处理业务出错
    String GET_HOMEPAGE_WARNINFO__ERROR = "013027";//获取首页信息预警信息失败
    String GET_WARNINFO_ITEMNO_ERROR = "013028";//获取首页预警信息时ItemNo为必传项

    String TASK_GET_RECYCLEUSERD_ERROR = "013029";//查看试剂使用量是否超出限额出错
    String TASK_ISEXIST_WARNRECORD_ERROR = "013030";//验证预警记录是否存在出错

    String WARN_PERSON_ITEMNO_NOT_NULL = "013031";//预警类型不能为空
    String WARN_PERSON_ADD_ERROR = "013032";
    String WARN_PERSON_UPDATE_ERROR = "013033";
    String WARN_PERSON_DELETE_ERROR = "013034";
    String ADD_WARNRULE_IS_EXIST_ERROR = "013035";//该预警规则已存在

    //项目(014)
    String PRO_FNAME_NOT_EMPTY = "014001";//项目名称不能为空
    String PRO_ADD_ERROR = "014002";
    String PRO_UPDATE_ERROR = "014003";

    //视频监控
    String GET_PLACE_LIST_ERROR ="016001";//分页查询视频监控地址失败
    String ADD_PLACE_ERROR ="016002";//添加视频监控地址失败
    String UPDATE_PLACE_ERROR ="016003";//更新视频监控地址失败
    String DELETE_PLACE_ERROR ="016004";//删除视频监控地址失败
    String GET_MONITOR_LIST_BYPLACEID_ERROR ="016005";//根据地址id获取监控设备失败
    String UPDATE_MONITOR_ERROR ="016006"; //更新监控设备失败
    String ADD_MONITOR_ERROR ="016007";//添加监控设备失败
    String DELETE_MONITOR_ERROR ="016008";//删除监控设备失败
    String PLACE_ID_NOT_NULL = "016009";//视频监控地址id不允许为空
    String GET_MONITOR_LIST_ERROR ="016010";//分页查询监控设备失败
    String GET_PLACE_BYKEY_ERROR ="016011";//根据id查询视频监控地址失败

    String VMON_PLACEID_LENGTH ="016012";//视频监控地址id必须为整数且长度小于10
    String VMON_PLACEID_NOTNULL = "016013";//视频监控地址id不能为空
    String VMON_PLACEADDRESS_LENGTH ="016014";//视频监控地址长度必须小于255
    String VMON_PLACEADDRESS_NOTNULL = "016015";//视频监控地址不能为空
    String VMON_MONITORID_LENGTH ="016016";//监控设备id必须为整数且长度小于10
    String VMON_MONITORID_NOTNULL = "016017";//监控设备id不能为空
    String VMON_MONITORIP_LENGTH = "016018";//监控设备ip长度必须小于100
    String VMON_MONITORPORT_LENGTH = "016019";//监控设备端口长度必须小于20
    String VMON_MONITORIPUSERNAME_LENGTH = "016020";//监控设备用户名长度必须小于100
    String VMON_MONITORPWD_LENGTH = "016021";//监控设备密码长度必须小于100

    //智能中控器
    String CTRL_INSERT_EQU4INST_ERROR = "017001";//插入仪器监控设备失败
    String INST_ID_NOT_NULL = "017002";//仪器id不能为空

    String EDIT_INSTRUNRECORD_ERROR = "017003";

    String GET_INSTRUNRECORD_ERROR = "017004";

    String EQU_PURPOSE_NOT_EMPTY = "017005";

    String EQU_SITE_ID_NOT_NULL = "017006";

    String CTRL_GET_TEMP_HUM_ERROR = "017007";

    String CTRL_EQU_NOT_EXIST = "017008";

    String EDIT_TEMP_HUM_ERROR = "017009";

    String EQU_PURPOSE_ERROR = "017010";

    String EQU_EXIST = "017011";

    String INST_HAVE_EQU = "017012";

    String EQU_HAVE_INST = "017013";

    String INST_UNBUNDING_ERROR = "017014";


}

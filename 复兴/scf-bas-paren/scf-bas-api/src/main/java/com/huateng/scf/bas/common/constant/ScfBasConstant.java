/**
 * 
 */
package com.huateng.scf.bas.common.constant;

/**
 * <p>
 * 供应链金融平台公共-业务常量
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月24日下午4:04:17
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月24日下午4:04:17              新增
 *
 *            </pre>
 */
public class ScfBasConstant {
	public static final String SYS_CODE = "SCF";// 系统代码
	public static final String RMB = "CNY";
	
	public static final String QUERY_LIMITS = "queryLimits";
	/**
	 * 规则引擎常量 
	 */
	public static final String RULES_PROJECT_NAME = "SCF_PROJECT";// 规则项目名称
	public static final String ADAPTER_ID = "adapterId";//adapterId
	public static final String RULES_TRANS = "trans";//规则trans参数名称
	public static final String RULES_TYPE = "rulesType";//规则类型 1-普通规则 2-决策表 3-决策树 4-评分卡 5-规则流
	public static final String RULES_TYPE_VALUE_4 = "4";// 4-评分卡
	public static final String RULES_TYPE_VALUE_3 = "3";// 3-评级结果
	public static final String RULES_TYPE_VALUE_5 = "5";// 5-客户产品定价
	public static final String RULES_TYPE_VALUE_6 = "6";// 6-利率定价
	public static final String RULES_ADAPTER_SCORECARDRULE = "scoreCardRuleAdapter";//评分卡规则
	public static final String RULES_ADAPTER_GRADERESULTRULE = "gradeResultRuleAdapter";//评级结果规则
	public static final String RULES_ADAPTER_CUSTPRICINGGROUPRULE = "custPricingGroupRuleAdapter";//客户产品定价规则
	public static final String RULES_ADAPTER_PRODPRICINGTABLERULE = "prodPricingTableRuleAdapter";//产品利率定价规则
	public static final String RULES_SETNAME = "Default_RuleSet";//规则集名称
	public static final String RULES_VERSION = "ruleVersion";//执行的基线版本
	public static final String RULES_SET_VERSION = "ruleSetVersion";//规则集版本
	public static final String RULES_VERSION_SCORECARD = "ScoreCard_ruleVersion";//评分卡执行的基线版本
	public static final String RULES_VERSION_SUPSCORECARD = "SupScoreCard_ruleVersion";//供应商评分卡执行的基线版本
	public static final String RULES_SET_VERSION_SCORECARD = "ScoreCard_ruleSetVersion";//评分卡规则集版本
	public static final String RULES_SET_VERSION_SUPSCORECARD = "SupScoreCard_ruleSetVersion";//供应商评分卡规则集版本
	public static final String RULES_SET_VERSION_OUTSUPSCORECARD = "OutSupScoreCard_ruleSetVersion";//外部供应商评分卡规则集版本
	public static final String RULES_SET_VERSION_MONISCORECARD = "MoniScoreCard_ruleSetVersion";//供应商评分卡规则集版本
	public static final String RULES_SET_VERSION_GRADERESULT = "GradeResult_ruleSetVersion";//评级结果规则集版本
	public static final String RULES_SET_VERSION_CUSTPRICINGGROUP = "CustPricingGroup_ruleSetVersion";//客户产品定价规则集版本
	public static final String RULES_SET_VERSION_PRODPRICINGTABLE = "ProdPricingTable_ruleSetVersion";//利率定价规则集版本
	public static final String RULES_SET_VERSION_CUSTPRICEADJUSTGROUP = "CustPriceAdjustGroup_ruleSetVersion";//客户产品调价规则集版本
	public static final String RULES_SET_VERSION_CUSTDISCOUNTGROUP = "CustDiscountGroup_ruleSetVersion";//客户产品折扣规则集版本
	
	/**
	 * 多方协议表协议类型常量
	 */
	public static final String MUTI_PROTOCOL_MONI = "01";// 监管协议
	public static final String MUTI_PROTOCOL_FOURWH = "02";// 四方保兑仓协议
	public static final String MUTI_PROTOCOL_AUTOFINANCE = "03";// 汽车金融协议
	public static final String MUTI_PROTOCOL_FACTOR = "04";// 保理协议
	public static final String MUTI_PROTOCOL_PLDEGE = "05";// 应收账款质押协议
	public static final String MUTI_PROTOCOL_ORDER = "06";// 订单协议
	public static final String MUTI_PROTOCOL_THREEWH = "07";// 三方保兑仓协议
	public static final String MUTI_PROTOCOL_CAR = "08";// 汽车先票/款后货协议

	/** 请求报文的DOCUMENT */
	public static final String REQ_DOCUMENT = "REQ_DOCUMENT";
	public static final String ORDER_PARAM_TYPE = "01";// 融资比例
	public static final String PROTOCOL_STATE_INVALID = "0";// 失效
	public static final String PROTOCOL_STATE_EFFECTIVE = "1";// 生效
	public static final String PROTOCOL_STATE_FROZEN = "2";// 冻结

	/** 协议纸质编号生成 */
	public static final String BUSSNO_TYPE_PROTOCOL_CODE_JGDT = "PROTOCOL_CODE_JGDT";// 仓储监管协议纸质编号【现货动态】
	public static final String BUSSNO_TYPE_PROTOCOL_CODE_JGJT = "PROTOCOL_CODE_JGJT";// 仓储监管协议纸质编号【现货静态】
	public static final String BUSSNO_TYPE_PROTOCOL_CODE_JGFBC = "PROTOCOL_CODE_JGFBC";// 仓储监管协议纸质编号【非标仓单】
	public static final String BUSSNO_TYPE_PROTOCOL_CODE_JGXPHH = "PROTOCOL_CODE_JGXPHH";// 仓储监管协议纸质编号【先票后货】
	public static final String BUSSNO_TYPE_THREE_PROTOCOL_NO = "THREE_PROTOCOL_NO";// 担保提货协议纸质编号
	public static final String BUSSNO_TYPE_PROTOCOL_CODE_XP = "PROTOCOL_CODE_XP";// 先票后货协议纸质编号
	public static final String BUSSNO_TYPE_PROTOCOL_CODE_DDRZ = "20";// 订单融资协议协议纸质编号
	public static final String BUSSNO_TYPE_BILLS_POOL_NO = "23"; // 票据池编号
	public static final String BUSSNO_TYPE_FACTCREDITCONTRACT_NO = "32";// 信保保理合同纸质编号
	public static final String BUSSNO_TYPE_FACTLEASECONTRACT_NO = "26";// 租赁保理
	public static final String BUSSNO_TYPE_FACTDOUBLECONTRACT_NO = "27";// 双保理合同纸质编号
	public static final String BUSSNO_TYPE_YS_GNBL_CONT_NO = "GNBL_CONT_NO";// 国内保理合同纸质编号
	public static final String BUSSNO_TYPE_YS_FXBL_CONT_NO = "FXBL_CONT_NO";// 反向保理合同号
	public static final String BUSSNO_TYPE_YS_YSZY_CONT_NO = "YSZY_CONT_NO";// 应收账款质押合同号
	public static final String BUSSNO_TYPE_ZY_CONT_NO = "ZY_CONT_NO";// 质押合同号ZY+8位为序列
	public static final String BUSSNO_TYPE_YS_GNBLC_CONT_NO = "GNBLC_CONT_NO";// 国内保理池合同纸质编号
	public static final String BUSSNO_TYPE_YS_YSZYC_CONT_NO = "YSZYC_CONT_NO";// 应收账款质押池合同号
	public static final String BUSSNO_TYPE_YS_CKTSC_CONT_NO = "CKTSC_CONT_NO";// 出口退税池合同号
	public static final String BUSSNO_TYPE_YS_GJBL_CONT_NO = "41";// 国际保理业务合同号
	public static final String MORTGAGE_NO = "MORTGAGE_NO";// 押品编号
	public static final String CZRK_APP_NO = "CZRK_APP_NO";// 出质入库申请编号
	public static final String HHZZ_APP_NO = "HHZZ_APP_NO";// 回款专户转账
	/** -编号生成code **/
	public static final String BUSSNO_TYPE_INDIRECT_CREDIT_NO = "INDIRECT_CREDIT_NO"; // 间接额度编号
	public static final String BUSSNO_TYPE_CREDIT_TYPE_NO = "CREDIT_TYPE_NO"; // 额度种类编号
	public static final String BUSSNO_TYPE_CREDIT_LIMIT_BUYER_NO = "CREDIT_LIMIT_BUYER_NO"; // 买方信用限额编号
																							// MSED+YYMMDD+五位序号
	/** 业务申请编号生成即appno begin **/
	public static final String BUSSNO_TYPE_SKQR_T_APP_NO = "SKQR_T_APP_NO"; // 担保提货收款确认SKQRT+YYMMDD+五位序号
	public static final String BUSSNO_TYPE_CETK_T_APP_NO = "CETK_T_APP_NO"; // 担保提货差额退款CETKT+YYMMDD+五位序号
	public static final String BUSSNO_TYPE_THSQ_T_APP_NO = "THSQ_T_APP_NO"; // 担保提货提货申请THSQT+YYMMDD+五位序号
	public static final String BUSSNO_TYPE_YSFZR_T_APP_NO = "YSFZR_T_APP_NO"; // 应收账款反转让YSFZR+YYYYMMDD+七位序号
	public static final String BUSSNO_TYPE_FHDZ_T_APP_NO = "FHDZ_T_APP_NO"; // 担保提货发货对账FHDZ+YYYYMMDD+七位序号
	public static final String BUSSNO_TYPE_YSCS_T_APP_NO = "YSCS_T_APP_NO"; // 应收账款催收YSCST+YYMMDD+五位序号
	public static final String BUSSNO_TYPE_YSCS_F_APP_NO = "YSCS_F_APP_NO"; // 应收账款池催收YSCSF+YYMMDD+五位序号
	public static final String BUSSNO_TYPE_YSRC_T_APP_NO = "YSRC_T_APP_NO"; // 应收账款入池YSRC+YYYYMMDD+七位序号
	public static final String BUSSNO_TYPE_YSCC_T_APP_NO = "YSCC_T_APP_NO"; // 应收账款出池YSCC+YYYYMMDD+七位序号
	public static final String BUSSNO_TYPE_YSHX_T_APP_NO = "YSHX_T_APP_NO"; // 应收账款核销YSHX+YYYYMMDD+七位序号
	public static final String BUSSNO_TYPE_YSJZ_T_APP_NO = "YSJZ_T_APP_NO"; // 应收账款减值YSJZ+YYYYMMDD+七位序号
	/** 预付类-先票/款后货 **/
	public static final String BUSSNO_TYPE_SKQR_F_APP_NO = "SKQR_F_APP_NO"; // 先票/款后货
																			// 收款确认SKQRF+YYMMDD+五位序号
	public static final String BUSSNO_TYPE_DZGL_F_APP_NO = "DZGL_F_APP_NO"; // 先票/款后货对账管理DZGL+YYYYMMDD+七位序号

	public static final String BUSSNO_TYPE_CZRK_F_APP_NO = "CZRK_F_APP_NO";// 先票/款后货-出质入库申请编号CZRKF+YYMMDD+五位序号

	public static final String BUSSNO_TYPE_THSQ_F_APP_NO = "THSQ_F_APP_NO";// 先票/款后货-提货申请申请编号THSQF+YYMMDD+五位序号

	public static final String BUSSNO_TYPE_CETK_F_APP_NO = "CETK_F_APP_NO"; // 先票/款后货差额退款CETKF+YYMMDD+五位序号

	/** 业务申请编号生成即appno end **/
	/** 通知书编号生成begin **/
	public static final String BUSSNO_TYPE_YSZR_T_NOTICE_NO = "YSZR_T_NOTICE_NO"; // 应收账款融资减值（折让）通知书编号TZ+17+六位序号
	public static final String BUSSNO_TYPE_YFFU_T_NOTICE_NO = "YFFU_T_NOTICE_NO"; // 预付类发货通知书编号TZ122+六位序号
	public static final String BUSSNO_TYPE_DJBC_T_NOTICE_NO = "DJBC_T_NOTICE_NO"; // 跌价补偿通知书编号TZ23+六位序号
	public static final String BUSSNO_TYPE_SKQR_T_NOTICE_NO = "SKQR_T_NOTICE_NO"; // 担保提货流贷收款确认通知书编号TZ+75+六位序号
	public static final String BUSSNO_TYPE_SKQR_T2_NOTICE_NO = "SKQR_T2_NOTICE_NO"; // 担保提货银承收款确认通知书编号TZ+78+六位序号
	public static final String BUSSNO_TYPE_FKQR_T_NOTICE_NO = "XHDY_L_NOTCIE_NO"; // 现货抵押放款确认通知书编号TZ+71+六位序号
	public static final String BUSSNO_TYPE_CETK_T_NOTICE_NO = "CETK_T_NOTICE_NO"; // 担保提货差额退款通知书编号TZ+71+六位序号
	public static final String BUSSNO_TYPE_THSQ_T_NOTICE_NO = "THSQ_T_NOTICE_NO"; // 担保提货提货申请通知书编号TZ+62+六位序号
	public static final String BUSSNO_TYPE_FHDZ_T_NOTICE_NO = "FHDZ_T_NOTICE_NO"; // 担保提货发货对账通知书编号TZ+40+六位序号
	/** 预付类-先票/款后货 **/
	public static final String BUSSNO_TYPE_SKQR_F_NOTICE_NO = "SKQR_F_NOTICE_NO"; // 先票/款后货流贷收款确认通知书编号TZ+77+六位序号
	public static final String BUSSNO_TYPE_SKQR_F2_NOTICE_NO = "SKQR_F2_NOTICE_NO"; // 先票/款后货银承收款确认通知书编号TZ+79+六位序号

	public static final String BUSSNO_TYPE_THSQ_F_NOTICE_NO = "THSQ_F_NOTICE_NO"; // 先票/款后货提货申请通知书编号TZ+70+六位序号

	public static final String BUSSNO_TYPE_CETK_F_NOTICE_NO = "CETK_F_NOTICE_NO"; // 先票/款后货退款通知书编号TZ+85+六位序号
	/** 预付类-先票/款后货 end **/
	public static final String BUSSNO_TYPE_YSZKC_T_NOTICE_NO = "YSZKC_T_NOTICE_NO"; // 应收账款池提示付款通知书编号TZ+117+六位序号
	
	public static final String BUSSNO_TYPE_YSZKC_C_NOTICE_NO = "YSZKC_C_NOTICE_NO"; // 应收账款池催收通知书编号TZ+110+六位序号
	
	public static final String BUSSNO_TYPE_YSZK_T_NOTICE_NO = "YSZK_T_NOTICE_NO"; // 应收账款提示付款通知书编号TZ+116+六位序号
	
	public static final String BUSSNO_TYPE_YSZK_C_NOTICE_NO = "YSZK_C_NOTICE_NO"; // 应收账款催收通知书编号TZ+33+六位序号
	
	public static final String BUSSNO_TYPE_YSHX_T_NOTICE_NO = "YSHX_T_NOTICE_NO"; // 应收账款池
																					// 核销通知书编号TZ+25+六位序号

	public static final String BUSSNO_TYPE_0_NOTICE_NO = "NOTICE_TYPE_0"; // 押品价格确定调整通知书TZ+0+六位序号

	public static final String BUSSNO_TYPE_1_NOTICE_NO = "NOTICE_TYPE_1"; // 押品监管下限通知书TZ+1+年月日+六位序号

	public static final String BUSSNO_TYPE_2_NOTICE_NO = "NOTICE_TYPE_2"; // 押品变更及回执通知书TZ+2+年月日+六位序号

	public static final String BUSSNO_TYPE_81_NOTICE_NO = "NOTICE_TYPE_81"; // 四方保兑仓出质通知书（线下）TZ+81+六位序号

	public static final String BUSSNO_TYPE_90_NOTICE_NO = "NOTICE_TYPE_90"; // 动产出质入库通知书TZ+90+年月日+六位序号

	public static final String BUSSNO_TYPE_DZGL_F_NOTICE_NO = "DZGL_F_NOTICE_NO"; // 先票/款后货对账管理发货对账通知书编号TZ+99+六位序号

	public static final String BUSSNO_TYPE_PLSY_NOTICE_NO = "PLSY_T_TYPE_22"; // 现货静态质押提货通知书TZ+2+年月日+六位序号
	
	public static final String BUSSNO_TYPE_111_NOTICE_NO = "NOTICE_TYPE_111"; // 国内双保理催收通知书TZ+111+年月日+六位序号
	
	public static final String BUSSNO_TYPE_112_NOTICE_NO = "NOTICE_TYPE_112"; // 信保保理催收通知书TZ+112+年月日+六位序号
	
	public static final String BUSSNO_TYPE_113_NOTICE_NO = "NOTICE_TYPE_113"; // 租赁保理催收通知书TZ+113+年月日+六位序号
	
	public static final String BUSSNO_TYPE_115_NOTICE_NO = "NOTICE_TYPE_115"; // 应收账款质押 催收通知书TZ+115+年月日+六位序号
	/**
	 * 盯市编号
	 */
	public static final String BUSSNO_TYPE_DSBH_NO = "DSBH_PRODUCT_ID"; // 盯市编号

	public static final String BUSSNO_TYPE_FBCD_ZY_NOTICE_NO = "FBCD_ZY_NOTICE_NO"; // 非标仓单质押通知书编号TZ+128+年月日+6位序号

	public static final String BUSSNO_TYPE_FBCD_JY_NOTICE_NO = "FBCD_JY_NOTICE_NO"; // 普通仓单解押通知书编号TZ+127+年月日+6位序号

	/** 通知书编号生成end **/

	/** B_CNT_MPROT_PART_INFO[多方协议参与者信息表] ROLE[参与者角色] */
	public static final String PROTOCOL_PART_ROLE_BANK = "01";// 银行
	public static final String PROTOCOL_PART_ROLE_MONI = "02";// 监管公司
	public static final String PROTOCOL_PART_ROLE_CREDIT = "03";// 授信客户/经销商
	public static final String PROTOCOL_PART_ROLE_CORE = "04";// 核心企业
	public static final String PROTOCOL_PART_ROLE_BACKCORE = "05";// 回购厂商/承担方

	/** B_CNT_MPROT_PART_INFO[多方协议参与者信息表] moniProtocolType[监管协议类型] */
	public static final String MONI_PROTOCOL_TYPE_CUST = "01";// 存货质押协议三方协议
	public static final String MONI_PROTOCOL_TYPE_STAND = "02";// 标准仓单协议
	public static final String MONI_PROTOCOL_TYPE_NORMAL = "03";// 非标准仓单协议
	public static final String MONI_PROTOCOL_TYPE_DEAL = "04";// 四方保兑仓监管协议
	public static final String MONI_PROTOCOL_TYPE_CAR = "05";// 汽车货押监管协议
	public static final String MONI_PROTOCOL_TYPE_CARFINANCE = "06";// 汽车金融监管协议
	/**
	 * 缓存常量
	 */
	public static final String SCF_CACHE_PUT_KEY_SCFGLOBALINFO = "scfGlobalInfo";// 全局信息缓存ID

	/** 客户查询类型 */
	public static final String CUST_QUERY_TYPE_BY_MANAGER = "01";// 按客户经理
	public static final String CUST_QUERY_TYPE_BY_MAA = "02";// 按客户经理+协管客户经理
	public static final String CUST_QUERY_TYPE_BY_BCTL = "03";// 按机构
	public static final String CUST_QUERY_TYPE_BY_NONE = "04";// 模拟角色登陆不控制客户可见性

	/** 常用角色ID */
	public static final String ROLE_ID_SYS = "7"; // 系统管理岗
	public static final String ROLE_ID_PRICE_MANAGE = "8"; // 价格管理岗
	public static final String ROLE_ID_MORT_PATROL = "9"; // 巡库岗
	public static final String ROLE_ID_MANAGER = "10001"; // 客户经理岗
	public static final String ROLE_ID_HEADBR_OPERATOR = "10018"; // 总行贸易融资事业部经办岗
	public static final String ROLE_ID_HEADBR_MANAGER = "10019"; // 总行贸易融资事业部经理岗
	public static final String ROLE_ID_HEADBR_CHARGE = "10021"; // 总行贸易融资事业部负责人岗
	public static final String ROLE_ID_PLEDGE_AUDIT = "10023"; // 出质入库审核岗
	public static final String ROLE_ID_MORT_REDEEM = "10025"; // 到货赎货岗
	public static final String ROLE_ID_DEBT_MANAGE = "10026"; // 应收账款管理岗
	public static final String ROLE_ID_CREDIT_MANAGE = "10028"; // 间接额度管理岗
	public static final String ROLE_ID_LOAN_AUDIT = "10029"; // 放款审核岗
	public static final String ROLE_ID_DEBT_TRANSFER = "10030"; // 应收账款转让岗
	public static final String ROLE_ID_CUST_MANAGE = "10031"; // 客户信息管理岗
	public static final String ROLE_ID_LOAN_MANAGE = "10032"; // 贷后管理岗
	public static final String ROLE_ID_MORT_ENTRY = "10034"; // 押品录入岗
	public static final String ROLE_ID_MORT_CHECK = "10035"; // 核库岗
	public static final String ROLE_ID_CBUS_MANAGE = "10036"; // 贸融业务管理岗

	/***数据字典 dictCode常量**/
	public static final String  DICT_CODE_CREDITLEVEL ="creditLevel";
	public static final String  DICT_CODE_NTETYPE ="nteType";  //通知书类型
	
	/**
	 * 监管协议状态
	 */
	public static final String STATE_INVALID = "0"; // 无效
	public static final String STATE_VALID = "1"; // 有效
	public static final String STATE_FREEZE = "2"; // 冻结
	/**
	 * 协议更新状态
	 */
	public static final String UPDATESTATE_VALID = "1";// 协议更新状态

	/**
	 * 融资方式：池模式/总对总;单笔模式/一一对应
	 */
	public static final String ARRIVED_MANAGE_MODE_POOL = "01";// 池模式
	public static final String ARRIVED_MANAGE_MODE_SINGLE = "02";// 单笔模式

	/**
	 * 出账方式 放款申请
	 */
	public static final String LOAN_WAY_WORKING_CAPITAL = "01";// 流贷
	public static final String LOAN_WAY_BANK_ACCEPTENCE = "02";// 银承

	public static final String APPLI_STATUS_DTL_CCMS_AGREE = "012";// 信贷放款通过

	/** 供应链产品大类 **/
	public static final String PRODUCT_TYPE_MORT = "1000"; // 现货类
	public static final String PRODUCT_TYPE_PREP = "2000"; // 预付类
	public static final String PRODUCT_TYPE_ACCR = "3000"; // 应收类
	public static final String PRODUCT_TYPE_CAR = "4000"; // 汽车金融类
	public static final String PRODUCT_TYPE_CHATTLE = "1000"; // 现货质押
	public static final String PRODUCT_TYPE_BILL = "1200"; // 仓单质押
	public static final String PRODUCT_TYPE_CAR_PLEDGE = "1300"; // 汽车货押
	public static final String PRODUCT_TYPE_CAR_FIRST_PAY = "1400"; // 汽车金融
	public static final String PRODUCT_TYPE_WAREHOUSE = "2100"; // 保兑仓
	public static final String PRODUCT_TYPE_INDUSTRY_FINANCING = "2200"; // 行业金融
	public static final String PRODUCT_TYPE_LETTER_CREDIT = "2300"; // 国内信用证
	public static final String PRODUCT_TYPE_ORDERBILLS = "2400"; // 订单融资
	public static final String PRODUCT_TYPE_FUTURE_MORT_RIGHT_ISSUE = "2500"; // 未来货权质押开证
	public static final String PRODUCT_TYPE_IMPORT_PLEDGE_CREDIT = "2600"; // 进口代收项下货权质押授信
	public static final String PRODUCT_TYPE_FACT = "3100"; // 应收账款
	public static final String PRODUCT_TYPE_BILL_POOL = "3200";// 票据池
	public static final String PRODUCT_TYPE_BUSI_TICKET_DISCOUNT = "3300";// 商票贴现
	public static final String PRODUCT_TYPE_BUSI_TICKET_PLEDEG = "3400";// 商票质押

	/** 供应链产品小类 **/
	public static final String PRODUCT_TYPE_SMALL_WH = "1210010";// 担保提货
	public static final String PRODUCT_TYPE_XPHH = "1210020";// 先票/款后货
	public static final String PRODUCT_TYPE_PLSY = "1220010"; // 现货静态质押
	public static final String PRODUCT_TYPE_PLDY = "1220020"; // 现货动态质押
	public static final String PRODUCT_TYPE_CAR_PL = "1220030"; // 汽车质押
	public static final String PRODUCT_TYPE_GNFAC = "1230010"; // 国内保理
	public static final String PRODUCT_TYPE_GNFXBL = "1230020"; // 反向保理
	public static final String PRODUCT_TYPE_YSZKZY = "1230030"; // 应收账款质押
	public static final String PRODUCT_TYPE_DEBT_POOL = "1230040"; // 国内保理池
	public static final String PRODUCT_TYPE_YSZKZY_POOL = "1230050"; // 应收账款质押
	public static final String PRODUCT_TYPE_CKTS_POOL = "1230060"; // 出口退税池
	public static final String PRODUCT_TYPE_DDRZ = "1210030"; // 订单融资

	/** 标志 */
	public static final String FLAG_ON = "1"; // 是
	public static final String FLAG_OFF = "0"; // 否

	/** 业务申请基础信息表-申请业务-BUSINESSNO_TYPE[业务编号类型] **/
	public static final String BUSINESSNO_TYPE_CONTNO = "01"; // 申请事项的合同编号(主合同号)
	public static final String BUSINESSNO_TYPE_SLAVECONTNO = "02"; // 出质入库申请，换货申请的合同编号（从合同号），仓单质押申请的合同编号（从合同号）
	public static final String BUSINESSNO_TYPE_PROTOCOLNO = "03";// 申请事项的协议编号
	public static final String BUSINESSNO_TYPE_CUSTCD = "04";// 申请事项的客户号，以客户为维度发起的业务，如额度相关业务

	/** 业务申请基础信息表-申请状态(APPLI_STATUS) **/
	public static final String APPLI_STATUS_UNSUBMIT = "00"; // 未提交（默认）
	public static final String APPLI_STATUS_SUBMITUNAPPROVE = "01"; // 已提交(未审批)
	public static final String APPLI_STATUS_APPROVED = "02"; // 已通过(审批通过)
	public static final String APPLI_STATUS_REFUSED = "03"; // 已拒绝(审批不通过)
	public static final String APPLI_STATUS_GOBACK = "04"; // 已退回(审批被退回)
	public static final String APPLI_STATUS_CANCEL = "07"; // 流程被撤销

	/** 业务申请基础信息表-申请状态明细(APPLI_STATUS_DTL) **/
	public static final String APPLI_STATUS_DTL_WAIT_SCF_WRITING = "010";// 供应链补录

	/**
	 * TBL_MORTGAGE_STOR_DELI_INFO[业务流水信息表] 出入库业务类型 STOR_DELI_BIZ_TYPE[出入库业务类型]
	 */
	public static final String STOR_DELI_BIZ_TYPE_STOCK = "01"; // 岀质入库
	public static final String STOR_DELI_BIZ_TYPE_DELIVERY = "02"; // 提货
	public static final String STOR_DELI_BIZ_TYPE_EXCHANGE = "03"; // 换货
	public static final String STOR_DELI_BIZ_TYPE_ADD_STOCK = "04"; // 追加出质
	public static final String STOR_DELI_BIZ_TYPE_ADJUST_PRICE = "05"; // 调价
	public static final String STOR_DELI_BIZ_TYPE_STAND_RECEIPT = "06";// 标准仓单解押
	public static final String STOR_DELI_BIZ_TYPE_NORMAL_RECEIPT = "07";// 普通仓单解押
	public static final String STOR_DELI_BIZ_TYPE_STAND_EXCHANGE = "08"; // 标准仓单置换
	public static final String STOR_DELI_BIZ_TYPE_NORMAL_EXCHANGE = "09"; // 普通仓单置换
	public static final String STOR_DELI_BIZ_TYPE_NORMAL_ADD = "17"; // 普通仓单追加
	public static final String STOR_DELI_BIZ_TYPE_NORMAL_PLEDGE = "10";// 普通仓单质押
	public static final String STOR_DELI_BIZ_TYPE_STAND_PLEDGE = "11";// 标准仓单质押
	public static final String STOR_DELI_BIZ_TYPE_CORRECT = "12";// 冲正
	public static final String STOR_DELI_BIZ_TYPE_CHECK = "13";// 非标准仓单核库
	public static final String STOR_DELI_BIZ_TYPE_CHANGE = "14";// 四方保兑仓单笔调价
	public static final String STOR_DELI_BIZ_TYPE_PLEDGE = "15";// 四方保兑仓出质入库
	public static final String STOR_DELI_BIZ_TYPE_IMPORT = "16"; // 库存清单导入押品出入库信息
	public static final String BUSSNO_TYPE_GOODS = "36"; // 货物清单编号
	public static final String BUSSNO_TYPE_DELIVEY_GOODS_NO = "37"; // 发货通知编号
	/**
	 * TBL_MORTGAGE_STOR_DELI_INFO[业务流水信息表] 出入库业务类型 STOR_DELI_BIZ_TYPE[出入库业务类型]
	 * end
	 **/

	/**
	 * TBL_MORTGAGE_STOR_DELI_INFO[业务流水信息表] STOR_OR_DELI[出库/入库] 出库/入库/核价/换货 类型
	 * start
	 **/
	public static final String STOR_OR_DELI_IN = "01"; // 入库
	public static final String STOR_OR_DELI_OUT = "02"; // 出库
	public static final String STOR_OR_DELI_CHECK = "03"; // 核价 调价
	public static final String STOR_OR_DELI_EXP = "04"; // 换货/置换
	public static final String STOR_OR_DELI_IMPORT = "05"; // 库存清单导入押品出入库信息
	public static final String STOR_OR_DELI_ADD = "06"; // 追加押品

	/**
	 * TBL_MORTGAGE_STOR_DELI_INFO[业务流水信息表] STOR_OR_DELI[出库/入库] 出库/入库/核价/换货 类型
	 * end
	 **/

	/**
	 * 票据业务标识
	 */
	public static final String BILLS_BUSI_FLAG_PROMISSORY = "1"; // 承兑

	/** 借据基本信息表-LNCI_STATUS[借据状态] **/
	public static final String LNCI_STATUS_NORMAL = "0";// 正常
	public static final String LNCI_STATUS_OVERDUE = "1";// 逾期
	public static final String LNCI_STATUS_IDLE = "2";// 呆滞
	public static final String LNCI_STATUS_BAD = "3";// 呆账

	// 借据记录状态
	public static final String LNCI_STATE_NEW = "2";// 2-新建
	public static final String LNCI_STATE_DEL = "1";// 1-删除
	public static final String LNCI_STATE_0 = "0";// 0-正常

	/** 质押物级别 **/
	public static final String MORT_LEVEL_FIRST = "1";// 一级质押物
	public static final String MORT_LEVEL_SECOND = "2";// 二级质押物
	public static final String MORT_LEVEL_THIRD = "3";// 三级质押物

	// 加锁状态
	public static final String LOCKED = "1"; // 锁定
	public static final String UNLOCKED = "0"; // 未锁定

	/** 借据确认状态 1：已收到；0：未收到 */
	public static final String LNCI_CONFIRM_RECEIVED = "1";
	public static final String LNCI_CONFIRM_NOTRECEIVED = "0";

	/** 借据类型 */
	public static final String ACCOUNT_WAY_LOAN = "01";// 贷款
	public static final String ACCOUNT_WAY_BILL = "02";// 银承汇票
	public static final String ACCOUNT_WAY_ELEC_BILL = "03";// 银承电票

	/*** 借据收款状态 1：已收；0：未收 */
	public static final String LNCI_CONFIRM_STATUS_POSITIVE = "1";// 已收款确认
	public static final String LNCI_CONFIRM_STATUS_PASSIVE = "0"; // 未收款确认

	/** 业务申请渠道标识 **/
	public static final String CHANNEL_FLAG_SCF = "1";// 供应链
	public static final String CHANNEL_FLAG_EBANK = "2";// 企业网银
	public static final String CHANNEL_FLAG_CCMS = "3";// 信贷系统
	public static final String CHANNEL_FLAG_IFSP = "4";// 互联网金融服务平台

	/** 额度类型 **/
	public static final String CREDIT_CLASS_DIRECT = "1";// 1-直接授信额度
	public static final String CREDIT_CLASS_THIRD = "2";// 2-第三方授信额度
	public static final String CREDIT_CLASS_INDIRECT = "3";// 3-间接额度
	public static final String CREDIT_CLASS_LIMIT_BUYER = "4";// 4-买方信用限额
	/** [额度节点类型] 1-根节点（1级） 2-子节点（2级） 3-子子节点（3级） **/
	public static final String CREDIT_NODE_TYPE_ROOT = "1";
	public static final String CREDIT_NODE_TYPE_LEAF = "2";
	public static final String CREDIT_NODE_TYPE_SUB_LEAF = "3";
	/** 额度状态 **/
	public static final String CREDIT_STATUS_NORMAL = "1";
	public static final String CREDIT_STATUS_TERMINATE = "2";
	public static final String CREDIT_STATUS_UNSUBMIT = "3";

	/** 信贷合同是否循环使用 **/
	public static final String CONT_CREDIT_CYCLE = "1";// 1-循环
	public static final String CONT_CREDIT_NOCYCLE = "2";// 2-非循环

	/**
	 * 追加保证金操作类型
	 */
	public static final String BAIL_ADD_OP_TYPE_CHATTLE_DELIVERY = "01";// 动产提货
	public static final String BAIL_ADD_OP_TYPE_ASSURE_DELIVERY = "02";// 担保提货提货
	public static final String BAIL_ADD_OP_TYPE_BILLFIRST_DELIVERY = "03";// 先票后货提货
	public static final String BAIL_ADD_OP_TYPE_MONILINE_ADJUST = "04";// 监管下限调整
	public static final String BAIL_ADD_OP_TYPE_CARMORT_DELIVERY = "05";// 汽车货押提货
	public static final String BAIL_ADD_OP_TYPE_CARMORT_REPLACE = "06";// 汽车货押换货
	public static final String BAIL_ADD_OP_TYPE_BILLNORMAL_DELIVERY = "07";// 非标仓单提货

	/** 保理业务类别标识 **/
	public static final String T_FINANCING_TYPE_INVOICE = "1";// 应收账款融资
	public static final String T_FINANCING_TYPE_POOL = "2";// 应收账款池融资
	public static final String T_FINANCING_TYPE_CREDIT = "4";// 信保保理
	public static final String T_FINANCING_TYPE_DOUBLE = "3";// 行内双保理
	public static final String T_FINANCING_TYPE_LEASE = "5";// 租赁保理
	public static final String T_FINANCING_TYPE_EF = "10";// 出口保理
	public static final String T_FINANCING_TYPE_IF = "11";// 进口保理

	// 00：生效(录入)；01：预占用；02：占用；；03：恢复（释放）；04：冻结；05:解冻；06：变更；07：终止;08-预占用恢复（释放）;09-直接占用
	public static final String CREDIT_TRADE_TYPE_INPUT = "00";// 生效(录入)
	public static final String CREDIT_TRADE_TYPE_PRE_OCCUPY = "01";// 预占用
	public static final String CREDIT_TRADE_TYPE_OCCUPY = "02";// 占用（预占用转占用）
	public static final String CREDIT_TRADE_TYPE_RELEASE = "03";// 占用恢复（释放）
	public static final String CREDIT_TRADE_TYPE_FREEZE = "04";// 冻结
	public static final String CREDIT_TRADE_TYPE_UNFREEZE = "05";// 解冻
	public static final String CREDIT_TRADE_TYPE_CHANGE = "06";// 变更
	public static final String CREDIT_TRADE_TYPE_END = "07";// 终止
	public static final String CREDIT_TRADE_TYPE_PRE_RELEASE = "08";// 预占用恢复（释放）
	public static final String CREDIT_TRADE_TYPE_DIRECT_OCCUPY = "09";// 直接占用

	// [额度业务关联类型]
	public static final String CREDIT_RELA_TYPE_CONT = "1";// 合同
	public static final String CREDIT_RELA_TYPE_LNCI = "2";// 借据
	public static final String CREDIT_RELA_TYPE_CUST = "3";// 客户

	// [额度操作类型定义]
	public static final String CREDIT_OPR_TYPE_OCCUPY = "1";// 占用
	public static final String CREDIT_OPR_TYPE_RELEASE = "2";// 占用恢复（释放）
	public static final String CREDIT_OPR_TYPE_FREEZE = "3";// 冻结
	// 产品额度操作方式
	public static final String CREDIT_OPR_MODE_SELLER_AND_BUYER = "01";

	/** 保理业务类型 与 DATA_DIC 相对应 **/
	public static final String FACT_TYPE_INLAND = "1"; // 国内保理
	public static final String FACT_TYPE_REVERSE = "2"; // 反向保理
	// public static final String FACT_TYPE_INTL = "2"; // 国际保理
	public static final String FACT_TYPE_DOUBLE_FACT = "3"; // 行内双保理
	public static final String FACT_TYPE_CREDIT_FACT = "4"; // 信保保理
	public static final String FACT_TYPE_LEASE_FACT = "5"; // 租赁保理
	public static final String FACT_TYPE_DEBT_PLEDGE = "6"; // 应收账款质押
	public static final String FACT_TYPE_DEBT_POOL_PLEDGE = "7"; // 应收账款质押池融资
	public static final String FACT_TYPE_DEBT_POOL = "8"; // 保理池融资
	public static final String FACT_TYPE_EXPORT_POOL_PLEDGE = "9"; // 出口退税池质押融资
	public static final String FACT_TYPE_EF = "10"; // 出口保理
	public static final String FACT_TYPE_IF = "11"; // 进口保理

	/** 收费类型 **/
	public static final String CHARGE_TYPE_ONLINE = "1";// 系统收取
	public static final String CHARGE_TYPE_OFFLINE = "2";// 线下收取
	/*** 发票状态 */
	public static final String BILLS_STATUS_NEW = "00"; // 新建
	public static final String BILLS_STATUS_RECORDED = "01"; // 已录入未转让
	public static final String BILLS_STATUS_PURCHASED = "02"; // 已转让/出质
	public static final String BILLS_STATUS_PAYOFF = "03";// 已核销
	public static final String BILLS_STATUS_LOANED = "04";// 已融资

	// 间接额度类型 有、无 【来自信贷接口】
	public static final String HAS_INDIRECT_CREDIT_TRUE = "1";// 有
	public static final String HAS_INDIRECT_CREDIT_FALSE = "0";// 无
	// 监管模式 1-动态
	public static final String MONI_MODEL_DYNAMIC = "1";
	// 监管模式 2-静态
	public static final String MONI_MODEL_STATIC = "2";

	/** 货物类型 **/
	// 货物类型 0-新入库
	public static final String MORTGAGE_TYPE_IN = "0";
	// 货物类型 1-解除抵押，出库
	public static final String MORTGAGE_TYPE_OUT = "1";
	// 货物类型 2-在押货物（押品变更后的货物信息）
	public static final String MORTGAGE_TYPE_UNDER = "2";

	/** 押品变更的类型 **/
	// 押品变更的类型 00-增加押品
	public static final String MORTGAGE_CHANGE_TYPE_ADD = "00";
	// 押品变更的类型 01-解除抵/质押
	public static final String MORTGAGE_CHANGE_TYPE_RELESE = "01";
	// 押品变更的类型 02-押品置换
	public static final String MORTGAGE_CHANGE_TYPE_EXCHANGE = "02";
	// 押品变更的类型 03-调价
	public static final String MORTGAGE_CHANGE_TYPE_ASJUST = "03";

	/**
	 * 查询方法返回类型
	 */
	public static final String RETURN_FLAG_CNAME = "CNAME";// 客户名称
	public static final String RETURN_FLAG_CUSTCD = "CUSTCD";// 客户号

	/**
	 * 保证金初始化类型：初始、追加
	 */
	public static final String INIT_TYPE_INIT = "01";// 初始
	public static final String INIT_TYPE_ADD = "02";// 追加
	public static final String INIT_TYPE_MAX = "03";// 最高额保证金
	/**
	 * 押品申请表TBL_APPLI_MORTGAGE_BASE_INFO【STATUS】字段
	 */
	public static final String APPLI_MORT_STATUS_VALID = "01"; // 有效
	public static final String APPLI_MORT_STATUS_INVALID = "02"; // 无效
	public static final String APPLI_MORT_STATUS_APPROVE = "99"; // 批量调价审批中
	public static final String APPLI_MORT_STATUS_APPROVED = "98"; // 批量调价审批通过
	public static final String APPLI_MORT_STATUS_DONE = "97"; // 批量调价单步调价完成
	/**
	 * 保证金等价物类型 01,存单;02,银票;03,保证金;
	 */
	public static final String BAIL_TYPE_DEPOSIT = "01";// 存单
	public static final String BAIL_TYPE_BILL = "02";// 银票
	public static final String BAIL_TYPE_NORMAL = "03";// 保证金
	// public static final String BAIL_TYPE_MAX = "04";//最高额保证金

	/** 保证金及现金等价物确认状态 01：已确认 02：未确认 */
	public static final String CONFIRM_STATUS_CONFIRMED = "01";// 已确认
	public static final String CONFIRM_STATUS_NOCONFIRM = "02";// 未确认
	public static final String CONFIRM_STATUS_RELEASED = "03";// 已解押
	public static final String CONFIRM_STATUS_RELEASEING = "04";// 解押中
	public static final String CONFIRM_STATUS_SETTLED = "05";// 已结清

	/** 对账方式 */
	public static final String CHECK_STOCK_WAY_CUST = "01";// 银行发起对账
	public static final String CHECK_STOCK_WAY_CONT = "02";// 监管公司发起对账
	public static final String CHECK_STOCK_WAY_SLAVE = "03";// 按担保合同
	public static final String CHECK_STOCK_WAY_WARE = "04";// 按仓库
	public static final String CHECK_STOCK_WAY_UPCUST = "05";// 上游客户/卖方发起

	/** 对账状态 */
	public static final String CHECK_STOCK_STATUS_CHECKING = "01";// 正在对账
	public static final String CHECK_STOCK_STATUS_FINISHED = "02";// 对账完成

	/**
	 * 巡库/盘库/对账明细表类型 01-对账
	 */
	public static final String CHK_STOCK_DTL_TYPE_CHECK = "01";
	/**
	 * 巡库/盘库/对账明细表类型 02-盘库
	 */
	public static final String CHK_STOCK_DTL_TYPE_COUNT = "02";
	/**
	 * 巡库/盘库/对账明细表类型 03-首次盘库
	 */
	public static final String CHK_STOCK_DTL_TYPE_FIRST_COUNT = "03";
	/**
	 * 巡库/盘库/对账明细表类型 04-巡库
	 */
	public static final String CHK_STOCK_DTL_TYPE_INSPECT = "04";

	// 押品对应方式 1,一一对应;2,总量对应
	public static final String MORTGAGE_MANAGE_MODE_ONETOONE = "1";
	public static final String MORTGAGE_MANAGE_MODE_ALLTOALL = "2";

	/** --- 首笔保证金可全额提货(后期一比一提货) --- */
	public static final String TRI_DELIVERY_RULE_ALL = "1";
	/** --- 首笔保证金不提货(后期按比例提货) --- */
	public static final String TRI_DELIVERY_RULE_NONE = "2";
	/** --- 首笔保证金全额最后提货(前期一比一提货) --- */
	public static final String TRI_DELIVERY_RULE_LAST = "3";

	// 存货库存状态
	public static final String STOCK_STATUS_NORMAL = "01"; // 正常
	public static final String STOCK_STATUS_INVALID = "02"; // 无效

	/**
	 * 有效标志/状态
	 */
	public static final String FLAG_INVALID = "0"; // 无效
	public static final String FLAG_VALID = "1"; // 有效

	// 押品级别
	public static final String MORTGAGE_LEVEL_ONE = "1";// 押品一级
	public static final String MORTGAGE_LEVEL_TWO = "2";// 押品二级

	/*************************
	 * 序号表(SEQCTL)中编号VALUE_NO与VALUE_INDEX begin
	 ************************/

	public static final int VALUE_NO_NOTICE_NUM = 14; // 通知书编号
	public static final int VALUE_NO_MORTGAGE_NO = 15; // 押品编号
	public static final int VALUE_NO_CUST_CD = 17; // 客户号编号
	public static final int VALUE_NO_INTERFACE_LOGNO = 22; // 网关流水编号
	public static final int VALUE_NO_BILL_NO = 25; // 仓单编号
	public static final int VALUE_NO_SEQ_TBL_ID = 35; // 数据库表主键序列
	public static final int VALUE_NO_BUSSNO = 40; // 业务编号
	public static final int VALUE_NO_ROLE_FUNC_REL = 115; // 角色权限
	public static final int VALUE_NO_TLR_ROLE_REL = 116; // 角色
	public static final int VALUE_NO_SEQ_CHNL_ID = 120; // 接口流水号

	public static final String VALUE_INDEX_NOTICE_NUM = "NOTICENUM"; // 通知书编号
	public static final String VALUE_INDEX_MORTGAGE_NO = "MORTGAGENO"; // 押品编号
	public static final String VALUE_INDEX_CUST_CD = "CUSTCD"; // 客户编号
	public static final String VALUE_INDEX_INTERFACE_LOGNO = "INTERFACELOGNO"; // 网关流水编号
	public static final String VALUE_INDEX_BILL_NO = "BILLNO"; // 仓单编号
	public static final String VALUE_INDEX_ROLE_ID = "ROLEID"; // 角色主键
	public static final String VALUE_INDEX_DATADICID = "DATADICID"; // 数据字典表主键
	public static final String VALUE_INDEX_PRODUCT_ID = "PRODUCT_ID"; // 产品ID
	public static final String VALUE_INDEX_APPLIBASEINFO_ID = "APPLIBASEINFO_ID"; // 业务申请基表主键
	public static final String VALUE_INDEX_GRADEELEMENTDATADIC_ID = "GRADEDATADIC_ID"; // 评分模型数据字典主键
	public static final String VALUE_INDEX_GRADEELEMENTLIST_ID = "GRADELIST_ID"; // 评分模型数据字典主键
	public static final String VALUE_INDEX_GRADEMODELRESULT_ID = "GRADERESULT_ID"; // 评分结果表主键
	public static final String VALUE_INDEX_GRADEMODELRESULTDTL_ID = "GRADERESULTDTL_ID"; // 评分结果明细表主键
	public static final String VALUE_INDEX_GRADEMODELSUBDATAELEMENT_ID = "GRADESUBDATAE_ID"; // 评分子数据元素主键
	public static final String VALUE_INDEX_CONTBASEINFO_ID = "CONTBASEINFO_ID"; // 保理合同表主键
	public static final String VALUE_INDEX_MORTGAGECLASS_ID = "MORTCLASS_ID"; // 押品类型表主键
	public static final String VALUE_INDEX_MUTIPROTBASEINFO_ID = "MUTIPROTBASE_ID"; // 多方协议表主键(弃用)
	public static final String VALUE_INDEX_WAREHOUSEINFO_ID = "WAREHOUSE_ID"; // 仓库信息表主键
	public static final String VALUE_INDEX_WORKFLOWAPPINFO_ID = "WFAPP_ID"; // 数据字典主键ID，value_index，此表继承hibernatedao，没办法使用seq值
	public static final String VALUE_INDEX_CSBIZLOG_ID = "CSBIZLOG_ID"; // TblCsBizLog主键
	public static final String VALUE_INDEX_BILL_ID = "BILL_ID"; // 票据申请表BILL_ID
	public static final String VALUE_INDEX_DEBTAPPNO_ID = "DEBTAPPNO_ID";// 数据字典主键ID，value_index
	public static final String VALUE_INDEX_APPLIMORTNO_ID = "APPLIMORTNO_ID"; // 押品申请表的押品编号
	public static final String VALUE_INDEX_INSURANCE_ID = "INSURANCE_ID"; // 保险信息表ID
	public static final String VALUE_INDEX_THIRDCREDITDETAIL_ID = "THIRDCREDITDETAIL_ID"; // 额度流水表主键
	public static final String VALUE_INDEX_BUSINESSCHECK_ID = "BUSINESSCHECK_ID"; // 业务检查表主键
	public static final String VALUE_INDEX_CREDIT_NO = "CREDIT_NO"; // 额度信息表主键(弃用)
	public static final String VALUE_INDEX_CUSTACCOUNT_ID = "CUSTACCOUNT_ID"; // TBL_APPLI_CUST_ACCOUNT_INFO
	public static final String VALUE_INDEX_ROLE_FUNC_REL = "ROLE_FUNC_REL_ID"; // 角色权限
	public static final String VALUE_INDEX_TLR_ROLE_REL = "TLR_ROLE_REL"; // 角色
	public static final String VALUE_INDEX_BUSSNO_CUST = "CUST"; // 客户编号
	public static final String VALUE_INDEX_BUSSNO_PROTOCOL = "PROTOCOL"; // 协议编号
	public static final String VALUE_INDEX_BUSSNO_CONTRACT = "CONTRACT"; // 合同编号
	public static final String VALUE_INDEX_BUSSNO_SLAVE_CONT = "SLAVE_CONT"; // 质押合同编号
	public static final String VALUE_INDEX_BUSSNO_GAGE = "GAGE"; // 押品编号
	public static final String VALUE_INDEX_BUSSNO_NOTICE = "NOTICE"; // 通知书编号
	public static final String VALUE_INDEX_BUSSNO_LNCI = "LNCI"; // 借据编号
	public static final String VALUE_INDEX_BILLNO = "BILLNO"; // 票据编号
	public static final String VALUE_INDEX_SIMU_NO = "SIMU_NO"; // 模拟器通用编号
	public static final String VALUE_INDEX_TRADE_CONT_ID = "TRADE_CONT_ID"; // 国内信用证贸易合同主键
	public static final String VALUE_INDEX_LCNO_ID = "LCNO_ID"; // 国内信用证合同主
	public static final String VALUE_INDEX_LCBILLS_ID = "LCBILLS_ID"; // 国内信用证来单编号
	// 6位序列号
	public static final String VALUE_INDEX_APP_NO = "INDEX_APP_NO"; // 业务申请编号

	public static final String VALUE_INDEX_INSPECT_REPORT_NO = "INSPECT_REPORT_NO"; // 巡库编号
	public static final String VALUE_INDEX_CHECK_REPORT_NO = "CHECK_REPORT_NO"; // 核库编号
	public static final String VALUE_INDEX_BATCHNO = "BATCHNO"; // 票据批次号
	public static final String VALUE_INDEX_PROTOCOL_CODE_JG_NO = "CODE_JG_NO"; // 仓储监管协议纸质编号【现货动态】
	public static final String VALUE_INDEX_PROTOCOL_CODE_JGJT_NO = "CODE_JGJT_NO"; // 仓储监管协议纸质编号【现货静态】
	public static final String VALUE_INDEX_PROTOCOL_CODE_JGQC_NO = "CODE_JGQC_NO"; // 仓储监管协议纸质编号【汽车货押】
	public static final String VALUE_INDEX_PROTOCOL_CODE_JGXP_NO = "CODE_JGXP_NO"; // 仓储监管协议纸质编号【先票后货】
	public static final String VALUE_INDEX_PROTOCOL_CODE_JGBZ_NO = "CODE_JGBZ_NO"; // 仓储监管协议纸质编号【标准仓单】
	public static final String VALUE_INDEX_PROTOCOL_CODE_JGPT_NO = "CODE_JGPT_NO"; // 仓储监管协议纸质编号【普通仓单】
	public static final String VALUE_INDEX_PROTOCOL_CODE_JGQJ_NO = "CODE_JGQJ_NO"; // 仓储监管协议纸质编号【汽车金融】
	public static final String VALUE_INDEX_PROTOCOL_CODE_DB_NO = "CODE_DB_NO"; // 担保提货协议纸质编号
	public static final String VALUE_INDEX_PROTOCOL_CODE_XP_NO = "CODE_XP_NO"; // 先票后货协议纸质编号
	public static final String VALUE_INDEX_PROTOCOL_CODE_DDRZ_NO = "CODE_DDRZ_NO"; // 订单融资协议协议纸质编号
	public static final String VALUE_INDEX_FACTCONTRACT_CODE_BL_NO = "FACT_CONTRACT"; // 应收账款合同纸质编号
	public static final String VALUE_INDEX_FACTPOOLCONTRACT_CODE_BL_NO = "POOL_CONTRACT"; // 应收账款池合同纸质编号
	public static final String VALUE_INDEX_FACTCREDITCONTRACT_CODE_BL_NO = "CREDITCONTRACT"; // 信保保理合同纸质编号
	public static final String VALUE_INDEX_FACTLEASECONTRACT_CODE_BL_NO = "LEASECONTRACT"; // 租赁保理合同纸质编号
	public static final String VALUE_INDEX_FACTDOUBLECONTRACT_CODE_BL_NO = "DOUBLECONTRACT"; // 双保理合同纸质编号
	public static final String VALUE_INDEX_INDIRECT_CREDIT_NO = "INDIRECT_CREDIT_NO"; // 间接额度编号
	public static final String VALUE_INDEX_CREDIT_TYPE = "CREDIT_TYPE"; // 额度种类编号
	public static final String VALUE_INDEX_BUYER_CREDIT_LIMIT_NO = "BUYER_CREDIT_NO"; // 买方信用限额编号
	public static final String VALUE_INDEX_INTERFACE_CHNL_NO = "INTERFACE_CHNL_NO"; // 接口渠道流水号
	public static final String VALUE_INDEX_FACTINTERNALCONTRACT_CODE_BL_NO = "INTERNALCONTRACT";// 国际保理合同纸质编号
	/*************************
	 * 序号表(SEQCTL)中编号VALUE_NO与VALUE_INDEX end
	 ************************/
	/** 额度阶段 begin **/
	// [额度阶段] 现金等价物
	public static final String CREDIT_PHASE_CASH_QYL = "01";// 现金等价物新增
	// [额度阶段] 四方保兑仓-先票款后货
	public static final String CREDIT_PHASE_FOUR_WAREHOUSE_ACCOUNT = "02";// 先票款后货融资
	public static final String CREDIT_PHASE_FOUR_WAREHOUSE_DELIVERYAPPLI = "03";// 先票款后货提货
	// [额度阶段] 担保提货
	public static final String CREDIT_PHASE_THREE_FINANCING = "04";// 担保融资融资
	public static final String CREDIT_PHASE_THREE_FINANCING_DELIVERY = "05";// 担保提货提货
	// [额度阶段] 订单融资
	public static final String CREDIT_PHASE_ORDER_FINANCING = "06";// 订单阶段融资
	public static final String CREDIT_PHASE_ORDER_FIRSTGOODS_FINANCING = "07";// 交货后阶段融资
	public static final String CREDIT_PHASE_ORDER_FIRSTGOODS_PAYMENT = "08";// 交货后阶段回款
	// [额度阶段] 应收账款
	public static final String CREDIT_PHASE_DEBT_FINANCING = "09";// 应收账款融资
	public static final String CREDIT_PHASE_DEBT_PAYMENT = "10";// 应收账款回款
	// [额度阶段] 国内双保理
	public static final String CREDIT_PHASE_FACTORING_FINANCING = "11";// 保理融资出账
	public static final String CREDIT_PHASE_FACTORING_PAYMENT = "12";// 保理应收账款回款
	public static final String CREDIT_PHASE_FACTORING_MANA_INSURANCE_PAYMENT = "13";// 保理商赔款
	public static final String CREDIT_PHASE_FACTORING_PURCHASE = "14";// 保理应收账款转让
	public static final String CREDIT_PHASE_FACTORING_ALLOWANCE = "15";// 保理应收账款减值
	public static final String CREDIT_PHASE_FACTORING_BACK_PURCHASE = "16";// 保理应收账款反转让
	public static final String CREDIT_PHASE_FACTORING_CHARGEOFF = "17";// 保理应收账款核销
	// [额度阶段] 信保保理
	public static final String CREDIT_PHASE_FACTORING_INSURANCE_FINANCING = "18";// 信保融资出账
	public static final String CREDIT_PHASE_FACTORING_INSURANCE_PAYMENT = "19";// 信保应收账款回款
	public static final String CREDIT_PHASE_FACTORING_COMPANY_INSURANCE_PAYMENT = "20";// 信保保险公司赔款
	public static final String CREDIT_PHASE_FACTORING_INSURANCE_PURCHASE = "21";// 信保应收账款转让
	public static final String CREDIT_PHASE_FACTORING_INSURANCE_ALLOWANCE = "22";// 信保应收账款减值
	public static final String CREDIT_PHASE_FACTORING_INSURANCE_BACK_PURCHASE = "23";// 信保应收账款反转让
	public static final String CREDIT_PHASE_FACTORING_INSURANCE_CHARGEOFF = "24";// 信保应收账款核销
	// [额度阶段] 租赁保理
	public static final String CREDIT_PHASE_LEASE_FACTORING_FINANCING = "25";// 租赁保理融资出账
	public static final String CREDIT_PHASEE_LEASE_FACTORING_INSURANCE_PAYMENT = "26";// 租赁保理应收账款回款
	// [额度阶段] 商票质押
	public static final String CREDIT_PHASE_TICKET_PLEDEG_OCCUPY = "27";// 商票质押放款
	public static final String CREDIT_PHASE_TICKET_PLEDEG_RELEASE = "28";// 商票质押还款
	// [额度阶段] 商票贴现
	public static final String CREDIT_PHASE_TICKET_DISCOUNT_OCCUPY = "29";// 商票贴现放款
	public static final String CREDIT_PHASE_TICKET_DISCOUNT_RELEASE = "30";// 商票贴现还款

	// [额度阶段] 现货动态抵/质押
	public static final String CREDIT_PHASE_CASH_PLEDGE_DYNSTATE_FINANCING = "31";// 现货动态抵/质押出账

	// [额度阶段] 现货静态抵/质押
	public static final String CREDIT_PHASE_CASH_PLEDGE_STATICSTATE_FINANCING = "32";// 现货静态抵/质押出账
	public static final String CREDIT_PHASE_CASH_PLEDGE_STATICSTATE_DELIVERY = "33";// 现货静态抵/质押提货

	// [额度阶段] 标准仓单
	public static final String CREDIT_PHASE_STANDARD_WAREHOUSE_RECEIPT_FINANCING = "34";// 标准仓单出账

	// [额度阶段] 汽车货押
	public static final String CREDIT_PHASE_CAR_PLEDGE_FINANCING = "35";// 汽车货押出账
	public static final String CREDIT_PHASE_CAR_PLEDGE_DELIVERY = "36";// 汽车货押提货

	// [额度阶段] 非标准仓单
	public static final String CREDIT_PHASE_BILLNORMAL_DELIVERY = "37";// 非标仓单提货

	// [额度阶段] 现金等价物
	public static final String CREDIT_PHASE_MARGIN = "38";// 保证金追加冻结

	// [额度阶段] 汽车金融
	// public static final String CREDIT_PHASE_AUTO_ORDER_APPLY = "18";//
	// 保兑仓订单融资申请
	// public static final String CREDIT_PHASE_AUTO_BACKLOAN = "19";// 汽车金融经销商还款
	// public static final String CREDIT_PHASE_AUTO_ORDER_BUYBACKAPPLI = "20";//
	// 汽车金融订单融资申请
	// [额度阶段] 动产
	// public static final String CREDIT_PHASE_CHATTEL_QUALITY = "00";// 动产出质
	// public static final String CREDIT_PHASE_CHATTEL_LOAN = "21";// 动产放款
	/** 额度阶段 end **/
	/**
	 * 客户关联关系额度类型
	 */
	/** 状态--有追索 */
	public static final String CREDIT_TYPE_WITH_RECOURSE = "1";// 有追索
	/** 状态--无追索 */
	public static final String CREDIT_TYPE_WITHOUT_RECOURSE = "2";// 无追索

	/**
	 * 业务编号类型
	 */
	public static final String BUSSNO_TYPE_CUST = "01"; // 客户编号
	public static final String BUSSNO_TYPE_PROTOCOL = "02"; // 协议编号
	public static final String BUSSNO_TYPE_CONTRACT = "03"; // 主合同编号
	public static final String BUSSNO_TYPE_SLAVE_CONT = "04"; // 质押合同编号
	public static final String BUSSNO_TYPE_GAGE = "05"; // 押品编号
	public static final String BUSSNO_TYPE_NOTICE = "06"; // 通知书编号
	public static final String BUSSNO_TYPE_LNCI = "07"; // 借据编号
	public static final String BUSSNO_TYPE_ORDER = "08"; // 订单编号
	public static final String BUSSNO_TYPE_LETTERCREDIT = "09"; // 信用证编号
	public static final String BUSSNO_TYPE_CONT_TRADE = "10"; // 信用证贸易合同编号
	public static final String BUSSNO_TYPE_LC_BILLSNO = "11"; // 信用证贸易合同编号
	public static final String BUSSNO_TYPE_MARKETNO = "12";// 盯市编号
	public static final String BUSSNO_TYPE_INSPECT_REPORT_NO = "13";// 巡库编号
	public static final String BUSSNO_TYPE_CHECK_REPORT_NO = "14";// 核库编号
	public static final String BUSSNO_TYPE_BILL_NO = "15";// 票据NO
	public static final String BUSSNO_TYPE_SIMU_NO = "16"; // 模拟器通用编号

	// [额控制度类型] 0：非循环；1：循环
	public static final String CREDIT_CLASS_NOCYCLE = "0";// 0-非循环
	public static final String CREDIT_CLASS_CYCLE = "1";// 1-循环

	/**
	 * 机构从属关系类型
	 */
	public static final String BCTL_AFFILIATION_DIRECT = "0";// 直属机构(即直接下级，包含自身)
	public static final String BCTL_AFFILIATION_BELONG = "1";// 隶属机构(包含自身)

	// 渠道代码
	public static final String CHNL_NO_CCMS = "13";// 13-信贷系统
	public static final String CHNL_NO_TEL = "15";// 15-电话银行
	public static final String CHNL_NO_EBANK = "17";// 17-网上银行
	public static final String CHNL_NO_FRONT = "23";// 23-大前置
	public static final String CHNL_NO_BILL = "28";// 28-电子商票
	public static final String CHNL_NO_SCF = "52";// 52-供应链

	// 返回码
	public static final String RSP_NO_SUCCESS = "SUCCESS";// SUCCESS-成功
	public static final String RSP_NO_FAIL = "FAIL";// FAIL-失败

	// 首笔保证金提货模式
	public static final String FIRST_BAIL_TYPE_ONE = "1"; // 首笔保证金可全额提货：本次可提货金额
															// = 初始保证金及等价物金额 +
															// 追加保证金及等价物金额 –
															// 已累计提货金额
	public static final String FIRST_BAIL_TYPE_TWO = "2"; // 首笔保证金在后期按比例提货:本次可提货金额
															// =
															// 追加保证金及等价物金额/(1-初始自有资金比例)
															// – 已累计提货金额
	public static final String FIRST_BAIL_TYPE_THREE = "3"; // //首笔保证金全额最后提货:

	/**
	 * 供应链产品ID或操作模式 01,动产动态;02,差额回购
	 */
	public static final String SUPPLYCHAINPDID_01 = "01";// 现货动态
	public static final String SUPPLYCHAINPDID_02 = "02";// 差额回购

	/** CUST_TYPE[客户类型] **/
	public static final String CUST_TYPE_CORP = "1";// 法人
	public static final String CUST_TYPE_NATU = "2";// 自然人
	public static final String CUST_TYPE_SAME = "3";// 同业客户

	/**
	 * 业务查询机构控制类型
	 */
	public static final String QUERY_TYPE_ALL_SUB = "1";// 取得所有下属支行列表
	public static final String QUERY_TYPE_ALL = "2";// 得到所有下属机构列表(包含自己)

	/** 客户状态 **/
	public static final String CUST_STATUS_INVALID = "00"; // 无效
	public static final String CUST_STATUS_VALID = "01"; // 有效

	/*** 账号类型 */
	public static final String ACCOUNT_TYPE_BALANCE = "1";// 结算账户
	public static final String ACCOUNT_TYPE_FACTORING = "2";// 保理专户
	public static final String ACCOUNT_TYPE_BAIL = "3";// 保证金账户
	public static final String ACCOUNT_TYPE_ACCEPTOR = "4";// 承兑人账户
	public static final String ACCOUNT_TYPE_LOAN = "5";// 贷款账号

	/** 主合同基础信息表 MAST_CONT_STATUS【主合同状态】 **/
	public static final String MAST_CONT_STATUS_NORMAL = "01"; // 正常
	public static final String MAST_CONT_STATUS_FILING = "02"; // 归档
	public static final String MAST_CONT_STATUS_STOP = "03"; // 终止
	public static final String MAST_CONT_STATUS_DISCARD = "04"; // 废弃

	/** 保证金及现金等价物确认状态 01：已确认 02：未确认 */
	public static final String LOANBAIL_CONFIRM_STATUS_SUBMIT = "01";// 已确认
	public static final String LOANBAIL_CONFIRM_STATUS_UNSUBMIT = "02";// 未确认
	public static final String LOANBAIL_CONFIRM_STATUS_DIS = "03";// 已解押
	public static final String LOANBAIL_CONFIRM_STATUS_DISING = "04";// 解押中
	public static final String LOANBAIL_CONFIRM_STATUS_APPLY = "05";// 申请中
	public static final String LOANBAIL_CONFIRM_STATUS_APPROVE = "06";// 已审批
	// public static final String LOANBAIL_CONFIRM_STATUS_05 = "05";//已结清
	// 核心接口 流贷还款【SF0106】 【s061 贷款还款】操作标志
	public static final String CORE_OPR_FLAG_ENTRY = "1";// 录入
	public static final String CORE_OPR_FLAG_CHECK = "2";// 复核
	public static final String CORE_OPR_FLAG_DIRECTPASS = "3";// 直通

	// 核心接口 流贷还款【SF0106】 【s061 贷款还款】还款种类
	public static final String CORE_REPAY_TYPE_ALL = "1";// 全部归还
	public static final String CORE_REPAY_TYPE_ARREARAGE = "2";// 归还欠款
	public static final String CORE_REPAY_TYPE_INADVANCE = "3";// 提前还款

	// 核心接口 流贷还款【SF0106】 【s061 贷款还款】 提前还款种类
	public static final String CORE_INADANCEREPAY_TYPE_PRINCIPLE = "1";// 指定本金
	public static final String CORE_INADANCEREPAY_TYPE_SUM = "2";// 指定总额
	public static final String CORE_INADANCEREPAY_TYPE_ALL = "3";// 全部结清

	// 网银接口，应收账款查询，阶段状态 phase

	public static final String ASSIGNMENT = "01"; // 转让

	public static final String FINANCE = "02";// 融资

	public static final String COLLECTION = "03";// 催收

	public static final String ANTI_ASSIGNMENT = "04"; // 反转让

	// 网银接口 ，多个字段，已竖线分开

	public static final String VERTICAL = "|";

	// 网银接口 融资模式 1-发票融资 2-池融资
	public static final String BILLS_FINANCE = "1";
	public static final String POOL_FINANCE = "2";

	// SCF发送信贷接口 放款 意见01- 同意02- 拒绝03- 退回
	public static final String VALUE_INDEX_WORKFLOWTASKINFO_ID = "WFTADKINFO_ID";// 数据字典主键ID，value_index

	public static final String SCF_LOAN_AGREE = "01"; // 同意

	public static final String SCF_LOAN_REFUSE = "02";// 拒绝

	public static final String SCF_LOAN_BACK = "03";// 退回

	// 买方信用限额额度流水查询交易类型
	public static final String TRANS_TYPE_ASSIGNMENT = "01";// 应收账款转让
	public static final String TRANS_TYPE_ANTI_ASSIGNMENT = "02";// 应收账款反转让
	public static final String TRANS_TYPE_ALLOWANCE = "03";// 应收账款减值
	public static final String TRANS_TYPE_CHARGE_OFF = "04";// 应收账款核销
	public static final String TRANS_TYPE_PAYMENT = "05";//// 应收账款回款
	public static final String TRANS_TYPE_REPARATION = "06";//// 保理商赔款
	public static final String TRANS_TYPE_INSURANCE_PAYMENT = "07";// 保险公司赔款

	// 预警编号=产品小类+预警类型。预警类型如下：
	public static final String WARN_NO_TYPE_DPZD = "01"; // 跌破最低控货价值预警
	public static final String WARN_NO_TYPE_DPJJ = "02"; // 跌破警戒线预警
	public static final String WARN_NO_TYPE_JGDF = "03"; // 价格跌幅预警
	public static final String WARN_NO_TYPE_JGYC = "04"; // 价格异常预警
	public static final String WARN_NO_TYPE_DZBP = "05"; // 对账不平预警
	public static final String WARN_NO_TYPE_WXK = "06"; // 未巡库预警
	public static final String WARN_NO_TYPE_TPXE = "07"; // 突破监管限额预警

	/** 发货登记状态 **/
	public static final String SEND_MORTGAGE_STATUS_UNSUBMIT = "0";// 已录入未提交
	public static final String SEND_MORTGAGE_STATUS_SUBMIT = "1";// 已提交

	// 产品大类：1000-存货类、2000-预付类、3000-应收类、XXXX-公共类
	public static final String COMMON_CLASS = "XXXX";

	// 多方协议状态
	public static final String MUTI_PROT_STATE_VALID = "1"; // 有效
	public static final String MUTI_PORT_STATE_INVALID = "0"; // 无效

	// 订单融资还款方式
	public static final String BILL_FINANCING_RETURN_USAGE_BAIL = "01";// 入保证金
	public static final String BILL_FINANCING_RETURN_USAGE_RAYMENT = "02";// 还贷

	// 出质状态
	public static final String MORT_STATUS_ENTRY = "1";// 已录入未出质
	public static final String MORT_STATUS_PLEDGED = "0";// 已出质

	// 订单类型 1 订单 2虚拟
	public static final String ORDER_TYPE_ONE = "1";// 订单合同
	public static final String ORDER_TYPE_TWO = "2";// 虚拟订单
	public static final String ORDER_TYPE_THREE = "3";// 电子订单

	// 订单交货凭证类型
	public static final String BILLS_TYPE_ONE = "01";// 发票
	public static final String BILLS_TYPE_TWO = "02";// 收货证明
	public static final String BILLS_TYPE_THREE = "03";// 其它

	// 回款用途
	public static final String RETURN_USAGE_IN_BAILAMOUNT = "01";// 入保证金
	public static final String RETURN_USAGE_REPAY = "02";// 还贷
	public static final String RETURN_USAGE_BALANCE = "03";// 尾款

	/**
	 * 额度发生操作类型 *
	 */
	public static final String CREDIT_OPERATION_TYPE01 = "01";// 核心厂商/监管商额度维护
	public static final String CREDIT_OPERATION_TYPE02 = "02";// 分行事业部厂商/监管商额度申请
	public static final String CREDIT_OPERATION_TYPE03 = "03";// 分行事业部厂商/监管商额度调整
	public static final String CREDIT_OPERATION_TYPE04 = "04";// 厂商/监管商额度总行回收
	public static final String CREDIT_OPERATION_TYPE05 = "05";// 现货动态出帐
	public static final String CREDIT_OPERATION_TYPE06 = "06";// 差额回购出账
	public static final String CREDIT_OPERATION_TYPE07 = "07";// 保证金转入
	public static final String CREDIT_OPERATION_TYPE08 = "08";// 保证金转出
	public static final String CREDIT_OPERATION_TYPE09 = "09";// 现金等价物转入
	public static final String CREDIT_OPERATION_TYPE10 = "10";// 现金等价物转出
	public static final String CREDIT_OPERATION_TYPE11 = "11";// 放款撤销
	/**
	 * 保证金转出模式
	 */
	public static final String TRANSFER_OUT_MAX = "0";// 最高额保证金转出
	public static final String TRANSFER_OUT_NOMORL = "1";// 保证金转出

	// 是否参与跑批
	public static final String JOIN_BATCH_YES = "1";// 是
	public static final String JOIN_BATCH_NO = "2";// 否

	/**
	 * 法人客户类型
	 */
	public static final String CUST_CLASS_NORMAL = "1";// 一般客户
	public static final String CUST_CLASS_MONI = "2";// 监管公司
	public static final String CUST_CLASS_CORE = "3";// 核心厂商
	public static final String CUST_CLASS_FUTU = "4";// 期货经纪公司
	public static final String CUST_CLASS_FLC = "5";// 金融租赁公司
	public static final String CUST_CLASS_INSURE = "6";// 保险公司
	public static final String CUST_CLASS_FACTOR = "7";// 保理商

	/** 金融服务网络管理 **/

	public static final String VALUE_INDEX_APPLINETWORKBASEINFO_ID = "APPLINETWORKBASEINFO_ID";// TBL_APPLI_NETWORK_BASE_INFO_ID
	public static final String NETWORK_PROTOCOLTYPE = "01";// 协议类型
	public static final String NETWORK_SIGNIN_STATUS = "01";// 经销商入退网标志:01-入网
	public static final String NETWORK_SIGNOUT_STATUS = "02";// 经销商入退网标志:02-退网
	/**
	 * 规则工程ID
	 */
	public static final String RULE_PROJECT_ID = "Topscf";// 一般客户
	/**
	 * 规则集名称
	 */
	public static final String RULE_SET_NAME = "供应商入网规则";// 规则集名称

	/**
	 * 价格管理岗角色名称
	 */
	public static final String ROLE_NAME_PRICING = "价格管理岗";
	/**
	 * 物流监控岗角色名称
	 */
	public static final String ROLE_NAME_CHKSTOCK = "物流监控岗";
	/**
	 * 借据逾期标志
	 */
	public static final String LOAN_OVERDUE_FLAG_YES = "1";// 逾期
	public static final String LOAN_OVERDUE_FLAG_NO = "2";// 正常

	/**
	 * 价格调整发起模式
	 */
	public static final String PLEDGE_MODE_SINGLE = "1";// 单笔
	public static final String PLEDGE_MODE_MUTI = "2";// 批量

	/******************* 供应链产品 以后不再使用，需要删除 ******************************/
	public static final String PRODUCT_TYPE_CHATTEL_FINANCING = "1101"; // 动产融资
	public static final String PRODUCT_TYPE_BILL_STANDARD = "1201"; // 标准仓单
	public static final String PRODUCT_TYPE_BILL_NORMAL = "1202"; // 普通非标准仓单
	public static final String PRODUCT_TYPE_B2B = "1004"; // B2B融资
	public static final String PRODUCT_TYPE_FACTORING = "2001"; // 国内保理
	public static final String PRODUCT_TYPE_FRANCHISER = "2101"; // 四方保兑仓、厂商银
	public static final String PRODUCT_TYPE_TRIPARTITE = "2102"; // 三方保兑仓
	public static final String PRODUCT_TYPE_CAR_FINANCING = "2201"; // 汽车先票款/后货

	/*** 市价来源 */
	public static final String MARKETPRICESRC_HAND = "00";// 手工录入
	public static final String MARKETPRICESRC_IMPORT = "01";// excel导入

	/**
	 * 客户查询管护员控制类型
	 */
	public static final String QUERY_TYPE_MAG_ALL_AID = "1";// 查询所有协管客户
	public static final String QUERY_TYPE_MAG_ALL_MAS = "2";// 查询所有主管客户
	public static final String QUERY_TYPE_MAG_ALL = "3";// 查询所有管理客户

	/** 质押合同及监管协议产品标识 **/
	public static final String PRODUCT_TYPE_CHATTLE_DYNAMIC = "1";// 动产动态
	public static final String PRODUCT_TYPE_FOURWARE = "2";// 先票款后货
	public static final String PRODUCT_TYPE_CARPLEDGE = "3";// 汽车货押
	public static final String PRODUCT_TYPE_CHATTLE_STATIC = "4";// 动产静态
	public static final String PRODUCT_TYPE_STANDARD_BILL = "5"; // 标准仓单
	public static final String PRODUCT_TYPE_NORMAL_BILL = "6"; // 普通非标准仓单
	public static final String PRODUCT_TYPE_CAR_FIRST = "7"; // 汽车先票款后货

	// 仓单类型
	public static final String BILL_TYPE_STANDARD = "1";// 标准仓单
	public static final String BILL_TYPE_NORMAL = "2";// 非标准仓单

	/** 仓单业务管理的status状态的值 **/
	public static final String BILL_MANAGE_STATUS_INPUT = "0";// 仓单管理表字段（status）-
																// 录入
	public static final String BILL_MANAGE_STATUS_DELIVERY = "1";// 仓单管理表字段（status）-
																	// 解押
	public static final String BILL_MANAGE_STATUS_PLEDGE = "2";// 仓单管理表字段（status）-
																// 质押
	public static final String BILL_MANAGE_STATUS_ADJUST = "3";// 仓单管理表字段(status)-
																// 处置
	public static final String BILL_MANAGE_STATUS_LOAN = "4";// 仓单管理表字段(status)-
																// 融资
	public static final String BILL_MANAGE_STATUS_IN = "5";// 仓单管理表字段(status)-
															// 置换换入
	public static final String BILL_MANAGE_STATUS_OUT = "6";// 仓单管理表字段(status)-
															// 置换换出

	/** 巡库核库类型 **/
	public static final String OPER_TYPE_INSPECT = "0";// 巡库
	public static final String OPER_TYPE_CHECK = "1";// 核库

	/** 管理人员综合素质 **/
	public static final String MANAGER_QUALITY_HIGH = "01";// 高
	public static final String MANAGER_QUALITY_NORMAL = "02";// 一般
	public static final String MANAGER_QUALITY_LOW = "03";// 差

	/** 操作人员行业经验 **/
	public static final String TLR_EXPERIENCE_ABUNDENT = "01";// 高
	public static final String TLR_EXPERIENCE_NORMAL = "02";// 一般
	public static final String TLR_EXPERIENCE_WORSE = "03";// 差

	/** 监管公司对我行核库配合 **/
	public static final String MONI_COOPERATION_GOOD = "01";// 好
	public static final String MONI_COOPERATION_BAD = "02";// 差

	/*******
	 * 押品相关业务类型 jianfeng.huang 2013.5.15 出入库业务类型2位+入库01/出库02 start
	 **********/
	public static final String MORT_BIZ_TYPE_PLEDGE_IN = "0101"; // 出质入库
	public static final String MORT_BIZ_TYPE_REPLACE_IN = "0301"; // 换货入库
	public static final String MORT_BIZ_TYPE_APPEND_STOCK_IN = "0401"; // 追加出质入库
	public static final String MORT_BIZ_TYPE_STAND_EXCHANGE_IN = "0801"; // 标准仓单置换入库
	public static final String MORT_BIZ_TYPE_NORMAL_EXCHANGE_IN = "0901"; // 普通仓单置换入库
	public static final String MORT_BIZ_TYPE_NORMAL_PLEDGE_IN = "1001"; // 普通仓单质押入库
	public static final String MORT_BIZ_TYPE_STAND_PLEDGE_IN = "1101"; // 标准仓单质押入库
	public static final String MORT_BIZ_TYPE_CORRECT_IN = "1201"; // 冲正入库
	public static final String MORT_BIZ_TYPE_DELIVERY_OUT = "0202"; // 提货出库
	public static final String MORT_BIZ_TYPE_EXCHANGE_OUT = "0302"; // 换货出库
	public static final String MORT_BIZ_TYPE_STAND_RECEIPT_OUT = "0602"; // 标准仓单解押出库
	public static final String MORT_BIZ_TYPE_NORMAL_RECEIPT_OUT = "0702"; // 普通仓单解押出库
	public static final String MORT_BIZ_TYPE_STAND_EXCHANGE_OUT = "0802"; // 标准仓单置换出库
	public static final String MORT_BIZ_TYPE_NORMAL_EXCHANGE_OUT = "0902"; // 普通仓单置换出库
	public static final String MORT_BIZ_TYPE_CORRECT_OUT = "1202"; // 冲正出库
	public static final String MORT_BIZ_TYPE_ADJUST_OUT = "1602"; // 处置调剂出库
	public static final String MORT_BIZ_TYPE_BUYBACK_OUT = "1702"; // 处置回购出库
	public static final String MORT_BIZ_TYPE_ADJUST_PRICE = "0503"; // 调价
	public static final String MORT_BIZ_TYPE_FOUR_DELIVERY_RECORD_IN = "1500"; // 发货录入(四方专用)
	public static final String MORT_BIZ_TYPE_FOUR_STOCK_IN = "1501"; // 出质入库(四方专用)
	public static final String MORT_BIZ_TYPE_FOUR_CONFIRM_STOCK_IN = "1502"; // 回执确认入库(四方专用)
	public static final String MORT_BIZ_TYPE_IMPORT_IN = "1601"; // 库存清单导入押品入库
	public static final String MORT_BIZ_TYPE_IMPORT_OUT = "1602"; // 库存清单导入押品出库
	public static final String MORT_BIZ_TYPE_NORMAL_ADD = "1802"; // 普通仓单置换出库
	/*******
	 * 押品相关业务类型 jianfeng.huang 2013.5.15 出入库业务类型2位+入库01/出库02 end
	 **********/

	/** 供应链产品种类 **/
	public static final String PRODUCT_TYPE_BIGCLASS = "000";// 大类
	public static final String PRODUCT_TYPE_SUBCLASS = "001";// 中类
	public static final String PRODUCT_TYPE_LEAFCLASS = "002";// 小类

	/** TBL_MORTGAGE_STOCK_INFO STOCK_ADJUST_TYPE **/
	public static final String STOCK_ADJUST_TYPE_ADD = "0";// 新增
	public static final String STOCK_ADJUST_TYPE_ADJUST = "1";// 调整

	/**
	 * 汽车金融，销售/还款状态
	 */
	public static final String MORTGAGE_STATUS_UNSALE = "01"; // 未销售
	public static final String MORTGAGE_STATUS_SALED = "02"; // 已销售
	// 费用类型
	public static final String COST_TYPE = "1001";// 保理手续费

	// [业务进展状态]
	public static final String BUSINESS_STATUS_SUBMIT = "SUBMIT"; // 提交审批(包括提交申请和退回修改后重新提交申请)
	public static final String BUSINESS_STATUS_APPROVAL_REFUSED = "APPROVAL_REFUSED"; // 审批拒绝(包括审批拒绝和退回修改)
	public static final String BUSINESS_STATUS_APPROVAL_CONFIRM = "APPROVAL_CONFIRM"; // 审批确认(回执确认)
	public static final String BUSINESS_STATUS_WITHOUT_APPROVAL = "WITHOUT_APPROVAL"; // 无需审批(无审批流程)直接占用额度
	public static final String BUSINESS_CREDIT_CHECK = "CREDIT_CHECK"; // 额度校验

	/** 额度操作金额类型 **/
	public static final String CREDIT_TYPE_MONITOR = "18";// 监管额度
	public static final String CREDIT_TYPE_LOAN = "02";// 融资额度

	/** TBL_BILL_STAND_IN_OUT的status状态的值 **/
	public static final String IN_OUT_STATUS_DELIVERY = "0";// 解押
	public static final String IN_OUT_STATUS_PLEDGE = "1";// 质押
	public static final String IN_OUT_STATUS_EXCHANGE_DELIVERY = "2";// 置换解押
	public static final String IN_OUT_STATUS_EXCHANGE_PLEDGE = "3";// 置换质押

	/**
	 * 业务信息查询类型
	 */
	public static final String QUERY_TYPE_SELF = "1";// 当前用户查询
	public static final String QUERY_TYPE_OTHER = "2";// 其他用户查询

	/** B_PBC_MTG_PRICE_HIS[押品历史价格表]-PRICE_WAY[维护方式] **/
	public static final String MORTGAGE_PRICE_WAY_BYHAND = "01"; // 人工
	public static final String MORTGAGE_PRICE_WAY_SYNC = "02"; // 同步

	/**
	 * 核价动因
	 */
	public static final String PRICINGREASON_ACCOUNT_BEFORE = "01";// 出账前核价
	public static final String PRICINGREASON_NEW_WAREHOUSE = "02";// 新入库核价
	public static final String PRICINGREASON_ADVANCE_PAYMENT = "03";// 预付款融资核价
	public static final String PRICINGREASON_MARKET_PRICE = "04";// 市场价格发生变化
	public static final String PRICINGREASON_APPLI_CHANGE = "05";// 经办行申请价格调整
	public static final String PRICINGREASON_OTHER = "06";// 其他

	/** 操作员状态 **/
	public static final String TLR_STATUS_LOCK = "0"; // 锁定
	public static final String TLR_STATUS_VALID = "1"; // 正常
	public static final String TLR_STATUS_INVALID = "2"; // 停用

	/** STATUS状态 **/
	public static final String STATUS_INVALID = "00"; // 无效
	public static final String STATUS_VALID = "01"; // 有效
	
	/** 押品申请表TBL_APPLI_MORTGAGE_BASE_INFO 标志[FLAG] **/
	public static final String MORTGAGE_FLAG_NOT_USE = "00"; // 不可用
	public static final String MORTGAGE_FLAG_CAN_USE = "01"; // 可用
	
	/**授信额度参数**/
	public static final String ROOT = "0";
	public static final String BRANCH = "1";
	public static final String LEAF = "2";
	
	/**
	 * 财务报表科目编辑方式
	 */
	public static final String ED_TYP_1 = "1";//1-输入项
	public static final String ED_TYP_2 = "2";//2-计算项
	public static final String ED_TYP_3 = "3";//3-标题项
	//财务指标常量，如，模型的MDL_ID有变更，这里需要修改
	public static final String MDL_ID_CWZB = "CWZB";//CWZB-财务指标
	public static final String MDL_ID_XJLL = "XJLL";//XJLL-财务指标
	/**
	 * 报表周期
	 */
	public static final String RP_SOURCE_01 = "01";//01-月报
	public static final String RP_SOURCE_04 = "04";//04-年报
	public static final String RP_SOURCE_03 = "03";//03-半年报
	
	//财务指标与平均值比较
	public static final String FIN_ANALY_A_2 = "2";//高于
	public static final String FIN_ANALY_A_1 = "1";//近与
	public static final String FIN_ANALY_A_0 = "0";//低于
	
	//分析结果
	public static final String FIN_ANALY_R_5 = "5";// 优秀
	public static final String FIN_ANALY_R_4 = "4";//较好
	public static final String FIN_ANALY_R_3 = "3";//平均
	public static final String FIN_ANALY_R_2 = "2";//较差
	public static final String FIN_ANALY_R_1 = "1";//差
	
	
	/**
	 * 调用阶段
	 */
	public static final String INVOKE_PHASE_APPLY = "01";//业务申请阶段
	public static final String INVOKE_PHASE_CONT = "02";//合同签订阶段
	public static final String INVOKE_PHASE_DUEBILL_APP = "03";//放款申请阶段
	public static final String INVOKE_PHASE_DUEBILL_REGISTER = "04";//出账登记阶段
	public static final String INVOKE_PHASE_TRANSFER = "05";//转让出质阶段
	public static final String INVOKE_PHASE_REPAYMENT = "06";//现金回款阶段
	public static final String INVOKE_PHASE_PRESS = "07";//催收申请阶段
	public static final String INVOKE_PHASE_DISPUTE_REGISTER = "08";//商纠登记阶段
	public static final String INVOKE_PHASE_DISPUTE_REMOVE = "09";//商纠解除阶段
	public static final String INVOKE_PHASE_IMPAIRMENT = "10";//减值申请阶段
	public static final String INVOKE_PHASE_BACK_TRANSFER = "11";//反转让解押阶段
	public static final String INVOKE_PHASE_CHARGE_OFF = "12";//核销申请阶段
	public static final String INVOKE_PHASE_PROMTO_PAY = "13";//提示付款申请阶段
	public static final String INVOKE_PHASE_OUT_POOL = "14";//出池申请阶段
	public static final String INVOKE_PHASE_IN_POOL = "15";//入池申请阶段
	
	/**
	 * 出账状态
	 */
	public static final String DUE_REGISTERSTATE_0 = "0";//未出账
	public static final String DUE_REGISTERSTATE_1 = "1";//出账未确认
	public static final String DUE_REGISTERSTATE_2 = "2";//已出账
	
	/**
	 * 云标签
	 */
	public static final String CLOUD_TAG_INDUSTRY_TYPE = "000001"; // 所属行业
	public static final String CLOUD_TAG_CREDIT_LEVEL = "000002"; // 信用评级
	public static final String CLOUD_TAG_ENTERPRISE_SCOPE = "000004"; // 企业规模
	public static final String CLOUD_TAG_ENTERPRISE_TYPE = "000005"; // 企业类型
	public static final String CLOUD_TAG_CREDIT_SCR = "000006"; // 信用评分
	public static final String CLOUD_TAG_TURNOVER = "000009"; // 年营业额
	/**
	 * ireport报表数据源连接类型
	 */
	public static final String IRP_CONN_TYPE = "irpConnType"; //使用JNDI=0,JDBC=1
	public static final String IRP_CONN_TYPE_0 = "0"; //使用JNDI=0
	public static final String IRP_CONN_TYPE_1 = "1"; //使用JNDI=1
	public static final String DATA_SOURCE = "dataSource"; //数据源BEAN ID常量名称
	
	/**
	 * 信息状态 ：1,无效;0,有效
	 */
	public static final String INFO_STATE_VALID = "0"; // 有效
	public static final String INFO_STATE_INVALID = "1"; // 无效
	
	/**
	 * 上传文件分类 ：01-信息发布附件;02-系统文档;03-通知书模板文件
	 */
	public static final String FILE_CLASS_INFO = "01"; // 信息发布附件

	
	/**
	 * 排序方式
	 */
	public static final String ORACLE_ASC = "1";//正序排列
	public static final String ORACLE_DESC = "2";//倒序排列
}

/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2004-2005 Huateng Software System.  All rights
 * reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.batch.common;

/**
 * @author valley
 * @date 2004-11-16
 * @desc 系统常量定义
 */
public class SystemConstant {

	public static int ENTITY_DRAFT_NUMBER_LENGTH = 12;// 实物票据长度12位
	public static int ELC_DRAFT_NUMBER_LENGTH = 30;// 电子票据长度12位

	/*
	 * 系统类型1-银行 2-财务公司
	 */
	public static String SYSTEM_TYPE_BANK = "1";// 1银行
	public static String SYSTEM_TYPE_FINANCE_COMPANIES = "2";// 2-财务公司

	/**
	 * 默认收藏夹记录
	 */
	public static int DEFAULT_FAVORITE_FUNCID = 235;

	/**
	 * 默认导出列的个数
	 */
	public static int DEFAULT_EXPORT_LENGTH = 23;
	public static String DEFAULT_SUCCESS = "success";
	public static String DEFAULT_FAILURE = "failure";

	/**
	 * 查询查复来源
	 */
	public static String CHECK_FROM_REAL = "1";
	public static String CHECK_FROM_POOL = "2";

	/**
	 * 用途
	 */
	/** 代保管 */
	public static String POOL_WAY_DBG = "1";
	/** 票据池 */
	public static String POOL_WAY_CJC = "2";

	/**
	 * 费率计算方式
	 */
	/** 按张 */
	public static String POOL_RATE_TYPE_AZ = "1";
	/** 按金额乘费率 */
	public static String POOL_RATE_TYPE_AJE = "2";
	/** 混合 */
	public static String POOL_RATE_TYPE_ALL = "3";

	/**
	 * 方向
	 */
	/** 存入 */
	public static String POOL_CREDIT_IN = "1";
	/** 取出 */
	public static String POOL_CREDIT_OUT = "2";

	/**
	 * 取出方式
	 */
	/** 取出 */
	public static String POOL_OUT_WAY_OUT = "1";
	/** 转贴现 */
	public static String POOL_OUT_WAY_DISCOUNT = "2";

	/**
	 * 用途转换
	 */
	/** 代保管到票据池 */
	public static String POOL_CHG_USE_DBG2PJC = "1";
	/** 票据池到代保管 */
	public static String POOL_CHG_USE_PJC2DBG = "2";

	/**
	 * 业务类型
	 */
	/** 短贷 */
	public static String POOL_BUS_TYPE_DD = "1";
	/** 保函 */
	public static String POOL_BUS_TYPE_BH = "2";
	/** 信用证 */
	public static String POOL_BUS_TYPE_XYZ = "3";
	/** 商票贴现保证 */
	public static String POOL_BUS_TYPE_SPBT = "4";
	/** 其它业务 */
	public static String POOL_BUS_TYPE_OTHERS = "5";

	/**
	 * 额度占用类型
	 */
	/** 占用额度 */
	public static String POOL_CREDIT_OCCUPY_CREDIT = "1";
	/** 占用质押 */
	public static String POOL_CREDIT_OCCUPY_IMPAWN = "2";

	/**
	 * 还款方式
	 */
	/** 自由还款 */
	public static String POOL_RETURN_WAY_FREE = "1";
	/** 质押品还款 */
	public static String POOL_RETURN_WAY_IMPAWN = "2";

	/**
	 * 还款方式
	 */
	/** 正常 */
	public static String POOL_DRAFT_NORMAL = "00";
	/** 票据池 */
	public static String POOL_DRAFT_POOL = "10";
	/** 在线保管 */
	public static String POOL_DRAFT_ONLINE = "20";
	/** 取出转贴现 */
	public static String POOL_DRAFT_OUT_DISCOUNT = "30";
	/** 质押 */
	public static String POOL_DRAFT_IMPAWN = "40";
	/** 取出 */
	public static String POOL_DRAFT_OUT = "50";
	/** 贴现中 */
	public static String POOL_DRAFT_DISCOUNT = "60";
	/** 结清 */
	public static String POOL_DRAFT_CLEAR = "70";
	/** 转换中 */
	public static String POOL_DRAFT_CHG = "80";
	/** 质押处理中 */
	public static String POOL_DRAFT_IMPAWNING = "90";
	/** 托收处理中 */
	public static String POOL_DRAFT_SEND_COLLECTION = "91";
	/** 出库 */
	public static String POOL_DRAFT_STORE_OUT = "93";
	/** 托收在途中 */
	public static String POOL_DRAFT_SEND_ON_WAY = "92";

	/**
	 * 票据池流程
	 */
	/** 录入 */
	public static String POOL_STATUS_INPUT = "1";
	/** 提交 */
	public static String POOL_STATUS_SUBMIT = "2";
	/** 接收 */
	public static String POOL_STATUS_ACCEPT = "3";
	/** 待复核 */
	public static String POOL_STATUS_CHECK = "4";
	/** 复核通过 */
	public static String POOL_STATUS_PASS = "5";
	/** 记账 */
	public static String POOL_STATUS_ACCOUNT = "6";

	/**
	 * 保证类别
	 */
	/** 出票人保证 */
	/* add liyi BMS-1496 begin */
	public static String GUARANTEE_TYPE_REMITE = "01";
	/** 承兑人保证 */
	public static String GUARANTEE_TYPE_ACCEPT = "02";
	/** 背书保证 */
	public static String GUARANTEE_TYPE_ENDROSE = "03";
	/* add liyi BMS-1496 end */
	/**
	 * 电子票清算方式
	 */
	/** 线上清算 */
	public static String ELECTRIC_FINISH_TYPE_TOP = "SM00";
	/** 线下清算 */
	public static String ELECTRIC_FINISH_TYPE_BELOW = "SM01";

	/**
	 * 电子票提示付款方式
	 */
	/** 正常 */
	public static String ELECTRIC_PROMPT_PAY_TYPE_NORMAL = "0";
	/** 逾期 */
	public static String ELECTRIC_PROMPT_PAY_TYPE_OVERDUE = "1";

	/**
	 * 默认用户状态
	 */
	/** 正常 */
	public static String OPER_STATUS_NORMAL = "1";
	/** 锁定 */
	public static String OPER_STATUS_LOCK = "2";
	/** 废弃 */
	public static String OPER_STATUS_DISAFFRIM = "3";

	/** 授权记录表 (AUTHORIZATION_RECORD) 记录状态 */
	/** 未复核 */
	public static String AUTHORIZE_RECORD_NOT_CHECK = "1";
	/** 已提交 */
	public static String AUTHORIZE_RECORD_HAS_SUBMIT = "2";
	/** 已复核 */
	public static String AUTHORIZE_RECORD_HAS_PASS = "3";
	/** 复核未通过 */
	public static String AUTHORIZE_RECORD_NOT_PASS = "4";

	/**
	 * 业务种类
	 *
	 */
	/** 承兑业务 */
	public static String BUSINESS_TYPE_ACCEPTANCE = "1";
	/** 买入业务 */
	public static String BUSINESS_TYPE_BUYIN = "2";
	/** 卖出业务 */
	public static String BUSINESS_TYPE_SELLOUT = "3";
	/** 质押业务 */
	public static String BUSINESS_TYPE_SEQUCE = "4";
	/** 质押解除业务 */
	public static String BUSINESS_TYPE_SEQUCE_OUT = "5";
	/** 保证业务 */
	public static String BUSINESS_TYPE_GAUDE = "6";
	/** 提示付款申请 */
	public static String BUSINESS_TYPE_TO_PAY = "7";
	/** 追索通知 */
	public static String BUSINESS_TYPE_ZX_NOTE = "8";
	/** 追索同意清偿申请 */
	public static String BUSINESS_TYPE_AND_QC = "9";
	/** 撤票通知 */
	public static String BUSINESS_TYPE_ADV_REC = "Q";
	/** 背书 .*/
	public static String BUSINESS_TYPE_TRF = "I";


	/**
	 * 记账种类
	 *
	 */
	/** 承兑明细记账 */
	public static String ACC_ACCEPTANCE_DTL = "10";
	/** 承兑批次记账 */
	public static String ACC_ACCEPTANCE_CONCT = "11";
	/** 承兑到期记账 */
	public static String ACC_ACCEPTANCE_DUE_PAY = "12";
	/** 承兑解付记账 */
	public static String ACC_ACCEPTANCE_PAY = "13";
	/** 承兑逾期记账 */
	public static String ACC_ACCEPTANCE_EXPIRED = "14";
	/** 买入明细记账 */
	public static String ACC_BUYIN_DTL = "20";
	/** 买入批次记账 */
	public static String ACC_BUYIN_CONCT = "21";
	/** 买入到期记账 */
	public static String ACC_BUYIN_DUE = "22";
	/** 卖出明细记账 */
	public static String ACC_SELLOUT_DTL = "30";
	/** 卖出批次记账 */
	public static String ACC_SELLOUT_CONCT = "31";
	/** 质押业务 */
	public static String ACC_SEQUCE = "4";
	/** 质押解除业务 */
	public static String ACC_SEQUCE_OUT = "5";
	/** 保证业务 */
	public static String ACC_GAUDE = "6";
	/** 承兑保证业务 */
	public static String ACC_GAUDE_A = "6A";
	/** 出票保证业务 */
	public static String ACC_GAUDE_B = "6B";
	/** 背书保证业务 */
	public static String ACC_GAUDE_C = "6C";
	/** 提示付款申请 */
	public static String ACC_TO_PAY = "7";
	/** 追索通知 */
	public static String ACC_ZX_NOTE = "8";
	/** 追索同意清偿申请 */
	public static String ACC_AND_QC = "9";
	/** 撤票通知 */
	public static String ACC_ADV_REC = "Q";
	/** 背书 .*/
	public static String ACC_TRF = "I";
	/** 批次记账 */
	public static String ACC_CONCT = "CONCT";
	/** 明细记账 */
	public static String ACC_DTL = "DTL";

	public static String ACCTOUNT_TYPE_2 = "2";
	public static String ACCTOUNT_TYPE_1 = "1";

	/**
	 * 到期提醒 0001到期托收提醒 0002卖出回购到期提醒 0003买入返售到期 0004双向买断到期 0005承兑到期 0006续买断到期 0007双买断到期
	 */
	public static final String DUE_REMIND_PROMPT_PAY = "0001";
	public static final String DUE_REMIND_SELLBUY = "0002";
	public static final String DUE_REMIND_BUY_SELL = "0003";
	public static final String DUE_REMIND_TWO_WAY_BUY = "0004";
	public static final String DUE_REMIND_ACCEPT = "0005";
	public static final String DUE_REMIND_BUY_EXPIRE = "0006";
	public static final String DUE_REMIND_TWO_WAY_SELL = "0007";

	/**
	 * 业务种类
	 *
	 */
	/** 承兑业务 */
	public static String CREDIT_TYPE_ACCEPTANCE = "0";
	/** 买入业务 */
	public static String CREDIT_TYPE_BUYIN = "1";

	/**
	 * 产品业务种类 BUSINESS_PRODUCT.BIZ_TYPE 01-直贴买入 02-转贴买入 10-承兑 21-转贴卖出 22-再贴卖出
	 */
	public static String BUSINESS_PRODUCT_BIZ_TYPE_DISCOUNT = "01";// 01-直贴买入
	public static String BUSINESS_PRODUCT_BIZ_TYPE_BUY = "02";// 02-转贴现买入
	public static String BUSINESS_PRODUCT_BIZ_TYPE_SELL_BUYBACK = "06";// 06-转贴回购到期赎回
	public static String BUSINESS_PRODUCT_BIZ_TYPE_PEOPLE_SELL_BUYBACK = "04";// 04-再贴现回购到期赎回
	public static String BUSINESS_PRODUCT_BIZ_TYPE_PEOPLE_BUY = "05";// 05-从央行买入
	public static String BUSINESS_PRODUCT_BIZ_TYPE_ACCEPT = "10";// 10-承兑
	public static String BUSINESS_PRODUCT_BIZ_TYPE_SELL = "21";// 21-转贴卖出
	public static String BUSINESS_PRODUCT_BIZ_TYPE_SELL_TO_PEOPLE_BANK = "22";// 22-再贴卖出
	public static String BUSINESS_PRODUCT_BIZ_TYPE_BANK_BUY_SELLBACK = "31";// 31-转贴到期返售
	public static String BUSINESS_PRODUCT_BIZ_TYPE_BUY_SELLBACK = "41";// 41-贴现到期返售

	/**
	 * 额度占用方
	 */
	/** 占用客户额度 */
	public static String CREDIT_CUSTOMER = "1";
	/** 占用承兑人额度 */
	public static String CREDIT_ACCEPTOR = "2";
	/** 占用客户和承兑人额度 */
	public static String CREDIT_CUSTOMER_AND_ACCEPTOR = "3";
	/** 占用客户或承兑人额度 */
	public static String CREDIT_CUSTOMER_OR_ACCEPTOR = "4";
	/** 占用第三方授信人额度 */
	public static String CREDIT_OTHERS = "5";

	/**
	 * 额度占用方式
	 */
	/** 票面金额 */
	public static String FACE_AMOUNT = "1";
	/** 占用承兑人额度 */
	public static String RISK_BALANCE = "2";

	/** 0-待接受 */
	public static String ELECTRIC_TO_ACCEPT = "0";
	/** 1-接受 */
	public static String ELECTRIC_ACCEPTED = "1";
	/** 2-拒绝 */
	public static String ELECTRIC_REJECTED = "2";

	/** 未审核* */
	public static String AUDIT_STATUS_NULL = "0";
	/** 审核中 */
	public static String AUDIT_STATUS_ING = "1";
	/** 审核通过 */
	public static String AUDIT_STATUS_PASS = "3";
	/** 审核不通过 */
	public static String AUDIT_STATUS_NOTPASS = "2";
	/** 已撤销 */
	public static String AUDIT_STATUS_CANCEL = "4";

	/** 审核同意 */
	public static String AUDIT_RESULT_AGREE = "1";
	/** 审核不同意 */
	public static String AUDIT_RESULT_DISAGREE = "0";

	/**
	 * 额度占用操作
	 */
	public static String CREDIT_CREATE_TYPE = "1"; // 占用
	public static String CREDIT_MODIFY_TYPE = "2"; // 修改
	public static String CREDIT_RESUME_TYPE = "3"; // 恢复

	/**
	 * 任务池锁状态 ECDS APPLOCK (00为可挑选任务) 01-办理加锁 00-办理未加锁
	 */
	public static String APPLY_STATUS_UNLOCK = "00"; // 办理未锁定
	public static String APPLY_STATUS_LOCK = "01"; // 办理锁定

	/*
	 * 报文种类
	 */
	public static String MESG_TYPE_ACCEPT_APPLY = "002"; // 提示承兑申请
	public static String MESG_TYPE_DISCOUNT_APPLY = "011"; // 贴现申请
	public static String MESG_TYPE_TRANSDISCOUNT_APPLY = "013"; // 转贴现申请
	public static String MESG_TYPE_COMMERCIAL_DRAFT_CENTRAL_BANK_SELLING_APPLY = "025"; // 央行卖出商业汇票申请

	/*
	 * 发出托收明细表中，收回状态定义
	 */

	/** 未收回 */
	public static String RECEIVE_STATUS_0 = "0";
	/** 已收回 */
	public static String RECEIVE_STATUS_1 = "1";

	/** 参数表中参数代码 */
	/** 是否对实物票据直贴业务强制采用二次录入复核 是/否 */
	public static String IS_SECOND_CHECK_FOR_DISCOUNT = "BSndChkBuy";
	/** 是否启用审核流程 */
	public static String NEED_AUDIT = "BNeedAudit";
	/** 是否启用查询查复 */
	public static String NEED_QUERY_CHECK = "BNQC";
	/** 是否启用授信控制 */
	public static String NEED_CREDIT_CONTROL = "BNCC";
	/** 系统运行环境 生产/测试 */
	public static String RUN_WAY = "RUNWAY";
	/** 统计余额数据中是否包含卖出回购余额 是/否 CDIS */
	public static String INTEREST_CALC_HAS_SELL_AMOUNT = "ICSHA";
	/** 是否启用贸易背景检查 是/否 */
	public static String BOOLEAN_USE_TRADE_BACKGROUND_CHECK = "BUTAC";
	/** 是否允许先贴后查 是/否 */
	public static String BOOLEAN_ALLOW_DISCOUNT_BEFORE_CHECK = "BADBC";
	/** 客户是否联机查询获得 是/否 */
	public static String BOOLEAN_CUSTOMER_GET_BY_INTERNER = "BCGBI";
	/** 是否自动产生业务批次号 */
	public static String BOOLEAN_AUTOMATIC_CREATE_NO = "BACN";
	/** 实物票据托收到期提醒天数 */
	public static String REAL_DRAFT_WARN_TIME = "RDWI";
	/** 实物票据承兑提前通知客户存款天数 */
	public static String REAL_DRAFT_NOTIFY_CUSTOMER_STORE_TIME = "RDNCS";
	/** 贴现利息计算方式 */
	public static String INTEREST_CALC_SET_WAY = "ICSW";
	/** 转贴现利息计算方式 */
	public static String INTEREST_CALC_SET_WAY_RESELL = "ICSWR";

	public static int TYPE_STRING = 1;
	public static int TYPE_DATE = 2;
	public static int TYPE_AMOUNT = 3;
	/**
	 * 树型结构定义用于生成页面权限
	 */
	public static int TREE_ROOT = 0;
	public static int TREE_TREE_FLAG = 1;
	public static int TREE_MENU_FLAG = 2;

	/**
	 * 有效标志/状态
	 */
	public static final String FLAG_INVALID = "0"; // 无效

	public static final String FLAG_VALID = "1"; // 有效

	/**
	 * SEQNUM类型
	 */
	public static final String SEQ_NUM_TYPE_BUY = "BUY";
	public static final String ELECTRIC_SEQ_NUM = "ELE";
	public static final String ELECTRIC_SEQ_NO = "ESN";
	/**
	 * 买入类型 因为实物票分成了这三个菜单
	 */
	/** 买入类型大类 */
	public static final String BUY_CONTRACT_BUY_TYPE_01 = "01"; // 直贴
	public static final String BUY_CONTRACT_BUY_TYPE_02 = "02"; // 转贴现买断
	public static final String BUY_CONTRACT_BUY_TYPE_03 = "03"; // 买入反售

	/** 买入类型 "0110" -- 一般贴现（银） */
	public static final String BUY_CONTRACT_BUY_TYPE_BANK_DISCOUNT = "0110"; // 一般贴现（银）
	public static final String BUY_CONTRACT_BUY_TYPE_INDUSTRY_DISCOUNT = "0111"; // 一般贴现（商）
	public static final String BUY_CONTRACT_BUY_TYPE_BANK_DATA_BUY = "0120"; // 数据包买（银）
	public static final String BUY_CONTRACT_BUY_TYPE_INDUSTRY_DATA_BUY = "0121"; // 数据包买（商）
	public static final String BUY_CONTRACT_BUY_TYPE_INDUSTRY_GUARANTEE = "0131"; // 商票保贴
	public static final String BUY_CONTRACT_BUY_TYPE_BANK_PROXY_DISCOUNT = "0140"; // 代理贴现（银）
	public static final String BUY_CONTRACT_BUY_TYPE_INDUSTRY_PROXY_DISCOUNT = "0141"; // 代理贴现（商）
	public static final String BUY_CONTRACT_BUY_TYPE_BANK_BUYSELL_DISCOUNT = "0150"; // 回购式贴现（银）
	public static final String BUY_CONTRACT_BUY_TYPE_INDUSTRY_BUYSELL_DISCOUNT = "0151"; // 回购式贴现（商）
	public static final String BUY_CONTRACT_BUY_TYPE_BANK_RESELL = "0210"; // 一般转贴现（银）
	public static final String BUY_CONTRACT_BUY_TYPE_INDUSTRY_RESELL = "0211"; // 一般转贴现（商）
	public static final String BUY_CONTRACT_BUY_TYPE_BANK_TWO_WAY_BUY = "0220"; // 双向买断（银）
	public static final String BUY_CONTRACT_BUY_TYPE_INDUSTRY_TWO_WAY_BUY = "0221"; // 双向买断（商）
	public static final String BUY_CONTRACT_BUY_TYPE_BANK_BUYSELLOUT = "0310"; // 回购式转贴现买入（银）
	public static final String BUY_CONTRACT_BUY_TYPE_INDUSTRY_BUYSELLOUT = "0311"; // 回购式转贴现买入（商）

	public static final String BUY_CONTRACT_BUY_TYPE_BANK_BUY_SELL = "0610";// 转贴现到期赎回（银）
	public static final String BUY_CONTRACT_BUY_TYPE_INDUSTRY_BUY_SELL = "0611";// 转贴现到期赎回（商）

	public static final String BUY_CONTRACT_BUY_TYPE_BANK_ACCEPTOR = "1000"; // 承兑（银）
	public static final String ACCEPT_CONTRACT_BUY_TYPE_BANK_ACCEPTOR_BUSINESS = "1001"; // 承兑（商）

	public static final String RESELL_CONTRACT_TYPE_BANK_SELL_BANK_BUSINESS = "2110"; // 卖断式转贴现(银)
	public static final String RESELL_CONTRACT_TYPE_BANK_SELL_INDUST_BUSINESS = "2111"; // 卖断式转贴现(商)
	public static final String RESELL_CONTRACT_TYPE_BANK_BUYSELL_BANK_BUSINESS = "2120"; // 卖出回购式转贴现(银)
	public static final String RESELL_CONTRACT_TYPE_BANK_BUYSELL_INDUST_BUSINESS = "2121"; // 卖出回购式转贴现(商)
	public static final String RESELL_CONTRACT_TYPE_BANK_SELLOUT_BANK_BUSINESS = "2210"; // 卖断式再贴现(银)
	public static final String RESELL_CONTRACT_TYPE_BANK_SELLOUT_INDUST_BUSINESS = "2211"; // 卖断式再贴现(商)

	public static final String RESELL_CONTRACT_TYPE_BANK_BUYSELLOUT_BANK_BUSINESS = "2220"; // 卖出回购式再贴现(银)
	public static final String RESELL_CONTRACT_TYPE_BANK_BUYSELLOUT_INDUST_BUSINESS = "2221"; // 卖出回购式再贴现(商)

	/** shen_antonio add 20090623. */
	public static final String RESELL_CONTRACT_TYPE_BANK_BUYSELL_DISCOUNT_BBANK_BUSINESS = "4130"; // 回购式贴现到期返售(银)（到期赎回申请）
	public static final String RESELL_CONTRACT_TYPE_BANK_BUYSELL_DISCOUNT_INDUST_BUSINESS = "4131"; // 回购式贴现到期返售(商)（到期赎回申请）

	public static final String BUY_CONTRACT_BUY_TYPE_REDISCOUNT_BANK_BUY_SELL = "0410";// 回购式再贴现赎回(银)(再贴现赎回签收)
	public static final String BUY_CONTRACT_BUY_TYPE_REDISCOUNT_INDUST_BUY_SELL = "0411";// 回购式再贴现赎回(商)(再贴现赎回签收)

	public static final String BUY_CONTRACT_BUY_TYPE_CENTERDISCOUNT_BANK_BUY_SELL = "0510";// 从央行票据买入(银)
	public static final String BUY_CONTRACT_BUY_TYPE_CENTERDISCOUNT_INDUST_BUY_SELL = "0511";// 从央行票据买入(商)(应该不会有这样的情况，只是作为预留）
	/** . */
	public static final String RESELL_CONTRACT_TYPE_BANK_BUYSELL_BUYBACK = "3110";// 转贴现到期返售(银)
	public static final String RESELL_CONTRACT_TYPE_INDUST_BUYSELL_BUYBACK = "3111";// 转贴现到期返售(商)

	public static final String BEYONDRATEAPPLY_BUSINESS_TYPE = "9000";// 超权限利率申请业务类别
	public static final String CHECKQUERY_BUSINESS_TYPE = "9001";// 查询查复申请业务类别

	/**
	 * 买入卖出明细再贴现标志 CENTRAL_BANKFLG
	 */
	public static final String CENTRAL_BANKFLG_ENTERPRISE = "0";// 贴现
	public static final String CENTRAL_BANKFLG_OTHER_BANK = "1";// 转贴现
	public static final String CENTRAL_BANKFLG_PEOPLE_BANK = "2";// 再贴现
	// 或从人民银行买入

	/**
	 * 票据买入卖出种类
	 */
	public static final String SELLBIZ_TYPE_BUYBIZ_TYPE_BUYOUT = "RM00"; // 买断式
	public static final String SELLBIZ_TYPE_BUYBIZ_TYPE_REPURCHASE = "RM01"; // 回购式
	public static final String SELLBIZ_TYPE_BUYBIZ_TYPE_DOUBLE_BUYOUT = "HT01";// 双向买断式
	// 电子票无此功能

	/**
	 * 代理回复标识
	 */
	public static final String PROXY_SIGNATURE_CODE_PROXY="PS00";//PS00开户机构代理回复签章
	public static final String PROXY_SIGNATURE_CODE_SELF="PS01";//PS01客户自己签章

	/**
	 * 承兑明细出票状态ACCEPT_DETAILS.PRINT_STATUS
	 */
	public static final String PRINT_STATUS_HAS_NOT_PRINT = "0";// 未出票
	public static final String PRINT_STATUS_HAS_PRINT = "1";// 已出票
	// 票据种类
	/**
	 * 票据种类-银票(默认)
	 */
	public static final String DRAFT_TYPE_BANK = "1"; // 银票（默认）
	/**
	 * 票据种类-商票
	 */
	public static final String DRAFT_TYPE_INDUSTRY = "2"; // 商票

	/**
	 * 人行票据类型定义
	 */
	public static final String DRAFT_TYPE_BANK_AC01 = "AC01"; // 银票
	public static final String DRAFT_TYPE_INDUSTRY_AC02 = "AC02"; // 商票

	/** 票据属性-1-实物(默认) */
	public static final String DRAFT_ATTR_REAL = "1";
	/** 票据属性-2-电子 */
	public static final String DRAFT_ATTR_ELECTRON = "2";

	// 利率类型
	/**
	 * 利率类型-年息(百分之)
	 */
	public static final String RATE_TYPE_YEAR = "1"; // 年息
	/**
	 * 利率类型-月息(千分之)
	 */
	public static final String RATE_TYPE_MONTH = "2"; // 月息
	/**
	 * 利率类型-日息(万分之)
	 */
	public static final String RATE_TYPE_DAY = "3"; // 日息

	/**
	 * 百分之
	 */
	public static final String RATIO_TYPE_PERCENT = "1";
	/**
	 * 利率类型-月息(千分之)
	 */
	public static final String RATIO_TYPE_PER_THOUSAND = "2";
	/**
	 * 利率类型-日息(万分之)
	 */
	public static final String RATIO_TYPE_PER_TEN_THOUSAND = "3";

	public static final String RATE_TYPE_YEAR_NAME = "年息"; // 年息
	public static final String RATE_TYPE_MONTH_NAME = "月息"; // 月息
	public static final String RATE_TYPE_DAY_NAME = "日息"; // 日息

	/**
	 * 付息方式
	 */
	public static final String RAY_TYPE_NONE = "0"; // 无
	public static final String RAY_TYPE_BUY = "2"; // 买方付息
	public static final String RAY_TYPE_SELL = "1"; // 卖方付息
	public static final String RAY_TYPE_BOTH = "3"; // 协议付息

	/**
	 * 查询方式
	 */
	public static final String QUERY_TYPE_MAIL = "1"; // 电查
	public static final String QUERY_TYPE_PERSON = "2"; // 实查

	/**
	 * 查询结果
	 */
	public static final String QUERY_TYPE_RESULT_NORMAL = "1"; // 正常
	public static final String QUERY_TYPE_RESULT_ERROR = "0"; // 异常

	/**
	 * 额度占用情况
	 */
	public static final String CREDIT_LINE_NOT_DEAL = "0"; // 未处理
	public static final String CREDIT_LINE_ENQROSS = "1"; // 已占用
	public static final String CREDIT_LINE_DRAW = "2"; // 已支用
	public static final String CREDIT_LINE_RECOVER = "3"; // 已恢复

	/**
	 * 收票
	 */
	public static final String ACCEPR_STATUS_CANCEL_RECIVE = "2"; // 取消收票
	public static final String ACCEPR_STATUS_RECIVE = "1"; // 收票
	public static final String ACCEPR_STATUS_NOT_RECIVE = "0"; // 未收票

	/**
	 * 查询查复状态
	 */
	public static final String QUERY_STATUS_NONE = "0"; // 未查询
	public static final String QUERY_STATUS_CHECKING = "1"; // 正在查询
	public static final String QUERY_STATUS_FINISH_SUCCESS = "2"; // 查询成功
	public static final String QUERY_STATUS_FINISH_FAILURE = "3"; // 查询失败

	/**
	 * 库存状态
	 */
	public static final String STORE_STATUS_NONE = "0"; // 未入库
	public static final String STORE_STATUS_IN = "1"; // 入库
	public static final String STORE_STATUS_OUT = "2"; // 出库

	/**
	 * 瑕疵状态
	 */
	public static final String BUY_DETAILS_STATUS_NOT_FLAW = "0"; // 无瑕疵
	public static final String BUY_DETAILS_STATUS_FLAW = "1"; // 有瑕疵

	/**
	 * 状态
	 */
	/** 状态-0-正常 */
	public static final String STATUS_NOT_DISAFFIRM = "0";
	/** 状态-1-废弃 */
	public static final String STATUS_DISAFFIRM = "1";

	/**
	 * 客户类型
	 */
	public static final String CUSTOMER_BANK = "2"; // 银行
	public static final String CUSTOMER_INDUSTRY = "1"; // 企业
	public static final String CUSTOMER_OTHERS = "3"; // 其他

	/**
	 * 同意与否
	 */
	/** 同意 */
	public static final String STATUS_AGREE = "1";
	/** 不同意 */
	public static final String STATUS_DISAGREE = "0";

	/**
	 * 是否同城
	 */
	/** 是 */
	public static final String SAME_CITY = "1";
	/** 否 */
	public static final String DIFF_CITY = "0";

	/**
	 * 买入状态
	 */
	public static final String BUY_CONTRACT_STATUS_NOT_RISK_CHECK = "0"; // 未风险检查
	public static final String BUY_CONTRACT_STATUS_RISK_CHECK_SUCCESS = "1"; // 风险检查成功
	public static final String BUY_CONTRACT_STATUS_RISK_CHECK_FAILURE = "2"; // 风险检查失败

	public static final String BUY_CONTRACT_STATUS_NOT_CREDIT_CHECK = "0"; // 未授信检查
	public static final String BUY_CONTRACT_STATUS_CREDIT_CHECK_SUCCESS = "1"; // 授信检查成功
	public static final String BUY_CONTRACT_STATUS_CREDIT_CHECK_FAILURE = "2"; // 授信检查失败

	public static final String BUY_CONTRACT_STATUS_NOT_LOGIC_CHECK = "0"; // 未业务逻辑查询
	public static final String BUY_CONTRACT_STATUS_LOGIC_CHECK_SUCCESS = "1"; // 业务逻辑查询成功
	public static final String BUY_CONTRACT_STATUS_LOGIC_CHECK_FAILURE = "2"; // 业务逻辑查询失败

	public static final String BUY_CONTRACT_STATUS_NOT_SUBMIT_AUDIT = "0"; // 未提交审核
	public static final String BUY_CONTRACT_STATUS_SUBMIT_AUDIT = "1"; // 提交审核
	public static final String BUY_CONTRACT_STATUS_AUDITING = "2"; // 审核中
	public static final String BUY_CONTRACT_STATUS_AUDIT_SUCCESS = "3"; // 审核成功
	public static final String BUY_CONTRACT_STATUS_AUDIT_FAILURE = "4"; // 审核失败
	public static final String BUY_CONTRACT_STATUS_AUDIT_GOBACK = "5";// 审核退回

	public static final String BUY_CONTRACT_STATUS_NOT_PAYMENT_CHECK = "0"; // 未计息复核
	public static final String BUY_CONTRACT_STATUS_PAYMENT_CHECK_SUCCESS = "1"; // 计息复核成功
	public static final String BUY_CONTRACT_STATUS_PAYMENT_CHECK_FAILURE = "2"; // 计息复核失败

	/** 买入批次状态-0-未通知放款 */
	public static final String BUY_CONTRACT_STATUS_NOT_BUY_ACCOUNT = "0";
	/** 买入批次状态-1-记账中 */
	public static final String BUY_CONTRACT_STATUS_BUY_ACCOUNTING = "1";
	/** 买入批次状态-2-记账成功 */
	public static final String BUY_CONTRACT_STATUS_BUY_ACCOUNT_SUCCESS = "2";
	/** 买入批次状态-3-记账失败 */
	public static final String BUY_CONTRACT_STATUS_BUY_ACCOUNT_FAILURE = "3";
	/** 买入批次状态-4-记账退回 */
	public static final String BUY_CONTRACT_STATUS_BUY_ACCOUNT_BACK = "4";
	/** 买入批次状态-5-通知放款 */
	public static final String BUY_CONTRACT_STATUS_BUY_ACCOUNT_SEND_MONEY = "5";
	/** 买入批次状态-6-取消通知放款 */
	public static final String BUY_CONTRACT_STATUS_BUY_ACCOUNT_CANCEL_MONEY = "6";

	/**
	 * 票据主要状态
	 *
	 * @author FTM
	 */
	/** 票据主要状态-00-库存 */
	public static final String DRAFT_STATUS_IN_STORE = "00";
	/** 票据主要状态-01-已承兑 */
	public static final String DRAFT_STATUS_ACCEPT = "01";
	/** 票据主要状态-02-已拒绝承兑 */
	public static final String DRAFT_STATUS_ACCEPT_REFUSE = "02";
	/** 票据主要状态-03-已未用退回 */
	public static final String DRAFT_STATUS_UNUSED_RESTITUTION = "03";
	/** 票据主要状态-04-已解付 */
	public static final String DRAFT_STATUS_PAY = "04";
	/** 票据主要状态-05-已垫款 */
	public static final String DRAFT_STATUS_ADVANCE = "05";
	/** 票据主要状态-11-已买入返售还票 */
	public static final String DRAFT_STATUS_BUY_RSELL_RETURNED = "11";
	/** 票据主要状态-21-已卖断销账 */
	public static final String DRAFT_STATUS_SOLD_CHARGE_OFF = "21";
	/** 票据主要状态-30-回购未还 */
	public static final String DRAFT_STATUS_BUY_BACK_UNRETURNED = "30";
	/** 票据主要状态-40-托收在途 */
	public static final String DRAFT_STATUS_ON_COLLECTION = "40";// 未启用
	/** 票据主要状态-41-已在退回过程中（便于退回的选择挑票） */
	public static final String DRAFT_STATUS_IN_RETURN_PROCESS = "41";// 未启用
	public static final String DRAFT_STATUS_RECEIVED = "42";// 托收已收回
	public static final String DRAFT_STATUS_RECEIVED_BUY_TYPE = "43";// 贴现已收回
	/** 票据主要状态-51-逾期 */
	public static final String DRAFT_STATUS_OVERDUE = "51";
	/** 电子票据状态-52-结清 */
	public static final String DRAFT_STATUS_OVERDUE_CLEAR = "52";
	/** 电子票据状态-保证业务-已保证 * */
	public static final String DRAFT_STATUS_GUARNED = "60";// 已保证
	/** 电子票据状态-99-无效 */
	public static final String DRAFT_INFO_USELESS = "99";
	/** 电子票据状态-质押业务-已经解除质押 */
	public static final String DRAFT_INFO_UNCOLLZTN = "71";
	/** 电子票据状态-53-票据已作废 */
	public static final String DRAFT_INFO_INVALID = "53"; //票据已作废;
	/** 电子票据状态-54-回购式(转／再)贴现逾赎回截止日 */
	public static final String DRAFT_STATUS_ZTIEXIAN_OVERDUE = "54";
	//add by jornezhang BMS-1717 BMS关于追索和赎回交易状态调整 begin
	/** 电子票据状态-56-追索已结清 */
	public static final String DRAFT_STATUS_RECOURSE_CLEAR = "56";
	/** 电子票据状态-80-已同意清偿 */
	public static final String DRAFT_STATUS_RECOURSE_AGREE = "80";
	//add by jornezhang BMS-1717 BMS关于追索和赎回交易状态调整 end
	/** add by liyi 0831 BMS-1717 bgein.*/
	/** 55-回购式(转/再)贴现已至赎回开放日【原贴入人/贴出人，收到040时修改】.*/
	public static final String DRAFT_STATUS_ZTIEXIAN_OPERDUE = "55";
	/** 10-回购式库存【原贴入人使用，回购式入库时使用】*/
	public static final String DRAFT_STATUS_RESELL_STORE = "10";
	/** add by liyi 0831 BMS-1717 end.*/

	/**
	 * 票据表-处理中状态-tmp_status add by weisuling
	 */
	public static final String DRAFT_TMP_FINISH = "00";// 00-处理结束
	public static final String DRAFT_TMP_ACCEPTTING = "01";// 01-承兑受理中
	public static final String DRAFT_TMP_RETRIEVING = "02";// 02-未用退回受理中
	public static final String DRAFT_TMP_EXPIRING = "03";// 03-到期受理中
	public static final String DRAFT_TMP_BUYING = "04";// 04-买入中
	public static final String DRAFT_TMP_COLLECTING = "05";// 05-托收在途
	public static final String DRAFT_TMP_SELLING = "06";// 06-转卖中
	public static final String REPORT_LOSS_NO = "07"; // 买入返售处理中
	public static final String DRAFT_TMP_LOSS_YES = "08"; // 卖出回购处理中
	public static final String DRAFT_TMP_LOSS_SUBMIT = "09"; // 挂失处理中
	public static final String DRAFT_TMP_UNLOSS_ACCOUNT = "10"; // 解挂处理中
	public static final String DRAFT_TMP_IMPAW_SUBMIT = "11"; // 质押处理中
	public static final String DRAFT_TMP_IMPAW_ACCOUNT = "12"; // 解除质押处理中
	public static final String DRAFT_TMP_GUARN_PROCESSING = "13";// 保证处理中

	/**
	 * 电子票据状态
	 */
	/** 电子票据状态-00-库存 */
	public static final String ELECTRIC_DRAFT_STATUS_IN_STORE = "00";
	/** 电子票据状态-10-贴现中 */
	public static final String ELECTRIC_DRAFT_STATUS_IN_BUY = "10";
	/** 电子票据状态-20-背书中 */
	public static final String ELECTRIC_DRAFT_STATUS_IN_ENDOSE = "20";
	/** 电子票据状态-30-保证中 */
	public static final String ELECTRIC_DRAFT_STATUS_IN_GUARANTEE = "30";
	/** 电子票据状态-40-质押中 */
	public static final String ELECTRIC_DRAFT_STATUS_IN_IMPAWN = "40";
	/** 电子票据状态-50-提示付款中 */
	public static final String ELECTRIC_DRAFT_STATUS_IN_PROMPT = "50";
	/** 电子票据状态-60-追索 */
	public static final String ELECTRIC_DRAFT_STATUS_IN_SWITCH_HOLDER = "60";
	/** 电子票据状态-70-回购 */
	public static final String ELECTRIC_DRAFT_STATUS_IN_BUY_BACK = "70";
	/** 电子票据状态-80-结清 */
	public static final String ELECTRIC_DRAFT_STATUS_FINISH = "80";

	/**
	 * 买入票据主要状态
	 *
	 * @author FTM
	 */
	public static final String BUY_DRAFT_STATUS_IN = "1"; // 1 - 库存
	public static final String BUY_DRAFT_STATUS_SOLD = "2"; // 2 - 已卖断销账
	public static final String BUY_DRAFT_STATUS_NOT_BACK = "3"; // 3 - 回购未还
	public static final String BUY_DRAFT_STATUS_ON_COLLECTION = "4"; // 4 -
	// 托收在途
	public static final String BUY_DRAFT_STATUS_RECEIVED = "5"; // 5 - 已收回
	public static final String BUY_DRAFT_STATUS_RESELL_RETURNED = "6"; // 6 -
	// 已买入返售还票
	/**
	 * 买入卖出协议(回购式)到期处理状态
	 *
	 * @author jason.mao
	 */
	public static final String MATURITY_STATUS_CONTRACT_EXPIRE_UNTREATED = "0";// 0-未做过到期处理
	public static final String MATURITY_STATUS_CONTRACT_EXPIRE_DONE = "1"; // 1-已做过到期处理（已出现于到期表）
	public static final String MATURITY_STATUS_CONTRACT_EXPIRE_DOING = "2"; // 2-到期处理中
	public static final String MATURITY_STATUS_CONTRACT_EXPIRE_PART_DONE = "3"; // 3-部分到期处理

	/**
	 * 挑票批次状态
	 */
	public static final String RESELL_TEMP_CONTRACT_TORESELL = "0"; // 未转卖
	public static final String RESELL_TEMP_CONTRACT_DONE = "1"; // 已转卖
	/**
	 * 买入批次收益分配状态
	 */
	public static final String PROFIT_ASSIGN_STATUS_UN = "0"; // 未收益分配
	public static final String PROFIT_ASSIGN_STATUS_DN = "1"; // 已收益分配

	/**
	 * 到期操作状态
	 *
	 * @author weisl
	 */
	public static final String EXPIRE_NOT_SUBMITTED = "00"; // 00-新增未处理
	public static final String EXPIRE_APPROVING = "01"; // 01-到期处理中
	public static final String EXPIRE_REFUSE = "02"; // 02-到期处理失败
	public static final String EXPIRE_PASS = "03"; // 03-到期处理成功
	public static final String EXPIRE_REJECT = "04"; // 04-驳回对方申请
	public static final String EXPIRE_PART_PASS = "05"; // 05-部分到期处理成功

	/**
	 * 到期记账状态
	 *
	 * @author weisl
	 */
	public static final String EXPIRE_UNACCOUNT = "0"; // 0-未记账
	public static final String EXPIRE_ACCOUNTING = "1"; // 1-记账中
	public static final String EXPIRE_ACCOUNT_SUCCESS = "2"; // 2-记账成功
	public static final String EXPIRE_ACCOUNT_FAILED = "3"; // 3-记账失败
	//add by fanrong 20110420 BMS-3016 begin
	public static final String ACCOUNT_STATUS_4 = "4"; // 4-已抹账
	//add by fanrong 20110420 BMS-3016 end

	/**
	 * 库存状态
	 *
	 * public static final String NO_STORAGE = "0"; // 0 - 未入库 public static
	 * final String STORAGE_IN = "1"; // 1 - 在库 public static final String
	 * STORAGE_OUT = "2"; // 2 - 出库
	 *
	 * /** 发出托收操作状态
	 *
	 * @author FTM
	 */
	public static final String COLLECTION_TODO = "0"; // 0 - 未发出托收
	public static final String COLLECTION_DONE = "1"; // 1 - 已发出托收

	/**
	 * 托收批次退票状态
	 *
	 * @author FTM
	 */
	public static final String COLLECTION_RETURNED_TODO = "0"; // 0 - 退票办理中
	public static final String COLLECTION_RETURNED_DONE = "1"; // 1 - 已退票

	/**
	 * 托收明细退票状态
	 *
	 * @author FTM
	 */
	public static final String COLLECTION_RETURNED_UNRECEIVED = "0"; // 收票办理中
	public static final String COLLECTION_RETURNED_RECEIVED = "1"; // 已收票
	public static final String COLLECTION_RETURNED_RECEIVED_ACCOUNT = "1"; // 已收票记账

	/**
	 * 票据来源
	 *
	 * @author FTM
	 */
	public static final String DRAFT_SOURCE_SELF = "1"; // 1 - 自有
	public static final String DRAFT_SOURCE_KEEPING = "2"; // 2 - 代保管

	/**
	 *
	 */
	public static final String NORMAL_STATUS = "1"; // 否
	public static final String CANCEL_STATUS = "2"; // 是

	/**
	 * 空白凭证批次状态 lizh
	 */
	public static final String BLANK_VOUCHER_BATCHSTATE_0 = "0";// 未记账
	public static final String BLANK_VOUCHER_BATCHSTATE_1 = "1";// 已记账

	/**
	 * 逾期状态
	 */
	public static final String OVERDUE_STATUS_0 = "0";// 0未逾期
	public static final String OVERDUE_STATUS_1 = "1";// 1逾期
	public static final String OVERDUE_STATUS_2 = "2";// 2结清

	/**
	 * 空白凭证明细状态 lizh 说明：（批次中的已记账状态即是明细中的未使用状态）
	 */
	public static final String BLANK_VOUCHER_STATUS_0 = "0";// 未使用
	public static final String BLANK_VOUCHER_STATUS_1 = "1";// 已使用
	public static final String BLANK_VOUCHER_STATUS_2 = "2";// 已作废
	public static final String BLANK_VOUCHER_STATUS_3 = "3";// 未记账

	/**
	 * 保证金 是否为付款人 lizh
	 *
	 */
	public static final String DRAWEE_FLAG_0 = "0";// 是
	public static final String DRAWEE_FLAG_1 = "1";// 否

	/**
	 * 承兑协议状态(ACCEPT_CONTRACT) lizh 0-已录入 1-签票处理中 2-签票成功 3-签票失败 4-出票退回 5-承兑处理中
	 * 6-已承兑 7-承兑失败 ；
	 */

	/** 承兑协议状态-已录入 */
	public static final String CONTRACT_STATUS_ADD = "0";// 已录入

	/** 承兑协议状态- 签票处理中 */
	public static final String CONTRACT_STATUS_PARTCHECKOUT = "1";// 部分签发出票成功
	// 换成 签票处理中

	/** 承兑协议状态-签票成功 */
	public static final String CONTRACT_STATUS_ALLCHECKOUT = "2";// 签票成功

	/** 承兑协议状态-签票失败 */
	public static final String CONTRACT_STATUS_CHECKOUT_FAILURE = "3";// 签票失败

	/** 承兑协议状态-出票退回 */
	public static final String CONTRACT_STATUS_BACK = "4";// 出票退回

	/** 承兑协议状态-承兑处理中 */
	public static final String CONTRACT_STATUS_PARTACCEPTANCE = "5";// 部分承兑成功 换成
	// 承兑处理中

	/** 承兑协议状态-已承兑 */
	public static final String CONTRACT_STATUS_ALLACCEPTANCE = "6";// 承兑成功 换成
	// 已承兑

	/** 承兑协议状态-承兑失败 */
	public static final String CONTRACT_STATUS_ALLACCEPTANCE_FAILURE = "7";// 承兑失败

	/**
	 * 承兑业务数据来源类型 DATASOURCETYPE lizh
	 */
	public static final String DATASOURCETYPE_SYSTEM = "1"; // 系统手工录入
	public static final String DATASOURCETYPE_NETBANK = "2"; // 接收网银数据

	/**
	 * 收到托收登记 GATHERING_TYPE 收款类型 lizh
	 */
	public static final String GATHERING_TYPE_NO = "0"; // 0-不划
	public static final String GATHERING_TYPE_ELECTRIC = "1"; // 1-电划（默认）
	public static final String GATHERING_TYPE_MAIL = "2"; // 2-邮划

	/**
	 * 收到托收登记 BEARER_KIND 托收人性质 lizh
	 */
	public static final String BEARER_KIND_BANK = "1"; // 银行
	public static final String BEARER_KIND_BUSINESS = "2"; // 企业

	/**
	 * 承兑批次 业务逻辑检查(LOGIC_CHECK_STATUS) lizh
	 */
	public static final String LOGIC_CHECK_STATUS_NO = "1";// 业务逻辑未检查(默认)
	public static final String LOGIC_CHECK_STATUS_SUCCESS = "2";// 业务逻辑检查成功
	public static final String LOGIC_CHECK_STATUS_FAILURE = "3";// 业务逻辑检查失败

	/**
	 * 承兑批次 授信检查(CREDIT_CHECK_STATUS) lizh
	 */
	public static final String CREDIT_CHECK_STATUS_NO = "0";// 未检查
	public static final String CREDIT_CHECK_STATUS_SUCCESS = "1";// 检查成功
	public static final String CREDIT_CHECK_STATUS_FAILURE = "2";// 检查失败

	/**
	 * 承兑批次 审核状态(AUDIT_STATUS) lizh
	 *
	 * 0-未审核（默认）1-提交审核(未用) 2-审核中 3-审核成功 4-审核失败 5-审核退回；
	 */
	public static final String AUDIT_STATUS_NO = "0";// 未审核（默认）
	public static final String AUDIT_STATUS_ON = "1";// 提交审核
	public static final String AUDIT_STATUS_IN = "2";// 审核中
	public static final String AUDIT_STATUS_SUCCESS = "3";// 审核成功
	public static final String AUDIT_STATUS_FAILURE = "4";// 审核失败
	public static final String AUDIT_STATUS_GOBACK = "5";// 审核退回

	// public static final String AUDIT_STATUS_UNSUBMIT="5";//撤销提交
	// public static final String AUDIT_STATUS_PARTSUBMIT="6";//部分提交

	/**
	 * 业务产品表 (BUSINESS_PRODUCT) 产品类型(PRODUCT_TYPE) lizh
	 */
	public static final String PRODUCT_TYPE_BUSINESS = "1";// 业务产品
	public static final String PRODUCT_TYPE_CREDIT = "2";// 授信产品

	/**
	 * 授信控制 授信批复信息(CREDIT_INFO) 授信种类(CREDIT_TYPE) lizh
	 */
	public static final String CREDIT_TYPE_COMMNON = "1";// 对公授信（企业授信）
	public static final String CREDIT_TYPE_SAME = "2";// 同来授信

	/**
	 * 授信控制 (CREDIT_RECORD) 是否有效(CREDIT_STATE) lizh
	 */
	public static final String CREDIT_STATE_YES = "1";// 正常
	public static final String CREDIT_STATE_NO = "0";// 已冻结

	/**
	 * 授信控制 (CREDIT_RECORD) 产品类型(EFFECTIVE_FLAG) lizh
	 */
	public static final String EFFECTIVE_FLAG_SUBMIT = "2";// 已提交
	public static final String EFFECTIVE_FLAG_YES = "1";// 有效
	public static final String EFFECTIVE_FLAG_NO = "0";// 无效

	/**
	 * 授信控制 批复表(CREDIT_INFO) 授信批复类型(CREDIT_INFO_TYPE) lizh
	 */
	public static final String CREDIT_INFO_TYPE_Single = "1";// 单笔单批
	public static final String CREDIT_INFO_TYPE_MANY = "2";// 综合授信

	/**
	 * 额度占用状态(CREDIT_LINE_STATUS) lizh
	 */
	public static final String CREDIT_LINE_STATUS_0 = "0";// 未占用
	public static final String CREDIT_LINE_STATUS_1 = "1";// 已占用
	public static final String CREDIT_LINE_STATUS_2 = "2";// 已支用
	public static final String CREDIT_LINE_STATUS_3 = "3";// 已恢复

	/**
	 * 查询查复登记 (RECEIVE_CHECK) author lizh
	 */
	public static final String YES_CHECKED_FLAG = "1";// 已查复
	public static final String NO_CHECKED_FLAG = "0";// 未查复

	/**
	 * 业务流水表 交易状态 (DEAL_STATE) author lizh
	 */
	public static final String DEAL_STATE_0 = "0";// 失败
	public static final String DEAL_STATE_1 = "1";// 成功

	/**
	 * 是否标志-否
	 */
	public static final String FLAG_OFF = "0"; // 否
	/**
	 * 是否标志-是
	 */
	public static final String FLAG_ON = "1"; // 是

	/**
	 * 客户管理(自然人管理)管理模式
	 */
	public static final String CUST_INDV_FLAG_MODE = "0"; // 1为分行模式

	/**
	 * 币种
	 */
	public static final String CURCD_RMB = "CNY"; // 人民币

	/**
	 * 日期格式
	 */
	public static final String DATE_PATTERN = "yyyyMMdd";

	/**
	 * 机构风险控制模式
	 */
	public static final String BRH_LIMIT_AMOUNT = "1";
	public static final String BRH_LIMIT_COUNT = "2";
	public static final String BRH_LIMIT_BOTH = "3";

	/**
	 * 核心系统合同号长度
	 */
	public static final int CONTRACTNO_LENGTH = 14;

	// seqctl中的value_no
	public static final int VALUE_NO_APPNO = 1; // 申请编号
	public static final int VALUE_NO_CUSTCD = 2; // 客户编码
	public static final int VALUE_NO_CONTRACTNO = 3; // 合同号
	public static final int VALUE_NO_PROJECTNO = 4; // 合作项目编号
	public static final int VALUE_NO_HOUSENO = 5; // 楼盘编号
	public static final int VALUE_NO_ACCUM_FUND_ACTNO = 6; // 公积金帐号
	public static final int VALUE_NO_ARCHIVE_ID = 7; // 档案要素编号
	public static final int VALUE_NO_WARNING_ID = 8; // 预警编号
	public static final int VALUE_NO_MORIIMPAWN_ID = 9;// 抵质压合同序号
	public static final int VALUE_NO_BRCODE = 10;// 机构编号
	public static final int VALUE_NO_CORESYS = 50; // 核心交易请求流水号
	public static final int VALUE_NO_CONVERT_PAY_NO = 20; // 转应解批次文件编号
	public static final int VALUE_NO_CALL_HOST = 11; // 转应解批次文件编号

	// seqctl中默认的value_index
	public static final String VALUE_INDEX = "00000000000000000000";

	// 公积金帐号科目(用于生成公积金帐号)
	public static final String ACCUM_FUND_ACNO = "0950";

	// 网银交易流水号
	public static final int EBANK_FLOW_NO = 2;

	// 网银批次号
	public static final int EBANK_BATCH_NO = 3;

	//public static final String BRCODE_CLASS_SELF = "0"; // 发起行同级机构（工作流参数配置使用） 2011/10/12 注释 by huaidong.li 广发总行机构级别为0
	/**
	 * 机构级别
	 */
	public static final String BRCODE_CLASS_HEAD = "1"; // 总行
	public static final String BRCODE_CLASS_BRANCH = "2"; // 分行
	public static final String BRCODE_CLASS_SUBBRANCH = "3"; // 支行

	public static final String BRCODE_ATTR_ACCTBRANCH = "1"; // 账务机构
	public static final String BRCODE_ATTR_TXNBRNACH = "2"; // 经办机构

	/*
	 * /** 管理机构级别
	 *
	 * public static final String MANAGE_BRCODE_CLASS_HEAD = "0"; // 总行 public
	 * static final String MANAGE_BRCODE_CLASS_BRANCH = "1"; // 分行 public static
	 * final String MANAGE_BRCODE_CLASS_SUBBRANCH = "2"; // 支行
	 */
	/**
	 * 操作员业务审批类型
	 */
	public static final String LIMIT_PARAM_BIZ_CLASS_ALL = "0"; // 全部
	public static final String LIMIT_PARAM_BIZ_CLASS_LOAN = "1"; // 贷款业务
	public static final String LIMIT_PARAM_BIZ_CLASS_PROJ = "2"; // 合作项目

	/**
	 * 岗位类型
	 */
	/*
	 * public static final String ROLE_TYPE_OTHER = "0"; // 其它 public static
	 * final String ROLE_TYPE_INPUT = "1"; // 录入岗 public static final String
	 * ROLE_TYPE_MGR = "2"; // 客户经理 public static final String ROLE_TYPE_AUDIT =
	 * "3"; // 审查岗 public static final String ROLE_TYPE_APPROVE = "4"; // 审批岗
	 * public static final String ROLE_TYPE_COUNCIL = "5"; // 贷审会意见录入岗 public
	 * static final String ROLE_TYPE_SUPERVISE = "6"; // 放款监督岗
	 */

	/**
	 * 票据未用退回状态
	 */
	public static final String UNUSE_STATE_YES = "0"; // 未用退回已受理
	public static final String UNUSE_STATE_SUBMIT = "1"; // 未用退回已提交
	public static final String UNUSE_STATE_ACCOUNT = "2"; // 未用退回已记账

	/**
	 * 票据挂失止付状态 REPORT_OF_LOSS STATUS
	 */
	public static final String REPORT_LOSS_YES = "1"; // 挂失已受理
	public static final String REPORT_LOSS_SUBMIT = "2"; // 挂失已提交
	public static final String REPORT_LOSS_ACCOUNT = "3"; // 已挂失
	public static final String CANCEL_REPORT_LOSS_SUBMIT = "4"; // 解除挂失提交
	public static final String CANCEL_REPORT_LOSS_ACCOUNT = "5"; // 已解挂

	/**
	 * 承兑明细状态 author lizh 0-处理中 1-已出票 2-已承兑 3-挂失已受理 4-挂失已记账 5-未用退回已受理 6-未用退回已记账
	 * 7-解挂已受理 8-到期中 9-已兑付；
	 */
	public static final String ACCEPT_DETAILS_STATUS_PROCESS = "0"; // 处理中
	public static final String ACCEPT_DETAILS_STATUS_OUT = "1"; // 已出票
	/** ACCEPT_DETAILS_STATUS_YES = 2 已承兑 */
	public static final String ACCEPT_DETAILS_STATUS_YES = "2";
	public static final String ACCEPT_DETAILS_STATUS_LOSS = "3"; // 挂失已受理
	public static final String ACCEPT_DETAILS_STATUS_LOSS_ACCOUNT = "4"; // 挂失已记账
	public static final String ACCEPT_DETAILS_STATUS_Unuse = "5"; // 未用退回已受理
	public static final String ACCEPT_DETAILS_STATUS_Unuse_ACCOUNT = "6"; // 未用退回已记账
	public static final String ACCEPT_DETAILS_STATUS_UNLOSS = "7"; // 解挂已受理
	// add by FTM

	public static final String ACCEPT_DETAILS_STATUS_IN_EXPIRE = "8"; // 到期业务中
	public static final String ACCEPT_DETAILS_STATUS_PAY_DONE = "9"; // 已兑付

	// 转卖协议表 记账状态
	/**
	 * 转卖协议表 记账状态 0-未记账
	 */
	public static final String RESELL_CONTRACT_ACCOUNT_STATUS_UNACCOUNT = "0";
	/**
	 * 转卖协议表 记账状态 1-记账中
	 */
	public static final String RESELL_CONTRACT_ACCOUNT_STATUS_ACCOUNTING = "1";
	/**
	 * 转卖协议表 记账状态 2-记账成功
	 */
	public static final String RESELL_CONTRACT_ACCOUNT_STATUS_ACCOUNT_SUCCESS = "2";
	/**
	 * 转卖协议表 记账状态 3-记账失败
	 */
	public static final String RESELL_CONTRACT_ACCOUNT_STATUS_ACCOUNT_FAILED = "3";
	/**
	 * 转卖协议表 记账状态 4-记账退回
	 */
	public static final String RESELL_CONTRACT_ACCOUNT_STATUS_ACCOUNT_RETURNED = "4";
	/**
	 * 转卖协议表 记账状态 5-通知划款
	 */
	public static final String RESELL_CONTRACT_ACCOUNT_STATUS_NOTICE_LENDER = "5";
	/**
	 * 转卖协议表 记账状态 6-取消通知划款
	 */
	public static final String RESELL_CONTRACT_ACCOUNT_STATUS_CANCEL_NOTICE_LENDER = "6";

	// 转卖协议表 审核状态
	/**
	 * 转卖协议表 审核状态 0-未审核
	 */
	public static final String RESELL_CONTRACT_AUDIT_STATUS_UNAUDIT = "0";
	/**
	 * 转卖协议表 审核状态 1-提交审核
	 */
	public static final String RESELL_CONTRACT_AUDIT_STATUS_AUDIT_SUBMIT = "1";
	/**
	 * 转卖协议表 审核状态 2-审核中
	 */
	public static final String RESELL_CONTRACT_AUDIT_STATUS_AUDITTING = "2";
	/**
	 * 转卖协议表 审核状态 3-审核成功
	 */
	public static final String RESELL_CONTRACT_AUDIT_STATUS_AUDIT_SUCCESS = "3";
	/**
	 * 转卖协议表 审核状态 4-审核失败
	 */
	public static final String RESELL_CONTRACT_AUDIT_STATUS_AUDIT_FAILED = "4";
	/**
	 * 转卖协议表 审核状态 5-审核退回
	 */
	public static final String RESELL_CONTRACT_AUDIT_STATUS_AUDIT_GOBACK = "5";

	// 转卖协议表 计息复核状态
	/**
	 * 转卖协议表 计息复核状态 0-未计息复核
	 */
	public static final String RESELL_CONTRACT_CALC_STATUS_UNCHECK = "0";
	/**
	 * 转卖协议表 计息复核状态 1-计息复核成功
	 */
	public static final String RESELL_CONTRACT_CALC_STATUS_SUCCESS = "1";
	/**
	 * 转卖协议表 计息复核状态 2-计息复核失败
	 */
	public static final String RESELL_CONTRACT_CALC_STATUS_FAILED = "2";

	// 转卖协议表 对方行接收状态
	/**
	 * 转卖协议表 对方行接收状态 0-未发出签收
	 */
	public static final String RESELL_CONTRACT_ACCEPT_STATUS_UNSUBMIT = "0";
	/**
	 * 转卖协议表 对方行接收状态 1-已发出签收
	 */
	public static final String RESELL_CONTRACT_ACCEPT_STATUS_SUBMIT = "1";
	/**
	 * 转卖协议表 对方行接收状态 2-签收中
	 */
	public static final String RESELL_CONTRACT_ACCEPT_STATUS_ACCEPTING = "2";
	/**
	 * 转卖协议表 对方行接收状态 3-已签收完成
	 */
	public static final String RESELL_CONTRACT_ACCEPT_STATUS_ACCEPTTED = "3";
	/**
	 * 转卖协议表 对方行接收状态 4-拒绝签收
	 */
	public static final String RESELL_CONTRACT_ACCEPT_STATUS_UNACCEPTED = "4";

	// 转卖明细表 对方行接收状态
	/**
	 * 转卖明细表 对方行接收状态 0-未发出签收
	 */
	public static final String RESELL_DETAILS_ACCEPT_STATUS_UNSUBMIT = "0";
	/**
	 * 转卖明细表 对方行接收状态 1-已发出签收
	 */
	public static final String RESELL_DETAILS_ACCEPT_STATUS_SUMBIT = "1";
	/**
	 * 转卖明细表 对方行接收状态 2-已接收
	 */
	public static final String RESELL_DETAILS_ACCEPT_STATUS_ACCEPTTED = "2";
	/**
	 * 转卖明细表 对方行接收状态 3-已拒绝
	 */
	public static final String RESELL_DETAILS_ACCEPT_STATUS_UNACCEPTTED = "3";

	// 买入协议状态
	public static final String BUY_DISAFFIRM_STATUS_ABAND = "1";// 废除
	public static final String BUY_DISAFFIRM_STATUS_NOM = "0"; // 正常
	public static final String BUY_DISAFFIRM_STATUS_REJECTED = "2";// 驳回

	/**
	 * globalinfo表ID
	 */
	public static final int TABLE_GLOBAL_INFO_ID = 1;

	/**
	 * session ID的常量定义
	 */
	public static final String WEB_SESSION_ID = "jsessionid";

	/**
	 * add by NT 2007-09-20 来源于交行个贷 缺省用户密码加密密钥
	 */
	public static final String DEFAULT_PASSWORD_KEY = "Huateng.gd.Ocean's Fourteen.DWMNTH2CJFLCWL";

	/**
	 * add by NT 2007-09-18 为兼容交行个贷用户权限管理及登录的配置文件，同交行个贷的bocompl.properties文件。
	 * 现在使用的是BocomplJAR.jar包中的SystemConstant.java
	 */
	public static final String CONFFILENAME = "gd";

	/**
	 * add by NT 2007-09-29 来源于交行个贷 缺省用户密码明文
	 */
	public static final String DEFAULT_PASSWORD = "111111";

	/**
	 * add by NT 2007-09-20 来源于交行个贷 用户密码错误次数
	 */
	public static final int ERR_PWD_TIMES_CONTINUE = 3;

	public static final int ERR_PWD_TIMES_SUM = 6;

	/**
	 * add by NT 2007-09-20 来源于交行个贷 柜员状态
	 */
	public static final String TLR_NO_STATE_LOGOUT = "0"; // 签退

	public static final String TLR_NO_STATE_LOGIN = "1"; // 签到

	public static final String TLR_NO_STATE_QUIT = "2"; // 离职

	/**
	 * add by NT 2007-09-28 日期格式
	 */
	public static final String FULLTIME_PATTERN = "yyyy-MM-dd.HH.mm.ss.SSS";

	public static final String OUT_USER_SESSION_INFO = "USER_SESSION_INFO";

	public static final String ERRORS_MSG_KEY = "errors.message";

	// 转逾/转非应计
	public static final String LOAN_TO_OVERDUE = "1"; // 转逾
	public static final String LOAN_TO_IDLE = "2"; // 转非应计

	// 登记档案（权利品）操作流水
	public static final String OPRTYPE_DOC = "1"; // 档案
	public static final String OPRTYPE_GUA = "2"; // 权利品

	// 权利品类型
	public static final String GUARANTEETYPE_MORT = "1"; // 抵押
	public static final String GUARANTEETYPE_IMPAWN = "2"; // 质押

	// 权利品出借状态
	public static final String LENDSTATE_YES = "1"; // 已出借
	public static final String LENDSTATE_NO = "0"; // 未出借

	public static final String CONTEXT_BIZ_LOG_MISC = "biz_log_misc"; // 用于记录流水的上下文键值

	/**
	 * 审批意见退回标志
	 */
	public static final String APPLYDTL_UNTREAD_NO = "0"; // 未退回
	public static final String APPLYDTL_UNTREAD_YES = "1"; // 已退回
	public static final String APPLYDTL_UNTREAD_LAST = "2"; // 最近一次退回

	// add by zsy
	public static final Integer STATIC_ID = new Integer(0);// 默认的ID用来初始化部分表中的ID

	/**
	 * Yes or No
	 */
	public static final String VALUE_FLAG_YES = "Y";// YES
	public static final String VALUE_FLAG_NO = "N";// NO

	/**
	 * 顺延方式 add by znh
	 */
	public static final String DELAY_VALUE_FLAG_YES = "Y";// YES
	public static final String DELAY_VALUE_FLAG_NO = "N";// NO
	public static final String DELAY_VALUE_FLAG_CUST = "C";// 用户自定义
	public static final String DELAY_VALUE_FLAG_CUST_IN = "A";// 用户手工设置

	/**
	 * 企业客户属性 add by fan_rong
	 */
	public static final String ATTR_TYPE_CLASS = "1";// 企业性质
	public static final String ATTR_TYPE_CREDITLEVEL = "2";// 信用等级
	public static final String ATTR_TYPE_SCALE = "3";// 企业规模
	public static final String ATTR_TYPE_TRADE_TYPE = "4";// 企业行业

	/**
	 * 到期相关提交标志 add by weisuling
	 */
	public static final String EXPIRE_UNSUBMITTED = "0";// 未提交
	public static final String EXPIRE_SUBMITTED = "1";// 已提交

	/**
	 * 票据-是否可转让-end_or_sement_mk <br>
	 * EM00-可再转让 <br>
	 * EM01-不得转让
	 */
	public static final String DRAFT_END_OR_SEMENT_MK_CAN = "EM00"; // EM00-可再转让
	public static final String DRAFT_END_OR_SEMENT_MK_CANNOT = "EM01"; // EM01-不得转让

	/**
	 * 票据承兑处理状态
	 *
	 */
	public static final String DRAFT_IN = "00"; // 录入中
	public static final String DRAFT_OUT = "01"; // 已出票
	public static final String DRAFT_ALREADY = "02"; // 已承兑
	public static final String DRAFT_REFUSE = "03"; // 已拒绝承兑

	/**
	 * 挂失状态
	 */
	public static final String LOSS_STATUS_NO = "00"; // 未挂失
	public static final String LOSS_STATUS_CANCEL = "01"; // 已挂失

	/** 默认成功状态 0000 */
	public static final String DEFAULT_SUCESS = "0000"; // 默认成功状态

	/** 默认不限业务种类 0000 */
	public static final String DEFAULT_BUSSTYPE = "0000"; // 默认不限业务种类

	// 票据表角色来源
	public static final String SRC_TYPE_01 = "01";// 承兑
	public static final String SRC_TYPE_02 = "02";// 贴现买入
	public static final String SRC_TYPE_03 = "03";// 转贴现买入
	public static final String SRC_TYPE_04 = "04";// 票据保管
	public static final String SRC_TYPE_05 = "05";// 我行提供保证
	public static final String SRC_TYPE_06 = "06";// 我行是质权人

	// 发出托收明细操作状态
	// public static final String SEND_COLLECTION_DEATILS_STATUS_1 = "1";//1-未托收
	// public static final String SEND_COLLECTION_DEATILS_STATUS_2 = "2";//2-已托收
	// public static final String SEND_COLLECTION_DEATILS_STATUS_3 =
	// "3";//3-已托收记账
	// public static final String SEND_COLLECTION_DEATILS_STATUS_4 =
	// "4";//4-托收退回

	/**
	 * 发出托收明细状态
	 */
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_NON_SEND = "00";// 00-未发出提示付款申请
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_SENDING = "11";// 11-发出提示付款申请通讯中
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_CM_ERROR = "21";// 21-发出提示付款申请通讯失败
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_CM_SUCCESS = "12";// 12-发出提示付款申请通讯成功
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_ECDS_RECEIVE_SUCCESS = "31";// 31-发出提示付款申请已确认成功
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_ECDS_RECEIVE_ERROR = "22";// 22-发出提示付款申请已确认失败
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_WITHDRAWN_SENDING = "13";// 13-发出提示付款撤回申请通讯中
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_WITHDRAWN_CM_ERROR = "23";// 23-发出提示付款撤回申请通讯失败
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_WITHDRAWN_CM_SUCCESS = "14";// 14-发出提示付款撤回申请通讯成功
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_WITHDRAWN_ECDS_RECEIVE_SUCCESS = "91";// 91-发出提示付款撤回已确认成功
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_WITHDRAWN_ECDS_RECEIVE_ERROR = "24";// 24-发出提示付款撤回已确认失败
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_THE_OTHER_SIGNED = "32";// 32-发出提示付款申请对方已签收
	public static final String SEND_COLLECTION_DEATILS_PROMPT_STATUS_ALL_SUCCESSED = "90";// 90-提示付款申请已交易成功(记账)

	// 退票批次明细-退票状态
	public static final String RETURNED_DETAILS_1 = "1";// 1-未退票
	public static final String RETURNED_DETAILS_2 = "2";// 2-已退票
	public static final String RETURNED_DETAILS_3 = "3";// 3-已退票

	/**
	 * 数据字典项类型
	 */
	public static final int DATADIC_TYPE_DRAFT_TYPE = 16;// 票据类型 银票或商票
	public static final int DATADIC_TYPE_INTRATE_TYPE = 17;// 利率类型
	public static final int DATADIC_TYPE_RESELL_TYPE = 25;// 转卖类型
	public static final int DATA_TYPE_NO_DRAFT_CLASS = 26;// 票据级别字典
	/** add by liyi 0820 BMS-1575 begin*/
	public static final int DATADIC_TYPE_STTLMMK_TYPE = 40;// 线上清算标志字典
	/** add by liyi 0820 BMS-1575 end*/
	public static final int DATADIC_TYPE_EXPIRE_STATUS = 46;// 到期处理状态
	public static final int DATADIC_TYPE_ACCOUNT_STATUS = 48;// 记账状态
	public static final int DATADIC_TYPE_DRAFT_STATUS = 51;// 票据状态字典
	public static final int DATADIC_TYPE_ECDS_DRAFT_TYPE = 52;// 人行票据种类AC01-银票AC02-商票
	public static final int DATADIC_TYPE_BUY_DRAFT_TYPE = 60; // 人行票据种类AC01-银承AC02-商承
	public static final int DATADIC_TYPE_RCRS_TP = 65; // 追索类型

	public static final int DATADIC_TYPE_COLLZTN_STATUS = 66; // 质押状态
	public static final int DATADIC_TYPE_DRAFT_TMP_STATUS = 67; // 票据处理中状态
	public static final int DATADIC_TYPE_DRAFT_SRC_TYPE = 68; // 客户类型
	public static final int DATADIC_TYPE_DRAFT_DFCLS_CTL = 69; // 票据级别控制标志
	public static final int DATADIC_TYPE_CUST_TYPE = 70; // 客户类型
	public static final int DATADIC_TYPE_RECOURSE_STATUS = 71; // 发出追索明细状态
	public static final int DATADIC_TYPE_SWT_CM_STATUS = 72; // SWT通讯状态
	public static final int DATADIC_TYPE_COLLZTN_DETAILS_COLLZTN_STATUS = 73;// 收到质押申请明细状态
	public static final int DATADIC_TYPE_RECEIVE_RECOURSE_STATUS = 74;// 质押登记簿状态
	public static final int DATADIC_TYPE_RECEIVE_RECOURSE_DETAILS_RECEIVE_STATUS = 75;// 收到追索明细状态
	public static final int DATADIC_TYPE_RECEIVE_RECOURSE_DETAILS_SEND_AGREEAP_STATUS = 76;// 发出同意清偿状态
	public static final int DATADIC_TYPE_QTGINF_BIZ_TYPE = 80;// 公开报价业务类型
	public static final int DATADIC_TYPE_QTGINF_DFTPYE = 81;// 公开报价票据类型
	public static final int DATADIC_TYPE_QTGINF_TYPE = 82;// 报价方式
	public static final int DATADIC_TYPE_ENTITY_REGISTER_SEND_STATUS = 83;// 纸票登记发送状态
	public static final int DATADIC_TYPE_BUSINESS_TASK_REMIND_BIZ = 86;// 业务提醒业务大类
	public static final int DATADIC_TYPE_BUSINESS_TASK_REMIND_SUB_BIZ = 87;// 业务提醒业务小类

	/**
	 * 票据级别
	 */
	public static final String DRAFT_CLASS_A = "1"; // A类票据
	public static final String DRAFT_CLASS_B = "2"; // B类票据
	public static final String DRAFT_CLASS_C = "3"; // C类票据
	public static final String DRAFT_CLASS_1 = "A"; // A类票据
	public static final String DRAFT_CLASS_2 = "B"; // B类票据
	public static final String DRAFT_CLASS_3 = "C"; // C类票据

	/** 冲正业务类型 */
	public static final String TASK_ACTION_TYPE_ADL1 = "ADL1";// 承兑到期解付记账
	public static final String TASK_ACTION_TYPE_BVL1 = "BVL1";// 空白凭证记账
	public static final String TASK_ACTION_TYPE_BLA1 = "BLA1";// 买入放款记账
	public static final String TASK_ACTION_TYPE_BLB1 = "BLB1";// 买入返售到期记账
	public static final String TASK_ACTION_TYPE_CAL1 = "CAL1 ";// 承兑记账
	public static final String TASK_ACTION_TYPE_CBL1 = "CBL1 ";// 签发出票记账
	public static final String TASK_ACTION_TYPE_CRA1 = "CRA1 ";// 收回款项记账
	public static final String TASK_ACTION_TYPE_CRA2 = "CRA2 ";// 托收退票记账
	public static final String TASK_ACTION_TYPE_CRL1 = "CRL1 ";// 解除挂失止付记账
	public static final String TASK_ACTION_TYPE_RAL1 = "RAL1 ";// 未用退回记账
	public static final String TASK_ACTION_TYPE_RLA1 = "RLA1 ";// 未用退回记账
	public static final String TASK_ACTION_TYPE_SCL1 = "SCL1 ";// 收回款项记账
	public static final String TASK_ACTION_TYPE_SLA1 = "SLA1 ";// 卖出记账
	public static final String TASK_ACTION_TYPE_SLB1 = "SLB1 ";// 卖出回购到期记账

	/**
	 * 顺延方式
	 */
	public static final String DELAYTYPE_1 = "1";// 系统自动调整顺延天数
	public static final String DELAYTYPE_2 = "2";// 用户手工调整顺延天数
	public static final String DELAYTYPE_3 = "3";// 用户自由指定顺延天数

	/**
	 * 实物票据登记交易类型
	 */
	public static final String ENTITY_REGISTER_TXTYPE_REGISTER = "1";// 1-登记类
	public static final String ENTITY_REGISTER_TXTYPE_RESULT = "2"; // 2-人行返回查询结果类
	public static final String ENTITY_REGISTER_TXTYPE_QUREY = "3"; // 3-信息查询(向人行查询)
	public static final String ENTITY_REGISTER_TXTYPE_QRY_RESULT = "4"; // 4-人行返回历史查询类

	//--------------------modified by HuangWeijing 20090901 jira:BMS-1716 begin---------------------------
	/**
	 * 登记状态
	 */
	public static final String ENTITY_REGISTER_SEND_STATUS_NONE = "0"; // 未发送
	public static final String ENTITY_REGISTER_SEND_STATUS_SUSCCESS = "1"; // 成功应答
	public static final String ENTITY_REGISTER_SEND_STATUS_FAIL = "2"; // 发送失败
	public static final String ENTITY_REGISTER_SEND_STATUS_CANCEL = "3"; // 作废成功
	public static final String ENTITY_REGISTER_SEND_STATUS_SEND_MOD = "4"; // 发送成功后又修改
	public static final String ENTITY_REGISTER_SEND_STATUS_ALL = "5"; // 全选
	public static final String ENTITY_REGISTER_SEND_STATUS_TIMEOUT = "6"; // 应答超时
	public static final String ENTITY_REGISTER_SEND_STATUS_REPLYFAILURE = "7"; // 失败应答
	public static final String ENTITY_REGISTER_SEND_STATUS_SENDING = "8"; //发送中
	//--------------------modified by HuangWeijing 20090901 jira:BMS-1716 end-----------------------------

	/**
	 * 承兑到期兑付表-审批状态
	 */
	public static final String APPSTATUS_NOT_SUBMIT = "00"; // 已接收未提交
	public static final String APPSTATUS_HAS_SUBMIT = "01"; // 受理已提交
	public static final String APPSTATUS_HAS_ACCOUNT = "02"; // 已记账

	/**
	 * 利率类型 weikun.wang 09.5.14
	 */
	public static final String RATE_TYPE_1 = "1";// 年息
	public static final String RATE_TYPE_2 = "2";// 月息
	public static final String RATE_TYPE_3 = "3";// 日息
	/**
	 * 买入类型 weikun.wang 09.5.14
	 */
	public static final String BUY_TYPE_01 = "01";// 买入
	public static final String BUY_TYPE_02 = "02";// 回购式业务到期

	/**
	 * 转卖明细表-卖出类型 <br>
	 * 01-卖出 <br>
	 * 02-回购式业务到期
	 */
	public static final String SELL_TYPE_01 = "01"; // 卖出
	public static final String SELL_TYPE_02 = "02"; // 回购式业务到期

	/**
	 * 转卖明细表-通讯状态-CM_STATUS <br>
	 * 01-未发送SWT <br>
	 * 02-已成功发送SWT <br>
	 * 03-发送SWT通讯失败 <br>
	 * 04-发送SWT业务失败
	 */
	public static final String RESELL_DETAILS_CM_STATUS_01 = "01";
	public static final String RESELL_DETAILS_CM_STATUS_02 = "02";
	public static final String RESELL_DETAILS_CM_STATUS_03 = "03";
	public static final String RESELL_DETAILS_CM_STATUS_04 = "04";

	/**
	 * 转卖明细表-签收意见-SIG_MK <br>
	 * SU00-同意签收 <br>
	 * SU01-拒绝签收
	 */
	public static final String RESELL_DETAILS_SIG_MK_SU00 = "SU00";
	public static final String RESELL_DETAILS_SIG_MK_SU01 = "SU01";

	/**
	 * 转卖明细表-卖出明细状态-SELL_STATUS <br>
	 * 00-卖出时未发出卖出申请 <br>
	 * 11-卖出时卖出申请通讯中 <br>
	 * 21-卖出时卖出申请通讯失败 <br>
	 * 12-卖出时卖出申请通讯成功 <br>
	 * 31-卖出时卖出申请已确认成功 <br>
	 * 22-卖出时卖出申请已确认失败 <br>
	 * 13-卖出时撤回申请通讯中 <br>
	 * 23-卖出时撤回申请通讯失败 <br>
	 * 14-卖出时撤回申请通讯成功 <br>
	 * 91-卖出时撤回已确认成功 <br>
	 * 24-卖出时撤回已确认失败 <br>
	 * 32-卖出时对方已签收 <br>
	 * 90-卖出时已交易成功(记账)<br>
	 * 25-线上清算失败<br>
	 * 26-清分失败回复<br>
	 * 27-已状态变更(收到040状态变更通知)<br>
	 * 28-已结清(收到043结清通知)<br>
	 */
	public static final String RESELL_DETAILS_SELL_STATUS_00 = "00";
	public static final String RESELL_DETAILS_SELL_STATUS_11 = "11";
	public static final String RESELL_DETAILS_SELL_STATUS_21 = "21";
	public static final String RESELL_DETAILS_SELL_STATUS_12 = "12";
	public static final String RESELL_DETAILS_SELL_STATUS_31 = "31";
	public static final String RESELL_DETAILS_SELL_STATUS_22 = "22";
	public static final String RESELL_DETAILS_SELL_STATUS_13 = "13";
	public static final String RESELL_DETAILS_SELL_STATUS_23 = "23";
	public static final String RESELL_DETAILS_SELL_STATUS_14 = "14";
	public static final String RESELL_DETAILS_SELL_STATUS_91 = "91";
	public static final String RESELL_DETAILS_SELL_STATUS_24 = "24";
	public static final String RESELL_DETAILS_SELL_STATUS_32 = "32";
	public static final String RESELL_DETAILS_SELL_STATUS_90 = "90";
	public static final String RESELL_DETAILS_SELL_STATUS_25 = "25";
	public static final String RESELL_DETAILS_SELL_STATUS_26 = "26";
	public static final String RESELL_DETAILS_SELL_STATUS_27 = "27";
	public static final String RESELL_DETAILS_SELL_STATUS_28 = "28";

	/**
	 * 发出追索明细状态 SEND_RECOURSE_DETAILS.RECOURSE_STATUS
	 */
	public static final String RECOURSE_STATUS_NON_SEND = "00";// 00-追索时未发出追索通知
	public static final String RECOURSE_STATUS_SENDING = "11";// 11-追索时追索通知通讯中
	public static final String RECOURSE_STATUS_CM_ERROR = "21";// 21-追索时追索通知通讯失败
	public static final String RECOURSE_STATUS_CM_SUCCESS = "12";// 12-追索时追索通知通讯成功
	public static final String RECOURSE_STATUS_ECDS_RECEIVE_SUCCESS = "31";// 31-追索时追索已通知确认成功
	public static final String RECOURSE_STATUS_ECDS_RECEIVE_ERROR = "22";// 22-追索时追索已通知确认失败
	public static final String RECOURSE_STATUS_BACK_SENDING = "13";// 13-追索时撤回申请通讯中
	public static final String RECOURSE_STATUS_BACK_CM_ERROR = "23";// 23-追索时撤回申请通讯失败
	public static final String RECOURSE_STATUS_BACK_CM_SUCCESS = "14";// 14-追索时撤回申请通讯成功
	public static final String RECOURSE_STATUS_ECDS_BACK_RECEIVE_SUCCESS = "91";// 91-追索时撤回已确认成功
	public static final String RECOURSE_STATUS_ECDS_BACK_RECEIVE_ERROR = "24";// 24-追索时撤回已确认失败
	public static final String RECOURSE_STATUS_ECDS_WITHDRAWN_THE_OTHER_SIGNED = "32";// 32-追索时对方已签收
	public static final String RECOURSE_STATUS_TRADE_SUCCESS = "90";// 90-追索时已交易成功

	/**
	 * 发出同意清偿状态 SEND_AGREEAP_STATUS
	 */
	public static final String SEND_AGREEAP_STATUS_NON_SEND = "00";// 00-未发出同意清偿申请
	public static final String SEND_AGREEAP_STATUS_SENDING = "11";// 11-发出同意清偿申请通讯中
	public static final String SEND_AGREEAP_STATUS_CM_ERROR = "21";// 21-发出同意清偿申请通讯失败
	public static final String SEND_AGREEAP_STATUS_CM_SUCCESS = "12";// 12-发出同意清偿申请通讯成功
	public static final String SEND_AGREEAP_STATUS_ECDS_RECEIVE_ERROR = "22";// 22-发出同意清偿申请已确认失败
	public static final String SEND_AGREEAP_STATUS_ECDS_RECEIVE_SUCCESS = "31";// 31-发出同意清偿申请已确认成功
	public static final String SEND_AGREEAP_STATUS_ECDS_WITHDRAWN_SENDING = "13";// 13-发出同意清偿撤回申请通讯中
	public static final String SEND_AGREEAP_STATUS_ECDS_WITHDRAWN_CM_ERROR = "23";// 23-发出同意清偿撤回申请通讯失败
	public static final String SEND_AGREEAP_STATUS_ECDS_WITHDRAWN_CM_SUCCESS = "14";// 14-发出同意清偿撤回申请通讯成功
	public static final String SEND_AGREEAP_STATUS_ECDS_WITHDRAWN_RECEIVE_SUCCESS = "91";// 91-发出同意清偿撤回已确认成功
	public static final String SEND_AGREEAP_STATUS_ECDS_WITHDRAWN_RECEIVE_ERROR = "24";// 24-发出同意清偿撤回已确认失败
	public static final String SEND_AGREEAP_STATUS_ECDS_WITHDRAWN_THE_OTHER_SIGNED = "32";// 32-发出同意清偿对方已签收

	/**
	 * 追索处理状态 RECEIVE_RECOURSE_DETAILS.RECEIVE_STATUS
	 */
	public static final String RECEIVE_RECOURSE_RECEIVE_STATUS_NOT_PROC = "00";// 00-收到追索未处理
	public static final String RECEIVE_RECOURSE_RECEIVE_STATUS_HAS_PROC = "31";// 31-收到追索已处理
	public static final String RECEIVE_RECOURSE_RECEIVE_STATUS_OTHER_HAS_PROC = "92";// 92-他人已清偿
	public static final String RECEIVE_RECOURSE_RECEIVE_STATUS_HAS_CANCEL = "91";// 91-追索已撤回

	/**
	 * 收到同意清偿明细状态 RECEIVE_RECOURSE_DETAILS
	 */
	public static final String RECEIVE_AGREEAP_STATUS_NON_SEND = "00";// 00-追索同意清偿签收未处理
	public static final String RECEIVE_AGREEAP_STATUS_SENDING = "11";// 11-追索同意清偿签收通讯中
	public static final String RECEIVE_AGREEAP_STATUS_CM_ERROR = "21";// 21-追索同意清偿签收通讯失败
	public static final String RECEIVE_AGREEAP_STATUS_CM_SUCCESS = "12";// 12-追索同意清偿签收通讯成功
	public static final String RECEIVE_AGREEAP_STATUS_ECDS_RECEIVE_ERROR = "22";// 22-追索同意清偿签收已确认失败
	public static final String RECEIVE_AGREEAP_STATUS_ECDS_RECEIVE_SUCCESS = "31";// 31-追索同意清偿签收已确认成功

	/**
	 * 同意清偿意见
	 */
	public static final String RECEIVE_RECOURSE_RECEIVE_AP_SIG_MK_AGREE = "1";// 同意
	public static final String RECEIVE_RECOURSE_RECEIVE_AP_SIG_MK_REFUSE = "0";// 拒绝

	/**
	 * 转卖协议表-审核状态-AUDIT_STATUS <br>
	 * 0-未审核（默认） <br>
	 * 1-提交审核(未用) <br>
	 * 2-审核中 <br>
	 * 3-审核成功 <br>
	 * 4-审核失败 <br>
	 * 5-撤销提交 <br>
	 * 6-部分提交
	 */
	public static final String RESLL_CONTRACT_AUDIT_STATUS_0 = "0";
	public static final String RESLL_CONTRACT_AUDIT_STATUS_1 = "1";
	public static final String RESLL_CONTRACT_AUDIT_STATUS_2 = "2";
	public static final String RESLL_CONTRACT_AUDIT_STATUS_3 = "3";
	public static final String RESLL_CONTRACT_AUDIT_STATUS_4 = "4";
	public static final String RESLL_CONTRACT_AUDIT_STATUS_5 = "5";
	public static final String RESLL_CONTRACT_AUDIT_STATUS_6 = "6";

	/**
	 * 买入明细状态 <br>
	 * 00-买入时我方未签收 91-买入时对方已撤回申请 11-买入时签收通讯中 21-买入时签收通讯失败 12-买入时签收通讯成功
	 * 31-买入时签收已确认成功 22-买入时签收已确认失败 90-买入时已交易成功(记账) 25-线上清算失败 26-清分失败回复
	 * 27-已状态变更(收到040状态变更通知) 28-已结清(收到043结清通知)
	 */
	public static final String BUY_DETAIL_STATUS_00 = "00";
	public static final String BUY_DETAIL_STATUS_91 = "91";
	public static final String BUY_DETAIL_STATUS_11 = "11";
	public static final String BUY_DETAIL_STATUS_21 = "21";
	public static final String BUY_DETAIL_STATUS_12 = "12";
	public static final String BUY_DETAIL_STATUS_31 = "31";
	public static final String BUY_DETAIL_STATUS_22 = "22";
	public static final String BUY_DETAIL_STATUS_90 = "90";
	public static final String BUY_DETAIL_STATUS_25 = "25";
	public static final String BUY_DETAIL_STATUS_26 = "26";
	public static final String BUY_DETAIL_STATUS_27 = "27";
	public static final String BUY_DETAIL_STATUS_28 = "28";

	// ////tmp add
	public static final String EXPIRE_PROCESS_OVER = "00"; // 新增未提交
	public static final String EXPIRE_KEEP_ACCOUNTS = "01";// 审批中
	public static final String EXPIRE_KEEP_FAIL = "02";// 审批已拒绝
	public static final String EXPIRE_UNDER_PROCESS = "03";// 审批已通过
	public static final String EXPIRE_UNTHREAD = "04";// 驳回对方申请
	public static final String NO_STORAGE = "";
	public static final String STORAGE_IN = "";
	public static final String STORAGE_OUT = "";

	/**
	 * 电子票据用-承兑明细处理状态 <br>
	 * 00-承兑时我方未签收 <br>
	 * 91-承兑时对方已撤回申请 <br>
	 * 11-承兑时签收通讯中 <br>
	 * 21-承兑时签收通讯失败 <br>
	 * 12-承兑时签收通讯成功 <br>
	 * 31-承兑时签收已确认成功 <br>
	 * 22-承兑时签收已确认失败 <br>
	 * 90-承兑时已交易成功(记账) <br>
	 * 92-承兑已撤票
	 * 25-线上清算失败
	 * 26-清分失败回复
	 * 27-已状态变更(收到040状态变更通知)
	 * 28-已结清(收到043结清通知)
	 */
	public static final String ELC_ACCEPT_STATUS_00 = "00";
	public static final String ELC_ACCEPT_STATUS_91 = "91";
	public static final String ELC_ACCEPT_STATUS_11 = "11";
	public static final String ELC_ACCEPT_STATUS_21 = "21";
	public static final String ELC_ACCEPT_STATUS_12 = "12";
	public static final String ELC_ACCEPT_STATUS_31 = "31";
	public static final String ELC_ACCEPT_STATUS_22 = "22";
	public static final String ELC_ACCEPT_STATUS_90 = "90";
	public static final String ELC_ACCEPT_STATUS_92 = "92";
	public static final String ELC_ACCEPT_STATUS_25 = "25";
	public static final String ELC_ACCEPT_STATUS_26 = "26";
	public static final String ELC_ACCEPT_STATUS_27 = "27";
	public static final String ELC_ACCEPT_STATUS_28 = "28";

	/**
	 * 电子票据用-签收意见 SU00-同意签收 SU01-拒绝签收
	 */
	public static final String SIG_MK_SU00 = "SU00";
	public static final String SIG_MK_SU01 = "SU01";

	/**
	 * 任务池 申请状态-ECDS APPLY_STATUS 01-已申请我方未回复 02-申请已撤回 03-我方已回复
	 * 04-清分失败 05-清算失败 06-已状态变更(收到040状态变更通知) 07-已结清(收到043结清通知)
	 */
	public static final String ECDS_APPLY_STATUS_01 = "01";
	public static final String ECDS_APPLY_STATUS_02 = "02";
	public static final String ECDS_APPLY_STATUS_03 = "03";
	public static final String ECDS_APPLY_STATUS_04 = "04";
	public static final String ECDS_APPLY_STATUS_05 = "05";
	public static final String ECDS_APPLY_STATUS_06 = "06";
	public static final String ECDS_APPLY_STATUS_07 = "07";

	/**
	 * 网银业务类型
	 */
	public static final String EBANK_BUSITYPE_01 = "01";// 出票信息登记
	public static final String EBANK_BUSITYPE_02 = "02";// 出票人提示保?
	public static final String EBANK_BUSITYPE_03 = "03";// 出票人提示承?
	public static final String EBANK_BUSITYPE_04 = "04";// 承兑人提示保?
	public static final String EBANK_BUSITYPE_05 = "05";// 出票人提示收?
	public static final String EBANK_BUSITYPE_06 = "06";// 撤票
	public static final String EBANK_BUSITYPE_07 = "07";// 背书转让业务
	public static final String EBANK_BUSITYPE_08 = "08";// 贴现业务
	public static final String EBANK_BUSITYPE_09 = "09";// 回购式贴现赎?
	public static final String EBANK_BUSITYPE_10 = "10";// 转贴现业务
	public static final String EBANK_BUSITYPE_11 = "11";// 回购式转贴现?
	public static final String EBANK_BUSITYPE_12 = "12";// 再贴现业务
	public static final String EBANK_BUSITYPE_13 = "13";// 回购式再贴现?
	public static final String EBANK_BUSITYPE_14 = "14";// 质押业务
	public static final String EBANK_BUSITYPE_15 = "15";// 解除质押
	public static final String EBANK_BUSITYPE_16 = "16";// 背书保证业务
	public static final String EBANK_BUSITYPE_17 = "17";// 提示付款业务
	public static final String EBANK_BUSITYPE_18 = "18";// 逾期提示付款?
	public static final String EBANK_BUSITYPE_19 = "19";// 拒付追索
	public static final String EBANK_BUSITYPE_20 = "20";// 非拒付追索
	public static final String EBANK_BUSITYPE_21 = "21";// 追索同意清偿

	/**
	 * 网银交易状态
	 */
	public static final String EBANK_TRADE_OPERATE_0 = "0";// 可操作
	public static final String EBANK_TRADE_OPERATE_1 = "1";// 正在操作
	public static final String EBANK_TRADE_OPERATE_2 = "2";// 已完成

	public static final String EBANK_TRADE_SEND = "01";// 发起方
	public static final String EBANK_TRADE_RECEIVE = "02";// 接收方

	/**
	 * 发出托收明细状态 <br>
	 * 00-未发出提示付款申请 <br>
	 * 11-发出提示付款申请通讯中 <br>
	 * 21-发出提示付款申请通讯失败 <br>
	 * 12-发出提示付款申请通讯成功 <br>
	 * 31-发出提示付款申请已确认成功 <br>
	 * 22-发出提示付款申请已确认失败 <br>
	 * 13-发出提示付款撤回申请通讯中 <br>
	 * 23-发出提示付款撤回申请通讯失败 <br>
	 * 14-发出提示付款撤回申请通讯成功 <br>
	 * 91-发出提示付款撤回已确认成功 <br>
	 * 24-发出提示付款撤回已确认失败 <br>
	 * 32-发出提示付款申请对方已签收 <br>
	 * 90-提示付款申请已交易成功(记账)
	 */
	public static final String PROMPT_STATUS_00 = "00";
	public static final String PROMPT_STATUS_11 = "11";
	public static final String PROMPT_STATUS_21 = "21";
	public static final String PROMPT_STATUS_12 = "12";
	public static final String PROMPT_STATUS_31 = "31";
	public static final String PROMPT_STATUS_22 = "22";
	public static final String PROMPT_STATUS_13 = "13";
	public static final String PROMPT_STATUS_23 = "23";
	public static final String PROMPT_STATUS_14 = "14";
	public static final String PROMPT_STATUS_91 = "91";
	public static final String PROMPT_STATUS_24 = "24";
	public static final String PROMPT_STATUS_32 = "32";
	public static final String PROMPT_STATUS_90 = "90";

	/**
	 * 审核状态 <br>
	 * 0-未审核（默认） <br>
	 * 1-提交审核(未用) <br>
	 * 2-审核中 <br>
	 * 3-审核成功 <br>
	 * 4-审核失败
	 */
	public static final String AUDIT_STATUS_0 = "0";
	public static final String AUDIT_STATUS_1 = "1";
	public static final String AUDIT_STATUS_2 = "2";
	public static final String AUDIT_STATUS_3 = "3";
	public static final String AUDIT_STATUS_4 = "4";

	/**
	 * 网银交易代码
	 */
	public static final String EBANK_TRADECODE_202101 = "202101"; // 出票登记交易
	public static final String EBANK_TRADECODE_202102 = "202102"; // 提示承兑交易
	public static final String EBANK_TRADECODE_202103 = "202103"; // 提示收票交易
	public static final String EBANK_TRADECODE_202001 = "202001"; // 撤消交易
	public static final String EBANK_TRADECODE_202002 = "202002"; // 通用签收
	public static final String EBANK_TRADECODE_202203 = "202203"; // 贴现预申请
	public static final String EBANK_TRADECODE_202201 = "202201"; // (转/再)贴现申请
	public static final String EBANK_TRADECODE_202501 = "202501"; // 质押请求
	public static final String EBANK_TRADECODE_202502 = "202502"; // 解除质押请求
	public static final String EBANK_TRADECODE_202104 = "202104"; // 撤票
	public static final String EBANK_TRADECODE_202301 = "202301"; // 背书
	public static final String EBANK_TRADECODE_202401 = "202401"; // 保证
	public static final String EBANK_TRADECODE_202601 = "202601"; // 提示付款
	public static final String EBANK_TRADECODE_202901 = "202901"; // 追索通知
	public static final String EBANK_TRADECODE_202902 = "202902"; // 同意清偿
	public static final String EBANK_TRADECODE_205901 = "205901"; // 可追索人查询
	public static final String EBANK_TRADECODE_205003 = "205003"; // 单笔流水查询
	public static final String EBANK_TRADECODE_205004 = "205004"; // 票据历史交易信息查询

	/**
	 * 承兑到期兑付表ACCEPT_DUE_PAY 发出签收明细状态ACPAY_STATUS
	 */
	public static final String ACPAY_STATUS_NOT_SIGN = "00";// 00-到期付款时我方未签收
	public static final String ACPAY_STATUS_WITHDRAWN = "91";// 91-到期付款时对方已撤回申请
	public static final String ACPAY_STATUS_SIGN_COMM_ING = "11";// 11-到期付款时签收通讯中
	public static final String ACPAY_STATUS_SIGN_COMM_ERR = "21";// 21-到期付款时签收通讯失败
	public static final String ACPAY_STATUS_SIGN_COMM_SUCCESS = "12";// 12-到期付款时签收通讯成功
	public static final String ACPAY_STATUS_SIGN_SUCCESS = "31";// 31-到期付款时签收已确认成功
	public static final String ACPAY_STATUS_SIGN_ERROR = "22";// 22-到期付款时签收已确认失败
	public static final String ACPAY_STATUS_PAY_SUCCESS = "90";// 90-到期付款已交易成功(记账)

	/**
	 * 提示付款报文种类：MESG_TYPE
	 */
	public static final String COLLECTION_MESG_TYPE_020 = "020"; // 020-提示付款申请
	public static final String COLLECTION_MESG_TYPE_021 = "021"; // 021-逾期提示付款申请

	/**
	 * 提示付款人类别：DRFT_HLDR_ROLE
	 */
	public static final String DRFT_HLDR_ROLE_RC00 = "RC00"; // RC00-接入行行
	public static final String DRFT_HLDR_ROLE_RC01 = "RC01"; // RC01-企业
	public static final String DRFT_HLDR_ROLE_RC02 = "RC02"; // RC02-人民银行
	public static final String DRFT_HLDR_ROLE_RC03 = "RC03"; // RC03-被代理行
	public static final String DRFT_HLDR_ROLE_RC04 = "RC04"; // RC04-被代理财务公司
	public static final String DRFT_HLDR_ROLE_RC05 = "RC05"; // RC05-接入财务公司

	/**
	 * 通讯状态：CM_STATUS
	 */
	public static final String CM_STATUS_01 = "01"; // 01-未发送SWT
	public static final String CM_STATUS_02 = "02"; // 02-已成功发送SWT
	public static final String CM_STATUS_03 = "03"; // 03-发送SWT通讯失败
	public static final String CM_STATUS_04 = "04"; // 04-发送SWT业务失败

	/**
	 * 记账状态：ACCOUNT_STATUS
	 */
	public static final String ACCOUNT_STATUS_0 = "0"; // 0-未记账
	public static final String ACCOUNT_STATUS_1 = "1"; // 1-记账中
	public static final String ACCOUNT_STATUS_2 = "2"; // 2-记账成功
	public static final String ACCOUNT_STATUS_3 = "3"; // 3-记账失败

	/**
	 * 追索类型
	 */
	public static final String RCRS_TP_REFUSED_TO_PAY = "RT00";// RT00拒付追索
	public static final String RCRS_TP_NON_REFUSED_TO_PAY = "RT01";// RT01非拒付追索

	/**
	 * 截留模式
	 */
	public static final String TASK_TYPE_NORMAL = "00";// 00-非截留模式
	public static final String TASK_TYPE_CUT = "01";// 01-截留模式

	/**
	 * 公开报价审批模式
	 */
	public static final String PUBLIC_PRICE_APPSTATUS_HASNOT_SUBMIT = "0";// 0-未提交
	public static final String PUBLIC_PRICE_APPSTATUS_HAS_SUBMIT = "1";// 1-已提交
	public static final String PUBLIC_PRICE_APPSTATUS_HAS_SEND = "2"; // 2-已发送

	public static final String PUBLIC_PRICE_QTSTATUS_NO_SEND = "00";// 初始化 未发送状态
	public static final String PUBLIC_PRICE_QTSTATUS_HAS_SEND = "12";// 发送成功
	public static final String PUBLIC_PRICE_QTSTATUS_FAIL_SEND = "21";// 发送失败
	/**
	 * 质押登记簿状态
	 */
	public static final String COLLZTN_DETAILS_STATUS_00 = "00";// 00-质押办理中
	public static final String COLLZTN_DETAILS_STATUS_01 = "01";// 01-已质押
	public static final String COLLZTN_DETAILS_STATUS_02 = "02";// 02-未质押
	public static final String COLLZTN_DETAILS_STATUS_03 = "03";// 03-解除质押办理中
	public static final String COLLZTN_DETAILS_STATUS_04 = "04";// 04-已解除质押

	/**
	 * 票据质押状态
	 */
	public static final String DRAFT_COLLZTN_STATUS_00 = "00";// 未质押
	public static final String DRAFT_COLLZTN_STATUS_01 = "01";// 已质押
	public static final String DRAFT_COLLZTN_STATUS_02 = "02";// 质押已至票据到期日

	/**
	 * 质押业务类型 票据质押登记簿COLLZTN_DETAILS.COLLZTN_TYPE
	 */
	public static final String COLLZTN_TYPE_COLLZTN_PROPSR = "0";// 0-我行是质权人
	public static final String COLLZTN_TYPE_COLLZTN_BK = "1";// 1-我行是出质人

	/**
	 * 质押申请-明细状态 我行是质权人
	 */
	public static final String COLLZTN_STATUS_00 = "00";// 00-收到质押申请时我方未签收
	public static final String COLLZTN_STATUS_11 = "11";// 11-收到质押申请时签收通讯中
	public static final String COLLZTN_STATUS_12 = "12";// 12-收到质押申请时签收通讯成功
	public static final String COLLZTN_STATUS_21 = "21";// 21-收到质押申请时签收通讯失败
	public static final String COLLZTN_STATUS_22 = "22";// 22-收到质押申请时签收已确认失败
	public static final String COLLZTN_STATUS_31 = "31";// 31-收到质押申请时签收已确认成功
	/**
	 * 质押-质押明细状态 我行是出质人
	 */
	public static final String COLLZTN_STATUS_13 = "13";// 13-申请解除质押时撤回申请通讯中
	public static final String COLLZTN_STATUS_23 = "23";// 23-申请解除质押时撤回申请通讯失败
	public static final String COLLZTN_STATUS_14 = "14";// 14-申请解除质押时撤回申请通讯成功
	public static final String COLLZTN_STATUS_90 = "90";// 90-买入时已交易成功(记账)
	public static final String COLLZTN_STATUS_24 = "24";// 24-申请解除质押时撤回已确认失败
	public static final String COLLZTN_STATUS_32 = "32";// 32-申请解除质押时对方已签收
	public static final String COLLZTN_STATUS_91 = "91";// 91-买入时对方已撤回申请

	/**
	 * 保证-保证明细状态 GURA_STATUS
	 */
	/** 00-买入时我方未签收 */
	public static final String GURA_STATUS_00 = "00";
	/** 91-买入时对方已撤回申请 */
	public static final String GURA_STATUS_91 = "91";
	/** 11-买入时签收通讯中 */
	public static final String GURA_STATUS_11 = "11";
	/** 21-买入时签收通讯失败 */
	public static final String GURA_STATUS_21 = "21";
	/** 12-买入时签收通讯成功 */
	public static final String GURA_STATUS_12 = "12";
	/** 31-买入时签收已确认成功 */
	public static final String GURA_STATUS_31 = "31";
	/** 22-买入时签收已确认失败 */
	public static final String GURA_STATUS_22 = "22";
	/** 90-买入时已交易成功(记账) */
	public static final String GURA_STATUS_90 = "90";
	/** 26-清分失败回复 */
	public static final String GURA_STATUS_26 = "26";
	/** 27-已状态变更(收到040状态变更通知) */
	public static final String GURA_STATUS_27 = "27";
	/** 28-已结清(收到043结清通知) */
	public static final String GURA_STATUS_28 = "28";

	/* add liyi BMS-1496 begin */
	/**
	 * 发出保证明细状态
	 */
	public static final String SEND_GURA_STATUS_NON_SEND = "00";// 00-未发出保证申请
	public static final String SEND_GURA_STATUS_SENDING = "11";// 11-发出保证申请通讯中
	public static final String SEND_GURA_STATUS_CM_ERROR = "21";// 21-发出保证申请通讯失败
	public static final String SEND_GURA_STATUS_CM_SUCCESS = "12";// 12-发出保证申请通讯成功
	public static final String SEND_GURA_STATUS_ECDS_RECEIVE_SUCCESS = "31";// 31-发出保证申请已确认成功
	public static final String SEND_GURA_STATUS_ECDS_RECEIVE_ERROR = "22";// 22-发出保证申请已确认失败
	public static final String SEND_GURA_STATUS_WITHDRAWN_SENDING = "13";// 13-发出保证撤回申请通讯中
	public static final String SEND_GURA_STATUS_WITHDRAWN_CM_ERROR = "23";// 23-发出保证撤回申请通讯失败
	public static final String SEND_GURA_STATUS_WITHDRAWN_CM_SUCCESS = "14";// 14-发出保证撤回申请通讯成功
	public static final String SEND_GURA_STATUS_WITHDRAWN_ECDS_RECEIVE_SUCCESS = "91";// 91-发出保证撤回已确认成功
	public static final String SEND_GURA_STATUS_WITHDRAWN_ECDS_RECEIVE_ERROR = "24";// 24-发出保证撤回已确认失败
	public static final String SEND_GURA_STATUS_THE_OTHER_SIGNED = "32";// 32-发出保证申请对方已签收
	public static final String SEND_GURA_STATUS_ALL_SUCCESSED = "90";// 90-保证申请已交易成功(记账)
	/* add liyi BMS-1496 end */

	/**
	 * 质押-解除质押-明细状态 我行是出质人时 UNCOLLZTN_STATUS
	 * 00-申请解除质押时未发出质押申请
	 * 11-申请解除质押时卖出申请通讯中
	 * 21-申请解除质押时卖出申请通讯失败
	 * 12-申请解除质押时卖出申请通讯成功
	 * 31-申请解除质押时卖出申请已确认成功
	 * 22-申请解除质押时卖出申请已确认失败
	 * 13-申请解除质押时撤回申请通讯中
	 * 23-申请解除质押时撤回申请通讯失败
	 * 14-申请解除质押时撤回申请通讯成功
	 * 91-申请解除质押时撤回已确认成功
	 * 24-申请解除质押时撤回已确认失败
	 * 32-申请解除质押时对方已签收
	 * 90-申请解除质押时已交易成功(记账)
	 */
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_00 = "00";// 00-申请解除质押时未发出质押申请
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_11 = "11";// 11-申请解除质押时卖出申请通讯中
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_21 = "21";// 21-申请解除质押时卖出申请通讯失败
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_12 = "12";// 12-申请解除质押时卖出申请通讯成功
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_31 = "31";// 31-申请解除质押时卖出申请已确认成功
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_22 = "22";// 22-申请解除质押时卖出申请已确认失败
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_13 = "13";// 13-申请解除质押时撤回申请通讯中
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_23 = "23";// 23-申请解除质押时撤回申请通讯失败
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_14 = "14";// 14-申请解除质押时撤回申请通讯成功
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_91 = "91";// 91-申请解除质押时撤回已确认成功
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_24 = "24";// 24-申请解除质押时撤回已确认失败
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_32 = "32";// 32-申请解除质押时对方已签收
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_90 = "90";// 90-申请解除质押时已交易成功(记账)
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_26 = "26";// 26-清分失败回复
	public static final String UNCOLLZTN_STATUS_COLLZTN_BK_27 = "27";// 27-已状态变更(收到040状态变更通知)


	/** 网银接口返回信息 */
	/** 信息标示-AAAAAAA */
	public static final String STD400MGID_A = "AAAAAAA";
	/** 信息标示-返回错误 */
	public static final String STD400MGID_ERROR = "0000000";

	/** 发生查询内容 */
	/** 信息类型-01-出票登记 */
	public static final String MSG_TYPE_CPDJ = "01";
	/** 信息类型-02-提示承兑 */
	public static final String MSG_TYPE_TSCD = "02";
	/** 信息类型-03-提示收票 */
	public static final String MSG_TYPE_TSSP = "03";
	/** 信息类型-04-撤票 */
	public static final String MSG_TYPE_CP = "04";
	/** 信息类型-05-背书 */
	public static final String MSG_TYPE_BS = "05";
	/** 信息类型-06-贴现 */
	public static final String MSG_TYPE_TX = "06";
	/** 信息类型-07-回购式贴现赎回 */
	public static final String MSG_TYPE_HGSTXSH = "07";
	/** 信息类型-08-转贴现 */
	public static final String MSG_TYPE_ZTX = "08";
	/** 信息类型-09-回购式转贴现赎回 */
	public static final String MSG_TYPE_HGSZTXSH = "09";
	/** 信息类型-10-再贴现 */
	public static final String MSG_TYPE_PTX = "10";
	/** 信息类型-11-回购式再贴现赎回 */
	public static final String MSG_TYPE_HGSPTXSH = "11";
	/** 信息类型-12-背书保证 */
	public static final String MSG_TYPE_BSBZ = "12";
	/** 信息类型-13-承兑保证 */
	public static final String MSG_TYPE_CDBZ = "13";
	/** 信息类型-14-出票人保证 */
	public static final String MSG_TYPE_CPRBZ = "14";
	/** 信息类型-15-质押 */
	public static final String MSG_TYPE_ZY = "15";
	/** 信息类型-16-质押解除 */
	public static final String MSG_TYPE_ZYJC = "16";
	/** 信息类型-17-提示付款 */
	public static final String MSG_TYPE_TSFK = "17";
	/** 信息类型-18-逾期提示付款 */
	public static final String MSG_TYPE_YQTSFK = "18";
	/** 信息类型-19-拒付追索通知 */
	public static final String MSG_TYPE_JFZSTZ = "19";
	/** 信息类型-20-非拒付追索通知 */
	public static final String MSG_TYPE_FJFZSTZ = "20";
	/** 信息类型-21-追索同意清偿请求 */
	public static final String MSG_TYPE_ZSTYQCQSTZ = "21";

	/** 签收种类 */
	/** 信息类型-01-出票登记 */
	public static final String SIGN_TYPE_CPDJ = "01";
	/** 信息类型-02-提示承兑 */
	public static final String SIGN_TYPE_TSCD = "02";
	/** 信息类型-03-提示收票 */
	public static final String SIGN_TYPE_TSSP = "03";
	/** 信息类型-04-撤票 */
	public static final String SIGN_TYPE_CP = "04";
	/** 信息类型-05-背书 */
	public static final String SIGN_TYPE_BS = "05";
	/** 信息类型-06-贴现 */
	public static final String SIGN_TYPE_TX = "06";
	/** 信息类型-07-回购式贴现赎回 */
	public static final String SIGN_TYPE_HGSTXSH = "07";
	/** 信息类型-08-转贴现 */
	public static final String SIGN_TYPE_ZTX = "08";
	/** 信息类型-09-回购式转贴现赎回 */
	public static final String SIGN_TYPE_HGSZTXSH = "09";
	/** 信息类型-10-再贴现 */
	public static final String SIGN_TYPE_PTX = "10";
	/** 信息类型-11-回购式再贴现赎回 */
	public static final String SIGN_TYPE_HGSPTXSH = "11";
	/** 信息类型-12-背书保证 */
	public static final String SIGN_TYPE_BSBZ = "12";
	/** 信息类型-13-承兑保证 */
	public static final String SIGN_TYPE_CDBZ = "13";
	/** 信息类型-14-出票人保证 */
	public static final String SIGN_TYPE_CPRBZ = "14";
	/** 信息类型-15-质押 */
	public static final String SIGN_TYPE_ZY = "15";
	/** 信息类型-16-质押解除 */
	public static final String SIGN_TYPE_ZYJC = "16";
	/** 信息类型-17-提示付款 */
	public static final String SIGN_TYPE_TSFK = "17";
	/** 信息类型-18-逾期提示付款 */
	public static final String SIGN_TYPE_YQTSFK = "18";
	/** 信息类型-19-追索通知 */
	public static final String SIGN_TYPE_ZSTZ = "19";
	/** 信息类型-20-追索同意清偿请求 */
	public static final String SIGN_TYPE_ZSTYQCQQ = "20";
	/** 信息类型-21-追索同意清偿签收通知 */
	public static final String SIGN_TYPE_ZSTYQCQSTZ = "21";
	/** 承兑余额查询 add by jornezhang BMS-1476 增加余额查询 2009-8-13 begin*/
	public static final String BALANCE_QUERY_TYPE_1 = "1";
	/** 库存余额查询 */
	public static final String BALANCE_QUERY_TYPE_2 = "2";
	/**  BMS-1476 增加余额查询 end*/
	/**  added by kangbyron 2009-08-20 BMS-1576 增加转卖余额查询 begin*/
    public static final String BALANCE_QUERY_TYPE_3 = "3";
    /**  BMS-1576 增加转卖余额查询 end*/

	/* add by jornezhang BMS-1581 查询做分页处理 2009-8-22 begin.*/
	/** 公开报价查询 我行标志 */
	public static final String BUSS_FLAG_01 = "01";
	/** 公开报价查询 他行标志 */
	public static final String BUSS_FLAG_02 = "02";
	/* add by jornezhang BMS-1581 查询做分页处理 2009-8-22 end.*/

	/** add by farly.yu 20090831 合并福州商行质押模块 */
	 /**质押登记簿---提交状态*/
	 public static final String SUB_STATUS_0="0";//0 未提交
	 public static final String SUB_STATUS_1="1";//1 已提交
	 public static final String SUB_STATUS_2="2";//2 已签收
	 public static final String SUB_STATUS_3="3";//3 退回修改

	 /**查询查复来源方*/
	 public static String CHECK_FROM_COLLZTN = "3";//实物票据质押
	 public static String CHECK_FROM_BANK_DISCOUNT = "1";//实物银票贴现
	 public static String CHECK_FROM_TRADE_DISCOUNT = "2";//实物商票贴现

	/**
	 * 质押与解除质押业务品种定义
	 */
	public static final String BUSINESS_TYPE_COLLZTN="9002";//质押业务
	public static final String BUSINESS_TYPE_UNCOLLZTN="9003";//解除质押业务
	public static final String BIZ_TYPE_PAWNEE="90";//我行是质权人
	public static final String BIZ_TYPE_UNPAWNEE="91";//我行是出质人

	 /**同业额度明细表--使用标志*/
	 public static final String FLAG_USE="0";/**使用额度*/
	 public static final String FLAG_RESUME="1";/**恢复额度*/

	/**
	 * 质押申请类型----生成质押appno
	 */
	public static final String COLLZTN_BUSINESS_TYPE="7011";
	 /** end is 20090831 */

	/**
	 *  交易方向(核算部分)
	 */
	public static final String BATCH_TXDIR_RCV ="1"; //  文件接收
	public static final String BATCH_TXDIR_SND ="2"; //  文件发送

	/* add by shen_antonio 20100113 jira: BMS-2416 begin .*/
	/** 公共数据代码-ECD03010-电子商业汇票提示付款期限(单位：天) */
	public static final String CMONDTCD_ECD03010 = "ECD03010";
	/* add by shen_antonio 20100113 jira: BMS-2416 end.*/
	/***预警参数RULE_NO ADD BY zhoujun.hou 20111221 */
	public static final String BATCH_RULE_NO_GY_AMOUNT="1";//额度提示提前天数(公用)
	public static final String BATCH_RULE_NO_GY_JGXY="2";//监管协议预警提前天数(公用)
	public static final String BATCH_RULE_NO_GY_ZHT="3";//主合同预警提前天数（公用）
	public static final String BATCH_RULE_NO_GY_ZYHT="4";//质押合同预警提前天数(公用)
	public static final String BATCH_RULE_NO_HY_YJTS="11";//价格波动率(货押)
	public static final String BATCH_RULE_NO_BL_BLHT="21";//保理合同预警提前天数(保理)
	public static final String BATCH_RULE_NO_SFBDC_XY="31";//四方保兑仓协议预警提前天数(四方保兑仓)

/*********************************             SCF 系统常量 BEGIN             **************************************************/

	/*******************供应链产品**********************ADD BY LGX 20111221 14:28********/

	/** 产品种类 */
	public static final String PRODUCT_TYPE_01="1001";    //动产融资

	/** 市价来源  */
	public static final String MARKETPRICESRC_00 = "00";//手工维护
	public static final String MARKETPRICESRC_01 = "01";//百川价格行情

	/** 状态:1-正常 */
	public static final String STATUS_1 = "1";//正常

	/** 合同状态:0-正常 */
	public static final String CONT_SLAVE_STATUS_0 = "0";

	/**规则引擎表设置参数值*/
	public static final String 	RULE_ENGINE_ID_DUEDAY = "13";//提示提前天数
	public static final String 	RULE_ENGINE_ID_WARNDAY = "14";//预警提前天数
	public static final String 	RULE_ENGINE_ID_PRICEWAVEPERCENT = "15";//价格波动率
	public static final String 	RULE_ENGINE_ID_PRICEWAVECIRCLE = "16";//价格波动周期
	public static final String 	RULE_ENGINE_ID_PILOTAGENC = "17";//试点机构参数设置


	/**
	 * 规则引擎表 预警参数  Rule_No
	 * */
	public static final String RULE_NO_0019 = "0019";//价格波动预警
	public static final String RULE_NO_0017 = "0017";//提前天数
	public static final String RULE_NO_0021 = "0021";//未巡库预警参数
	public static final String RULE_NO_0022 = "0022";//试点机构参数

	/** TBL_RULE_ENGINE[业务规则表]-RULE_TYPE[规则类型]**/
	public static final String	RULE_TYPE_06 = "06"; // 预警参数

	/**协议类型*/
	public static final String MUTI_PROTOCOL_ORTHER = "00";//其他协议
	public static final String MUTI_PROTOCOL_CUST = "01";//监管协议
	public static final String MUTI_PROTOCOL_GUARANTE = "02";//保购协议
	public static final String MUTI_PROTOCOL_WARE = "03";//仓贸银协议
	public static final String MUTI_PROTOCOL_STORAGERENT = "04";//仓库租赁期协议

	/**业务编号类型*/
	public static final String  WARN_BUSINESSNO_TYPE02= "02";//出资入库?

	/**add by mingzhao.lan 2011-8-17*/
	//核库结果
	public static final String CHECK_STOCK_RESULTS_00 = "00";//未核库
	public static final String CHECK_STOCK_RESULTS_01 = "01";//通过
	public static final String CHECK_STOCK_RESULTS_02 = "02";//不通过
	
	/**对账结果**/
	public static final String CHECK_STOCK_RESULTS_NORMAL = "01";//正常
	public static final String CHECK_STOCK_RESULTS_NOT_EQUALS = "02";//对账不平
	
	/** 对账/盘库 区分 */
	public static final String CHECK_STOCK_TYPE_ACCOUNT = "01";// 对账
	
	/**  对帐状态 */
	public static final String CHECK_STOCK_STATUS_01 = "01";//正在对帐
	public static final String CHECK_STOCK_STATUS_02 = "02";//对帐完成

	/**  对帐方式 */
	public static final String CHECK_STOCK_WAY_BANK = "01";//银行发起对账
	public static final String CHECK_STOCK_WAY_CUST = "02";//监管公司发起对账
	public static final String CHECK_STOCK_WAY_SLAVE = "03";//按担保合同
//	public static final String CHECK_STOCK_WAY_WARE = "04";//按仓库
	/**  监管级别 */
	public static final String MONI_LEVELS_0 = "1";//一级
	public static final String MONI_LEVELS_1 = "2";//二级
	public static final String MONI_LEVELS_2 = "3";//三级

	/**
	 *监管合同：00,独立第三方仓库监管;01,非独立第三方仓库监管
	 */
	public static final String MONI_WAREHOUSE_TYPE_00 = "00";//独立第三方仓库监管
	public static final String MONI_WAREHOUSE_TYPE_01 = "01";//非独立第三方仓库监管
	public static final String MONI_WAREHOUSE_TYPE_02 = "02";//混合型

	public static final String ONE_MONTH_DAYS_30 = "30";//一个月天数
	public static final String TWO_MONTH_DAYS_60 = "60";//二个月天数
	public static final String THREE_MONTH_DAYS_90 = "90";//季度天数
	/**
	 * 提前预警天数
	 */
	public static final String AHEAD_OF_TIME_7 = "7" ;// 提前七天
	/**
	 * 合同类型
	 */
	public static final String BUSINESSNO_TYPE_SLAVECONTNO = "02";//抵质押合同 类型

	/**
	 * SCF库存信息变更区别
	 */
	public static final String SCF_MORT_STOCK_TYPE_01 = "01";//入库
	public static final String SCF_MORT_STOCK_TYPE_02 = "02";//出库
	public static final String SCF_MORT_STOCK_TYPE_03 = "03";//修改

    /**
     * SCF与CMS接口库存信息变更类型区别
     */
	public static final String CMS_MORT_STOCK_TYPE_00 = "00";//出库
	public static final String CMS_MORT_STOCK_TYPE_01 = "01";//入库
	public static final String CMS_MORT_STOCK_TYPE_02 = "02";//修改

	/**客户类型 01-企业客户**/
	public static final String CUSTCLASS01 = "01";// 企业客户
	/**客户类型 02-监管公司**/
	public static final String CUSTCLASS02 = "02";// 监管公司
	/**客户类型 03-期货公司**/
	public static final String CUSTCLASS03 = "03";// 期货公司

	/**SCF接入网关标示符**/
	public static final String SYSTEM_SCFS = "SCFS";
	/**CMS接入网关标示符**/
	public static final String SYSTEM_CMSF = "CMSF";
	/**动产流水号，value_no**/
	public static final int VALUE_NO_SCFNO_ID = 36;//动产流水号，value_no
	/***动产流水号value_index*/
	public static final String VALUE_INDEX_SCFNO_ID = "SCFNO_ID";//动产流水号value_index

	/** 错误应答码 */
	public static final String ERROR_CODE_SUCC = "0000"; // 成功
	public static final String ERROR_CODE_FAIL = "9999"; // 失败

	public static final String MORTGAGE_PARENT_CODE_0 = "0";//上级押品0

	public static final String MORTGAGE_LEVEL_1 = "1";//押品一级
	public static final String MORTGAGE_LEVEL_2 = "2";//押品二级
	public static final String MORTGAGE_LEVEL_3 = "3";//押品三级
	public static final String MORTGAGE_LEVEL_4 = "4";//押品四级

	public static final String MORTGAGE_STATUS_1 = "1";//押品状态

	public static final String MORTGAGE_TYPE_1 = "1";//押品种类,自己维护
	public static final String MORTGAGE_TYPE_2 = "2";//押品种类,cms过来的

	public static final String TLR_TYPE_0 = "0";//0系统维护员；
	public static final String TLR_TYPE_1 = "1";//1 业务维护员；
	public static final String TLR_TYPE_2 = "2";//2-业务员；
	public static final String TLR_TYPE_3 = "3";//3-系统操作员

	public static final String ROLE_ADMIN_VALUE = "7";//上线前根据生产更改

	public static final String TLRROLEREL_STATUS_1 = "1";//TlrRoleRel表状态：1-有效

	/**
	 * 机构级别  1 总行
	 * **/
//	public static final String BRCODE_CLASS_0 = "0";
	public static final String BRCODE_CLASS_1 = "1";
	public static final String BRCODE_CLASS_2 = "2";
	public static final String BRCODE_CLASS_3 = "3";
//	public static final String BRCODE_CLASS_4 = "4";
//	public static final String BRCODE_CLASS_SELF = "-1";

	/**
	 * 是否开启试点机构
	 */
	public static final String TRYBRCODESTATUS_1 = "1";//开启试点机构
	public static final String TRYBRCODESTATUS_2 = "2";//关闭试点机构

	public static final String PRODUCT_TYPE_1001="1001";    //GF动产融资
	public static final String PRODUCT_TYPE_1002="1002";    //标准仓单
	public static final String PRODUCT_TYPE_1003="1003";    //普通非标准仓单
	public static final String PRODUCT_TYPE_1004="1004";    //B2B融资

	public static final String PRODUCT_TYPE_2001="2001";    //国内保理
	public static final String PRODUCT_TYPE_2003="2003";    //应收账款质押融资
	public static final String PRODUCT_TYPE_3001="3001";    //四方保兑仓、厂商银
	/*** add by zhoujun.hou 20111221 begin*/
	/** 合同申请-多方协议： 多方协议类型(PROTOCOL_TYPE) **/
	public static final String OTHER_PROTOCOLTYPE = "00";//其他协议
	public static final String CUST_PROTOCOLTYPE = "01";// 存货质押协议三方协议(监管合同)
	public static final String GUAR_PROTOCOLTYPE = "02";//保购合同
	public static final String DEBT_PROTOCOLTYPE = "05";//应收账款
	public static final String WARE_PROTOCOLTYPE = "03";//“仓贸银”授信三方合同协议
	public static final String SITE_PROTOCOLTYPE = "04";//场地租赁协议

	/** TBL_WARN_DUE_INFO[到期提醒表]-WARN_DUE_TYPE[到期提醒类型] add by zhoujun.hou 20111221**/
	public static final String	WARN_DUE_TYPE_FINANCING = "0001"; // 融资到期提醒
	public static final String  WARN_DUE_TYPE_BILL ="0002";      //仓单到期提醒
	public static final String  WARN_DUE_TYPE_NOTCHECK ="0003";      //未巡库提示
	public static final String  WARN_DUE_TYPE_NOTCHANGE ="0004";      //未换货提示
	public static final String  WARN_DUE_TYPE_WARNLINE ="0005";      //仓单警戒线预警
	public static final String  WARN_DUE_TYPE_SALELINE ="0006";      //仓单平仓线预警
	public static final String  WARN_DUE_TYPE_SLAVE ="0007";      //质押合同到期
	public static final String  WARN_DUE_TYPE_PROT ="0008";      //监管协议到期
	public static final String  WARN_DUE_TYPE_WAREH ="0009";      //四方保兑仓协议到期
	public static final String  WARN_DUE_TYPE_BLHT ="0010";      //保理合同到期
	public static final String  WARN_DUE_TYPE_RZED ="0011";      //融资额度到期
	/** TBL_WARN_DUE_INFO[到期提醒表]-WARN_STATUS[预警信息处理状态] **/
	public static final String	WARN_STATUS_UNDO = "00"; // 未处理
	public static final String	WARN_STATUS_DONE = "01"; // 已处理
	/** TBL_DEAL_BASE_INFO[四方保兑仓协议表]-MAST_CONT_STATUS[主合同状态] **/
	public static final String	MAST_CONT_STATUS_00 = "00"; // 失效
	public static final String	MAST_CONT_STATUS_01 = "01"; // 正常
	public static final String	MAST_CONT_STATUS_02 = "02"; // 冻结
	public static final String	MAST_CONT_STATUS_03 = "03"; // 建立审批中
	public static final String	MAST_CONT_STATUS_04 = "04"; // 冻结审批中
	public static final String	MAST_CONT_STATUS_05 = "05"; // 其它
	/** TBl_CONT_DEBT_BASE_INFO[保理合同基本信息表]-TYPE[合同类型] **/
	public static final String	CONT_DEBT_TYPE_DC = "1"; // 动产主合同
	public static final String	CONT_DEBT_TYPE_BL = "2"; // 保理主合同
	public static final String	CONT_DEBT_TYPE_YXKZ = "3"; // 应收款主合同
	/** TBL_CREDIT_INFO[额度信息表]-STATUS[额度状态] **/
	public static final String	CREDIT_INFO_STATUS_ZC = "1"; // 正常
	public static final String	CREDIT_INFO_STATUS_ZZ = "2"; // 终止
	/*** add by zhoujun.hou 20111221 end */
	/** 有效 */
	public static final String	SLAVECONT_STATUS_VALID = "01"; // 从合同状态有效

	/** 预警级别 1-高 */
	public static final String WARN_LEVEL_HIGH = "1";
	/** 预警级别 2-中 */
	public static final String WARN_LEVEL_MIDI = "2";
	/** 预警级别 3-低 */
	public static final String WARN_LEVEL_LOW = "3";

	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中合同为01*/
	public static final String BUSINESS_TYPE_MASTCONTNO = "01";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中协议为02*/
	public static final String BUSINESS_TYPE_PROTOCOLNO = "02";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中质押合同为03*/
	public static final String BUSINESS_TYPE_SLAVECONTNO = "03";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中额度逾期的额度编号为04*/
	public static final String BUSINESS_TYPE_CREDITOVERDUENO = "04";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中额度到期的额度编号为05*/
	public static final String BUSINESS_TYPE_CREDITDUENO = "05";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中未巡库预警06*/
	public static final String BUSINESS_TYPE_UnPatrolStore = "06";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中未核库预警07*/
	public static final String BUSINESS_TYPE_UnCheckStore = "07";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中标准仓单到期预警08*/
	public static final String BUSINESS_TYPE_STANDBILL = "08";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中非标仓单到期预警09*/
	public static final String BUSINESS_TYPE_NORMALBILL = "09";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中未换货预警 10*/
	public static final String BUSINESS_TYPE_UNEXCHANGEGOOD = "10";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中融资借据到期预警 11*/
	public static final String BUSINESS_TYPE_LNCI = "11";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中池融资溢拨预警为12*/
	public static final String BUSINESS_TYPE_OVERFLOWPOOL = "12";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中担保付款到期预警为13*/
	public static final String BUSINESS_TYPE_GuaranteePaymentDue = "13";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE中担保付款逾期预警为14*/
	public static final String BUSINESS_TYPE_GuaranteePaymentOverDue = "14";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE四方保兑仓押品在途通知书申请编号15*/
	public static final String BUSINESS_TYPE_FOURNOTICE = "15";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE汽车金融押品在途通知书申请编号16*/
	public static final String BUSINESS_TYPE_CARNOTICE = "16";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE应收帐款争议预警为17*/
	public static final String BUSINESS_TYPE_DEBTID = "17";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE借据到期敞口未结清预警18*/
	public static final String BUSINESS_TYPE_LNCI_EXPOSURE = "18";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE单笔业务未填平敞口预警19*/
	public static final String BUSINESS_TYPE_LNCI_OPNE = "19";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE核心未收款确认预警为20*/
	public static final String BUSINESS_TYPE_NONE_PAY = "20";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE厂商到期未交货预警为21*/
	public static final String BUSINESS_TYPE_NONE_DELIVERY = "21";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE池敞口无法覆盖预警为22*/
	public static final String BUSINESS_TYPE_POOL_OPEN_NOT_COVER = "22";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE订单未交货预警提示23*/
	public static final String BUSINESS_TYPE_ORDER_UNDELIVERED = "23";
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE订单付款提示24*/
	public static final String BUSINESS_TYPE_ORDER_REPAY = "24";//
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE订单付款到期提醒25*/
	public static final String BUSINESS_TYPE_ORDER_REPAY_DUE = "25";//
	/**TBL_WARN_DUE_INFO中BUSINESSNO_TYPE订单付款逾期预警26*/
	public static final String BUSINESS_TYPE_ORDER_REPAY_OVERDUE = "26";//


	/**TBL_CONT_SLAVE_INFO.STATUS 质押合同状态 01:正常；02：冻结；03：无效 */
	public static final String CONT_SLAVE_STATUS_NORMAL = "01";
	public static final String CONT_SLAVE_STATUS_FREEZE = "02";
	public static final String CONT_SLAVE_STATUS_INVALID = "03";

	/**
	 * TBL_WARN_BASE_INFO 预警基本信息表 状态status
	 * 0-无效   1-有效  2-忽略
	 */
	public static final String WARN_STATUS_NOT_EFFICT = "0";
	public static final String WARN_STATUS_EFFICT = "1";
	public static final String WARN_STATUS_SUSPEND = "2";

	/** 客户状态 **/
    public static final String CUST_STATUS_INVALID = "00"; //无效
    public static final String CUST_STATUS_VALID = "01"; //有效

    /**
	 * TBL_PRODUCT_INFO PARENT_ID
	 */
	public static final String PARENT_ID_1100="1100";    //动产融资

	/**
	 * TBL_PRODUCT_MORT MONI_TYPE
	 */
	public static final String MONI_TYPE_1="1";    //动态
	
	public static final String MONI_TYPE_2="2";    //静态


	/**TBL_MUTI_PROT_BASE_INFO, PROTOCOL_TYPE 协议类型	 */
	public static final String MUTI_PROTOCOL_MONI = "01";// 监管协议
	public static final String MUTI_PROTOCOL_FOURWH = "02";// 四方保兑仓协议
	public static final String MUTI_PROTOCOL_AUTOFINANCE = "03";// 汽车金融协议
	public static final String MUTI_PROTOCOL_FACTOR = "04";// 保理协议
	public static final String MUTI_PROTOCOL_PLDEGE = "05";// 应收账款质押协议
	public static final String MUTI_PROTOCOL_ORDER = "06";// 订单协议
	public static final String MUTI_PROTOCOL_THREEWH = "07";// 三方保兑仓协议

    /**
     * 监管协议状态
     */
    public static final String STATE_INVALID = "0"; // 无效
    public static final String STATE_VALID = "1"; // 有效
    public static final String STATE_FREEZE = "2"; // 冻结

  //核库结果
    public static final String CHECK_STOCK_RESULTS_UNCHECK = "00";//未核库
    public static final String CHECK_STOCK_RESULTS_PASS = "01";//通过

    /** 仓单业务管理的status状态的值 **/
    public static final String BILL_MANAGE_STATUS_DELIVERY = "0";//仓单管理表字段（status）  -- 解押
    public static final String BILL_MANAGE_STATUS_PLEDGE = "1";//仓单管理表字段（status）  -- 质押
    public static final String BILL_MANAGE_STATUS_ADJUST = "2";//仓单管理表字段(status)    -- 处置

    public static final String WORKFLOW_BUSSTYPE_EXCHANGEAPPLI = "1104";	// 换货申请

    //押品变更的类型 2-押品置换
    public static final String MORTGAGE_CHANGE_TYPE_EXCHANGE = "2";

    /**
     * 通知书类型
     * */
    // 通知书类型: 2-押品变更通知书及回执
    public static final String NOTICE_TYPE_2 = "2";
    //通知书类型: 9-发货通知书
    public static final String NOTICE_TYPE_9 = "9";
 // 通知书类型: 49-汽车金融发货通知书
    public static final String NOTICE_TYPE_49 = "49";
    //通知书类型： 77-先票/款后货收款确认通知书：流贷
    public static final String NOTICE_TYPE_77 = "77";
    //通知书类型： 79-先票/款后货收款确认通知书：银承
    public static final String NOTICE_TYPE_79 = "79";

    /** TBL_LNCI_BASE_INFO[借据基本信息表]-LNCI_STATUS[借据状态]
     *  借据状态：0-新建；1-已生效；2-已结清；3-已失效
     */
    public static final String LNCI_STATUS_NEW = "0";
    public static final String LNCI_STATUS_EFFECT = "1";
    public static final String LNCI_STATUS_SETTLE = "2";
    public static final String LNCI_STATUS_INVALID = "3";

    /***发票状态 */
	public static final String INVOICE_STATUS_ENTRY="01";//01已录入
	public static final String INVOICE_STATUS_PURCHASED="02";//02：已承购，
	public static final String INVOICE_STATUS_VERIFIED="03";//03：已核销
	
	/*** 凭证状态  */
	public static final String BILLS_STATUS_RECORDED = "01"; //已录入
	public static final String BILLS_STATUS_PURCHASED = "02"; // 已转让
	public static final String BILLS_STATUS_PAYOFF = "03";//已核销
	public static final String BILLS_STATUS_LOANED = "04";//已融资
	
	/***订单状态 500 */
	public static final String ORDER_STATUS_ENTRY="01";//01已录入
	public static final String ORDER_STATUS_LOANED="02";//02：已融资，
	public static final String ORDER_STATUS_DELIVERED="03";//03：已录入交货后凭证
	
	/***商纠状态 */
	public static final String ISSUE_FLAG_TRUE="1";//有
	public static final String ISSUE_FLAG_FALSE="0";//无

	/**
     * 应收账款单据类型
     */
    /** 发票 */
    public static final String DEBT_BILL_TYPE_DEBT = "01";	//发票(日结算单)
    /** 结算单 */
    public static final String DEBT_BILL_TYPE_BILL = "02";	//结算单

    /**TblDebtBaseInfo  BUSS_TYPE */
    public static final String DEBT_BUSS_TYPE_WF = "3201";//	国内保理-无追索-单笔融资
    public static final String DEBT_BUSS_TYPE_WC = "3202";//	国内保理-无追索-池融资


    /**
     * 通知书回执状态
     */
    //通知书回执状态:0-未确认回执
    public static final String NOTICE_BASE_STATUS_UNCONFIRM = "0";
    //通知书回执状态:1-监管公司确认回执--同意
    public static final String NOTICE_BASE_STATUS_MONI_CONFIRM_AGREE = "1";
    // 通知书回执状态：10-银行通知发货
    public static final String NOTICE_BASE_STATUS_DELIVER_NOTICE = "10";
    // 通知书回执状态：2-核库巡库岗确认回执
    public static final String NOTICE_BASE_STATUS_CHECK_STOCK_CONFIRM = "2";
    //通知书回执状态：3-四方保兑仓出质入库回执--银行审批通过后使用--同意
    public static final String NOTICE_BASE_STATUS_CONFIRM_AGREE = "3";
    // 通知书回执状态：4-拒绝回执
    public static final String NOTICE_BASE_STATUS_REFUSE = "4";
    //通知书回执状态：9-跌价补偿时使用。
    public static final String NOTICE_BASE_STATUS_COMPENSATED = "9";
    //申请状态：10-商业纠纷类型。
    public static final String APPLY_TYPE_ISSUE="10";

    /*** 借据收款状态 1：已收；0：未收 */
	public static final String LNCI_CONFIRM_STATUS_POSITIVE = "1";// 确认收款
	public static final String LNCI_CONFIRM_STATUS_PASSIVE = "0";// 未收

	// [额度状态] 1：正常；2：终止
	public static final String CREDIT_STATUS_NORMAL = "1";
	public static final String CREDIT_STATUS_TERMINATE = "2";

	// [交易操作类型]
	// 00：生效(录入)；01：预占用；02：占用；；03：恢复（释放）；04：冻结；05:解冻；06：变更；07：终止;08-预占用恢复（释放）;09-直接占用
	public static final String CREDIT_TRADE_TYPE_INPUT = "00";// 生效(录入)
	public static final String CREDIT_TRADE_TYPE_PRE_OCCUPY = "01";// 预占用
	public static final String CREDIT_TRADE_TYPE_OCCUPY = "02";// 占用
	public static final String CREDIT_TRADE_TYPE_RELEASE = "03";// 占用恢复（释放）
	public static final String CREDIT_TRADE_TYPE_FREEZE = "04";// 冻结
	public static final String CREDIT_TRADE_TYPE_UNFREEZE = "05";// 解冻
	public static final String CREDIT_TRADE_TYPE_CHANGE = "06";// 变更
	public static final String CREDIT_TRADE_TYPE_END = "07";// 终止
	public static final String CREDIT_TRADE_TYPE_PRE_RELEASE = "08";// 预占用恢复（释放）
	public static final String CREDIT_TRADE_TYPE_DIRECT_OCCUPY = "09";// 直接占用

	public static final String REVERSE_FLAG_OFF = "0"; //正向
	public static final String REVERSE_FLAG_ON = "1"; //反向

	//add by fanrong 20110315 jira:BMS-3016 begin
	/**
	 * 机构拆并各步骤处理标志
	 */
	public static final String MERGEINFO_FLAG_FINISHED = "F"; //处理成功
	public static final String MERGEINFO_FLAG_FAILED = "E";   //处理失败
	public static final String MERGEINFO_FLAG_RUNING = "R";   //正在处理
	public static final String MERGEINFO_FLAG_UNPROCESSED = "N"; //未处理
	public static final String MERGEINFO_FLAG_REVERSED = "V"; //反向处理结束

	   /** add by Qingguang.Li date=20100722 机构合并 begin **/
	public static final String BR_BRCODE_FLAG_1 = "1";    //机构编号为INTEGER
	public static final String BR_BRCODE_FLAG_2 = "2";    //机构编号VARCHAR
	public static final String BR_BRCODE_FLAG_3 = "3";    //联行编号为INTEGER
	public static final String BR_BRCODE_FLAG_4 = "4";    //联行编号VARCHAR
	public static final String BR_BRCODE_FLAG_5 = "5";    //机构名称
	public static final String BR_BRCODE_FLAG_6 = "6";    //联行名称
	/** add by Qingguang.Li date=20100722 机构合并 end **/

	/** add by Qingguang.Li date=20100818 机构合并更新标志 begin**/
	public static String BR_MERGE_UPDATE_FLAG_0 = "0"; //更新机构信息
//	public static String BR_MERGE_UPDATE_FLAG_1 = "1"; //更新联行信息
	/** add by Qingguang.Li date=20100818 机构合并更新标志 end**/

	public static final String MERGEINFO_FLAG_VALID = "1";        //有效
	public static final String MERGEINFO_FLAG_INVALIDATION = "0"; //无效


	public static final String BACKUP_TABLE_NAME = "br_merge_history_info"; //机构拆并备份信息表名
	public static final String BR_MERGER_DATA_BAK_TABLE_NAME = "br_merge_data_bak"; //机构合并数据备份表

	/**
	 * 备份信息表号码种类code_type定义
	 */
	public static final String HISTORYINFO_CODE_TYPE_CONTRACTNO = "1"; //合同号
	public static final String HISTORYINFO_CODE_TYPE_CREDIT = "2"; //授信号
	public static final String HISTORYINFO_CODE_TYPE_GUARANTEESET = "3"; //权利品编号
	public static final String HISTORYINFO_CODE_TYPE_ARCHIVE = "4"; //档案编号
	public static final String HISTORYINFO_CODE_TYPE_TLRINFO = "5"; //操作员编号
	//add by fanrong 20110315 jira:BMS-3016 end
	// [额度类型] 1：直接授信额度；2：第三方授信额度；3：间接额度
	public static final String CREDIT_CLASS_DIRECT = "1";// 1-直接授信额度
	public static final String CREDIT_CLASS_THIRD = "2";// 2-第三方授信额度
	public static final String CREDIT_CLASS_INDIRECT="3";//3-间接额度
	public static final String CREDIT_CLASS_LIMIT_BUYER="4";//4-买方信用限额

	// [额度节点类型] 1-根节点（1级） 2-子节点（2级） 3-子子节点（3级）
	public static final String CREDIT_NODE_TYPE_ROOT = "1";
	public static final String CREDIT_NODE_TYPE_LEAF = "2";
	public static final String CREDIT_NODE_TYPE_SUB_LEAF = "3";


	/**TBL_WARN_CREDIT_INFO中BUSINESS_TYPE领用额度未出账占用预警为01*/
	public static final String BUSINESS_TYPE_INDIRECT_CREDIT_NOTCARRIEDOUT = "01";
	/**TBL_WARN_CREDIT_INFO中BUSINESS_TYPE额度核对预警为02*/
	public static final String BUSINESS_TYPE_CERDIT_CHECK = "02";
	
	/** TBL_MUTI_PROT_PART_INFO[多方协议参与者信息表] ROLE[参与者角色] */
	public static final String PROTOCOL_PART_ROLE_BANK = "01";// 银行
	public static final String PROTOCOL_PART_ROLE_MONI = "02";// 监管公司
	public static final String PROTOCOL_PART_ROLE_CREDIT = "03";// 授信客户
	public static final String PROTOCOL_PART_ROLE_CORE = "04";// 核心企业
	public static final String PROTOCOL_PART_ROLE_BACKCORE = "05";// 回购厂商
	
	/** 巡库核库类型 **/
	public static final String OPER_TYPE_INSPECT = "0";// 巡库
	public static final String OPER_TYPE_CHECK = "1";// 核库
	
	//通用预警TBL_WARN_BASE_INFO TOP_TBL_PRODUCT_ID
	public static final String COMMON_TOP_PRODUCT_ID = "XXXX";
	//通用预警编号=产品大类+预警类型
	public static final String WARN_NO_TYPE_MONI_LEVEL_DUE = "100000001";//监管公司等级到期预警
	public static final String WARN_NO_TYPE_CREDIT_CARRIED_OUT = "100000002";//间接额度领用额度未出账占用预警
	public static final String WARN_NO_TYPE_LOAN_DUE = "100000003";//融资到期提示
	public static final String WARN_NO_TYPE_LOAN_OVERDUE = "100000004";//融资逾期未结清提示
	//预警编号=产品小类+预警类型。预警类型如下：
	public static final String WARN_NO_TYPE_01 = "01"; // 跌破最低控货价值预警
	public static final String WARN_NO_TYPE_02 = "02"; // 跌破警戒线预警
	public static final String WARN_NO_TYPE_03 = "03"; // 价格跌幅预警
	public static final String WARN_NO_TYPE_04 = "04"; // 价格异常预警
	public static final String WARN_NO_TYPE_05 = "05"; // 对账不平预警
	public static final String WARN_NO_TYPE_06 = "06"; // 未巡库预警
	public static final String WARN_NO_TYPE_07 = "07"; // 突破监管限额预警
	public static final String WARN_NO_TYPE_08 = "08"; // 应收账款付款提示
	public static final String WARN_NO_TYPE_09 = "09"; // 应收账款到期提醒
	public static final String WARN_NO_TYPE_10 = "10"; // 应收账款逾期预警
	public static final String WARN_NO_TYPE_11 = "11"; // 敞口无法覆盖预警
	public static final String WARN_NO_TYPE_12 = "12"; // 预约还款未成功预警
	
	//最大提交记录条数
	public static final int MAX_COMMIT=500;  //最大提交条数。超过500条记录需要提交到数据库中。
	
	/** 供应链产品类别 **/
	public static final String PRODUCT_TYPE_WAREHOUSE_TOP = "2000"; // 保兑仓
	public static final String PRODUCT_TYPE_WAREHOUSE = "2100"; // 保兑仓
	
	/** 票据业务类型 **/
	public static final String BILL_TYPE_DRAFT = "00"; // 承兑
	public static final String BILL_TYPE_PLEDGE = "01"; // 票据池质押
	
	/** 票据池状态 **/
	public static final String BILL_POOL_STATUS_IN = "1"; // 已入池
	public static final String BILL_POOL_STATUS_OUT = "2"; // 已出池
	
	/** 出账方式 **/
	public static final String LOAN_WAY_CASH = "01"; // 流动资金贷款
	public static final String LOAN_WAY_BILL = "02"; // 银行承兑汇票
	
	//合同协议无效状态
	public static final String MAST_CONT_STATUS_STOP = "03"; //主合同无效标记
	public static final String STATUS_INVALID = "00"; // 无效
	
	/***发票池状态 */
	public static final String POOL_FLAG_IN_POOL="1";//入池
	public static final String POOL_FLAG_OUT_POOL="0";//出池
	
	// 加锁状态
	public static final String LOCKED = "1"; // 锁定
	public static final String UNLOCKED = "0"; // 未锁定
	
	/** 保理业务类型 与 DATA_DIC 相对应**/
	public static final String FACT_TYPE_INLAND = "1"; // 国内保理
	public static final String FACT_TYPE_REVERSE = "2"; // 反向保理
	//public static final String FACT_TYPE_INTL = "2"; // 国际保理
	public static final String FACT_TYPE_DOUBLE_FACT = "3"; // 行内双保理
	public static final String FACT_TYPE_CREDIT_FACT = "4"; // 信保保理
	public static final String FACT_TYPE_LEASE_FACT = "5"; // 租赁保理
	public static final String FACT_TYPE_DEBT_PLEDGE = "6"; //应收账款质押
	public static final String FACT_TYPE_DEBT_POOL_PLEDGE = "7"; // 应收账款质押池融资
	public static final String FACT_TYPE_DEBT_POOL = "8"; // 保理池融资
	public static final String FACT_TYPE_EXPORT_POOL_PLEDGE = "9"; // 出口退税池质押融资
	
	/**
	 * 是否为票据池。用于 TblBillBaseInfo表
	 */
	public static final String POOL_FLAG_NO="0";//不是票据池
	public static final String POOL_FLAG_YES="1";//是票据池
	/**
	 * 票据状态
	 */
	public static final String BILLS_STATUS_OVER="0";//已结清
	public static final String BILLS_STATUS_NORMAL="1";//正常

}
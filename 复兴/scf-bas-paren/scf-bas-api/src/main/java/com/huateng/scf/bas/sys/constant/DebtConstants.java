package com.huateng.scf.bas.sys.constant;

import com.huateng.scf.bas.common.constant.ScfBasConstant;

public class DebtConstants extends ScfBasConstant {
	public static final String VALUE_INDEX_CONTREPAYMENTINFO_ID = "CONTREPAYMENTINFO_ID";

	/*** 发票状态 */
	public static final String INVOICE_STATUS_NEW = "00";		// 00-新建
	public static final String INVOICE_STATUS_ENTRY = "01";		// 01-已录入
	public static final String INVOICE_STATUS_PURCHASED = "02";	// 02-已转让
	public static final String INVOICE_STATUS_VERIFIED = "03";	// 03-已核销
	public static final String INVOICE_STATUS_FINANCED = "04";	// 04-已融资

	public static final String CLAIM_STATUS_APPLIED = "1";// 已申请理赔
	public static final String CLAIM_STATUS_UNAPPLIED = "0";// 未申请理赔

	/*** 商纠状态 */
	public static final String ISSUE_FLAG_FALSE = "0"; // 无商纠
	public static final String ISSUE_FLAG_TRUE = "1";  // 有商纠
	public static final String ISSUE_FLAG_CLEAR = "2"; // 商纠解除

	/*** 发票池状态 */
	public static final String POOL_FLAG_IN_POOL = "1";// 入池
	public static final String POOL_FLAG_OUT_POOL = "0";// 出池

	/*** 融资模式 */
	public static final String FINANCING_TYPE_INVOICE = "1";// 发票融资
	public static final String FINANCING_TYPE_POOL = "2";// 池融资
	/*** 业务类型 */
	public static final String APPLY_TYPE_ENTRY = "00";// 录入
	public static final String APPLY_TYPE_PURCHASE = "01";// 承购
	public static final String APPLY_TYPE_IN_POOL = "02";// 入池
	public static final String APPLY_TYPE_OUT_POOL = "03";// 出池
	public static final String APPLY_TYPE_DISCOUNT = "04";// 减值
	public static final String APPLY_TYPE_REPURCHASE = "05";// 回购
	public static final String APPLY_TYPE_VERIFY = "06";// 核销
	public static final String APPLY_TYPE_INVOICE_AGE_CHANGE = "07";// 发票账龄变更
	public static final String APPLY_TYPE_REPAYMENT = "08";// 还款
	public static final String APPLY_TYPE_FLAW = "09";// 瑕疵
	public static final String APPLY_TYPE_ISSUE_SET = "10";// 商纠设定
	public static final String APPLY_TYPE_OVERDUE = "11";// 逾期
	public static final String APPLY_TYPE_BAD_DEBT = "12";// 呆账
	public static final String APPLY_TYPE_INVOICE_FINANCING = "13";// 放款
	public static final String APPLY_TYPE_POOL_FINANCING = "14";// 池融资
	public static final String APPLY_TYPE_BILL_MODIFY = "15";// 单据修改
	public static final String APPLY_TYPE_BILL_DELETE = "16";// 单据删除
	/** ---商纠解除--- */
	public static final String APPLY_TYPE_ISSUE_REMOVE = "17";// 商纠解除
	/** ---催收--- */
	public static final String APPLY_TYPE_COLLECTION = "18";// 催收
	/** ---发票费用补录--- */
	public static final String APPLY_TYPE_INVOICE_COST_RECORD = "19";// 发票费用补录
	/** ---融资展期--- */
	public static final String APPLY_TYPE_FINANCING_EXTENSION = "20";// 融资展期
	/** ---后收费用收取--- */
	public static final String APPLY_TYPE_AFTER_COST_CHARGE = "21";// 后收费用收取
	/** --保证金转入-- */
	public static final String APPLY_TYPE_DEPOSITE_TRANSFER = "22";// 保证金转入
	/** --提前还贷-- */
	public static final String APPLY_TYPE_ADVANCE_REPAYMENT = "23";// 提前还贷
	/** --担保回购-- */
	public static final String APPLY_TYPE_ASSURE_REPAYMENT = "24";// 担保回购

	public static final String VALUE_INDEX_DEBTAPPNO_ID = "DEBTAPPNO_ID";
	public static final String VALUE_INDEX_CREDITDETAIL_ID = "CREDITDETAIL_ID";
	/*** 逾期状态 */
	public static final String OVERDUE_FLAG_OVERDUE = "1";// 逾期
	public static final String OVERDUE_FLAG_NORMAL = "0";// 正常

	/*** 呆账状态 */
	public static final String BAD_FLAG_TRUE = "1";// 有
	public static final String BAD_FLAG_FALSE = "0";// 无

	/*** 额度种类 */
	public static final String CREDIT_TYPE_RELA_ASSURE = "1";// 买卖关联担保额度
	public static final String CREDIT_TYPE_FINANCING = "2";// 融资额度

	/*** 交易操作类型 */
	public static final String CREDIT_TRADE_TYPE_ENTRY = "00";// 录入
	public static final String CREDIT_TRADE_TYPE_OCCUPY = "01";// 占用
	public static final String CREDIT_TRADE_TYPE_PRE_OCCUPY = "02";// 预占用
	public static final String CREDIT_TRADE_TYPE_RECOVER = "03";// 恢复（释放）
	public static final String CREDIT_TRADE_TYPE_FREEZE = "04";// 冻结
	public static final String CREDIT_TRADE_TYPE_CHANGE = "05";// 变更
	public static final String CREDIT_TRADE_TYPE_OTHER = "06";// 其他

	/*** 还款方式 */
	public static final String RETURN_METHOD_BUYER_PAYMENT = "1";// 买方付款
	public static final String RETURN_METHOD_INDIRECT_PAYMENT = "2";// 间接还款
	public static final String RETURN_METHOD_SELLER_PAYMENT = "3";// 卖方还款
	public static final String RETURN_METHOD_ASSURE_PAYMENT = "4";// 担保付款
	public static final String RETURN_METHOD_ASSURE_COM_PAYMENT = "5";// 担保公司赔款
	/** -----催收方式-------- */
	/** -----提示付款-------- */
	public static final String DEBT_PRESS_MODE_PROMPT_PAYMENT = "1";// 提示付款
	/** -----催收-------- */
	public static final String DEBT_PRESS_MODE_COLLECTION = "2";// 催收

	/*** 尾款是否划入卖方结算户 */
	public static final String TO_SALLER_AMOUNT_TRUE = "1";// 是
	public static final String TO_SALLER_AMOUNT_FALSE = "2";// 否

	/** 尾款规则 **/
	public static final String DUE_BALANCE_RULE_TO_ACCOUNT = "1";// 入结算账户
	public static final String DUE_BALANCE_RULE_IN_RETURN_ACCOUNT = "2";// 留存回款专户

	public static final String POOL_BALANCE_RULE_TO_BAIL ="2";//入保证金账户
	public static final String POOL_BALANCE_RULE_ASSIGN ="3";//自主分配


	public static final String USED_AMUNT_ADD = "01";// 实占额度增加
	public static final String USED_AMUNT_REDUCE = "02";// 实占额度减少
	public static final String USED_AMUNT_CHANGE = "03";// 额度变更

	/*** 还款状态 */
	public static final String RETURN_STATUS_NO_PAYMENT = "01";// 未还款
	public static final String RETURN_STATUS_PART_PAYMENT = "02";// 部分还款
	public static final String RETURN_STATUS_ALL_PAYMENT = "03";// 已还款

	/*** 费用计算 */
	public static final String FEE_TYPE_PURCHASE = "01";// 承购
	public static final String FEE_TYPE_INVOICE_FINANCING = "02";// 发票融资
	public static final String FEE_TYPE_POOL_FINANCING = "03";// 池融资
	public static final String FEE_TYPE_HONOR = "04";// 信用证承付
	public static final String FEE_TYPE_DISHONOR = "05";// 信用证拒付
	public static final String FEE_TYPE_PAYMENT = "06";// 信用证付款
	public static final String FEE_TYPE_DISCREPANCY = "07";// 信用证不符点费用
	public static final String FEE_TYPE_SELLER_CREDIT_RECEIVABLE = "08";// 卖方信用证收款

	/*** 借据类型 **/
	public static final String LNCI_TYPE_DUE_BILL = "01";// 借据
	public static final String LNCI_TYPE_BANK_ACCEPTANCE_BILL = "02"; // 银承汇票
	public static final String LNCI_TYPE_WORKING_CAPITAL_LOAN = "03"; // 流动资金贷款
	public static final String LNCI_TYPE_ELEC_BANK_ACCEPTANCE_BILL = "04"; // 银承电子汇票
	public static final String LNCI_TYPE_CREDIT_PURCHASE = "05"; // 信用证承付
	/*** 借据状态 **/
	public static final String LNCI_STATUS_EFFECTIVE="1";//已生效

	/** -----展期状态-------- */
	/** -----未展期-------- */
	public static final String DEBT_DEFERSTATUS_NO = "0";// 未展期
	/** -----已展期-------- */
	public static final String debt_DEFERsTATUS_YES = "1";// 已展期
	/** -----其他-------- */
	public static final String debt_DEFERsTATUS_OTHER = "2";// 其他
	/*** 收取状态 **/
	public static final String CHARGE_STATUS_CHARGED = "1";// 1-已收，
	public static final String CHARGE_STATUS_UNCHARGED = "2";// 2-未收

	/*** 收取方式 **/
	public static final String COST_TYPE_FORMER = "1";// 1先收
	public static final String COST_TYPE_AFTER = "2";// 2 后收
	public static final String COST_TYPE_FREE = "3";// 3 免收

	/*** 融资逾期状态状态 **/
	public static final String LOAN_OVERDUE_FLAG_OVER = "1";// 1逾期
	public static final String LOAN_OVERDUE_FLAG_NORMAL = "2";// 2正常
	public static final String LOAN_OVERDUE_FLAG_EXTEND = "3";// 3展期

	public static final String COMMON_AMOUNT_ADD = "01";// 后可用额度增加
	public static final String COMMON_AMOUNT_REDUCE = "02";// 后可用额度减少
	public static final String COMMON_AMOUNT_CHANGE = "03";// 后可用额度变更
	/*** 客户角色 */
	public static final String CUST_ROLE_CREDIT_CUST = "00";// 授信客户
	public static final String CUST_ROLE_BUYER = "01";// 买方
	public static final String CUST_ROLE_SELLER = "02";// 卖方
	public static final String CUST_ROLE_BUYER_SELLER = "03";// 兼具买卖双方
	public static final String CUST_ROLE_SUPERVISE_COMPANY = "04";// 监管公司
	public static final String CUST_ROLE_ASSURE_COMPANY = "05";// 担保公司
	public static final String CUST_ROLE_FUTURE_BROKER_FIRM = "06";// 期货经济公司
	public static final String CUST_ROLE_CORE_COMPANY = "07";// 核心企业
	public static final String CUST_ROLE_THIRD_PARTY_COMPANY = "08";// 第三方平台公司
	public static final String CUST_ROLE_OTHERS = "09";// 其他
	/** 回款核销规则 **/
	public static final String PAYMENT_VERIFY_RULE_DUE_FIRST = "1";// 先到期先核销
	public static final String PAYMENT_VERIFY_RULE_AVERAGE = "2";// 平均分配核销

	/**
	 * 回款用途
	 */
	public static final String RETURN_USAGE_IN_BAILAMOUNT = "01";// 入保证金
	public static final String RETURN_USAGE_REPAY = "02";// 还贷
	public static final String RETURN_USAGE_BALANCE = "03";// 尾款
	/*** 还款类型 */
	public static final String RETURN_TYPE_INTEREST = "1"; // 利息
	public static final String RETURN_TYPE_FINANCING = "2"; // 融资
	public static final String RETURN_TYPE_PRINCIPAL_INTEREST = "3"; // 融资本息
	public static final String RETURN_TYPE_NONE = "4"; // 无
	/** 瑕疵状态 */
	public static final String FLAW_FLAG_TRUE = "1";// 有瑕疵
	public static final String FLAW_FLAG_FALSE = "0";// 无瑕疵

	/** 商纠状态 */
	public static final String ISSUE_FLAG_TPYE_TRUE = "1";// 有
	public static final String ISSUE_FLAG_TPYE_FALSE = "0";// 无

	/** 是否呆账 */
	public static final String BAD_FLAG_TYPE_TRUE = "1";// 有
	public static final String BAD_FLAG_TYPE_FALSE = "0";// 无

	/** 发票池状态 */
	public static final String POOL_FLAG_TYPE_INPOOL = "1";// 有
	public static final String POOL_FLAG_TYPE_OUTPOOL = "0";// 无

	/** 预警方式 */
	public static final String WARNING_TYPE_SOON_DUEDATE = "1";// 即将到期预警
	public static final String WARNING_TYPE_DUEDATE = "2";// 今日到期预警
	public static final String WARNING_TYPE_OVERDUE = "3";// 逾期预警

	/** 业务类型 */
	public static final String RECOVER_TYPE_TRUE = "1";// 有追索
	public static final String RECOVER_TYPE_FALSE = "2";// 无追索

	/** 合同状态 */
	public static final String MAST_CONT_STATUS_NO_EFFECT = "00"; // 失效
	public static final String MAST_CONT_STATUS_NORMAL = "01"; // 正常
	public static final String MAST_CONT_STATUS_FREEZE = "02"; // 冻结
	public static final String MAST_CONT_STATUS_APPLY_APPROVE = "03"; // 建立审批中
	public static final String MAST_CONT_STATUS_FREEZE_APPROVE = "04"; // 冻结审批中
	public static final String MAST_CONT_STATUS_OTHER = "05"; // 其他

	/** 合同类型 */
	public static final String MAST_CONT_TYPE_CHATTEL = "1"; // 动产主合同
	public static final String MAST_CONT_TYPE_FACTORING = "2"; // 保理主合同
	public static final String MAST_CONT_TYPE_RECEIVABLE = "3"; // 应收款主合同
	public static final String MAST_CONT_TYPE_FOUR_COMFIRM_WAREHOUSE = "4"; // 四方保兑仓合同

	public static final String VALUE_INDEX_DEALBASEINFO_ID = "DEALBASEINFO_ID";

	/**
	 * 通知方式 DATA_DIC.120012
	 */
	public static final String FACTORY_NOTICE_TYPE = "03";// 取得发票收妥回执
	public static final String FACTORY_ONLY_NOTICE_TYPE = "04";// 仅签收发票

	/** 合同费用收取方式DATA_DIC.120013 */
	public static final String FACTORY_CHARGE_TYPE_YEAR = "01";// 按年收费
	public static final String FACTORY_CHARGE_TYPE_NUM = "02";// 单笔收取

	/**
	 * 出账信息发货状态
	 */
	/** -- 未发货 0-- */
	public static final String SEND_STATUS_NO = "0";
	/** -- 部分发货 1-- */
	public static final String SEND_STATUS_PART = "1";
	/** -- 全部发货 2-- */
	public static final String SEND_STATUS_ALL = "2";
	/** -- 部分发货中&中间状态 3-- */
	public static final String SEND_STATUS_PART_SENDING = "3";

	/**
	 * 收货状态
	 */
	/** -- 未收货 0-- */
	public static final String RECEIVE_STATUS_UNRECEIVED = "0";
	/** -- 已收货 1-- */
	public static final String RECEIVE_STATUS_RECEIVED = "1";
	/** -- 已接车2-- */
	public static final String RECEIVE_STATUS_CAR_RECEIVED = "2";
	/** -- 已退车3-- */
	public static final String RECEIVE_STATUS_CAR_RECEDE = "3";
	/** TBL_APPLI_BUSS_DETAIL 区分发票或者池 */
	public static final String BUSS_TYPE_INVOICE = "1";// 发票
	public static final String BUSS_TYPE_POOL = "2";// 池

	// 应收账款交易类型
	public static final String DEBT_BUSS_TYPE_PLEDGE = "01";// 质押
	public static final String DEBT_BUSS_TYPE_FACTORING = "02";// 保理

	/** 保险类型 */
	public static final String INSURANCE_PROTOCOL_TYPE_2 = "2";// 保理
	public static final String INSURANCE_PROTOCOL_TYPE_4 = "4";// 四方
	public static final String INSURANCE_PROTOCOL_TYPE_5 = "5";// 三方
	public static final String INSURANCE_PROTOCOL_TYPE_6 = "6";// 监管

	/**
	 * 理赔超过最高额控制开关
	 */
	public static final String PARAM_ID_FACTORINGFLAG = "FACTORINGFLAG";// 保理参数
	public static final String PARAM_INDEX_TOPREPARATIONAMT_ALERT_FLAG = "OVER_TOP_CLAIM_FLAG";// 信保保理保险理赔最高额控制开关
	public static final String OVER_TOP_CLAIM_FLAG_ON = "1";
	public static final String OVER_TOP_CLAIM_FLAG_OFF = "0";

	/**
	 * 放款接口开关 关闭则模拟生成放款信息到借据表
	 */
	public static final String PARAM_ID_INTERFACE_FLAG = "FACTORINGFLAG";
	public static final String PARAM_INDEX_FINANCING_INTERFACE_FLAG = "FINANCING_INTER_FLAG";
	public static final String FINANCING_INTERFACE_FLAG_OFF = "0";
	public static final String FINANCING_INTERFACE_FLAG_ON = "1";


	/**EDI商纠处理报文类型*/
	public static final String EDI_DISPUTESTATUS_RESPONSE="1";//回复
	public static final String EDI_DISPUTESTATUS_REMINDER="2";//催函
	public static final String EDI_DISPUTESTATUS_SETTLED="3";//处理

	/**
	 * 国际保理使用
	 * */
	public static final String COMMON_YES = "1";
	public static final String COMMON_NO = "0";
	/**
	 * 是否允许直接联系
	 * */
	public static final String DIRECT_ALLOWED_YES ="1";
	public static final String DIRECT_ALLOWED_NO ="2";
	/**
	 * 国际保理报文DataState
	 */
	public static final String DATA_STATE_INIT = "0";	// 初始化
	public static final String DATA_STATE_PASS = "1";	// 放行
	public static final String DATA_STATE_DROP = "2";	// 放弃

	public static final String PURCHASE_FLAG_NO ="0"; //未受让
	public static final String PURCHASE_FLAG_YES ="1"; //已受让

	/**
	 * 收费时点
	 */
	public static final String LOANFEE_GETPOINT_FREE = "1";	// 自由收费
	public static final String LOANFEE_GETPOINT_LOAN = "2";	// 融资时收费
	public static final String LOANFEE_GETPOINT_RPAY = "3";	// 还款时收费

	/**
	 * 商纠发起方
	 * */
	public static final String SPONSOR_EF_SEND = "0";	// EF发起
	public static final String SPONSOR_EF_RECEIVE = "1";	// IF发起， EF接收

	/**
	 * 费用类型定义
	 */
	public static final String FEE_TYPE_S1 = "1";		// 申请费
	public static final String FEE_TYPE_S2 = "2";		// 单据处理费
	public static final String FEE_TYPE_S3 = "3";		// 额度手续费
	public static final String FEE_TYPE_S4 = "4";		// 保理费
	public static final String FEE_TYPE_S5 = "5";		// 贸易融资手续费
	public static final String FEE_TYPE_S6 = "6";		// 展期费
	public static final String FEE_TYPE_S7 = "7";		// 其他费用

	public static final String FEE_DIRECTION_EF = "1";		// EF费用
	public static final String FEE_DIRECTION_IF = "2";		// IF费用

	/**
	 * 数据状态
	 * */
	public static final String STATE_NEW = "2";
	public static final String STATE_DELETE = "3";
	public static final String STATE_EFFECTIVE = "1";

	public static final String STATE_APPLY = "5";//仅额度申请使用

	/**
	 * 额度申请状态
	 * */
	public static final String APPLY_STATE_REQUEST = "1"; //申请
	public static final String APPLY_STATE_REMINDER = "2"; //提醒
	public static final String APPLY_STATE_RESPONSE = "3"; //已回复

	/**
	 * 报文发送状态
	 * */
	public static final String SEND_STATUS_S = "1"; //发送成功
	public static final String SEND_STATUS_L = "2"; //发送失败
	public static final String SEND_STATUS_N = "3"; //未发送

	/**
	 * EDI报文功能
	 * */
	public static final String EDI_FUNC_8="8";//	2	额度决定
	public static final String EDI_FUNC_7="7";//	2	变更
	public static final String EDI_FUNC_6="6";//	2	 申请单笔额度
	public static final String EDI_FUNC_5="5";//	2	申请可循环额度
	public static final String EDI_FUNC_4="4";//	2	提醒
	public static final String EDI_FUNC_3="3";//	2	请求
	public static final String EDI_FUNC_2="2";//	2	保理协议签署
	public static final String EDI_FUNC_1="1";//	2	出口商信息
}
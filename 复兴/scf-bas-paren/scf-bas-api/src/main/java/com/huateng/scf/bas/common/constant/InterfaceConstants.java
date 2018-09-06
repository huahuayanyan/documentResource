/*
 * ==================================================================
 * The Huateng Software License
 *
 * Copyright (c) 2008-2013 TOPSCF  All rights reserved.
 * ==================================================================
 */

package com.huateng.scf.bas.common.constant;

/**
 * 接口常量
 *
 * @author <a href="mailto:xiong_xiaolong@topscf.com">xiong_xiaolong</a>
 *
 * @version Revision: 1.0 Date: 2013-7-22 下午4:56:23
 *
 */

public interface InterfaceConstants {
	/** 核心前台接口交易码常量 **/
	public static final String TXCODE_BAIL_SYNCHRONIZE = "s169";// 同步冻结保证金信息
	public static final String TXCODE_FROZEN_BAIL = "s166";// 冻结保证金
	public static final String TXCODE_CASH_PAYMENT = "s061";// 流贷还款交易
	public static final String TXCODE_ACCOUNT_TRANSFER = "s001";// 保证金转入/回款资金转账
	public static final String TXCODE_FACTORING_FEE_RECORD = "s012";// 保理费用记账
	public static final String TXCODE_ACCOUNT_QUERY_RECORDS = "s033";// 账号信息查询
	public static final String TXCODE_ACCOUNT_IN_RECORDS = "s034";// 账号入账查询
	public static final String TXCODE_BAIL_LIST_SYNCHRONIZE = "s274";// 同步冻结保证金冻结列表信息
	public static final String TXCODE_ADD_FROZEN_BAIL = "s167";// 追加冻结保证金
	public static final String TXCODE_FROZEN_BILL_BAIL = "s136";// 银承汇票冻结保证金

	/** 信贷系统接口交易码常量 **/
	public static final String TXCODE_CUSTOMER_IMPORT = "G006";// 借款企业信息引入
	public static final String TXCODE_TLR_SYNCHRONIZE = "G007";// 操作员（用户）信息同步
	public static final String TXCODE_EBANK_CASH_LOAN_APPLY = "G008";// 网银放款（流贷）申请
	public static final String TXCODE_EBANK_BILL_LOAN_APPLY = "G009";// 网银放款（银承）申请
	public static final String TXCODE_CCMS_CASH_LOAN_APPLY = "G010";// 信贷放款（流贷）申请
	public static final String TXCODE_CCMS_BILL_LOAN_APPLY = "G011";// 信贷放款（银承）申请
	public static final String TXCODE_SCF_APPROVE_RESULT = "G012";// 供应链审批结果通知
	public static final String TXCODE_CASH_LOAN_RESULT_RECEIVE = "G013";// 放款结果接收（流贷）
	public static final String TXCODE_BILL_LOAN_RESULT_RECEIVE = "G014";// 放款结果接收（银承）
	public static final String TXCODE_MAST_CONT_IMPORT = "G015";// 用信合同引入(额度项下合同)
	public static final String TXCODE_SLAVE_CONT_IMPORT = "G016";// 质押合同引入
	public static final String TXCODE_INDIRECT_CREDIT_OCCUPY = "G017";// 间接额度占用
	public static final String TXCODE_INDIRECT_CREDIT_RELEASE = "G018";// 间接额度释放
	public static final String TXCODE_CCMS_BILL_FILE_LOAN_APPLY = "G019";// 信贷放款（银承）文件申请

	/** 票据系统接口交易码常量 **/
	public static final String TXCODE_BILLS_IMPORT = "G001";// 入池票据引入
	public static final String TXCODE_BILL_IN_POOL = "G002";// 票据入池申请
	public static final String TXCODE_BILL_OUT_POOL = "G003";// 票据出池申请
	public static final String TXCODE_BILL_IN_POOL_RESULT = "G004";// 票据入池申请结果返回
	public static final String TXCODE_BILL_OUT_POOL_RESULT = "G005";// 票据出池申请结果返回

	/** ECIF系统接口交易码常量 **/
	public static final String TXCODE_ECIF_CUST_IMPORT = "F102";// ECIF客户信息引入
	public static final String TXCODE_SCF_CUST_EXPORT_TO_ECIF = "F103";// 客户信息推送到ECIF

	/** 网银系统接口交易码常量 **/
	public static final String TXCODE_TODO_TASK_LIST = "G101";// 待办任务查询
	public static final String TXCODE_LOAN_CONT_QUERY = "G102";// 放款合同查询
	public static final String TXCODE_DEBT_CONT_QUERY = "G103";// 应收账款合同查询
	public static final String TXCODE_DEBT_INSERT = "G104";// 应收账款录入
	public static final String TXCODE_DEBT_QUERY = "G105";// 应收账款查询
	public static final String TXCODE_DEBT_PURCHASE = "G106";// 应收账款转让申请
	public static final String TXCODE_DEBT_REVERSE_PURCHASE = "G107";// 应收账款反转让申请
	public static final String TXCODE_DEBT_PURCHASE_RESULT_QUERY = "G108";// 应收账款转让结果查询
	public static final String TXCODE_DEBT_PURCHASE_RESULT_CONFIRM = "G109";// 应收账款转让结果确认
	public static final String TXCODE_DEBT_DISPOSE_CONFIRM_QUERY = "G110";// 应收账款催收确认查询
	public static final String TXCODE_DEBT_DISPOSE_CONFIRM_SUBMIT = "G111";// 应收账款催收确认提交
	public static final String TXCODE_DEBT_BILL_LOAN = "G112";// 应收账款融资出账-银承
	public static final String TXCODE_DEBT_CASH_LOAN = "G113";// 应收账款融资出账-流贷
	public static final String TXCODE_DEBT_POOL_BILL_LOAN = "G114";// 应收账款池融资出账-银承
	public static final String TXCODE_DEBT_POOL_CASH_LOAN = "G115";// 应收账款池融资出账-流贷
	public static final String TXCODE_SLAVE_CONT_QUERY = "G116";// 质押合同查询
	public static final String TXCODE_MORTGAGE_QUERY = "G117";// 质物查询
	public static final String TXCODE_MORT_BILL_LOAN = "G118";// 存货质押融资融资出账-银承
	public static final String TXCODE_MORT_CASH_LOAN = "G119";// 存货质押融资融资出账-流贷
	public static final String TXCODE_MORT_PLEDGE = "G120";// 出质入库信息申请
	public static final String TXCODE_MORT_DELIVERY = "G121";// 提货申请
	public static final String TXCODE_MORT_PRICE_DECREASE_NOTICE_QUERY = "G122";// 跌价补偿通知查询
	public static final String TXCODE_MORT_PRICE_DECREASE_NOTICE_CONFIRM = "G123";// 跌价补偿确认提交
	public static final String TXCODE_THREE_BILL_LOAN = "G124";// 担保提货融资出账-银承
	public static final String TXCODE_THREE_CASH_LOAN = "G125";// 担保提货融资出账-流贷
	public static final String TXCODE_THREE_BUYCONT_QUERY = "G126";// 担保提货购销合同查询
	public static final String TXCODE_THREE_MORT_QUERY = "G127";// 担保提货押品详情查询
	public static final String TXCODE_THREE_PAYMENT_CONFIRMATION_QUERY = "G128";// 担保提货收票款确认通知
	public static final String TXCODE_THREE_PAYMENT_CONFIRMATION_RECEIPT = "G129";// 担保提货收款确认回执
	public static final String TXCODE_THREE_PRICE_DECREASE_NOTICE_QUERY = "G130";// 担保提货跌价补偿通知查询
	public static final String TXCODE_THREE_PAYMENT_CONFIRMATION_SUBMIT = "G131";// 担保提货收票/款确认提交
	public static final String TXCODE_THREE_DELIVERY = "G132";// 担保提货提货申请
	public static final String TXCODE_DELIVERY_NOTICE_QUERY = "G133";// 提货通知查询
	public static final String TXCODE_DELIVERY_NOTICE_RECEIPT = "G134";// 提货通知查询回执
	public static final String TXCODE_THREE_DELIVERY_CHECK_NOTICE_QUERY = "G135";// 担保提货发货对账通知查询
	public static final String TXCODE_THREE_DELIVERY_CHECK_NOTICE_SUBMIT = "G136";// 担保提货发货对账确认提交
	public static final String TXCODE_THREE_REFUND_NOTICE_QUERY = "G137";// 担保提货退款通知
	public static final String TXCODE_THREE_REFUND_NOTICE_CONFIRM = "G138";// 担保提货退款通知确认
	public static final String TXCODE_FOUR_BILL_LOAN = "G139";// 先票款后货融资出账-银承
	public static final String TXCODE_FOUR_CASH_LOAN = "G140";// 先票款后货融资出账-流贷
	public static final String TXCODE_FOUR_SLAVE_CONT_QUERY = "G141";// 先票款后货质押合同查询
	public static final String TXCODE_FOUR_MORT_QUERY = "G142";// 先票款后货入库押品信息详情查询
	public static final String TXCODE_FOUR_MORT_PLEDGE = "G143";// 先票款后货到货出质入库提交
	public static final String TXCODE_FOUR_MORT_DETAIL_QUERY = "G144";// 先票款后货押品信息详情查询
	public static final String TXCODE_FOUR_DELIVERY = "G145";// 先票款后货提货申请提交
	public static final String TXCODE_FOUR_DELIVERY_CHECK_NOTICE_QUERY = "G146";// 先票款后货发货对账通知查询
	public static final String TXCODE_FOUR_DELIVERY_CHECK_NOTICE_SUBMIT = "G147";// 先票款后货发货对账确认提交
	public static final String TXCODE_FOUR_REFUND_NOTICE_QUERY = "G148";// 先票款后货退款通知
	public static final String TXCODE_FOUR_REFUND_NOTICE_CONFIRM = "G149";// 先票款后货退款通知确认
	public static final String TXCODE_MORT_IMPORT = "G150";// 日常库存明细推送提交
	public static final String TXCODE_MORT_PRICE_ADJUST_NOTICE_QUERY = "G151";// 价格调整通知查询
	public static final String TXCODE_MORT_PRICE_ADJUST_NOTICE_CONFIRM = "G152";// 价格调整确认提交
	public static final String TXCODE_MORT_PLDEGE_NOTICE_QUERY = "G153";// 查复及出质确认书查询
	public static final String TXCODE_MORT_PLDEGE_NOTICE_CONFIRM = "G154";// 查复及出质确认书确认提交
	public static final String TXCODE_MORT_DELIVERY_NOTICE_QUERY = "G155";// 提货通知查询
	public static final String TXCODE_MORT_DELIVERY_NOTICE_CONFIRM = "G156";// 提货通知确认提交
	public static final String TXCODE_MORT_LOWPIRCE_NOTICE_QUERY = "G157";// 质物最低控货价值通知查询
	public static final String TXCODE_MORT_LOWPIRCE_NOTICE_CONFIRM = "G158";// 质物最低控货价值通知确认提交
	public static final String TXCODE_MORT_CHECK_ACCOUNT_QUERY = "G165";// 监管对账查询
	public static final String TXCODE_MORT_CHECK_ACCOUNT_DETAIL_QUERY = "G166";// 监管对账押品查询
	public static final String TXCODE_MORT_CHECK_ACCOUNT_CONFIRM = "G167";// 监管对账结果提交
	public static final String TXCODE_LNCI_BASE_INFO_QUERY = "G169";// 借据信息查询
	public static final String TXCODE_APPLY_LOG_INFO_QUERY = "G170";// 申请流水查询
	public static final String TXCODE_DEBT_PURCHASE_RESULT_DETAIL_QUERY = "G172";// 应收账款转让结果明细查询
	public static final String TXCODE_DEBT_DISPOSE_CONFIRM_LIST_QUERY = "G173";// 应收账款催收确认列表查询
	public static final String TXCODE_DELIVERY_NOTICE_DETAIL_QUERY = "G175";// 提货通知书明细查询
	public static final String TXCODE_MORT_PRICE_ADJUST_NOTICE_DETAIL_QUERY = "G178";//价格调整通知详情列表查询
	public static final String TXCODE_MORT_PLDEGE_NOTICE_DETAIL_QUERY = "G179";//查复及出质确认书详情列表查询
	public static final String TXCODE_DEBT_BASE_INFO_QUERY = "G185";//应收账款信息查询
	public static final String TXCODE_DEBT_REPAYMENT_INFO_QUERY = "G186";//应收账款回款查询
	public static final String TXCODE_MORTGAGE_STOCK_INFO_QUERY = "G187";//现货库存（押品）查询
	public static final String TXCODE_MORTGAGE_STOCK_LOG_QUERY = "G188";// 押品流水查询
	public static final String TXCODE_TRADE_CONT_ENTER = "G189";// 购销合同录入
	public static final String TXCODE_TRADE_MUTI_PROT_QUERY = "G190";// 担保提货/先票款后货协议查询
	public static final String TXCODE_THREE_DELIVERY_INFO_QUERY = "G191";// 提货情况查询
	public static final String TXCODE_MORT_CLASS_LEVEL_ONE_QUERY = "G198";//押品一级查询
	public static final String TXCODE_MORT_CLASS_LEVEL_TWO_QUERY = "G199";//押品二级查询
	public static final String TXCODE_ORDER_DELD_BILLS_INFO_QUERY = "G205";//交货后凭证查询
	public static final String TXCODE_ORDER_REPAYMENT_QUERY = "G206";//订单回款查询
	public static final String TXCODE_MORT_SEND_NOTICE_QUERY = "G208";// 监管物监管通知书查询/发货入库通知书
	public static final String TXCODE_MORT_SEND_NOTICE_DETAIL_QUERY = "G209";//  监管物监管通知内列表查询
	public static final String TXCODE_MORT_SEND_NOTICE_CONFIRM = "G210";// 监管物监管通知书提交
	public static final String TXCODE_MORT_CLASS_LEVEL_THREE_QUERY = "G214";//押品三级查询
	public static final String TXCODE_MORTGAGE_ENTER_CONFIRM = "G215";//现货质押押品入库录入提交
	public static final String TXCODE_FOUR_SEND_NOTICE_QUERY = "G225";//卖方发货通知查询
	public static final String TXCODE_FOUR_SEND_NOTICE_DETAIL_QUERY = "G226";//卖方发货通知货物详情查询
	public static final String TXCODE_FOUR_SEND_NOTICE_CONFIRM = "G227";//先票/款后货到货出质入库提交
	public static final String TXCODE_MORT_SEND_CHECK_NOTICE_QUERY = "G228";//监管对账确认通知查询
	public static final String TXCODE_MORT_SEND_CHECK_NOTICE_DETAIL_QUERY = "G229";//监管对账确认通知明细查询
	public static final String TXCODE_MORT_SEND_CHECK_NOTICE_CONFIRM = "G230";//监管对账确认提交
	public static final String TXCODE_DEBT_REPAYMENT_DETAIL_INFO_QUERY = "G277";//应收账款回款明细查询
	public static final String TXCODE_ORDER_REPAYMENT_DETAIL_QUERY = "G278";//订单回款明细查询
	public static final String TXCODE_REGULATORY_DEBT_PURCHASE = "T001";//出质申请

	public static final String TXCODE_MORT_BILL_NORMAL_CONFIRM = "P501";//普通仓单质押申请
	public static final String TXCODE_QUERY_CONT_BASE_CONFIRM = "P502";//主合同查询
	public static final String TXCODE_QUERY_CONT_SLAVE_CONFIRM = "P506";//查询抵质押合同
	public static final String TXCODE_QUERY_APPLY_STATUS = "P503";//查询申请状态
	public static final String TXCODE_SCFONLINE_BILL_NORMAL_CASH_LOAN_APPLY = "P507";//普通仓单流贷申请
	public static final String TXCODE_QUERY_SET_USABLE_LIMIT= "P508";//查询设置可用额度

	public static final String TXCODE_MORT_LNCI_BASE_INFO_QUERY = "P509";//借据查询
	public static final String TXCODE_MORT__BASE_INFO_QUERY = "P510";//押品查询
	public static final String TXCODE_QUERY_LOAN_REOCRD = "P511";//放款记录查询
	public static final String TXCODE_QUERY_MURT_BASE = "P512";//协议查询
	public static final String TXCODE_IFSP_MORT_DELIVERY = "P530";//提货申请
	public static final String TXCODE_IFSP_PICKUP_DELIVERY = "P515";//提货计算器
	public static final String TXCODE_IFSP_GET_AMOUNT = "P517";//收款确认
	public static final String TXCODE_CUST_ORG_CODE_QUERY = "P300";//客户查询
	public static final String TXCODE_DELIVERY_GUARANTEE_CASH_LOAN_APPLY = "P531";//担保提货融资申请（流贷）
	public static final String TXCODE_DELIVERY_GUARANTEE_BILL_LOAN_APPLY = "P529";//担保提货融资申请（银承）
	public static final String TXCODE_INCOICE_FINANCING_APPLY = "P534";//应收账款融资申请（流贷）
	public static final String TXCODE_BAIL_ADD = "P523";//保证金转入
	public static final String TXCODE_TASK_NOTICE_QRY = "P520";//担保提货-提货申请-回执确认代办任务查询
	public static final String TXCODE_TASK_NOTICE_CONFIRM = "P522";//担保提货-提货申请-回执确认
	public static final String TXCODE_TASK_NOTICE_QUERY = "P533";//担保提货-提货申请-回执确认
	public static final String TXCODE_RETURN_NOTICE_INFO = "P532";//通知书结果信息返回
	public static final String TXCODE_RETURN_STATUS = "P539";//回执状态信息返回
	public static final String TXCODE_DEBT_BASE_INFO = "P550";//应收账款还款
	public static final String TXCODE_DEBT_CONT_LIST_QUERY ="P535";//保理合同查询
	public static final String TXCODE_DEBT_TRANSFER ="P536";//保理应收账款转让
	public static final String TXCODE_FOUR_REFUND_APPLY ="P540";//担保提货差额退款
	public static final String TXCODE_FOUR_INDIRECT_CREDIT_LIST_QUERY = "P537";//间接额度查询
	public static final String TXCODE_IFSP_LNCI_REPAY ="P538";//借据还款
	public static final String TXCODE_IFSP_FINANCE_DEBT_SYN_STATUS ="P541";//应收账款融资后状态同步
	public static final String TXCODE_IFSP_NORMAL_WHR_PLEDGE_SYN="P542";//非标仓单质押回执同步信息



	/*
	  add by zhonghuabin  2013-9-2
	 */
	public static final String BILL_RESULT_FAIL = "0"; //0-失败
	public static final String BILL_RESULT_SUCCESS = "1"; //1-成功

	/**
	 * add by fengjinfu  2013-9-4
	 */
	public static final String BAIL_FREEZE_HUOBDH="01";  //货币代码  默认为：01
	public static final String BAIL_FREEZE_FREEKD="26";  //冻结种类，默认为:26
	public static final String ZHYODM = "B00228"; //行内资金转账的摘要代码

	/** 押品流水查询  操作类型常量 **/
	public static final String MORTGAGE_LOG_OPTYPE_IN = "1"; //1-出质入库
	public static final String MORTGAGE_LOG_OPTYPE_PUTIN = "2"; //2-库存清单导入
	public static final String MORTGAGE_LOG_OPTYPE_OUT = "3"; //3-出库

	/**
	 * 渠道号
	 */
	public static final String IFSP_CHANNEL = "IFSP01"; //互联网金融渠道号

	/**
	 * 交易码
	 */
	public static final String IFSP_TXN_NO_NOTICE_SYN = "NOT01011001"; //互联网金融通知书信息同步交易码
	public static final String IFSP_TXN_NO_NOTICE_SYN2 = "NOT01011002"; //互联网金融通知书信息同步交易码
	public static final String IFSP_TXN_NO_DEBT_SYN= "RPM01011007";//互联网金融应收账款状态同步

}

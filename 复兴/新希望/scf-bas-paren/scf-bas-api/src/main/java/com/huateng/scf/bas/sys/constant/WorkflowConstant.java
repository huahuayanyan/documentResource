/**
 * 
 */
package com.huateng.scf.bas.sys.constant;

/**
 * <p>
 * 工作流审批常量类
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月16日上午10:08:57
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月16日上午10:08:57              新增
 *
 *            </pre>
 */
public class WorkflowConstant {
	/**
	 * 工作流人员分配默认值
	 */
	public static final String ROLE_DEFINFE_TLRNO = "XXXXXXXX"; // 默认值分配
	public static final String CMSOPERATOR = "CMSSystem";// 分配给信贷系统
	public static final String CMS = "CMS";// 信贷系统

	/** 业务申请基础信息表-申请状态(APPLI_STATUS) **/
	public static final String APPLI_STATUS_UNSUBMIT = "00"; // 未提交（默认）
	public static final String APPLI_STATUS_SUBMITUNAPPROVE = "01"; // 已提交(未审批)
	public static final String APPLI_STATUS_APPROVED = "02"; // 已通过(审批通过)
	public static final String APPLI_STATUS_REFUSED = "03"; // 已拒绝(审批不通过)
	public static final String APPLI_STATUS_GOBACK = "04"; // 已退回(审批被退回)
	public static final String APPLI_STATUS_CCMS_AGREE = "12";// 放款通过


	/** 业务申请基础信息表-申请状态明细(APPLI_STATUS_DTL) **/
	public static final String APPLI_STATUS_DTL_WRITING = "000";// 未提交
	public static final String APPLI_STATUS_DTL_APPROVING = "001";// 已提交
	public static final String APPLI_STATUS_DTL_APPROVED = "002"; // 已通过
	public static final String APPLI_STATUS_DTL_REFUSED = "003"; // 已否决
	public static final String APPLI_STATUS_DTL_GOBACK = "004"; // 已退回
	public static final String APPLI_STATUS_DTL_BACKMODIFY = "005"; // 退回已修改
	public static final String APPLI_STATUS_DTL_BACKSUBMIT = "006"; // 修改已提交
	public static final String APPLI_STATUS_DTL_WAITCMS = "007";// 供应链提交
	public static final String APPLI_STATUS_DTL_CANCEL = "008";// 已撤销
	public static final String APPLI_STATUS_DTL_WAIT_SCF_WRITING = "010";// 供应链补录
	public static final String APPLI_STATUS_DTL_CCMS_AGREE = "012";// 放款通过

	
	/** 预付类-担保提货 **/
	public static final String PROCMODEL_THREE_LOAN_CHARGE_OFF_APPLY = "ThreeLoanChargeOffApply";// 出账申请-流贷
	public static final String PROCMODEL_THREE_BILL_APPLY = "ThreeBillChargeOffApply";// 出账申请-银承
	public static final String PROCNAME_THREE_BILL_APPLY = "ThreeBillChargeOffApply";// 出账申请-银承
	public static final String PROCMODEL_THREE_LETTER_GUARANTEE_APPLY = "ThreeLetterGuaranteeApply";// 担保提货-出账申请-融资性保函
	public static final String PROCMODEL_THREE_LETTER_GUARANTEE_NO_APPLY = "ThreeLetterGuaranteeNoApply";// 担保提货-出账申请-非融资性保函
	public static final String PROCMODEL_THREE_GUARANTEE_DISCOUNT_APPLY = "ThreeGuaranteeDiscountApply";// 担保提货-出账申请-保贴函
	public static final String PROCMODEL_THREE_CREDIT_APPLY = "ThreeCreditApply";// 担保提货-出账申请-信用证
	public static final String PROCMODEL_THREE_ACCOUNTCONFIRM_APPLY = "ThreeAccountConfirmApply";// 收款确认
	public static final String PROCMODEL_THREE_DELIVERY_APPLY = "ThreeDeliveryApply";// 提货申请
	public static final String PROCMODEL_THREE_GUA_BUYBACK_APPLY = "ThreeGuaBuybackApply";// 差额退款
	
	/** 预付类-先票/款后货  **/
	public static final String PROCNAME_FOUR_LOAN_APPLY = "FourLoanApply";// 出账申请-流贷
	public static final String PROCNAME_FOUR_LOAN_BILL_APPLY = "FourLoanBillApply";// 出账申请-银承
	public static final String PROCNAME_FOUR_LETTER_GUARANTEE_APPLY = "FourLetterGuaranteeApply";// 先票/款后货-出账申请-融资性保函
	public static final String PROCNAME_FOUR_LETTER_GUARANTEE_NO_APPLY = "FourLetterGuaranteeNoApply";// 先票/款后货-出账申请-非融资性保函
	public static final String PROCNAME_FOUR_GUARANTEE_DISCOUNT_APPLY = "FourGuaranteeDiscountApply";// 先票/款后货-出账申请-保贴函
	public static final String PROCNAME_FOUR_CREDIT_APPLY = "FourCreditApply";// 先票/款后货-出账申请-信用证
	public static final String PROCNAME_FOUR_ACCOUNT_CONFIRM_APPLY = "FourAccountConfirmApply";//收款确认
	public static final String PROCNAME_FOURHOUSEPLEDGEAPPLY = "FourhousePledgeApply";// 到货出质入库
	public static final String PROCNAME_FOURHOUSEDELIVERYAPPLY = "FourHouseDeliveryApply";// 提货申请
	public static final String PROCNAME_FOUR_GUA_BUYBACK_APPLY = "FourGuaBuybackApply";//差额退款
	public static final String PROCNAME_ONE2ONEFOURDELIVERYAPPLY = "One2OneFourDeliveryApply";// 提货申请

	
	/** 应收类-流贷 **/
	public static final String PROCNAME_INCOICE_FINANCING_APPLY = "InvoiceFinancingApply";// 应收账款融资出账申请-流贷
	public static final String APPLI_TYPE_INCOICEFINANCINGAPPLY = "3207"; // 应收账款融资发放-流贷

	/** 流程节点：申请，审批，通知书回执， 担保合同收款确认,担保合同差额退款,担保合同提货申请 */
	public static final String PROCNODE_APPLY = "Write";// 申请节点
	public static final String PROCNODE_APPROVE = "Approve";// 审批节点 【收款确认，无】
	public static final String PROCNODE_RECEIPT = "Receipt";// 通知书回执 节点
	public static final String PROCNODE_PASS = "pass";// 审批通过 结束

	public static final String PROCNODE_DUEBILLAPPLY = "Approve_DuebillApp";// 出账申请第一个节点申请节点
	
	public static final String CONFIRM_TRANSFER = "confirmTransfer";// 应收账款申请确认
	public static final String CHECK_TRANSFER = "checkTransfer";// 应收账款初审
	public static final String CHECK_TRANSFER_AGAIN = "checkTransferAgain";// 应收账款复审

	public static final String DISPUTEINVOICE_SAVE = "disputeInvoiceSetSaveTask";// 商纠登记提交
	public static final String DISPUTEINVOICE_SUBMIT = "disputeInvoiceSetSubmitTask";// 商纠登记初审

	/** 任务节点 担保合同收款确认 ,担保合同差额退款,担保合同提货申请, */
	public static final String TASKNODE_APPLY = "Write_task";// 申请节点
	public static final String TASKNODE_APPROVE = "Approve_task";// 审核节点
	/** 三方保兑仓申请类型 */
	public static final String APPLI_TYPE_THREE_CHARGEOFFAPPLI = "2111"; // 出账申请--贷款loanWays=="01"(三方保兑仓)
	public static final String APPLI_TYPE_THREE_ACCOUNTAPPLI = "2112"; // 出账申请--银承汇票loanWays=="02"(三方保兑仓)
	public static final String APPLI_TYPE_THREE_ELECACCOUNTAPPLI = "2113"; // 出账申请--银承电子汇票loanWays=="03"(三方保兑仓)
	public static final String APPLI_TYPE_THREE_BUYBACKAPPLI = "2114"; // 担保回购申请(三方保兑仓)
	public static final String APPLI_TYPE_TRIPARTITE_DELIVERY_APPLY = "2115"; // 提货申请(三方保兑仓)
	public static final String APPLI_TYPE_THREE_BILLPPLI = "2117";// 出账申请--银承（线下）
	public static final String APPLI_TYPE_THREE_LETTER_GUARANTEE_APPLY = "2130";// 担保提货-出账申请-融资性保函
	public static final String APPLI_TYPE_THREE_LETTER_GUARANTEE_NO_APPLY = "2131";// 担保提货-出账申请-非融资性保函
	public static final String APPLI_TYPE_THREE_GUARANTEE_DISCOUNT_APPLY = "2132";// 担保提货-出账申请-保贴函
	public static final String APPLI_TYPE_THREE_CREDIT_APPLY = "2133";// 担保提货-出账申请-信用证
	public static final String APPLI_TYPE_THREE_ACCOUNTCONFIRM = "2118";// 收款确认三方（线下）
	public static final String APPLI_TYPE_THREE_LOANCHARGEOFFAPPLI = "2121"; // 出账申请--贷款（线下）
	public static final String APPLI_TYPE_THREE_DELIVERYAPPLY = "2125"; // 三方保兑仓提货申请（线下）

	/** 四方申请类型（线下） */
	public static final String APPLI_TYPE_FOUR_LOAN_APPLY = "2119"; // 出账申请--贷款loanWays=="01"(四方保兑仓)
	public static final String APPLI_TYPE_FOUR_BILL_APPLY = "2120"; // 出账申请--银承汇票loanWays=="02"(四方保兑仓)
	public static final String APPLI_TYPE_FOUR_LETTER_GUARANTEE_APPLY = "2134";// 先票/款后货-出账申请-融资性保函
	public static final String APPLI_TYPE_FOUR_LETTER_GUARANTEE_NO_APPLY = "2135";// 先票/款后货-出账申请-非融资性保函
	public static final String APPLI_TYPE_FOUR_GUARANTEE_DISCOUNT_APPLY = "2136";// 先票/款后货-出账申请-保贴函
	public static final String APPLI_TYPE_FOUR_CREDIT_APPLY = "2137";// 先票/款后货-出账申请-信用证
	public static final String APPLI_TYPE_FOURHOUSEPLEDGEAPPLY = "2116"; // 四方到货出质入库
	public static final String APPLI_TYPE_FOURHOUSEDELIVERYAPPLY = "2122"; // 四方提货申请
	public static final String APPLI_TYPE_FOURACCOUNTCONFIRMAPPLY = "2123"; // 四方收款确认
	public static final String APPLI_TYPE_FOURGUARANTEEBUYBACKAPPLY = "2124"; // 差额退款
	public static final String APPLI_TYPE_FOURHOUSEUPDELIVERYAPPLY = "2126";// 四方核心厂商提货

	/** 应收类-应收账款池融资 **/
	public static final String PROCNAME_FACTORING_POOL_AANWINST_APPLY = "FactoringPoolAanwinstApply";// 应收账款池融资转让/出质申请
	public static final String PROCNAME_ALLOWANCE_POOL_APPLY = "AllowancePoolApply";// 应收账款池融资减值申请
	// "DisputePoolInvoiceSetApply";应收账款池融资商业纠纷登记申请
	public static final String PROCNAME_DISPUTE_POOL_INVOICE_SET_APPLY = "PoolDisputeInvoiceReg";// 应收账款池融资商业纠纷登记申请
	public static final String PROCNAME_DISPUTE_POOL_INVOIC_REMOVE_APPLY = "DisputePoolInvoicRemoveApply";// 应收账款池融资商业纠纷登记解除申请
	public static final String PROCNAME_ACCOUNTS_RECEIVABLE_INPOOL_APPLY = "AccountsReceivableInPool";// 应收账款池融资入池申请
	public static final String PROCNAME_ACCOUNTS_RECEIVABLE_OUTPOOL_APPLY = "AccountsReceivableOutPool";// 应收账款池融资出池申请
	public static final String PROCNAME_FINANCING_POOL_APPLY = "FinancingPoolApply";// 应收账款池融资出账申请-流贷
	public static final String PROCNAME_FINANCING_POOL_BILL_APPLY = "FinancingPoolBillApply";// 应收账款池融资出账申请-银承
	public static final String PROCNAME_FINANCING_POOL_LETTER_GUARANTEE_APPLY = "FinancingPoolLetterGuaranteeApply";// 应收账款池融资出账申请-融资性保函
	public static final String PROCNAME_FINANCING_POOL_LETTER_GUARANTEE_NO_APPLY = "FinancingPoolLetterGuaranteeNoApply";// 应收账款池融资出账申请-非融资性保函
	public static final String PROCNAME_FINANCING_POOL_GUARANTEE_DISCOUNT_APPLY = "FinancingPoolGuaranteeDiscountApply";// 应收账款池融资出账申请-保贴函
	public static final String PROCNAME_FINANCING_POOL_CREDIT_APPLY = "FinancingPoolCreditApply";// 应收账款池融资出账申请-信用证
	public static final String PROCNAME_FACTORING_POOL_PAYMENT_APPLY = "FactoringPoolPaymentApply";// 应收账款池融资回款申请
	public static final String PROCNAME_BILL_POOL_PAYMENT_REG_QRY = "billPoolPaymentRegQry";// 应收账款池融资
																							// 票据登记
	public static final String PROCNAME_DEBT_POOL_RETURN_ACC_TRANSFER_APPLY = "PoolReturnAccTransferApply";// 应收账款池融资回款专户转账申请
	public static final String PROCNAME_FACTORING_POOL_CHARGEOFF_APPLY = "FactoringDebtPoolChargeOffApply";// 应收账款池融资核销申请
	public static final String PROCNAME_FACTORING_POOL_CANCEL_APPLY = "FactoringPoolChargeOffApply";// 应收账款池融资核销申请(配置版)
	public static final String PROCNAME_FACTORING_POOL_BUYBACK_APPLY = "FactoringPoolBuyBackApply";// 应收账款池融资反转让/解质申请
	public static final String PROCNAME_DEBT_POOL_PRESSING_APPLY = "DebtPoolPressingApply";// 应收账款池融资催收申请
	public static final String PROCNAME_DEBT_POOL_BILL_REPAY_WRITEOFF_APPLY = "DPBillRepayWriteOffApply";// 应收池融资
																											// 票据回款销记
	// public static final String POOLDISPUTEINVOICESUBMITTASK =
	// "PoolDisputeInvoiceSubmitTask";// 商纠登记初审
	public static final String POOLDISPUTEINVOICESUBMITTASK = "write_task";// 商纠登记初审

	/** 应收账款融资申请类型 */
	public static final String APPLI_TYPE_AFTERCHARGETOCOLLECTAPPLY = "3222";// 后收费用收取申请
	public static final String APPLI_TYPE_INVOICEFEESUPPLEMENTAPPLY = "3221";// 发票费用补录申请
	public static final String APPLI_TYPE_FINANINGEXTENSIONAPPLY = "3220";// 融资展期申请
	public static final String APPLI_TYPE_DISPUTEINVOICREMOVEAPPLY = "3218";// 商业纠纷解除申请
	public static final String APPLI_TYPE_DISPUTEINVOICESETAPPLY = "3217";// 商业纠纷设定申请
	public static final String APPLI_TYPE_BILLSINSURANCEPAYMENTAPPLY = "3216";// 发票融资保险公司赔款申请
	public static final String APPLI_TYPE_BILLSVENDORPAYMENTAPPLY = "3215"; // 发票资卖方还款申请(国内保理)
	public static final String APPLI_TYPE_BILLSASSUREPAYMENTAPPLY = "3214";// 发票融资担保付款申请
	public static final String APPLI_TYPE_BILLSASSUREPAYMENTBILLAPPLY = "3264";// 发票融资担保付款申请--银承
	public static final String APPLI_TYPE_BILLSINDIRECTPAYMENTAPPLY = "3213";// 发票融资间接付款申请
	public static final String APPLI_TYPE_BILLSINDIRECTPAYMENTBILLAPPLY = "3263";// 发票融资间接付款申请--银承
	public static final String APPLI_TYPE_BILLSBUYERPAYMENTAPPLY = "3212"; // 发票融资买方还款申请(国内保理)
	public static final String APPLI_TYPE_BILLSBUYERPAYMENTBILLAPPLY = "3262"; // 发票融资买方还款申请(国内保理)-银承
	public static final String APPLI_TYPE_POOLSELLERPAYAPPLY = "3211"; // 池融资卖方还款申请(国内保理)
	public static final String APPLI_TYPE_POOLASSUREPAYMENTAPPLY = "3210"; // 池融资担保付款申请(国内保理)
	public static final String APPLI_TYPE_POOLINDIRECTPAYMENTAPPLY = "3209"; // 池融资间接付款申请(国内保理)
	public static final String APPLI_POOL_TYPE_BUYERPAYMENTAPPLY = "3208"; // 池融资买方还款申请(国内保理)
	public static final String APPLI_TYPE_INCOICEFINANCINGBILLAPPLY = "3257"; // 应收账款融资发放-银承
	public static final String APPLI_TYPE_INCOICE_FINANCING_LETTER_GUARANTEE_APPLY = "3275";// 应收账款融资出账申请-融资性保函
	public static final String APPLI_TYPE_INCOICE_FINANCING_LETTER_GUARANTEE_NO_APPLY = "3276";// 应收账款融资出账申请-非融资性保函
	public static final String APPLI_TYPE_INCOICE_FINANCING_GUARANTEE_DISCOUNT_APPLY = "3277";// 应收账款融资出账申请-保贴函
	public static final String APPLI_TYPE_INCOICE_FINANCING_CREDIT_APPLY = "3278";// 应收账款融资出账申请-信用证
	public static final String APPLI_TYPE_FINANCINGPOOLAPPLY = "3206"; // 应收账款池融资发放-流贷
	public static final String APPLI_TYPE_BILLREPAYTAK = "3288";// 票据回款取票
	public static final String APPLI_TYPE_BILLPOOLREPAYTAK = "3290";// 池融资票据回款取票
	public static final String APPLI_TYPE_DEBTPOOL_BILLREPAY_REG = "3291";// 池融资票据回款登记
	public static final String APPLI_TYPE_DEBTPOOL_BILLREPAY_WRITEOFAPPLY = "3292";// 池融资票据回款销记
	public static final String APPLI_TYPE_FINANCINGPOOLBILLAPPLY = "3268";// 应收账款池融资发放-银承
	public static final String APPLI_TYPE_FINANCING_POOL_LETTER_GUARANTEE_APPLY = "3279";// 应收账款池融资出账申请-融资性保函
	public static final String APPLI_TYPE_FINANCING_POOL_LETTER_GUARANTEE_NO_APPLY = "3280";// 应收账款池融资出账申请-非融资性保函
	public static final String APPLI_TYPE_FINANCING_POOL_GUARANTEE_DISCOUNT_APPLY = "3281";// 应收账款池融资出账申请-保贴函
	public static final String APPLI_TYPE_FINANCING_POOL_CREDIT_APPLY = "3282";// 应收账款池融资出账申请-信用证
	public static final String APPLI_TYPE_FACTORINGACCOUNTCANCELAPPLY = "3205"; // 应收账款核销申请(国内保理)
	public static final String APPLI_TYPE_FACTORINGACCOUNTREPURAPPLY = "3204"; // 应收账款回购申请(国内保理)
	public static final String APPLI_TYPE_ALLOWANCEAPPLY = "3203"; // 应收账款折让申请(国内保理)
	public static final String APPLI_TYPE_RECEIVABLEMODIFYAPPLY = "3202"; // 应收账款变更申请(国内保理)
	public static final String APPLI_TYPE_FACTORINGAANWINSTAPPLY = "3201"; // 应收账款转让申请(国内保理)
	public static final String APPLI_TYPE_CASHPAYMENTAPPLY = "3223";// 现金回款处理
	public static final String APPLI_TYPE_BILL_REPAY_REG_APPLY = "3189";// 票据回款登记
	public static final String APPLI_TYPE_BILL_REPAY_WRITEOFF_APPLY = "3289";// 票据回款销记
	public static final String APPLI_TYPE_DEBT_REPAY_ACC_TRANSFER_APPLY = "3405";// 回款专户转账
	public static final String APPLI_TYPE_DEBTPRESSINGAPPLY = "3224"; // 应收账款融资催收
	public static final String APPLI_TYPE_DEBTPOOLPRESSINGAPPLY = "3225"; // 应收账款池融资催收
	public static final String APPLI_TYPE_DEBTCREDITPRESSINGAPPLY = "3226";// 信保保理催收
	public static final String APPLI_TYPE_DEBTDOUBLEPRESSINGAPPLY = "3227";// 双保理催收
	public static final String APPLI_TYPE_DEBTLEASEPRESSINGAPPLY = "3228"; // 租赁保理催收
	public static final String APPLI_TYPE_ALLOWANCEPOOLAPPLY = "3229"; // 应收账款池融资折让
	public static final String APPLI_TYPE_ALLOWANCECREDITAPPLY = "3230";// 信保保理折让
	public static final String APPLI_TYPE_ALLOWANCEDOUBLEAPPLY = "3231";// 双保理折让
	public static final String APPLI_TYPE_ALLOWANCELEASEAPPLY = "3232"; // 租赁保理折让
	public static final String APPLI_TYPE_DISPUTEPOOLINVOICESETAPPLY = "3233"; // 应收账款池融资商纠
	public static final String APPLI_TYPE_DISPUTECREDITINVOICESETAPPLY = "3234";// 信保保理商纠
	public static final String APPLI_TYPE_DISPUTEDOUBLEINVOICESETAPPLY = "3235";// 双保理商纠
	public static final String APPLI_TYPE_DISPUTELEASEINVOICESETAPPLY = "3236";// 租赁保理商纠
	public static final String APPLI_TYPE_DISPUTEPOOLINVOICREMOVEAPPLY = "3237"; // 应收账款池融资商纠解除
	public static final String APPLI_TYPE_DISPUTECREDITINVOICREMOVEAPPLY = "3238";// 信保保理商纠解除
	public static final String APPLI_TYPE_DISPUTEDOUBLEINVOICREMOVEAPPLY = "3239";// 双保理商纠解除
	public static final String APPLI_TYPE_DISPUTELEASEINVOICREMOVEAPPLY = "3240";// 租赁保理商纠解除
	public static final String APPLI_TYPE_FACTORING_CREDIT_PAYMENT_APPLY = "3241";// 信保回款
	public static final String APPLI_TYPE_FACTORING_DOUBLE_PAYMENT_APPLY = "3242";// 双保理回款
	public static final String APPLI_TYPE_FACTORING_LEASE_PAYMENT_APPLY = "3243";// 租赁保理回款
	public static final String APPLI_TYPE_POOL_REPAY_ACC_TRANSFER_APPLY = "3244";// 应收账款池
																					// 回款专户转账
	public static final String APPLI_TYPE_FACTORING_CREDIT_REPAY_ACC_TRANSFER_APPLY = "3245";// 信保回款专户转账
	public static final String APPLI_TYPE_FACTORING_DOUBLE_REPAY_ACC_TRANSFER_APPLY = "3246";// 双保理回款专户转账
	public static final String APPLI_TYPE_FACTORING_LEASE_REPAY_ACC_TRANSFER_APPLY = "3247";// 租赁回款专户转账
	public static final String APPLI_TYPE_FACTORING_CREDIT_AANWINST_APPLY = "3248";// 信保保理转让申请
	public static final String APPLI_TYPE_FACTORING_DOUBLE_AANWINST_APPLY = "3249";// 双保理转让申请
	public static final String APPLI_TYPE_FACTORING_LEASE_AANWINST_APPLY = "3250";// 租赁保理转让申请
	public static final String APPLI_TYPE_FACTORING_CREDIT_INSURANCE_REPARATION_APPLY = "3251";// 信保保险公司赔款
	public static final String APPLI_TYPE_FACTORING_DOUBLE_FACTOR_REPARATION_APPLY = "3252";// 国内双保理保理商赔款申请
	public static final String APPLI_TYPE_FACTORING_CREDIT_BUY_BACK_APPLY = "3253";// 信保保理反转让
	public static final String APPLI_TYPE_FACTORING_DOUBLE_BUY_BACK_APPLY = "3254";// 双保理反转让
	public static final String APPLI_TYPE_FACTORING_LEASE_BUY_BACK_APPLY = "3255";// 租赁保理反转让
	public static final String APPLI_TYPE_FACTORING_DEBT_CREDIT_CHARGE_OFF_APPLY = "3256";// 信保保理核销
	public static final String APPLI_TYPE_FACTORING_DEBT_DOUBLE_CHARGE_OFF_APPLY = "3257";// 双保理核销
	public static final String APPLI_TYPE_FACTORING_DEBT_LEASE_CHARGE_OFF_APPLY = "3258";// 租赁保理核销
	public static final String APPLI_TYPE_FACTORING_SETTLE_CLAIM_APPLY = "3259";// 国内双保理理赔申请
	public static final String APPLI_TYPE_FACTORING_SETTLE_CLAIM_MODIFY_APPLY = "3260";// 国内双保理理赔变更
	public static final String APPLI_TYPE_INSURANCE_SETTLE_CLAIM_APPLY = "3261";// 保险理赔申请-信保保理
	public static final String APPLI_TYPE_INSURANCE_SETTLE_CLAIM_MODIFY_APPLY = "3265";// 保险理赔变更-信保保理
	public static final String APPLI_TYPE_ACCOUNTS_RECEIVABLE_INPOOL_APPLY = "3266";// 应收账款入池
	public static final String APPLI_TYPE_ACCOUNTS_RECEIVABLE_OUTPOOL_APPLY = "3267";// 应收账款出池
	public static final String APPLI_TYPE_DOUBLE_FACT_FINANCING_APPLY = "3269";// 行内双保理融资发放-流贷
	public static final String APPLI_TYPE_DOUBLE_FACT_FINANCING_BILL_APPLY = "3270";// 行内双保理融资发放-银承
	public static final String APPLI_TYPE__DOUBLE_FACT_LETTER_GUARANTEE_APPLY = "3283";// 国内双保理出账申请-融资性保函
	public static final String APPLI_TYPE__DOUBLE_FACT_LETTER_GUARANTEE_NO_APPLY = "3294";// 国内双保理出账申请-非融资性保函
	public static final String APPLI_TYPE__DOUBLE_FACT_GUARANTEE_DISCOUNT_APPLY = "3295";// 国内双保理出账申请-保贴函
	public static final String APPLI_TYPE__DOUBLE_FACT_CREDIT_APPLY = "3296";// 国内双保理出账申请-信用证
	public static final String APPLI_TYPE_CREDIT_FACT_FINANCING_APPLY = "3271";// 信保保理融资发放-流贷
	public static final String APPLI_TYPE_CREDIT_FACT_FINANCING_BILL_APPLY = "3272";// 信保保理融资发放-银承
	public static final String APPLI_TYPE_CREDIT_FACT_LETTER_GUARANTEE_APPLY = "3297";// 信保保理出账申请-融资性保函
	public static final String APPLI_TYPE_CREDIT_FACT_LETTER_GUARANTEE_NO_APPLY = "3298";// 信保保理出账申请-非融资性保函
	public static final String APPLI_TYPE_CREDIT_FACT_GUARANTEE_DISCOUNT_APPLY = "3299";// 信保保理出账申请-保贴函
	public static final String APPLI_TYPE_CREDIT_FACT_CREDIT_APPLY = "3300";// 信保保理出账申请-信用证
	public static final String APPLI_TYPE_LEASE_FACT_FINANCING_APPLY = "3273";// 租赁保理融资发放-流贷
	public static final String APPLI_TYPE_LEASE_FACT_FINANCING_BILL_APPLY = "3274";// 租赁保理融资发放-银承
	public static final String APPLI_TYPE_LEASE_FACT_LETTER_GUARANTEE_APPLY = "3301";// 租赁保理出账申请-融资性保函
	public static final String APPLI_TYPE_LEASE_FACT_LETTER_GUARANTEE_NO_APPLY = "3302";// 租赁保理出账申请-非融资性保函
	public static final String APPLI_TYPE_LEASE_FACT_GUARANTEE_DISCOUNT_APPLY = "3303";// 租赁保理出账申请-保贴函
	public static final String APPLI_TYPE_LEASE_FACT_CREDIT_APPLY = "3304";// 租赁保理出账申请-信用证
	public static final String APPLI_TYPE_FACTORING_POOL_BUYBACK = "3284"; // 应收账款反转让申请(池)
	public static final String APPLI_TYPE_FACTORING_POOL_CHARGEOFF = "3285"; // 应收账款核销申请(池)
	public static final String APPLI_TYPE_FACTORING_POOL_PAYMENT_APPLY = "3286";// 应收账款池融资
																				// 回款申请
	public static final String APPLI_TYPE_FACTORING_POOL_AANWINST_APPLY = "3287";// 应收账款池转让申请

	/** 应收类-租赁保理 **/
	public static final String PROCNAME_FACTORING_LEASE_AANWINST_APPLY = "FactoringLeaseAanwinstApply";// 应收租金转让申请
	public static final String PROCNAME_ALLOWANCE_LEASE_APPLY = "AllowanceLeaseApply";// 应收租金减值申请
	public static final String PROCNAME_DISPUTE_LEASE_INVOICE_SET_APPLY = "DisputeLeaseInvoiceSetApply";// 租赁保理商业纠纷登记申请
	public static final String PROCNAME_DISPUTE_LEASE_INVOIC_REMOVE_APPLY = "DisputeLeaseInvoicRemoveApply";// 租赁保理商业纠纷登记解除申请
	public static final String PROCNAME_LEASE_FACT_FINANCING_APPLY = "LeaseFactFinancingApply";// 租赁保理出账申请-流贷
	public static final String PROCNAME_LEASE_FACT_LETTER_GUARANTEE_APPLY = "LeaseFactLetterGuaranteeApply";// 租赁保理出账申请-融资性保函
	public static final String PROCNAME_LEASE_FACT_LETTER_GUARANTEE_NO_APPLY = "LeaseFactLetterGuaranteeNoApply";// 租赁保理出账申请-非融资性保函
	public static final String PROCNAME_LEASE_FACT_GUARANTEE_DISCOUNT_APPLY = "LeaseFactGuaranteeDiscountApply";// 租赁保理出账申请-保贴函
	public static final String PROCNAME_LEASE_FACT_CREDIT_APPLY = "LeaseFactCreditApply";// 租赁保理出账申请-信用证
	public static final String PROCNAME_LEASE_FACT_FINANCING_BILL_APPLY = "LeaseFactFinancingBillApply";// 租赁保理出账申请-银承
	public static final String PROCNAME_PAYMENT_LEASE_APPLY = "FactoringLeasePaymentApply";// 应收租金回款申请
	public static final String PROCNAME_FACTORING_LEASE_RETURN_ACC_TRANSFER_APPLY = "LeaseReturnAccTransferApply";// 租赁保理回款专户转账申请
	public static final String PROCNAME_FACTORING_DEBT_LEASE_CHARGE_OFF_APPLY = "FactoringDebtLeaseChargeOffApply";// 应收租金核销申请
	public static final String PROCNAME_FACTORING_LEASE_BUY_BACK_APPLY = "FactoringLeaseBuyBackApply";// 应收租金反转让申请
	public static final String PROCNAME_DEBT_LEASE_PRESSING_APPLY = "DebtLeasePressingApply";// 应收租金催收申请
	
	public static final String PROCNAME_FACTORING_LEASE_CHARGE_OFF_APPLY = "FactoringLeaseChargeOffApply";// 应收租金核销申请(应收类配置)

	/** 应收类-信保保理 **/
	public static final String PROCNAME_FACTORING_CREDIT_AANWINST_APPLY = "FactoringCreditAanwinstApply";// 信保保理应收账款转让申请
	public static final String PROCNAME_ALLOWANCE_CREDIT_APPLY = "AllowanceCreditApply";// 信保保理应收账款减值申请
	public static final String PROCNAME_DISPUTE_CREDIT_INVOICE_SET_APPLY = "DisputeCreditInvoiceSetApply";// 信保保理商业纠纷登记申请
	public static final String PROCNAME_DISPUTE_CREDIT_INVOIC_REMOVE_APPLY = "DisputeCreditInvoicRemoveApply";// 信保保理商业纠纷登记解除申请
	public static final String PROCNAME_CREDIT_FACT_FINANCING_APPLY = "CreditFactFinancingApply";// 信保保理出账申请-流贷
	public static final String PROCNAME_CREDIT_FACT_FINANCING_BILL_APPLY = "CreditFactFinancingBillApply";// 信保保理出账申请-银承
	public static final String PROCNAME_CREDIT_FACT_LETTER_GUARANTEE_APPLY = "CreditFactLetterGuaranteeApply";// 信保保理出账申请-融资性保函
	public static final String PROCNAME_CREDIT_FACT_LETTER_GUARANTEE_NO_APPLY = "CreditFactLetterGuaranteeNoApply";// 信保保理出账申请-非融资性保函
	public static final String PROCNAME_CREDIT_FACT_GUARANTEE_DISCOUNT_APPLY = "CreditFactGuaranteeDiscountApply";// 信保保理出账申请-保贴函
	public static final String PROCNAME_CREDIT_FACT_CREDIT_APPLY = "CreditFactCreditApply";// 信保保理出账申请-信用证
	public static final String PROCNAME_PAYMENT_CREDIT_APPLY = "FactoringCreditPaymentApply";// 信保保理应收账款回款申请
	public static final String PROCNAME_INSURANCE_SETTLE_CLAIM_APPLY = "InsuranceSettleClaimApply";// 保险理赔申请
	public static final String PROCNAME_INSURANCE_SETTLE_CLAIM_MODIFY_APPLY = "InsuranceSettleClaimModifyApply";// 保险理赔变更申请
	public static final String PROCNAME_FACTORING_CREDIT_INSURANCE_REPARATION_APPLY = "CreditInsuranceReparationApply";// 保险公司赔款申请
	public static final String PROCNAME_FACTORING_CREDIT_RETURN_ACC_TRANSFER_APPLY = "CreditReturnAccTransferApply";// 信保保理回款专户转账申请
	public static final String PROCNAME_FACTORING_DEBT_CREDIT_CHARGE_OFF_APPLY = "FactoringDebtCreditChargeOffApply";// 信保保理应收账款核销申请
	public static final String PROCNAME_FACTORING_CREDIT_BUY_BACK_APPLY = "FactoringCreditBuyBackApply";// 信保保理应收账款反转让申请
	public static final String PROCNAME_DEBT_CREDIT_PRESSING_APPLY = "DebtCreditPressingApply";// 信保保理应收账款催收申请

	public static final String PROCNAME_FACTORING_CREDIT_CHARGE_OFF_APPLY = "FactoringCreditChargeOffApply";// 信保保理应收账款核销申请（应收类配置）

	/** 应收类-应收账款融资 **/

	public static final String PROCNAME_FACTORING_AANWINST_APPLY = "FactoringAanwinstApply";// 应收账款融资转让/出质申请
	public static final String PROCNAME_ALLOWANCE_APPLY = "AllowanceApply";// 应收账款融资减值申请
	public static final String PROCNAME_BILL_REPAY_TAK = "BillRepayTak";// 应收账款融资票据回款取票申请
	public static final String PROCNAME_BILL_POOL_REPAY_TAK = "BillPoolRepayTak";// 应收账款池融资票据回款取票申请
	public static final String PROCNAME_DISPUTE_INVOICE_SET_APPLY = "DisputeInvoiceSetApply";// 应收账款融资商业纠纷登记申请
	public static final String PROCNAME_DISPUTE_INVOIC_REMOVE_APPLY = "DisputeInvoicRemoveApply";// 应收账款融资商业纠纷登记解除申请
	public static final String PROCNAME_INCOICE_FINANCING_BILL_APPLY = "InvoiceFinancingBillApply";// 应收账款融资出账申请-银承
	public static final String PROCNAME_INCOICE_FINANCING_LETTER_GUARANTEE_APPLY = "InvoiceFinancingLetterGuaranteeApply";// 应收账款融资出账申请-融资性保函
	public static final String PROCNAME_INCOICE_FINANCING_LETTER_GUARANTEE_NO_APPLY = "InvoiceFinancingLetterGuaranteeNoApply";// 应收账款融资出账申请-非融资性保函
	public static final String PROCNAME_INCOICE_FINANCING_GUARANTEE_DISCOUNT_APPLY = "InvoiceFinancingGuaranteeDiscountApply";// 应收账款融资出账申请-保贴函
	public static final String PROCNAME_INCOICE_FINANCING_CREDIT_APPLY = "InvoiceFinancingCreditApply";// 应收账款融资出账申请-信用证
	public static final String PROCNAME_CASH_PAYMENT_APPLY = "CashPaymentApply";// 应收账款融资回款申请
	public static final String PROCNAME_BILL_PAYMENT_REG_QRY = "billPaymentRegQry";// 应收账款融资
																					// 票据登记
	public static final String PROCNAME_DEBT_REPAY_ACC_TRANSFER_APPLY = "ReversePaymentTransferApply";// 应收账款融资回款专户转账申请
	public static final String PROCNAME_FACTORING_ACCOUNTCANCEL_APPLY = "FactoringAccountCancelApply";// 应收账款融资核销申请
	public static final String PROCNAME_FACTORING_ACCOUNTREPUR_APPLY = "FactoringAccountRepurApply";// 应收账款融资反转让/解质申请
	public static final String PROCNAME_DEBT_PRESSING_APPLY = "DebtPressingApply";// 应收账款融资催收申请
	public static final String PROCNAME_BILL_REPAY_WRITEOFF_APPLY = "BillRepayWriteoffApply";// 应收账款融资
																								// 票据销记

	/** 应收类-国内双保理 **/
	public static final String PROCNAME_FACTORING_DOUBLE_AANWINST_APPLY = "FactoringDoubleAanwinstApply";// 国内双保理应收账款转让申请
	public static final String PROCNAME_ALLOWANCE_DOUBLE_APPLY = "AllowanceDoubleApply";// 国内双保理应收账款减值申请
	public static final String PROCNAME_DISPUTE_DOUBLE_INVOICE_SET_APPLY = "DisputeDoubleInvoiceSetApply";// 国内双保理商业纠纷登记申请
	public static final String PROCNAME_DISPUTE_DOUBLE_INVOIC_REMOVE_APPLY = "DisputeDoubleInvoicRemoveApply";// 国内双保理商业纠纷登记解除申请
	public static final String PROCNAME_DOUBLE_FACT_FINANCING_APPLY = "DoubleFactFinancingApply";// 国内双保理出账申请-流贷
	public static final String PROCNAME_DOUBLE_FACT_FINANCING_BILL_APPLY = "DoubleFactFinancingBillApply";// 国内双保理出账申请-银承
	public static final String PROCNAME_DOUBLE_FACT_LETTER_GUARANTEE_APPLY = "DoubleFactLetterGuaranteeApply";// 国内双保理出账申请-融资性保函
	public static final String PROCNAME_DOUBLE_FACT_LETTER_GUARANTEE_NO_APPLY = "DoubleFactLetterGuaranteeNoApply";// 国内双保理出账申请-非融资性保函
	public static final String PROCNAME_DOUBLE_FACT_GUARANTEE_DISCOUNT_APPLY = "DoubleFactGuaranteeDiscountApply";// 国内双保理出账申请-保贴函
	public static final String PROCNAME_DOUBLE_FACT_CREDIT_APPLY = "DoubleFactCreditApply";// 国内双保理出账申请-信用证
	public static final String PROCNAME_PAYMENT_DOUBLE_APPLY = "FactoringDoublePaymentApply";// 国内双保理应收账款回款申请
	public static final String PROCNAME_FACTORING_SETTLE_CLAIM_APPLY = "FactoringSettleClaimApply";// 保理理赔申请
	public static final String PROCNAME_FACTORING_SETTLE_CLAIM_MODIFY_APPLY = "FactoringSettleClaimModifyApply";// 保理理赔变更申请
	public static final String PROCNAME_FACTORING_DOUBLE_FACTOR_REPARATION_APPLY = "DoubleFactorReparationApply";// 保理商赔款申请
	public static final String PROCNAME_FACTORING_DOUBLE_RETURN_ACC_TRANSFER_APPLY = "DoubleReturnAccTransferApply";// 国内双保理回款专户转账申请
	public static final String PROCNAME_FACTORING_DEBT_DOUBLE_CHARGE_OFF_APPLY = "FactoringDebtDoubleChargeOffApply";// 国内双保理应收账款核销申请
	public static final String PROCNAME_FACTORING_DOUBLE_BUY_BACK_APPLY = "FactoringDoubleBuyBackApply";// 国内双保理应收账款反转让申请
	public static final String PROCNAME_DEBT_DOUBLE_PRESSING_APPLY = "DebtDoublePressingApply";// 国内双保理应收账款催收申请

	public static final String PROCNAME_FACTORING_DOUBLE_CHARGE_OFF_APPLY = "FactoringDoubleChargeOffApply";// 国内双保理应收账款核销申请（应收类配置）

	/** 现货类-动产质押 */
	public static final String PROCNAME_DYNAMICQUALITYAPPLY = "DynamicQualityApply";// 动产融资出质入库（动态）申请
	public static final String PROCNAME_STATICQUALITYAPPLY = "StaticQualityApply";// 动产融资出质入库（静态）申请
	public static final String PROCNAME_MORTGAGECASHLOANAPPLY = "MortgageCashLoanApply"; // 动产-放款申请-流贷
	public static final String PROCNAME_MORTGAGEBILLLOANAPPLY = "MortgageBillLoanApply"; // 动产-放款申请-银承
	public static final String PROCNAME_MORTGAGE_LETTER_GUARANTEE_APPLY = "MortgageLetterGuaranteeApply";// 动产-放款申请-融资性保函
	public static final String PROCNAME_MORTGAGE_LETTER_GUARANTEE_NO_APPLY = "MortgageLetterGuaranteeNoApply";// 动产-放款申请-非融资性保函
	public static final String PROCNAME_MORTGAGE_GUARANTEE_DISCOUNT_APPLY = "MortgageGuaranteeDiscountApply";// 动产-放款申请-保贴函
	public static final String PROCNAME_MORTGAGE_CREDIT_APPLY = "MortgageCreditApply";// 动产-放款申请-信用证
	public static final String PROCNAME_PROTOCOL_AMOUNT_APPLY = "ProtocolAmountApply";// 最低控货价值调整申请
	public static final String PROCNAME_PRICEADJUSTAPPLY = "PriceAdjustApply";// 押品价格调整申请
	public static final String PROCNAME_STOCK_LIST_IMPORT_APPLY = "StockListImportApply";// 动产动态库存清单导入申请
	public static final String PROCNAME_MULTIPRICEADJUSTAPPLY = "MultiPriceAdjustApply"; // 批量质物价格调整申请
	public static final String PROCNAME_MULTIPRICEADJUSTAPPLYXHJT = "MultiPriceAdjustApplyXhjt"; // (现货静态)批量质物价格调整申请
	public static final String PROCNAME_MULTIPRICEADJUSTAPPLYXHDT = "MultiPriceAdjustApplyXhdt"; // (现货动态)批量质物价格调整申请

	public static final String PROCNAME_E_DELIVERYAPPLY = "DeliveryApply"; // 提货申请	现货静态

	/** 动产 */
	public static final String APPLI_TYPE_DYNAMIC_QUALITY_APPLY = "1101"; // 动产融资出质入库（动态）申请
	public static final String APPLI_TYPE_STATIC_QUALITY_APPLY = "1102"; // 动产融资出质入库（静态）申请
	public static final String APPLI_TYPE_LOAN_APPLY = "1103"; // 动产融资放款申请
	public static final String APPLI_TYPE_EXCHANGEAPPLI = "1104"; // 动产融资换货申请
	public static final String APPLI_TYPE_DELIVERYAPPLI = "1105"; // 动产融资提货申请
	public static final String APPLI_TYPE_MORTGAGE_APPEND_APPLY = "1106";// 动产融资追加质物
	public static final String APPLI_TYPE_CHANGE_PRICE_APPLY = "1107"; // 动产融资质物价格调整申请
	public static final String APPLI_TYPE_LOWERPRICEAPPLI = "1108"; // 动产融资押品监管下限调整申请
	public static final String APPLI_TYPE_MULTIPRICEADJUSTAPPLY = "1109";// 动产融资批量质物价格调整申请
	public static final String APPLI_TYPE_STOCKLISTIMPORTAPPLY = "1110";// 动产动态库存清单导入申请
	public static final String APPLI_TYPE_MORTGAGE_CASH_LOAN_APPLY = "1111"; // 动产-放款申请-流贷
	public static final String APPLI_TYPE_MORTGAGE_BILL_LOAN_APPLY = "1112"; // 动产-放款申请-银承
	public static final String APPLI_TYPE_MORTGAGE_LETTER_GUARANTEE_APPLY = "1113";// 动产-放款申请-融资性保函
	public static final String APPLI_TYPE_MORTGAGE_LETTER_GUARANTEE_NO_APPLY = "1114";// 动产-放款申请-非融资性保函
	public static final String APPLI_TYPE_MORTGAGE_GUARANTEE_DISCOUNT_APPLY = "1115";// 动产-放款申请-保贴函
	public static final String APPLI_TYPE_MORTGAGE_CREDIT_APPLY = "1116";// 动产-放款申请-信用证

	/**
	 * 现货静态
	 */
	public static final String PROCNAME_ADJUSTPRICEAPPLY = "AdjustPriceApply";// 现货静态押品价格调整申请

	/** 汽车货押 **/
	public static final String APPLI_TYPE_CAR_STATIC_QUALITY_APPLY = "1301"; // 出质入库申请
	public static final String APPLI_TYPE_CAREXCHANGEAPPLI = "1302"; // 换货申请
	public static final String APPLI_TYPE_CARDELIVERYAPPLI = "1303"; // 提货申请
	public static final String APPLI_TYPE_CAR_CHANGE_PRICE_APPLY = "1304"; // 调价申请
	public static final String APPLI_TYPE_CAR_MORTGAGE_CASH_LOAN_APPLY = "1305"; // 放款申请-流贷
	public static final String APPLI_TYPE_CAR_MORTGAGE_BILL_LOAN_APPLY = "1306"; // 放款申请-银承
	public static final String APPLI_TYPE_CAR_MORTGAGE_LETTER_GUARANTEE_APPLY = "1307";// 汽车-放款申请-融资性保函
	public static final String APPLI_TYPE_CAR_MORTGAGE_LETTER_GUARANTEE_NO_APPLY = "1308";// 汽车-放款申请-非融资性保函
	public static final String APPLI_TYPE_CAR_MORTGAGE_GUARANTEE_DISCOUNT_APPLY = "1309";// 汽车-放款申请-保贴函
	public static final String APPLI_TYPE_CAR_MORTGAGE_CREDIT_APPLY = "1310";// 汽车-放款申请-信用证

	/** 仓单 */
	public static final String APPLI_TYPE_BILL_NORMAL_MULTIPRICEADJUSTAPPLY = "1209";// 非标准仓单批量质物价格调整申请
	public static final String APPLI_TYPE_STANDARD_BILL_UNPLEDGEAPPLI = "1212";// 标准仓单解押申请
	public static final String APPLI_TYPE_BILL_NORMAL_UNPLEDGEAPPLI = "1213";// 非标准仓单解押申请
	public static final String APPLI_TYPE_BILL_STANDARD_EXCHANGE = "1214"; // 标准仓单置换申请
	public static final String APPLI_TYPE_BILL_NORMAL_EXCHANGE = "1215"; // 非标准仓单置换申请
	public static final String APPLI_TYPE_BILL_NORMAL_QUALITYAPPLI = "1216";// 非标准仓单质押申请
	public static final String APPLI_TYPE_BILL_STANDARD_QUALITYAPPLI = "1217";// 标准仓单质押申请
	public static final String APPLI_TYPE_BILL_NORMAL_CASH_LOAN_APPLY = "1218";// 非标准仓单流贷融资申请
	public static final String APPLI_TYPE_BILL_NORMAL_BILL_LOAN_APPLY = "1219";// 非标准仓单银承融资申请
	public static final String APPLI_TYPE_NORMAL_LETTER_GUARANTEE_APPLY = "1222";// 普通仓单-融资申请-融资性保函
	public static final String APPLI_TYPE_NORMAL_PHASE_LETTER_GUARANTEE_NO_APPLY = "1223";// 普通仓单-融资申请-非融资性保函
	public static final String APPLI_TYPE_NORMAL_PHASE_GUARANTEE_DISCOUNT_APPLY = "1224";// 普通仓单-融资申请-保贴函
	public static final String APPLI_TYPE_NORMAL_PHASE_CREDIT_APPLY = "1225";// 普通仓单-融资申请-信用证
	public static final String APPLI_TYPE_BILL_NORMAL_ADD_APPLI = "1220";// 非标准仓单追加申请
	public static final String APPLI_TYPE_BILL_NORMAL_DELIVERY_APPLY = "1221";// 普通仓单(单笔)提货申请
	public static final String APPLI_TYPE_CHANGE_PRICE_APPLY_BILL = "1117";// 普通仓单质物调价

	public static final String CUST_CD = "custCd"; // 客户号
	public static final String CUST_NAME = "custName"; // 客户名称
	/** 默认审批意见 */
	public static final String DEFOULT_ATTITUDE = "发起流程"; // 默认审批意见
	public static final String QUALITYAPPLY_APPLY = "出质入库申请";// 收款确认
	// 流程流转状态
	public final static String WORKFLOW_TRANS_AGREE = "Agree";
	public final static String WORKFLOW_TRANS_GOBACK = "GoBack";
	public final static String WORKFLOW_TRANS_REFUSE = "Refuse";
	public final static String WORKFLOW_TRANS_REJECT = "Reject";
	public final static String WORKFLOW_TRANS_CANCEL = "Cancel";
	public final static String WORKFLOW_TRANS_BACKTOLAST = "BackToLast";

	/** 出账申请 */
	public final static String WORKFLOW_BCRRDUEBILL_ADD = "duebilladd_task";
	public final static String WORKFLOW_BCRRDUEBILL_CONFIRM = "duebillConfirm";

	public final static String WORKFLOW_WRITEOFF_RECEIPT = "receipt";
	public final static String WORKFLOW_WRITEOFF_REQUESTTASK = "requestTask";
	/** 出质入库 */
	public static final String QUALITYAPPLY = "qualityApply"; // 提货申请

	/** 出质入库任务id */
	public static final String WRITE_TASK = "write_task"; // 出质入库申请
	public static final String CHECK_TASK = "check_task"; // 出质入库核价
	public static final String RECEIPT_TASK = "receipt_task"; // 出质入库确认
	public static final String APPROVE_TASK = "approve_task"; // 出质入库审核
	/** 回款专户转账 */
	public static final String POOLREPAY = "poolRePay"; // 提货申请
	/** 回款专户转账流程节点 */
	public static final String POOLREPAY_START = "Start";// 发起流程节点
	public static final String POOLREPAY_WRITE = "Write";// 申请节点
	public static final String POOLREPAY_CHECK = "Check";// 确认节点

	/** 现金等价物 */
	public static final String APPLI_TYPE_CASHEQUALREG_APPLY = "8101";// 现金等价物质押登记
	public static final String APPLI_TYPE_DISMORTGAGEBILL = "8102";// 现金等价物解压
	public static final String APPLI_TYPE_BAIL_TRANSFER_OUT_APPLY = "8103"; // 保证金转出申请
	public static final String APPLI_TYPE_BAILTRANSFERAPPLY = "8104"; // 保证金转入登记
	public static final String APPLI_TYPE_MAXBAIL_TRANSFER_OUT_APPLY = "8105"; // 最高额保证金转出申请
	public static final String APPLI_TYPE_CASHEQUALVALUE = "8106";// 现金等价物维护申请
	public static final String APPLI_TYPE_INDIRECT_CREDIT_DRAW_APPLY = "8007";// 间接额度领用申请
	public static final String APPLI_TYPE_INDIRECT_CREDIT_RECOVER_APPLY = "8008";// 间接额度回收申请
	public static final String APPLI_TYPE_INDIRECT_CREDIT_APPLY = "8009";// 间接额度新增提交申请
	public static final String APPLI_TYPE_INDIRECT_CREDIT_MODIFY_APPLY = "8010";// 间接额度修改提交申请
	public static final String APPLI_TYPE_MARGIN_APPLY = "8011";// 保证金追加冻结
	
	/** 基础类 */
	public static final String PROCNAME_CASH_EQUAL_VALUE = "CashEqualValue";// 现金等价物维护申请
	public static final String PROCNAME_CASHEQUALREG_APPLY="CashEqualValueRegApply";//现金等价物登记申请
	public static final String PROCNAME_INDIRECT_CREDIT_APPLY = "IndirectCreditApply";// 间接额度新增申请
	public static final String PROCNAME_INDIRECT_CREDIT_MODIFY_APPLY = "IndirectCreditModifyApply";// 间接额度修改申请
	public static final String PROCNAME_INDIRECT_CREDIT_DRAW_APPLY = "IndirectCreditDrawApply";// 间接额度领用申请
	public static final String PROCNAME_INDIRECT_CREDIT_RECOVER_APPLY = "IndirectCreditRecoverApply";// 间接额度回收申请

	/** 保证金及现金等价物(暂不使用) **/
	public static final String PROCNAME_BAIL_TRANSFER_OUT_APPLY = "BailTransferOutApply"; // 保证金转出
	public static final String PROCNAME_MAXBAIL_TRANSFER_OUT_APPLY = "MaxBailTransferOutApply"; // 最高额保证金转出
	public static final String PROCNAME_DIS_MORTGAGE_BILL = "DisMortgageBill";// 现金等价物解押
	public static final String PROCNAME_MARGIN_APPLY ="MarginApply";//保证金追加冻结
	
	public static final String APPLI_STATUS_DTL_UNSUBMIT = "000"; // 未提交（默认）
	
	/** 现货类-仓单(暂不使用) **/
	public static final String PROCNAME_STANDARD_BILL_UNPLEDGE_APPLY = "BillStandardUnpledgeApply";// 标准仓单解押
	public static final String PROCNAME_NORMAL_BILL_UNPLEDGE_APPLY = "BillNormalUnpledgeApply";// 普通非标准仓单解押申请
	public static final String PROCNAME_STANDARD_BILL_EXCHANGE_APPLY = "BillStandardReplaceApply";// 标准仓单置换申请
	public static final String PROCNAME_NORMAL_BILL_EXCHANGE_APPLY = "BillNormalReplaceApply";// 普通非标准仓单置换申请
	public static final String PROCNAME_NORMAL_BILL_QUALITY_APPLY = "BillNormalQualityApply";// 普通非标准仓单质押申请
	public static final String PROCNAME_STANDARD_BILL_QUALITY_APPLY = "BillStandardQualityApply";// 标准仓单质押申请
	public static final String PROCNAME_NORMAL_CASH_LOAN_APPLY = "BillNormalCashLoanApply";// 普通仓单流贷融资申请
	public static final String PROCNAME_NORMAL_BILL_LOAN_APPLY = "BillNormalBillLoanApply";// 普通仓单银承融资申请
	public static final String PROCNAME_NORMAL_LETTER_GUARANTEE_APPLY = "BillNormalLetterGuaranteeApply";// 普通仓单-融资申请-融资性保函
	public static final String PROCNAME_NORMAL_PHASE_LETTER_GUARANTEE_NO_APPLY = "BillNormalLetterGuaranteeNoApply";// 普通仓单-融资申请-非融资性保函
	public static final String PROCNAME_NORMAL_PHASE_GUARANTEE_DISCOUNT_APPLY = "BillNormalGuaranteeDiscountApply";// 普通仓单-融资申请-保贴函
	public static final String PROCNAME_NORMAL_PHASE_CREDIT_APPLY = "BillNormalCreditApply";// 普通仓单-融资申请-信用证
	public static final String PROCNAME_NORMAL_BILL_DELIVERY_APPLY= "BillNormalDeliveryApply";//普通仓单（单笔）提货申请
	public static final String PROCNAME_NORMAL_BILL_ADD_APPLY = "BillNormalAddApply";// 普通非标准仓单追加申请
	public static final String PROCNAME_NORMAL_BILL_MULTIPRICEADJUSTAPPLY = "BillNormalMultiPriceAdjustApply"; // 普通仓单批量质物价格调整申请
	public static final String PROCNAME_PRICEADJUSTAPPLYBILL = "AdjustPriceApplicationBill"; // 普通仓单质物价格调整申请
	public static final String PROCNAME_PRICEADJUSTAPPLYXPHH = "AdjustPriceApplyXphh"; // 先票后货质物价格调整申请
	public static final String PROCNAME_PRICEADJUSTAPPLYXHDT = "AdjustPriceApplyXhdt"; // 现货动态质物价格调整申请



	/** 汽车先票/款后货 申请类型 */
	public static final String APPLI_TYPE_CAR_FOUR_LOAN_APPLY = "2219"; // 出账申请--贷款loanWays=="01"(四方保兑仓)
	public static final String APPLI_TYPE_CAR_FOUR_BILL_APPLY = "2220"; // 出账申请--银承汇票loanWays=="02"(四方保兑仓)
	public static final String APPLI_TYPE_CAR_FOUR_LETTER_GUARANTEE_APPLY = "2227";// 汽车-出账申请-融资性保函
	public static final String APPLI_TYPE_CAR_FOUR_LETTER_GUARANTEE_NO_APPLY = "2228";// 汽车-出账申请-非融资性保函
	public static final String APPLI_TYPE_CAR_FOUR_GUARANTEE_DISCOUNT_APPLY = "2229";// 汽车-出账申请-保贴函
	public static final String APPLI_TYPE_CAR_FOUR_CREDIT_APPLY = "2230";// 汽车-出账申请-信用证
	public static final String APPLI_TYPE_CAR_FOURHOUSEPLEDGEAPPLY = "2216"; // 汽车到货出质入库
	public static final String APPLI_TYPE_CAR_FOUR_CHANGE_PRICE_APPLY = "2207"; // 动产融资质物价格调整申请
	public static final String APPLI_TYPE_CAR_FOURHOUSEDELIVERYAPPLY = "2222"; // 汽车提货申请
	public static final String APPLI_TYPE_CAR_FOURACCOUNTCONFIRMAPPLY = "2223"; // 汽车收款确认
	public static final String APPLI_TYPE_CAR_FOURGUARANTEEBUYBACKAPPLY = "2224"; // 汽车 差额退款
	public static final String APPLI_TYPE_CAR_FOURHOUSEUPDELIVERYAPPLY = "2226";// 汽车核心厂商提货
	public static final String APPLI_TYPE_CAR_SENDOUTGOODSAPP = "2204"; // 汽车先票后货 发货出质申请
	public static final String APPLI_TYPE_CARWORTHCOMPENSATEAPPLY = "2128"; // 汽车先票后货跌价补偿

	/** 订单融资 */
	public static final String APPLI_TYPE_ORDER_PHASE_LOAN_APPLY = "2401"; // 订单融资-订单阶段流贷放款申请
	public static final String APPLI_TYPE_ORDER_PHASE_BILLS_LOAN_APPLY = "2451"; // 订单融资-订单阶段银承放款申请
	public static final String APPLI_TYPE_ORDER_PHASE_LETTER_GUARANTEE_APPLY = "2452";// 订单融资-出账申请-融资性保函
	public static final String APPLI_TYPE_ORDER_PHASE_LETTER_GUARANTEE_NO_APPLY = "2454";// 订单融资-出账申请-非融资性保函
	public static final String APPLI_TYPE_ORDER_PHASE_GUARANTEE_DISCOUNT_APPLY = "2455";// 订单融资-出账申请-保贴函
	public static final String APPLI_TYPE_ORDER_PHASE_CREDIT_APPLY = "2456";// 订单融资-出账申请-信用证
	public static final String APPLI_TYPE_ORDER_DELD_BILLS_TRANS = "2402"; // 订单融资-交货后阶段应收账款转让申请
	public static final String APPLI_TYPE_DELD_PHASE_LOAN_APPLY = "2403"; // 订单融资-交货后阶段流贷放款申请
	public static final String APPLI_TYPE_DELD_PHASE_BILLS_LOAN_APPLY = "2453"; // 订单融资-交货后阶段银承放款申请
	public static final String APPLI_TYPE_DELD_PHASE_LETTER_GUARANTEE_APPLY = "2457";// 订单融资交货后阶段-出账申请-融资性保函
	public static final String APPLI_TYPE_DELD_PHASE_LETTER_GUARANTEE_NO_APPLY = "2458";// 订单融资交货后阶段-出账申请-非融资性保函
	public static final String APPLI_TYPE_DELD_PHASE_GUARANTEE_DISCOUNT_APPLY = "2459";// 订单融资交货后阶段-出账申请-保贴函
	public static final String APPLI_TYPE_DELD_PHASE_CREDIT_APPLY = "2460";// 订单融资交货后阶段-出账申请-信用证
	public static final String APPLI_TYPE_ORDER_DEBT_URGE = "2404"; // 订单融资-交货后阶段应收账款催收申请
	public static final String APPLI_TYPE_ORDER_DELD_BILLS_DEVAL = "2405"; // 订单融资-交货后阶段应收账款减值申请
	public static final String APPLI_TYPE_ORDER_DEBT_REVERSE = "2406"; // 订单融资-交货后阶段应收账款反转让申请
	public static final String APPLI_TYPE_ORDER_REPAYMENT = "2407"; // 订单融资-交货后阶段订单回款申请

	public static final String APPLI_TYPE_FACTORING_CONT_APPLI = "3293";// 应收类（配置版）业务申请
	public static final String PROCNAME_FACTORING_CONT_APPLY = "FactoringContApply";// 应收类（配置版）业务申请
}

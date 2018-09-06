/**
 * 
 */
package com.huateng.scf.bas.icr.constant;

/**
 * <p>XXX</p>
 *
 * @author 	shangxiujuan
 * @date 	2016年11月5日.下午4:04:47
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月5日.下午4:04:47	     新增
 *
 * </pre>
 */

public class BIcrConstant {
	

	//public static final String CREDIT_TYPE_NO = "CREDIT_TYPE_NO";//额度类型编号
	
	// [额度节点类型] 1-根节点（1级） 2-子节点（2级） 3-子子节点（3级）1,总额度;2,分项额度;3,领用额度
	public static final String CREDIT_NODE_TYPE_ROOT = "1";
	public static final String CREDIT_NODE_TYPE_LEAF = "2";
	public static final String CREDIT_NODE_TYPE_SUB_LEAF = "3";
	// [交易操作类型]
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
	// [额控制度类型] 0：非循环；1：循环
	public static final String CREDIT_CLASS_NOCYCLE = "0";// 0-非循环
	public static final String CREDIT_CLASS_CYCLE = "1";// 1-循环
	// [额度类型] 1：直接授信额度；2：第三方授信额度；3：间接额度
	public static final String CREDIT_CLASS_DIRECT = "1";// 1-直接授信额度
	public static final String CREDIT_CLASS_THIRD = "2";// 2-第三方授信额度
	public static final String CREDIT_CLASS_INDIRECT="3";//3-间接额度
	public static final String CREDIT_CLASS_LIMIT_BUYER="4";//4-买方信用限额
	// [额度状态] 1：正常、有效；2：终止、无效、未提交；
	public static final String CREDIT_STATUS_NORMAL = "1";
	public static final String CREDIT_STATUS_TERMINATE = "2";
	// [额度业务关联类型]
	public static final String CREDIT_RELA_TYPE_CONT = "1";// 合同
	public static final String CREDIT_RELA_TYPE_LNCI = "2";// 借据
	public static final String CREDIT_RELA_TYPE_CUST = "3";// 客户
	
	// [额度操作类型定义]
	public static final String CREDIT_OPR_TYPE_OCCUPY = "1";// 占用
	public static final String CREDIT_OPR_TYPE_RELEASE = "2";// 占用恢复（释放）
	public static final String CREDIT_OPR_TYPE_FREEZE = "3";// 冻结
		
	/**额度阶段 begin**/
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
	public static final String CREDIT_PHASE_FACTORING_CHARGEOFF= "17";// 保理应收账款核销
	// [额度阶段] 信保保理
	public static final String CREDIT_PHASE_FACTORING_INSURANCE_FINANCING = "18";// 信保融资出账
	public static final String CREDIT_PHASE_FACTORING_INSURANCE_PAYMENT = "19";// 信保应收账款回款
	public static final String CREDIT_PHASE_FACTORING_COMPANY_INSURANCE_PAYMENT = "20";// 信保保险公司赔款
	public static final String CREDIT_PHASE_FACTORING_INSURANCE_PURCHASE = "21";// 信保应收账款转让
	public static final String CREDIT_PHASE_FACTORING_INSURANCE_ALLOWANCE = "22";// 信保应收账款减值
	public static final String CREDIT_PHASE_FACTORING_INSURANCE_BACK_PURCHASE = "23";// 信保应收账款反转让
	public static final String CREDIT_PHASE_FACTORING_INSURANCE_CHARGEOFF= "24";// 信保应收账款核销
	// [额度阶段] 租赁保理
	public static final String CREDIT_PHASE_LEASE_FACTORING_FINANCING= "25";// 租赁保理融资出账
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
	public static final String CREDIT_PHASE_CASH_PLEDGE_STATICSTATE_DELIVERY  = "33";// 现货静态抵/质押提货

	// [额度阶段] 标准仓单
	public static final String CREDIT_PHASE_STANDARD_WAREHOUSE_RECEIPT_FINANCING = "34";// 标准仓单出账

	// [额度阶段] 汽车货押
	public static final String CREDIT_PHASE_CAR_PLEDGE_FINANCING = "35";// 汽车货押出账
	public static final String CREDIT_PHASE_CAR_PLEDGE_DELIVERY  = "36";// 汽车货押提货

	//[额度阶段] 非标准仓单
	public static final String CREDIT_PHASE_BILLNORMAL_DELIVERY ="37";//非标仓单提货

	// [额度阶段] 现金等价物
	public static final String CREDIT_PHASE_MARGIN = "38";// 保证金追加冻结

	// [额度阶段] 汽车金融
//	public static final String CREDIT_PHASE_AUTO_ORDER_APPLY = "18";// 保兑仓订单融资申请
//	public static final String CREDIT_PHASE_AUTO_BACKLOAN = "19";// 汽车金融经销商还款
//	public static final String CREDIT_PHASE_AUTO_ORDER_BUYBACKAPPLI = "20";// 汽车金融订单融资申请
	// [额度阶段] 动产
//	public static final String CREDIT_PHASE_CHATTEL_QUALITY = "00";// 动产出质
//	public static final String CREDIT_PHASE_CHATTEL_LOAN = "21";// 动产放款
	/**额度阶段 end**/
	/**
	 * 间接额度类型 有、无 【来自信贷接口】
	 */
	public static final String HAS_INDIRECT_CREDIT_TRUE = "1";//有
	public static final String HAS_INDIRECT_CREDIT_FALSE= "0";//无
}

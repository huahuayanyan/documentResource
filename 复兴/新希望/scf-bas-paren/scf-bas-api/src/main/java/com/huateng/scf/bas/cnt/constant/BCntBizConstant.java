/**
 * 
 */
package com.huateng.scf.bas.cnt.constant;

/**
 * <p>担保提货业务常量类</p>
 *
 * @author 	huangshuidan
 * @date 2016年11月24日下午4:25:06	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月24日下午4:25:06              新增
 *
 * </pre>
 */
public class BCntBizConstant {
	/** 保理业务类别标识 **/
	public static final String T_FINANCING_TYPE_INVOICE = "1";// 应收账款融资
	public static final String T_FINANCING_TYPE_POOL = "2";// 应收账款池融资
	public static final String T_FINANCING_TYPE_CREDIT = "4";// 信保保理
	public static final String T_FINANCING_TYPE_DOUBLE = "3";// 行内双保理
	public static final String T_FINANCING_TYPE_LEASE = "5";// 租赁保理
	public static final String T_FINANCING_TYPE_EF = "10";// 出口保理
	public static final String T_FINANCING_TYPE_IF = "11";// 进口保理
	/** 保理业务类型  FACT_TYPE 相对应**/
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
	public static final String FACT_TYPE_EF = "10"; // 出口保理
	public static final String FACT_TYPE_IF = "11"; // 进口保理
	
	/*** 融资模式 */
	public static final String FINANCING_TYPE_INVOICE = "1";// 发票融资
	public static final String FINANCING_TYPE_POOL = "2";// 池融资
	
	/*** 主合同状态 */
	public static final String MAST_CONT_STATUS_INVALID = "00";// 失效
	public static final String MAST_CONT_STATUS_VALID = "01";// 正常
	public static final String MAST_CONT_STATUS_FROZEN = "02";// 冻结
	public static final String MAST_CONT_STATUS_ADD_APPROVAL = "03";// 建立审批中
	public static final String MAST_CONT_STATUS_FROZE_APPROVAL = "04";// 冻结审批中
	public static final String MAST_CONT_STATUS_OTHERS = "05";// 其它
	
	/** 合同费用收取方式 */
	public static final String CONT_CHARGE_TYPE_YEAR = "01";// 按年收费
	public static final String CONT_CHARGE_TYPE_NUM = "02";// 单笔收取
	
	/**费用管理类型*/
	public static final String COST_INFO_RELA_TYPE_PROT = "1";//1协议
	public static final String COST_INFO_RELA_TYPE_CONT = "2";// 费用管理类型2合同
	/**
	 *有无追索权
	 */
	/** 状态--有追索 */
	public static final String RECOVER_TYPE_WITH_RECOURSE = "1";// 有追索
	/** 状态--无追索 */
	public static final String RECOVER_TYPE_WITHOUT_RECOURSE = "2";// 无追索
	
	//收取方式
	public static final String COST_TYPE_FIRST="1";//先收
	public static final String COST_TYPE_LAST="2";//后收
	public static final String COST_TYPE_FREE="3";//免收
	
	//扣取方式
	public static final String CHARGE_TYPE_OUT="1";//外扣
	public static final String CHARGE_TYPE_IN="2";//内收
	//计算方式
	public static final String COST_CALC_TYPE_FIX="1";//固定
	public static final String COST_CALC_TYPE_RATE="2";//按比率
	//费用收取种类  
	public static final String COST_CLASS_WHOLE="1";//整体
	public static final String COST_CLASS_SINGLE="2";//单张
}

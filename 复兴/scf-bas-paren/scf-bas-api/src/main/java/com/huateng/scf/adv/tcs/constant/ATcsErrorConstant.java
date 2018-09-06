/**
 * 
 */
package com.huateng.scf.adv.tcs.constant;

/**
 * <p>预付类担保提货模块异常常量类</p>
 *
 * @author 	shangxiujuan
 * @date 2016年12月12日下午8:02:03	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * shangxiujuan		   2016年12月12日下午8:02:03              新增
 *
 * </pre>
 */
public class ATcsErrorConstant {
	
	public static final String SCF_ADV_TCS_10002 = "scf.adv.tcs.10002";// 申请基本信息丢失！
	public static final String SCF_ADV_TCS_10003 = "scf.adv.tcs.10003";//合同信息丢失!
	public static final String SCF_ADV_TCS_10004 = "scf.adv.tcs.10004";//申请编号丢失!
	
	/*收款确认*/
	public static final String SCF_ADV_TCS_20000 = "scf.adv.tcs.20000";// 该借据正在被其他流程处理！
	
	/*差额退款*/
	public static final String SCF_ADV_TCS_30000 = "scf.adv.tcs.30000";//  一致性检查未通过！协议号下存在尚未审批的退款申请流程
	public static final String SCF_ADV_TCS_30001 = "scf.adv.tcs.30001";//  担保提货协议信息丢失
	public static final String SCF_ADV_TCS_30002 = "scf.adv.tcs.30002";//  业务申请流水信息丢失!
	
	/*提货申请*/
	public static final String SCF_ADV_TCS_40000 = "scf.adv.tcs.40000";//获取放款购销合同失败！
	public static final String SCF_ADV_TCS_40001 = "scf.adv.tcs.40001";// 购销合同号的提货总金额大于当前放款购销合同下的可提货金额
	public static final String SCF_ADV_TCS_40002 = "scf.adv.tcs.40002";// 本次申请提货金额不能大于本次可提货金额！
	public static final String SCF_ADV_TCS_40003 = "scf.adv.tcs.40003";//货物编号丢失！
	public static final String SCF_ADV_TCS_40004 = "scf.adv.tcs.40004";//货物编号:"+mortgageNo+"规格型号不能为空！
	public static final String SCF_ADV_TCS_40005 = "scf.adv.tcs.40005";//"货物编号:"+mortgageNo+"提货金额必须大于0！
	public static final String SCF_ADV_TCS_40006 = "scf.adv.tcs.40006";//提货列表不能为空！
	public static final String SCF_ADV_TCS_40007 = "scf.adv.tcs.40007";//票/款确认书信息丢失！   通知书信息丢失，无法同步到FS系统！
	public static final String SCF_ADV_TCS_40008 = "scf.adv.tcs.40008";//银票/借据信息丢失！    借据信息丢失，无法同步到FS系统！
	public static final String SCF_ADV_TCS_40009 = "scf.adv.tcs.40009";//追加冻结金额总金额必须等于本次追加保证金总额！
	public static final String SCF_ADV_TCS_40010 = "scf.adv.tcs.40010";//保证金追加列表记录不能为空！
	public static final String SCF_ADV_TCS_40011 = "scf.adv.tcs.40011";//购销合同对应的借据的申请信息丢失！
	public static final String SCF_ADV_TCS_40012 = "scf.adv.tcs.40012";//获取首笔保证金提货模式失败!
}

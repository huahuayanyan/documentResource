/**
 * 
 */
package com.huateng.scf.bas.cnt.constant;

/**
 * <p>
 * 担保提货模块异常常量类
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月24日下午3:45:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月24日下午3:45:26              新增
 *
 *            </pre>
 */
public class BCntErrorConstant {

	/** 保理合同基本信息 */
	public static final String SCF_BAS_CNT_10000 = "scf.bas.cnt.10000";// 保理合同基本信息转换异常！
	public static final String SCF_BAS_CNT_10001 = "scf.bas.cnt.10001";// 保理合同基本信息插入异常！
	public static final String SCF_BAS_CNT_10002 = "scf.bas.cnt.10002";// 保理合同基本信息更新异常！
	public static final String SCF_BAS_CNT_10003 = "scf.bas.cnt.10003";// 保理合同基本信息删除异常！

	public static final String SCF_BAS_CNT_20000 = "scf.bas.cnt.20000";// 买卖双方不能为一个客户！
	public static final String SCF_BAS_CNT_20001 = "scf.bas.cnt.20001";// 买方和担保方不能为一个客户！
	public static final String SCF_BAS_CNT_20002 = "scf.bas.cnt.20002";// 参数对象不能为空！
	public static final String SCF_BAS_CNT_20003 = "scf.bas.cnt.20003";// 保存多方协议，日期转换错误！
	public static final String SCF_BAS_CNT_20004 = "scf.bas.cnt.20004";// 协议号丢失！
	public static final String SCF_BAS_CNT_20005 = "scf.bas.cnt.20005";// 协议编号为[{0}]的多方协议不存在
																		// ，不能删除！
	public static final String SCF_BAS_CNT_20006 = "scf.bas.cnt.20006";// 已有信贷合同关联该担保提货协议，不允许进行删除操作！
	public static final String SCF_BAS_CNT_20007 = "scf.bas.cnt.20007";// 协议项下有出账业务，不能修改！
	public static final String SCF_BAS_CNT_20008 = "scf.bas.cnt.20008";// 已有购销合同关联该担保提货协议，不允许进行删除操作！
	/** 应收 */
	public static final String SCF_BAS_CNT_30000 = "scf.bas.cnt.30000";// 合同编号丢失！
	public static final String SCF_BAS_CNT_30001 = "scf.bas.cnt.30001";// 分页条件查询应收账款融资交易对手信息失败！
	public static final String SCF_BAS_CNT_30002 = "scf.bas.cnt.30002";// 保理合同信息丢失!
	public static final String SCF_BAS_CNT_30003 = "scf.bas.cnt.30003";// 合同下存在未结清借据!
	public static final String SCF_BAS_CNT_30004 = "scf.bas.cnt.30004";// 合同下存在未核销的应收账款!

	/** 担保提货-购销合同 **/
	public static final String SCF_BAS_CNT_40000 = "scf.bas.cnt.40000";// 购销合同号已存在，不允许重复！
	public static final String SCF_BAS_CNT_40001 = "scf.bas.cnt.40001";// 已有累计出账金额或审批中出账金额的购销合同不允许删除！
	public static final String SCF_BAS_CNT_40002 = "scf.bas.cnt.40002";// 已有累计出账金额或审批中出账金额的购销合同不允许修改！
	public static final String SCF_BAS_CNT_40003 = "scf.bas.cnt.40003";// 已关联业务的购销合同不允许删除！
	public static final String SCF_BAS_CNT_40004 = "scf.bas.cnt.40004";// 已关联业务的购销合同不允许修改！
	/** 先票/款后货协议 **/
	public static final String SCF_BAS_CNT_40005 = "scf.bas.cnt.40005";// 先票/款后货协议新增失败！
	public static final String SCF_BAS_CNT_40006 = "scf.bas.cnt.40006";// 先票/款后货协议修改失败！

}

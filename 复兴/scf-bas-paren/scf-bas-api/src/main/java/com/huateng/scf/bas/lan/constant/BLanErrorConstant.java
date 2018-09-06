package com.huateng.scf.bas.lan.constant;

/**
 * <p>
 * 放款模块异常常量类
 * </p>
 *
 * @author liph
 * @date 2016年12月8日下午8:18:26
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * liph     		   2016年12月8日下午8:18:26              新增
 *
 *            </pre>
 */
public class BLanErrorConstant {
	// 放款异常处理
	public static final String SCF_BAS_LAN_20000 = "scf.bas.lan.20000";// 数据库代码操作异常
	public static final String SCF_BAS_LAN_20001 = "scf.bas.lan.20001";// 出账方式与主合同出账方式不对应！
	public static final String SCF_BAS_LAN_20002 = "scf.bas.lan.20002";// 参数对象不能为空！
	public static final String SCF_BAS_LAN_20003 = "scf.bas.lan.20003";// 出账方式不正确！
	public static final String SCF_BAS_LAN_20004 = "scf.bas.lan.20004";// 借据处于放款状态，不能再次放款申请！
	public static final String SCF_BAS_LAN_20005 = "scf.bas.lan.20005";// 申请信息不存在
	public static final String SCF_BAS_LAN_20006 = "scf.bas.lan.20006";// 供应链未提交审批
	public static final String SCF_BAS_LAN_20007 = "scf.bas.lan.20007";// 保理买方间接额度可用余额不足！
	public static final String SCF_BAS_LAN_20008 = "scf.bas.lan.20008";// (信贷合同项下所有放款的借据金额
																		// +
																		// 本次放款金额)必须小于等于信贷合同金额
	public static final String SCF_BAS_LAN_20009 = "scf.bas.lan.20009";// 信贷合同可用敞口不足！
	public static final String SCF_BAS_LAN_20010 = "scf.bas.lan.20010";// (信贷合同项下所有生效的借据敞口余额
																		// +
																		// 本次风险敞口)必须小于等于信贷合同总敞口
	public static final String SCF_BAS_LAN_20011 = "scf.bas.lan.20011";// 应收账款可融资金额不足！
	public static final String SCF_BAS_LAN_20012 = "scf.bas.lan.20012";// 该笔抵/质押合同的抵质押率不能小于等于0！
	public static final String SCF_BAS_LAN_20013 = "scf.bas.lan.20013";// 当前最低控货价值不足以覆盖本笔风险敞口
	public static final String SCF_BAS_LAN_20014 = "scf.bas.lan.20014";// 当前押品价值不足以覆盖本笔风险敞口
	public static final String SCF_BAS_LAN_20015 = "scf.bas.lan.20015";// 担保方间接额度可用余额不足、
	public static final String SCF_BAS_LAN_20016 = "scf.bas.lan.20016";// 金额校验异常
	public static final String SCF_BAS_LAN_20017 = "scf.bas.lan.20017";// 累计合同金额，不能超过购销合同总额
	public static final String SCF_BAS_LAN_20018 = "scf.bas.lan.20018";// 信贷合同不能为空！
	public static final String SCF_BAS_LAN_20019 = "scf.bas.lan.20019";// 更新业务申请明细表异常！
	public static final String SCF_BAS_LAN_20020 = "scf.bas.lan.20020";// 申请号丢失！
	public static final String SCF_BAS_LAN_20021 = "scf.bas.lan.20021";// 产品编号丢失！
	public static final String SCF_BAS_LAN_20022 = "scf.bas.lan.20022";// 借据编号丢失！
	public static final String SCF_BAS_LAN_20023 = "scf.bas.lan.20023";// 产品与额度类型关联信息丢失！
	public static final String SCF_BAS_LAN_20024 = "scf.bas.lan.20024";// 业务品种获取大类不能为空！
	public static final String SCF_BAS_LAN_20025 = "scf.bas.lan.20025";// 出账流水号不能为空！
	public static final String SCF_BAS_LAN_20026 = "scf.bas.lan.20026";// 信贷合同编号不能为空！
	public static final String SCF_BAS_LAN_20028 = "scf.bas.lan.20028";// 协议号不能为空！
	public static final String SCF_BAS_LAN_20029 = "scf.bas.lan.20029";// 间接额度扣减信息不存在！
	public static final String SCF_BAS_LAN_20030 = "scf.bas.lan.20030";// 客户信息不存在
	public static final String SCF_BAS_LAN_20031 = "scf.bas.lan.20031";// 出账申请流程发起异常！
	public static final String SCF_BAS_LAN_20032 = "scf.bas.lan.20032";// 担保合同不能为空！
	public static final String SCF_BAS_LAN_20033 = "scf.bas.lan.20033";// 应收账款池可融资金额不足！
	/* 表信息操作异常begin */
	public static final String SCF_BAS_LAN_10001 = "scf.bas.lan.10001";// 借据申请信息插入异常！
	public static final String SCF_BAS_LAN_10002 = "scf.bas.lan.10002";// 借据申请信息更新异常！
	public static final String SCF_BAS_LAN_10003 = "scf.bas.lan.10003";// 借据申请信息删除异常！

	public static final String SCF_BAS_LAN_10004 = "scf.bas.lan.10004";// 借据基本信息转换异常！
	public static final String SCF_BAS_LAN_10005 = "scf.bas.lan.10005";// 借据基本信息插入异常！
	public static final String SCF_BAS_LAN_10006 = "scf.bas.lan.10006";// 借据基本信息更新异常！
	public static final String SCF_BAS_LAN_10007 = "scf.bas.lan.10007";// 借据基本信息删除异常！

	public static final String SCF_BAS_LAN_10008 = "scf.bas.lan.10008";// 购销合同流水表转换异常！
	public static final String SCF_BAS_LAN_10009 = "scf.bas.lan.10009";// 购销合同流水表更新异常！
	public static final String SCF_BAS_LAN_10011 = "scf.bas.lan.10011";// 购销合同流水表插入异常！

	public static final String SCF_BAS_LAN_10010 = "scf.bas.lan.10010";// 票据信息保存异常！

	public static final String SCF_BAS_LAN_10012 = "scf.bas.lan.10012";// 放款申请购销合同信息转换异常！
	public static final String SCF_BAS_LAN_10013 = "scf.bas.lan.10013";// 放款申请购销合同信息插入异常！
	public static final String SCF_BAS_LAN_10014 = "scf.bas.lan.10014";// 放款申请购销合同信息更新异常！
	public static final String SCF_BAS_LAN_10015 = "scf.bas.lan.10015";// 放款申请购销合同信息删除异常！

	public static final String SCF_BAS_LAN_10016 = "scf.bas.lan.10016";// 锁定借据基本信息失败！
	public static final String SCF_BAS_LAN_10017 = "scf.bas.lan.10017";// 解锁借据基本信息失败！

	/* 表信息操作异常end */
	/** 应收 */
	public static final String SCF_BAS_LAN_30000 = "scf.bas.lan.30000";// 合同编号丢失！
}

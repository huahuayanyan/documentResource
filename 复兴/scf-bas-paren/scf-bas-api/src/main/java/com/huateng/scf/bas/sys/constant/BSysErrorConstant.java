/**
 * 
 */
package com.huateng.scf.bas.sys.constant;

/**
 * <p>
 * 系统管理模块异常常量类
 * </p>
 *
 * @author huangshuidan
 * @date 2016年11月5日下午4:25:43
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月5日下午4:25:43	                                 新增
 *
 *            </pre>
 */
public class BSysErrorConstant {
	/*
	 * 系统管理异常
	 */
	public static final String SCF_BAS_SYS_20000 = "scf.bas.sys.20000";// 序号代码不能为空或者序号代码未配置！
	public static final String SCF_BAS_SYS_20001 = "scf.bas.sys.20001";// 序号代码格式不正确！
	public static final String SCF_BAS_SYS_20002 = "scf.bas.sys.20002";// [{0}]业务流水号取值已经超过最大值！
	public static final String SCF_BAS_SYS_20003 = "scf.bas.sys.20003";// 空值！
	public static final String SCF_BAS_SYS_20004 = "scf.bas.sys.20004";// 控制器执行异常

	public static final String SCF_BAS_SYS_20005 = "scf.bas.sys.20005";// 前台所传数据无效！
	public static final String SCF_BAS_SYS_20006 = "scf.bas.sys.20006";// 拦截模型ID已存在！
	public static final String SCF_BAS_SYS_20007 = "scf.bas.sys.20007";// 数据新增失败！
	public static final String SCF_BAS_SYS_20008 = "scf.bas.sys.20008";// 数据修改失败！
	public static final String SCF_BAS_SYS_20009 = "scf.bas.sys.20009";// 数据删除失败！
	public static final String SCF_BAS_SYS_20010 = "scf.bas.sys.20010";// 数据查询失败！

	public static final String SCF_BAS_SYS_50000 = "scf.bas.sys.50000";// 转换异常！
	public static final String SCF_BAS_SYS_50001 = "scf.bas.sys.50001";// 插入异常！
	public static final String SCF_BAS_SYS_50003 = "scf.bas.sys.50003";// 删除异常！
	public static final String SCF_BAS_SYS_50004 = "scf.bas.sys.50004";// 参数为空！
	public static final String SCF_BAS_SYS_50005 = "scf.bas.sys.50005";// 更新异常！
	public static final String SCF_BAS_SYS_50006 = "scf.bas.sys.50006";// 服务器繁忙，请稍后再审批。
	public static final String SCF_BAS_SYS_50007 = "scf.bas.sys.50007";// 申请号丢失，基本节点跳转失败，请重新开始业务！
	public static final String SCF_BAS_SYS_50008 = "scf.bas.sys.50008";// 任务撤销失败！

	/**
	 * 额度管理
	 */
	public static final String SCF_BAS_ICR_40000 = "scf.bas.icr.40000";// 保存额度信息失败
	public static final String SCF_BAS_ICR_40001 = "scf.bas.icr.40001";// 可用额度不足
	public static final String SCF_BAS_ICR_40002 = "scf.bas.icr.40002";// 额度详情转换异常！
	public static final String SCF_BAS_ICR_40003 = "scf.bas.icr.40003";// 额度详情新增失败!

	public static final String RECORD_HAS_EXIST = "scf.bas.10002"; // 记录已存在
	public static final String ERROR_CODE_DATA_INPUT_ERR = "scf.bas.10004";// 数据输入错误!

	public static final String SCF_BAS_DCR_50000 = "scf.bas.dcr.50000";// 转换异常！
	public static final String SCF_BAS_DCR_50001 = "scf.bas.dcr.50001";// 插入异常！
	public static final String SCF_BAS_DCR_50003 = "scf.bas.dcr.50003";// 删除异常！
	public static final String SCF_BAS_DCR_50004 = "scf.bas.dcr.50004";
	public static final String SCF_BAS_DCR_50005 = "scf.bas.dcr.50005";

}

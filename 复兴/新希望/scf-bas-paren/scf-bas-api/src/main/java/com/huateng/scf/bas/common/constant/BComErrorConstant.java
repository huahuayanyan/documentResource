/**
 * 
 */
package com.huateng.scf.bas.common.constant;

/**
 * <p>
 * 供应链异常公共常量类
 * </p>
 *
 * @author huangshuidan
 * @date 2016年12月30日 下午8:44:54
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年12月30日下午8:44:54             新增
 *
 *            </pre>
 */
public class BComErrorConstant {
	public  static final String SCF_BAS_COM_10000= "scf.bas.com.10000";//工作流异常！
	
	public  static final String SCF_BAS_COM_20000= "scf.bas.com.20000";//[{0}]记录不存在！
	public  static final String SCF_BAS_COM_20001= "scf.bas.com.20001";//产品编号丢失！
	public  static final String SCF_BAS_COM_20002= "scf.bas.com.20002";//借据编号丢失！
	public  static final String SCF_BAS_COM_20003= "scf.bas.com.20003";//[{0}]借据不存在！

	/**
	 * 公共错误代码 GD3001~GD3500
	 */
	public static final String ERROR_CODE_QUERY_CONDITION_CANNOT_BEEN_NULL = "GD3001"; // 查询条件不能全空
	public static final String ERROR_CODE_RECORD_NOTFOUND = "GD3002"; // 没有找到符合条件的记录
	public static final String ERROR_CODE_NO_BRCODE = "GD3003"; // 该机构号不存在
	public static final String ERROR_CODE_CANNOT_SUBMIT = "GD3004"; // 不能提交
	public static final String ERROR_CODE_TIME_LIMIT = "GD3005"; // 次数超限
	/**
	 * 规则接口 
	 */
	public  static final String SCF_BAS_COM_20005= "scf.bas.com.20005";//查询规则项目信息错误！
	public  static final String SCF_BAS_COM_20006= "scf.bas.com.20006";//规则项目不存在！
	public  static final String SCF_BAS_COM_20007= "scf.bas.com.20007";//查询规则列表异常！
	public  static final String SCF_BAS_COM_20008= "scf.bas.com.20008";//规则执行出错！
	public  static final String SCF_BAS_COM_20009= "scf.bas.com.20009";//加载adapter对象出错！
	public  static final String SCF_BAS_COM_20010= "scf.bas.com.20010";//规则类型参数不能为空！
	public  static final String SCF_BAS_COM_20011= "scf.bas.com.20011";//没有找到adapter配置，请配置规则adapter！
}

/**
 * 
 */
package com.huateng.scf.bas.sys.constant;

import com.huateng.scf.bas.common.startup.ScfBaseData;

/**
 * <p>
 * XXX
 * </p>
 *
 * @author shangxiujuan
 * @date 2016年11月16日.下午3:00:01
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 *            <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * shangxiujuan		2016年11月16日.下午3:00:01	     新增
 *
 *            </pre>
 */

public class BSysConstant {
	public static final String WORKDATE = ScfBaseData.getScfGlobalInfoData().getTxnDate();
	public static final String SYSDATE = ScfBaseData.getScfGlobalInfoData().getSysDate();
	/**
	 * 有效标志/状态
	 */
	public static final String FLAG_INVALID = "0"; // 无效

	public static final String FLAG_VALID = "1"; // 有效
	/**
	 * 是否标志-否（两位字符）
	 */
	public static final String FLAG_NC_OFF = "00"; // 否
	/**
	 * 是否标志-是（两位字符）
	 */
	public static final String FLAG_NC_ON = "01"; // 是

	/**
	 * 是否标志-否
	 */
	public static final String FLAG_OFF = "0"; // 否

	/**
	 * 是否标志-是
	 */
	public static final String FLAG_ON = "1"; // 是

}

/**
 * 
 */
package com.huateng.scf.bas.common.startup;

import java.util.Properties;

/**
 * <p>平台基础环境变量</p>
 *
 * @author 	huangshuidan
 * @date 	2016年11月7日下午7:46:57
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			date			              Content
 * huangshuidan		2016年11月7日下午7:46:57	                                 新增
 *
 * </pre>
 */
public class ScfBaseEnv {
	private static ScfBaseEnv scfBaseEnv = null;

	private Properties systemProps = null;
	private Properties systemErrorProps = null;
	public static final String SYSTEM_PROPS = "proconfig.scf_bas_config";//系统配置文件
	public static final String SYSTEM_ERROR_PROPS = "proconfig.zh_cn.scf_bas_error";//系统异常或者提示信息配置文件
	public static final String SYSTEM_REC_PROPS = "proconfig.scf_rec_config";//系统配置文件
	public static final String SYSTEM_REC_ERROR_PROPS = "proconfig.zh_cn.scf_rec_error";//系统异常或者提示信息配置文件

	public static ScfBaseEnv getInstance() {
		if (scfBaseEnv == null) {
			scfBaseEnv = new ScfBaseEnv();
		}
		return scfBaseEnv;
	}

	public Properties getSystemProps() {
		return this.systemProps;
	}

	public void setSystemProps(Properties systemProps) {
		this.systemProps = systemProps;
	}

	/**
	 * @return the systemErrorProps
	 */
	public Properties getSystemErrorProps() {
		return systemErrorProps;
	}

	/**
	 * @param systemErrorProps the systemErrorProps to set
	 */
	public void setSystemErrorProps(Properties systemErrorProps) {
		this.systemErrorProps = systemErrorProps;
	}
	
	
	
}

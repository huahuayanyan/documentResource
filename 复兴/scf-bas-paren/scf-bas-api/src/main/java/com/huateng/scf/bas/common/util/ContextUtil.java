/**
 * 
 */
package com.huateng.scf.bas.common.util;

import org.springframework.context.ApplicationContext;

/**
 * <p>上下文工具类</p>
 *
 * @author 	huangshuidan
 * @date 2016年11月29日上午9:44:52	
 * @version 1.0
 * @Copyright Shanghai Huateng Software Systems Co., Ltd.
 *
 * <pre>
 * =================Modify Record=======================
 * Modifier			   date			              Content
 * huangshuidan		   2016年11月29日上午9:44:52              新增
 *
 * </pre>
 */
public class ContextUtil {
	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		ContextUtil.applicationContext = applicationContext;
	}

	public static Object getBean(String beanId) {
		return applicationContext.getBean(beanId);
	}
}
